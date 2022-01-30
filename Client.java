package OrnekAraba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
	// Getter-setter kullanýlmadý çünkü veriler sadece bu classta kullanýldý.
    private String surname;
    private String name;
    private String age;
    private String phone;
    private String id;
    private String creditCard;
    List<Client> girilenMusteri = new ArrayList<>();

    public Client() {
    }

    public Client(String name, String surname, String age, String phone, String id, String creditCard) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.id = id;
        this.creditCard = creditCard;
    }

    void musteriInfo() {

        try { // Olasý exceptionslara karþý try-catch kullanýldý.
            Scanner scan = new Scanner(System.in);
            System.out.print("Ýsminizi girin : ");
            String name = scan.next().toUpperCase();
            System.out.print("Soyisminizi girin : ");
            String surname = scan.next().toUpperCase();
            System.out.print("Yaþýnýzý girin : ");
            String age = scan.next();
            System.out.print("Telefonunuzu girin : ");
            String phone = scan.next();
            System.out.print("Kimlik numaranýzý girin : ");
            String id = scan.next();
            id = id.substring(0, 3) + id.replaceAll("\\d", "*");
            System.out.print("Kredi kartý numaranýzý girin : ");
            String creditCard = scan.next();
            creditCard = creditCard.substring(0, 3) + creditCard.replaceAll("\\d", "*");
            Client client = new Client(name, surname, age, phone, id, creditCard);
            girilenMusteri.add(client);
        } catch (Exception e) {
            System.out.println("Lütfen istenen bilgileri doðru bir þekilde girin...");
            musteriInfo();
        }
    }

    @Override
    public String toString() {
        return "Name : '" + name + '\'' +
                ", Age : '" + age + '\'' +
                ", Phone : '" + phone + '\'' +
                ", Kimlik no : '" + id + '\'' +
                ", Credit Card : '" + creditCard;
    }
}
