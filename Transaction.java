package OrnekAraba;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Transaction {
	// Getter-setter kullanýlmadý çünkü veriler sadece bu classta kullanýldý.
    private String alinacakSehir;
    private Date alinacakGun;
    private double alisSaati;
    private Date teslimGunu;
    private double teslimSaati;
    List<Transaction> girilenÝslemler = new ArrayList<>();

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

        // Date alýp kaç gün kiralanacaðýný bulacaðýz ve fiyatý ona göre ayarlayacaðýz
        long difference_In_Time
                = this.teslimGunu.getTime() - this.alinacakGun.getTime();
        int fark = (int) (TimeUnit
                .MILLISECONDS
                .toDays(difference_In_Time)
                % 365);

        toplam = (int) (Vehicle.dailyPrice * fark);

        return toplam;
    }

    void islemler() { // Kullanýcýdan alýnacak tarih saat ve þehir bilgisi...
        Scanner scan = new Scanner(System.in);
        try { // Olasý exceptionslara karþý try-catch kullanýldý.
            System.out.print("Almak istediðiniz þehir : ");
            String city = scan.next();

            // Bunu internetten çarptým :)
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            System.out.println("Alýþ Tarihi þu þekilde girin (gg.aa.yy):");
            String alým = scan.next();
            if (null != alým && alým.trim().length() > 0) {
                this.alinacakGun = format.parse(alým);
            }
            System.out.println("Alým Saati seçin");
            double saat1 = scan.nextDouble();

            SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
            System.out.println("Teslim Tarihi þu þekilde girin (gg.aa.yy):");
            String teslim = scan.next();
            if (null != teslim && teslim.trim().length() > 0) {
                this.teslimGunu = format1.parse(teslim);
            }
            System.out.println("Teslim Saati seçin");
            double saat2 = scan.nextDouble();
            Transaction transaction = new Transaction(city, this.alinacakGun, saat1, this.teslimGunu, saat2);
            girilenÝslemler.add(transaction);

            System.out.println("Ödemeniz gereken toplam ücret : " + topFiyat() + " TL'dir");
        } catch (Exception e) {
            System.out.println("Lütfen istenen bilgileri doðru bir þekilde girin...");
            islemler();
        }
    }

    @Override
    public String toString() {
        return "Alýnacak Þehir : '" + alinacakSehir + '\'' +
                ", Alýnacak Gün : " + alinacakGun +
                ", Alýþ Saati : " + alisSaati +
                ", Teslim Günü : " + teslimGunu +
                ", Teslim Saati : " + teslimSaati;
    }
}
