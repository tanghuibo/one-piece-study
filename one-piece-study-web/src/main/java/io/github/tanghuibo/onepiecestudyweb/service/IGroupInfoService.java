package io.github.tanghuibo.onepiecestudyweb.service;

import io.github.tanghuibo.onepiecestudyweb.entity.GroupInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * <p>
 * 分组信息 服务类
 * </p>
 *
 * @author thb
 * @since 2020-12-07
 */
public interface IGroupInfoService extends IService<GroupInfo> {

    /**
     * 通过名称获取
     * @param name
     * @return
     */
    default GroupInfo getByName(String name) {
        return lambdaQuery().eq(GroupInfo::getName, name).last("limit 1").one();
    }


    /**
     * 获取名称map
     * @param idList
     * @return
     */
    default Map<Long, String> getNameMap(List<Long> idList) {
        if(CollectionUtils.isEmpty(idList)) {
            return Collections.emptyMap();
        }
        return lambdaQuery().in(GroupInfo::getId, idList).list().stream()
                .collect(Collectors.toMap(GroupInfo::getId, GroupInfo::getName));
    }
}
