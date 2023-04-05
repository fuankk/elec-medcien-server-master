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
import com.ruoyi.elecmed.domain.BloodPressureWaveform;
import com.ruoyi.elecmed.service.IBloodPressureWaveformService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 血压波形Controller
 * 
 * @author zyl
 * @date 2022-10-03
 */
@RestController
@RequestMapping("/elecmed/waveform")
public class BloodPressureWaveformController extends BaseController
{
    @Autowired
    private IBloodPressureWaveformService bloodPressureWaveformService;

    /**
     * 查询血压波形列表
     */
    @PreAuthorize("@ss.hasPermi('elecmed:waveform:list')")
    @GetMapping("/list")
    public TableDataInfo list(BloodPressureWaveform bloodPressureWaveform)
    {
        startPage();
        List<BloodPressureWaveform> list = bloodPressureWaveformService.selectBloodPressureWaveformList(bloodPressureWaveform);
        return getDataTable(list);
    }

    /**
     * 导出血压波形列表
     */
    @PreAuthorize("@ss.hasPermi('elecmed:waveform:export')")
    @Log(title = "血压波形", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BloodPressureWaveform bloodPressureWaveform)
    {
        List<BloodPressureWaveform> list = bloodPressureWaveformService.selectBloodPressureWaveformList(bloodPressureWaveform);
        ExcelUtil<BloodPressureWaveform> util = new ExcelUtil<BloodPressureWaveform>(BloodPressureWaveform.class);
        util.exportExcel(response, list, "血压波形数据");
    }

    /**
     * 获取血压波形详细信息
     */
    @PreAuthorize("@ss.hasPermi('elecmed:waveform:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(bloodPressureWaveformService.selectBloodPressureWaveformById(id));
    }

    /**
     * 新增血压波形
     */
    @PreAuthorize("@ss.hasPermi('elecmed:waveform:add')")
    @Log(title = "血压波形", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BloodPressureWaveform bloodPressureWaveform)
    {
        return toAjax(bloodPressureWaveformService.insertBloodPressureWaveform(bloodPressureWaveform));
    }

    /**
     * 修改血压波形
     */
    @PreAuthorize("@ss.hasPermi('elecmed:waveform:edit')")
    @Log(title = "血压波形", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BloodPressureWaveform bloodPressureWaveform)
    {
        return toAjax(bloodPressureWaveformService.updateBloodPressureWaveform(bloodPressureWaveform));
    }

    /**
     * 删除血压波形
     */
    @PreAuthorize("@ss.hasPermi('elecmed:waveform:remove')")
    @Log(title = "血压波形", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bloodPressureWaveformService.deleteBloodPressureWaveformByIds(ids));
    }
}
