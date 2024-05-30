package com.ruoyi.leave.service;

import java.util.List;
import com.ruoyi.leave.domain.Apply;

/**
 * 申请Service接口
 * 
 * @author ruoyi
 * @date 2024-05-30
 */
public interface IApplyService 
{
    /**
     * 查询申请
     * 
     * @param applyId 申请主键
     * @return 申请
     */
    public Apply selectApplyByApplyId(Long applyId);

    /**
     * 查询申请列表
     * 
     * @param apply 申请
     * @return 申请集合
     */
    public List<Apply> selectApplyList(Apply apply);

    /**
     * 新增申请
     * 
     * @param apply 申请
     * @return 结果
     */
    public int insertApply(Apply apply);

    /**
     * 修改申请
     * 
     * @param apply 申请
     * @return 结果
     */
    public int updateApply(Apply apply);

    /**
     * 批量删除申请
     * 
     * @param applyIds 需要删除的申请主键集合
     * @return 结果
     */
    public int deleteApplyByApplyIds(Long[] applyIds);

    /**
     * 删除申请信息
     * 
     * @param applyId 申请主键
     * @return 结果
     */
    public int deleteApplyByApplyId(Long applyId);
}
