import components.LoginPage;
import components.ProfilePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ProfileTest {
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
        A5, A7, A8, A12 criterias.
    */
    @Test
    public void profileAboutMeForm_FillWithTextAndSave_TextStaysAfterReloading() {
        // Arrange
        var oldText = "oldText";
        var newText = "newText";

        // Act & Assert
        loginPage.login(correctEmail, correctPassword);
        loginPage.waitForLoginToComplete();
        var profilePage = loginPage.getHeader().openProfile();

        profilePage.fillAboutMeText(oldText);
        profilePage.refresh();
        Assertions.assertEquals(oldText, profilePage.getAboutMeText());


        profilePage.fillAboutMeText(newText);
        profilePage.refresh();
        Assertions.assertEquals(newText, profilePage.getAboutMeText());
    }
}
