package OrnekAraba;

import java.text.ParseException;

public class Runner {
	static Vehicle vehicle = new Vehicle();
    static Transaction transaction = new Transaction();
    static Client client = new Client();
    static Runner runner = new Runner();

    public static void main(String[] args) throws ParseException {
        vehicle.aracGoster();
        transaction.islemler();
        client.musteriInfo();
        runner.zRaporu();
    }

    void zRaporu() { // En son kiralamayla ilgili bilgileri tekrarddan fi� �eklinde versin dedik. // Makyaj yani :)
        System.out.println("Ara� kiralama i�lemi ba�ar�l�.\n============================" +
                "\nKiralama yapan ki�i bilgileri");
        for (int i = 0; i < client.girilenMusteri.size(); i++)
            System.out.println(client.girilenMusteri.get(i).toString());
        System.out.println("============================");
        System.out.println("Kiralama yap�lan ara� bilgileri");
        for (int i = 0; i < vehicle.secilenArac.size(); i++) System.out.println(vehicle.secilenArac.get(i).toString());
        System.out.println("============================");
        System.out.println("Kiralama tarih bilgileri");
        for (int i = 0; i < transaction.girilen�slemler.size(); i++)
            System.out.println(transaction.girilen�slemler.get(i).toString());
        System.out.println("============================");
        System.out.println("Toplam �deme tutar� : "+ transaction.topFiyat()+ " TL");
    }
}
