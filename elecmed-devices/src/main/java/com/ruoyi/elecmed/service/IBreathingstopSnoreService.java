package com.ruoyi.elecmed.service;

import java.util.List;
import com.ruoyi.elecmed.domain.BreathingstopSnore;

/**
 * 呼吸暂停打鼾Service接口
 * 
 * @author zyl
 * @date 2022-10-03
 */
public interface IBreathingstopSnoreService 
{
    /**
     * 查询呼吸暂停打鼾
     * 
     * @param id 呼吸暂停打鼾主键
     * @return 呼吸暂停打鼾
     */
    public BreathingstopSnore selectBreathingstopSnoreById(Long id);

    /**
     * 查询呼吸暂停打鼾列表
     * 
     * @param breathingstopSnore 呼吸暂停打鼾
     * @return 呼吸暂停打鼾集合
     */
    public List<BreathingstopSnore> selectBreathingstopSnoreList(BreathingstopSnore breathingstopSnore);

    /**
     * 新增呼吸暂停打鼾
     * 
     * @param breathingstopSnore 呼吸暂停打鼾
     * @return 结果
     */
    public int insertBreathingstopSnore(BreathingstopSnore breathingstopSnore);

    /**
     * 修改呼吸暂停打鼾
     * 
     * @param breathingstopSnore 呼吸暂停打鼾
     * @return 结果
     */
    public int updateBreathingstopSnore(BreathingstopSnore breathingstopSnore);

    /**
     * 批量删除呼吸暂停打鼾
     * 
     * @param ids 需要删除的呼吸暂停打鼾主键集合
     * @return 结果
     */
    public int deleteBreathingstopSnoreByIds(Long[] ids);

    /**
     * 删除呼吸暂停打鼾信息
     * 
     * @param id 呼吸暂停打鼾主键
     * @return 结果
     */
    public int deleteBreathingstopSnoreById(Long id);
}
