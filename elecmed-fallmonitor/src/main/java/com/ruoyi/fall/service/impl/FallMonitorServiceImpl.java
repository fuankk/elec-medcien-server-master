package com.ruoyi.fall.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.fall.mapper.FallMonitorMapper;
import com.ruoyi.fall.domain.FallMonitor;
import com.ruoyi.fall.service.IFallMonitorService;

/**
 * 跌倒监测Service业务层处理
 * 
 * @author zyl
 * @date 2022-11-29
 */
@Service
public class FallMonitorServiceImpl implements IFallMonitorService 
{
    @Autowired
    private FallMonitorMapper fallMonitorMapper;

    /**
     * 查询跌倒监测
     * 
     * @param id 跌倒监测主键
     * @return 跌倒监测
     */
    @Override
    public FallMonitor selectFallMonitorById(Long id)
    {
        return fallMonitorMapper.selectFallMonitorById(id);
    }

    /**
     * 查询跌倒监测列表
     * 
     * @param fallMonitor 跌倒监测
     * @return 跌倒监测
     */
    @Override
    public List<FallMonitor> selectFallMonitorList(FallMonitor fallMonitor)
    {
        return fallMonitorMapper.selectFallMonitorList(fallMonitor);
    }

    /**
     * 新增跌倒监测
     * 
     * @param fallMonitor 跌倒监测
     * @return 结果
     */
    @Override
    public int insertFallMonitor(FallMonitor fallMonitor)
    {
        return fallMonitorMapper.insertFallMonitor(fallMonitor);
    }

    /**
     * 修改跌倒监测
     * 
     * @param fallMonitor 跌倒监测
     * @return 结果
     */
    @Override
    public int updateFallMonitor(FallMonitor fallMonitor)
    {
        return fallMonitorMapper.updateFallMonitor(fallMonitor);
    }

    /**
     * 批量删除跌倒监测
     * 
     * @param ids 需要删除的跌倒监测主键
     * @return 结果
     */
    @Override
    public int deleteFallMonitorByIds(Long[] ids)
    {
        return fallMonitorMapper.deleteFallMonitorByIds(ids);
    }

    /**
     * 删除跌倒监测信息
     * 
     * @param id 跌倒监测主键
     * @return 结果
     */
    @Override
    public int deleteFallMonitorById(Long id)
    {
        return fallMonitorMapper.deleteFallMonitorById(id);
    }
}
