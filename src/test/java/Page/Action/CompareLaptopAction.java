package Page.Action;

import Page.BasePage;
import Page.Page.CompareLaptopsPage;
import org.openqa.selenium.WebDriver;

public class CompareLaptopAction extends BasePage {

    CompareLaptopsPage compareLaptopsPage;

    public CompareLaptopAction(WebDriver driver) {
        super(driver);
        compareLaptopsPage = new CompareLaptopsPage(driver);
    }

    private void clickSelectLaptop(int i) throws Exception {
        click(compareLaptopsPage.getSelectLaptop(i));
        Thread.sleep(1000);
    }

    private void sendKeysInputLaptop(int i, String text) throws Exception {
        sendKeys(compareLaptopsPage.getInputLaptop(i), text);
    }

    private void clickOptionLaptop(String desc) throws Exception {
        click(compareLaptopsPage.getOptionLaptop(desc));
    }

    public void actionSeleccionarLaptop(int i, String desc) throws Exception {
        scrollDown();
        clickSelectLaptop(i);
        sendKeysInputLaptop(i, desc);
        clickOptionLaptop(desc);
    }

    public void clickBtnCompare() throws Exception {
        click(compareLaptopsPage.getBtnCompare());
    }
}
