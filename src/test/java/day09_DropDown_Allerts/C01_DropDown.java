package day09_DropDown_Allerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    /*
    DropDown nedir?
    -AltBasliklarin oldugu  acilir menu listesi
    DropDown nasil automate edilir(Handle)?:
    a-DropDown menuyu ilk olarak locate ederiz
    b-Select objesi olustururuz
    c-Select objesinin dropDown menu Webelementi'nin icerigine ve seceneklerine erisim saglamasi icin
    SELECT sinifina arguman olarak locate ettigimiz webelementi koyariz
    Syntax: Select select =new Select(ddm Webelement)
    d-Select class'i sadece <select> tag'i ile olusturulmus dropdown menulere uygulanabilir.
    e-select objesi ddm'yi handle edebilmek icin 3 method kullanilir
           selectByVisibleText()==>Ddm'deki elemente gorunur  metin ile ulasmak icin kullanilir.
           selectByIndex() ==>Index ile ulasmak icin kullanilir(Index 0 dan baslar)
           selectByValue ==>Elementin degeri ile ulasmak icin kullanilir(option tag'indaki deger ile)
    f-getOptions()==> Locate ettigimiz ddm'deki tum secenekleri bize dondurur.
    g-getFirstSelectOption()==>Ddm'deki en son secili kalan ilk secenegi bize dondurur.


     */

    @Test
    public void test02() {
        /*
        //a. Tüm eyalet isimlerini yazdıralım
        WebElement tumEyaletler = driver.findElement(By.cssSelector("select[id='state']"));
        Select select = new Select(tumEyaletler);
        List<WebElement> stateList = select.getOptions();//Bütün options taglarını getir
        //for (WebElement w:stateList) {
        //    System.out.println(w.getText());
        // }
        stateList.forEach(t-> System.out.println(t.getText()));

         */

        //a. Tüm eyalet isimlerini yazdıralım
        List<WebElement> tumEyaletler = driver.findElements(By.xpath("//*[@id='state']//option"));
        System.out.println(tumEyaletler.get(2).getText());
        System.out.println("*******************************************");
        tumEyaletler.forEach(t -> System.out.println(t.getText()));
        //b. Sayfadaki tüm ddm lerdeki tüm seçenekleri(option) konsolda yazdırınız
        System.out.println("*******************************************");
        List<WebElement> eyaletlerList=driver.findElements(By.tagName("select"));
        eyaletlerList.forEach(t-> System.out.println(t.getText()));
        System.out.println("*******************************************");
        System.out.println(tumEyaletler.size());


    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();

    }
}
