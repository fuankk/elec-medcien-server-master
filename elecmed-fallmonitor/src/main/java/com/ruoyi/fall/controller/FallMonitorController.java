package com.ruoyi.fall.controller;

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
import com.ruoyi.fall.domain.FallMonitor;
import com.ruoyi.fall.service.IFallMonitorService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 跌倒监测Controller
 * 
 * @author zyl
 * @date 2022-11-29
 */
@RestController
@RequestMapping("/fall/fallmonitor")
public class FallMonitorController extends BaseController
{
    @Autowired
    private IFallMonitorService fallMonitorService;

    /**
     * 查询跌倒监测列表
     */
    @PreAuthorize("@ss.hasPermi('fall:fallmonitor:list')")
    @GetMapping("/list")
    public TableDataInfo list(FallMonitor fallMonitor)
    {
        startPage();
        List<FallMonitor> list = fallMonitorService.selectFallMonitorList(fallMonitor);
        return getDataTable(list);
    }

    /**
     * 导出跌倒监测列表
     */
    @PreAuthorize("@ss.hasPermi('fall:fallmonitor:export')")
    @Log(title = "跌倒监测", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FallMonitor fallMonitor)
    {
        List<FallMonitor> list = fallMonitorService.selectFallMonitorList(fallMonitor);
        ExcelUtil<FallMonitor> util = new ExcelUtil<FallMonitor>(FallMonitor.class);
        util.exportExcel(response, list, "跌倒监测数据");
    }

    /**
     * 获取跌倒监测详细信息
     */
    @PreAuthorize("@ss.hasPermi('fall:fallmonitor:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(fallMonitorService.selectFallMonitorById(id));
    }

    /**
     * 新增跌倒监测
     */
    @PreAuthorize("@ss.hasPermi('fall:fallmonitor:add')")
    @Log(title = "跌倒监测", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FallMonitor fallMonitor)
    {
        return toAjax(fallMonitorService.insertFallMonitor(fallMonitor));
    }

    /**
     * 修改跌倒监测
     */
    @PreAuthorize("@ss.hasPermi('fall:fallmonitor:edit')")
    @Log(title = "跌倒监测", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FallMonitor fallMonitor)
    {
        return toAjax(fallMonitorService.updateFallMonitor(fallMonitor));
    }

    /**
     * 删除跌倒监测
     */
    @PreAuthorize("@ss.hasPermi('fall:fallmonitor:remove')")
    @Log(title = "跌倒监测", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fallMonitorService.deleteFallMonitorByIds(ids));
    }
}
