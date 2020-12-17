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

**Breve Explicación del Programa - Tarea 2**

***Paquete Weapon***

En primer lugar se implementó una interfaz IWeapon la cual representa todas las armas disponibles en el juego, se definen en ella algunos getters necesarios y el método equipToPlayerCharacter(), el cual recibe un objeto de tipo IPlayerCharacter (a discutir en breve) y manda un mensaje indicando que dicha arma debe ser equipada, luego el personaje en cuestión “decide” qué hacer con dicho mensaje dependiendo de su clase específica y la clase de arma tratando de ser equipada. 

La clase abstracta AbstractWeapon implementa la interfaz anterior, donde además de definirse un constructor y dar cuerpo a los getters declarados, se definen los métodos equals() y hashCode() para luego ser utilizados en el testing. Definimos que un arma es igual a otra si estas dos son exactamente la misma instancia, o si pertenecen a la misma clase, tienen el mismo nombre y peso. 

Finalmente, definimos las subclases de armas específicas (Axe, Sword, Knife, Staff y Bow), los constructores de dichas subclases utilizan el constructor de la superclase anteriormente descrita (en el caso de Staff adicionalmente se define un campo mana y su getter respectivo), adicionalmente se da cuerpo a equipToPlayerCharacter(), donde lo único que se hace es equipar un arma de la clase en que se está definiendo dicho método (todos los personajes tendrán un método para equipar armas de cada clase).

***Paquete Character***

En primer lugar se implementó una interfaz ICharacter la cual posee los métodos comunes tanto a personajes controlados por el jugador como por la CPU. Estos son, el método waitTurn(), método turn(), métodos para atacar y recibir ataques, y getters para campos comunes entre enemigos y personajes del jugador.
Como subclase de aquella interfaz tenemos la clase Enemy con todos sus campos, constructor, getters y setters necesarios e implementación de métodos como waitTurn(), equals(), hashCode(), turn(), attack(), beingAttacked(), isAlive() y addListeners(). Definimos que dos enemigos son iguales si son exactamente la misma instancia, o si tienen el mismo nombre y peso. El método addListener() agrega observers para los eventos de muerte y cambio de turno, los cuales se gatillan, dentro del método beingAttacked() al morir la instancia, y al llamarse turn() dentro del controlador del juego respectivamente.

Posteriormente definimos la interfaz IPlayerCharacter como extensión de ICharacter, la cual representa tan solo personajes controlados por el jugador; se definen en ella los getters propios a personajes controlados por el jugador y todos los métodos para equipar armas de cada clase, por ejemplo EquipAxe(Axe axe) le dice al personaje que debe intentar equiparse el arma axe dada como parámetro (es posible que el personaje en cuestión, dada su clase, no sea capaz de equiparse un hacha). 

Definimos adicionalmente la interfaz IMageCharacter la cual representa personajes magicos como lo son Magos Negros y Magos Blancos (en nuestro caso Dark y White Wizard) y, por el momento, tan solo posee la declaración del método getMana() pero que no obstante, mas adelante en el proyecto, utilizaremos extensivamente para cuestiones como hechizos y efectos adversos. 

La clase abstracta AbstractPlayerCharacter se encarga de implementar la interfaz IPlayerCharacter antes discutida, en ella se define un constructor, da cuerpo a los getters declarados y se definen también los métodos waitTurn(), equals(), hashCode(), turn(), attack(), beingAttacked(), isAlive() y addListeners(); el método addToQueue() verifica que el personaje tratando de entrar a la cola esté vivo (lo mismo sucede para enemigos) . Definimos que un personaje controlado por el jugador es igual a otro si estos dos son exactamente la misma instancia, o si pertenecen a la misma clase, y tienen el mismo nombre. Notemos también que en el cuerpo de esta clase se implementan todos los métodos para equipar armas como, por default,  imposible, i.e. ninguna clase de personaje es capaz de equiparse armas (independiente la clase del arma), esto nos ahorra duplicación de código en las subclases, donde tan solo escribimos excepciones al comportamiento anterior. El método addListener() agrega observers para los eventos de muerte y cambio de turno, los cuales se gatillan, dentro del método beingAttacked() al morir la instancia, y al llamarse turn() dentro del controlador del juego respectivamente (de la misma manera a como fue explicitado en la descripción para enemigos).

Se define así mismo la clase abstracta AbstractMagePlayerCharacter como extensión de la clase abstracta recién tratada y que implementa la interfaz IMageCharacter, donde se define un constructor que utiliza el de la superclase e inicializa un nuevo campo maná, se hace override al método EquipStaff() (todo personaje mágico es capaz de equipar un bastón) y se da cuerpo a getManá(). Veamos que, si bien se ha discutido no es buena práctica definir una clase abstracta como extensión de otra, y en este caso parece innecesario pues solo se define un método para equipar bastones y un getter de maná, en las entregas futuras este diseño resultará más extensible considerando que falta implementar los hechizos y efectos adversos (esta clase nos ahorrará también bastante duplicación de código en las subclases).

Finalmente, definimos las subclases de personajes controlados por el jugador, donde las clases Knight, Thief y Engineer extienden la clase abstracta AbstractPlayerCharacter mientras que las clases Dark Wizard y White Wizard extienden la clase abstracta AbstractMagePlayerCharacter. Dentro de cada una de estas clases se define un constructor que utiliza el de la superclase y se hace override a los métodos de equipar armas que correspondan, es decir, el de las clases de armas equipables por cada clase de personaje. La forma en que se equipa un arma es tan solo haciendo set del arma equipada (la cual está definida por defecto como null en la superclase).

***Paquete Controller***

**Paquete Factories**

Definimos la clase CharacterFactory encargada de crear, dentro del controlador, instancias de cada tipo de personaje (incluyendo enemigos), y adicionalmente se implementan los getter necesarios para conocer los datos de estos. Los métodos encargados de crear personajes retornan instancias de estos y, mediante el método addListeners(), se añaden los Handlers encargados de observar eventos de muerte e inicio de turno para el jugador y enemigo.

La clase WeaponFactory, de la misma manera a como se detalló para el CharacterFactory, se encarga de crear instancias de armas en el controlador y tener los getters necesarios para conocer los datos de estas.

**Paquete Handlers**

Se define la interfaz IEventHandler encargada de extender la clase PropertyChangeListener, y los handlers EnemyDeathHandler, PlayerDeathHandler, EnemyTurnHandler y PlayerTurnHandler los cuales implementan la anterior interfaz. Los handlers EnemyDeathHandler y PlayerDeathHandler se encargan de observar eventos de muerte para enemigos y jugadores respectivamente, dentro de los cuales se asigna un controlador y al ser gatillados, envían el mensaje necesario por aquel para revisar si el jugador a perdido o ganado el juego. Los Handlers EnemyTurnHandler y PlayerTurnHandler se encargan de recibir el mensaje enviado por los jugadores al momento de activarse su turno (incluyendo enemigos), notificando a su vez al controlador (asignado en el constructor) a que personaje le corresponde en siguiente turno.

**Clases GameController, Party e Inventory**

Se define la clase Party, implementada como un arreglo dinámico, la cual se encarga de almacenar los personajes controlados por el jugador y aquellos controlados por la CPU (enemigos). En esta clase definimos un método para agregar personajes a la “party”, quitar personajes de la “party” y un getter para la cantidad de personajes en ella. De la misma manera, la clase Inventory, implementada como un arreglo dinámico, se encarga de almacenar las armas disponibles para ser usadas por el jugador, en ella definimos un método para agregar armas al inventario y quitar armas del inventario.

Finalmente, definimos la clase GameController, encargada de controlar el flujo del juego. En ella tenemos una cola de turnos, “parties” de jugadores controlados por la CPU y jugador, fábricas de jugadores y armas y los handlers definidos anteriormente. El método equipWeapon() se encarga de equipar armas a un jugador, quitando el arma siendo equipada del inventario y agregando al inventario el arma anteriormente equipada por el jugador. El método attack() se encarga de controlar el combate en el juego. El método checkLoss() se gatilla cada vez que muere un personaje controlado por el jugador, quitandolo de la cola de turnos y la “party” del jugador, y verificando que queden personajes disponibles; de no quedar personajes disponibles a ser utilizados por el jugador, la función retorna true (el jugador a perdido). El método checkVictory() se gatilla cada vez que muere un enemigo, quitandolo de la cola de turnos y la “party” de los personajes controlados por la CPU, y verificando que queden personajes disponibles en ella; de no quedar personajes disponibles a ser utilizados por la CPU, la función retorna true (el jugador a ganado). Se implementan así mismo los primeros tres pasos de la sección 2.2 de la descripción del proyecto. El primer paso, implementado por el método getNextCharacter(), toma al primer personaje de la cola de turnos, llamando a su vez al método turn() (manejado por los handlers de turnos) el cual gatilla uno de los dos turnos posibles (enemyTurn() o playerTurn(), los cuales por el momento quedan vacíos), para finalmente retornar el personaje tomado. El segundo paso, implementado por el método removeCharacter(), se encarga de quitar de la cola de turnos el personaje tomado en el paso anterior. El tercer paso, implementado por el método setTimer(), llama a waitTurn() para el personaje tomado en el primer paso. Los pasos 4 y 5 se dejan pendientes para la próxima entrega, esto pues para aquello se implementará un state pattern, no obstante se declarará un observer encargado de notificar cuando la cola no esté vacía, en cuyo momento se agregará el personaje tomado en el primer paso a la cola de turnos. Finalmente, en esta clase se definen todos los getter necesarios para el testeo.
