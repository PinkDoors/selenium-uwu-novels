import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import components.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    private final String correctEmail = "daniil.butchenko@rambler.ru";
    private final String correctPassword = "test12345";

    @BeforeEach
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    /*
        A4, A7, A8 criteria.
     */
    @Test
    public void login_CorrectCredentials_SuccessfulLogin() {
        // Arrange
        var expectedUsername = "@Tester12345";

        // Act
        loginPage.login(correctEmail, correctPassword);
        loginPage.waitForLoginToComplete();

        // Assert
        var email = loginPage.getHeader().getCurrentUsername();
        Assertions.assertEquals(expectedUsername, email);
    }

    /*
        A4 criteria.
    */
    @Test
    public void login_WrongEmail_UnsuccessfulLogin() {
        // Arrange
        var wrongEmail = "abracadabra@gmail.com";
        var errorMessage = "Некорректная почта и/или пароль";

        // Act
        loginPage.login(wrongEmail, correctPassword);

        // Assert
        var errorText = loginPage.getErrorText();
        Assertions.assertEquals(errorMessage, errorText);
    }

    /*
        A6 criteria.
    */
    @Test
    public void logout_afterSuccessfulLogin_SuccessfulLogout() {
        // Arrange
        var expectedLoginButtonText = "Войти";

        // Act
        loginPage.login(correctEmail, correctPassword);
        loginPage.waitForLoginToComplete();
        loginPage.getHeader().logout();
        loginPage.waitForLogoutToComplete();

        // Assert
        var loginButtonText = loginPage.getHeader().getLoginButton().getText();
        Assertions.assertEquals(expectedLoginButtonText, loginButtonText);
    }
}
