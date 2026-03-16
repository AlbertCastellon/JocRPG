# 🎮 Videojoc RPG per Consola (Java)

Aquest projecte és un **videojoc simple tipus RPG desenvolupat en Java** que s'executa per consola.
Permet crear personatges, crear i assignar armes, i fer combats entre dos jugadors utilitzant els personatges disponibles.

El projecte està pensat com a **pràctica de programació orientada a objectes**, utilitzant estructures com classes, enums, arrays i `ArrayList`.

---

# 📋 Funcionalitats

El programa disposa de diverses funcionalitats accessibles mitjançant menús.

## 👤 Gestió de Personatges

Permet gestionar els personatges del joc.

Opcions disponibles:

* Crear un personatge manualment
* Crear un personatge automàticament
* Llistar tots els personatges creats

### Creació manual

L'usuari pot decidir:

* Nom
* Raça
* Edat
* Distribució de punts d'atributs

Cada atribut té un valor mínim de **5** i el total màxim és **80 punts**.

Atributs disponibles:

* **Força (STR)**
* **Destresa (DEX)**
* **Constitució (CON)**
* **Intel·ligència (INT)**
* **Saviesa (WIS)**
* **Sort (LUCK)**

Els punts sobrants s'assignen automàticament a **Sort**.

### Creació automàtica

El programa genera aleatòriament:

* Raça
* Edat
* Distribució dels atributs

---

# ⚔️ Gestió d'Armes

Permet crear armes i assignar-les als personatges.

Opcions disponibles:

* Crear una nova arma
* Crear i assignar una arma a un personatge
* Llistar totes les armes

Cada arma té:

* **Nom**
* **Tipus**
* **Si és màgica o no**
* **Valor d'atac**

Tipus d'armes disponibles:

* Espasa
* Destral
* Maça
* Arc

---

# 🕹️ Sistema de Joc

Dos jugadors poden seleccionar:

* El seu **nom**
* El **personatge** que volen utilitzar

Després comença el combat.

---

# 🥊 Sistema de Combat

El combat funciona per **torns**.

En cada torn els jugadors poden triar entre:

1. **Atacar**
2. **Defensar-se**

### Atacar

El personatge utilitza la seva arma per fer mal al rival.

### Defensar-se

El personatge redueix o evita el dany rebut durant el torn.

El combat continua fins que:

* La vida d'un dels personatges arriba a **0**.

---

# 🧠 Conceptes de Programació Utilitzats

Aquest projecte utilitza diversos conceptes importants de Java:

* **Programació Orientada a Objectes (POO)**
* Classes
* Enums
* `ArrayList`
* Arrays
* Menús interactius amb `Scanner`
* Validació d'entrada d'usuari
* Generació de valors aleatoris (`Math.random()`)

---

# 📁 Estructura del Projecte

El projecte està compost principalment per les següents classes:

```
videojoc.java      → Classe principal amb els menús
Personatge.java    → Representa els personatges del joc
Arma.java          → Representa les armes
```

---

# ▶️ Com executar el projecte

1. Compilar el programa:

```bash
javac *.java
```

2. Executar el joc:

```bash
java videojoc
```

---

# 🚀 Possibles millores futures

Algunes funcionalitats que es podrien afegir en el futur:

* Sistema d'experiència i nivells
* Inventari d'objectes
* Més tipus d'armes
* Sistema d'esquiva basat en destresa
* Atacs crítics basats en sort
* Interfície gràfica

---

# 👨‍💻 Autor

Projecte desenvolupat com a pràctica de **programació en Java**.
