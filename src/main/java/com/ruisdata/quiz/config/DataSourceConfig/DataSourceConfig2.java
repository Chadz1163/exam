package com.ruisdata.quiz.config.DataSourceConfig;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.ruisdata.quiz.dao.exam2",sqlSessionFactoryRef = "exam2SqlSessionFactory")
public class DataSourceConfig2 {
    @Primary
    @Bean(name = "exam2DataSource")
    @ConfigurationProperties("spring.datasource.exam2")
    public DataSource masterDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "exam2SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("exam2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapping/exam2/*.xml"));
        return sessionFactoryBean.getObject();
    }

}