import components.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class MainTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
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
