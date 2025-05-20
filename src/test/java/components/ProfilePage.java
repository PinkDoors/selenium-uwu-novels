package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage {
    private final By aboutMeInput = By.xpath("//main[contains(@class, 'profileBlock')]//textarea[@name='description']");
    private final By saveButton = By.xpath("//main[contains(@class, 'profileBlock')]//button[@type='submit']");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void fillAboutMeText(String text) {
        waitVisibilityAndFindElement(aboutMeInput).clear();
        waitVisibilityAndFindElement(aboutMeInput).sendKeys(text);
        saveChanges();
    }

    public String getAboutMeText() {
        return waitVisibilityAndFindElement(aboutMeInput).getText();
    }

    private void saveChanges() {
        waitVisibilityAndFindElement(saveButton).click();
        // During saving 'Сохранить'(Save) is changed to loading circle.
        var saveEndedCondition = ExpectedConditions.textToBePresentInElementLocated(saveButton, "Сохранить");
        waitBooleanCondition(saveEndedCondition);
    }
}
