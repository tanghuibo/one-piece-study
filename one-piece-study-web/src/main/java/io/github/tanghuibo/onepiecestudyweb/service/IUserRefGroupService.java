package io.github.tanghuibo.onepiecestudyweb.service;

import io.github.tanghuibo.onepiecestudyweb.entity.UserRefGroup;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户分组信息 服务类
 * </p>
 *
 * @author thb
 * @since 2020-12-07
 */
public interface IUserRefGroupService extends IService<UserRefGroup> {

    /**
     * 通过分组id查询
     * @param groupId
     * @return
     */
    default List<UserRefGroup> queryByGroupId(Long groupId) {
        return lambdaQuery().eq(UserRefGroup::getGroupId, groupId).list();
    }

    /**
     * 获取分组信息
     * @param userIdList
     * @return
     */
    default Map<Long, List<Long>> getGroupMapByUserIdList(List<Long> userIdList) {
        return lambdaQuery().in(UserRefGroup::getUserId, userIdList).list().stream().collect(Collectors.groupingBy(
                UserRefGroup::getUserId,
                Collectors.mapping(UserRefGroup::getGroupId, Collectors.toList())
        ));
    }

    /**
     * 通过分组id报春
     * @param userId
     * @param groupIdList
     * @return
     */
    default boolean saveByGroupIdList(Long userId, List<Long> groupIdList) {
        deleteByUserId(userId);
        if(groupIdList == null) {
            return true;
        }
        for (Long groupId : groupIdList) {
            UserRefGroup userRefGroup = new UserRefGroup();
            userRefGroup.setUserId(userId);
            userRefGroup.setGroupId(groupId);

            save(userRefGroup);
        }
        return true;
    }

    /**
     * 通过用户名删除
     * @param userId
     * @return
     */
    default boolean deleteByUserId(Long userId) {
        return lambdaUpdate().eq(UserRefGroup::getUserId, userId).remove();
    }

}
