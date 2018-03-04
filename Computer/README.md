Uppgifter:

1:


Instructions(interface), MemorySpace(interface), Word(abstract class), Memory(abstract class), ProgramCounter(class), BinOp(abstract class).



2:


Eftersom man vill kunna hoppa tillbaka till ett specifikt index anser vi att ArrayList är bäst då det går på konstant tid och har ett bra inbyggt index. Den har även en färdig implementerad add metod.



3:


Det som har med minnet att göra, ex Memory och MemorySpace ligger i ett paket MemoryHandle. I det andra paketet MainComputer ligger Computer, Program och instructions med tillhörande subklasser.



4: 


Interfacet Instructions har en metod execute() som varje operand måste implementera. 



5:


Template method används för att samla den duplicerade koden i abstrakta klasser. Word är en abstrakt klass som LongWord ärver av. Om man vill lägga till VeryLongWord unviks därför duplicering. Detsamma gäller den abstrakta klassen Memory och LongMemory (VeryLongMemory). Även den abstrakta klassen BinOp har lagts till för att lyfta ut duplicerad kod ur Add och Mul. 




6:


I instructions behöver minnet ändras. Istället för att göra det i instruktionerna delegeras detta till Word i MemorySpace. 



7:

Add utförs i Words subklasser.



