package Exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class E11_WebElement extends TestBase {
    @Test
    public void test01(){
        //a.web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        // b.Search(ara) "city bike"
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike", Keys.ENTER);

        // c.Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
      //  WebElement sonuc = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
     //   System.out.println(sonuc.getText().split(" ")[2]);

        //    c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        WebElement result = driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        System.out.println(result.getText().split(" ")[2]);

//    d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
       // driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

    }
}
