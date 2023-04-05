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
import com.ruoyi.elecmed.domain.FallAlarm;
import com.ruoyi.elecmed.service.IFallAlarmService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 跌倒警报Controller
 * 
 * @author zyl
 * @date 2022-10-03
 */
@RestController
@RequestMapping("/elecmed/alarm")
public class FallAlarmController extends BaseController
{
    @Autowired
    private IFallAlarmService fallAlarmService;

    /**
     * 查询跌倒警报列表
     */
//    @PreAuthorize("@ss.hasPermi('elecmed:alarm:list')")
    @GetMapping("/list")
    public TableDataInfo list(FallAlarm fallAlarm)
    {
        startPage();
        List<FallAlarm> list = fallAlarmService.selectFallAlarmList(fallAlarm);
        return getDataTable(list);
    }

    /**
     * 导出跌倒警报列表
     */
    @PreAuthorize("@ss.hasPermi('elecmed:alarm:export')")
    @Log(title = "跌倒警报", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FallAlarm fallAlarm)
    {
        List<FallAlarm> list = fallAlarmService.selectFallAlarmList(fallAlarm);
        ExcelUtil<FallAlarm> util = new ExcelUtil<FallAlarm>(FallAlarm.class);
        util.exportExcel(response, list, "跌倒警报数据");
    }

    /**
     * 获取跌倒警报详细信息
     */
//    @PreAuthorize("@ss.hasPermi('elecmed:alarm:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(fallAlarmService.selectFallAlarmById(id));
    }

    /**
     * 新增跌倒警报
     */
    @PreAuthorize("@ss.hasPermi('elecmed:alarm:add')")
    @Log(title = "跌倒警报", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FallAlarm fallAlarm)
    {
        return toAjax(fallAlarmService.insertFallAlarm(fallAlarm));
    }

    /**
     * 修改跌倒警报
     */
    @PreAuthorize("@ss.hasPermi('elecmed:alarm:edit')")
    @Log(title = "跌倒警报", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FallAlarm fallAlarm)
    {
        return toAjax(fallAlarmService.updateFallAlarm(fallAlarm));
    }

    /**
     * 删除跌倒警报
     */
    @PreAuthorize("@ss.hasPermi('elecmed:alarm:remove')")
    @Log(title = "跌倒警报", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fallAlarmService.deleteFallAlarmByIds(ids));
    }
}
