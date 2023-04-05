package com.ruoyi.fall.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 跌倒监测对象 fall_monitor
 * 
 * @author zyl
 * @date 2022-11-29
 */
public class FallMonitor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录id */
    private Long id;

    /** 设备号 */
    @Excel(name = "设备号")
    private Long deviceId;

    /** 时间戳 */
    @Excel(name = "时间戳")
    private Long time;

    /** 帧号 */
    @Excel(name = "帧号")
    private Long frameId;

    /** 航迹号 */
    @Excel(name = "航迹号")
    private Long trackId;

    /** 位置x */
    @Excel(name = "位置x")
    private Long positionx;

    /** 位置y */
    @Excel(name = "位置y")
    private Long positiony;

    /** 位置z */
    @Excel(name = "位置z")
    private Long positionz;

    /** 平滑位置z */
    @Excel(name = "平滑位置z")
    private Long smoothpositionz;

    /** 标志位 */
    @Excel(name = "标志位")
    private Long mark;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeviceId(Long deviceId) 
    {
        this.deviceId = deviceId;
    }

    public Long getDeviceId() 
    {
        return deviceId;
    }
    public void setTime(Long time) 
    {
        this.time = time;
    }

    public Long getTime() 
    {
        return time;
    }
    public void setFrameId(Long frameId) 
    {
        this.frameId = frameId;
    }

    public Long getFrameId() 
    {
        return frameId;
    }
    public void setTrackId(Long trackId) 
    {
        this.trackId = trackId;
    }

    public Long getTrackId() 
    {
        return trackId;
    }
    public void setPositionx(Long positionx) 
    {
        this.positionx = positionx;
    }

    public Long getPositionx() 
    {
        return positionx;
    }
    public void setPositiony(Long positiony) 
    {
        this.positiony = positiony;
    }

    public Long getPositiony() 
    {
        return positiony;
    }
    public void setPositionz(Long positionz) 
    {
        this.positionz = positionz;
    }

    public Long getPositionz() 
    {
        return positionz;
    }
    public void setSmoothpositionz(Long smoothpositionz) 
    {
        this.smoothpositionz = smoothpositionz;
    }

    public Long getSmoothpositionz() 
    {
        return smoothpositionz;
    }
    public void setMark(Long mark) 
    {
        this.mark = mark;
    }

    public Long getMark() 
    {
        return mark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceId", getDeviceId())
            .append("time", getTime())
            .append("frameId", getFrameId())
            .append("trackId", getTrackId())
            .append("positionx", getPositionx())
            .append("positiony", getPositiony())
            .append("positionz", getPositionz())
            .append("smoothpositionz", getSmoothpositionz())
            .append("mark", getMark())
            .toString();
    }
}
