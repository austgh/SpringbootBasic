package com.austgh;

import com.austgh.import1.ImportDmo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.austgh")
//@MapperScan("com.austgh.mapper")
@Import(ImportDmo.class)
public class AppConfig {
}
