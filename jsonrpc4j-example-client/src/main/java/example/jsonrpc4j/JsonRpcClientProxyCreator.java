package example.jsonrpc4j;

import static java.lang.String.format;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

import com.googlecode.jsonrpc4j.JsonRpcService;
import com.googlecode.jsonrpc4j.spring.JsonProxyFactoryBean;

import example.jsonrpc4j.util.ClassUtil;
import example.jsonrpc4j.util.YamlUtils;

@Component
public class JsonRpcClientProxyCreator implements BeanFactoryPostProcessor {
	
	static Properties prop = YamlUtils.yaml2Properties("application.yml");

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        if(prop.getProperty("jsonrpc.baseurl") == null || prop.getProperty("jsonrpc.scan") == null) {
        		return;
        }
		DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;

		for (Class clazz : ClassUtil.getClasses(prop.getProperty("jsonrpc.scan"))) {
			if (clazz.isAnnotationPresent(JsonRpcService.class)) {
				JsonRpcService jrs = (JsonRpcService) clazz.getAnnotation(JsonRpcService.class);
				registerJsonProxyBean(defaultListableBeanFactory, clazz.getName(), jrs.value());
			}
		}

	}

	private void registerJsonProxyBean(DefaultListableBeanFactory defaultListableBeanFactory, String className, String path) {
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(JsonProxyFactoryBean.class)
				.addPropertyValue("serviceUrl", appendBasePath(path)).addPropertyValue("serviceInterface", className);

		defaultListableBeanFactory.registerBeanDefinition(className + "-clientProxy", beanDefinitionBuilder.getBeanDefinition());
	}

	private String appendBasePath(String path) {
		try {
			return new URL(prop.getProperty("jsonrpc.baseurl") + path).toString();
		} catch (MalformedURLException e) {
			throw new RuntimeException(format("Cannot combine URLs '%s' and '%s' to valid URL.", "http://localhost:8080/", path), e);
		}
	}
}
