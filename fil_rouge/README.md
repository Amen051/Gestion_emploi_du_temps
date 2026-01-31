#  Automated Scheduling System - Java

Ce projet implémente un solveur d'ordonnancement d'activités sous contraintes. Développé en **Java**, il utilise des concepts avancés d'algorithmique de graphes pour générer des emplois du temps valides.

## Auteurs
- **Elom Mensah Amen ATTIOGBE**
- **Eugene Ephrem ATIVI**

---

##  Fonctionnalités & Algorithmes
Le projet est découpé en plusieurs modules suivant l'évolution des problématiques d'ordonnancement :

* **Gestion d'Activités & Contraintes** : Implémentation de contraintes de précédence (`PrecedenceConstraint`) et de délais (`Gap`).
* **Tri Topologique** : Utilisation de l'algorithme de tri topologique (incluant une version en temps linéaire) pour résoudre l'ordre d'exécution des tâches.
* **Solveurs Aléatoires** : Génération d'emplois du temps basés sur des approches probabilistes pour tester la robustesse des contraintes.
* **Logique de Contraintes** : Gestion avancée via des opérateurs logiques (Négation, Disjonction).

---

##  Structure du Projet
Le code est organisé en packages pour une meilleure modularité :
- `scheduling.activities` : Définition des entités de base.
- `scheduling.constraints` : Moteur de règles et contraintes logiques.
- `scheduling.solvers` : Algorithmes de résolution (Main & Random Generation).
- `scheduling.basictopologicalsort` : Cœur algorithmique (Graphes).

---

##  Guide de démarrage

### Prérequis
Le projet nécessite la librairie `schedulingtests.jar` présente dans le dossier `/lib`.

### Compilation & Exécution (Exemple Solveur Principal)
```bash
# Compilation
javac -d ../build -cp .:../lib/schedulingtests.jar scheduling/solvers/*.java

# Exécution du solveur standard
java -cp ../build:../lib/schedulingtests.jar scheduling.solvers.Main

# Exécution du solveur aléatoire
java -cp ../build:../lib/schedulingtests.jar scheduling.solvers.Main2
