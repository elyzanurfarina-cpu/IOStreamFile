package bagian2.bacatulis;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class LatihanMandiri2 {
    public static void main(String[] args) {
        String namaBerkas = "hari.txt";

        // =========================================================================
        // 1. Menulis 5 nama hari ke berkas, lalu membaca dan menampilkan ke layar
        // =========================================================================
        System.out.println("--- TUGAS 1: Menulis & Membaca 5 Hari ---");
        
        // Menulis ke berkas (Menimpa/Overwrite baru jika file sudah ada)
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            penulis.println("Senin");
            penulis.println("Selasa");
            penulis.println("Rabu");
            penulis.println("Kamis");
            penulis.println("Jumat");
            System.out.println("Berhasil menulis 5 nama hari ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menulis berkas: " + e.getMessage());
        }

        // Membaca kembali berkas dan menampilkan ke layar
        System.out.println("\nIsi berkas saat ini:");
        tampilkanIsiBerkas(namaBerkas);
        System.out.println();


        // =========================================================================
        // 2. Menambahkan (append) 2 nama hari lagi, lalu menampilkan seluruh isinya
        // =========================================================================
        System.out.println("--- TUGAS 2: Menambahkan (Append) 2 Hari ---");
        
        // Parameter 'true' pada FileWriter digunakan untuk mode append (menambah data)
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas, true))) {
            penulis.println("Sabtu");
            penulis.println("Minggu");
            System.out.println("Berhasil menambahkan 2 nama hari tanpa menghapus data lama.");
        } catch (IOException e) {
            System.out.println("Gagal menambah data berkas: " + e.getMessage());
        }

        // Menampilkan seluruh isi berkas setelah di-append
        System.out.println("\nIsi berkas setelah ditambahkan:");
        tampilkanIsiBerkas(namaBerkas);
        System.out.println();


        // =========================================================================
        // 3. Membaca berkas hari.txt lalu menghitung jumlah baris di dalamnya
        // =========================================================================
        System.out.println("--- TUGAS 3: Menhitung Jumlah Baris ---");
        
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            int jumlahBaris = 0;
            // Melakukan perulangan selama baris yang dibaca tidak kosong (null)
            while (pembaca.readLine() != null) {
                jumlahBaris++;
            }
            System.out.println("Banyaknya baris di dalam berkas " + namaBerkas + " adalah: " + jumlahBaris + " baris.");
        } catch (IOException e) {
            System.out.println("Gagal menghitung baris berkas: " + e.getMessage());
        }
    }

    /**
     * Method helper untuk membaca dan menampilkan isi berkas ke layar
     */
    private static void tampilkanIsiBerkas(String namaBerkas) {
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            int nomor = 1;
            while ((baris = pembaca.readLine()) != null) {
                System.out.println(nomor + ". " + baris);
                nomor++;
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca berkas: " + e.getMessage());
        }
    }
}