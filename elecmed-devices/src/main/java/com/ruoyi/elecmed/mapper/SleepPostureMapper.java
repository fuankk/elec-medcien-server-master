package com.ruoyi.elecmed.mapper;

import java.util.List;
import com.ruoyi.elecmed.domain.SleepPosture;

/**
 * 睡眠姿势Mapper接口
 * 
 * @author zyl
 * @date 2022-10-03
 */
public interface SleepPostureMapper 
{
    /**
     * 查询睡眠姿势
     * 
     * @param id 睡眠姿势主键
     * @return 睡眠姿势
     */
    public SleepPosture selectSleepPostureById(Long id);

    /**
     * 查询睡眠姿势列表
     * 
     * @param sleepPosture 睡眠姿势
     * @return 睡眠姿势集合
     */
    public List<SleepPosture> selectSleepPostureList(SleepPosture sleepPosture);

    /**
     * 新增睡眠姿势
     * 
     * @param sleepPosture 睡眠姿势
     * @return 结果
     */
    public int insertSleepPosture(SleepPosture sleepPosture);

    /**
     * 修改睡眠姿势
     * 
     * @param sleepPosture 睡眠姿势
     * @return 结果
     */
    public int updateSleepPosture(SleepPosture sleepPosture);

    /**
     * 删除睡眠姿势
     * 
     * @param id 睡眠姿势主键
     * @return 结果
     */
    public int deleteSleepPostureById(Long id);

    /**
     * 批量删除睡眠姿势
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSleepPostureByIds(Long[] ids);
}
