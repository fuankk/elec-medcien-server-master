package com.ruoyi.elecmed.mapper;

import java.util.List;
import com.ruoyi.elecmed.domain.FallAlarm;

/**
 * 跌倒警报Mapper接口
 * 
 * @author zyl
 * @date 2022-10-03
 */
public interface FallAlarmMapper 
{
    /**
     * 查询跌倒警报
     * 
     * @param id 跌倒警报主键
     * @return 跌倒警报
     */
    public FallAlarm selectFallAlarmById(Long id);

    /**
     * 查询跌倒警报列表
     * 
     * @param fallAlarm 跌倒警报
     * @return 跌倒警报集合
     */
    public List<FallAlarm> selectFallAlarmList(FallAlarm fallAlarm);

    /**
     * 新增跌倒警报
     * 
     * @param fallAlarm 跌倒警报
     * @return 结果
     */
    public int insertFallAlarm(FallAlarm fallAlarm);

    /**
     * 修改跌倒警报
     * 
     * @param fallAlarm 跌倒警报
     * @return 结果
     */
    public int updateFallAlarm(FallAlarm fallAlarm);

    /**
     * 删除跌倒警报
     * 
     * @param id 跌倒警报主键
     * @return 结果
     */
    public int deleteFallAlarmById(Long id);

    /**
     * 批量删除跌倒警报
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFallAlarmByIds(Long[] ids);
}
