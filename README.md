# Leitarvél fyrir hótel
## hbv401g-2016v-9h
### Upplýsingar um notkun

#### handleRequest()

(Date dateIn, Date dateOut, String location, int numGuest)

 - handleRequest er fall í Director.java. Fallið tekur við fjórum breytum.
 Þær eru, í þessari röð, dateIn, af taginu Date, dateOut, einnig af taginu Date,
 location, af taginu String, og numGuest, af taginu Integer. handleRequest skilar ArrayList
  af taginu Hotel.

  - dateIn er dagsettningin sem notandinn vill skrá sig inn á hótelið.
  - dateOut er dagsettningin sem notandinn vill skrá sig út af hótelinu.
  - location er borgin sem notandinn vill að hótelið sé í.
  - numGuest er fjöldi manns í herbergi.

#### bookRoom()
(Hotel h , TypeOfRoom t, Date dateIn, Date dateOut)  

 - bookRoom er fall í Director.java. Fallið tekur við fjórum breytum. Þær eru, í
 þessari röð, h, af taginu Hotel, t, af taginu TypeOfRoom, dateIn, af taginu Date,
  og dateOut, af taginu Date. Fallið skilar ekki neinu en bókar eitt herbergi
  í t og vistar bókunina í gagnagrunninn hotels.db.

  - h er hótelið sem notandinn vill bóka herbergi á.
  - t er herbergistegundin sem notandinn vil bóka.
  - dateIn er dagsettningin sem notandinn vill skrá sig inn á hótelið.
  - dateOut er dagsettningin sem notandinn vill skrá sig út af hótelinu.

### Upplýsingar um klasa

#### Date.java

 - Smiðurinn á Date tekur við þremur Integer breytum. Fyrsta breytan vísar í dag, önnur
 í mánuð og sú þriðja í ár. Ár eru einungis með fjórum tölustöfum, ( 2016 = 16 ).

  - Dæmi um notkun: Date dagur = new Date(1,1,16);


  - Við ákváðum að gera hlutinn Date þar sem við vorum í einhverju veseni með
  java.util.Date hlutinn. Vona að þetta valdi ekki of miklum ruglingi.

#### Room.java

 - Smiðurinn tekur við tveimur breytum. Þær eru roomID af taginu Integer og price af
 taginu Double. Room innihledur samt alltaf breytnua date sem er ArrayList af
 tveggja staka Date fylki. ArrayListinn heldur um allar bókanir á þessu herbergi. Hver
 bókun er tveggja staka Date fylki þar sem fyrra Date-ið lýsir því hvenær viðskiptavinur
 mætir og seinni Date-ið hvenær hann skráir sig út af herberginu.


#### TypeOfRoom.java

  - Smiðurinn tekur við fjórum Integer breytum. Fyrsta er singleBed sem lýsir fjölda
  einstæklingsrúma í þessari tegund af herbergi, önnur er doubleBed sem lýsir fjölda
  hjónarúma, þriðja er people sem lýsir fjölda manns sem geta gist í þessari tegund af
  herbergi og fjórða er typeOfRoomID. TypeOfRoom er alltaf með breytu sem heitir rooms.
  Breytan er ArrayList af taginu Room og öll þessi Room í fylkinu eru af viðeigandi tegund
  af herbergi.

#### Hotel.java

 - Smiðurinn tekur einungis við einni breytu af taginu String. breytan heitir location
 og lýsir staðsettningu hótelsins. Hótelið er samt alltaf með fjórar aðrar breytur.
 Þær eru info af taginu String, hotelID, af taginu Integer, name, af taginu String og
 roomTypes sem er ArrayList af taginu TypeOfRoom. Öll TypeOfRoom í þessum ArrayList
 eru í viðeigandi hóteli.


### Hvernig á ég að setja þetta upp?

 - mappan "src" inniheldur alla .java filea sem þarf. hotels.db þyrfti helst að vera í
rót verkefnisins sjálfs. Ef það er eitthvað vesen að hafa .db skránna þar þá er ekkert
mál að redda því. Það þarf að refrence-a í sqlite-jdbc-3.8.11.2.jar fileinn til þess
að ná tenginu við gagnagrunninn.
