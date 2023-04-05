package com.ruoyi.elecmed.controller;

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
import com.ruoyi.elecmed.domain.SleepPosture;
import com.ruoyi.elecmed.service.ISleepPostureService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 睡眠姿势Controller
 * 
 * @author zyl
 * @date 2022-10-03
 */
@RestController
@RequestMapping("/elecmed/posture")
public class SleepPostureController extends BaseController
{
    @Autowired
    private ISleepPostureService sleepPostureService;

    /**
     * 查询睡眠姿势列表
     */
    @PreAuthorize("@ss.hasPermi('elecmed:posture:list')")
    @GetMapping("/list")
    public TableDataInfo list(SleepPosture sleepPosture)
    {
        startPage();
        List<SleepPosture> list = sleepPostureService.selectSleepPostureList(sleepPosture);
        return getDataTable(list);
    }

    /**
     * 导出睡眠姿势列表
     */
    @PreAuthorize("@ss.hasPermi('elecmed:posture:export')")
    @Log(title = "睡眠姿势", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SleepPosture sleepPosture)
    {
        List<SleepPosture> list = sleepPostureService.selectSleepPostureList(sleepPosture);
        ExcelUtil<SleepPosture> util = new ExcelUtil<SleepPosture>(SleepPosture.class);
        util.exportExcel(response, list, "睡眠姿势数据");
    }

    /**
     * 获取睡眠姿势详细信息
     */
//    @PreAuthorize("@ss.hasPermi('elecmed:posture:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sleepPostureService.selectSleepPostureById(id));
    }

    /**
     * 新增睡眠姿势
     */
    @PreAuthorize("@ss.hasPermi('elecmed:posture:add')")
    @Log(title = "睡眠姿势", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SleepPosture sleepPosture)
    {
        return toAjax(sleepPostureService.insertSleepPosture(sleepPosture));
    }

    /**
     * 修改睡眠姿势
     */
    @PreAuthorize("@ss.hasPermi('elecmed:posture:edit')")
    @Log(title = "睡眠姿势", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SleepPosture sleepPosture)
    {
        return toAjax(sleepPostureService.updateSleepPosture(sleepPosture));
    }

    /**
     * 删除睡眠姿势
     */
    @PreAuthorize("@ss.hasPermi('elecmed:posture:remove')")
    @Log(title = "睡眠姿势", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sleepPostureService.deleteSleepPostureByIds(ids));
    }
}
