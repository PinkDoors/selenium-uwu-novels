import components.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class MainTest extends BaseTest {
    private MainPage mainPage;

    @Override
    @BeforeEach
    public void baseSetUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        // A27 criteria.
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        mainPage = new MainPage(driver);
    }

    /*
        A9, A19.
     */
    @Test
    public void getTitle_StaticPage_LoadsSuccessfullyAndReturnsTitle() {
        // Arrange
        var expectedTitle = "Визуальные новеллы | UwU Novels";

        // Act
        var title = mainPage.getTitle();

        // Assert
        Assertions.assertEquals(expectedTitle, title);
    }
}
