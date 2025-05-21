import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import components.LoginPage;

import java.net.MalformedURLException;
import java.util.UUID;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    private final String correctEmail = "daniil.butchenko@rambler.ru";
    private final String correctPassword = "test12345";

    @BeforeEach
    public void setUp() throws MalformedURLException {
        loginPage = new LoginPage(driver);
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
        A4, A7, A8, A35 criteria.
    */
    @Test
    public void login_WrongEmail_UnsuccessfulLogin() {
        // Arrange
        String randomEmail = "user_" + UUID.randomUUID() + "@example.com";
        var errorMessage = "Некорректная почта и/или пароль";

        // Act
        loginPage.login(randomEmail, correctPassword);

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
