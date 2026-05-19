import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowExample {
    WebDriver driver;

    @BeforeMethod
    public void windowsTestPage()throws InterruptedException  {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml");
        Thread.sleep(3000);

    }

   @Test
   public void windowTests()throws InterruptedException{
       // Click and Confirm new Window Opens
   String oldWindow = driver.getWindowHandle();
   System.out.println("Parent window:" + oldWindow);

     WebElement openButton = driver.findElement(By.xpath(" //*[@id='j_idt88:new']/span"));
     openButton.click();
     Thread.sleep(3000);

       Set<String> handles = driver.getWindowHandles();
       System.out.println("handle size +" + handles.size());


       //first method - using foreach loop
       for(String newWindow : handles){
           System.out.println(newWindow);
           driver.switchTo().window(newWindow);
           System.out.println("page title is: " + driver.getTitle());
       }
        driver.close();
        driver.switchTo().window(oldWindow);

        WebElement openButton1 = driver.findElement(By.xpath(" //*[@id='j_idt88:new']/span"));
        boolean openbuttonVisibility = openButton1.isDisplayed();
        System.out.println("Open button visibility" + openbuttonVisibility);

// find the no of opened tabs

  WebElement multiWindow = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']/span"));
  multiWindow.click();
  Thread.sleep(3000);

        Set<String> multiWindows = driver.getWindowHandles();
        int howmanyWindows = multiWindows.size();
        System.out.println("No of windows opened" + howmanyWindows);


// close all windows except primary
        WebElement dontclosemeButton = driver.findElement(By.name("j_idt88:j_idt93"));
        dontclosemeButton.click();
        Thread.sleep(3000);

       Set<String>  newWindowsHandles = driver.getWindowHandles();
       for(String allwindows:newWindowsHandles){
           if (!allwindows.equals(oldWindow)){
               driver.switchTo().window(allwindows);
               driver.close();
           }
       }

driver.quit();


   }






















}
