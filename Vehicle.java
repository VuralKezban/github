
package OrnekAraba;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vehicle extends Data {

    // Getter-setter kullan�lmad� ��nk� veriler sadece bu classta kullan�ld�.
    private String marka;
    private String model;
    static double dailyPrice;
    private String yakitTuru;
    private String vitesTuru;
    String randomStr;
    static int secim;
    List<Vehicle> secilenArac = new ArrayList<>();

    public Vehicle() {
    }

    public Vehicle(String marka, String model, String yakitTuru, String vitesTuru) {
        this.marka = marka;
        this.model = model;
        this.yakitTuru = yakitTuru;
        this.vitesTuru = vitesTuru;
    }

    void aracGoster() {
        //getMarkalar();
        int devam;
        do { // Data classtaki arraylari burada d�nd�rece�iz. Kullan�c� araba marka ve model, yak�t t�r� ve vites t�r� se�ece�iz.
            // Hepsinin fiyat� farkl� d�necek. Araba kiralamaya uygun de�ilse men�ye d�necek, uygunsa ilerleme veya men�ye d�nme se�ene�i var.

            try {  // Olas� exceptionslara kar�� try-catch kullan�ld�.
                dailyPrice = 0.0;
                System.out.println("=========RENT A CAR'A HO�GELD�N�Z========");
                System.out.println("Listeden araba markas� se�iniz...");
                Scanner scan = new Scanner(System.in);
                for (int j = 0; j < getMarkalar().size(); j++) {
                    System.out.println((j + 1) + ". : " + getMarkalar().get(j) + " - " + getModeller().get(j));
                }
                // System.out.println("7. Di�er");
                secim = scan.nextInt();
                switch (secim) { // Yukar�daki ara� listesinden se�ilenleri burada g�sterece�iz.
                    case 1, 2, 3, 4, 5, 6, 7 -> {
                        System.out.println("----------------------------");
                        System.out.println("Se�ilen yak�t t�r� : " + yakit());
                        System.out.println("Se�ilen vites t�r� : " + vites());
                        dailyPrice += getDailyPrice().get(secim - 1);
                        System.out.println("----------------------------");
                        System.out.println("Se�ilen marka : " + getMarkalar().get(secim - 1) +
                                "\nSe�ilen model : " + getModeller().get(secim - 1));
                        System.out.println(randomRent());
                        if (this.randomStr.equalsIgnoreCase("Araba kiralamaya uygun de�il.")) {
                            aracGoster();
                        } else {
                            // Se�ilen ��eleri se�ilen ara� listine ekliyoruz. belki birden fazla ara� sececek
                            Vehicle vehicle = new Vehicle(getMarkalar().get(secim - 1), getModeller().get(secim - 1), this.yakitTuru, this.vitesTuru);
                            secilenArac.add(vehicle);
                        }
                    }
                }
                System.out.println("Devam etmek i�in 1'e; Ana men�ye d�nmek i�in 0'a bas�n�z...");
                devam = scan.nextInt();
            } catch (Exception e) {
                System.out.println("--------------------------------------");
                System.out.println("L�tfen beklenen aral�ktaki say�lardan birini giriniz");
                System.out.println("--------------------------------------");
                devam = 0;
            }
        } while (devam != 1);
    }

    String yakit() { // Yak�t t�r� se�imi i�in method
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < getYakitTurleri().size(); i++)
            System.out.println((i + 1) + ". " + getYakitTurleri().get(i));
        System.out.print("Yak�t T�r�n� Se�iniz : ");
        int yakitSec = scan.nextInt();
        dailyPrice += getDailyPrice().get(yakitSec - 1);
        this.yakitTuru = getYakitTurleri().get(yakitSec - 1);
        return yakitTuru;
    }

    String vites() { // Vites t�r� se�imi i�in method
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < getVitesTurleri().size(); i++)
            System.out.println((i + 1) + ". " + getVitesTurleri().get(i));
        System.out.print("Vites T�r�n� Se�iniz : ");
        int vitesSec = scan.nextInt();
        dailyPrice += getDailyPrice().get(vitesSec - 1);
        this.vitesTuru = getVitesTurleri().get(vitesSec - 1);
        return vitesTuru;
    }

    String randomRent() {
        // Arac�n kirada olup olmad���n� random d�nd�r�yoruz.. %60 kiralamaya uygun olacak �ekilde ayarlan�r.
        int random = (int) (Math.random() * 100);
        this.randomStr = random < 60 ? "*****Araba kiralamaya uygun.\n" + "G�nl�k kiralama �creti : " + dailyPrice + " TL" :
                "*****Araba kiralamaya uygun de�il. L�tfen listeden ba�ka bir araba se�iniz.";

        return randomStr;
    }

    @Override
    public String toString() {
        return "Marka : '" + marka + '\'' +
                ", Model : '" + model + '\'' +
                ", Yak�t T�r� : '" + yakitTuru + '\'' +
                ", Vites T�r� : '" + vitesTuru;
    }
}
