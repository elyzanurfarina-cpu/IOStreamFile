package tugas;

/*
 * Nama : [Elyza Nurfarina Rizkia Maulida]
 * NPM  : [2410010431]
 * Tugas Akhir: Pengelolaan Data Barang Toko
 */
public class MainTugas {
    public static void main(String[] args) {
        
        // 1. Menyimpan dan menampilkan minimal 3 nama kategori dalam array String
        System.out.println("=== 1. KATEGORI BARANG TOKO ===");
        String[] kategori = {"Elektronik", "Pakaian", "Makanan", "Alat Tulis"};
        for (String kat : kategori) {
            System.out.println("- Kategori: " + kat);
        }
        System.out.println();

        // 2. Membuat objek gudang pertama dan menambahkan minimal 5 barang berbeda
        System.out.println("=== 2. INPUT DATA BARANG AWAL ===");
        Gudang gudangUtama = new Gudang("barang.txt");
        
        gudangUtama.tambahBarang(new Barang("Laptop Asus", 8500000, 5));
        gudangUtama.tambahBarang(new Barang("Mouse Wireless", 150000, 15));
        gudangUtama.tambahBarang(new Barang("Keyboard Mekanik", 450000, 8));
        gudangUtama.tambahBarang(new Barang("Monitor LED", 1750000, 4));
        gudangUtama.tambahBarang(new Barang("Printer Inkjet", 1200000, 3));
        
        // Menampilkan data dan menyimpannya ke berkas
        gudangUtama.tampilkanSemua();
        gudangUtama.simpanKeBerkas();
        System.out.println();

        // 3. Membuat objek Gudang baru untuk pembuktian integritas data berkas
        System.out.println("=== 3. VERIFIKASI PEMBACAAN BERKAS BARU ===");
        Gudang gudangSatelit = new Gudang("barang.txt");
        
        // Memuat kembali data dari berkas teks
        gudangSatelit.muatDariBerkas();
        gudangSatelit.tampilkanSemua();
        
        // Menampilkan total nilai aset/persediaan barang di toko tersebut
        System.out.println("----------------------------------------");
        System.out.println("Total Nilai Persediaan Toko: Rp" + gudangSatelit.totalNilai());
    }
}