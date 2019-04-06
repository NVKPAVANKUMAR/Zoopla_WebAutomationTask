package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(id = "search-submit")
    private WebElement searchButton;

    public void inputTextToSearchBox(String input_Txt) {
        searchBox.sendKeys(input_Txt);

    }

    public void clickSearchButton() {
        searchButton.click();
    }


}
