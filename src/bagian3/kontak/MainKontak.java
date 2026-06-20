package bagian3.kontak;

public class MainKontak {
    public static void main(String[] args) {
        // Mengubah nama berkas menjadi kontak_email.txt untuk format baru
        BukuKontak buku = new BukuKontak("kontak_email.txt");
        
        // 1. Mengisi data kontak baru dengan menyertakan EMAIL (Soal 2)
        buku.tambahKontak(new Kontak("Andi", "0811111", "andi@email.com"));
        buku.tambahKontak(new Kontak("Budi", "0822222", "budi@email.com"));
        buku.tambahKontak(new Kontak("Citra", "0833333", "citra@email.com"));
        
        System.out.println("=== DATA AWAL TERSIMPAN ===");
        buku.tampilkanSemua();
        buku.simpanKeBerkas();
        System.out.println();
        
        // 2. UJI COBA: Mencari kontak berdasarkan nama (Soal 1)
        System.out.println("=== PENGUJIAN CARI KONTAK ===");
        buku.cariKontak("Budi"); // Skenario kontak ditemukan
        buku.cariKontak("Zaki"); // Skenario kontak tidak ditemukan
        System.out.println();
        
        // 3. UJI COBA: Menghapus kontak berdasarkan nama (Soal 3)
        System.out.println("=== PENGUJIAN HAPUS KONTAK ===");
        buku.hapusKontak("Andi"); // Menghapus Andi (otomatis memperbarui berkas)
        System.out.println();
        
        // 4. MEMBUKTIKAN PERUBAHAN: Memuat kembali dari berkas ke objek baru
        System.out.println("=== MEMUAT ULANG DARI BERKAS ===");
        BukuKontak bukuLain = new BukuKontak("kontak_email.txt");
        bukuLain.muatDariBerkas(); // Memuat data pasca Andi dihapus
        bukuLain.tampilkanSemua(); // Andi seharusnya sudah tidak muncul lagi
        System.out.println("Jumlah kontak saat ini: " + bukuLain.jumlahKontak());
    }
}