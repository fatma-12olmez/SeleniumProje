package Exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class E06_Iframe extends TestBase {
    @Test
    public void test() {

        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        // tüm ikinci emoji öğelerini tıklayın
        List<WebElement> resimler = driver.findElements(By.xpath("//div[@id='nature']"));

        //for each ile
        for (WebElement w : resimler) {
            System.out.println(w.getText());
        }
        resimler.forEach(t -> System.out.println(t.getText()));

        // parent iframe e geri donun
        driver.switchTo().parentFrame();

        // formu doldurun,(Formu istediğiniz metinlerle doldurun)

        driver.findElement(By.xpath("//input[@id='text']")).sendKeys("Fatma");
        driver.findElement(By.xpath("//input[@id='smiles']")).sendKeys("gulucuk");
        driver.findElement(By.xpath("//input[@id='nature']")).sendKeys("Doga");
        driver.findElement(By.xpath("//input[@id='food']")).sendKeys("Iskender");
        driver.findElement(By.xpath("//input[@id='activities']")).sendKeys("Tenis");
        driver.findElement(By.xpath("//input[@id='places']")).sendKeys("Miami");
        driver.findElement(By.xpath("//input[@id='objects']")).sendKeys("Cicek");
        driver.findElement(By.xpath("//input[@id='symbols']")).sendKeys("Ayicik");
        driver.findElement(By.xpath("//input[@id='flags']")).sendKeys("Turk Bayragi");
        driver.findElement(By.xpath("//input[@id='hide']")).sendKeys("Feel");
        driver.findElement(By.xpath("//input[@id='active']")).sendKeys("fifi");


        // apply button a basiniz
        driver.findElement(By.id("send")).click();

        bekle(3);


    }
}
