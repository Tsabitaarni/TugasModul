import com.sun.tools.javac.Main;

import java.util.Scanner;

class Mahasiswa {
    public static String[] namaMahasiswa = new String[10];
    public static String[] fakultas = new String[10];
    public static String[] nim = new String[10];
    public static String[] programStudi = new String[10];
    public static String[] bukuTerpinjam = new String[10];

    int cekMahasiswa(){
        Scanner scanString = new Scanner (System.in);
        System.out.print("Masukkan NIM Anda (input 99 untuk kembali): ");
        String input = scanString.nextLine();
        if (input.equals("99")) {
            System.out.println("Kembali ke menu awal...");
            return 0;
        }
        for (int i = 0; i < nim.length; i++) {
            if (input.equals(nim[i])) {
                System.out.println("Sukses login sebagai mahasiswa\n");
                return 1;
            }
        }
        System.out.println("NIM tidak ditemukan\n");
        return 0;
    }

    void pinjamBuku(int j){
        Main perpustakaan = new Main();
        Scanner scanString = new Scanner (System.in);
        System.out.println("Masukkan ID buku yang ingin Anda pinjam (input 99 untuk kembali)");
        System.out.print("Input: ");
        String idBuku = scanString.nextLine();
        if (idBuku.equals("99")) {
            System.out.println("Kembali ke menu awal...");
            return;
        }
        for (int i = 0; i < perpustakaan.idBuku.length; i++) {
            if (idBuku.equals(perpustakaan.idBuku[i])) {
                System.out.println("Buku dengan ID " + idBuku + " berhasil dipinjam");
                perpustakaan.stok[i] -= 1;
                break;
            }
        }
        bukuTerpinjam[j] = idBuku;
    }

    void tampilkanBukuTerpinjam(){
        System.out.println("Buku terpinjam: ");
        for (int i = 0; i < bukuTerpinjam.length; i++) {
            if (bukuTerpinjam[i] == null) {
                break;
            } else {
                System.out.printf("%d. %s", i+1, bukuTerpinjam[i]);
            }
        }
    }
}

class Pengelola {
    Mahasiswa mahasiswa = new Mahasiswa();
    public static String namaPengelola = "admin";
    public static String kataSandi = "1231";
    public static int jumlahMahasiswa = 0;

    int cekPengelola(){
        Scanner scanString = new Scanner(System.in);
        System.out.print("Masukkan username Anda (admin): ");
        String user = scanString.nextLine();
        System.out.print("Masukkan password Anda (admin): ");
        String pass = scanString.nextLine();
        if (user.equals(namaPengelola) && pass.equals(kataSandi)) {
            System.out.println("Sukses login sebagai pengelola\n");
            return 1;
        }
        else {
            System.out.println("Pengelola tidak ditemukan\n");
            return 0;
        }
    }

    void tambahMahasiswa(){
        Scanner scanString = new Scanner(System.in);
        System.out.print("Masukkan nama mahasiswa: ");
        Mahasiswa.namaMahasiswa[jumlahMahasiswa] = scanString.nextLine();

        System.out.print("Masukkan fakultas mahasiswa: ");
        Mahasiswa.fakultas[jumlahMahasiswa] = scanString.nextLine();

        System.out.print("Masukkan NIM mahasiswa: ");
        Mahasiswa.nim[jumlahMahasiswa] = scanString.nextLine();
        while(true){
            if (String.valueOf(Mahasiswa.nim[jumlahMahasiswa]).length() != 15 ) {
                System.out.print("NIM Harus 15 Digit!!!\n");
                System.out.print("Masukkan NIM mahasiswa: ");
                Mahasiswa.nim[jumlahMahasiswa] = scanString.nextLine();
            } else {
                break;
            }
        }

        System.out.print("Masukkan program studi mahasiswa: ");
        Mahasiswa.programStudi[jumlahMahasiswa] = scanString.nextLine();

        System.out.print("Data mahasiswa berhasil ditambahkan.\n");
        jumlahMahasiswa++; // tambahkan jumlahMahasiswa setiap kali data mahasiswa ditambahkan
    }

    void tampilkanMahasiswa(){
        for (int j = 0; j < jumlahMahasiswa; j++) { // gunakan jumlahMahasiswa untuk mengakses data sebanyak yang telah ditambahkan
            System.out.println("\nData mahasiswa ke " + (j+1));
            System.out.println("Nama: " + Mahasiswa.namaMahasiswa[j]);
            System.out.println("Fakultas: " + Mahasiswa.fakultas[j]);
            System.out.println("NIM: " + Mahasiswa.nim[j]);
            System.out.println("Program Studi: " + Mahasiswa.programStudi[j]);
        }
    }

}

public class Main {
    //data buku
    public static String[] idBuku = new String[] {"388c-e681-9152", "ed90-be30-5cdb", "d95e-0c4a-9523"};
    public static String[] namaBuku = new String[] {"judul", "judul", "judul"};
    public static String[] pengarang = new String[] {"pengarang", "pengarang", "pengarang"};
    public static String[] kategori = new String[] {"Sejarah", "Sejarah", "Sejarah"};
    public static int[] stok = new int[] {4, 0, 2};

    void tampilkanMenuUtama(){
        System.out.println("\n==== Sistem Perpustakaan ====");
        System.out.println("1. Masuk sebagai Mahasiswa");
        System.out.println("2. Masuk sebagai Pengelola");
        System.out.println("3. Keluar");
        System.out.print("Pilihan Anda: ");
    }

    void tampilkanMenuMahasiswa(){
        System.out.println("\n==== Menu Mahasiswa ====");
        System.out.println("1. Daftar Buku Terpinjam");
        System.out.println("2. Pinjam Buku");
        System.out.println("3. Logout");
        System.out.print("Pilihan Anda: ");
    }

    void tampilkanMenuPengelola(){
        System.out.println("\n==== Menu Pengelola ====");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Tampilkan Daftar Mahasiswa Terdaftar");
        System.out.println("3. Logout");
        System.out.print("Pilihan Anda: ");
    }

    void tampilkanDaftarBuku(){
        System.out.println("===========================================================================================================================================");
        System.out.println("|| No. || ID Buku\t\t\t\t || Nama Buku\t\t || Pengarang\t\t || Kategori\t || Stok\t || ");
        for (int i = 0; i < 3; i++){
            System.out.printf("|| %d   || %s\t\t || %s\t\t\t || %s\t\t || %s\t\t || %d\t\t || \n", i, idBuku[i], namaBuku[i], pengarang[i], kategori[i], stok[i]);
        }
        System.out.println("===========================================================================================================================================");
    }

    public static void main(String[] args) {
        Mahasiswa mahasiswa = new Mahasiswa();
        Pengelola pengelola = new Pengelola();
        ProgramUtama programUtama = new ProgramUtama();
        while (true) {
            programUtama.tampilkanMenuUtama();
            Scanner scanInt = new Scanner(System.in);
            int pilih = scanInt.nextInt();
            if (pilih == 1) {
                if (mahasiswa.cekMahasiswa() == 0) {
                    continue;
                }
                int j = 0;
                while (true) {
                    programUtama.tampilkanMenuMahasiswa();
                    pilih = scanInt.nextInt();
                    if (pilih == 1){
                        mahasiswa.tampilkanBukuTerpinjam();
                    } else if (pilih == 2){
                        programUtama.tampilkanDaftarBuku();
                        mahasiswa.pinjamBuku(j);
                        j++;
                    } else {
                        break;
                    }
                }
            } else if (pilih == 2) {
                if (pengelola.cekPengelola() == 0) {
                    continue;
                }
                while (true) {
                    programUtama.tampilkanMenuPengelola();
                    pilih = scanInt.nextInt();
                    if (pilih == 1) {
                        pengelola.tambahMahasiswa();
                    } else if (pilih == 2) {
                        pengelola.tampilkanMahasiswa();
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
    }
}
