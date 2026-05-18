import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;


public class TextBoxExample {


    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.leafground.com/input.xhtml");
    }

 @Test
 public void textBOXTests(){
        //1. Type your name
     WebElement name = driver.findElement(By.id("j_idt88:name"));
     name.sendKeys("Kokila Harith");

        //2.Append Country to this city
     WebElement appendText = driver.findElement(By.id("j_idt88:j_idt91"));
     appendText.sendKeys(" Sri Lanka");

        //3.Verify if text box is disabled
     boolean enabled = driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
     System.out.println("Is text box enabled"+enabled);

        //4.Clear the typed text
     WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
     clearText.clear();

        //5.Retrive the typed text
    WebElement textElement = driver.findElement(By.id("j_idt88:j_idt97"));
    String value = textElement.getAttribute("value");
    System.out.println(value);

        //6.Type email and Tab.Confirm control moved to next element.
     driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("kokila@gmail.com"+ Keys.TAB +"Confirmed control moved to next element");

 }



}
