package com.ruoyi.professors.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教授人群对象 people
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
public class People extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${个人简历页面}", readConverterExp = "$column.readConverterExp()")
    private String profileurl;

    /** $column.columnComment */
    @Excel(name = "${姓名}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** $column.columnComment */
    @Excel(name = "${邮件}", readConverterExp = "$column.readConverterExp()")
    private String email;

    /** $column.columnComment */
    @Excel(name = "${领域}", readConverterExp = "$column.readConverterExp()")
    private String field;

    /** $column.columnComment */
    @Excel(name = "${学校}", readConverterExp = "$column.readConverterExp()")
    private String school;

    /** $column.columnComment */
    @Excel(name = "${部门}", readConverterExp = "$column.readConverterExp()")
    private String department;

    /** $column.columnComment */
    @Excel(name = "${位置}", readConverterExp = "$column.readConverterExp()")
    private String location;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProfileurl(String profileurl) 
    {
        this.profileurl = profileurl;
    }

    public String getProfileurl() 
    {
        return profileurl;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setField(String field) 
    {
        this.field = field;
    }

    public String getField() 
    {
        return field;
    }
    public void setSchool(String school) 
    {
        this.school = school;
    }

    public String getSchool() 
    {
        return school;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("profileurl", getProfileurl())
            .append("name", getName())
            .append("email", getEmail())
            .append("field", getField())
            .append("school", getSchool())
            .append("department", getDepartment())
            .append("location", getLocation())
            .toString();
    }
}
