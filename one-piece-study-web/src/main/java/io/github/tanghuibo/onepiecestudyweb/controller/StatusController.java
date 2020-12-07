package io.github.tanghuibo.onepiecestudyweb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author tanghuibo
 * @date 2020/12/8上午12:53
 */
@RestController
@RequestMapping("status")
public class StatusController {

    @GetMapping("user-status")
    public List<Map<String, Object>> queryUserStatusList() {
        return JSON.parseObject("[{\n" +
                "  \"index\": 1,\n" +
                "  \"desc\": \"新手\"\n" +
                "}, {\n" +
                "  \"index\": 2,\n" +
                "  \"desc\": \"普通\"\n" +
                "}, {\n" +
                "  \"index\": 3,\n" +
                "  \"desc\": \"熟练\"\n" +
                "}, {\n" +
                "  \"index\": 4,\n" +
                "  \"desc\": \"大师\"\n" +
                "}]", new TypeReference<List<Map<String, Object>>>() {});
    }
}
