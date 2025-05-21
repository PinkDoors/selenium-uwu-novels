package components;

import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
        driver.get("https://uwunovels.com/main/");
    }
}
