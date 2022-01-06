# WDP_4_BV_PD3750
Java learning
Zad 1:
Napisać program, który jako pierwszy argument wywołania uzyskuje  łańcuch znakowy i:
podaje na konsoli długość łańcucha, 
wyprowadza pierwszy i ostatni znak (rozdzielone spacją) 
wyprowadza podłańcuch od 4 znaku do ostatniego znaku, 
wyprowadza podłańcuch od 4 znaku do przedostatniego znaku, 
wyprowadza informacje o tym ile razy w wejściowym łańcuchu występuje zadany (podany jako drugi argument wywołania programu) podłańcuch (np. 
ile razy w łańcuchu "podstoleczne tramwaje mialy postoje po sto razy dziennie" występuje podlancuch "sto" - w tym przypadku 3) 
tworzy tablicę wszystkich słów  łańcucha (tu slowa niech oznaczają zestawy znaków rozdzielone spacjami, przecinkami, kropkami i średnikami) i
wyprowadza jej elementy w jednym wierszu, rozdzielone znakiem _ (podkreślenie) ,
stwierdzia czy pierwsze i ostatnie słowo łańcucha jest takie samo. 
Działanie programu winno wyglądać w następujący sposób.
Załóżmy, że jako argumenty wywołania programu podano:
"ala ma kota, ale  ma psa.psa.hopsa. psa kota psa ma ala" psa

Przy takim wywołaniu na konsoli powinniśmy uzyskać wynik:

1) 55
2) a a
3) ma kota, ale  ma psa.psa.hopsa. psa kota psa ma ala
4) ma kota, ale  ma psa.psa.hopsa. psa kota psa ma al
5) 5
6) ala_ma_kota_ale_ma_psa_psa_hopsa_psa_kota_psa_ma_ala
7) true

Sposób działania programu i forma wydruku są obowiązkowe
(proszę zwrócić uwagę na wyprowadzanie numeracji kolejnych punktów zadania na wydruku oraz na to w jaki sposób podawane sa wynik).

Pomoc:
Proszę zobaczyć w wykładzie materiał o argumentach wywołania programu (argumenty wiersza poleceń).
Z poziomu Eclipse argumenty podajemy wybierając: Run - Run Configurations i wpisując argumenty pod Arguments:

_________________________________________________________________________________________________________________________________________________________________________________

zad 2

Daty w pliku tekstowym  o nazwie{user.home}/test/daty.txt maja postać YYYY-MM-DD (rok- miesiac- dzien). Oprócz dat, plik zawiera inne informacje.
Wczytać plik i wypisać w jednym wierszu wszystkie poprawne daty - czyli:
  po wyróżnieniu wszystkich fragmentów, które mogą być datami sprawdzić ich poprawnośc (np. czy właściwa jest liczba dni w miesiącu)

Program powininn w specyficzny sposób traktować niejednozanczną informację (np. 2009-01-111 - czy to błędna data czy potraktowac ją jako 2009-01-11).
Sposób traktowania takich sytuacji wyjaśnia poniższy przykład.

Dane w pliku:

2007-01-12Jakis txt2008-01-31 xxx 2008-02-29 2008-15-10 2008-19-45 2009-05-01 
20999-11-11 pppp 2001-00-01 09-01-01 2001-01-00 2009-01-111 2009-02-29 1998-11-11

Program powinien wyprowadzić:

2007-01-12 2008-01-31 2008-02-29 2009-05-01 1998-11-11

Podpowiedź: użyć skanera, wyrażeń regularnych (ale same wyrażenia reg. nie wystarczą).

Uwaga: nazwa i lokalizacja pliku jest obowiązkowa. O katalogu user.home - zob. poprzednie zadania. Proszę nie dostarczać  z projektem swoich własnych plików.

_________________________________________________________________________________________________________________________________________________________________________________

zad 3

Kwiaciarnia (uwaga: niezbędny do wykonania tego zadania  materiał  zawiera punkt o polimorfizmie w wykładzie, dotyczącym programowania obiektowego)

Napisać aplikację, która symuluje zakupy w kwiaciarni "samoobsługowej".
W kwiaciarni są kwiaty, kwiaty mają swoje nazwy oraz kolory. Ceny kwiatów znajdują się w cenniku.
Do kwiaciarni przychodzą klienci. Klienci mają imiona oraz dysponują jakimś zasobem pieniędzy. Wybierają kwiaty i umieszczają je na wózku sklepowym.
Następnie płacą za zawartość wózka i przepakowują ją do pudełka (jakiegoś pudełka na kwiaty :-).

Aplikacja wymaga zdefiniowania kilku klas i umiejętnego ich użycia, w taki sposób by następujący program działał poprawnie.

       public class FloristsTest {
          // definicja metody sumowania wartosci kwiatów o podanym kolorze 
          static int valueOf(Box box, String color) {
               /*<- tu trzeba wpisac kod metody */
          }

          public static void main(String[] args) {
            // Kwiaciarnia samoobsługowa
            // ustalenie cennika
            PriceList pl = PriceList.getInstance();
            pl.put("róża", 10.0);
            pl.put("bez", 12.0);
            pl.put("piwonia", 8.0);

            // Przychodzi klient janek. Ma 200 zł
            Customer janek = new Customer("Janek", 200);

            // Bierze różne kwiaty: 5 róż, 5 piwonii, 3 frezje, 3 bzy
            janek.get(new Rose(5));
            janek.get(new Peony(5));
            janek.get(new Freesia(3));
            janek.get(new Lilac(3));

            // Pewnie je umieścił na wózku sklepowyem
            // Zobaczmy co tam ma
            ShoppingCart wozekJanka = janek.getShoppingCart();
            System.out.println("Przed płaceniem " + wozekJanka);

            // Teraz za to zapłaci...
            janek.pay();

            // Czy przypadkiem przy płaceniu nie okazało się,
            // że w koszu są kwiaty na które nie ustalono jeszcze ceny?
            // W takim arzie zostałyby usunięte z wózka i Janek nie płaciłby za nie
            // Również może mu zabraknąc pieniędzy, wtedy też kwaity są odkładane.

            System.out.println("Po zapłaceniu " + janek.getShoppingCart());

            // Ile Jankowi zostało pieniędzy? 
            System.out.println("Jankowi zostało : " + janek.getCash() + " zł");

            // Teraz jakos zapakuje kwiaty (może do pudełka)
            Box pudelkoJanka = new Box(janek);
            janek.pack(pudelkoJanka);

            // Co jest teraz w wózku Janka...
            // (nie powinno już nic być)
            System.out.println("Po zapakowaniu do pudełka " + janek.getShoppingCart());

            // a co w pudełku
            System.out.println(pudelkoJanka);

            // Zobaczmy jaka jest wartość czerwonych kwiatów w pudełku Janka
            System.out.println("Czerwone kwiaty w pudełku Janka kosztowały: "
                + valueOf(pudelkoJanka, "czerwony"));

            // Teraz przychodzi Stefan
            // ma tylko 60 zł
            Customer stefan = new Customer("Stefan", 60);

            // Ale nabrał kwiatów nieco za dużo jak na tę sumę
            stefan.get(new Lilac(3));
            stefan.get(new Rose(5));

            // co ma w wózku
            System.out.println(stefan.getShoppingCart());

            // płaci i pakuje do pudełka
            stefan.pay();
            Box pudelkoStefana = new Box(stefan);
            stefan.pack(pudelkoStefana);

            // co ostatecznie udało mu się kupić
            System.out.println(pudelkoStefana);
            // ... i ile zostało mu pieniędzy
            System.out.println("Stefanowi zostało : " + stefan.getCash() + " zł");
          }
        }
Program ten wyprowadzi na konsolę:
Przed płaceniem Wózek własciciel Janek
róża, kolor: czerwony, ilość 5, cena 10.0
piwonia, kolor: czerwony, ilość 5, cena 8.0
frezja, kolor: żółty, ilość 3, cena -1.0
bez, kolor: biały, ilość 3, cena 12.0
Po zapłaceniu Wózek własciciel Janek
róża, kolor: czerwony, ilość 5, cena 10.0
piwonia, kolor: czerwony, ilość 5, cena 8.0
bez, kolor: biały, ilość 3, cena 12.0
Jankowi zostało : 74.0 zł
Po zapakowaniu do pudełka Wózek własciciel Janek -- pusto
Pudełko własciciel Janek
róża, kolor: czerwony, ilość 5, cena 10.0
piwonia, kolor: czerwony, ilość 5, cena 8.0
bez, kolor: biały, ilość 3, cena 12.0
Czerwone kwiaty w pudełku Janka kosztowały: 90
Wózek własciciel Stefan
bez, kolor: biały, ilość 3, cena 12.0
róża, kolor: czerwony, ilość 5, cena 10.0
Pudełko własciciel Stefan
bez, kolor: biały, ilość 3, cena 12.0
Stefanowi zostało : 24.0 zł


Uwaga: kod tego programu można zmienic tylko w miejscu zaznaczonym na zielono.


Dodawanie do  programu nowych rodzajów kwiatów  ma byc bardzo łatwe.
Przy dodaniu nowego rodzaju kwiatów nie wolno modyfikować żadnych innych klas programu.
Wymagania dodatkowe:
należy wykorzystać klasy abstrakcyjne i polimorfizm
należy zminimalizować kod klas ShoppingCart i Box
należy zdefiniować klasę PriceList jako singleton (możemy mieć zawsze tylko jeden cennik)
Ważne uwagi.
W kwiaciarni mogą być kwiaty, których zapomniano dodać do cennika. Wtedy przy płaceniu są one usuwane z naszego wózka.
Może się okazać, że klient nie dysponuje odpowiednią kwotą pieniędzy aby zapłacić za całą zawartość wóżka. Wtedy z wózka usuwane są kwiaty,
za które klient nie może zapłacić (ale nie pojedyńczo, tylko w kompletach np. po stefan.get(new Lilac(3)) usuwane są te trzy bzy na które Stefan nie ma pieniędzy).
Warto zwrócić uwagę na odpowiednio zdefiniowanie metody toString() w niektórych klasach.

I na koniec: nie przejmujemy się tym, że np. róże mogą mieć wiele kolorów. Dla uproszczenia przyjęliśmy, że róże są czerwone itd.

