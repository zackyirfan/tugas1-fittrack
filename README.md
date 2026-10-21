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
