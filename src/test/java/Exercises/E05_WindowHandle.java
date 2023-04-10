package Exercises;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class E05_WindowHandle extends TestBase {
    @Test
    public void test() {


        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //   İlk sayfanın ID'sini(Window Handle değerini) alın.
        String ilkSayfaWindowHandle = driver.getWindowHandle();

        //   Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfaTexti = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("Opening a new window", sayfaTexti.getText());


        //   Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        Assert.assertEquals("The Internet", actualTitle);

        //   "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
//Açılan pencereye geçin.
        switchToWindow(1);
        bekle(1);
//Açılan yeni pencerenin sayfa başlığının(title) "New Window" olduğunu doğrulayın.
        String actuelbaslik=driver.getTitle();
        assertEquals("New Window" , actuelbaslik);
        bekle(1);
//Bir önceki pencereye dönüp sayfa başlığının "The Internet" olduğunu  doğrulayın.
        switchToWindow(0);
        bekle(1);
//2. pencereye tekrar geçin.
        switchToWindow(1);
        bekle(1);
//1. pencereye tekrar dönün.
        switchToWindow(0);

    }
}