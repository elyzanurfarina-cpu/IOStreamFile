package tugas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Gudang {
    // Menampung banyak objek Barang dalam ArrayList
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private String namaBerkas;

    public Gudang(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    // Menambah objek barang ke dalam list
    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    // Menampilkan seluruh isi barang di gudang beserta nomor urut
    public void tampilkanSemua() {
        System.out.println("--- Daftar Barang di Gudang ---");
        if (daftarBarang.isEmpty()) {
            System.out.println("(Gudang kosong)");
        } else {
            for (int i = 0; i < daftarBarang.size(); i++) {
                System.out.println((i + 1) + ". " + daftarBarang.get(i).info());
            }
        }
    }

    // Menyimpan seluruh data barang dari ArrayList ke berkas teks
    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Barang b : daftarBarang) {
                penulis.println(b.keBaris());
            }
            System.out.println("Data barang berhasil disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data: " + e.getMessage());
        }
    }

    // Memuat data dari berkas teks kembali ke dalam ArrayList (Memecah 3 bagian)
    public void muatDariBerkas() {
        daftarBarang.clear(); // Bersihkan list terlebih dahulu
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                if (bagian.length == 3) {
                    String nama = bagian[0];
                    double harga = Double.parseDouble(bagian[1]);
                    int stok = Integer.parseInt(bagian[2]);
                    daftarBarang.add(new Barang(nama, harga, stok));
                }
            }
            System.out.println("Data barang berhasil dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat data: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Kesalahan format angka di dalam berkas: " + e.getMessage());
        }
    }

    // Menghitung total nilai persediaan (Harga dikali Stok seluruh barang)
    public double totalNilai() {
        double total = 0;
        for (Barang b : daftarBarang) {
            total += (b.getHarga() * b.getStok());
        }
        return total;
    }
}