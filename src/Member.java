/**
 * Kelas ini merepresentasikan data seorang member dalam sistem.
 * 
 * @author Arienal Zacky Irfan
 * @version 1.0
 * @since 2026
 */

public class Member{
    private String nama;
    private String noTelepon;
    private String tanggalDaftar;
    private String jenisPaket;


    /**
     * Method constructor untuk membuat objek
     * dari kelas member
     * 
     * @param nama nama lengkap member
     * @param noTelepon nomor telepon member
     * @param tanggalDaftar tanggal saat member mendaftar 
     * @param jenisPaket jenis paket langganan member
     */
    public Member(String nama, String noTelepon, String tanggalDaftar, String jenisPaket) {
        this.nama = nama;
        this.noTelepon = noTelepon;
        this.tanggalDaftar = tanggalDaftar;
        this.jenisPaket = jenisPaket;
    }

    public Member(String nama, String noTelepon, String tanggalDaftar) {
        this(nama, noTelepon, tanggalDaftar, "Basic");
    }
 
    public String getNama() {
        return this.nama;
    }

    public String getNoTelepon() {
        return this.noTelepon;
    }

    public String getTanggalDaftar() {
        return this.tanggalDaftar;
    }

    public String getJenisPaket() {
        return this.jenisPaket;
    }

    public void setNama(String nama) {
        // Aturan: Nama tidak boleh kosong atau hanya berisi spasi
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong atau hanya berisi spasi!")
        }
        this.nama = nama;
    }

}