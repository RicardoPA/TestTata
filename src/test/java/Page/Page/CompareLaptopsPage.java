package Page.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompareLaptopsPage {

    @FindBy(xpath = "//button[text()='compare']")
    private WebElement btnCompare;

    public CompareLaptopsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public By getSelectLaptop(int i){
        return By.xpath("//li["+i+"]//i");
    }

    public By getInputLaptop(int i){
        return By.xpath("//li["+i+"]//input");
    }

    public By getOptionLaptop(String desc) {
        return By.xpath("//mark[contains(text(),'"+desc+"')]/parent::span");
    }

    public WebElement getBtnCompare() {
        return btnCompare;
    }
}
