package Exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class E10_WebElement extends TestBase {


    @Test
    public void test01() {

        //a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//a")).click();
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        //b.  log in butonuna basin
        driver.findElement(By.xpath("//*[text()='Log in']")).click();

        //c. email textbox,password textbox, and  log in button elementlerini locate ediniz..
        WebElement emailKutusu = driver.findElement(By.id("email"));
        WebElement passwordKutusu = driver.findElement(By.id("password"));
        //d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (log in)buttonunu tıklayın:
        emailKutusu.sendKeys("testtechproed@gmail.com");
        passwordKutusu.sendKeys("Test1234!");
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block")).click();

        //i. Username : testtechproed@gmail.com
        //ii. Password : Test1234!
        //e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).

        //f. "Addresses" ve "Sign Out" textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        //3. Sayfada kac tane link oldugunu bulun.



    }
}
