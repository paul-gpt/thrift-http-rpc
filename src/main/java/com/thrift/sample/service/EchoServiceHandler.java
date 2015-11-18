package com.thrift.sample.service;

import org.apache.thrift.TException;
import org.springframework.stereotype.Component;

import com.thrift.sample.service.EchoService.Iface;

@Component
public class EchoServiceHandler implements Iface {

	@Override
	public String echo(String str) throws TException {
		return str;
	}

}
