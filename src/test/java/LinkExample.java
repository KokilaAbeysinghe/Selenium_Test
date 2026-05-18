import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.time.Duration;

public class LinkExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.leafground.com/link.xhtml");
    }

    @Test
    public void LinkTests(){
        // 1.Take me to Dash board
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();

        //2.Find my destination
        WebElement wheretoGo = driver.findElement(By.partialLinkText("Find the URL without cli"));
        String path = wheretoGo.getAttribute("href");
        System.out.println("This Link is going to:"+path);

        //3.Am I broken Link?
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();

       String title = driver.getTitle();
       if(title.contains("404")){
           System.out.println("The link is broken");
       } else{
           System.out.println("Not Broken");
       }
        driver.navigate().back();

        //4. Duplicate Link
        WebElement homeLinkAgain = driver.findElement(By.linkText("Go to Dashboard"));
        homeLinkAgain.click();
        driver.navigate().back();

        //Count page Link
         List<WebElement> countfullpageLinks = driver.findElements(By.tagName("a"));
         int pageLinkCount = countfullpageLinks.size();
         System.out.println("Count of full page links : " +pageLinkCount);

        //6. Count Layout links

        WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countOfLayoutLinks = layoutElement.findElements(By.tagName("a"));
        System.out.println("Count of layout links:" + countOfLayoutLinks.size());




    }





}
