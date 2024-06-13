package com.ruoyi.web.controller.professors;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.professors.domain.People;
import com.ruoyi.professors.service.IPeopleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教授人群Controller
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
@RestController
@RequestMapping("/professors/people")
public class PeopleController extends BaseController
{
    @Autowired
    private IPeopleService peopleService;

    /**
     * 查询教授人群列表
     */
    @PreAuthorize("@ss.hasPermi('professors:people:list')")
    @GetMapping("/list")
    public TableDataInfo list(People people)
    {
        startPage();
        List<People> list = peopleService.selectPeopleList(people);
        return getDataTable(list);
    }

    /**
     * 导出教授人群列表
     */
    @PreAuthorize("@ss.hasPermi('professors:people:export')")
    @Log(title = "教授人群", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, People people)
    {
        List<People> list = peopleService.selectPeopleList(people);
        ExcelUtil<People> util = new ExcelUtil<People>(People.class);
        util.exportExcel(response, list, "教授人群数据");
    }

    /**
     * 获取教授人群详细信息
     */
    @PreAuthorize("@ss.hasPermi('professors:people:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(peopleService.selectPeopleById(id));
    }

    /**
     * 新增教授人群
     */
    @PreAuthorize("@ss.hasPermi('professors:people:add')")
    @Log(title = "教授人群", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody People people)
    {
        return toAjax(peopleService.insertPeople(people));
    }

    /**
     * 修改教授人群
     */
    @PreAuthorize("@ss.hasPermi('professors:people:edit')")
    @Log(title = "教授人群", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody People people)
    {
        return toAjax(peopleService.updatePeople(people));
    }

    /**
     * 删除教授人群
     */
    @PreAuthorize("@ss.hasPermi('professors:people:remove')")
    @Log(title = "教授人群", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(peopleService.deletePeopleByIds(ids));
    }
}
