package com.alibaba.icbu.crm.psql;

import com.alibaba.icbu.crm.psql.db.object.UserDo;
import com.alibaba.icbu.crm.psql.db.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PsqlApplication implements CommandLineRunner {

    @Autowired
    private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(PsqlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        UserDo userDo = userMapper.findById(1L);
        System.out.println(userDo);
    }
}
