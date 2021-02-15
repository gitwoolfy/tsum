package starter.page;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://tsum.ru")
public class LoginPage extends PageObject {

    private By lk = By.xpath("//a[contains(text(),'Личный кабинет')]");
    private By auth = By.xpath("//p[contains(text(),'Авторизация')]");
    private By reg = By.xpath("//p[contains(text(),'Регистрация')]");
    private By email = By.xpath("//input[@placeholder='Email']");
    private By pass = By.xpath("//input[@placeholder='Пароль']");
    private By enter = By.xpath("//button[contains(text(),'Войти') or contains(text(),'Зарегистрироваться')]");

    private By geoPopup = By.xpath("//div[@class='geo-popup']/div[@class='geo-popup__confirm']//div[@class='geo-controls']/div[contains(@class,'geo-controls_')]/button[contains(@class,'quite-black')]");

    private By successReg = By.xpath("//span[contains(text(),'Успешная регистрация')]");
    private By failReg = By.xpath("//span[contains(text(),'Пользователь с таким email уже существует.')]");
    private By failLog = By.xpath("//span[contains(text(),'Неверный логин или пароль')]");

    private By actualMail = By.xpath("//a[@class='header__link ng-star-inserted']");


    public LoginPage toLogin() {
        find(lk).click();
        return this;
    }

    public LoginPage toAuthForm() {
        find(auth).click();
        return this;
    }

    public LoginPage toRegForm() {
        find(reg).click();
        return this;
    }

    public LoginPage entEmail(String mail) {
        find(email).sendKeys(mail);
        return this;
    }

    public LoginPage entPassword(String password) {
        find(pass).sendKeys(password);
        return this;
    }

    public LoginPage submit() {
        find(enter).click();
        return this;
    }

    public void closePopup() {
        sleep(5000);
        find(geoPopup).click();
    }

    public String getRegStatus() {
        sleep(5000);
        return find(successReg).getText();
    }

    public String getFailRegStatus() {
        sleep(5000);
        return find(failReg).getText();
    }

    public String getFailLogStatus() {
        sleep(5000);
        return find(failLog).getText();
    }

    public String getActualMail(){
        sleep(5000);
        return find(actualMail).getText();
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}