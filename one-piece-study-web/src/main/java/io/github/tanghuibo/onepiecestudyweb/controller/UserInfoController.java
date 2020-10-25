package io.github.tanghuibo.onepiecestudyweb.controller;


import io.github.tanghuibo.onepiecestudyweb.entity.UserInfo;
import io.github.tanghuibo.onepiecestudyweb.service.IUserInfoService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author thb
 * @since 2020-10-25
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Resource
    IUserInfoService userInfoService;

    @GetMapping("query")
    public List<UserInfo> getAll() {
        return userInfoService.list();
    }


    @PostMapping("add")
    public Boolean add(@RequestBody UserInfo userInfo) {
        userInfo.setId(null);
        return userInfoService.save(userInfo);
    }

    @PutMapping("update")
    public Boolean update(@RequestBody UserInfo userInfo) {
        return userInfoService.updateById(userInfo);
    }

    @DeleteMapping("delete")
    public Boolean delete(@RequestParam Long id) {
        return userInfoService.removeById(id);
    }

}
