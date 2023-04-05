package com.ruoyi.elecmed.Socket;

import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.elecmed.domain.BreathHeartMonitor;
import com.ruoyi.elecmed.service.IBreathHeartMonitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class TumbleSocketServer {

    //导入气象服务类，在完成所有结果接收后，调用气象服务类存入数据库
    public static IBreathHeartMonitorService iBreathHeartMonitorService = SpringUtils.getBean(IBreathHeartMonitorService.class);
    //锁，用来使得发送指令和接受结果顺序执行（同步，不能异步）
    static volatile boolean notice = true;

    static volatile boolean lock = true;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    //使用多线程，需要线程池，防止并发过高时创建过多线程耗尽资源
    private final ExecutorService threadPool = Executors.newCachedThreadPool();
    //    @Value("${port}")
    //socket服务器端口
    private Integer port;
    private boolean started;
    private ServerSocket serverSocket;

    private static void onMessage(Socket socket, BreathHeartMonitor breathHeartMonitor, int[] flag) {
        //工具类
        SocketTools socketTools = new SocketTools();
        try {
            // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
            InputStream in = socket.getInputStream();
            int[] clock = new int[]{0};
            int len = 0;//读入的数据的长度。

            byte[] buf = new byte[72];//收到的值
            /**
             * 待机指令 8 字节
             * 开机指令 8 字节
             * 信息指令 119 字节 判断传入是不是119字节
             *
             * 判断从fa 15 71 开始作为判断 延时接收
             */

            while (true) {
                //todo

                len = in.read(buf);
                if (len == -1) {
                    break;
                }

//                System.out.println("buf_len:" + len);
                String a = bytesToHexString(buf);
                String standby = "fa0502000200fffc";//FA 05 02 00 02 00 FF FC
                //如果含有 “fa1902000300e2fc”
                if (a.startsWith(standby) && notice) {
                    //信息指令 FA 15 71 00 03 08 00 00 00 06 00 00 00 00 00 2C 00 1E 84 AA 77 2F 32 00 00 2C 00 49 00 03 08 D6 BF C0 DD 05 B8 E2 79 3F 3C 00 00 00 00 00 00 00 00 56 55 05 43 7B 8E E9 EF 00 00 00 00 5D 74 11 42 00 00 96 40 7F FA 66 3F 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 3F 9E CE 36 04 1F 9E 3D 00 00 00 00 00 40 4E 41 00 80 3B 42 00 00 00 00 00 00 00 00 00 00 4B FC
                    //待机 FA 19 02 00 03 00 E2 FC
                    System.out.println("跌倒收到待机指令 + Client saying:" + a);
                    OutputStream out = null;
                    out = socket.getOutputStream();

                    //如果为真发送开机指令 并置于false
                    if (notice) {
                        //发送开机指令
                        out.write(socketTools.hexStringToByteArray("FA 02 02 00 01 00 EF FC"));
                        out.flush();
                        notice = false;
                        clock[0] = 0;
                        System.out.println("跌倒开机指令已发出");
                    }
                } else if (!notice && !a.startsWith(standby)) {
                    //如果为假  进行操作并插入
                    System.out.println("跌倒收到客户端信息指令： " + a);
                    int str_index = a.indexOf("fa011e00");
                    if (str_index == -1 || str_index > 4) {
                        System.out.println("error");
                    } else {
                        String now = a.substring(str_index);
//                    System.out.println("now:" +now+"\n"+ "now.length:"+now.length());
                        System.out.println(str_index);
                        System.out.println(now);
                        System.out.println(now.length());
                        a = now;

//                    System.out.println("length:" + a.length());
                        //处理方法存入数据库等操作
                        String device_id = a.substring(8, 10);
                        int int_device_id = Integer.valueOf(device_id, 16);
//                    System.out.println("int_device_id: " + int_device_id);

                        //小端、时间戳 uint32
                        String time = a.substring(10, 18);
                        //取反
                        time = SocketTools.interception_Reveerse(time);
                        //转十进制
                        int int_time = Integer.valueOf(time, 16);
//                    System.out.println("int_time: " + int_time);


                        //小端、帧号 uint32
                        String frame_id = a.substring(18, 26);
                        frame_id = SocketTools.interception_Reveerse(frame_id);
                        //转十进制
                        int int_frame_id = Integer.valueOf(frame_id, 16);
//                    System.out.println("int_frame_id: " + int_frame_id);

                        //航迹号 uint
                        String track_id = a.substring(26, 28);
                        int int_track_id = Integer.valueOf(track_id, 16);
//                    System.out.println(f_outputFilterBreathOut);

                        //小端，位置x float
                        String positionX = a.substring(28, 36);
                        positionX = SocketTools.interception_Reveerse(positionX);
                        //16进制转float
                        Long l = Long.parseLong(positionX, 16);
                        Float f_positionX = Float.intBitsToFloat(l.intValue());
//                    System.out.println(f_outputFilterHeartOut);

                        //小端，位置y float
                        String positionY = a.substring(36, 44);
                        positionY = SocketTools.interception_Reveerse(positionY);
                        //16进制转float
                        l = Long.parseLong(positionY, 16);
                        Float f_positionY = Float.intBitsToFloat(l.intValue());
//                    System.out.println(f_BreathingRate_Out);

                        //小端，位置z float
                        String positionZ = a.substring(44, 52);
                        positionZ = SocketTools.interception_Reveerse(positionZ);
                        //16进制转float
                        l = Long.parseLong(positionZ, 16);
                        Float f_positionZ = Float.intBitsToFloat(l.intValue());
//                    System.out.println(f_BreathingRate_Out);

                        //小端，平滑位置z float
                        String smoothPositionZ = a.substring(52, 60);
                        smoothPositionZ = SocketTools.interception_Reveerse(smoothPositionZ);
                        //16进制转float
                        l = Long.parseLong(smoothPositionZ, 16);
                        Float f_smoothPositionZ = Float.intBitsToFloat(l.intValue());
//                    System.out.println(f_heartRate_Out);

                        //标志位 0 为 none，1 为站立，2 为跌倒  uint8
                        String mark = a.substring(60, 62);
                        //16进制转float
                        int int_mark = Integer.valueOf(mark, 16);


//                        breathHeartMonitor.setDeviceId((long) int_device_id);
//                        breathHeartMonitor.setTime((long) int_time);
//                        breathHeartMonitor.setFrameId((long) int_frame_id);
//                        breathHeartMonitor.setOutputfilterbreathout(f_outputFilterBreathOut);
//                        breathHeartMonitor.setOutputfilterheartout(f_outputFilterHeartOut);
//                        breathHeartMonitor.setBreathingrateOut(f_BreathingRate_Out);
//                        breathHeartMonitor.setHeartrateOut(f_heartRate_Out);

                        System.out.println("device_id:" + int_device_id);
                        System.out.println("time:" + int_time);
                        System.out.println("frame_id:" + int_frame_id);
                        System.out.println("trackID:" + int_track_id);
                        System.out.println("f_positionX:" + f_positionX);
                        System.out.println("f_positionY:" + f_positionY);
                        System.out.println("f_positionZ:" + f_positionZ);
                        System.out.println("f_smoothPositionZ:" + f_smoothPositionZ);
                        System.out.println("mark:" + mark);

//                    System.out.println(breathHeartMonitor);

                        try {
//                            iBreathHeartMonitorService.insertBreathHeartMonitor(breathHeartMonitor);
//                        confidenceMetricBreathOut_xCorr被设置为了非空，但是你给了空

                        } catch (Exception e) {
                            System.out.println(e);
//                        System.out.println("ohohohoho");

                        }
                    }
//                    System.out.println("dasdasda");


//                    lock=false;

//                    System.out.println("device_id:" + device_id);//03
//                    System.out.println("time:" + time);//08000000
//                    System.out.println("frame_id:" + frame_id);//06000000
//                    System.out.println("outputFilterBreathOut:" + outputFilterBreathOut);
//                    System.out.println("outputFilterHeartOut:" + outputFilterHeartOut);
//                    System.out.println("BreathingRate_Out:" + BreathingRate_Out);
//                    System.out.println("heartRate_Out:" + heartRate_Out);

                } else {
                    System.out.println("客户端未连接服务器");
                }

                String res = a.substring(2, 4);

                java.util.Arrays.fill(buf, (byte) 0);


            }
            //此处，需要关闭服务器的输出流，但不能使用inputStream.close().
            //com.ruoyi.meteorological.socket.shutdownInput();


        } catch (IOException e) {
            e.printStackTrace();

        }
    }

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

    //包装
    public void start() {
        start(2222);
    }

    //启动socket服务器
    private void start(Integer port) {
        try {
            serverSocket = new ServerSocket(port == null ? this.port : port);
            started = true;
            logger.info("Socket服务已启动，占用端口： {}", serverSocket.getLocalPort());
        } catch (IOException e) {
            logger.error("端口异常信息", e);
            System.exit(0);
        }
        while (started) {
            try {
                //有新的socket客户端接入请求
                Socket socket = serverSocket.accept();
                //开启一个新的线程
                Runnable runnable = () -> {
                    //
                    int[] flag = new int[]{0};
                    //导入气象类，存储天气数据
                    BreathHeartMonitor breathHeartMonitor = new BreathHeartMonitor();
                    //发送至指令线程启动
                    //抽出去
//                    new sendMessThread(socket, breathHeartMonitor).start();

                    //接收客户端数据线程启动
                    onMessage(socket, breathHeartMonitor, flag);
                };
                //接收线程返回结果
                Future future = threadPool.submit(runnable);
                logger.info(future.isDone() + "--------");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //发送消息的内部类。
    class sendMessThread extends Thread {
        Socket socket = null;
        BreathHeartMonitor breathHeartMonitor = null;

        public sendMessThread(Socket socket, BreathHeartMonitor breathHeartMonitor) {
            this.socket = socket;
            this.breathHeartMonitor = breathHeartMonitor;
        }


        @Override
        public void run() {
            super.run();
            OutputStream out = null;

            for (; ; ) {
                int[] clock = new int[]{0};
                try {
                    if (socket != null) { //主类中的定义。
                        out = socket.getOutputStream();

                        if (notice) {
                            out.write(hexStringToByteArray("FA 16 02 00 01 00 EF FC")); //跌倒开机指令 FA 02 02 00 01 00 EF FC
                            out.flush();
                            notice = false;
                            clock[0] = 0;
                            System.out.println("跌倒开机指令已发出");
                        }

                        //                        每条指令间延迟十秒
                        while (true) {
                            if (notice) {
                                Thread.sleep(1000);
                                break;
                            }
                            Thread.sleep(1000);
                            clock[0]++;
                            if (clock[0] == 10) {
                                notice = true;
                            }
                        }

                        /*****************************************  历史代码  ***************************************************/
//                        if(notice){
//                            out.write(hexStringToByteArray("02 03 00 00 00 02 C4 38")); //风向
//                            out.flush();
//                            notice = false;
//                            clock[0] = 0;
//                            System.out.println("风向指令已发出");
//                        }
//
////                        每条指令间延迟十秒
//                        while (true){
//                            if (notice){
//                                Thread.sleep(1000);
//                                break;
//                            }
//                            Thread.sleep(1000);
//                            clock[0]++;
//                            if (clock[0] == 10){
//                                notice = true;
//                            }
//                        }
//
//                        if(notice){
//                            out.write(hexStringToByteArray("01 03 00 00 00 01 84 0A")); //风速
//                            out.flush();
//                            notice = false;
//                            clock[0] = 0;
//                            System.out.println("风速指令已发出");
//                        }
//
//                        while (true){
//                            if (notice){
//                                Thread.sleep(1000);
//                                break;
//                            }
//                            Thread.sleep(1000);
//                            clock[0]++;
//                            if (clock[0] == 10){
//                                notice = true;
//                            }
//                        }
//                        if(notice){
//                            out.write(hexStringToByteArray("0B 03 01 F4 00 02 84 AF")); //温湿度
//                            out.flush();
//                            notice = false;
//                            clock[0] = 0;
//                            System.out.println("空气温湿度指令已发出");
//                        }
//
////                        while (true){
////                            if (notice){
////                                break;
////                            }
////                        }
//                        while (true){
//                            if (notice){
//                                Thread.sleep(1000);
//                                break;
//                            }
//                            Thread.sleep(1000);
//                            clock[0]++;
//                            if (clock[0] == 10){
//                                notice = true;
//                            }
//                        }
//                        if(notice){
//                            out.write(hexStringToByteArray("0B 03 01 FA 00 02 E5 6C")); //光照
//                            out.flush();
//                            notice = false;
//                            clock[0] = 0;
//                            System.out.println("光照指令已发出");
//                        }
//
//                        while (true){
//                            if (notice){
//                                Thread.sleep(1000);
//                                break;
//                            }
//                            Thread.sleep(1000);
//                            clock[0]++;
//                            if (clock[0] == 10){
//                                notice = true;
//                            }
//                        }
//
//                        if(notice){
//                            out.write(hexStringToByteArray("0B 03 01 F9 00 01 55 6D")); //大气压
//                            out.flush();
//                            notice = false;
//                            clock[0] = 0;
//                            System.out.println("大气压指令已发出");
//                        }
//
//                        while (true){
//                            if (notice){
//                                Thread.sleep(1000);
//                                break;
//                            }
//                            Thread.sleep(1000);
//                            clock[0]++;
//                            if (clock[0] == 10){
//                                notice = true;
//                            }
//                        }
//                        if(notice){
//                            out.write(hexStringToByteArray("04 03 00 06 00 04 A4 5D")); //ph 04 03 08 02 BC 07 62 06 43 02 BC 71 FB
//                            out.flush();
//                            notice = false;
//                            clock[0] = 0;
//                            System.out.println("pH指令已发出");
//                        }
//
//                        while (true){
//                            if (notice){
//                                Thread.sleep(1000);
//                                break;
//                            }
//                            Thread.sleep(1000);
//                            clock[0]++;
//                            if (clock[0] == 10){
//                                notice = true;
//                            }
//                        }
//                        if(notice){
//                            out.write(hexStringToByteArray("04 03 00 1E 00 03 65 98")); //NPK
//                            out.flush();
//                            notice = false;
//                            clock[0] = 0;
//                            System.out.println("NPK指令已发出");
//                        }
//
//                        while (true){
//                            if (notice){
//                                Thread.sleep(1000);
//                                break;
//                            }
//                            Thread.sleep(1000);
//                            clock[0]++;
//                            if (clock[0] == 10){
//                                notice = true;
//                            }
//                        }
//                        if(notice){
//                            out.write(hexStringToByteArray("04 03 00 12 00 02 64 5B")); //湿温度
//                            out.flush();
//                            notice = false;
//                            clock[0] = 0;
//                            System.out.println("土壤温湿度指令已发出");
//                        }
//
//                        while (true){
//                            if (notice){
//                                Thread.sleep(1000);
//                                break;
//                            }
//                            Thread.sleep(1000);
//                            clock[0]++;
//                            if (clock[0] == 10){
//                                notice = true;
//                            }
//                        }
//                        if(notice){
//                            out.write(hexStringToByteArray("04 03 00 15 00 01 95 9B")); //导电率 04 03 02 00 00 74 44
//                            out.flush();
//                            notice = false;
//                            clock[0] = 0;
//                            System.out.println("导电率指令已发出");
//                        }
//
//                        while (true){
//                            if (notice){
//                                Thread.sleep(1000);
//                                break;
//                            }
//                            Thread.sleep(1000);
//                            clock[0]++;
//                            if (clock[0] == 10){
//                                notice = true;
//                            }
//                        }
//                        if(notice){
//                            out.write(hexStringToByteArray("03 03 00 00 00 01 85 E8")); //雨量
//                            out.flush();
//                            notice = false;
//                            clock[0] = 0;
//                            System.out.println("雨量指令已发出");
//                        }
//
//                        while (true){
//                            if (notice){
//                                break;
//                            }
//                            Thread.sleep(1000);
//                            clock[0]++;
//                            if (clock[0] == 20){
//                                //TODO
//                                //sysMeteorologicalService.insertSysMeteorological(sysMeteorological);
//                                notice = true;
//                            }
//                        }

                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(1000 * 60 * 2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        //将16进制表示的字符串转换为字节数组，进行信息的发送

        /**
         * @param hexString 16进制字符串
         * @retrun byte[] 字节数组
         */

        public byte[] hexStringToByteArray(String hexString) {
            hexString = hexString.replace(" ", "");//把所有的空格都去掉
            int len = hexString.length();//获取长度
            byte[] bytes = new byte[len / 2];

            for (int i = 0; i < len; i += 2) {
                bytes[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4) + Character
                        .digit(hexString.charAt(i + 1), 16));
            }

            return bytes;
        }
    }


}
