package com.thrift.sample.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;
import org.junit.Test;

import com.thrift.sample.service.EchoService;

public class Clinet {
	
	private String url = "http://127.0.0.1:8080/service/";
	
	@Test
	public void test() throws TException {
		TTransport transport = new THttpClient(url);
		TProtocol protocol = new TBinaryProtocol(transport);
		TMultiplexedProtocol mp = new TMultiplexedProtocol(protocol, "EchoService");
		EchoService.Client userServiceClient = new EchoService.Client(mp);
		String s = userServiceClient.echo("hello");
		System.out.print(s);
	}
	
}
