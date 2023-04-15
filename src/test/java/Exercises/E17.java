package Exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class E17 extends TestBase {
    @Test
    public void test01() {
        //  -https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");

        //  -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        driver.switchTo().frame(0);

        Actions actions = new Actions(driver);
        WebElement kirmizi =driver.findElement(By.xpath("//div[@id='red']"));
        WebElement yesil =driver.findElement(By.xpath("//div[@id='green']"));
        WebElement mavi =driver.findElement(By.xpath("//div[@id='blue']"));




        actions.dragAndDropBy(kirmizi, 150, 0).release().build().perform();
        actions.dragAndDropBy(yesil, -150, 0).release().build().perform();
        actions.dragAndDropBy(mavi, -150, 0).release().build().perform();



        //   -Sarı olduğunu test edelim


        actions.dragAndDropBy(yesil, 150, 0).release().build().perform();
        bekle(2);
        actions.dragAndDropBy(mavi, -150, 0).release().build().perform();
        bekle(2);



        WebElement sariMi = driver.findElement(By.xpath("//div[@id='swatch']"));
        String backgroundColor = sariMi.getCssValue("background-color");



        if(backgroundColor.equals("rgba(255, 255, 0)")){
            System.out.println("sari oldu");
        }else {
            System.out.println("sari olmadi");
        }




    }

    }
