package day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C02_WindowHandle extends TestBase {


    @Test
    public void WindowHandle() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
         String techproWindowHandle = driver.getWindowHandle();//Techpro sayfasinin handle degerini bir String'e assign ettik
          System.out.println(techproWindowHandle);

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(actualTitle, expectedTitle);


        //Window 2'de https://www.youtube.com sayfasını açınız:

        driver.switchTo().//Gecis yap
                newWindow(WindowType.TAB);//-->Yeni bir pencere'ye driver'i tasir
        //WindowType.WINDOW-->Yeni pencerede acar
        //WindowType.TAB-->Yeni sekme acar
        driver.get("https://www.youtube.com");
         String youTubeWindowHandle= driver.getWindowHandle();//Youtube  sayfasinin handle degerini bir String'e assign ettik
        System.out.println(youTubeWindowHandle);

        //Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
         String linkednWindowHandle=driver.getWindowHandle();//Linkedin  sayfasinin handle degerini bir String'e assign ettik
          System.out.println(linkednWindowHandle);

        List<String> tumWindowList = new ArrayList<>(driver.getWindowHandles());
        //butun actigim pencerelerin handle degerlerini bir ArrayList'e atadik
/*
         switchToWindow(0);
         switchToWindow(1);
         switchToWindow(2);

 */


        //techproeducation sayfasına geçiniz:
        bekle(3);
         driver.switchTo().window(techproWindowHandle);
        driver.switchTo().window(tumWindowList.get(0));//-->Ilk actigimiz pencereye index ile gecebiliriz

        //youtube sayfasına geçiniz:
        bekle(3);
           driver.switchTo().window(youTubeWindowHandle);
       driver.switchTo().window(tumWindowList.get(1));
        //linkedIn sayfasına geçiniz:
        bekle(3);
          driver.switchTo().window(linkednWindowHandle);
       driver.switchTo().window(tumWindowList.get(2));


    }
}
