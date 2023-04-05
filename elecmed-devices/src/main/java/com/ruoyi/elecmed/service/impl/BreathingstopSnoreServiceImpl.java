package com.ruoyi.elecmed.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.elecmed.mapper.BreathingstopSnoreMapper;
import com.ruoyi.elecmed.domain.BreathingstopSnore;
import com.ruoyi.elecmed.service.IBreathingstopSnoreService;

/**
 * 呼吸暂停打鼾Service业务层处理
 * 
 * @author zyl
 * @date 2022-10-03
 */
@Service
public class BreathingstopSnoreServiceImpl implements IBreathingstopSnoreService 
{
    @Autowired
    private BreathingstopSnoreMapper breathingstopSnoreMapper;

    /**
     * 查询呼吸暂停打鼾
     * 
     * @param id 呼吸暂停打鼾主键
     * @return 呼吸暂停打鼾
     */
    @Override
    public BreathingstopSnore selectBreathingstopSnoreById(Long id)
    {
        return breathingstopSnoreMapper.selectBreathingstopSnoreById(id);
    }

    /**
     * 查询呼吸暂停打鼾列表
     * 
     * @param breathingstopSnore 呼吸暂停打鼾
     * @return 呼吸暂停打鼾
     */
    @Override
    public List<BreathingstopSnore> selectBreathingstopSnoreList(BreathingstopSnore breathingstopSnore)
    {
        return breathingstopSnoreMapper.selectBreathingstopSnoreList(breathingstopSnore);
    }

    /**
     * 新增呼吸暂停打鼾
     * 
     * @param breathingstopSnore 呼吸暂停打鼾
     * @return 结果
     */
    @Override
    public int insertBreathingstopSnore(BreathingstopSnore breathingstopSnore)
    {
        breathingstopSnore.setCreateTime(DateUtils.getNowDate());
        return breathingstopSnoreMapper.insertBreathingstopSnore(breathingstopSnore);
    }

    /**
     * 修改呼吸暂停打鼾
     * 
     * @param breathingstopSnore 呼吸暂停打鼾
     * @return 结果
     */
    @Override
    public int updateBreathingstopSnore(BreathingstopSnore breathingstopSnore)
    {
        breathingstopSnore.setUpdateTime(DateUtils.getNowDate());
        return breathingstopSnoreMapper.updateBreathingstopSnore(breathingstopSnore);
    }

    /**
     * 批量删除呼吸暂停打鼾
     * 
     * @param ids 需要删除的呼吸暂停打鼾主键
     * @return 结果
     */
    @Override
    public int deleteBreathingstopSnoreByIds(Long[] ids)
    {
        return breathingstopSnoreMapper.deleteBreathingstopSnoreByIds(ids);
    }

    /**
     * 删除呼吸暂停打鼾信息
     * 
     * @param id 呼吸暂停打鼾主键
     * @return 结果
     */
    @Override
    public int deleteBreathingstopSnoreById(Long id)
    {
        return breathingstopSnoreMapper.deleteBreathingstopSnoreById(id);
    }
}
