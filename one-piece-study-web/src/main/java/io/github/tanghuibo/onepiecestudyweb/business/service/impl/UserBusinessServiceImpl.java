package io.github.tanghuibo.onepiecestudyweb.business.service.impl;

import io.github.tanghuibo.onepiecestudyweb.business.service.UserBusinessService;
import io.github.tanghuibo.onepiecestudyweb.entity.UserInfo;
import io.github.tanghuibo.onepiecestudyweb.exception.MyException;
import io.github.tanghuibo.onepiecestudyweb.request.UserInfoAddRequest;
import io.github.tanghuibo.onepiecestudyweb.request.UserInfoUpdateRequest;
import io.github.tanghuibo.onepiecestudyweb.service.IUserInfoService;
import io.github.tanghuibo.onepiecestudyweb.service.IUserRefGroupService;
import io.github.tanghuibo.onepiecestudyweb.util.DateUtils;
import io.github.tanghuibo.onepiecestudyweb.vo.UserInfoVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author tanghuibo
 * @date 2020/12/7下午11:57
 */
@Service
public class UserBusinessServiceImpl implements UserBusinessService {

    @Resource
    IUserInfoService userInfoService;

    @Resource
    IUserRefGroupService userRefGroupService;

    @Override
    public List<UserInfoVo> getAll() {
        List<UserInfo> userInfoList = userInfoService.list();
        if(userInfoList.size() == 0) {
            return Collections.emptyList();
        }
        List<Long> userIdList = userInfoList.stream().map(UserInfo::getId).collect(Collectors.toList());

        Map<Long, List<Long>> groupIdListMap = userRefGroupService.getGroupMapByUserIdList(userIdList);

        return userInfoList.stream().map(item -> {
            UserInfoVo vo = new UserInfoVo();
            vo.setId(item.getId());
            vo.setUsername(item.getUsername());
            vo.setNoteInfo(item.getNoteInfo());
            vo.setGroupList(groupIdListMap.get(item.getId()));
            vo.setUserStatus(item.getUserStatus());
            vo.setCreateTime(DateUtils.toTimestamp(item.getCreateTime()));
            vo.setUpdateTime(DateUtils.toTimestamp(item.getUpdateTime()));
            return vo;
        }).collect(Collectors.toList());

    }

    @Override
    public Boolean addUser(UserInfoAddRequest request) {
        String username = request.getUsername();
        if(userInfoService.getByName(username) != null) {
            throw MyException.build("用户名称已存在");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(request.getUsername());
        userInfo.setNoteInfo(request.getNoteInfo());
        userInfo.setUserStatus(request.getUserStatus());
        userInfo.setCreateTime(LocalDateTime.now());
        userInfo.setUpdateTime(LocalDateTime.now());
        userInfoService.save(userInfo);
        userRefGroupService.saveByGroupIdList(userInfo.getId(), request.getGroupList());
        return true;
    }

    @Override
    public Boolean updateUser(UserInfoUpdateRequest request) {
        String username = request.getUsername();
        Long id = request.getId();
        UserInfo oldUserInfo = userInfoService.getByName(username);
        if(oldUserInfo != null && !id.equals(oldUserInfo.getId())) {
            throw MyException.build("用户名称已存在");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setId(request.getId());
        userInfo.setUsername(request.getUsername());
        userInfo.setNoteInfo(request.getNoteInfo());
        userInfo.setUserStatus(request.getUserStatus());
        userInfo.setCreateTime(LocalDateTime.now());
        userInfo.setUpdateTime(LocalDateTime.now());
        userInfoService.updateById(userInfo);
        userRefGroupService.saveByGroupIdList(userInfo.getId(), request.getGroupList());
        return true;
    }

    @Override
    public Boolean deleteUser(Long id) {
        return userInfoService.removeById(id);
    }
}
