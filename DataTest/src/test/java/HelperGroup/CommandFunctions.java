package HelperGroup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommandFunctions {

    public void setText(WebElement element, WebDriverWait wait, String Input)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(Input);
    }

    public void ClickButton(WebElement element, WebDriverWait wait)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
}
