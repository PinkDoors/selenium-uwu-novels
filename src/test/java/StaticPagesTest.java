import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StaticPagesTest {
    private WebDriver driver;
    private static List<String> staticPages;

    @BeforeAll
    public static void loadStaticPages() throws IOException {
        staticPages = Files.readAllLines(Paths.get("./src/test/resources/static-pages.txt"));
    }

    @BeforeEach
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
    }

    @AfterEach
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    /*
        A10, A37 criterias.
     */
    @Test
    public void getTitle_StaticPagesFromConfigurationFile_TitlesNotEmpty() {
        for (var url : staticPages) {
            driver.get(url);
            var title = driver.getTitle();
            Assertions.assertNotNull(title);
            Assertions.assertNotEquals("", title);
        }
    }
}
