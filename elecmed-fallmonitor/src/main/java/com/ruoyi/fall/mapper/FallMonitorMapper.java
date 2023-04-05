package com.ruoyi.fall.mapper;

import java.util.List;
import com.ruoyi.fall.domain.FallMonitor;

/**
 * 跌倒监测Mapper接口
 * 
 * @author zyl
 * @date 2022-11-29
 */
public interface FallMonitorMapper 
{
    /**
     * 查询跌倒监测
     * 
     * @param id 跌倒监测主键
     * @return 跌倒监测
     */
    public FallMonitor selectFallMonitorById(Long id);

    /**
     * 查询跌倒监测列表
     * 
     * @param fallMonitor 跌倒监测
     * @return 跌倒监测集合
     */
    public List<FallMonitor> selectFallMonitorList(FallMonitor fallMonitor);

    /**
     * 新增跌倒监测
     * 
     * @param fallMonitor 跌倒监测
     * @return 结果
     */
    public int insertFallMonitor(FallMonitor fallMonitor);

    /**
     * 修改跌倒监测
     * 
     * @param fallMonitor 跌倒监测
     * @return 结果
     */
    public int updateFallMonitor(FallMonitor fallMonitor);

    /**
     * 删除跌倒监测
     * 
     * @param id 跌倒监测主键
     * @return 结果
     */
    public int deleteFallMonitorById(Long id);

    /**
     * 批量删除跌倒监测
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFallMonitorByIds(Long[] ids);
}
