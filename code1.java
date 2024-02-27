import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class  code1 {
    public static void main(String[] args) {
        Scanner inputan = new Scanner(System.in);

        System.out.print("Masukkan namamu: ");
        String nama = inputan.nextLine();
        System.out.print("Masukkan jenis kelaminmu ? (P/L): ");
        String jenis = inputan.nextLine();
        char jenisKelamin = jenis.toUpperCase().charAt(0);
        System.out.print("Masukkan tanggal lahirmu  (yyyy-mm-dd): ");
        String tgl = inputan.nextLine();
        LocalDate tgllahir = LocalDate.parse(tgl);

        LocalDate sekarang = LocalDate.now();
        Period period = Period.between(tgllahir, sekarang);
        int umur = period.getYears();
        int bulan = period.getMonths();

        System.out.println("\nData Diri:");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + (jenisKelamin == 'L' ? "Laki-laki" : "Perempuan"));
        System.out.println("Tanggal Lahir: " + tgllahir);
        System.out.println("Umur: " + umur + " tahun " + bulan + " bulan");

        inputan.close();
    }

    public static class TugasModul1 {
    }
}