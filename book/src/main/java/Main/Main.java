package Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    public static void main(String[] args) {
        // Setup selenium webdriver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        
        // Open the url
        driver.get("https://map.naver.com/v5/entry/place/1797596093?lng=127.07871212042468&lat=37.623767434322055&placePath=%2Fhome&entry=plt&c=20,0,0,0,dh");
        
        // Wait for the page to fully load
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        // Switch to the iframe
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe.yourIframeSelector")));
        driver.switchTo().frame(iframe);
        
        // Replace "span.place_blind > em" with the appropriate selector.
        WebElement ratingElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("em")));
        
        // Get the rating
        String rating = ratingElement.getText();
        System.out.println("Rating: " + rating);
        
        // Switch back to the main window
        driver.switchTo().defaultContent();
        
        driver.quit();
    }
}
