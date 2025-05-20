package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NovelsPage extends BasePage {
    private final By categoriesButton = By.xpath("//form[contains(@class, 'marketFilters')]//input[@placeholder='Все категории...']");
    private final By categoriesDropdown = By.xpath("//form[contains(@class, 'marketFilters')]//div[contains(@class, 'TagSearch_tagSearch__suggestions__')]//button");

    public NovelsPage(WebDriver driver) {
        super(driver);
        driver.get("https://uwunovels.com/");
    }

    public List<String> getCategoryDropdownOptions() {
        waitVisibilityAndFindElement(categoriesButton).click();
        var a = waitVisibilityAndFindElements(categoriesDropdown);
        return waitVisibilityAndFindElements(categoriesDropdown).stream().map(WebElement::getText).toList();
    }
}
