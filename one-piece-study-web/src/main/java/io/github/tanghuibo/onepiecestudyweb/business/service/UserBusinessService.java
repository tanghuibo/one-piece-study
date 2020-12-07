package io.github.tanghuibo.onepiecestudyweb.business.service;

import io.github.tanghuibo.onepiecestudyweb.request.UserInfoAddRequest;
import io.github.tanghuibo.onepiecestudyweb.request.UserInfoUpdateRequest;
import io.github.tanghuibo.onepiecestudyweb.vo.UserInfoVo;

import java.util.List;

/**
 * @author tanghuibo
 * @date 2020/12/7下午11:35
 */
public interface UserBusinessService {

    /**
     * 获取全部用户信息
     * @return
     */
    List<UserInfoVo> getAll();

    /**
     * 添加用户信息
     * @param request
     * @return
     */
    Boolean addUser(UserInfoAddRequest request);

    /**
     * 更新用户信息
     * @param request
     * @return
     */
    Boolean updateUser(UserInfoUpdateRequest request);

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    Boolean deleteUser(Long id);
}
