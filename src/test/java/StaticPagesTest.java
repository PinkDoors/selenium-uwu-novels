import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StaticPagesTest extends BaseTest {
    private static List<String> staticPages;

    @BeforeAll
    public static void loadStaticPages() throws IOException {
        staticPages = Files.readAllLines(Paths.get("./src/test/resources/static-pages.txt"));
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
