package io.github.tanghuibo.onepiecestudyweb.controller;

import io.github.tanghuibo.onepiecestudyweb.business.service.GroupBusinessService;
import io.github.tanghuibo.onepiecestudyweb.request.GroupInfoAddRequest;
import io.github.tanghuibo.onepiecestudyweb.request.GroupInfoUpdateRequest;
import io.github.tanghuibo.onepiecestudyweb.vo.GroupInfoVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tanghuibo
 * @date 2020/12/7下午11:43
 */
@RestController
@RequestMapping("/groupInfo")
public class GroupInfoController {

    @Resource
    GroupBusinessService groupBusinessService;

    @GetMapping("query")
    public List<GroupInfoVo> getAll() {
        return groupBusinessService.getAll();
    }


    @PostMapping("add")
    public Boolean add(@RequestBody GroupInfoAddRequest request) {
        return groupBusinessService.addGroup(request);
    }

    @PutMapping("update")
    public Boolean update(@RequestBody GroupInfoUpdateRequest request) {
        return groupBusinessService.updateGroup(request);
    }

    @DeleteMapping("delete")
    public Boolean delete(@RequestParam Long id) {
        return groupBusinessService.deleteGroup(id);
    }
}
