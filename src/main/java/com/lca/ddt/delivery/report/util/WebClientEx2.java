package com.lca.ddt.delivery.report.util;

import io.netty.channel.ChannelOption;
import io.netty.channel.epoll.EpollChannelOption;
import reactor.netty.http.client.HttpClient;

public class WebClientEx2 {

	
	HttpClient client = HttpClient.create()
			  .option(ChannelOption.SO_KEEPALIVE, true)
			  .option(EpollChannelOption.TCP_KEEPIDLE, 300)
			  .option(EpollChannelOption.TCP_KEEPINTVL, 60)
			  .option(EpollChannelOption.TCP_KEEPCNT, 8);

	
	

		

	}


