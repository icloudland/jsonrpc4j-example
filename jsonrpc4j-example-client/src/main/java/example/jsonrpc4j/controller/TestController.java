package example.jsonrpc4j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import example.jsonrpc4j.domain.User;
import example.jsonrpc4j.rpcservice.MyService;

@RestController
@RequestMapping("/te")
public class TestController {
	

	@Autowired
    private MyService myService;
	
	@GetMapping
	public String get() {
		System.out.println(myService.div(2, 1));
		return "hello";
	}
	
	@PostMapping
	public @ResponseBody User post(@RequestBody User user) {
		return myService.getUser(user);
	}
}
