package com.thinkgem.jeesite.modules.potevio.util;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MinaSocketServer {
	private static Logger logger = LoggerFactory
			.getLogger(MinaSocketServer.class);
	private static int PORT = 8899;
	private static int inited = 0;
	@Autowired
	private SocketHandler handler;

	@Scheduled(fixedRate = 60 * 1000)
	public void start() {
		if (inited > 0) {
			return;
		}
		inited++;
		System.out.println("scheduled");
		IoAcceptor acceptor = new NioSocketAcceptor();
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new TextLineCodecFactory()));
		acceptor.getFilterChain().addLast("threadPool",
				new ExecutorFilter(Executors.newCachedThreadPool()));
		acceptor.setHandler(handler);
		try {
			acceptor.bind(new InetSocketAddress(PORT));
			logger.info("SOCKET BIND TO:" + PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
