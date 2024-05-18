# Langue Legend Oyunu

Bu projede, İngilizce kelime bilgisi üzerine bir mini quiz oyunu geliştirdim. Oyunda kullanıcılara bir İngilizce kelime soruluyor ve üç seçenek sunuluyor. Kullanıcının doğru cevabı seçmesi gerekiyor.

![Quiz Game Screenshot 1](https://github.com/sevdindagdelen/langue-legend/blob/master/Ekran%20g%C3%B6r%C3%BCnt%C3%BCs%C3%BC%202024-05-17%20205851.png)
![Quiz Game Screenshot 2](https://github.com/sevdindagdelen/langue-legend/blob/master/Ekran%20g%C3%B6r%C3%BCnt%C3%BCs%C3%BC%202024-05-17%20205923.png))
![Quiz Game Screenshot 3](https://github.com/sevdindagdelen/langue-legend/blob/master/Ekran%20g%C3%B6r%C3%BCnt%C3%BCs%C3%BC%202024-05-17%20210114.png)
![Quiz Game Screenshot 4](https://github.com/sevdindagdelen/langue-legend/blob/master/Ekran%20g%C3%B6r%C3%BCnt%C3%BCs%C3%BC%202024-05-17%20210425.png)
![Quiz Game Screenshot 5](https://github.com/sevdindagdelen/langue-legend/blob/master/Ekran%20g%C3%B6r%C3%BCnt%C3%BCs%C3%BC%202024-05-17%20210815.png)
![Quiz Game Screenshot 6](https://github.com/sevdindagdelen/langue-legend/blob/master/Ekran%20g%C3%B6r%C3%BCnt%C3%BCs%C3%BC%202024-05-17%20211014.png)
![Quiz Game Screenshot 7](https://github.com/sevdindagdelen/langue-legend/blob/master/Ekran%20g%C3%B6r%C3%BCnt%C3%BCs%C3%BC%202024-05-17%20211032.png)

## Özellikler

- **İngilizce Kelime Soruları**: Oxford 3000 listesinden alınan kelimelerle oluşturulan sorular.
- **Üç Seçenekli Cevaplar**: Her soru için bir doğru, iki yanlış seçenek.
- **Veritabanı Entegrasyonu**: Kelime verileri bir veritabanında saklanıyor.
- **Recycler adapter** ve **Recycler tasarım**
- **Fragmentler**

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
