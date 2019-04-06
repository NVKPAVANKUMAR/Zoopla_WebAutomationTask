package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AgentPage {

    private final WebDriver driver;

    public AgentPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='content']/div/h1/b[1]")
    private WebElement agentNameHeaderElement;

    public String captureAgentNameFromHeader() {
        return agentNameHeaderElement.getText();
    }

}
