package com.ruoyi.web.controller.leave;

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
import com.ruoyi.leave.domain.Apply;
import com.ruoyi.leave.service.IApplyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 申请Controller
 * 
 * @author ruoyi
 * @date 2024-05-30
 */
@RestController
@RequestMapping("/leave/apply")
public class ApplyController extends BaseController
{
    @Autowired
    private IApplyService applyService;

    /**
     * 查询申请列表
     */
    @PreAuthorize("@ss.hasPermi('leave:apply:list')")
    @GetMapping("/list")
    public TableDataInfo list(Apply apply)
    {
        startPage();
        List<Apply> list = applyService.selectApplyList(apply);
        return getDataTable(list);
    }

    /**
     * 导出申请列表
     */
    @PreAuthorize("@ss.hasPermi('leave:apply:export')")
    @Log(title = "申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Apply apply)
    {
        List<Apply> list = applyService.selectApplyList(apply);
        ExcelUtil<Apply> util = new ExcelUtil<Apply>(Apply.class);
        util.exportExcel(response, list, "申请数据");
    }

    /**
     * 获取申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('leave:apply:query')")
    @GetMapping(value = "/{applyId}")
    public AjaxResult getInfo(@PathVariable("applyId") Long applyId)
    {
        return success(applyService.selectApplyByApplyId(applyId));
    }

    /**
     * 新增申请
     */
    @PreAuthorize("@ss.hasPermi('leave:apply:add')")
    @Log(title = "申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Apply apply)
    {
        return toAjax(applyService.insertApply(apply));
    }

    /**
     * 修改申请
     */
    @PreAuthorize("@ss.hasPermi('leave:apply:edit')")
    @Log(title = "申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Apply apply)
    {
        return toAjax(applyService.updateApply(apply));
    }

    /**
     * 删除申请
     */
    @PreAuthorize("@ss.hasPermi('leave:apply:remove')")
    @Log(title = "申请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{applyIds}")
    public AjaxResult remove(@PathVariable Long[] applyIds)
    {
        return toAjax(applyService.deleteApplyByApplyIds(applyIds));
    }
}
