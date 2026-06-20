package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class LatihanMandiri1 {
    public static void main(String[] args) {
        
        // =========================================================================
        // SOAL 1: Memeriksa keberadaan dan ukuran file 'laporan.txt'
        // =========================================================================
        System.out.println("--- SOAL 1 ---");
        File laporan = new File("laporan.txt");
        
        if (laporan.exists()) {
            System.out.println("Berkas 'laporan.txt' ditemukan.");
            System.out.println("Ukuran berkas: " + laporan.length() + " byte");
        } else {
            System.out.println("Berkas 'laporan.txt' tidak ada/tidak ditemukan.");
        }
        System.out.println(); // Baris baru untuk kerapian output


        // =========================================================================
        // SOAL 2: Membuat folder baru bernama 'arsip' dengan mkdir()
        // =========================================================================
        System.out.println("--- SOAL 2 ---");
        File folderArsip = new File("arsip");
        
        if (folderArsip.mkdir()) {
            System.out.println("Berhasil: Folder 'arsip' telah dibuat.");
        } else {
            System.out.println("Gagal: Folder 'arsip' gagal dibuat (mungkin sudah ada sebelumnya).");
        }
        System.out.println();


        // =========================================================================
        // SOAL 3: Membuat, memeriksa, dan menghapus 'sementara.txt'
        // =========================================================================
        System.out.println("--- SOAL 3 ---");
        File fileSementara = new File("sementara.txt");
        
        try {
            // 1. Membuat berkas baru
            if (fileSementara.createNewFile()) {
                System.out.println("Berkas 'sementara.txt' berhasil dibuat.");
            } else {
                System.out.println("Berkas 'sementara.txt' sudah ada sebelumnya.");
            }
            
            // 2. Tampilkan status keberadaan SEBELUM dihapus
            System.out.println("Status keberadaan sebelum dihapus: " + fileSementara.exists());
            
            // 3. Menghapus berkas dengan method delete()
            if (fileSementara.delete()) {
                System.out.println("Berkas 'sementara.txt' berhasil dihapus.");
            } else {
                System.out.println("Gagal menghapus berkas 'sementara.txt'.");
            }
            
            // 4. Tampilkan status keberadaan SESUDAH dihapus
            System.out.println("Status keberadaan sesudah dihapus: " + fileSementara.exists());
            
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan I/O pada Soal 3: " + e.getMessage());
        }
    }
}