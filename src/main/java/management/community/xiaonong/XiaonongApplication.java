package management.community.xiaonong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "management.community.xiaonong.mapper")
public class XiaonongApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaonongApplication.class, args);
    }

}
