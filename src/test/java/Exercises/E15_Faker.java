package Exercises;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class E15_Faker extends TestBase {
    @Test
    public void test01() {
        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
        driver.findElement(By.xpath("//*[text()='Autoriser les cookies essentiels et optionnels']")).click();

        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//*[text()='Créer nouveau compte']")).click();

        //“firstName” giris kutusuna bir isim yazin
        Faker faker = new Faker();
        faker.name().firstName();
        driver.findElement(By.xpath("(//*[@type='text'])[2]")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("(//*[@type='text'])[3]")).sendKeys(faker.name().lastName());
        //“email” giris kutusuna bir email yazin
        driver.findElement(By.xpath("(//*[@type='text'])[4]")).sendKeys(faker.internet().emailAddress());


        //Bir sifre girin
        driver.findElement(By.id("password_step_input")).sendKeys(faker.internet().password());
        //Tarih icin gun secin
        driver.findElement(By.id("day")).sendKeys("01");
        //Tarih icin ay secin
        driver.findElement(By.id("month")).sendKeys("Avril");
        //Tarih icin yil secin
        driver.findElement(By.id("year")).sendKeys("1994");

        //Cinsiyeti secin
       WebElement button= driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
       button.click();
        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        System.out.println(button.isSelected());
        WebElement button2= driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        System.out.println(button2.isSelected());
        //Sayfayi kapatin
        driver.close();

    }

}
