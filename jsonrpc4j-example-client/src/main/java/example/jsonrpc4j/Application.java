package example.jsonrpc4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableConfigurationProperties(JsonRpcProperties.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
//		new SpringApplicationBuilder()
//        .sources(Application.class)
//        .resourceLoader(new JarResourceLoader())
//        .run(args);
	}

//	@Bean
//	public MyAutoJsonRpcClientProxyCreator autoJsonRpcClientProxyCreator() {
//		MyAutoJsonRpcClientProxyCreator creator = new MyAutoJsonRpcClientProxyCreator();
//		creator.setScanPackage("example.jsonrpc4j.rpcservice");
//		try {
//			creator.setBaseUrl(new URL("http://localhost:8080/"));
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
//		
//		return creator;
//	}
}
