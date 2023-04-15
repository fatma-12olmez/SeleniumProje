package Exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class E16_ extends TestBase {
    //1. https://www.amazon.com/ sayfasina gidelim 2. arama kutusunu locate edelim

    @Test
    public void test01() {

        driver.get("https://www.amazon.com/");
// 3. "Samsung headphones" ile arama yapalim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Samsung headphones" , Keys.ENTER);

        // 4. Bulunan sonuc sayisini yazdiralim
        WebElement sonuc=  driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonuc.getText());
        String arr1[]=sonuc.getText().split(" ");
        String  sonuc2=arr1[2];
        System.out.println(sonuc2);

//5. Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

/*
  for (int i = 0; i < 24; i++) {
            List<WebElement> resimler = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
            resimler.get(i).click();
            System.out.println(i + " . Title " + driver.getTitle());
            driver.navigate().back();
 */

//6. Sayfadaki tum basliklari yazdiralim
//sayfadaki tum basliklari yazdirmak icin bu sekilde bir yol izlemeliyiz

        List<WebElement> basliklar=driver.findElements(By.tagName("h1"));
        for (WebElement w: basliklar){

            System.out.println(w.getText());
        }
//Lambda ile cozumu

        // driver.findElements(By.tagName("h1"))
//   .forEach(title -> System.out.println(title.getText()));

    }

}
