import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class OtherTests extends BaseTest {
    /*
        A32 criteria.
     */
    @Test
    public void toForum_BackToNovels_TitlesChange() {
        // Arrange & Act
        driver.get("https://uwunovels.com/");
        var firstPageTitle = driver.getTitle();

        driver.get("https://example.com/forum/");
        var secondPageTitle = driver.getTitle();

        Assertions.assertNotEquals(firstPageTitle, secondPageTitle);

        driver.navigate().back();

        // Assert
        var currentTitle = driver.getTitle();
        Assertions.assertEquals(firstPageTitle, currentTitle);
    }

    /*
        A38 criteria.
     */
    @Test
    public void makeHeadingYellow_UsingJavaScript_SuccessfullyTurnsYellow() {
        // Arrange
        driver.get("https://uwunovels.com/");

        // Act
        var element = driver.findElement(By.tagName("h1"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].style.border = '3px solid yellow';", element);

        // Assert
        var borderColor = element.getCssValue("border-color");
        Assertions.assertEquals("rgb(255, 255, 0)", borderColor);
    }
}
