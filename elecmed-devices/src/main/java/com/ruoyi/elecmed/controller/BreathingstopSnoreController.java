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
import com.ruoyi.elecmed.domain.BreathingstopSnore;
import com.ruoyi.elecmed.service.IBreathingstopSnoreService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 呼吸暂停打鼾Controller
 * 
 * @author zyl
 * @date 2022-10-03
 */
@RestController
@RequestMapping("/elecmed/snore")
public class BreathingstopSnoreController extends BaseController
{
    @Autowired
    private IBreathingstopSnoreService breathingstopSnoreService;

    /**
     * 查询呼吸暂停打鼾列表
     */
    @PreAuthorize("@ss.hasPermi('elecmed:snore:list')")
    @GetMapping("/list")
    public TableDataInfo list(BreathingstopSnore breathingstopSnore)
    {
        startPage();
        List<BreathingstopSnore> list = breathingstopSnoreService.selectBreathingstopSnoreList(breathingstopSnore);
        return getDataTable(list);
    }

    /**
     * 导出呼吸暂停打鼾列表
     */
    @PreAuthorize("@ss.hasPermi('elecmed:snore:export')")
    @Log(title = "呼吸暂停打鼾", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BreathingstopSnore breathingstopSnore)
    {
        List<BreathingstopSnore> list = breathingstopSnoreService.selectBreathingstopSnoreList(breathingstopSnore);
        ExcelUtil<BreathingstopSnore> util = new ExcelUtil<BreathingstopSnore>(BreathingstopSnore.class);
        util.exportExcel(response, list, "呼吸暂停打鼾数据");
    }

    /**
     * 获取呼吸暂停打鼾详细信息
     */
//    @PreAuthorize("@ss.hasPermi('elecmed:snore:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(breathingstopSnoreService.selectBreathingstopSnoreById(id));
    }

    /**
     * 新增呼吸暂停打鼾
     */
    @PreAuthorize("@ss.hasPermi('elecmed:snore:add')")
    @Log(title = "呼吸暂停打鼾", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BreathingstopSnore breathingstopSnore)
    {
        return toAjax(breathingstopSnoreService.insertBreathingstopSnore(breathingstopSnore));
    }

    /**
     * 修改呼吸暂停打鼾
     */
    @PreAuthorize("@ss.hasPermi('elecmed:snore:edit')")
    @Log(title = "呼吸暂停打鼾", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BreathingstopSnore breathingstopSnore)
    {
        return toAjax(breathingstopSnoreService.updateBreathingstopSnore(breathingstopSnore));
    }

    /**
     * 删除呼吸暂停打鼾
     */
    @PreAuthorize("@ss.hasPermi('elecmed:snore:remove')")
    @Log(title = "呼吸暂停打鼾", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(breathingstopSnoreService.deleteBreathingstopSnoreByIds(ids));
    }
}
