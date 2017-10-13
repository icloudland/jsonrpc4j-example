package example.jsonrpc4j.rpcservice;

import com.googlecode.jsonrpc4j.JsonRpcError;
import com.googlecode.jsonrpc4j.JsonRpcErrors;
import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;

import example.jsonrpc4j.domain.User;

@JsonRpcService("/rpc/myservice")
public interface MyService {

	String sayHelloWorld(String name);

	int add(@JsonRpcParam("a") int a, @JsonRpcParam("b") int b);

	@JsonRpcErrors({ @JsonRpcError(exception = IllegalArgumentException.class, code = -5678, message = "除数不能为0", data = "The Data"),
			@JsonRpcError(exception = Throwable.class, code = -187) })
	int div(@JsonRpcParam("a") int a, @JsonRpcParam("b") int b);
	
	User getUser(User usr);
}
