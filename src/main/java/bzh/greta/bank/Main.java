package bzh.greta.bank;

import bzh.greta.bank.domain.Account;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = Account.class)
public class Main {
    public static void main(String... args) {
        SpringApplication.run(Main.class, args);
    }
}
