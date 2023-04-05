package com.ruoyi.elecmed.Socket;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author ccWang
 * @Time 2022/12/31
 * @Description 服务端业务处理
 */
@Component
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    // 获取实例化对象
    @Autowired
//    protected IPlapDataService plapDataService;
    public static NettyServerHandler nettyServerHandler;

    // 用户保存客户端的通道，String为设备的deviceNumber，ChannelHandlerContext为设备的通道信息
    public static Map<String,ChannelHandlerContext> ctxMap = new ConcurrentHashMap<String, ChannelHandlerContext>() ;

    // 配合@Comonent注解获取Service层的bean
    @PostConstruct
    public void init() {
        nettyServerHandler = this;
//        nettyServerHandler.plapDataService = this.plapDataService;
    }

    // 客户端连接触发
    @Override
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        System.out.println("客户端发起连接。");
    }

    // 客户段断开连接触发
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        removeChannelMap(ctx);
        super.channelInactive(ctx);
    }

    // 客户端发送信息触发
    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object msg) throws Exception {
        //获取客户端的ip
        InetSocketAddress inetSocketAddress = (InetSocketAddress) channelHandlerContext.channel().remoteAddress();
        String ip = inetSocketAddress.getAddress().getHostAddress();
        System.out.println("收到的客户端的IP为: " + ip);
        //获取到的设备信息
        String device_msg = msg.toString();
//        byte[] bytes = device_msg.getBytes(StandardCharsets.US_ASCII);
//        String mag = new String(bytes,StandardCharsets.UTF_8);
        System.out.println("收到的消息为: " + device_msg);
        //将msg转换为json
//        JSONObject jsonObject = JSON.parseObject(device_msg);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date sendTime = format.parse((String) jsonObject.get("sendTime"));
//        String request = (String) jsonObject.get("request");
//        //设备连接之后进行注册，将channel放到channelMap中进行管理；
//        switch (request) {
//            case "register":{
//                //获取设备编号
//                String deviceNumber = (String) jsonObject.get("deviceNumber");
//                //通过设备编号，将通道信息放到ctxMap中
//                ctxMap.put(deviceNumber, channelHandlerContext);
//                channelHandlerContext.write("Register successed!");
//                System.out.println("当前在线设备数量：" + ctxMap.size());
//                break;
//            }
//            case "insert":{
//                String deviceType = (String) jsonObject.get("deviceType");
//                //对PLAP设备进行更新
//                if (deviceType.equals("PLAP")) {
//                    //获取json中的PLAP对象
//                    JSONObject plap = jsonObject.getJSONObject("PLAP");
//                    //将plap转换为java对象
//                    PlapData plapData = JSON.parseObject(String.valueOf(plap), PlapData.class);
//                    //更新plap中的updateTime为下位机上传的sendTIme，其他字段同理。
//                    plapData.setCreateTime(sendTime);
//                    plapData.setData(plap.toString());
//                    plapData.setCreateBy(plapData.getDeviceNumber());
//                    //利用Service对plap_data进行更新
//                    nettyServerHandler.plapDataService.insertPlapDataSocket(plapData);
//                    //System.out.println("更新结果为: " + result);
//                    System.out.println("接收到的deviceNumber为: " + plapData.getDeviceNumber());
//                    System.out.println("接收到的sendTime为: " + sendTime);
//                }
//                break;
//            }
//            default:{
//                System.out.println("通讯内容有误！");
//            }
//        }

        //返回收到确认信息
//        channelHandlerContext.write("Received!");
        //清空缓存
//        channelHandlerContext.flush();
    }

    // 移除已经失效的连接
    private void removeChannelMap(ChannelHandlerContext ctx){
        for(String key: ctxMap.keySet()){
            if(ctxMap.get(key) != null && ctxMap.get(key).equals(ctx)){
                System.out.println("移除设备连接：" + key);
                ctxMap.remove(key);
            }
        }
        //移除后输出全部通道，测试
        System.out.println("当前在线设备数量：" + ctxMap.size());
    }

    /**
     * 向特定设备发送信息，通过deviceNumber查找通道，
     * @param content 需要发送的内容
     * @param deviceNumber 需要发送的设备
     */
    public void sendMessage(String content, String deviceNumber){
        ChannelHandlerContext ctx = ctxMap.get(deviceNumber);
        ctx.write(content);
        ctx.flush();
    }

    /**
     * 关闭特定设备的socket连接
     * @param deviceNumber 需要关闭的设备
     */
    public void closeChannelByDeviceNumber(String deviceNumber){
        ChannelHandlerContext ctx = ctxMap.get(deviceNumber);
        ctx.close();
        removeChannelMap(ctx);
    }

    //发生异常触发
    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable cause) throws Exception {
        cause.printStackTrace();
        //发生错误，关闭socket
        channelHandlerContext.close();
    }

}
