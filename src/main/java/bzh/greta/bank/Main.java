package bzh.greta.bank;

import bzh.greta.bank.domain.Account;
import bzh.greta.bank.domain.MenuMode;
import bzh.greta.bank.io.MenuHandler;
import bzh.greta.bank.router.MenuRouter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MenuMode selectedMenu = MenuHandler.execute();
        MenuRouter menuRouteur = (MenuRouter) context.getBean("menuRouter");
        menuRouteur.execute(new Account(0), selectedMenu);
    }
}
