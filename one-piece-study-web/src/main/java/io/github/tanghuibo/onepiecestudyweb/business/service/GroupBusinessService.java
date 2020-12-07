package io.github.tanghuibo.onepiecestudyweb.business.service;

import io.github.tanghuibo.onepiecestudyweb.request.GroupInfoAddRequest;
import io.github.tanghuibo.onepiecestudyweb.request.GroupInfoUpdateRequest;
import io.github.tanghuibo.onepiecestudyweb.vo.GroupInfoVo;

import java.util.List;

/**
 * @author tanghuibo
 * @date 2020/12/7下午11:44
 */
public interface GroupBusinessService {

    /**
     * 获取所有分组
     * @return
     */
    List<GroupInfoVo> getAll();

    /**
     * 添加分组
     * @param request
     * @return
     */
    Boolean addGroup(GroupInfoAddRequest request);

    /**
     * 更新分组
     * @param request
     * @return
     */
    Boolean updateGroup(GroupInfoUpdateRequest request);

    /**
     * 删除分组
     * @param id
     * @return
     */
    Boolean deleteGroup(Long id);
}
