package com.thrift.sample.servlet;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thrift.sample.processor.SampleMultiplexingProcessor;

@Component
public class SampleServlet extends TServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3157898764625849465L;
	
	@SuppressWarnings("unused")
	private SampleMultiplexingProcessor processor;
	
	@Autowired
    public SampleServlet(SampleMultiplexingProcessor p) {
        super(p, new TBinaryProtocol.Factory());
        processor = p;
    }
}
