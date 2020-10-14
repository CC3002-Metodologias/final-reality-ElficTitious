Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---

**Breve Explicación del Programa - Tarea 1**

***Paquete Weapon***

En primer lugar se implementó una interfaz IWeapon la cual representa todas las armas disponibles en el juego, se definen en ella algunos getters necesarios y el método equipToPlayerCharacter(), el cual recibe un objeto de tipo IPlayerCharacter (a discutir en breve) y manda un mensaje indicando que dicha arma debe ser equipada, luego el personaje en cuestión “decide” qué hacer con dicho mensaje dependiendo de su clase específica y la clase de arma tratando de ser equipada. 

La clase abstracta AbstractWeapon implementa la interfaz anterior, donde además de definirse un constructor y dar cuerpo a los getters declarados, se definen los métodos equals() y hashCode() para luego ser utilizados en el testing. Definimos que un arma es igual a otra si estas dos son exactamente la misma instancia, o si pertenecen a la misma clase, tienen el mismo nombre y peso. 

Finalmente, definimos las subclases de armas específicas (Axe, Sword, Knife, Staff y Bow), los constructores de dichas subclases utilizan el constructor de la superclase anteriormente descrita (en el caso de Staff adicionalmente se define un campo mana y su getter respectivo), adicionalmente se da cuerpo a equipToPlayerCharacter(), donde lo único que se hace es equipar un arma de la clase en que se está definiendo dicho método (todos los personajes tendrán un método para equipar armas de cada clase).

***Paquete Character***

En primer lugar se implementó una interfaz ICharacter la cual posee tan solo el método waitTurn() que es común tanto a personajes controlados por el jugador como por la CPU.
Como subclase de aquella interfaz tenemos la clase Enemy con todos sus campos, constructor, getters necesarios e implementación de  métodos como waitTurn(), equals() y hashCode(). Definimos que dos enemigos son iguales si son exactamente la misma instancia, o si tienen el mismo nombre y peso. 

Posteriormente definimos la interfaz IPlayerCharacter como extensión de ICharacter, la cual representa tan solo personajes controlados por el jugador; se definen en ella los getters propios a personajes controlados por el jugador y todos los métodos para equipar armas de cada clase, por ejemplo EquipAxe(Axe axe) le dice al personaje que debe intentar equiparse el arma axe dada como parámetro (es posible que el personaje en cuestión, dada su clase, no sea capaz de equiparse un hacha). 

Definimos adicionalmente la interfaz IMageCharacter la cual representa personajes magicos como lo son Magos Negros y Magos Blancos (en nuestro caso Dark y White Wizard) y, por el momento, tan solo posee la declaración del método getMana() pero que no obstante, mas adelante en el proyecto, utilizaremos extensivamente para cuestiones como hechizos y efectos adversos. 

La clase abstracta AbstractPlayerCharacter se encarga de implementar la interfaz IPlayerCharacter antes discutida, en ella se define un constructor, da cuerpo a los getters declarados y se definen también los métodos waitTurn(), equals() y hashCode() para luego ser utilizados en el testing. Definimos que un personaje controlado por el jugador es igual a otro si estos dos son exactamente la misma instancia, o si pertenecen a la misma clase, y tienen el mismo nombre. Notemos también que en el cuerpo de esta clase se implementan todos los métodos para equipar armas como, por default,  imposible, i.e. ninguna clase de personaje es capaz de equiparse armas (independiente la clase del arma), esto nos ahorra duplicación de código en las subclases, donde tan solo escribimos excepciones al comportamiento anterior.

Se define así mismo la clase abstracta AbstractMagePlayerCharacter como extensión de la clase abstracta recién tratada y que implementa la interfaz IMageCharacter, donde se define un constructor que utiliza el de la superclase e inicializa un nuevo campo maná, se hace override al método EquipStaff() (todo personaje mágico es capaz de equipar un bastón) y se da cuerpo a getManá(). Veamos que, si bien se ha discutido no es buena práctica definir una clase abstracta como extensión de otra, y en este caso parece innecesario pues solo se define un método para equipar bastones y un getter de maná, en las entregas futuras este diseño resultará más extensible considerando que falta implementar los hechizos y efectos adversos (esta clase nos ahorrará también bastante duplicación de código en las subclases).

Finalmente, definimos las subclases de personajes controlados por el jugador, donde las clases Knight, Thief y Engineer extienden la clase abstracta AbstractPlayerCharacter mientras que las clases Dark Wizard y White Wizard extienden la clase abstracta AbstractMagePlayerCharacter. Dentro de cada una de estas clases se define un constructor que utiliza el de la superclase y se hace override a los métodos de equipar armas que correspondan, es decir, el de las clases de armas equipables por cada clase de personaje. La forma en que se equipa un arma es tan solo haciendo set del arma equipada (la cual está definida por defecto como null en la superclase).
