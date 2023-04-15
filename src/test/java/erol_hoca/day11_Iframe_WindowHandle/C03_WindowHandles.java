package day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C03_WindowHandles extends TestBase {
    /*
   https://the-internet.herokuapp.com/windows adresine gidin.
   İlk sayfanın ID'sini(Window Handle değerini) alın.
   Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
   Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
   "Click Here" butonuna tıklayın.
   Açılan pencereye geçin.
   Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
   Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
   2. pencereye tekrar geçin.
   1. pencereye tekrar dönün.
    */

    @Test
    public void WindowHandles() {
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

        //   Açılan pencereye geçin.
        /*
        Eger bir button'a click yaptigimizda bizim kontrolumuz disinda yeni bir pencere aciliyorsa ,
        o pencereye icindeki webelementleri handle edebilmem icin o switchTo() method'u ile gecis yapmam gerekir
        fakat kontrolumuz disinda acildigi icin handle degerini bilmedigimiz icin tum acilan pencereleri getWindowHandles()
        method'unu kullanarak bir Set'e assign ederiz .Yada ArryList'e assign ederiz

                */

        Set<String> tumPencereler = driver.getWindowHandles();
        for (String w : tumPencereler) {
            if (!w.equals(ilkSayfaWindowHandle)) {
                driver.switchTo().window(w);
            }
        }       //Burda amac bizim kontrolumuz disinda acilan pencereye gecis yapmak


        // List<String> tumWindowHandles=new ArrayList<String >(driver.getWindowHandles());
        // driver.switchTo().window(tumWindowHandles.get(1));  *********bu sekilde de yapilir


        //   Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
        String gercekBaslik = driver.getTitle();
        Assert.assertEquals("New Window", gercekBaslik);
        String ikinciSayfaHandleDegeri = driver.getWindowHandle();

        //   Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(ilkSayfaWindowHandle);
        Assert.assertEquals("The Internet", driver.getTitle());
        bekle(3);

        //   2. pencereye tekrar geçin.
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        bekle(3);

        //   1. pencereye tekrar dönün.
        driver.switchTo().window(ilkSayfaWindowHandle);

    }
}
