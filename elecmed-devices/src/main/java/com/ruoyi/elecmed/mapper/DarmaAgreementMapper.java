package com.ruoyi.elecmed.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.elecmed.domain.DarmaAgreement;
import org.apache.ibatis.annotations.Param;

/**
 * 串口协议Mapper接口
 * 
 * @author zyl
 * @date 2022-10-03
 */
public interface DarmaAgreementMapper 
{

    //    返回最新一条心跳和呼吸数据
    public List<Map> selectwaveform3();

//    返回一小时前的心跳和呼吸波形
    public List<Map> selectwaveform2();

// 查询一分钟前心跳和呼吸波形
    public List<Map> selectwaveform();

    //    返回最新一条userID2心跳和呼吸数据
    public List<Map> selectwaveform6();

    //    返回一小时前userID2的心跳和呼吸波形
    public List<Map> selectwaveform5();

    // 查询一分钟前userID2心跳和呼吸波形
    public List<Map> selectwaveform4();

    //    串口协议部分信息查询
    public List<Map> selectagreement(@Param("heartbeatWaveform") String heartbeatWaveform, @Param("breathWaveform") String breathWaveform,
                                     @Param("heartRat") String heartRat, @Param("breathRat") String breathRat, @Param("createTime") String createTime,
                                     @Param("highPressure") String highPressure,@Param("lowPressure") String lowPressure,@Param("outputFilterBreathOut")
                                     String outputFilterBreathOut,@Param("outputFilterHeartOut") String outputFilterHeartOut);

    /**
     * 查询串口协议
     * 
     * @param id 串口协议主键
     * @return 串口协议
     */
    public DarmaAgreement selectDarmaAgreementById(Long id);

    /**
     * 查询串口协议列表
     * 
     * @param darmaAgreement 串口协议
     * @return 串口协议集合
     */
    public List<DarmaAgreement> selectDarmaAgreementList(DarmaAgreement darmaAgreement);

    /**
     * 新增串口协议
     * 
     * @param darmaAgreement 串口协议
     * @return 结果
     */
    public int insertDarmaAgreement(DarmaAgreement darmaAgreement);

    /**
     * 修改串口协议
     * 
     * @param darmaAgreement 串口协议
     * @return 结果
     */
    public int updateDarmaAgreement(DarmaAgreement darmaAgreement);

    /**
     * 删除串口协议
     * 
     * @param id 串口协议主键
     * @return 结果
     */
    public int deleteDarmaAgreementById(Long id);

    /**
     * 批量删除串口协议
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDarmaAgreementByIds(Long[] ids);
}
