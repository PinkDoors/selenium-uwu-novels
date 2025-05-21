import components.NovelsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

public class NovelsTest extends BaseTest {
    private NovelsPage novelsPage;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        novelsPage = new NovelsPage(this.driver);
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
