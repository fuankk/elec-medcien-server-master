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
import com.ruoyi.elecmed.domain.DarmaAgreement;
import com.ruoyi.elecmed.service.IDarmaAgreementService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 串口协议Controller
 *
 * @author zyl
 * @date 2022-10-03
 */
@RestController
@RequestMapping("/elecmed/agreement")
public class DarmaAgreementController extends BaseController
{
    @Autowired
    private IDarmaAgreementService darmaAgreementService;

    //    串口协议部分信息查询
    @GetMapping("/selectagreement")
    @ResponseBody
    public List<Map> selectagreement(HttpServletRequest request){
        String heartbeatWaveform=request.getParameter("heartbeatWaveform");
        String breathWaveform=request.getParameter("breathWaveform");
        String heartRat=request.getParameter("heartRat");
        String breathRat=request.getParameter("breathRat");
        String createTime=request.getParameter("createTime");
        String highPressure=request.getParameter("highPressure");
        String lowPressure=request.getParameter("lowPressure");
        String outputFilterBreathOut=request.getParameter("outputFilterBreathOut");
        String outputFilterHeartOut=request.getParameter("outputFilterHeartOut");
        return darmaAgreementService.selectagreement(heartbeatWaveform,breathWaveform,heartRat,breathRat,createTime,highPressure,lowPressure,outputFilterBreathOut,
                outputFilterHeartOut);
    }

    //返回一分钟之前的心跳波形和呼吸波形数据
    @GetMapping("/selectwaveform")
    @ResponseBody
    public Map selectwaveform(HttpServletRequest request){
        List<Object> heartbeatWaveform = new ArrayList<>();
        List<Object> breathWaveform = new ArrayList<>();
        for (int i = 0;i<darmaAgreementService.selectwaveform().size();i++){
            heartbeatWaveform.add(darmaAgreementService.selectwaveform().get(i).get("heartbeatWaveform"));
            breathWaveform.add(darmaAgreementService.selectwaveform().get(i).get("breathWaveform"));
        }
        Map result = new HashMap<>();
        result.put("heartbeatWaveform",heartbeatWaveform);
        result.put("breathWaveform",breathWaveform);
//        return darmaAgreementService.selectwaveform();
        return result;
    }

    //返回一分钟之前的userID2心跳波形和呼吸波形数据
    @GetMapping("/selectwaveform4")
    @ResponseBody
    public Map selectwaveform4(HttpServletRequest request){
        List<Object> heartbeatWaveform = new ArrayList<>();
        List<Object> breathWaveform = new ArrayList<>();
        for (int i = 0;i<darmaAgreementService.selectwaveform4().size();i++){
            heartbeatWaveform.add(darmaAgreementService.selectwaveform4().get(i).get("heartbeatWaveform"));
            breathWaveform.add(darmaAgreementService.selectwaveform4().get(i).get("breathWaveform"));
        }
        Map result = new HashMap<>();
        result.put("heartbeatWaveform",heartbeatWaveform);
        result.put("breathWaveform",breathWaveform);
//        return darmaAgreementService.selectwaveform();
        return result;
    }

//    返回一小时前的心跳和呼吸波形
    @GetMapping("/selectwaveform2")
    @ResponseBody
    public List<Map> selectwaveform2(HttpServletRequest request){
        return darmaAgreementService.selectwaveform2();
    }

//    返回一小时前userID2的心跳和呼吸波形
    @GetMapping("/selectwaveform5")
    @ResponseBody
    public List<Map> selectwaveform5(HttpServletRequest request){
        return darmaAgreementService.selectwaveform5();
    }

//    返回最新一条心跳和呼吸数据
    @GetMapping("/selectwaveform3")
    @ResponseBody
    public List<Map> selectwaveform3(HttpServletRequest request){
        return  darmaAgreementService.selectwaveform3();
    }

    //    返回最新一条userID2心跳和呼吸数据
    @GetMapping("/selectwaveform6")
    @ResponseBody
    public List<Map> selectwaveform6(HttpServletRequest request){
        return  darmaAgreementService.selectwaveform6();
    }

    /**
     * 查询串口协议列表
     */
    @PreAuthorize("@ss.hasPermi('elecmed:agreement:list')")
    @GetMapping("/list")
    public TableDataInfo list(DarmaAgreement darmaAgreement)
    {
        startPage();
        List<DarmaAgreement> list = darmaAgreementService.selectDarmaAgreementList(darmaAgreement);
        return getDataTable(list);
    }

    /**
     * 导出串口协议列表
     */
    @PreAuthorize("@ss.hasPermi('elecmed:agreement:export')")
    @Log(title = "串口协议", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DarmaAgreement darmaAgreement)
    {
        List<DarmaAgreement> list = darmaAgreementService.selectDarmaAgreementList(darmaAgreement);
        ExcelUtil<DarmaAgreement> util = new ExcelUtil<DarmaAgreement>(DarmaAgreement.class);
        util.exportExcel(response, list, "串口协议数据");
    }

    /**
     * 获取串口协议详细信息
     */
    @PreAuthorize("@ss.hasPermi('elecmed:agreement:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(darmaAgreementService.selectDarmaAgreementById(id));
    }

    /**
     * 新增串口协议
     */
//    @PreAuthorize("@ss.hasPermi('elecmed:agreement:add')")
//    @Log(title = "串口协议", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DarmaAgreement darmaAgreement)
    {
        return toAjax(darmaAgreementService.insertDarmaAgreement(darmaAgreement));
    }

    /**
     * 新增darma数据，采用get请求
     */
    @GetMapping("/insert")
    public AjaxResult insert(@RequestBody DarmaAgreement darmaAgreement)
    {
        return toAjax(darmaAgreementService.insertDarmaAgreement(darmaAgreement));
    }

    /**
     * 修改串口协议
     */
    @PreAuthorize("@ss.hasPermi('elecmed:agreement:edit')")
    @Log(title = "串口协议", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DarmaAgreement darmaAgreement)
    {
        return toAjax(darmaAgreementService.updateDarmaAgreement(darmaAgreement));
    }

    /**
     * 删除串口协议
     */
    @PreAuthorize("@ss.hasPermi('elecmed:agreement:remove')")
    @Log(title = "串口协议", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(darmaAgreementService.deleteDarmaAgreementByIds(ids));
    }
}
