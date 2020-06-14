package com.bobo;
        import org.apache.ibatis.annotations.Mapper;
        import org.mybatis.spring.annotation.MapperScan;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bobo.dao")
public class AppofboboApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppofboboApplication.class, args);
    }

}
