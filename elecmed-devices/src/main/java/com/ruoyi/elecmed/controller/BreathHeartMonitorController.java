package com.ruoyi.elecmed.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.elecmed.domain.BreathHeartMonitor;
import com.ruoyi.elecmed.service.IBreathHeartMonitorService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 呼吸心跳监测Controller
 *
 * @author zyl
 * @date 2022-10-03
 */
@RestController
@RequestMapping("/elecmed/monitor")
public class BreathHeartMonitorController extends BaseController
{
    @Autowired
    private IBreathHeartMonitorService breathHeartMonitorService;

//    返回一分钟前的呼吸和心跳相位值
    @GetMapping("/selectoutputFilter")
    @ResponseBody
    public List <Map> selectoutputFilter(HttpServletRequest request){
//        List<Object> outputFilterBreathOut=new ArrayList<>();
//        List<Object> outputFilterHeartOut=new ArrayList<>();
//        for(int i=1;i<breathHeartMonitorService.selectoutputFilter().size();i++){
//            outputFilterBreathOut.add(breathHeartMonitorService.selectoutputFilter().get(i).get("outputFilterBreathOut"));
//            outputFilterHeartOut.add(breathHeartMonitorService.selectoutputFilter().get(i).get("outputFilterHeartOut"));
//        }
//        Map result=new HashMap<>();
//        result.put("outputFilterBreathOut",outputFilterBreathOut);
//        result.put("outputFilterHeartOut",outputFilterHeartOut);
//        return result;
        return breathHeartMonitorService.selectoutputFilter();
    }

//    返回一小时前呼吸和心跳频率值
    @GetMapping("/selectratout")
    @ResponseBody
    public List <Map> selectratout(HttpServletRequest request){
//        List<Object> BreathingRateOut=new ArrayList<>();
//        List<Object> heartRateOut=new ArrayList<>();
//        for(int i=1;i<breathHeartMonitorService.selectratout().size();i++){
//            BreathingRateOut.add(breathHeartMonitorService.selectoutputFilter().get(i).get("BreathingRateOut"));
//            heartRateOut.add(breathHeartMonitorService.selectoutputFilter().get(i).get("heartRateOut"));
//        }
//        Map result=new HashMap<>();
//        result.put("BreathingRate_Out",BreathingRateOut);
//        result.put("heartRate_Out",heartRateOut);
//        return result;
        return breathHeartMonitorService.selectratout();
    }

//    返回最新一条呼吸和心跳频率值
    @GetMapping("/selectratout2")
    @ResponseBody
    public List<Map> selectratout2(HttpServletRequest request){
        return breathHeartMonitorService.selectratout2();
    }

    /**
     * 查询呼吸心跳监测列表
     */
    @PreAuthorize("@ss.hasPermi('elecmed:monitor:list')")
    @GetMapping("/list")
    public TableDataInfo list(BreathHeartMonitor breathHeartMonitor)
    {
        startPage();
        List<BreathHeartMonitor> list = breathHeartMonitorService.selectBreathHeartMonitorList(breathHeartMonitor);
        return getDataTable(list);
    }

    /**
     * 导出呼吸心跳监测列表
     */
    @PreAuthorize("@ss.hasPermi('elecmed:monitor:export')")
    @Log(title = "呼吸心跳监测", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BreathHeartMonitor breathHeartMonitor)
    {
        List<BreathHeartMonitor> list = breathHeartMonitorService.selectBreathHeartMonitorList(breathHeartMonitor);
        ExcelUtil<BreathHeartMonitor> util = new ExcelUtil<BreathHeartMonitor>(BreathHeartMonitor.class);
        util.exportExcel(response, list, "呼吸心跳监测数据");
    }

    /**
     * 获取呼吸心跳监测详细信息
     */
    @PreAuthorize("@ss.hasPermi('elecmed:monitor:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(breathHeartMonitorService.selectBreathHeartMonitorById(id));
    }

    /**
     * 新增呼吸心跳监测
     */
    @PreAuthorize("@ss.hasPermi('elecmed:monitor:add')")
    @Log(title = "呼吸心跳监测", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BreathHeartMonitor breathHeartMonitor)
    {
        return toAjax(breathHeartMonitorService.insertBreathHeartMonitor(breathHeartMonitor));
    }

    /**
     * 新增呼吸心跳监测
     */
//    @PreAuthorize("@ss.hasPermi('elecmed:monitor:add')")
//    @Log(title = "呼吸心跳监测", businessType = BusinessType.INSERT)
//    @PostMapping
    public AjaxResult add2(@RequestBody BreathHeartMonitor breathHeartMonitor)
    {
        return toAjax(breathHeartMonitorService.insertBreathHeartMonitor2(breathHeartMonitor));
    }

    /**
     * 修改呼吸心跳监测
     */
    @PreAuthorize("@ss.hasPermi('elecmed:monitor:edit')")
    @Log(title = "呼吸心跳监测", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BreathHeartMonitor breathHeartMonitor)
    {
        return toAjax(breathHeartMonitorService.updateBreathHeartMonitor(breathHeartMonitor));
    }

    /**
     * 删除呼吸心跳监测
     */
    @PreAuthorize("@ss.hasPermi('elecmed:monitor:remove')")
    @Log(title = "呼吸心跳监测", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(breathHeartMonitorService.deleteBreathHeartMonitorByIds(ids));
    }
}
