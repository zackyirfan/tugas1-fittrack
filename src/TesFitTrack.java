/**
 * Kelas ini dibuat untuk menampung method main dan 
 * menguji skenario ujian yang diminta
 * 
 * @author: Arienal Zacky Irfan
 * @version: 1.0
 * @since: 2026
 */
public class TesFitTrack {

    /**
     * Method utama (entry point) untuk menjalankan program pengujian FitTrack.
     * Berisi skenario pembuatan array objek Member, pengujian validasi,
     * penanganan exception pada setter, serta pencetakan data menggunakan perulangan.
     * 
     * @param args argumen baris perintah (command line arguments)
     */
    public static void main(String[] args) {
        // Membuat array bertipe Member(class) dengan kapasitas 4 elemen
        Member[] daftarMember = new Member[4];

        daftarMember[0] = new Member("Fathir", "081234567890", "12-01-2026", "VIP");
        daftarMember[1] = new Member("Rehan", "089876543210", "10-12-2026", "Premium");
        daftarMember[2] = new Member("Teddy", "081122334455", "06-02-2025", "Basic");
        daftarMember[3] = new Member("Joko", "085544332211", "25-04-2026"); // Constructor tanpa paket (default Basic)

        System.out.println("--- Menguji Setter dengan Data yang Salah ---");
        try {
            daftarMember[0].setNoTelepon("12345");
        } catch (IllegalArgumentException e) {
            System.out.println("Penolakan Validasi: " + e.getMessage());
        }

        System.out.println("Nomor telepon setelah di-set salah: " + daftarMember[0].getNoTelepon());

        System.out.println("--- Daftar Seluruh Member FitTrack ---");
        for (int i = 0; i < daftarMember.length; i++) {
            // Memanggil toString() secara otomatis
            System.out.println((i + 1) + ". " + daftarMember[i]);
        }
    }
}