__________________________________________________________________________
Nom de l'étudiant       | Prénoms de l'étudiant                          
| ATIVI                 | Eugene Ephrem                                  | 
__________________________________________________________________________
| ATTIOGBE              | Elom Mensah Amen                               |
__________________________________________________________________________

Exercice 1 : Nom des package :
_ scheduling.activities: question 1.1 à 1.3
_scheduling.basicconstraints : question 1.4 à 1.10

Exercice 2 : Nom des packages
_ scheduling.basictopologicalsort : question 2.1 à 2.5

Liste des classes exécutables : 
|
|__README.txt
|
|__src
   |
   |______scheduling
          |
          |__activities
          |  |
          |  |_________Demo.java
          |__basicconstraints
          |  |
          |  |_________Demo.java
          |__basictopologicalsort
          |  |
          |  |_________Main.java
          |__factoredconstraint
          |  |
          |  |_________Demo.java
          |__factoredtopologicalsort
          |  |
          |  |_________Main.java
          |__constraints
          |
          |__solvers
             |
             |_________Main.java(pour le normal)
             |_________Main2.java(pour les générations aléatoires)
           
Mode d'emploi : 
_ Pour lancer la classe exécutable Demo.java de l'exercice 1 
   |____activities
   |    |__Pour la compilation : javac -d ../build -cp .:../lib/schedulingtests.jar scheduling/activities/*.java
   |    |__Pour l'exécution : java -cp ../build:../lib/schedulingtests.jar scheduling/activities.Demo
   |____basicconstraints
        |__Pour la compilation : javac -d ../build -cp .:../lib/schedulingtests.jar scheduling/basicconstraints/*.java
        |__Pour l'exécution : java -cp ../build:../lib/schedulingtests.jar scheduling/basicconstraints.Demo



_Pour lancer la classe exéctutable Main.java de l'exercice 2 
Pour la compilation : javac -d ../build -cp .:../lib/schedulingtests.jar scheduling/basictopologicalsort/*.java
Pour l'exécution : java -cp ../build:../lib/schedulingtests.jar scheduling/basictopologicalsort.Main

_Pour lancer la classe exéctutable Main.java de l'exercice 3 (on a juste ajouté linearTimeSort)
Pour la compilation : javac -d ../build -cp .:../lib/schedulingtests.jar scheduling/basictopologicalsort/*.java
Pour l'exécution : java -cp ../build:../lib/schedulingtests.jar scheduling/basictopologicalsort.Main

_Pour lancer la classe exéctutable Main.java de l'exercice 4 (on a ajouté le PrecedenceConstraintWithGap)
Pour la compilation : javac -d ../build -cp .:../lib/schedulingtests.jar scheduling/basicconstraints/*.java
Pour l'exécution : java -cp ../build:../lib/schedulingtests.jar scheduling/basicconstraints.Demo


_Pour lancer la classe exéctutable Main.java de l'exercice 6
Pour la compilation : javac -d ../build -cp .:../lib/schedulingtests.jar scheduling/solvers/*.java
Pour l'exécution : java -cp ../build:../lib/schedulingtests.jar scheduling/solvers.Main



_Pour lancer la classe exéctutable Main.java de l'exercice 7(génération aléatoire)
Pour la compilation : javac -d ../build -cp .:../lib/schedulingtests.jar scheduling/solvers/*.java
Pour l'exécution : java -cp ../build:../lib/schedulingtests.jar scheduling/solvers.Main2 (pour la génération aléatoire)



_Pour lancer la classe exéctutable Main.java de l'exercice 8(les deux tests)
Pour la compilation : javac -d ../build -cp .:../lib/schedulingtests.jar scheduling/constraint/*.java
Pour l'exécution : java -cp ../build:../lib/schedulingtests.jar scheduling/constraints.TestNegation(qui marche)
Pour l'exécution : java -cp ../build:../lib/schedulingtests.jar scheduling/constraints.TestNegation2(qui ne marche pas)
Pour l'exécution : java -cp ../build:../lib/schedulingtests.jar scheduling/constraints.TestDisjunction(qui marche)
Pour l'exécution : java -cp ../build:../lib/schedulingtests.jar scheduling/constraints.TestDisjunction2(qui ne marche pas)



Pour la javadoc : 
javadoc -d ../doc scheduling/activities/Demo.java scheduling/basicconstraints/Demo.java scheduling/basictopologicalsort/Main.java scheduling/solvers/Main.java scheduling/solvers/Main2.java

_________________________________________________Merci_________________________________________________________
