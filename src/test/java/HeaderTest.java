import components.HeaderComponent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class HeaderTest {
    private WebDriver driver;
    private HeaderComponent headerComponent;

    private final String correctEmail = "daniil.butchenko@rambler.ru";
    private final String correctPassword = "test12345";

    @BeforeEach
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        headerComponent = new HeaderComponent(driver);
        driver.get("https://uwunovels.com/");
    }

    @AfterEach
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    /*
        A29 criteria.
     */
    @Test
    public void playButton_Hover_ChangesColor() {
        // Arrange & Act
        var button = headerComponent.getPlayButton();

        var colorBefore = button.getCssValue("color");

        var actions = new Actions(driver);
        actions.moveToElement(button).perform();

        var colorAfter = button.getCssValue("color");

        // Assert
        Assertions.assertNotEquals("Цвет не изменился при наведении", colorBefore, colorAfter);
    }
}
