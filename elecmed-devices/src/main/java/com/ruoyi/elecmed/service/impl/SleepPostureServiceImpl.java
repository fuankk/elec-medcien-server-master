package com.ruoyi.elecmed.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.elecmed.mapper.SleepPostureMapper;
import com.ruoyi.elecmed.domain.SleepPosture;
import com.ruoyi.elecmed.service.ISleepPostureService;

/**
 * 睡眠姿势Service业务层处理
 * 
 * @author zyl
 * @date 2022-10-03
 */
@Service
public class SleepPostureServiceImpl implements ISleepPostureService 
{
    @Autowired
    private SleepPostureMapper sleepPostureMapper;

    /**
     * 查询睡眠姿势
     * 
     * @param id 睡眠姿势主键
     * @return 睡眠姿势
     */
    @Override
    public SleepPosture selectSleepPostureById(Long id)
    {
        return sleepPostureMapper.selectSleepPostureById(id);
    }

    /**
     * 查询睡眠姿势列表
     * 
     * @param sleepPosture 睡眠姿势
     * @return 睡眠姿势
     */
    @Override
    public List<SleepPosture> selectSleepPostureList(SleepPosture sleepPosture)
    {
        return sleepPostureMapper.selectSleepPostureList(sleepPosture);
    }

    /**
     * 新增睡眠姿势
     * 
     * @param sleepPosture 睡眠姿势
     * @return 结果
     */
    @Override
    public int insertSleepPosture(SleepPosture sleepPosture)
    {
        sleepPosture.setCreateTime(DateUtils.getNowDate());
        return sleepPostureMapper.insertSleepPosture(sleepPosture);
    }

    /**
     * 修改睡眠姿势
     * 
     * @param sleepPosture 睡眠姿势
     * @return 结果
     */
    @Override
    public int updateSleepPosture(SleepPosture sleepPosture)
    {
        sleepPosture.setUpdateTime(DateUtils.getNowDate());
        return sleepPostureMapper.updateSleepPosture(sleepPosture);
    }

    /**
     * 批量删除睡眠姿势
     * 
     * @param ids 需要删除的睡眠姿势主键
     * @return 结果
     */
    @Override
    public int deleteSleepPostureByIds(Long[] ids)
    {
        return sleepPostureMapper.deleteSleepPostureByIds(ids);
    }

    /**
     * 删除睡眠姿势信息
     * 
     * @param id 睡眠姿势主键
     * @return 结果
     */
    @Override
    public int deleteSleepPostureById(Long id)
    {
        return sleepPostureMapper.deleteSleepPostureById(id);
    }
}
