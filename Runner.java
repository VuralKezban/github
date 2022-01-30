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

    void zRaporu() { // En son kiralamayla ilgili bilgileri tekrarddan fiþ þeklinde versin dedik. // Makyaj yani :)
        System.out.println("Araç kiralama iþlemi baþarýlý.\n============================" +
                "\nKiralama yapan kiþi bilgileri");
        for (int i = 0; i < client.girilenMusteri.size(); i++)
            System.out.println(client.girilenMusteri.get(i).toString());
        System.out.println("============================");
        System.out.println("Kiralama yapýlan araç bilgileri");
        for (int i = 0; i < vehicle.secilenArac.size(); i++) System.out.println(vehicle.secilenArac.get(i).toString());
        System.out.println("============================");
        System.out.println("Kiralama tarih bilgileri");
        for (int i = 0; i < transaction.girilenÝslemler.size(); i++)
            System.out.println(transaction.girilenÝslemler.get(i).toString());
        System.out.println("============================");
        System.out.println("Toplam ödeme tutarý : "+ transaction.topFiyat()+ " TL");
    }
}
