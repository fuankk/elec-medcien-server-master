package com.ruoyi.elecmed.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.elecmed.domain.BreathHeartMonitor;

/**
 * 呼吸心跳监测Mapper接口
 *
 * @author zyl
 * @date 2022-10-03
 */
public interface BreathHeartMonitorMapper
{

    //    返回最新一条呼吸和心跳频率值
    public List<Map> selectratout2();

    //    返回一小时前呼吸和心跳频率值
    public List<Map> selectratout();

//   返回一分钟前的呼吸和心跳相位值
    public List<Map> selectoutputFilter();

    /**
     * 查询呼吸心跳监测
     *
     * @param id 呼吸心跳监测主键
     * @return 呼吸心跳监测
     */
    public BreathHeartMonitor selectBreathHeartMonitorById(Long id);

    /**
     * 查询呼吸心跳监测列表
     *
     * @param breathHeartMonitor 呼吸心跳监测
     * @return 呼吸心跳监测集合
     */
    public List<BreathHeartMonitor> selectBreathHeartMonitorList(BreathHeartMonitor breathHeartMonitor);

    /**
     * 新增呼吸心跳监测
     *
     * @param breathHeartMonitor 呼吸心跳监测
     * @return 结果
     */
    public int insertBreathHeartMonitor(BreathHeartMonitor breathHeartMonitor);

    /**
     * 新增呼吸心跳监测
     *
     * @param breathHeartMonitor 呼吸心跳监测
     * @return 结果
     */
    public int insertBreathHeartMonitor2(BreathHeartMonitor breathHeartMonitor);

    /**
     * 修改呼吸心跳监测
     *
     * @param breathHeartMonitor 呼吸心跳监测
     * @return 结果
     */
    public int updateBreathHeartMonitor(BreathHeartMonitor breathHeartMonitor);

    /**
     * 删除呼吸心跳监测
     *
     * @param id 呼吸心跳监测主键
     * @return 结果
     */
    public int deleteBreathHeartMonitorById(Long id);

    /**
     * 批量删除呼吸心跳监测
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBreathHeartMonitorByIds(Long[] ids);
}
