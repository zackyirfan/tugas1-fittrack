import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

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

    // Formatter tanggal dengan pola ketat "dd-MM-yyyy"
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            .withResolverStyle(ResolverStyle.STRICT);


    // Constructor 1
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
        setNama(nama);
        setNoTelepon(noTelepon);
        setTanggalDaftar(tanggal);
        setJenisPaket(jenisPaket);
    }


    // Constructor 2 (Default paket "Basic")
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


    //      --- GETTER ---
    
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


    //      --- SETTER DENGAN VALIDASI --

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
            throw new IllegalArgumentException("Nama tidak boleh kosong atau hanya berisi spasi!");
        }
        this.nama = nama;
    }

    /**
     * Mengatur nomor telepon member dengan validasi,
     * agar diawali angka 0 dan minimal 10 digit
     * 
     * @param noTelepon nomor telepon member
     * @throws IllegalArgumentException jika nama bernilai null, kurang dari 10 digit,
     * atau tidak diawali angka nol
     */
    public void setNoTelepon(String noTelepon) {
        // Aturan: nomor telepon tidak boleh lebih dari sepuluh digit
        // dan diawali angka nol
        if (noTelepon == null || !noTelepon.matches("^0\\d{9,}$")) { //menggunakan Regular Expression untuk constraint
            throw new IllegalArgumentException("Nomor telepon harus diawali angka 0 dan minimal 10 digit");
        }
        this.noTelepon = noTelepon;
    }

    /**
     * Mengatur tanggal daftar member dengan memanggil fungsi validasi dan parsing terpisah
     * 
     * @param tanggalDaftar tanggal saat member mendaftar
     */
    public void setTanggalDaftar(String tanggalDaftar) {
        validateTanggal(tanggalDaftar);
        this.tanggalDaftar = parseDanFormatTanggal(tanggalDaftar);
    }

    /**
     * Method helper untuk memeriksa apakah input tanggal kosong atau null.
     * 
     * @param tanggal tanggal daftar yang di-input
     * @throws IllegalArgumentException jika tanggal kosong
     */
    private void validateTanggal(String tanggal) {
        if (tanggal == null || tanggal.trim().isEmpty()) {
            throw new IllegalArgumentException("Tanggal daftar tidak boleh kosong!");
        }
    }

    /**
     * Method Helper khusus untuk melakukan parsing string ke format
     * tanggal yang valid.
     * 
     * @param tanggal tanggal daftar yang di-input
     * @return representasi string dari tanggal yang sudah diparse dan diformat
     * @throws IllegalArgumentException jika format tanggal salah
     */
    private String parseDanFormatTanggal(String tanggal) {
            try {
            // Validasi dan melakukan parsing string ke LocalDate menggunakan
            // formatter ketat
            LocalDate parseDate = LocalDate.parse(tanggal.trim(), FORMATTER);
            return parseDate.toString(); // disimpan kembali ke bentuk string standar
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Format tanggal harus persis: dd-MM-yyyy");
        }
    }

    public void setJenisPaket(String jenisPaket) {
        if (jenisPaket == null || jenisPaket.trim().isEmpty()) {
            throw new IllegalArgumentException("Jenis paket tidak boleh kosong!");
        }
        this.jenisPaket = jenisPaket.trim();
    }
}