package day14_FakerClass_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownloadTest extends TestBase {
    @Test
    public void fileDownloadTest() {

        //https://testcenter.techproeducation.com/index.php?page=file-download    adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        bekle(2);
        File silinecekDosya = new File("C:\\Users\\fatma\\Downloads\\b10 all test cases, code.docx");
        silinecekDosya.delete();
        //Eger localinizden otomasyon ile bir dosya silmek icin file class'indan obje olusturup dosya yolumuzu icine yerlestiririz.
        //Ve olusturdugumuz obje ile delete() method'unu kullanarako dosyayi silebiliriz
        // Bunu yapma sebebimiz test classlarimizi calistirdigimizda her calistirmada yeni bir dosya create edecegi icin
        // oradaki dosya kalabaligini onlemis oluruz ayni zamanda dogrulama yaparken isimizi garantiye almis oluruz
        //birden fazla dosya indirmis olsak ayni isimde her indirilen yanina index verecegi icin ve bizim ilk indirdigimiz
        // o klasorun icinde bulunacagi icin  her zaman ilk dosyanin varligini test etmis oluruz.

        //b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='b10 all test cases, code.docx']")).click();
        bekle(3);

        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        //Dosya yolunu aliyoruz
        String dosyaYolu = System.getProperty("user.home") + "/Downloads/b10 all test cases, code.docx";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
