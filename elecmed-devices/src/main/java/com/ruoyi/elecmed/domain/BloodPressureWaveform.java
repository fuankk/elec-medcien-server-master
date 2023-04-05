package com.ruoyi.elecmed.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 血压波形对象 blood_pressure_waveform
 * 
 * @author zyl
 * @date 2022-10-03
 */
public class BloodPressureWaveform extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录id */
    private Long id;

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 高压 */
    @Excel(name = "高压")
    private Long highPressure;

    /** 低压 */
    @Excel(name = "低压")
    private Long lowPressure;

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
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setHighPressure(Long highPressure) 
    {
        this.highPressure = highPressure;
    }

    public Long getHighPressure() 
    {
        return highPressure;
    }
    public void setLowPressure(Long lowPressure) 
    {
        this.lowPressure = lowPressure;
    }

    public Long getLowPressure() 
    {
        return lowPressure;
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
            .append("time", getTime())
            .append("highPressure", getHighPressure())
            .append("lowPressure", getLowPressure())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("userId", getUserId())
            .toString();
    }
}
