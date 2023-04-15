package day12_WindowHandles_BasicAut_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {

    //Aşağıdaki bilgileri kullanarak authentication yapınız:

    @Test
    public void test() {
    //    Url: https://the-internet.herokuapp.com/basic_auth
    //    Username: admin
    //    Password: admin
    //    Başarılı girişi doğrulayın.
    //Authentication Url: "https://admin:admin@the-internet.herokuapp.com/basic_auth"
  //  https://the-internet.herokuapp.com/basic_auth adresine gidiniz
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

    //Paragraf'in "Congratulations" kelimesini icerdigini dogrulayiniz
        WebElement  paragraf=driver.findElement(By.xpath("//p"));
        Assert.assertTrue(paragraf.getText().contains("Congratulations"));

    }
}