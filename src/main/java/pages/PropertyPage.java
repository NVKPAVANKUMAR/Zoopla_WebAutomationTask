package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PropertyPage {
    private final WebDriver driver;

    public PropertyPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(className = "ui-agent__name")
    private WebElement agentNameLinkElement;


    public String captureAgentName() {
        return agentNameLinkElement.getText();
    }

    public void clickOnAgentNameLink() {
        agentNameLinkElement.click();
    }
}
