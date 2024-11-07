# Java exercise: File Management

Vous allez développer un programme Java qui gère la lecture et l'écriture dans un fichier texte. L'objectif est de manipuler les fichiers à l'aide de l'API classique (java.io) et de gérer correctement les exceptions liées aux opérations I/O.

## Objectifs

Lire le contenu d’un fichier texte (fichier_entree.txt) ligne par ligne.
Écrire dans un nouveau fichier (fichier_sortie.txt) les lignes lues, tout en les numérotant.

### Gérer les cas suivants avec des exceptions appropriées :
Le fichier d'entrée n'existe pas.
Une erreur se produit pendant l'écriture.

### Afficher dans la console :
Les lignes lues avec leur numéro.
Un message indiquant si l’écriture dans le fichier de sortie a réussi ou échoué.

## Contraintes
Utilisez des blocs try-with-resources pour garantir la fermeture des flux.
Le programme doit être robuste : toutes les exceptions doivent être correctement gérées.
Si le fichier d'entrée n'existe pas, affichez un message clair et terminez le programme.

## Structure attendue
Un fichier d’entrée : fichier_entree.txt (vous pouvez en créer un avec quelques lignes de texte).
Un fichier de sortie : fichier_sortie.txt, qui sera généré par le programme.

## Exemple de sortie

Si le fichier fichier_entree.txt contient :

Bonjour tout le monde.
Bienvenue dans cet exercice.
Amusez-vous bien avec Java !

Votre programme doit afficher :


Lignes lues :
Bonjour tout le monde.
Bienvenue dans cet exercice.
Amusez-vous bien avec Java !

Écriture terminée avec succès dans fichier_sortie.txt.

Et le contenu du fichier fichier_sortie.txt sera :

Bonjour tout le monde.
Bienvenue dans cet exercice.
Amusez-vous bien avec Java !

## Points importants pour les étudiants
Blocs try-with-resources : Simplifient la gestion des flux en garantissant leur fermeture.
Exceptions spécifiques :
FileNotFoundException pour vérifier l'existence du fichier d'entrée.
IOException pour gérer les erreurs générales d'I/O.
Organisation du code : Séparer clairement la lecture et l’écriture pour une meilleure lisibilité.
Robustesse : Le programme doit gérer les cas d'erreurs (fichiers manquants, permissions, etc.).
Exercices supplémentaires

Modifiez le programme pour copier uniquement les lignes qui contiennent un certain mot-clé.

Ajoutez une option pour que l'utilisateur saisisse le chemin du fichier d'entrée et du fichier de sortie via la console.
try (ResourceType resource = new ResourceType(...)) {
// Opérations sur la ressource
} catch (ExceptionType e) {
// Gestion des exceptions
}