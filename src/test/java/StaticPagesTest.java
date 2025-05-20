import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class StaticPagesTest {
    private static final String[] STATIC_PAGES = {
            "https://uwunovels.com/main",
            "https://uwunovels.com/team"
    };

    /*
        A10 criteria.
     */
    @Test
    public void testStaticPagesLoadSuccessfully() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        var driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        for (var url : STATIC_PAGES) {
            driver.get(url);
            var title = driver.getTitle();
            Assertions.assertNotNull(title);
            Assertions.assertNotEquals("", title);
        }
    }
}
