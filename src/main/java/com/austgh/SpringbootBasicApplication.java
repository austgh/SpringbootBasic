package com.austgh;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ServletComponentScan
@SpringBootApplication
@MapperScan("com.austgh.mapper")
public class SpringbootBasicApplication {
   final static Logger logger= LoggerFactory.getLogger("SpringbootBasicApplication");

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBasicApplication.class, args);
        logger.info("启动成功!");
    }
}
