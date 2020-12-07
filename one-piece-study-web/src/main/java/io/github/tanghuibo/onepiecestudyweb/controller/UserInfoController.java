package io.github.tanghuibo.onepiecestudyweb.controller;


import io.github.tanghuibo.onepiecestudyweb.business.service.UserBusinessService;
import io.github.tanghuibo.onepiecestudyweb.entity.UserInfo;
import io.github.tanghuibo.onepiecestudyweb.request.UserInfoAddRequest;
import io.github.tanghuibo.onepiecestudyweb.request.UserInfoUpdateRequest;
import io.github.tanghuibo.onepiecestudyweb.service.IUserInfoService;
import io.github.tanghuibo.onepiecestudyweb.vo.UserInfoVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author thb
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Resource
    UserBusinessService userBusinessService;

    @GetMapping("query")
    public List<UserInfoVo> getAll() {
        return userBusinessService.getAll();
    }


    @PostMapping("add")
    public Boolean add(@RequestBody UserInfoAddRequest request) {
        return userBusinessService.addUser(request);
    }

    @PutMapping("update")
    public Boolean update(@RequestBody UserInfoUpdateRequest request) {
        return userBusinessService.updateUser(request);
    }

    @DeleteMapping("delete")
    public Boolean delete(@RequestParam Long id) {
        return userBusinessService.deleteUser(id);
    }



}
