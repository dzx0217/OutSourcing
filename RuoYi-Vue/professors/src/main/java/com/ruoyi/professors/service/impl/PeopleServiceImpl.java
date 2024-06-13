package com.ruoyi.professors.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.professors.mapper.PeopleMapper;
import com.ruoyi.professors.domain.People;
import com.ruoyi.professors.service.IPeopleService;

/**
 * 教授人群Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
@Service
public class PeopleServiceImpl implements IPeopleService 
{
    @Autowired
    private PeopleMapper peopleMapper;

    /**
     * 查询教授人群
     * 
     * @param id 教授人群主键
     * @return 教授人群
     */
    @Override
    public People selectPeopleById(Long id)
    {
        return peopleMapper.selectPeopleById(id);
    }

    /**
     * 查询教授人群列表
     * 
     * @param people 教授人群
     * @return 教授人群
     */
    @Override
    public List<People> selectPeopleList(People people)
    {
        return peopleMapper.selectPeopleList(people);
    }

    /**
     * 新增教授人群
     * 
     * @param people 教授人群
     * @return 结果
     */
    @Override
    public int insertPeople(People people)
    {
        return peopleMapper.insertPeople(people);
    }

    /**
     * 修改教授人群
     * 
     * @param people 教授人群
     * @return 结果
     */
    @Override
    public int updatePeople(People people)
    {
        return peopleMapper.updatePeople(people);
    }

    /**
     * 批量删除教授人群
     * 
     * @param ids 需要删除的教授人群主键
     * @return 结果
     */
    @Override
    public int deletePeopleByIds(Long[] ids)
    {
        return peopleMapper.deletePeopleByIds(ids);
    }

    /**
     * 删除教授人群信息
     * 
     * @param id 教授人群主键
     * @return 结果
     */
    @Override
    public int deletePeopleById(Long id)
    {
        return peopleMapper.deletePeopleById(id);
    }
}
