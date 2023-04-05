package com.ruoyi.elecmed.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 串口协议对象 darma_agreement
 * 
 * @author zyl
 * @date 2022-10-03
 */
public class DarmaAgreement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 原始数据 */
    @Excel(name = "原始数据")
    private Long rawData;

    /** 心跳波形 */
    @Excel(name = "心跳波形")
    private Long heartbeatWaveform;

    /** 呼吸波形 */
    @Excel(name = "呼吸波形")
    private Long breathWaveform;

    /** 记录id */
    private Long id;

    /** 心率 */
    @Excel(name = "心率")
    private Long heartRat;

    /** 呼吸率 */
    @Excel(name = "呼吸率")
    private Long breathRat;

    /** 信号类型 */
    @Excel(name = "信号类型")
    private Long signType;

    /** 信号质量 */
    @Excel(name = "信号质量")
    private Long signQuality;

    /** 精神压力 */
    @Excel(name = "精神压力")
    private Long mentalStress;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    public void setRawData(Long rawData) 
    {
        this.rawData = rawData;
    }

    public Long getRawData() 
    {
        return rawData;
    }
    public void setHeartbeatWaveform(Long heartbeatWaveform) 
    {
        this.heartbeatWaveform = heartbeatWaveform;
    }

    public Long getHeartbeatWaveform() 
    {
        return heartbeatWaveform;
    }
    public void setBreathWaveform(Long breathWaveform) 
    {
        this.breathWaveform = breathWaveform;
    }

    public Long getBreathWaveform() 
    {
        return breathWaveform;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setHeartRat(Long heartRat) 
    {
        this.heartRat = heartRat;
    }

    public Long getHeartRat() 
    {
        return heartRat;
    }
    public void setBreathRat(Long breathRat) 
    {
        this.breathRat = breathRat;
    }

    public Long getBreathRat() 
    {
        return breathRat;
    }
    public void setSignType(Long signType) 
    {
        this.signType = signType;
    }

    public Long getSignType() 
    {
        return signType;
    }
    public void setSignQuality(Long signQuality) 
    {
        this.signQuality = signQuality;
    }

    public Long getSignQuality() 
    {
        return signQuality;
    }
    public void setMentalStress(Long mentalStress) 
    {
        this.mentalStress = mentalStress;
    }

    public Long getMentalStress() 
    {
        return mentalStress;
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
            .append("rawData", getRawData())
            .append("heartbeatWaveform", getHeartbeatWaveform())
            .append("breathWaveform", getBreathWaveform())
            .append("id", getId())
            .append("heartRat", getHeartRat())
            .append("breathRat", getBreathRat())
            .append("signType", getSignType())
            .append("signQuality", getSignQuality())
            .append("mentalStress", getMentalStress())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("userId", getUserId())
            .toString();
    }
}
