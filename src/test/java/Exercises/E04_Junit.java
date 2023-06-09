package Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class E04_Junit {


    WebDriver driver;
    static List<WebElement> urunler;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @After
    public void tearDown() throws Exception {
        //- sayfayı kapatalım
           driver.close();
    }

    @Test
    public void test() throws InterruptedException {


        //- ebay sayfasına gidiniz
        driver.get("https://www.ebay.com/");
        //- electronics bölümüne tıklayınız
        driver.findElement(By.xpath("//*[@class='hl-cat-nav__js-tab'][2]")).click();
        //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        //- Her sayfanın sayfa başlığını yazdıralım
        //- Her sayfanın sayfa başlığını yazdıralım

        urunler = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
        for (int i = 0; i < urunler.size(); i++) {
            urunler = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            urunler.get(i).click();
            Thread.sleep(2000);
            System.out.println(i + 1 + ". başlık : " + driver.getTitle());
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);


        }
    }
}

