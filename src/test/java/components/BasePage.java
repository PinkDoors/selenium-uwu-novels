package components;

import org.openqa.selenium.WebDriver;

public class BasePage extends BaseComponent {
    private final HeaderComponent header;

    BasePage(WebDriver driver) {
        super(driver);
        this.header = new HeaderComponent(driver);
    }

    public HeaderComponent getHeader() {
        return header;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void refresh() {
        driver.navigate().refresh();
    }
}
