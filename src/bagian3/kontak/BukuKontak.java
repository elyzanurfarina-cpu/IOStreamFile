package bagian3.kontak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BukuKontak {
    // ArrayList yang menampung objek bertipe Kontak
    private ArrayList<Kontak> daftar = new ArrayList<>();
    private String namaBerkas;
    
    public BukuKontak(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }
    
    // Menambah satu kontak ke koleksi
    public void tambahKontak(Kontak kontak) {
        daftar.add(kontak);
    }
    
    // Menampilkan seluruh koleksi beserta nomor urut
    public void tampilkanSemua() {
        System.out.println("== Daftar Kontak ==");
        for (int i = 0; i < daftar.size(); i++) {
            Kontak k = daftar.get(i);
            System.out.println((i + 1) + ". " + k.info());
        }
    }
    
    // Menyimpan seluruh kontak ke berkas, satu kontak per baris
    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Kontak k : daftar) {
                penulis.println(k.keBaris());
            }
            System.out.println("Kontak disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }
    
    // Membaca kembali kontak dari berkas ke dalam ArrayList
    // DISESUAIKAN: memecah menjadi 3 bagian (Soal 2)
    public void muatDariBerkas() {
        daftar.clear();
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                // Diubah menjadi length == 3 untuk mendukung data email
                if (bagian.length == 3) {
                    daftar.add(new Kontak(bagian[0], bagian[1], bagian[2]));
                }
            }
            System.out.println("Kontak dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat: " + e.getMessage());
        }
    }
    
    public int jumlahKontak() {
        return daftar.size();
    }    

    // TAMBAHAN: Method untuk mencari kontak berdasarkan nama (Soal 1)
    public void cariKontak(String nama) {
        for (Kontak k : daftar) {
            if (k.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Kontak Ditemukan: " + k.info());
                return; // Keluar dari method karena data sudah ditemukan
            }
        }
        // Jika perulangan selesai dan tidak ada yang cocok
        System.out.println("Kontak dengan nama '" + nama + "' tidak ditemukan.");
    }

    // TAMBAHAN: Method untuk menghapus kontak berdasarkan nama (Soal 3)
    public void hapusKontak(String nama) {
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getNama().equalsIgnoreCase(nama)) {
                daftar.remove(i); // Menghapus kontak dari ArrayList
                System.out.println("Kontak '" + nama + "' berhasil dihapus.");
                simpanKeBerkas(); // Otomatis menyimpan perubahan terbaru ke berkas
                return; // Keluar dari method
            }
        }
        // Jika nama tidak ditemukan di dalam list
        System.out.println("Gagal menghapus, kontak '" + nama + "' tidak ditemukan.");
    }
}