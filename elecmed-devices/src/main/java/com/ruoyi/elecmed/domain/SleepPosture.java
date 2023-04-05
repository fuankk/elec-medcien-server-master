package com.ruoyi.elecmed.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 睡眠姿势对象 sleep_posture
 * 
 * @author zyl
 * @date 2022-10-03
 */
public class SleepPosture extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 记录id */
    private Long id;

    /** 姿势 */
    @Excel(name = "姿势")
    private String posture;

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 持续时间 */
    @Excel(name = "持续时间")
    private String lastingTime;

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPosture(String posture) 
    {
        this.posture = posture;
    }

    public String getPosture() 
    {
        return posture;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setLastingTime(String lastingTime) 
    {
        this.lastingTime = lastingTime;
    }

    public String getLastingTime() 
    {
        return lastingTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("id", getId())
            .append("posture", getPosture())
            .append("time", getTime())
            .append("lastingTime", getLastingTime())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
