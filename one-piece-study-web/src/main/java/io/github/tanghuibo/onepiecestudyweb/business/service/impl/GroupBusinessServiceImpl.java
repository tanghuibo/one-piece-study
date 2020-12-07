package io.github.tanghuibo.onepiecestudyweb.business.service.impl;

import io.github.tanghuibo.onepiecestudyweb.business.service.GroupBusinessService;
import io.github.tanghuibo.onepiecestudyweb.entity.GroupInfo;
import io.github.tanghuibo.onepiecestudyweb.entity.UserRefGroup;
import io.github.tanghuibo.onepiecestudyweb.exception.MyException;
import io.github.tanghuibo.onepiecestudyweb.request.GroupInfoAddRequest;
import io.github.tanghuibo.onepiecestudyweb.request.GroupInfoUpdateRequest;
import io.github.tanghuibo.onepiecestudyweb.service.IGroupInfoService;
import io.github.tanghuibo.onepiecestudyweb.service.IUserRefGroupService;
import io.github.tanghuibo.onepiecestudyweb.util.DateUtils;
import io.github.tanghuibo.onepiecestudyweb.vo.GroupInfoVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author tanghuibo
* @date 2020/12/7下午11:57
*/
@Service
public class GroupBusinessServiceImpl implements GroupBusinessService {
    @Resource
    IUserRefGroupService userRefGroupService;

    @Resource
    IGroupInfoService groupInfoService;
    @Override
    public List<GroupInfoVo> getAll() {
        return groupInfoService.list().stream().map(
                item -> {
                    GroupInfoVo vo = new GroupInfoVo();
                    vo.setId(item.getId());
                    vo.setName(item.getName());
                    vo.setNoteInfo(item.getNoteInfo());
                    vo.setCreateTime(DateUtils.toTimestamp(item.getCreateTime()));
                    vo.setUpdateTime(DateUtils.toTimestamp(item.getUpdateTime()));
                    return vo;
                }
        ).collect(Collectors.toList());
    }

    @Override
    public Boolean addGroup(GroupInfoAddRequest request) {
        String name = request.getName();
        if(groupInfoService.getByName(name)!=null) {
            throw MyException.build("分组名已存在");
        }
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setName(request.getName());
        groupInfo.setNoteInfo(request.getNoteInfo());
        groupInfo.setCreateTime(LocalDateTime.now());
        groupInfo.setUpdateTime(LocalDateTime.now());

        return groupInfoService.save(groupInfo);
    }

    @Override
    public Boolean updateGroup(GroupInfoUpdateRequest request) {
        Long id = request.getId();
        String name = request.getName();
        GroupInfo oldGroupInfo = groupInfoService.getByName(name);
        if(oldGroupInfo != null && !id.equals(oldGroupInfo.getId())) {
            throw MyException.build("分组名已存在");
        }
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setId(request.getId());
        groupInfo.setName(request.getName());
        groupInfo.setNoteInfo(request.getNoteInfo());
        groupInfo.setUpdateTime(LocalDateTime.now());
        return groupInfoService.updateById(groupInfo);
    }

    @Override
    public Boolean deleteGroup(Long id) {
        List<UserRefGroup> userRefGroups = userRefGroupService.queryByGroupId(id);
        if(userRefGroups.size() > 0) {
            throw MyException.build("分组正在使用中，禁止删除");
        }
        return groupInfoService.removeById(id);
    }
}
