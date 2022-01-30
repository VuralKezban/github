package OrnekAraba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
	// Getter-setter kullan�lmad� ��nk� veriler sadece bu classta kullan�ld�.
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

        try { // Olas� exceptionslara kar�� try-catch kullan�ld�.
            Scanner scan = new Scanner(System.in);
            System.out.print("�sminizi girin : ");
            String name = scan.next().toUpperCase();
            System.out.print("Soyisminizi girin : ");
            String surname = scan.next().toUpperCase();
            System.out.print("Ya��n�z� girin : ");
            String age = scan.next();
            System.out.print("Telefonunuzu girin : ");
            String phone = scan.next();
            System.out.print("Kimlik numaran�z� girin : ");
            String id = scan.next();
            id = id.substring(0, 3) + id.replaceAll("\\d", "*");
            System.out.print("Kredi kart� numaran�z� girin : ");
            String creditCard = scan.next();
            creditCard = creditCard.substring(0, 3) + creditCard.replaceAll("\\d", "*");
            Client client = new Client(name, surname, age, phone, id, creditCard);
            girilenMusteri.add(client);
        } catch (Exception e) {
            System.out.println("L�tfen istenen bilgileri do�ru bir �ekilde girin...");
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
