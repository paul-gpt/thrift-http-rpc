package com.thrift.sample.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thrift.sample.service.EchoService.Processor;
import com.thrift.sample.service.EchoServiceHandler;

@Component
public class EchoServiceProcessor extends Processor<EchoServiceHandler> {

	// @Autowired(required = true)
	private EchoServiceHandler handler;
	
	@Autowired
	public EchoServiceProcessor(EchoServiceHandler iface) {
		super(iface);
		this.handler = iface;
	}
	
	public EchoServiceProcessor() {
		super(new EchoServiceHandler());
	}

	public EchoServiceHandler getHandler() {
		return handler;
	}

	public void setHandler(EchoServiceHandler handler) {
		this.handler = handler;
	}
	
}
