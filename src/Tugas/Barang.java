package tugas;

public class Barang {
    // Atribut model barang (Studi Kasus)
    private String nama;
    private double harga;
    private int stok;

    // Constructor lengkap dengan 3 parameter
    public Barang(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter untuk masing-masing atribut
    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    // Mengubah objek barang menjadi satu baris teks dipisahkan titik koma (untuk berkas)
    public String keBaris() {
        return nama + ";" + harga + ";" + stok;
    }

    // Mengembalikan keterangan barang dalam bentuk format tampilan layar
    public String info() {
        return nama + " (Harga: Rp" + harga + ", Stok: " + stok + ")";
    }
}