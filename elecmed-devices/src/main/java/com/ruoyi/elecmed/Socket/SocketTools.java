package com.ruoyi.elecmed.Socket;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SocketTools {
    //将16进制表示的字符串转换为字节数组，进行信息的发送

    /**
     * 将byte[]数组转换为16进制的字符串
     *
     * @param bytes
     * @return
     */
    public static String bytesToHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(hex);
        }
        return stringBuilder.toString();
    }

    /**
     * @Description: 字符串取二为一组置反，例如 ab cd ef 结果：ef cd ab
     * @return:{@link null}
     * @date: 2022/9/30/0030 20:55
     * @author: boliang
     * @since : JDK 1.8
     */
    public static String interception_Reveerse(String str) {
        String newStr = "";
        int count = str.length();
        while (count != 0) {
            newStr += str.substring(count - 2, count);
            count -= 2;
        }
        return newStr;
    }

    /**
     * @Description:测试截取转换
     * @return:{@link null}
     * @date: 2022/10/1/0001 11:32
     * @author: boliang
     * @since : JDK 1.8
     */
    public static void Interception_Conversion(String a) {
        String device_id = a.substring(8, 10);
        int int_device_id = Integer.valueOf(device_id, 16);
        System.out.println("int_device_id: " + int_device_id);

        //时间戳 uint32
        String time = a.substring(10, 18);
        //取反
        time = SocketTools.interception_Reveerse(time);
        //转十进制
        int int_time = Integer.valueOf(time, 16);
        System.out.println("int_time: " + int_time);


        //帧号 uint32
        String frame_id = a.substring(18, 26);
        frame_id = SocketTools.interception_Reveerse(frame_id);
        //转十进制
        int int_frame_id = Integer.valueOf(frame_id, 16);
        System.out.println("int_frame_id: " + int_frame_id);

        //小端，呼吸相位值 float
        String outputFilterBreathOut = a.substring(66, 74);
        outputFilterBreathOut = SocketTools.interception_Reveerse(outputFilterBreathOut);
        //16进制转float
        Long l = Long.parseLong(outputFilterBreathOut, 16);
        Float f_outputFilterBreathOut = Float.intBitsToFloat(l.intValue());
        System.out.println(f_outputFilterBreathOut);

        //小端，心跳相位值 float
        String outputFilterHeartOut = a.substring(74, 82);
        outputFilterHeartOut = SocketTools.interception_Reveerse(outputFilterHeartOut);
        //16进制转float
        l = Long.parseLong(outputFilterHeartOut, 16);
        Float f_outputFilterHeartOut = Float.intBitsToFloat(l.intValue());
        System.out.println(f_outputFilterHeartOut);

        //小端，呼吸频率值 float
        String BreathingRate_Out = a.substring(218, 226);
        BreathingRate_Out = SocketTools.interception_Reveerse(BreathingRate_Out);
        //16进制转float
        l = Long.parseLong(BreathingRate_Out, 16);
        Float f_BreathingRate_Out = Float.intBitsToFloat(l.intValue());
        System.out.println(f_BreathingRate_Out);

        //小端，心跳频率值 float
        String heartRate_Out = a.substring(226, 234);
        heartRate_Out = SocketTools.interception_Reveerse(heartRate_Out);
        //16进制转float
        l = Long.parseLong(heartRate_Out, 16);
        Float f_heartRate_Out = Float.intBitsToFloat(l.intValue());
        System.out.println(f_heartRate_Out);


//        breathHeartMonitor.setDeviceId((long) int_device_id);
//        breathHeartMonitor.setTime((long) int_time);
//        breathHeartMonitor.setFrameId((long) int_frame_id);
//        breathHeartMonitor.setOutputfilterbreathout(f_outputFilterBreathOut);
//        breathHeartMonitor.setOutputfilterheartout(f_outputFilterHeartOut);
//        breathHeartMonitor.setBreathingrateOut(f_BreathingRate_Out);
//        breathHeartMonitor.setHeartrateOut(f_outputFilterBreathOut);

//        System.out.println(breathHeartMonitor);
//
//        iBreathHeartMonitorService.insertBreathHeartMonitor2(breathHeartMonitor);

//                    lock=false;

//                    System.out.println("device_id:" + device_id);//03
//                    System.out.println("time:" + time);//08000000
//                    System.out.println("frame_id:" + frame_id);//06000000
//                    System.out.println("outputFilterBreathOut:" + outputFilterBreathOut);
//                    System.out.println("outputFilterHeartOut:" + outputFilterHeartOut);
//                    System.out.println("BreathingRate_Out:" + BreathingRate_Out);
//                    System.out.println("heartRate_Out:" + heartRate_Out);
    }

    //将时间戳转换为时间
    public static String stampToTime(String s) throws Exception {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        //将时间戳转换为时间
        Date date = new Date(lt);
        //将时间调整为yyyy-MM-dd HH:mm:ss时间样式
        res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * @param hexString 16进制字符串
     * @retrun byte[] 字节数组
     */

    public byte[] hexStringToByteArray(String hexString) {
        //把所有的空格都去掉
        hexString = hexString.replace(" ", "");
        //获取长度
        int len = hexString.length();
        byte[] bytes = new byte[len / 2];

        for (int i = 0; i < len; i += 2) {
            bytes[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4) + Character
                    .digit(hexString.charAt(i + 1), 16));
        }

        return bytes;
    }

}
