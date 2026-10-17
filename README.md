# TP5DPBO2526C1
Janji : Saya Aracelli Jasmine Malaika dengan NIM 2501804 mengerjakan Tugas Praktikum 5 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahan-Nya, maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

## Deskripsi Program
Program **PeopleData** merupakan aplikasi berbasis Java Swing yang digunakan untuk mengelola data personal dengan menerapkan konsep pemrograman berorientasi objek dan koneksi database MySQL.

Aplikasi ini terhubung dengan database `db_people` yang memiliki tabel `person`. Data yang dikelola meliputi ID, nama, tahun lahir, kategori, dan email.

## Fitur Program
1. **Read** — Menampilkan data personal dari database MySQL ke dalam tabel aplikasi.
2. **Create** — Menambahkan data personal baru ke database.
3. **Update** — Mengubah data personal yang sudah tersimpan.
4. **Delete** — Menghapus data personal berdasarkan ID.
5. **Clear** — Mengosongkan kolom input pada aplikasi.

## Teknologi yang Digunakan
- Java
- Java Swing
- MySQL
- phpMyAdmin
- MySQL Connector/J
- IntelliJ IDEA

## Struktur Folder
```text
TP5DPBO2526C1/
├── PersonData/
│   └── src/
│       ├── PeopleMenu.java
│       ├── PeopleMenu.form
│       ├── Person.java
│       └── Database.java
├── Dokumentasi/
│   ├── 1-tampilanawal.png
│   ├── 2-sebelumtambah.png
│   ├── 3-sesudahtambah.png
│   ├── 4-tampilansesudahtambah.png
│   ├── 5-sebelumupdate.png
│   ├── 6-sesudahupdate.png
│   ├── 7-tampilansesudahupdate.png
│   ├── 8-sebelumhapus.png
│   ├── 9-sesudahhapus.png
│   ├── 10-tampilansesudahhapus.png
│   ├── 11-tampilansesudahtambah.png
│   ├── 12-tampilansesudahupdate.png
│   └── 13-tampilansesudahhapus.png
├── db_people.sql
└── README.md
```

## Dokumentasi Program
### 1. Tampilan Awal
Tampilan awal aplikasi PeopleData yang menampilkan data personal dari database MySQL.
<img width="1365" height="719" alt="1-tampilanawal" src="https://github.com/user-attachments/assets/69ed8522-f84b-4487-aef6-e8834d6af304" />

### 2. Pengujian Create (Tambah Data)
**Sebelum menambahkan data**
<img width="1365" height="717" alt="2-sebelumtambah" src="https://github.com/user-attachments/assets/558c4308-fcbf-444d-8abc-3b437a67e6b5" />

**Sesudah menambahkan data**
<img width="1365" height="717" alt="3-sesudahtambah" src="https://github.com/user-attachments/assets/bb2e1ee7-77dc-4b21-ab47-cad858165038" />
<img width="1365" height="714" alt="4-tampilansesudahtambah" src="https://github.com/user-attachments/assets/230a4874-b419-4e81-b5ca-d4cea975eb36" />

Pada pengujian ini, data personal baru ditambahkan melalui aplikasi. Data yang berhasil ditambahkan akan muncul pada tabel aplikasi dan tersimpan di database MySQL.

### 3. Pengujian Update (Ubah Data)
**Sebelum mengubah data**
<img width="1365" height="718" alt="5-sebelumupdate" src="https://github.com/user-attachments/assets/337c51b3-0c1f-4a99-85fa-74684ae6b14c" />

**Sesudah mengubah data**
<img width="1365" height="713" alt="6-sesudahupdate" src="https://github.com/user-attachments/assets/a7b29f3a-c9cc-4a91-8d7b-24abe9e2d814" />
<img width="1365" height="715" alt="7-tampilansesudahupdate" src="https://github.com/user-attachments/assets/5ef60af1-decd-407f-9867-2795b3662078" />

Pada pengujian ini, data personal yang sudah tersimpan diubah melalui aplikasi. Perubahan data ditampilkan pada tabel aplikasi dan diperbarui pada database MySQL.

### 4. Pengujian Delete (Hapus Data)
**Sebelum menghapus data**
<img width="1365" height="715" alt="8-sebelumhapus" src="https://github.com/user-attachments/assets/999e4d84-8b31-4f35-8f08-3286117bebd8" />

**Sesudah menghapus data**
<img width="1365" height="714" alt="9-sesudahhapus" src="https://github.com/user-attachments/assets/038f712c-460d-4020-9d36-34a2270343e7" />
<img width="1365" height="718" alt="10-tampilansesudahhapus" src="https://github.com/user-attachments/assets/acd43529-d660-49a4-abfa-0cea991c0411" />

Pada pengujian ini, data personal yang dipilih dihapus melalui aplikasi. Setelah proses berhasil, data tersebut tidak lagi ditampilkan pada tabel aplikasi dan dihapus dari database MySQL.

### 5. Tampilan Tabel MySQL
**tampilan sesudah menambahkan data**
<img width="1111" height="597" alt="11-tampilansesudahtambah" src="https://github.com/user-attachments/assets/5d04e020-f83d-45fd-85a4-1a3a90bad8ae" />

**tampilan sesudah update data**
<img width="1111" height="593" alt="12-tampilansesudahupdate" src="https://github.com/user-attachments/assets/7d5929a2-9fe0-44ac-9375-3ccee9080984" />

**tampilan sesudah menghapus data**
<img width="1108" height="595" alt="13-tampilansesudahhapus" src="https://github.com/user-attachments/assets/db6607ff-e2c3-4cf3-8c66-f9cfaa73488f" />

Gambar di atas menunjukkan tabel `person` pada database `db_people` melalui phpMyAdmin. Pengujian ini dilakukan untuk memastikan bahwa data yang ditambahkan, diubah, dan dihapus melalui aplikasi juga diterapkan pada database.

## Database
Database yang digunakan dalam program ini adalah `db_people` dengan tabel `person`.

Struktur kolom tabel:
| Kolom | Tipe Data | Keterangan |
|---|---|---|
| `id` | VARCHAR(255) | Primary key |
| `nama` | VARCHAR(255) | Nama personal |
| `thn_lahir` | INT | Tahun lahir |
| `kategori` | VARCHAR(255) | Kategori personal |
| `email` | VARCHAR(255) | Email personal |

File database yang digunakan untuk mengimpor struktur tabel dan data awal disertakan dalam file `db_people.sql`.

## Alur Kerja Program
1. **Koneksi Database**  
   Program menggunakan class `Database.java` untuk menghubungkan aplikasi Java dengan database MySQL `db_people`.

2. **Menampilkan Data**  
   Setelah aplikasi dijalankan, program mengambil data dari tabel `person` menggunakan perintah SQL `SELECT`. Data tersebut kemudian ditampilkan pada tabel di aplikasi.

3. **Menambahkan Data (Create)**  
   Pengguna mengisi ID, nama, tahun lahir, kategori, dan email, kemudian menekan tombol tambah. Program menyimpan data ke database menggunakan perintah SQL `INSERT`, lalu memperbarui tampilan tabel.

4. **Mengubah Data (Update)**  
   Pengguna memilih data pada tabel sehingga informasi yang dipilih muncul pada kolom input. Setelah data diubah dan tombol update ditekan, program memperbarui data pada database menggunakan perintah SQL `UPDATE`.

5. **Menghapus Data (Delete)**  
   Pengguna memilih data yang ingin dihapus, kemudian menekan tombol hapus. Program menghapus data dari database menggunakan perintah SQL `DELETE` berdasarkan ID.

6. **Mengosongkan Input (Clear)**  
   Tombol clear digunakan untuk mengosongkan kolom input agar pengguna dapat memasukkan data baru atau membatalkan pengisian data.

7. **Memperbarui Tampilan**  
   Setelah proses tambah, ubah, atau hapus berhasil, program mengambil kembali data dari database agar tabel aplikasi menampilkan data terbaru.

## Penerapan OOP
Program ini menerapkan konsep Object-Oriented Programming (OOP) melalui beberapa class berikut:
- **`Person.java`**: Merepresentasikan objek personal yang memiliki atribut ID, nama, tahun lahir, kategori, dan email.
- **`Database.java`**: Mengatur koneksi antara aplikasi Java dan database MySQL.
- **`PeopleMenu.java`**: Mengatur tampilan antarmuka, menerima input pengguna, serta menjalankan proses CRUD terhadap database.

Ketiga class tersebut memiliki tanggung jawab masing-masing sehingga pengelolaan data, koneksi database, dan antarmuka program tersusun lebih terstruktur.

## Cara Menjalankan Program
1. Pastikan Java, IntelliJ IDEA, dan MySQL sudah tersedia.
2. Jalankan MySQL melalui XAMPP.
3. Impor file `db_people.sql` melalui phpMyAdmin.
4. Pastikan nama database adalah `db_people`.
5. Buka project `PersonData` melalui IntelliJ IDEA.
6. Pastikan MySQL Connector/J sudah ditambahkan ke project.
7. Sesuaikan konfigurasi koneksi database pada `Database.java` jika diperlukan.
8. Jalankan file `PeopleMenu.java`.
9. Aplikasi siap digunakan untuk mengelola data personal.

## Kesimpulan
Berdasarkan pengujian yang dilakukan, aplikasi PeopleData dapat menampilkan, menambahkan, mengubah, dan menghapus data personal melalui Java Swing. Koneksi dengan MySQL juga memungkinkan perubahan data pada aplikasi tersimpan pada database, sehingga fitur CRUD dapat berjalan sesuai dengan fungsinya.
