package com.ruoyi.elecmed.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 呼吸心跳监测对象 breath_heart_monitor
 *
 * @author zyl
 * @date 2022-10-03
 */
public class BreathHeartMonitor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 设备号  */
    @Excel(name = "设备号 ")
    private Long deviceId;

    /** 时间戳 */
    @Excel(name = "时间戳")
    private Long time;

    /** 帧号 */
    @Excel(name = "帧号")
    private Long frameId;

    /** 小端，呼吸相位值 */
    @Excel(name = "小端，呼吸相位值")
    private Float outputfilterbreathout;

    /** 小端，心跳相位值
 */
    @Excel(name = "小端，心跳相位值 ")
    private Float outputfilterheartout;

    /** 小端，呼吸频率值 */
    @Excel(name = "小端，呼吸频率值")
    private Float breathingrateOut;

    /** 小端，心跳频率值 */
    @Excel(name = "小端，心跳频率值")
    private Float heartrateOut;

    /** 最大范围 */
    @Excel(name = "最大范围")
    private Long rangebinindexmax;

    /** 范围相位 */
    @Excel(name = "范围相位")
    private Long rangebinindexphase;

    /** 最大值 */
    @Excel(name = "最大值")
    private Long maxval;

    /** 处理周期输出 */
    @Excel(name = "处理周期输出")
    private Long processingcyclesout;

    /** 范围索引 */
    @Excel(name = "范围索引")
    private Long rangebinstartindex;

    /** 范围结果索引 */
    @Excel(name = "范围结果索引")
    private Long rangebinendindex;

    /** 展开相位峰值 */
    @Excel(name = "展开相位峰值")
    private Long unwrapphasepeakMm;

    /** 心率估计值 */
    @Excel(name = "心率估计值")
    private Long heartrateestFft;

    /** 心率估计值_4hz */
    @Excel(name = "心率估计值_4hz")
    private Long heartrateestFft4hz;

    /** 心率估计值_xCorr */
    @Excel(name = "心率估计值_xCorr")
    private Long heartrateestXcorr;

    /** 心率估计值峰值计数_过滤 */
    @Excel(name = "心率估计值峰值计数_过滤")
    private Long heartrateestPeakcountFiltered;

    /** 呼吸估计值Est_FFT */
    @Excel(name = "呼吸估计值Est_FFT")
    private Long breathingrateestFft;

    /** 呼吸估计值_xCorr */
    @Excel(name = "呼吸估计值_xCorr")
    private Long breathingrateestXcorr;

    /** 呼吸估计值峰值计数_过滤 */
    @Excel(name = "呼吸估计值峰值计数_过滤")
    private Long breathingrateestPeakcount;

    /** 置信度度量呼吸 */
    @Excel(name = "置信度度量呼吸")
    private Long confidencemetricbreathout;

    /** 置信度度量呼吸_xCorr */
    @Excel(name = "置信度度量呼吸_xCorr")
    private Long confidencemetricbreathoutXcorr;

    /** 置信度度量心跳 */
    @Excel(name = "置信度度量心跳")
    private Long confidencemetricheartout;

    /** 置信度度量心跳_4Hz */
    @Excel(name = "置信度度量心跳_4Hz")
    private Long confidencemetricheartout4hz;

    /** 置信度度量心跳_xCorr */
    @Excel(name = "置信度度量心跳_xCorr")
    private Long confidencemetricheartoutXcorr;

    /** 呼吸能量总和 */
    @Excel(name = "呼吸能量总和")
    private Long sumenergybreathwfm;

    /** 心跳能量总和 */
    @Excel(name = "心跳能量总和")
    private Long sumenergyheartwfm;

    /** 运动检测标志 */
    @Excel(name = "运动检测标志")
    private Long motiondetectedflag;

    /** 呼吸频率能量 */
    @Excel(name = "呼吸频率能量")
    private Long breathingrateestHarmonicenergy;

    /** 心率能量 */
    @Excel(name = "心率能量")
    private Long heartrateestHarmonicenergy;

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
    public void setOutputfilterbreathout(Float outputfilterbreathout)
    {
        this.outputfilterbreathout = outputfilterbreathout;
    }

    public Float getOutputfilterbreathout()
    {
        return outputfilterbreathout;
    }
    public void setOutputfilterheartout(Float outputfilterheartout)
    {
        this.outputfilterheartout = outputfilterheartout;
    }

    public Float getOutputfilterheartout()
    {
        return outputfilterheartout;
    }
    public void setBreathingrateOut(Float breathingrateOut)
    {
        this.breathingrateOut = breathingrateOut;
    }

    public Float getBreathingrateOut()
    {
        return breathingrateOut;
    }
    public void setHeartrateOut(Float heartrateOut)
    {
        this.heartrateOut = heartrateOut;
    }

    public Float getHeartrateOut()
    {
        return heartrateOut;
    }
    public void setRangebinindexmax(Long rangebinindexmax)
    {
        this.rangebinindexmax = rangebinindexmax;
    }

    public Long getRangebinindexmax()
    {
        return rangebinindexmax;
    }
    public void setRangebinindexphase(Long rangebinindexphase)
    {
        this.rangebinindexphase = rangebinindexphase;
    }

    public Long getRangebinindexphase()
    {
        return rangebinindexphase;
    }
    public void setMaxval(Long maxval)
    {
        this.maxval = maxval;
    }

    public Long getMaxval()
    {
        return maxval;
    }
    public void setProcessingcyclesout(Long processingcyclesout)
    {
        this.processingcyclesout = processingcyclesout;
    }

    public Long getProcessingcyclesout()
    {
        return processingcyclesout;
    }
    public void setRangebinstartindex(Long rangebinstartindex)
    {
        this.rangebinstartindex = rangebinstartindex;
    }

    public Long getRangebinstartindex()
    {
        return rangebinstartindex;
    }
    public void setRangebinendindex(Long rangebinendindex)
    {
        this.rangebinendindex = rangebinendindex;
    }

    public Long getRangebinendindex()
    {
        return rangebinendindex;
    }
    public void setUnwrapphasepeakMm(Long unwrapphasepeakMm)
    {
        this.unwrapphasepeakMm = unwrapphasepeakMm;
    }

    public Long getUnwrapphasepeakMm()
    {
        return unwrapphasepeakMm;
    }
    public void setHeartrateestFft(Long heartrateestFft)
    {
        this.heartrateestFft = heartrateestFft;
    }

    public Long getHeartrateestFft()
    {
        return heartrateestFft;
    }
    public void setHeartrateestFft4hz(Long heartrateestFft4hz)
    {
        this.heartrateestFft4hz = heartrateestFft4hz;
    }

    public Long getHeartrateestFft4hz()
    {
        return heartrateestFft4hz;
    }
    public void setHeartrateestXcorr(Long heartrateestXcorr)
    {
        this.heartrateestXcorr = heartrateestXcorr;
    }

    public Long getHeartrateestXcorr()
    {
        return heartrateestXcorr;
    }
    public void setHeartrateestPeakcountFiltered(Long heartrateestPeakcountFiltered)
    {
        this.heartrateestPeakcountFiltered = heartrateestPeakcountFiltered;
    }

    public Long getHeartrateestPeakcountFiltered()
    {
        return heartrateestPeakcountFiltered;
    }
    public void setBreathingrateestFft(Long breathingrateestFft)
    {
        this.breathingrateestFft = breathingrateestFft;
    }

    public Long getBreathingrateestFft()
    {
        return breathingrateestFft;
    }
    public void setBreathingrateestXcorr(Long breathingrateestXcorr)
    {
        this.breathingrateestXcorr = breathingrateestXcorr;
    }

    public Long getBreathingrateestXcorr()
    {
        return breathingrateestXcorr;
    }
    public void setBreathingrateestPeakcount(Long breathingrateestPeakcount)
    {
        this.breathingrateestPeakcount = breathingrateestPeakcount;
    }

    public Long getBreathingrateestPeakcount()
    {
        return breathingrateestPeakcount;
    }
    public void setConfidencemetricbreathout(Long confidencemetricbreathout)
    {
        this.confidencemetricbreathout = confidencemetricbreathout;
    }

    public Long getConfidencemetricbreathout()
    {
        return confidencemetricbreathout;
    }
    public void setConfidencemetricbreathoutXcorr(Long confidencemetricbreathoutXcorr)
    {
        this.confidencemetricbreathoutXcorr = confidencemetricbreathoutXcorr;
    }

    public Long getConfidencemetricbreathoutXcorr()
    {
        return confidencemetricbreathoutXcorr;
    }
    public void setConfidencemetricheartout(Long confidencemetricheartout)
    {
        this.confidencemetricheartout = confidencemetricheartout;
    }

    public Long getConfidencemetricheartout()
    {
        return confidencemetricheartout;
    }
    public void setConfidencemetricheartout4hz(Long confidencemetricheartout4hz)
    {
        this.confidencemetricheartout4hz = confidencemetricheartout4hz;
    }

    public Long getConfidencemetricheartout4hz()
    {
        return confidencemetricheartout4hz;
    }
    public void setConfidencemetricheartoutXcorr(Long confidencemetricheartoutXcorr)
    {
        this.confidencemetricheartoutXcorr = confidencemetricheartoutXcorr;
    }

    public Long getConfidencemetricheartoutXcorr()
    {
        return confidencemetricheartoutXcorr;
    }
    public void setSumenergybreathwfm(Long sumenergybreathwfm)
    {
        this.sumenergybreathwfm = sumenergybreathwfm;
    }

    public Long getSumenergybreathwfm()
    {
        return sumenergybreathwfm;
    }
    public void setSumenergyheartwfm(Long sumenergyheartwfm)
    {
        this.sumenergyheartwfm = sumenergyheartwfm;
    }

    public Long getSumenergyheartwfm()
    {
        return sumenergyheartwfm;
    }
    public void setMotiondetectedflag(Long motiondetectedflag)
    {
        this.motiondetectedflag = motiondetectedflag;
    }

    public Long getMotiondetectedflag()
    {
        return motiondetectedflag;
    }
    public void setBreathingrateestHarmonicenergy(Long breathingrateestHarmonicenergy)
    {
        this.breathingrateestHarmonicenergy = breathingrateestHarmonicenergy;
    }

    public Long getBreathingrateestHarmonicenergy()
    {
        return breathingrateestHarmonicenergy;
    }
    public void setHeartrateestHarmonicenergy(Long heartrateestHarmonicenergy)
    {
        this.heartrateestHarmonicenergy = heartrateestHarmonicenergy;
    }

    public Long getHeartrateestHarmonicenergy()
    {
        return heartrateestHarmonicenergy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceId", getDeviceId())
            .append("time", getTime())
            .append("frameId", getFrameId())
            .append("outputfilterbreathout", getOutputfilterbreathout())
            .append("outputfilterheartout", getOutputfilterheartout())
            .append("breathingrateOut", getBreathingrateOut())
            .append("heartrateOut", getHeartrateOut())
            .append("rangebinindexmax", getRangebinindexmax())
            .append("rangebinindexphase", getRangebinindexphase())
            .append("maxval", getMaxval())
            .append("processingcyclesout", getProcessingcyclesout())
            .append("rangebinstartindex", getRangebinstartindex())
            .append("rangebinendindex", getRangebinendindex())
            .append("unwrapphasepeakMm", getUnwrapphasepeakMm())
            .append("heartrateestFft", getHeartrateestFft())
            .append("heartrateestFft4hz", getHeartrateestFft4hz())
            .append("heartrateestXcorr", getHeartrateestXcorr())
            .append("heartrateestPeakcountFiltered", getHeartrateestPeakcountFiltered())
            .append("breathingrateestFft", getBreathingrateestFft())
            .append("breathingrateestXcorr", getBreathingrateestXcorr())
            .append("breathingrateestPeakcount", getBreathingrateestPeakcount())
            .append("confidencemetricbreathout", getConfidencemetricbreathout())
            .append("confidencemetricbreathoutXcorr", getConfidencemetricbreathoutXcorr())
            .append("confidencemetricheartout", getConfidencemetricheartout())
            .append("confidencemetricheartout4hz", getConfidencemetricheartout4hz())
            .append("confidencemetricheartoutXcorr", getConfidencemetricheartoutXcorr())
            .append("sumenergybreathwfm", getSumenergybreathwfm())
            .append("sumenergyheartwfm", getSumenergyheartwfm())
            .append("motiondetectedflag", getMotiondetectedflag())
            .append("breathingrateestHarmonicenergy", getBreathingrateestHarmonicenergy())
            .append("heartrateestHarmonicenergy", getHeartrateestHarmonicenergy())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .toString();
    }
}
