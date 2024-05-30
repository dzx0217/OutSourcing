package com.ruoyi.leave.mapper;

import java.util.List;
import com.ruoyi.leave.domain.Apply;

/**
 * 申请Mapper接口
 * 
 * @author ruoyi
 * @date 2024-05-30
 */
public interface ApplyMapper 
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
     * 删除申请
     * 
     * @param applyId 申请主键
     * @return 结果
     */
    public int deleteApplyByApplyId(Long applyId);

    /**
     * 批量删除申请
     * 
     * @param applyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteApplyByApplyIds(Long[] applyIds);
}
