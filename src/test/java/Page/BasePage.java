package Page;

import org.openqa.selenium.*;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void sendKeys(By element, String inputText) throws Exception {
        try {
            driver.findElement(element).sendKeys(inputText);
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new Exception("No se pudo encontrar el elemento");
        }

    }

    protected void click(WebElement webElement) throws Exception {
        try {
            webElement.click();
            Thread.sleep(1000);
        } catch (Exception e) {
            throw new Exception("No se pudo hacer click en el elemento " + webElement);
        }
    }

    protected void click(By element) throws Exception {
        try {
            driver.findElement(element).click();
            Thread.sleep(1000);
        } catch (Exception e) {
            throw new Exception("No se pudo hacer click en el elemento " + element);
        }
    }

    protected void scrollDown() {
        Dimension size = driver.manage().window().getSize();
        int startPoint = (int)((double)size.getHeight() * 0.7D);
        int endPoint = (int)((double)size.getHeight() * 0.4D);
        ((JavascriptExecutor)driver).executeScript("scroll("+startPoint+","+endPoint+")");
    }

    public void scrollDownToElement(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
