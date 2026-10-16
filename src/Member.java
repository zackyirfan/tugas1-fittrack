public class Member{
    String nama;
    tring noTelepon;
    String tanggalDaftar;
    String jenisPaket;

    public Member(String nama, String noTelepon, String tanggalDaftar, String jenisPaket) {
        this.nama = nama;
        this.noTelepon = noTelepon;
        this.tanggalDaftar = tanggalDaftar;
        this.jenisPaket = jenisPaket;
    }

    public Member(String nama, String noTelepon, String tanggalDaftar) {
        this(nama, noTelepon, tanggalDaftar, "Basic");
    }
}