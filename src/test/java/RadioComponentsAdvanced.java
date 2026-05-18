import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class RadioComponentsAdvanced
{
    public class RadioComponents {
        WebDriver driver;

        @BeforeMethod
        public void dropDownTestPage() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @Test
        public void radioTests() {
            driver.get("https://www.leafground.com/radio.xhtml");

            // Find all radio buttons using XPath starts-with() on the id attribute
            List<WebElement> radioButtons = driver.findElements(
                    By.xpath("//input[starts-with(@id, 'j_idt87:console1:')]")
            );

            for (WebElement radio : radioButtons) {
                if (radio.isSelected()) {
                    // Get the id of the selected radio and find its label dynamically
                    String radioId = radio.getAttribute("id");
                    WebElement label = driver.findElement(
                            By.xpath("//label[@for='" + radioId + "']")
                    );
                    System.out.println("Default selected radio button is: " + label.getText());
                    break; // Only one radio can be selected at a time
                }
            }
        }
    }
}
