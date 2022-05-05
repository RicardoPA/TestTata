package Page.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultPage {

    @FindBy(xpath = "//div[contains(text(), 'Summary')]/parent::div//table//tr")
    private List<WebElement> listTableSummary;

    @FindBy(xpath = "//div[contains(text(), 'Summary')]")
    private WebElement labelSummary;

    public ResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getListTableSummary() {
        return listTableSummary;
    }

    public WebElement getLabelSummary() {
        return labelSummary;
    }
}
