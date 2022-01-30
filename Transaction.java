package OrnekAraba;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Transaction {
	// Getter-setter kullan�lmad� ��nk� veriler sadece bu classta kullan�ld�.
    private String alinacakSehir;
    private Date alinacakGun;
    private double alisSaati;
    private Date teslimGunu;
    private double teslimSaati;
    List<Transaction> girilen�slemler = new ArrayList<>();

    public Transaction() {
    }

    public Transaction(String alinacakSehir, Date alinacakGun, double alisSaati, Date teslimGunu, double teslimSaati) {
        this.alinacakSehir = alinacakSehir;
        this.alinacakGun = alinacakGun;
        this.alisSaati = alisSaati;
        this.teslimGunu = teslimGunu;
        this.teslimSaati = teslimSaati;
    }

    double topFiyat() {
        int toplam;

        // Date al�p ka� g�n kiralanaca��n� bulaca��z ve fiyat� ona g�re ayarlayaca��z
        long difference_In_Time
                = this.teslimGunu.getTime() - this.alinacakGun.getTime();
        int fark = (int) (TimeUnit
                .MILLISECONDS
                .toDays(difference_In_Time)
                % 365);

        toplam = (int) (Vehicle.dailyPrice * fark);

        return toplam;
    }

    void islemler() { // Kullan�c�dan al�nacak tarih saat ve �ehir bilgisi...
        Scanner scan = new Scanner(System.in);
        try { // Olas� exceptionslara kar�� try-catch kullan�ld�.
            System.out.print("Almak istedi�iniz �ehir : ");
            String city = scan.next();

            // Bunu internetten �arpt�m :)
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            System.out.println("Al�� Tarihi �u �ekilde girin (gg.aa.yy):");
            String al�m = scan.next();
            if (null != al�m && al�m.trim().length() > 0) {
                this.alinacakGun = format.parse(al�m);
            }
            System.out.println("Al�m Saati se�in");
            double saat1 = scan.nextDouble();

            SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
            System.out.println("Teslim Tarihi �u �ekilde girin (gg.aa.yy):");
            String teslim = scan.next();
            if (null != teslim && teslim.trim().length() > 0) {
                this.teslimGunu = format1.parse(teslim);
            }
            System.out.println("Teslim Saati se�in");
            double saat2 = scan.nextDouble();
            Transaction transaction = new Transaction(city, this.alinacakGun, saat1, this.teslimGunu, saat2);
            girilen�slemler.add(transaction);

            System.out.println("�demeniz gereken toplam �cret : " + topFiyat() + " TL'dir");
        } catch (Exception e) {
            System.out.println("L�tfen istenen bilgileri do�ru bir �ekilde girin...");
            islemler();
        }
    }

    @Override
    public String toString() {
        return "Al�nacak �ehir : '" + alinacakSehir + '\'' +
                ", Al�nacak G�n : " + alinacakGun +
                ", Al�� Saati : " + alisSaati +
                ", Teslim G�n� : " + teslimGunu +
                ", Teslim Saati : " + teslimSaati;
    }
}
