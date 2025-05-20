import components.NovelsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class NovelsTest {
    private WebDriver driver;
    private NovelsPage novelsPage;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        novelsPage = new NovelsPage(this.driver);
    }

    @AfterEach
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    /*
        A13 criterias.
    */
    @Test
    public void getNovelsCategories_OneLevelFiltering_ShouldBeNine() {
        // Arrange
        var expectedNumberOfCategories = 9;

        // Act
        var categories = novelsPage.getCategoryDropdownOptions();

        // Assert
        Assertions.assertEquals(expectedNumberOfCategories, categories.size());
    }
}
