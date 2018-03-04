1. Vi behöver klasser för som ingår i model, view och controller. I model så har vi redan expr klasserna, xl klassen, exprParser, Enviroment. 
Sedan behövs fler klasser tex en klass som representerar enskilda rutor och en klass som representerar hela arket.
I view så är det GUI klasserna.
I Controller så är det klasser som skickar det vi skriver in och trycker på till modelen.

Vi behöver en klass som innehåller en matris med rutor, samt att rutorna i sig är representerade av en klass som innehåller en sträng eller ett expr.


2. Ett observer objekt som ingår i controllern skickar strängen i editorn till modelen. Ett objekt i modellen tolkar strängen och uppdaterar rutklassen med värdet av utrycket eller med strängen.
Viewn ser att modelen uppdaterats och visar det.

För att modelera detta kan man använda sig av template method där vi har ett interface som representerar en ruta och sedan har vi två konkreta klasser som implementerar detta, tex stringRuta och exprRuta. 


3. Ge inte rutorna något värde när de är tomma. Ge dem först ett värde när man skriver ett utryck eller värdet 0 när man skriver en text. Om man tar bort texten/expr i en ruta så ska rutan inte ha något värde längre.

4. Model ska vara observable och View och Controller ska vara Observers. De klasser som ingår i model skall därför observeras.

5. StatusPanel

6. Man kan skapa ett nytt kalkylark. Man kan skriva text i editorn. Menyraderna åker ner som de ska.

7. I expr klassen eller i klassen som implementerar environment

8. SlotLabel? Annars är det den klassen i modellen som representerar en ruta.

9. En klass i modelen som implementerar environment interfacet. Hela arket representeras av en matris av environment objekt.

10. ?





