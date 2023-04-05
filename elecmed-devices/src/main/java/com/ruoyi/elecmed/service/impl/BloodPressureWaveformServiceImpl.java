package com.ruoyi.elecmed.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.elecmed.mapper.BloodPressureWaveformMapper;
import com.ruoyi.elecmed.domain.BloodPressureWaveform;
import com.ruoyi.elecmed.service.IBloodPressureWaveformService;

/**
 * 血压波形Service业务层处理
 * 
 * @author zyl
 * @date 2022-10-03
 */
@Service
public class BloodPressureWaveformServiceImpl implements IBloodPressureWaveformService 
{
    @Autowired
    private BloodPressureWaveformMapper bloodPressureWaveformMapper;

    /**
     * 查询血压波形
     * 
     * @param id 血压波形主键
     * @return 血压波形
     */
    @Override
    public BloodPressureWaveform selectBloodPressureWaveformById(Long id)
    {
        return bloodPressureWaveformMapper.selectBloodPressureWaveformById(id);
    }

    /**
     * 查询血压波形列表
     * 
     * @param bloodPressureWaveform 血压波形
     * @return 血压波形
     */
    @Override
    public List<BloodPressureWaveform> selectBloodPressureWaveformList(BloodPressureWaveform bloodPressureWaveform)
    {
        return bloodPressureWaveformMapper.selectBloodPressureWaveformList(bloodPressureWaveform);
    }

    /**
     * 新增血压波形
     * 
     * @param bloodPressureWaveform 血压波形
     * @return 结果
     */
    @Override
    public int insertBloodPressureWaveform(BloodPressureWaveform bloodPressureWaveform)
    {
        bloodPressureWaveform.setCreateTime(DateUtils.getNowDate());
        return bloodPressureWaveformMapper.insertBloodPressureWaveform(bloodPressureWaveform);
    }

    /**
     * 修改血压波形
     * 
     * @param bloodPressureWaveform 血压波形
     * @return 结果
     */
    @Override
    public int updateBloodPressureWaveform(BloodPressureWaveform bloodPressureWaveform)
    {
        bloodPressureWaveform.setUpdateTime(DateUtils.getNowDate());
        return bloodPressureWaveformMapper.updateBloodPressureWaveform(bloodPressureWaveform);
    }

    /**
     * 批量删除血压波形
     * 
     * @param ids 需要删除的血压波形主键
     * @return 结果
     */
    @Override
    public int deleteBloodPressureWaveformByIds(Long[] ids)
    {
        return bloodPressureWaveformMapper.deleteBloodPressureWaveformByIds(ids);
    }

    /**
     * 删除血压波形信息
     * 
     * @param id 血压波形主键
     * @return 结果
     */
    @Override
    public int deleteBloodPressureWaveformById(Long id)
    {
        return bloodPressureWaveformMapper.deleteBloodPressureWaveformById(id);
    }
}
