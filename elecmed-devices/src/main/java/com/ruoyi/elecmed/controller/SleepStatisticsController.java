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
import com.ruoyi.elecmed.domain.SleepStatistics;
import com.ruoyi.elecmed.service.ISleepStatisticsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 睡眠统计Controller
 * 
 * @author zyl
 * @date 2022-10-03
 */
@RestController
@RequestMapping("/elecmed/statistics")
public class SleepStatisticsController extends BaseController
{
    @Autowired
    private ISleepStatisticsService sleepStatisticsService;

    /**
     * 查询睡眠统计列表
     */
    @PreAuthorize("@ss.hasPermi('elecmed:statistics:list')")
    @GetMapping("/list")
    public TableDataInfo list(SleepStatistics sleepStatistics)
    {
        startPage();
        List<SleepStatistics> list = sleepStatisticsService.selectSleepStatisticsList(sleepStatistics);
        return getDataTable(list);
    }

    /**
     * 导出睡眠统计列表
     */
    @PreAuthorize("@ss.hasPermi('elecmed:statistics:export')")
    @Log(title = "睡眠统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SleepStatistics sleepStatistics)
    {
        List<SleepStatistics> list = sleepStatisticsService.selectSleepStatisticsList(sleepStatistics);
        ExcelUtil<SleepStatistics> util = new ExcelUtil<SleepStatistics>(SleepStatistics.class);
        util.exportExcel(response, list, "睡眠统计数据");
    }

    /**
     * 获取睡眠统计详细信息
     */
//    @PreAuthorize("@ss.hasPermi('elecmed:statistics:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sleepStatisticsService.selectSleepStatisticsById(id));
    }

    /**
     * 新增睡眠统计
     */
    @PreAuthorize("@ss.hasPermi('elecmed:statistics:add')")
    @Log(title = "睡眠统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SleepStatistics sleepStatistics)
    {
        return toAjax(sleepStatisticsService.insertSleepStatistics(sleepStatistics));
    }

    /**
     * 修改睡眠统计
     */
    @PreAuthorize("@ss.hasPermi('elecmed:statistics:edit')")
    @Log(title = "睡眠统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SleepStatistics sleepStatistics)
    {
        return toAjax(sleepStatisticsService.updateSleepStatistics(sleepStatistics));
    }

    /**
     * 删除睡眠统计
     */
    @PreAuthorize("@ss.hasPermi('elecmed:statistics:remove')")
    @Log(title = "睡眠统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sleepStatisticsService.deleteSleepStatisticsByIds(ids));
    }
}
