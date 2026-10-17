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

    /**
     * Method constructor untuk membuat objek dari kelas member
     * dengan jenis paket default "Basic"
     * 
     * @param nama nama lengkap member
     * @param noTelepon nomor telepon member
     * @param tanggalDaftar tanggal saat member mendaftar
     */
    public Member(String nama, String noTelepon, String tanggalDaftar) {
        this(nama, noTelepon, tanggalDaftar, "Basic");
    }
    
    /**
     * Mengembalikan nilai nama member
     * 
     * @return nilai dari aribut nama 
     */
    public String getNama() {
        return this.nama;
    }

    /**
     * Mengembalikan nilai no Telepon member
     * 
     * @return nilai dari atribut noTelepon;
     */
    public String getNoTelepon() {
        return this.noTelepon;
    }

    /**
     * Mengembalikan nilai Tanggal daftar member
     * 
     * @return nilai dari atribut tanggalDaftar
     */
    public String getTanggalDaftar() {
        return this.tanggalDaftar;
    }

    /**
     * Mengembalikan nilai jenis paket member
     * 
     * @return nilai dari atribut jenisPaket
     */
    public String getJenisPaket() {
        return this.jenisPaket;
    }

    /**
     * Mengatur nama lengkap member dengan melakukan validasi 
     * agar tidak boleh kosong atau hanya berisi spasi
     * 
     * @param nama nama lengkap member yang akan di-set
     * @throws IllegalArgumentException jika nama bernilai null, kosong,
     * atau hanya berisi spasi  
     */
    public void setNama(String nama) {
        // Aturan: Nama tidak boleh kosong atau hanya berisi spasi
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong atau hanya berisi spasi!")
        }
        this.nama = nama;
    }

}