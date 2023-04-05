package com.ruoyi.elecmed.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.elecmed.mapper.BreathHeartMonitorMapper;
import com.ruoyi.elecmed.domain.BreathHeartMonitor;
import com.ruoyi.elecmed.service.IBreathHeartMonitorService;

/**
 * 呼吸心跳监测Service业务层处理
 *
 * @author zyl
 * @date 2022-10-03
 */
@Service
public class BreathHeartMonitorServiceImpl implements IBreathHeartMonitorService
{
    @Autowired
    private BreathHeartMonitorMapper breathHeartMonitorMapper;

    //    返回最新一条呼吸和心跳频率值
    @Override
    public List<Map> selectratout2(){
        return breathHeartMonitorMapper.selectratout2();
    }

    //    返回一小时前呼吸和心跳频率值
    @Override
    public List<Map> selectratout(){
        return breathHeartMonitorMapper.selectratout();
    }

//     返回一分钟前的呼吸和心跳相位值
    @Override
    public List<Map> selectoutputFilter(){
        return breathHeartMonitorMapper.selectoutputFilter();
    }

    /**
     * 查询呼吸心跳监测
     *
     * @param id 呼吸心跳监测主键
     * @return 呼吸心跳监测
     */
    @Override
    public BreathHeartMonitor selectBreathHeartMonitorById(Long id)
    {
        return breathHeartMonitorMapper.selectBreathHeartMonitorById(id);
    }

    /**
     * 查询呼吸心跳监测列表
     *
     * @param breathHeartMonitor 呼吸心跳监测
     * @return 呼吸心跳监测
     */
    @Override
    public List<BreathHeartMonitor> selectBreathHeartMonitorList(BreathHeartMonitor breathHeartMonitor)
    {
        return breathHeartMonitorMapper.selectBreathHeartMonitorList(breathHeartMonitor);
    }

    /**
     * 新增呼吸心跳监测
     *
     * @param breathHeartMonitor 呼吸心跳监测
     * @return 结果
     */
    @Override
    public int insertBreathHeartMonitor(BreathHeartMonitor breathHeartMonitor)
    {
        breathHeartMonitor.setCreateTime(DateUtils.getNowDate());
        return breathHeartMonitorMapper.insertBreathHeartMonitor(breathHeartMonitor);
    }

    /**
     * 新增呼吸心跳监测
     *
     * @param breathHeartMonitor 呼吸心跳监测
     * @return 结果
     */
    @Override
    public int insertBreathHeartMonitor2(BreathHeartMonitor breathHeartMonitor)
    {
        breathHeartMonitor.setCreateTime(DateUtils.getNowDate());
        return breathHeartMonitorMapper.insertBreathHeartMonitor2(breathHeartMonitor);
    }

    /**
     * 修改呼吸心跳监测
     *
     * @param breathHeartMonitor 呼吸心跳监测
     * @return 结果
     */
    @Override
    public int updateBreathHeartMonitor(BreathHeartMonitor breathHeartMonitor)
    {
        breathHeartMonitor.setUpdateTime(DateUtils.getNowDate());
        return breathHeartMonitorMapper.updateBreathHeartMonitor(breathHeartMonitor);
    }

    /**
     * 批量删除呼吸心跳监测
     *
     * @param ids 需要删除的呼吸心跳监测主键
     * @return 结果
     */
    @Override
    public int deleteBreathHeartMonitorByIds(Long[] ids)
    {
        return breathHeartMonitorMapper.deleteBreathHeartMonitorByIds(ids);
    }

    /**
     * 删除呼吸心跳监测信息
     *
     * @param id 呼吸心跳监测主键
     * @return 结果
     */
    @Override
    public int deleteBreathHeartMonitorById(Long id)
    {
        return breathHeartMonitorMapper.deleteBreathHeartMonitorById(id);
    }
}
