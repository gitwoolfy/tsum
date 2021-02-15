package starter.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import starter.page.LoginPage;

public class LoginPageSteps {

    LoginPage loginPage;

    @Step("Открываем веб-сайт")
    public void openSite() {
        loginPage.open();
    }

    @Step("Открываем страничку логина")
    public void openPage() {
        loginPage.closePopup();
        loginPage.toLogin();
    }

    @Step("Переходим на вкладку 'Авторизация'")
    public void goToAuthForm() {
        loginPage.toAuthForm();
    }

    @Step("Переходим на вкладку 'Регистрация'")
    public void goToRegForm() {
        loginPage.toRegForm();
    }

    @Step("Вводим email в поле логина")
    public void writeEmail(String email) {
        loginPage.entEmail(email);
    }

    @Step("Вводим пароль в поле пароля")
    public void writePassword(String password) {
        loginPage.entPassword(password);
    }

    @Step("Подтверждаем вход/регистрацию")
    public void confirmEnterToLk() {
        loginPage.submit();
    }

    @Step("Проверяем успешность регистрации")
    public void getRegSuccess() {
        Assert.assertEquals("Регистрация не удалась", "Успешная регистрация", loginPage.getRegStatus());
        System.out.println("Регистрация удалась");
    }

    @Step("Проверяем неуспешность регистрации")
    public void getRegFail() {
        Assert.assertEquals("Регистрация удалась", "Пользователь с таким email уже существует.", loginPage.getFailRegStatus());
        System.out.println("Регистрация не удалась");
    }

    @Step("Проверяем успешность авторизации")
    public void getLogSuccess(String authMail) {
        Assert.assertEquals("Авторизация не удалась", authMail, loginPage.getActualMail());
        System.out.println("Авторизация удалась");
    }

    @Step("Проверяем неуспешность авторизации")
    public void getLogFail() {
        Assert.assertEquals("Авторизация удалась", "Неверный логин или пароль", loginPage.getFailLogStatus());
        System.out.println("Авторизация не удалась");
    }
}
