package programmer_zaman_now.webservlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class BelajarJavaWebServletApplication {
    public static void main(String[] args) {
        SpringApplication.run(BelajarJavaWebServletApplication.class);
    }
}
