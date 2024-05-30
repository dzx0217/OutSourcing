package com.ruoyi.leave.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.leave.mapper.ApplyMapper;
import com.ruoyi.leave.domain.Apply;
import com.ruoyi.leave.service.IApplyService;

/**
 * 申请Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-05-30
 */
@Service
public class ApplyServiceImpl implements IApplyService 
{
    @Autowired
    private ApplyMapper applyMapper;

    /**
     * 查询申请
     * 
     * @param applyId 申请主键
     * @return 申请
     */
    @Override
    public Apply selectApplyByApplyId(Long applyId)
    {
        return applyMapper.selectApplyByApplyId(applyId);
    }

    /**
     * 查询申请列表
     * 
     * @param apply 申请
     * @return 申请
     */
    @Override
    public List<Apply> selectApplyList(Apply apply)
    {
        return applyMapper.selectApplyList(apply);
    }

    /**
     * 新增申请
     * 
     * @param apply 申请
     * @return 结果
     */
    @Override
    public int insertApply(Apply apply)
    {
        return applyMapper.insertApply(apply);
    }

    /**
     * 修改申请
     * 
     * @param apply 申请
     * @return 结果
     */
    @Override
    public int updateApply(Apply apply)
    {
        return applyMapper.updateApply(apply);
    }

    /**
     * 批量删除申请
     * 
     * @param applyIds 需要删除的申请主键
     * @return 结果
     */
    @Override
    public int deleteApplyByApplyIds(Long[] applyIds)
    {
        return applyMapper.deleteApplyByApplyIds(applyIds);
    }

    /**
     * 删除申请信息
     * 
     * @param applyId 申请主键
     * @return 结果
     */
    @Override
    public int deleteApplyByApplyId(Long applyId)
    {
        return applyMapper.deleteApplyByApplyId(applyId);
    }
}
