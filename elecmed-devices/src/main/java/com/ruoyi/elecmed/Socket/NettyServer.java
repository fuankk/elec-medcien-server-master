package com.ruoyi.elecmed.Socket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

public class NettyServer {
    private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);

    public void start(InetSocketAddress inetSocketAddress)
    {
        // new 一个主线程组,这里的数量有确认。默认可以不写
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //new 一个工作线程组,这里的数量有确认。默认可以不写
        EventLoopGroup workGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap()
                .group(bossGroup,workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ServerChannelInitializer())
                //设置队列大小
                .option(ChannelOption.SO_BACKLOG,1024)
                //两个小时内没有数据通信时，TCP会自动发送一个活动探测数据报文
                .childOption(ChannelOption.SO_KEEPALIVE,true);
        try{
            ChannelFuture future = bootstrap.bind(inetSocketAddress).sync();
            System.out.println("服务器ip为: "+ inetSocketAddress.getHostName());
            System.out.println("服务器端口为: "+ inetSocketAddress.getPort());
            future.channel().closeFuture().sync();
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            //关闭主线程组
            bossGroup.shutdownGracefully();
            //关闭工作线程组
            workGroup.shutdownGracefully();
        }
    }

//    如果需要单独控制socket开关，可以单独写一个函数对boosGroup和workGroup进行操作。
//    public void close() {
//        workGroup.shutdownGracefully();
//        bossGroup.shutdownGracefully();
//        logger.info("======Shutdown Netty Server Success!=========");
//    }

}
