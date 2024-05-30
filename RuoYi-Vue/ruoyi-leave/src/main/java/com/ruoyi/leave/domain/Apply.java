package com.ruoyi.leave.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 申请对象 apply
 * 
 * @author ruoyi
 * @date 2024-05-30
 */
public class Apply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 申请id */
    private Long applyId;

    /** 申请人 */
    @Excel(name = "申请人")
    private String applyName;

    /** 申请时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applyDate;

    /** 申请类型 */
    @Excel(name = "申请类型")
    private String applyType;

    /** 审核人 */
    @Excel(name = "审核人")
    private String reviewName;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 原因 */
    @Excel(name = "原因")
    private String reason;

    public void setApplyId(Long applyId) 
    {
        this.applyId = applyId;
    }

    public Long getApplyId() 
    {
        return applyId;
    }
    public void setApplyName(String applyName) 
    {
        this.applyName = applyName;
    }

    public String getApplyName() 
    {
        return applyName;
    }
    public void setApplyDate(Date applyDate) 
    {
        this.applyDate = applyDate;
    }

    public Date getApplyDate() 
    {
        return applyDate;
    }
    public void setApplyType(String applyType) 
    {
        this.applyType = applyType;
    }

    public String getApplyType() 
    {
        return applyType;
    }
    public void setReviewName(String reviewName) 
    {
        this.reviewName = reviewName;
    }

    public String getReviewName() 
    {
        return reviewName;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setReason(String reason) 
    {
        this.reason = reason;
    }

    public String getReason() 
    {
        return reason;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("applyId", getApplyId())
            .append("applyName", getApplyName())
            .append("applyDate", getApplyDate())
            .append("applyType", getApplyType())
            .append("reviewName", getReviewName())
            .append("status", getStatus())
            .append("reason", getReason())
            .toString();
    }
}
