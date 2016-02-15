# thrift-http-rpc
thrift rpc via http protocal with spring

USE CASE 

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
	

# CI Used