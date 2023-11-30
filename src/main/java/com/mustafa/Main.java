package com.mustafa;

import java.util.*;

/*

1-) 1den 100 e kadar rastgele 10 000 adet sayı ureteceğiz Bu sayıları mesela 20 den 150 tane uretildi 90 dan 500 tane
uretildi 10 dan 20 tane uretildi gibi düşünürsek Soyle bir yaoıda tutmak ıstıyorm  20=150 , 90=500, 10=20 gibi
Her sayıya karşılık kactane  uretildiğini bir yapıda tutalım

2-) Devamında bu olusturdugumuz yapıda gezerken bu yapıdaki verileri bir liste yapısına ekleyeceğiz
Yani 20 150 kere tekrar etmişse 150 kere eklenecek toplamda boyutu 10 000 boyutlu bir liste elde etmiş olacağım

3-) Bu listeyi once karıştıralım daha sonra rastgele tekrar etmeyen 10 deger alalım yani bir deger 2 kere eklenemez
Ve böylece sanslı 10 numarayı bulmuş olucağız


 */
public class Main {



    public static void main(String[] args) {

        // metot kullanılarak rastgele oluşturulan sayılardan Map oluşturuldu
        Map<Integer,Integer> sayilarMap = rastgeleSayilardanMapOlustur();

        // Map Listeye dönüştürüldü
        List<Integer> sayilarListesi =maptenListeyeDonustur(sayilarMap);

        //Set kullanarak sectiğimiz sayıların birbirinden farklı olmasını sağladık
        Set<Integer> sansliSayilar = sansliOnNumara(sayilarListesi,10);
        System.out.println();
        System.out.println("***     Sanslı Numaralar    ***");
        //foreach ile yazdırma
        sansliSayilar.forEach(System.out::println);
        System.out.println();
        //sout ile yazdırma
        System.out.println(sansliSayilar);


    }// main sonu


    /**
     * Metod, içersinde 1 den 100e kadar rastgele olacak şekilde 10_000adet sayi üreten ve
     * bunları Map<Integer,Integer> cinsinde, k-> sayı v-> adet sayısı olacak şekilde dönen metod.
     * @return
     */
    public static Map<Integer,Integer> rastgeleSayilardanMapOlustur() {
        Random random = new Random();
        Map<Integer,Integer> sayilar = new HashMap<>();
        int sayi;
        int sayac=1;
        for (int i = 0; i < 10_000; i++) {
            sayi = random.nextInt(1,100);
            // Eğer sayı daha önceden listeye eklenmiş ise sayacı arttırıp kaç adet olduğu  buluyoruz
            // else ise listeye ekliyoruz
            if(sayilar.containsKey(sayi)){
                sayac++;
            }else{
                sayilar.put(sayi,sayac);
            }
        }
        sayilar.forEach((k,v)-> System.out.println(k+" sayısından bu kadar var---> "+v));
        return sayilar;
    }


    /**
     * Map<Integer,Integer> parametresi alarak bunu List<Integer> a dönüştürür. içerisinde kaç adet value
     * var ise key o kadar yazdırılır.
     * @param map
     * @return
     */
    private static List<Integer> maptenListeyeDonustur(Map <Integer, Integer> map) {
        List<Integer> sonuc = new ArrayList<>();

        // Her bir key-value çiftini döngü ile geziyoruz
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            // Keyi value kadar kadar Listeye ekle
            for (int i = 0; i < value; i++) {
                sonuc.add(key);
            }
        }
        sonuc.forEach(System.out::println);
        return sonuc;
    }


    /**
     * Girilen listeden(karıştırılmış liste) verilen sayi kadar Set listesine ekleme yapar.
     * Set kullanıldığı için secilenler birbirinden farklıdır
     * @param list
     * @param sayiAdedi
     * @return
     */
    private static Set<Integer> sansliOnNumara(List<Integer> list, int sayiAdedi) {
        //girdiğimiz listeyi burada suffle metodu ile karıştırıyoruz
        Collections.shuffle(list);
        //Set oluşturuyoruz
        Set<Integer> setListe = new HashSet<>();
        //karıştırdığımız listeden set e ekleme yapıyoruz
        for (Integer sayi : list) {
            setListe.add(sayi);
            // liste boyutu verdiğimiz sayıya eşit ise break
            if (setListe.size() == sayiAdedi) {
                break;
            }
        }
        return setListe;
    }








}