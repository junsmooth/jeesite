package com.thinkgem.jeesite.modules.potevio.util;

import java.util.UUID;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkgem.jeesite.modules.potevio.entity.Watch;
import com.thinkgem.jeesite.modules.potevio.service.WatchService;

@Service
public class SocketHandler extends IoHandlerAdapter {

	@Autowired
	private WatchService watchService;

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("Client connected:" + session.getRemoteAddress());
		super.sessionOpened(session);
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		super.sessionClosed(session);
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		super.sessionCreated(session);
	}

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		System.out.println("RECEIVED:" + message);
		Watch watch = new Watch();
		watch.setHeartbeat(60+"");
//		watch.setId(UUID.randomUUID().toString());
		watchService.insertWatch(watch);
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		super.messageSent(session, message);
	}
}
