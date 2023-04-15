package Exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class E12_Locators extends TestBase {
    @Test
    public void test01() {
        //1- https://the-internet.herokuapp.com/add_remove_elements/https://the-internet.herokuapp.com/add_remove_elements/ adresine  gidin
        driver.navigate().to("https://the-internet.herokuapp.com/add_remove_elements/");
        // 2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        //3. Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        deleteButton.isDisplayed();
        //4. Delete tusuna basin
        driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();
        //5. “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement removeElements = driver.findElement(By.xpath("//h3"));
        removeElements.isDisplayed();
    }
}
