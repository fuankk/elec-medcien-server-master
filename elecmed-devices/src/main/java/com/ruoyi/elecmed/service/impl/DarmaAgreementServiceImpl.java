package com.ruoyi.elecmed.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.elecmed.mapper.DarmaAgreementMapper;
import com.ruoyi.elecmed.domain.DarmaAgreement;
import com.ruoyi.elecmed.service.IDarmaAgreementService;

/**
 * 串口协议Service业务层处理
 *
 * @author zyl
 * @date 2022-10-03
 */
@Service
public class DarmaAgreementServiceImpl implements IDarmaAgreementService
{
    @Autowired
    private DarmaAgreementMapper darmaAgreementMapper;

    //    返回最新一条心跳和呼吸数据
    @Override
    public List<Map> selectwaveform3(){
        return darmaAgreementMapper.selectwaveform3();
    }

    //    返回一小时前的心跳和呼吸波形
    @Override
    public List<Map> selectwaveform2(){
        return darmaAgreementMapper.selectwaveform2();
    }

//   查询一分钟前心跳和呼吸波形
    @Override
    public List<Map> selectwaveform(){
        return darmaAgreementMapper.selectwaveform();
    }

    //    返回最新一条userID2心跳和呼吸数据
    @Override
    public List<Map> selectwaveform6(){
        return darmaAgreementMapper.selectwaveform6();
    }

    //    返回一小时前userID2的心跳和呼吸波形
    @Override
    public List<Map> selectwaveform5(){
        return darmaAgreementMapper.selectwaveform5();
    }

    //   查询一分钟前userID2心跳和呼吸波形
    @Override
    public List<Map> selectwaveform4(){
        return darmaAgreementMapper.selectwaveform4();
    }

    //  串口协议部分信息查询
    @Override
    public List<Map> selectagreement(String heartbeatWaveform, String breathWaveform, String heartRat, String breathRat, String createTime,String highPressure,String lowPressure,
                                     String outputFilterBreathOut,String outputFilterHeartOut){
        return darmaAgreementMapper.selectagreement(heartbeatWaveform,breathWaveform,heartRat,breathRat,createTime,highPressure,lowPressure,outputFilterBreathOut,outputFilterHeartOut);
    }

    /**
     * 查询串口协议
     *
     * @param id 串口协议主键
     * @return 串口协议
     */
    @Override
    public DarmaAgreement selectDarmaAgreementById(Long id)
    {
        return darmaAgreementMapper.selectDarmaAgreementById(id);
    }

    /**
     * 查询串口协议列表
     *
     * @param darmaAgreement 串口协议
     * @return 串口协议
     */
    @Override
    public List<DarmaAgreement> selectDarmaAgreementList(DarmaAgreement darmaAgreement)
    {
        return darmaAgreementMapper.selectDarmaAgreementList(darmaAgreement);
    }

    /**
     * 新增串口协议
     *
     * @param darmaAgreement 串口协议
     * @return 结果
     */
    @Override
    public int insertDarmaAgreement(DarmaAgreement darmaAgreement)
    {
        darmaAgreement.setCreateTime(DateUtils.getNowDate());
        return darmaAgreementMapper.insertDarmaAgreement(darmaAgreement);
    }

    /**
     * 修改串口协议
     *
     * @param darmaAgreement 串口协议
     * @return 结果
     */
    @Override
    public int updateDarmaAgreement(DarmaAgreement darmaAgreement)
    {
        darmaAgreement.setUpdateTime(DateUtils.getNowDate());
        return darmaAgreementMapper.updateDarmaAgreement(darmaAgreement);
    }

    /**
     * 批量删除串口协议
     *
     * @param ids 需要删除的串口协议主键
     * @return 结果
     */
    @Override
    public int deleteDarmaAgreementByIds(Long[] ids)
    {
        return darmaAgreementMapper.deleteDarmaAgreementByIds(ids);
    }

    /**
     * 删除串口协议信息
     *
     * @param id 串口协议主键
     * @return 结果
     */
    @Override
    public int deleteDarmaAgreementById(Long id)
    {
        return darmaAgreementMapper.deleteDarmaAgreementById(id);
    }
}
