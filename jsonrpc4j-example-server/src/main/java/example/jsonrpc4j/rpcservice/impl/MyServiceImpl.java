package example.jsonrpc4j.rpcservice.impl;

import org.springframework.stereotype.Component;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;

import example.jsonrpc4j.domain.User;
import example.jsonrpc4j.rpcservice.MyService;

@Component
@AutoJsonRpcServiceImpl
public class MyServiceImpl implements MyService {

	@Override
	public String sayHelloWorld(String name) {
		return "Hello world, " + name;
	}

	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int div(int a, int b) {

		if (b == 0) {
			throw new IllegalArgumentException();
		}
		return a / b;
	}

	@Override
	public User getUser(User usr) {
		return usr;
	}


}
