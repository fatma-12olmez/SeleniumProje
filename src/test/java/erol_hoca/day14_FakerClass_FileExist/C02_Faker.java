package day14_FakerClass_FileExist;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_Faker {
    @Test
    public void faker() {

        //1.Faker objesi olustururuz.
        Faker faker = new Faker();
        //YADA Faker.instance() statik methodu ile de kullanabiliriz "Faker.instance().name().firstName()"
        //Faker.instance();

        //firstname yazdiralim
        System.out.println("Fake firstname: " + faker.name().firstName());

        //Lastname yazdiralim
        System.out.println(faker.name().lastName());

        //Kullanici adi yazdiralim
        System.out.println(faker.name().username());

        //Meslek ismi  yazdiralim
        System.out.println(faker.name().title());
        System.out.println(faker.job().position());

        //Sehir ismi  yazdiralim
        System.out.println(faker.address().city());

        // Ulke ismi yazdiralim
        System.out.println(faker.address().country());

        //adress yazdiralim
        System.out.println(faker.address().fullAddress());

        //telefon numarasi
        System.out.println(faker.phoneNumber().cellPhone());

        //Zipcode numarasi
        System.out.println(Faker.instance().address().countryCode());
        System.out.println(faker.address().zipCode());

        //rastgele 15 haneli bir numara
        System.out.println(faker.number().digits(15));

        //Email adress:
        System.out.println(Faker.instance().internet().emailAddress());


    }
}
