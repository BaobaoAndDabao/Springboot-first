package com.wenzhihao;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jolbox.bonecp.BoneCPDataSource;

//@Configuration一般与@ComponentScan一起使用.因为在xml中配置扫描包嘛
@Configuration //通过该注解来表明该类是一个Spring的配置，相当于一个xml文件. 
//这个config要作为参数作为初始化容器的参数传入.
@ComponentScan(basePackages ="com.wenzhihao") //配置扫描包,会扫描com/wenzhihao下的所有注解类.
@PropertySource(value= {"classpath:jdbc.properties"},ignoreResourceNotFound=true)//properties资源注解类似placeHolder
public class SpringConfig {
    
    
	@Value("${jdbc.url}")
	private String jdbcUrl;

	@Value("${jdbc.driverClassName}")
	private String jdbcDriverClassName;

	@Value("${jdbc.username}")
	private String jdbcUsername;

	@Value("${jdbc.password}")
	private String jdbcPassword;

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		BoneCPDataSource boneCPDataSource = new BoneCPDataSource();
		// 数据库驱动
		boneCPDataSource.setDriverClass(jdbcDriverClassName);
		// 相应驱动的jdbcUrl
		boneCPDataSource.setJdbcUrl(jdbcUrl);
		// 数据库的用户名
		boneCPDataSource.setUsername(jdbcUsername);
		// 数据库的密码
		boneCPDataSource.setPassword(jdbcUsername);
		// 检查数据库连接池中空闲连接的间隔时间，单位是分，默认值：240，如果要取消则设置为0
		boneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
		// 连接池中未使用的链接最大存活时间，单位是分，默认值：60，如果要永远存活设置为0
		boneCPDataSource.setIdleMaxAgeInMinutes(30);
		// 每个分区最大的连接数
		boneCPDataSource.setMaxConnectionsPerPartition(100);
		// 每个分区最小的连接数
		boneCPDataSource.setMinConnectionsPerPartition(5);
		return boneCPDataSource;
	}
	
	
    @Bean // 通过该注解来表明是一个Bean对象，相当于xml中的<bean>   通过java代码配置的bean
    public UserDAO getUserDAO(){//bean的名字是getUserDAO
        return new UserDAO(); // 直接new对象做演示
    }
    
}