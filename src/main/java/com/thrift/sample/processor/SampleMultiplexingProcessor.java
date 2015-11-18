package com.thrift.sample.processor;

import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.TProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thrift.sample.service.EchoServiceHandler;

@Component
public class SampleMultiplexingProcessor extends TMultiplexedProcessor {
	
	// @Autowired(required = true)
	EchoServiceHandler echoServiceHandler;
	
	@Autowired
    public SampleMultiplexingProcessor(EchoServiceProcessor echoServiceProcessor) {
        this.registerProcessor("EchoService", (TProcessor) echoServiceProcessor);
        // add more registerProcessor lines here for additional services
        echoServiceHandler = echoServiceProcessor.getHandler();
        // set any additional service handlers here
    }

	public EchoServiceHandler getContactUserServiceHandler() {
		return echoServiceHandler;
	}

	public void setContactUserServiceHandler(EchoServiceHandler echoServiceHandler) {
		this.echoServiceHandler = echoServiceHandler;
	}
	
}
