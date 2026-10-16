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

}