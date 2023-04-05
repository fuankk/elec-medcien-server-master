package com.ruoyi.elecmed.service;

import java.util.List;
import com.ruoyi.elecmed.domain.SleepStatistics;

/**
 * 睡眠统计Service接口
 * 
 * @author zyl
 * @date 2022-10-03
 */
public interface ISleepStatisticsService 
{
    /**
     * 查询睡眠统计
     * 
     * @param id 睡眠统计主键
     * @return 睡眠统计
     */
    public SleepStatistics selectSleepStatisticsById(Long id);

    /**
     * 查询睡眠统计列表
     * 
     * @param sleepStatistics 睡眠统计
     * @return 睡眠统计集合
     */
    public List<SleepStatistics> selectSleepStatisticsList(SleepStatistics sleepStatistics);

    /**
     * 新增睡眠统计
     * 
     * @param sleepStatistics 睡眠统计
     * @return 结果
     */
    public int insertSleepStatistics(SleepStatistics sleepStatistics);

    /**
     * 修改睡眠统计
     * 
     * @param sleepStatistics 睡眠统计
     * @return 结果
     */
    public int updateSleepStatistics(SleepStatistics sleepStatistics);

    /**
     * 批量删除睡眠统计
     * 
     * @param ids 需要删除的睡眠统计主键集合
     * @return 结果
     */
    public int deleteSleepStatisticsByIds(Long[] ids);

    /**
     * 删除睡眠统计信息
     * 
     * @param id 睡眠统计主键
     * @return 结果
     */
    public int deleteSleepStatisticsById(Long id);
}
