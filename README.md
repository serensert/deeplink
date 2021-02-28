# DEEPLINK - TRENDYOL

Deeplink ne ise yarar?

Verilen URL'i mobile uygulamada kullanılan linke dönüştürür veya linki URL'e dönüştürür.

## Kurulum

Uygulama Docker containerlar uzerinde calisir,
bu nedenle bilgisayarinizda docker kurulu olmasi gerekmektedir.

Uygulama database olarak Couchbase kullanmaktadir.
Couchbase ayaga kaldirmak icin,


```bash
docker network create --driver bridge deeplink-network 
docker run -d --name couchbase -p 8091-8094:8091-8094 -p 11210:11210 --network deeplink-network couchbase:6.6.1
```

http://localhost:8091 açılır.
setup new cluster menüsünden ilerlenir ve admin password trendyol2021 olarak belirlenir.

1 bucket yeterlidir. İsim olarak aşağıdaki isim kullanılmalıdır:
	ReqsAndResps 1024MB

## Calistirma

Couchbase ayaga kalkmasindan sonra,
uygulamayi asagidaki komutlarla ayaga kaldirabilrisiniz


```bash
docker build -t deeplink:0.0.1 .
docker run -d --name deeplink -p 8080:8080 --network deeplink-network deeplink:0.0.1
```

http://localhost:8080 den kullanabilirsiniz.

swagger için http://localhost:8080/swagger-ui/index.html adresine girebilirsiniz.

## Kapatma

Ayakta olan uygulama ve couchbase container larini asagidaki komutla kapatabilirsiniz


```bash
docker rm -f deeplink couchbase
```