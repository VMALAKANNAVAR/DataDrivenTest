package HelperGroup;

import org.apache.commons.math3.ode.events.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    public void ScrollToElement(WebElement element, WebDriverWait wait) {
        JavascriptExecutor js = (JavascriptExecutor) Base.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void HoverOverElement(WebElement element, WebDriverWait wait) {
        Actions action = new Actions(Base.getDriver());
        action.moveToElement(element).build().perform();
    }

    public void DoubleClick(WebElement element, WebDriverWait wait) {
        Actions action = new Actions(Base.getDriver());
        action.doubleClick(element).build().perform();
    }

    public void RightClick(WebElement element, WebDriverWait wait) {
        Actions action = new Actions(Base.getDriver());
        action.contextClick(element).build().perform();
    }
}
