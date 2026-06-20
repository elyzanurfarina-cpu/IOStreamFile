package bagian3.kontak;

public class Kontak {
    // Atribut: data yang dimiliki setiap kontak (Ditambahkan email sesuai Soal 2)
    private String nama;
    private String nomor;
    private String email; 
    
    // Constructor: diperbarui agar menerima 3 parameter (Soal 2)
    public Kontak(String nama, String nomor, String email) {
        this.nama = nama;
        this.nomor = nomor;
        this.email = email;
    }
    
    // Getter: cara membaca atribut dari luar class
    public String getNama() {
        return nama;
    }
    
    public String getNomor() {
        return nomor;
    }

    // Getter tambahan untuk membaca atribut email (Soal 2)
    public String getEmail() {
        return email;
    }
    
    // Mengubah objek menjadi satu baris teks dengan 3 bagian dipisah titik koma (Soal 2)
    public String keBaris() {
        return nama + ";" + nomor + ";" + email;
    }
    
    // Mengembalikan keterangan lengkap kontak termasuk email (Soal 2)
    public String info() {
        return nama + " - " + nomor + " - " + email;
    }
}