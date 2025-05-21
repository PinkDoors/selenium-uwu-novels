import components.HeaderComponent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

public class HeaderTest extends BaseTest {
    private HeaderComponent headerComponent;

    private final String correctEmail = "daniil.butchenko@rambler.ru";
    private final String correctPassword = "test12345";

    @BeforeEach
    public void setUp() {
        headerComponent = new HeaderComponent(driver);
        driver.get("https://uwunovels.com/");
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
