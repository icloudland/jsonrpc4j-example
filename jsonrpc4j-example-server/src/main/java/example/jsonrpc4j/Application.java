package example.jsonrpc4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public AutoJsonRpcServiceImplExporter AutoJsonRpcServiceImplExporter() {
		return new AutoJsonRpcServiceImplExporter();
	}
}
