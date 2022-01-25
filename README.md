# Tugas Kecil 1 IF2211 Strategi Algoritma

**Dibuat oleh:** <br>
Flavia Beatrix Leoni A. S. - 13520051

## Deskripsi Singkat
Merupakan program yang dapat digunakan untuk mencari solusi word search puzzle dengan algoritma Brute Force. Word search puzzle merupakan permainan kata dimana pemain harus menemukan beberapa kata tersembunyi dalam kumpulan huruf acak. Program dapat menerima masukan berupa nama file teks berisi matriks huruf di dalam puzzle serta daftar kata yang akan dicari dalam puzzle. Program akan memberikan keluaran berupa tampilan di layar yang menunjukkan letak masing-masing kata, waktu pencarian kata, dan banyak perbandingan huruf yang dilakukan. Program ini dibuat dalam bahasa Java.

## Cara Penggunaan Program
Pastikan bahwa Java telah terinstall dengan baik dan kode program ini telah terdapat di komputer Anda.
1. Buka terminal dan arahkan ke folder bin dengan command `cd <directory>/bin`
2. Jalankan program dengan command `java Main` atau `java -jar WordSearchPuzzle.jar`
3. Kemudian, program akan meminta masukan berupa nama file teks yang berisi puzzle. Format pengisian file teks ini akan dijelaskan kemudian. <br>
Apabila file terdapat pada direktori yang sama, Anda hanya perlu menuliskan nama filenya saja, seperti:
```
small1.txt
```
Akan tetapi, jika file terdapat pada direktori yang berbeda, misalnya pada direktori test, maka Anda perlu menuliskan nama direktori secara lengkap diikuti dengan nama filenya, seperti:
```
../test/small1.txt
```

## Format Pengisian File Teks
File teks diisi dengan matriks huruf di dalam puzzle (antarhuruf dipisahkan oleh spasi), lalu diikuti dengan satu baris kosong dan daftar kata-kata yang akan dicari di dalam puzzle dimana satu baris hanya berisi satu kata saja. <br>
Berikut merupakan contoh isi file teks `small1.txt`
```
E J D N G P E T L I O K D Q L C
K F N B B E X F C U R M H P L C
J L J Q J N I X F O M W Z F P R
D G U C X G R O T A U F K F V O
R G O J M U A S R C R B X U N T
T Y W R G I E I T G E I U S M A
E N V O F N B O B A N L G T E G
V L A J N A R J R O N I L B E I
L T E Z A M A X I A D N A P R L
C J D P A E L L T I G E R U K L
G P B X H V O M O N K E Y B A A
D A O T V A P O D A O E F O T J
Y W N M N U N N L E C Z R J T E
C Z A E W X A T H N A Q J Z S Z

ALLIGATOR
FROG
LION
PANDA
STORK
BEAR
GIRAFFE
MEERKAT
PENGUIN
TIGER
ELEPHANT
GOAT
MONKEY
POLARBEAR
TOAD
```