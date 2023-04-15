package day14_FakerClass_FileExist;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {


    @Test
    public void fileExist() {
        //Masaustunde bir dosya olusturalim
        //Bu dosyanin varligini dogrulayalim

        System.out.println(System.getProperty("user.dir"));//C:\Users\fatma\IdeaProjects\B129SeleniumMavenJunit
        //Projemizin icinde bulundugu yolu verir

        System.out.println(System.getProperty("user.home"));//C:\Users\fatma
        //Localimizideki(bilgisayarimizdaki) kullanici yolunu verir.

        String dosyayolu="C:\\Users\\fatma\\Desktop\\b129.txt";
        String fakliKisim=System.getProperty("user.home");//her kullanicinin ana yolu farkli oldugu icin farkli kisim dedik
        String ortakKisim="\\Desktop\\b129.txt";//Ayni yerde olusturuldugu icin ortakKisim dedik
        String dosyaYolu=fakliKisim+ortakKisim;//dosya yolu olarak farkliKisim ve OrtakKisim aldik


        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
       // Files.exists() method'u ile dosyanin varligini dogruladik



    }
}
