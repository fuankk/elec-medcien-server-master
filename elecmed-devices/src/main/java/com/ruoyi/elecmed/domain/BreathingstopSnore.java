package com.ruoyi.elecmed.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 呼吸暂停打鼾对象 breathingstop_snore
 * 
 * @author zyl
 * @date 2022-10-03
 */
public class BreathingstopSnore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录id */
    private Long id;

    /** 报警信息 */
    @Excel(name = "报警信息")
    private String alarmInfo;

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 紧急程度 */
    @Excel(name = "紧急程度")
    private String urgency;

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
    public void setAlarmInfo(String alarmInfo) 
    {
        this.alarmInfo = alarmInfo;
    }

    public String getAlarmInfo() 
    {
        return alarmInfo;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setUrgency(String urgency) 
    {
        this.urgency = urgency;
    }

    public String getUrgency() 
    {
        return urgency;
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
            .append("alarmInfo", getAlarmInfo())
            .append("time", getTime())
            .append("urgency", getUrgency())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("userId", getUserId())
            .toString();
    }
}
