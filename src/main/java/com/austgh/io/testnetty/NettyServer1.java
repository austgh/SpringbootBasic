package com.austgh.io.testnetty;

import com.austgh.io.netty.NettyServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by think on 2021/1/19.
 */
public class NettyServer1 {
    public static void main(String[] args) throws InterruptedException {
        {
            EventLoopGroup bossGroup = new NioEventLoopGroup(1);
            EventLoopGroup workerGroup = new NioEventLoopGroup();
            try {
                ServerBootstrap bootstrap = new ServerBootstrap();
                bootstrap.group(bossGroup, workerGroup) //设置两个线程组
                        .channel(NioServerSocketChannel.class) //使用NioServerSocketChannel作为服务器的通道实现
                        .option(ChannelOption.SO_BACKLOG, 1024)
                        .childHandler(new ChannelInitializer<SocketChannel>() {//创建通道初始化对象，设置初始化参数
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                ch.pipeline().addLast(new NettyServerHandler());
                            }
                        });
                System.out.println("netty server start。。");
                ChannelFuture cf = bootstrap.bind(9000).sync();
                cf.channel().closeFuture().sync();
            } finally {
                bossGroup.shutdownGracefully();
                workerGroup.shutdownGracefully();
            }
        }
    }
}
