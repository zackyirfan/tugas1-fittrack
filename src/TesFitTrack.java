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
        Member[] listMember = {
            new Member("Alex", "081234567890", "12-01-2026", "vip")
        };

        String border = "+----+----------------------+---------------+----------------+-------------+";
        System.out.println(border);
        System.out.printf("| %-2s | %-20s | %-13s | %-14s | %-11s |\n",
                          "No", "Nama Member", "No Telepon", "Tanggal Daftar", "Jenis Paket");
        System.out.println(border);

        for (int i = 0; i < listMember.length; i++) {
            System.out.printf("| %-2d | %-20s | %-13s | %-14s | %-11s |\n",
                              (i + 1),
                              listMember[i].getNama(),
                              listMember[i].getNoTelepon(),
                              listMember[i].getTanggalDaftar(),
                              listMember[i].getJenisPaket());
        }

        System.out.println(border);
    }
}