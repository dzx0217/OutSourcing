package com.ruoyi.professors.mapper;

import java.util.List;
import com.ruoyi.professors.domain.People;

/**
 * 教授人群Mapper接口
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
public interface PeopleMapper 
{
    /**
     * 查询教授人群
     * 
     * @param id 教授人群主键
     * @return 教授人群
     */
    public People selectPeopleById(Long id);

    /**
     * 查询教授人群列表
     * 
     * @param people 教授人群
     * @return 教授人群集合
     */
    public List<People> selectPeopleList(People people);

    /**
     * 新增教授人群
     * 
     * @param people 教授人群
     * @return 结果
     */
    public int insertPeople(People people);

    /**
     * 修改教授人群
     * 
     * @param people 教授人群
     * @return 结果
     */
    public int updatePeople(People people);

    /**
     * 删除教授人群
     * 
     * @param id 教授人群主键
     * @return 结果
     */
    public int deletePeopleById(Long id);

    /**
     * 批量删除教授人群
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePeopleByIds(Long[] ids);
}
