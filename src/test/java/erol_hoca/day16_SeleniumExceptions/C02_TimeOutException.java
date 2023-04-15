package day16_SeleniumExceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_TimeOutException extends TestBase {
    @Test
    public void TimeOutException() {
        /*
        TimeOutException:
            Sayfada aradığımız elementi wait ile belirlediğimiz max. sürede bulamadığı durumda
        TimeOutException hatası alırız.
         */

        driver.get("https://techproeducation.com");
        bekle(5);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için
        //TimeOutException alabilmek için visibleofelementlocator methodunu kullanarak yanlis bir locate aldık
        visibleWait(By.id("Yanlis Locate"),15);//org.openqa.selenium.TimeoutException:

        //Webelementi beklerlerken o webelemtin locati'ni bulamadığı için max. belirttiğimiz süre kadar bekler ve
        //org.openqa.selenium.TimeoutException hatasını verir
        /*
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='ssearch']")));
         */
    }
    @Test
    public void TimeOutExceptionTest2() {
        //https://the-internet.herokuapp.com/dynamic_loading/1 adresine gidelim
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");


       //start butonuna tıklayalım
        driver.findElement(By.xpath("//*[text()='Start']")).click();

        //Hello World textinin ciktigini dogrulayiniz
       WebElement helloWordText= driver.findElement(By.xpath("(//h4)[2]"));
       visibleWait(helloWordText,2);//org.openqa.selenium.TimeoutException:
        //HelloWord yazisi ortalama 6 saniye de gozuktugu icin explicit wait'te max. 2 sn verdigimizden dolayi  org.openqa.selenium.TimeoutException:hatasi aldik
        Assert.assertTrue(helloWordText.isDisplayed());



    }
}
