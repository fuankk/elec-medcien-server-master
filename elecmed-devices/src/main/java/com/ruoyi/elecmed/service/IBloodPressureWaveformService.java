package com.ruoyi.elecmed.service;

import java.util.List;
import com.ruoyi.elecmed.domain.BloodPressureWaveform;

/**
 * 血压波形Service接口
 * 
 * @author zyl
 * @date 2022-10-03
 */
public interface IBloodPressureWaveformService 
{
    /**
     * 查询血压波形
     * 
     * @param id 血压波形主键
     * @return 血压波形
     */
    public BloodPressureWaveform selectBloodPressureWaveformById(Long id);

    /**
     * 查询血压波形列表
     * 
     * @param bloodPressureWaveform 血压波形
     * @return 血压波形集合
     */
    public List<BloodPressureWaveform> selectBloodPressureWaveformList(BloodPressureWaveform bloodPressureWaveform);

    /**
     * 新增血压波形
     * 
     * @param bloodPressureWaveform 血压波形
     * @return 结果
     */
    public int insertBloodPressureWaveform(BloodPressureWaveform bloodPressureWaveform);

    /**
     * 修改血压波形
     * 
     * @param bloodPressureWaveform 血压波形
     * @return 结果
     */
    public int updateBloodPressureWaveform(BloodPressureWaveform bloodPressureWaveform);

    /**
     * 批量删除血压波形
     * 
     * @param ids 需要删除的血压波形主键集合
     * @return 结果
     */
    public int deleteBloodPressureWaveformByIds(Long[] ids);

    /**
     * 删除血压波形信息
     * 
     * @param id 血压波形主键
     * @return 结果
     */
    public int deleteBloodPressureWaveformById(Long id);
}
