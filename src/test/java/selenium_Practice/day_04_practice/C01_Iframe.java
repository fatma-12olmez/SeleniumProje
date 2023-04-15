package selenium_Practice.day_04_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Iframe extends TestBase {

    @Test
    public void test01() {
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");
        Actions actions=new Actions(driver);


        // Videoyu görecek kadar asagiya ininiz
     actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
     driver.switchTo().frame(0);

        // Videoyu izlemek icin Play tusuna basiniz
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

        // Videoyu calistirdiginizi test ediniz

        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
    }
}
