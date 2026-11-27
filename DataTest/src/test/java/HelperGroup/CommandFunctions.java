package HelperGroup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommandFunctions {

    public void setText(WebElement element, WebDriverWait wait, String Input) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(Input);
    }

    public void ClickButton(WebElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void selectDropDownValue(WebElement element, WebDriverWait wait, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public boolean validatElementPresence(String xpath) {
        try {
            Base.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            if (Base.getDriver().findElement(By.xpath(xpath)).isDisplayed())
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }
}
