package com.ruoyi.elecmed.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.elecmed.mapper.FallAlarmMapper;
import com.ruoyi.elecmed.domain.FallAlarm;
import com.ruoyi.elecmed.service.IFallAlarmService;

/**
 * 跌倒警报Service业务层处理
 * 
 * @author zyl
 * @date 2022-10-03
 */
@Service
public class FallAlarmServiceImpl implements IFallAlarmService 
{
    @Autowired
    private FallAlarmMapper fallAlarmMapper;

    /**
     * 查询跌倒警报
     * 
     * @param id 跌倒警报主键
     * @return 跌倒警报
     */
    @Override
    public FallAlarm selectFallAlarmById(Long id)
    {
        return fallAlarmMapper.selectFallAlarmById(id);
    }

    /**
     * 查询跌倒警报列表
     * 
     * @param fallAlarm 跌倒警报
     * @return 跌倒警报
     */
    @Override
    public List<FallAlarm> selectFallAlarmList(FallAlarm fallAlarm)
    {
        return fallAlarmMapper.selectFallAlarmList(fallAlarm);
    }

    /**
     * 新增跌倒警报
     * 
     * @param fallAlarm 跌倒警报
     * @return 结果
     */
    @Override
    public int insertFallAlarm(FallAlarm fallAlarm)
    {
        fallAlarm.setCreateTime(DateUtils.getNowDate());
        return fallAlarmMapper.insertFallAlarm(fallAlarm);
    }

    /**
     * 修改跌倒警报
     * 
     * @param fallAlarm 跌倒警报
     * @return 结果
     */
    @Override
    public int updateFallAlarm(FallAlarm fallAlarm)
    {
        fallAlarm.setUpdateTime(DateUtils.getNowDate());
        return fallAlarmMapper.updateFallAlarm(fallAlarm);
    }

    /**
     * 批量删除跌倒警报
     * 
     * @param ids 需要删除的跌倒警报主键
     * @return 结果
     */
    @Override
    public int deleteFallAlarmByIds(Long[] ids)
    {
        return fallAlarmMapper.deleteFallAlarmByIds(ids);
    }

    /**
     * 删除跌倒警报信息
     * 
     * @param id 跌倒警报主键
     * @return 结果
     */
    @Override
    public int deleteFallAlarmById(Long id)
    {
        return fallAlarmMapper.deleteFallAlarmById(id);
    }
}
