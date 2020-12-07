package io.github.tanghuibo.onepiecestudyweb.service.impl;

import io.github.tanghuibo.onepiecestudyweb.entity.UserInfo;
import io.github.tanghuibo.onepiecestudyweb.mapper.UserInfoMapper;
import io.github.tanghuibo.onepiecestudyweb.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author thb
 * @since 2020-12-08
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
