package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class LoginPage extends BasePage {
    private final By emailField = By.id("loginEmailInput");
    private final By passwordField = By.id("loginPasswordInput");
    private final By loginButton = By.xpath("//button[@type='submit' and text()='Войти']");
    private final By errorText = By.xpath("//div[contains(@class, 'errorMessageDiv')]//p");

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get("https://uwunovels.com/login/");
    }

    public void enterUsername(String username) {
        waitVisibilityAndFindElement(emailField).sendKeys(username);
    }

    public void enterPassword(String password) {
        waitVisibilityAndFindElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        waitVisibilityAndFindElement(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getErrorText() {
        return waitVisibilityAndFindElement(errorText).getText();
    }

    /*
        Checks that login operation is complete by looking at the logout button in the hovered menu.
     */
    public void waitForLoginToComplete() {
        ExpectedCondition<Boolean> hoverAndPopupVisible = driver -> {
            try {
                WebElement hoverTarget = waitVisibilityAndFindElement(getHeader().getUserMenuIconLocator());
                new Actions(driver).moveToElement(hoverTarget).perform();

                // Checks if there is a username, throws exception if no.
                WebElement username = driver.findElement(getHeader().getLogoutButtonLocator());
                return username.isDisplayed();
            } catch (Exception e) {
                return false;
            }
        };

        waitBooleanCondition(hoverAndPopupVisible);
    }

    /*
    Checks that logout operation is complete by looking at the login button in the hovered menu.
 */
    public void waitForLogoutToComplete() {
        ExpectedCondition<Boolean> hoverAndPopupVisible = driver -> {
            try {
                WebElement hoverTarget = waitVisibilityAndFindElement(getHeader().getUserMenuIconLocator());
                new Actions(driver).moveToElement(hoverTarget).perform();

                // Checks if there is a username, throws exception if no.
                WebElement username = driver.findElement(getHeader().getLoginButtonLocator());
                return username.isDisplayed();
            } catch (Exception e) {
                return false;
            }
        };

        waitBooleanCondition(hoverAndPopupVisible);
    }
}
