# Langue Legend Oyunu

Bu projede, İngilizce kelime bilgisi üzerine bir mini quiz oyunu geliştirdim. Oyunda kullanıcılara bir İngilizce kelime soruluyor ve üç seçenek sunuluyor. Kullanıcının doğru cevabı seçmesi gerekiyor.

![Quiz Game Screenshot 1](path/to/image1.png)
![Quiz Game Screenshot 2](path/to/image2.png)
![Quiz Game Screenshot 3](path/to/image3.png)
![Quiz Game Screenshot 4](path/to/image4.png)
![Quiz Game Screenshot 5](path/to/image5.png)
![Quiz Game Screenshot 6](path/to/image6.png)
![Quiz Game Screenshot 7](path/to/image7.png)

## Özellikler

- **İngilizce Kelime Soruları**: Oxford 3000 listesinden alınan kelimelerle oluşturulan sorular.
- **Üç Seçenekli Cevaplar**: Her soru için bir doğru, iki yanlış seçenek.
- **Veritabanı Entegrasyonu**: Kelime verileri bir veritabanında saklanıyor.

## Veri Kaynağı

Kelimeler, [Oxford 3000](https://www.oxfordlearnersdictionaries.com/wordlist/english/oxford3000/) sitesinden alınmıştır. Bu verileri, Python'ın Selenium kütüphanesini kullanarak çekip ve Pandas kütüphanesiyle düzenledim bu söz konusu işlemleri farkl bir repoya ekledim.

## Veri Çekme ve Düzenleme

Bu işlemlere ait kodlar başka bir repoda bulunmaktadır. Verilerin çekilmesi ve düzenlenmesi ile ilgili detaylı bilgilere [bu repodan](URL) ulaşabilirsiniz.

## Kullanılan Teknolojiler

- **Kotlin**: Oyun mantığı ve kullanıcı arayüzü için.
- **Python**: Veri çekme ve işleme.
- **Selenium**: Web scraping işlemleri için.
- **Pandas**: Veri düzenleme ve işleme.
- **SQLite**: Oyun verilerinin saklanması için.
