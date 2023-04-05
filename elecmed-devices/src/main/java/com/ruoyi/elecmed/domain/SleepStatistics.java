package com.ruoyi.elecmed.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 睡眠统计对象 sleep_statistics
 * 
 * @author zyl
 * @date 2022-10-03
 */
public class SleepStatistics extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录id */
    private Long id;

    /** 深睡比例 */
    @Excel(name = "深睡比例")
    private Long deepSleep;

    /** 浅睡比例 */
    @Excel(name = "浅睡比例")
    private Long shallowSleep;

    /** 睡眠时间 */
    @Excel(name = "睡眠时间")
    private Long sleepTime;

    /** 呼吸质量 */
    @Excel(name = "呼吸质量")
    private Long breathQuality;

    /** 清醒次数 */
    @Excel(name = "清醒次数")
    private String wakeTimes;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeepSleep(Long deepSleep) 
    {
        this.deepSleep = deepSleep;
    }

    public Long getDeepSleep() 
    {
        return deepSleep;
    }
    public void setShallowSleep(Long shallowSleep) 
    {
        this.shallowSleep = shallowSleep;
    }

    public Long getShallowSleep() 
    {
        return shallowSleep;
    }
    public void setSleepTime(Long sleepTime) 
    {
        this.sleepTime = sleepTime;
    }

    public Long getSleepTime() 
    {
        return sleepTime;
    }
    public void setBreathQuality(Long breathQuality) 
    {
        this.breathQuality = breathQuality;
    }

    public Long getBreathQuality() 
    {
        return breathQuality;
    }
    public void setWakeTimes(String wakeTimes) 
    {
        this.wakeTimes = wakeTimes;
    }

    public String getWakeTimes() 
    {
        return wakeTimes;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deepSleep", getDeepSleep())
            .append("shallowSleep", getShallowSleep())
            .append("sleepTime", getSleepTime())
            .append("breathQuality", getBreathQuality())
            .append("wakeTimes", getWakeTimes())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .toString();
    }
}
