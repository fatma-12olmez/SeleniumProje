package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class E03_Iframe extends TestBase {
    @Test
    public void iframeTest() {      //● Bir metod olusturun: iframeTest
        //● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement text=driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        System.out.println(text.getText());
        System.out.println(text.isEnabled());

        //○Text Box’a “Merhaba Dunya!” yazin.
        driver.switchTo().frame(0);
      WebElement textBox=  driver.findElement(By.xpath("//*[@id='tinymce']"));
      textBox.sendKeys("Merhaba Dunya!");

        //○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur  oldugunu dogrulayin ve konsolda yazdirin
        driver.switchTo().defaultContent();
      WebElement elementalSelenium= driver.findElement(By.xpath(" //a[text()='Elemental Selenium']"));
        System.out.println(elementalSelenium.isDisplayed());


    }





}
