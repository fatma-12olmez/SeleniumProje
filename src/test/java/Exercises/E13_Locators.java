package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class E13_Locators extends TestBase {
    @Test
    public void test() {

        // 2- https://www.amazon.com/ adresine gidin
        driver.navigate().to("https://www.amazon.com/");

        // 4.- Sayfayi "refresh" yapin
        driver.navigate().refresh();

        // 5. Sayfa basliginin "Spend less" ifadesi icerdigini test edin
        System.out.println(driver.getTitle().contains("Spend less"));


        // 6. Gift Cards sekmesine basin
        driver.findElement(By.xpath("//*[text()='Gift Cards']")).click();

        // 7. Birthday butonuna basin
        driver.findElement(By.xpath("(//*[@alt='Birthday'])[1]")).click();

        // 8.  Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@alt='Amazon.com eGift Card'])[1]")).click();

        // 9. Gift card details'den 25 $'i secin
        driver.findElement(By.id("gc-mini-picker-amount-1")).click();

        // 10-Urun ucretinin $25.00 oldugunu test edin
        WebElement urunFiyat = driver.findElement(By.id("gc-live-preview-amount"));
        Assert.assertEquals("$25.00", urunFiyat.getText());

        // 10-Sayfayi kapatin
         driver.close();
    }
}
