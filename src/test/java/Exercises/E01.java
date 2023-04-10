package Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class E01 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        //https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        //cookies uyarisini kabul ederek kapatin
        driver.findElement(By.cssSelector("button[id='L2AGLb']")).click();

        //Sayfa basliginin “Google” ifadesi icerdigini test edin
       String actualTitle= driver.getTitle();
       String expectedTitle="Google";
       if (actualTitle.equals(expectedTitle)){
           System.out.println("TEST PASSED");
       }else {
           System.out.println("TEST FAILED");
       }
        //Arama cubuguna “Nutella” yazip aratin
        WebElement aramaKutusu=driver.findElement(By.cssSelector("input[class='gLFyf']"));
       aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        //Bulunan sonuc sayisini yazdirin
       WebElement sonucSayisi= driver.findElement(By.cssSelector("div[id='result-stats'"));
        String [] sonuc=sonucSayisi.getText().split(" ");
        System.out.println("Bulunan sayi " + sonuc[1]);

        //sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        //Sayfayi kapatin
        driver.close();
    }
}