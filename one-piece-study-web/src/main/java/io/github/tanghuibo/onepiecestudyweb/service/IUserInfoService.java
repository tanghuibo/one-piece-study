package io.github.tanghuibo.onepiecestudyweb.service;

import io.github.tanghuibo.onepiecestudyweb.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author thb
 * @since 2020-12-08
 */
public interface IUserInfoService extends IService<UserInfo> {

    /**
     * 通过名称获取
     * @param usernmae
     * @return
     */
    default UserInfo getByName(String usernmae) {
        return lambdaQuery().eq(UserInfo::getUsername, usernmae).last("limit 1").one();
    }
}
