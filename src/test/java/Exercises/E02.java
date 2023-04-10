package Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class E02 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        //“https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //Username kutusuna “standard_user” yazdirin
      WebElement Aramakutusu= driver.findElement(By.xpath("//input[@class='input_error form_input'][1]"));
      Aramakutusu.sendKeys("standard_user", Keys.ENTER);

        //Password kutusuna “secret_sauce” yazdirin
        WebElement Passwordkutusu= driver.findElement(By.cssSelector("input[id='password']"));
        Passwordkutusu.sendKeys("secret_sauce", Keys.ENTER);
        //Login tusuna basin
        driver.findElement(By.id("login-button")).click();
        //Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

        //Add to Cart butonuna basin
        //Alisveris sepetine tiklayin
        //Sectiginiz urunun basarili olarak sepete eklendigini control edin
        //Sayfayi kapatin
    }
}
