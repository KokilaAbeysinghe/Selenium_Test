import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertExample {
    WebDriver driver;

    @BeforeMethod
    public void dropDownTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");

    }

    @Test
    public void alertBox()throws InterruptedException{
        //Alert simple dialog
        WebElement alertBox = driver.findElement(By.id("j_idt88:j_idt91"));
        alertBox.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

    //Alert confirm Dialog

        WebElement confirmBox = driver.findElement(By.id("j_idt88:j_idt93"));
        confirmBox.click();
        Alert alert1  = driver.switchTo().alert();
        Thread.sleep(3000);
        alert1.dismiss();

        //Alert (Prompt Dialog)
        WebElement promtBox = driver.findElement(By.id("j_idt88:j_idt104"));
        promtBox.click();
        Alert alert2  = driver.switchTo().alert();
        Thread.sleep(3000);
        String alertText = alert2.getText();
        System.out.println("Alert text is:"+ alertText);
        alert2.sendKeys("My name is Kokila");
        alert2.accept();




    }








}
