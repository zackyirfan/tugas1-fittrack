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

public class Member {
    // Atribut Privatecd
    private String nama;
    private String noTelepon;
    private String tanggalDaftar;
    private String jenisPaket;

    // Konstanta (Magic String & Regex ditaruh di sini)
    public static final String DEFAULT_NAMA = "Unknown Member";
    public static final String DEFAULT_NO_TELEPON = "000000000000";
    public static final String DEFAULT_TANGGAL_DAFTAR = "01-01-2026";
    public static final String DEFAULT_JENIS_PAKET = "Basic";

    // Formatter tanggal dengan pola ketat "dd-MM-yyyy"
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-uuuu")
            .withResolverStyle(ResolverStyle.STRICT);


    // Constructor 1

    /**
     * Method constructor untuk membuat objek
     * dari kelas member
     *
     * @param nama          nama lengkap member
     * @param noTelepon     nomor telepon member
     * @param tanggalDaftar tanggal saat member mendaftar
     * @param jenisPaket    jenis paket langganan member
     */
    public Member(String nama, String noTelepon, String tanggalDaftar, String jenisPaket) {
        setNama(nama);
        setNoTelepon(noTelepon);
        setTanggalDaftar(tanggalDaftar);
        setJenisPaket(jenisPaket);
    }


    // Constructor 2 (Default paket "Basic")

    /**
     * Method constructor untuk membuat objek dari kelas member
     * dengan jenis paket default "Basic"
     *
     * @param nama          nama lengkap member
     * @param noTelepon     nomor telepon member
     * @param tanggalDaftar tanggal saat member mendaftar
     */
    public Member(String nama, String noTelepon, String tanggalDaftar) {
        this(nama, noTelepon, tanggalDaftar, "Basic");
    }

    /**
     * Method Constructor tanpa parameter
     * untuk assign nilai default
     */
    public Member() {
        this("Unknown Member", "000000000000", "01-01-2026", "Basic");
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
     *                                  atau hanya berisi spasi
     */
    public void setNama(String nama) {
        // Aturan: Nama tidak boleh kosong atau hanya berisi spasi
        try {
            if (nama == null || nama.trim().isEmpty()) {
                throw new IllegalArgumentException("Nama tidak boleh kosong atau hanya berisi spasi!");
            }
            this.nama = capitalizeWords(nama);
        } catch (IllegalArgumentException e) {
            System.out.println("Penolakan Validasi: " + e.getMessage());

            if (this.nama == null) {
                this.nama = "Unknown Member";
            }
        }
    }

    /**
     * Mengatur nomor telepon member dengan validasi,
     * agar diawali angka 0 dan minimal 10 digit
     *
     * @param noTelepon nomor telepon member
     * @throws IllegalArgumentException jika nama bernilai null, kurang dari 10 digit,
     *                                  atau tidak diawali angka nol
     */
    public void setNoTelepon(String noTelepon) {
        // Aturan: nomor telepon tidak boleh lebih dari sepuluh digit
        // dan diawali angka nol
        try {
            if (noTelepon == null || !noTelepon.matches("^0\\d{9,}$")) {
                throw new IllegalArgumentException("Nomor telepon harus diawali angka 0 dan minimal 10 digit");
            }
            this.noTelepon = noTelepon;
        } catch (IllegalArgumentException e) {
            System.out.println("Penolakan Validasi: " + e.getMessage());

            if (this.noTelepon == null) {
                this.noTelepon = "000000000000";
            }
        }
    }

    /**
     * Mengatur tanggal daftar member dengan memanggil fungsi validasi dan parsing terpisah
     *
     * @param tanggalDaftar tanggal saat member mendaftar
     */
    public void setTanggalDaftar(String tanggalDaftar) {
        try {
            validateTanggal(tanggalDaftar);
            this.tanggalDaftar = parseDanFormatTanggal(tanggalDaftar);
        } catch (IllegalArgumentException e) {
            System.out.println("Penolakan Validasi: " + e.getMessage());

            if (this.tanggalDaftar == null) {
                this.tanggalDaftar = "01-01-2006";
            }
        }
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
            return parseDate.format(FORMATTER); // disimpan kembali ke bentuk string standar
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Format tanggal harus persis: dd-MM-yyyy");
        }
    }

    /**
     * Mengatur jenis paket yang dipilih member
     * agar tidak null dan kosong
     *
     * @param jenisPaket jenis paket yang dipilih member
     * @throws IllegalArgumentException jika jenis paket kosong atau null
     */
    public void setJenisPaket(String jenisPaket) {
        try {
            if (jenisPaket == null || jenisPaket.trim().isEmpty()) {
                throw new IllegalArgumentException("Jenis paket tidak boleh kosong!");
            }

            String input = jenisPaket.trim();

            // Validasi apakah input sesuai dengan pilihan yang diizinkan
            if (!input.equalsIgnoreCase("Basic") &&
                    !input.equalsIgnoreCase("Premium") &&
                    !input.equalsIgnoreCase("VIP")) {
                throw new IllegalArgumentException("Jenis paket harus berupa: Basic, Premium, atau VIP");
            }

            if (input.equalsIgnoreCase("VIP")) {
                this.jenisPaket = "VIP";
            } else {
                this.jenisPaket = Character.toUpperCase(input.charAt(0)) + input.substring(1).toLowerCase();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Penolakan Validasi: " + e.getMessage());

            if (this.jenisPaket == null) {
                this.jenisPaket = "Basic";
            }
        }
    }

    /**
     * Mengembalikan representasi string dari objek Member yang berisi informasi lengkap
     * meliputi nama, nomor telepon, tanggal daftar, dan jenis paket.
     *
     * @return string representasi data member dalam format teks yang mudah dibaca
     */
    @Override
    public String toString() {
        return "Member [Nama: " + nama +
                " | No Telepon: " + noTelepon +
                " | Tanggal Daftar: " + tanggalDaftar +
                " | Jenis Paket: " + jenisPaket + "]";
    }

    public static String capitalizeWords(String str) {
        if (str == null || str.trim().isEmpty()) {
            return str;
        }

        // Memecah kalimaat berdasarkan spasi
        String[] words = str.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                // Mengubah huruf pertama jadi kapital, sisanya jadi huruf kecil
                String capitalizeWords = Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
                result.append(capitalizeWords).append(" ");
            }
        }

        return result.toString().trim();
    }
}