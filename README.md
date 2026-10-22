# FitTrack - Sistem Keanggotaan Gym

![Java CI](https://github.com/zackyirfan/tugas1-fittrack/actions/workflows/ci.yml/badge.svg)
![Java Version](https://img.shields.io/badge/Java-21%20LTS-orange)

## Judul & Identitas
* **Nama Tugas**: Remedial UTS / Tugas 1 - Sistem Keanggotaan Gym
* **Nama**: Arienal Zacky Irfan
* **NPM**: 250810701100071
* **Kelas**: Praktikum PBO A

---

## Deskripsi Singkat
Sistem pendataan member berbasis Java console untuk gym FitTrack. Aplikasi ini menggantikan pencatatan manual di buku tulis guna meminimalisir kesalahan input data (seperti nomor telepon salah format) dan memastikan seluruh data member yang masuk selalu valid sebelum disimpan.

## Fitur Utama
* **Pendaftaran Member Fleksibel**: Mendukung pendaftaran member dengan paket khusus maupun otomatis mendapatkan paket default ('Basic')
* **Validasi Otomatis Data Member**: Menolak input nama kosong, nomor telepon tidak standar, dan tanggal daftar yang tidak valid.
* **Pencegahan Data Rusak**: Jika terjadi kesalahan input pada *setter*, sistem menolak nilai baru dan tetap mempertahankan data lama yang valid.
* **Auto-Formatting Teks**: Nama member otomatis dikapitalisasi setiap awal kata, dan paket 'VIP' selalu tersimpan dalam format huruf kapital penuh.

---

## Konsep OOP yang Diterapkan
| Konsep OOP | Lokasi Penerapan | Alasan Penerapan |
|---|---|---|
| **Encapsulation** | Class `Member` (`private` attributes, `getter`, `setter`) | Menyembunyikan akses atribut secara langsung dari luar class serta memusatkan kontrol logika validasi di dalam *setter*. |
| **Constructor Overloading** | Class `Member` (`Member(...)` 4 param & 3 param) | Menyediakan opsi pendaftaran member dengan paket khusus atau tanpa paket (otomatis `Basic`). |
| **Method Overriding** | Method `toString()` di Class `Member` | Mengubah perilaku bawaan `Object.toString()` agar menghasilkan format cetak data member yang rapi dan berlabel. |
| **DRY (Don't Repeat Yourself)** | Constructor memanggil *setter* (`setNama()`, dll.) | Memusatkan seluruh pemeriksaan validasi hanya pada satu tempat (*setter*) tanpa mengulang kodenya di constructor. |

---

## Struktur Projek
```text
tugas1-fittrack/
├── .github/
│   └── workflows/
│       └── ci.yml          # Konfigurasi GitHub Actions untuk kompilasi otomatis
├── src/
│   ├── Member.java         # Class entitas, validasi atribut, dan Javadoc
│   └── TesFitTrack.java    # Class main untuk eksekusi skenario uji
├── .gitignore              # Pengecualian file kompilasi .class dan folder IDE
└── README.md               # Dokumentasi utama proyek
```

---

## Prasyarat
* **Java Development Kit (JDK)**: JDK 21 LTS.
* **IDE / Editor**: Visual Studio Code / Intellij IDEA / Terminal.

---

## Cara Menjalankan Program

### Melalui Command Line (Terminal)
1. Clone Repository ini:
    ```bash
    git clone [https://github.com/zackyirfan/tugas1-fittrack.git](https://github.com/zackyirfan/tugas1-fittrack.git)
    cd tugas1-fittrack/src```