package base.dependenceInjection;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseUtil {
    public String userFullName;

    public void highLighter(WebDriver driver, WebElement element) throws Exception{
        //getting current styles and store them somewhere
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        String elementStyle = element.getAttribute("style");

        //Creating new Styles and applying them to element
        js.executeScript(
                "arguments[0].setAttribute('style', 'background-color: red; color: black; border: 2px solid yellow;');",
                element);
        Thread.sleep(500);

        //Restoring back normal element style
        js.executeScript("arguments[0].setAttribute('style',arguments[1]);",
                element,elementStyle);
    }
}
