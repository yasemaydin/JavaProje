# Ders ve Öğrenci Kayıt Uygulaması

* Bu proje, ders ve öğrenci kayıt projesidir.
* Projede 3 tane form (mainForm -> Anasayfa, dersForm -> Ders Kayıt Sayfası, ogrenciForm -> Öğrenci Kayıt Sayfası) vardır.
* Projede 2 tane sınıf (dersler ve ogrenciler) vardır.
* Kayıtlar kök klasörünün içerisindeki dersler ve ogrenciler csv dosyalarına kayıt edilmektedir.

## Nasıl Çalışır

1. Anasayfa formu çalıştırılır.
2. Ders eklemek için açılan pencerede Ders Form buttonuna tıklanır.
3. Öğrenci eklemek için açılan pencerede Öğrenci Form butonuna tıklanır.
4. Ders eklemek için tüm alanlar doldurulur. Tüm alanlar doldurulmaz ise hata mesajı verir.

* Ders Kod: JTextField
* Ders Ad: JTextField
* Ders Dönem: JSpinner
* Ders Kredi: JSpinner
* Ders Kota: JSpinner

5. Öğrenci eklemek için tüm alanlar doldurulur. Tüm alanlar doldurulmaz ise işlem gerçekleştirilmez.

* Öğrenci Kod: JTextField
* Öğrenci Ad: JTextField
* Öğrenci Soyad: JTextField
* Öğrenci Bölüm: JTextField
* Öğrenci Dönem: JSpinner
* Ders: JComboBox<String>

## Dosyalar

- dersler.csv -> Ders bilgilerini tutan dosyadır.
- ogrenciler.csv -> Öğrenci bilgilerini tutan dosyadır.

## Sınıflar

- dersler -> Ders bilgi alanlarını tutan, dersin daha önce eklenip eklenmediğini kontrol eden ve ders bilgilerini kayıt eden sınıftır.
- ogrenciler -> Öğrenci bilgi alanlarını tutan, dersleri combobox nesnesine ekleyen ve öğrenci bilgilerini kayıt eden sınıftır.

- mainForm, dersForm ve ogrenciForm sınıfları form sınıflarıdır.

## Alanlar

- dersler -> dersKod: Ders kod bilgisini tutan alandır.
- dersler -> dersAd: Ders ad bilgisini tutan alandır.
- dersler -> dersDonem: Ders dönem bilgisini tutan alandır.
- dersler -> dersKredi: Ders kredi bilgisini tutan alandır.
- dersler -> dersKota: Ders kota bilgisini tutan alandır.

- ogrenciler -> ogrenciKod: Öğrenci kod bilgisini tutan alandır.
- ogrenciler -> ogrenciAd: Öğrenci ad bilgisini tutan alandır.
- ogrenciler -> ogrenciSoyad: Öğrenci soyad bilgisini tutan alandır.
- ogrenciler -> ogrenciBolum: Öğrenci bölüm bilgisini tutan alandır.
- ogrenciler -> ogrenciDonem: Öğrenci dönem bilgisini tutan alandır.
- ogrenciler -> ders: Öğrenci ders bilgisini tutan alandır.

## Metodlar

- dersler -> dersVarMi: String türünden bir değişken ile çalışır. Dersin daha önce eklenip eklenmediğini kontrol eder. Kayıt var ise false, yok ise true döndürür.
- dersler -> kaydet: dersler türünden bir nesne ile çalışır. Nesne verilerini belirtilen CSV belgesine kayıt eder. Kayıt başarılı ise true, değil ise false döndürür.

- ogrenciler -> ogrenciVarMi: String türünden iki değişken ile çalışır. Öğrenci kodunun ve ders kodunun daha önce eklenip eklenmediğini kontrol eder. Kayıt var ise false, yok ise true döndürür.
- ogrenciler -> kaydet: ogrenciler türünden bir nesne ile çalışır. Nesne verilerini belirtilen CSV belgesine kayıt eder. Kayıt başarılı ise true, değil ise false döndürür.
- ogrenciler -> doldur: JComboBox<String> türünden bir nesne ile çalışır. Belirtilen CSV belgesinden ders adlarını combobox nesnesine ekler.