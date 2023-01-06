# **FILE GYAKORLÓ FELADAT(Sorforgató)**  
**Bevezetés**  
Nagyon fontos adatokat tároltál szöveges fájlokban. Azonban egy csúnya vírus belerondított minden sorodba!  
A sorok hossza szerencsére ugyanaz maradt mint régen, azonban a kezdőbetű eltolódott!  
A kezdőbetűtől a karakterek sorrendje helyes, azonban amelyik karakterek nem fértek ki a fix sorhosszba, azok a sor elején jelennek meg.  
Szerencsére biztosan tudod, hogy minden sorod kezdőbetűje nagybetű volt, egy sor sem tartalmaz több nagybetűt és minden sorban  
csak az ABC betűi valamint szóközök szerepelnek.

**Példa:**

| Eredeti | Elrontott |
|---------|---------|
| A szőlő finom | nomA szőlő fi |
 
Írj egy java programot, ami képes visszaállítani az elrontott fájljaidat!  
**Feladatleírás**  
Írj egy osztályt, `FileRowRotater`, melynek van egy `rotateRows()` metódusa. A `FileRowRotater`-t úgy lehet létrehozni,  
hogy konstruktorában megadjuk a javítandó fájl elérési útvonalát + nevét. A `rotateRows` hívás beolvassa a fájl tartalmát,  
soronként helyre forgatja, és egy új fájlba menti, melynek neve: <eredeti fájl név>.rotated.<kiterjesztes>.  
Pl.: dog.txt → dog.rotated.txt

**Példák sorokra:**
 
| Input fájl egy sora | Output fájl megfelelő sora |
|-------------|----------|
| asztalKerek | Kerekasztal |
| m vanMa jó napo | Ma jó napom van |
| A | A |
| ekete bika pataF | Fekete bika pata |
| ján   a   jetiBobor | Boborján   a   jeti|
