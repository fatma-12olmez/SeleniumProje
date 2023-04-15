package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class E14_RelativeLocators extends TestBase {

    @Test
    public void test() {
// 1.) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

// 2.) Berlin'i 3 farkli relative locator ile locate edin
        WebElement NYC=driver.findElement(By.id("pid3_thumb"));
        WebElement sailor=driver.findElement(By.id("pid11_thumb"));
        WebElement BayArea=driver.findElement(By.id("pid8_thumb"));
        WebElement berlin=driver.findElement(with(By.tagName("img")).above(sailor).below(NYC).toLeftOf(BayArea));
        berlin.click();

        // 3 ) Relative locator'larin dogru calistigini test edin

        //Relative locator’larin dogru calistigini test edin
        /*
        String actualIdDegeri=berlin.getAttribute("id");
        String expectedIDDegeri="pid7_thumb";
        if (actualIdDegeri.equals(expectedIDDegeri)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

         */
        String actualIdDegeri=berlin.getAttribute("id");
        Assert.assertEquals("pid7_thumb",actualIdDegeri);

    }
}
