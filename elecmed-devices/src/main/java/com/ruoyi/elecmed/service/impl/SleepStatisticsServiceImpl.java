package com.ruoyi.elecmed.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.elecmed.mapper.SleepStatisticsMapper;
import com.ruoyi.elecmed.domain.SleepStatistics;
import com.ruoyi.elecmed.service.ISleepStatisticsService;

/**
 * 睡眠统计Service业务层处理
 * 
 * @author zyl
 * @date 2022-10-03
 */
@Service
public class SleepStatisticsServiceImpl implements ISleepStatisticsService 
{
    @Autowired
    private SleepStatisticsMapper sleepStatisticsMapper;

    /**
     * 查询睡眠统计
     * 
     * @param id 睡眠统计主键
     * @return 睡眠统计
     */
    @Override
    public SleepStatistics selectSleepStatisticsById(Long id)
    {
        return sleepStatisticsMapper.selectSleepStatisticsById(id);
    }

    /**
     * 查询睡眠统计列表
     * 
     * @param sleepStatistics 睡眠统计
     * @return 睡眠统计
     */
    @Override
    public List<SleepStatistics> selectSleepStatisticsList(SleepStatistics sleepStatistics)
    {
        return sleepStatisticsMapper.selectSleepStatisticsList(sleepStatistics);
    }

    /**
     * 新增睡眠统计
     * 
     * @param sleepStatistics 睡眠统计
     * @return 结果
     */
    @Override
    public int insertSleepStatistics(SleepStatistics sleepStatistics)
    {
        sleepStatistics.setCreateTime(DateUtils.getNowDate());
        return sleepStatisticsMapper.insertSleepStatistics(sleepStatistics);
    }

    /**
     * 修改睡眠统计
     * 
     * @param sleepStatistics 睡眠统计
     * @return 结果
     */
    @Override
    public int updateSleepStatistics(SleepStatistics sleepStatistics)
    {
        sleepStatistics.setUpdateTime(DateUtils.getNowDate());
        return sleepStatisticsMapper.updateSleepStatistics(sleepStatistics);
    }

    /**
     * 批量删除睡眠统计
     * 
     * @param ids 需要删除的睡眠统计主键
     * @return 结果
     */
    @Override
    public int deleteSleepStatisticsByIds(Long[] ids)
    {
        return sleepStatisticsMapper.deleteSleepStatisticsByIds(ids);
    }

    /**
     * 删除睡眠统计信息
     * 
     * @param id 睡眠统计主键
     * @return 结果
     */
    @Override
    public int deleteSleepStatisticsById(Long id)
    {
        return sleepStatisticsMapper.deleteSleepStatisticsById(id);
    }
}
