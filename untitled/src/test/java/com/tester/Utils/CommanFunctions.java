package com.tester.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommanFunctions {


    public void setText(WebElement element,String InputText)
    {
        element.clear();
        element.sendKeys(InputText);
    }

    public void ClickElement(WebElement element)
    {
        element.click();

    }
}
