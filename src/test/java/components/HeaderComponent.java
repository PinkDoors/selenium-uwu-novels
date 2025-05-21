package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HeaderComponent extends BaseComponent{
    private WebDriver driver;

    private final By userMenuIcon = By.xpath("//div[contains(@class, 'navUserMenu')]//img[contains(@class, 'navUserMenuIcon')]");
    private final By usernameText = By.xpath("//div[contains(@class, 'navUserList')]//a[@class='userProfileData']//p");
    private final By logoutButton = By.xpath("//div[contains(@class, 'navUserList')]//a[contains(@class, navUserQuit) and contains(text(),'Выйти')]");
    private final By loginButton = By.xpath("//div[contains(@class, 'navUserList')]//a[@href='/login']");
    private final By profileButton = By.xpath("//div[contains(@class, 'navUserList')]//a[@href='/profile']");

    private final By playButton = By.xpath("//nav[contains(@class, 'mainNav')]//a[@href='/']");

    public HeaderComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public By getUserMenuIconLocator() {
        return userMenuIcon;
    }

    public By getLoginButtonLocator() {
        return loginButton;
    }

    public By getLogoutButtonLocator() {
        return logoutButton;
    }

    public String getCurrentUsername() {
        openUserMenu();
        return waitVisibilityAndFindElement(usernameText).getText();
    }

    public void logout() {
        openUserMenu();
        waitVisibilityAndFindElement(logoutButton).click();
    }

    public WebElement getLoginButton() {
        openUserMenu();
        return waitVisibilityAndFindElement(loginButton);
    }

    public ProfilePage openProfile() {
        waitVisibilityAndFindElement(profileButton).click();
        return new ProfilePage(driver);
    }

    public WebElement getPlayButton() {
        return waitVisibilityAndFindElement(playButton);
    }

    private void openUserMenu() {
        var hoverTarget = waitVisibilityAndFindElement(userMenuIcon);
        new Actions(driver).moveToElement(hoverTarget).perform();
    }
}
