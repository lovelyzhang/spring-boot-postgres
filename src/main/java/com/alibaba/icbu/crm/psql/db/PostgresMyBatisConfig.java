package com.alibaba.icbu.crm.psql.db;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author hualun.zy
 */
@Configuration
@MapperScan(
        basePackages = {"com.alibaba.icbu.crm.psql.db.mapper"},
        sqlSessionFactoryRef = "postgresSqlSessionFactory",
        sqlSessionTemplateRef = "postgresSqlSessionTemplate")
public class PostgresMyBatisConfig {


    @Bean(name = "postgresSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier(value = "postgresDataSource") DataSource postgresDataSource) throws Exception {

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(postgresDataSource);
        bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:/mybatis-config-postgres.xml"));
        return bean.getObject();
    }

    @Bean(name = "postgresSqlSessionTemplate")
    public SqlSessionTemplate singleSqlSessionTemplate(@Qualifier(value = "postgresSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
