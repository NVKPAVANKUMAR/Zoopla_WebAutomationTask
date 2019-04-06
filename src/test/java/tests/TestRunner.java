package tests;

import driver.BrowserInstance;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.AgentPage;
import pages.HomePage;
import pages.PropertyPage;
import pages.SearchResultsPage;
import utilities.ConfigParser;

import java.io.IOException;

import static utilities.ReportGenerator.*;

public class TestRunner extends BrowserInstance {

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private PropertyPage propertyPage;
    private AgentPage agentPage;

    @BeforeSuite
    public void setUp() throws IOException {
        setExtent();
        initiateDriver(ConfigParser.fetchProperity("browser").toString());
        openUrl(ConfigParser.fetchProperity("webapplication_url").toString());
    }

    @Test
    public void perform_task() {
        logger = reports.createTest(new Object() {
        }.getClass().getEnclosingMethod().getName());
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.inputTextToSearchBox("London");
        logger.info("Input Text Entered");
        homePage.clickSearchButton();
        logger.info("Search Button Clicked");
        searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
        searchResultsPage.getAllPropertyValues();
        logger.info("Retrieved All Property Values");
        searchResultsPage.clickOnFifthPropertyLink();
        logger.info("Clicked on Fifth Property Link");
        propertyPage = PageFactory.initElements(driver, PropertyPage.class);
        String agentName = propertyPage.captureAgentName();
        logger.info("Agent Name Captured");
        propertyPage.clickOnAgentNameLink();
        logger.info("Clicked on AgentName Link");
        agentPage = PageFactory.initElements(driver, AgentPage.class);
        String agentNameFromHeader = agentPage.captureAgentNameFromHeader();
        Assert.assertEquals(agentName, agentNameFromHeader);
        logger.info("Asserted Agent Name");
        logger.pass("PASSED");
    }

    @AfterSuite
    public void tearDown() {
        endReport();
        closeBrowser();
    }
}
