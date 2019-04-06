package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchResultsPage {
    private final WebDriver driver;
    private ArrayList<Integer> al = new ArrayList<Integer>();

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='content']/ul/li[*]")
    private List<WebElement> searchResultsList;

    @FindBy(xpath = "//*[@id='content']/ul/li[position() = 5]/div/div[2]/a")
    private WebElement fifthPropertyLink;


    private int getSearchResultsListCount() {
        return searchResultsList.size();
    }

    public void getAllPropertyValues() {
        for (int i = 1; i < getSearchResultsListCount(); i++) {
            try {
                String text = driver.findElement(By.xpath("//*[@id='content']/ul/li[" + i + "]/div/div[2]/a")).getText();
                al.add(Integer.parseInt(text.replaceAll("[^0-9]", "")));
                al.sort(Collections.reverseOrder());
            } catch (Exception e) {
                e.getSuppressed();
            }
        }
        System.out.println("Sorted Property values" + al);
    }

    public void clickOnFifthPropertyLink() {
        fifthPropertyLink.click();
    }


}
