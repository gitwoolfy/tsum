package starter;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import starter.steps.LoginPageSteps;

@RunWith(SerenityRunner.class)
public class NewTest {

    @Steps
    LoginPageSteps steps;

    @Managed(driver = "chrome")
    WebDriver driver;


    /**
     * В этом тесте нужно первоначально задать в String email новую почту (можно взять с https://temp-mail.org/ru/)
     * На первый запуск новая почта уже задана
     */
    @Test
    public void successReg(){
        String email = "lativi4579@donmah.com";
        String pass = "qwerty123";
        steps.openSite();
        steps.openPage();
        steps.goToRegForm();
        steps.writeEmail(email);
        steps.writePassword(pass);
        steps.confirmEnterToLk();
        steps.getRegSuccess();
    }

    @Test
    public void failReg(){
        String email = "jomor81315@hancack.com";
        String pass = "qwerty123";
        steps.openSite();
        steps.openPage();
        steps.goToRegForm();
        steps.writeEmail(email);
        steps.writePassword(pass);
        steps.confirmEnterToLk();
        steps.getRegFail();
    }


    @Test
    public void successLog() {
        String email = "jomor81315@hancack.com";
        String pass = "qwerty123";
        steps.openSite();
        steps.openPage();
        steps.goToAuthForm();
        steps.writeEmail(email);
        steps.writePassword(pass);
        steps.confirmEnterToLk();
        steps.getLogSuccess(email);
    }

    @Test
    public void failLog() {
        String email = "jomor81315@hancack.com";
        String pass = "qwerty1231";
        steps.openSite();
        steps.openPage();
        steps.goToAuthForm();
        steps.writeEmail(email);
        steps.writePassword(pass);
        steps.confirmEnterToLk();
        steps.getLogFail();
    }
}
