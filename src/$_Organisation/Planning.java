package $_Organisation;

public class Planning {
   /**
    * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    * // NE RIEN SUPPRIMER SUR CE DOCUMENT - RAJOUTEZ JUSTE DES INFORMATIONS (par exemple qui s'est occupé de quoi)
    * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    * 
    * Il faut commencer par bien définir comme notre jeu fonctionnera.
    * Base n°1 (peut être modifié) :
    * 1) On saisit les noms des joueurs (2 min - 6 max) - sur une première ihm (détaillé dans la partie III. Ihm)
    *       -> Espace près défini pour rentrer le nom de 2 joueurs, et bouton pour "rajouter un joueur", par exemple
    *       -> Bouton pour commencer
    *       -> Bouton pour voir les règles
    * 2) Création du plateau de jeu : (détaillé dans la partie III. Ihm)
    *       -> Instantiation de la grille de jeu (aléatoirement)
    *       -> Instantiation des tas de cartes (aléatoirement)
    *       -> Création d'un espace par joueur
    * 3) On instantie le tas de carte pour chacun des joueurs
    * 4) On associe un carte aventurier à un joueur
    * 5) On fait des tours de jeu tant que le jeu n'est pas terminé (+ on leve une exception si le jeu se termine en milieu de tour de jeu, par exemple) ou qu'il n'y a pas de défaite
    * 6) Message pour afficher la défaite ou la victoire des joueurs
    * 
    * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    *                             Travail à faire :
    * 
    * ------------------------------- *
    * I. Modèle         - A COMPLETER *
    * ------------------------------- *
    *   Aventuriers     - A COMPLETER
    *       Navigateur
    *           1) Construire la méthode qui permet de déplacer un autre joueur d'une ou deux cases adjacentes pour une action
    *           -> A FAIRE DANS LE CODE DIRECTEMENT
    *   Cartes          - Normalement rien à faire
    *   ElementsJeu     - A COMPLETER
    *       Grille 
    *           1) Construire la méthode qui permet d'instancier aléatoirement une grille // OK
    *   Enumerations    - Normalement rien à faire
    *   Tas             - A COMPLETER
    *       POUR TOUS LES TAS 
    *           1) Construire la méthode qui permet d'instancier aléatoirement les tas      // OK
    *           2) Construire les méthodes pour mélanger ces tas (peut aider pour la méthode du dessus) // OK
    *              (Utile pour mélanger les défausses principalement)      
    * 
    * ------------------------------- *
    * II. Controleur    - A COMPLETER * 
    * ------------------------------- *
    *   Controle        - A COMPLETER
    *       Faire les traiterAction() pour :
    *       1) Utilisation d'une carte Tresor   
    *       2) Utilisation d'une carte Inondation
    *       3) Piocher une carte Tresor
    *       4) Piocher une carte Inondation
    *       5) Demande de donation d'une carte Tresor
    *       6) Don d'une carte Tresor
    *       7) Se défausser d'une carte 
    *       8) Recuperer un Tresor
    * 
    * ------------------------------- *
    * III. Ihm          - A COMPLETER *
    * ------------------------------- *
    *       (Partie importante car ça correspondra au rendu visuel du projet. Il faut essayer de faire un truc qui fonctionne, et pas trop moche.
    *       Le plus important est d'abord d'essayer de faire un truc qui fonctionne, et qui soit facilement modulable pour apporter quelques modifications esthétiques.
    *       Si c'est trop casse-tête, on se concentrera juste sur l'aspect fonctionnel des ihms)
    * 
    *   Demo
    *       1) Comprendre ce qu'il y a dedans, et voir comment ça peut nous aider dans les vues
    *   Image           - Normalement rien à faire (mais les regarder pour Demo)
    *   Vues            - A COMPLETER
    *       1) Créer une ihm pour le menu du jeu
    *           Elements principaux :
    *           -> Titre du jeu
    *           -> L'espace pour rentre 2 noms de joueurs
    *           -> Bouton pour rajouter un espace pour rajouter un nom de joueur
    *           -> Bouton à côté d'un joueur pour pouvoir le supprimer
    *           -> Bouton pour commencer la partie
    *           -> Bouton pour quitter le jeu
    *           -> Bouton pour afficher les règles du jeu
    *       2) Construire une ihm commune pour les grilles et les utilisateurs. (Ihms dans une ihm, par exemple)
    *           -> Grille de jeu
    *               -> Pour les tuiles, utiliser les images dans Image
    *               -> Pareil pour les emplacement des aventuriers, les représenter sur les tuiles avec les images fournies dans Image
    *               -> Pareil pour les emplacements de trésor sur les cartes
    *           -> Tas Inondation
    *               -> utiliser les images dans Image 
    *           -> Tas Tresors
    *               -> utiliser les images dans Image
    *           -> Defausse Inondation
    *               -> utiliser les images dans Image
    *           -> Defausse Tresor
    *               -> utiliser les images dans Image
    *           -> Un espace par joueur (Tous les espaces doivent être affichés à l'écran tout le temps ! 
    *              Mais on ne doit pouvoir intéragir qu'avec celui du joueur en cours (sauf pour le cas d'une utilisation d'une carte d'Action Speciale)
    *               -> Nom + Couleur + Carte Aventurier 
    *                  + Tas de Cartes du joueur (entre 0 et 5 cartes possibles)
    *                   -> utiliser les images dans Image pour les cartes retournées
    *           -> Un endroit dans lequel il est indiqué quels sont les trésors déjà récupérés ou non
    * 
    * ------------------------------- *
    * IV. Tests         - A COMPLETER *
    * ------------------------------- *
    *   Jeu_Tests       - A COMPLETER
    *       Chacun doit faire des tests pour sa propre partie
    *           -> On doit bien TOUT vérifier morceaux par morceaux, pour être sûr qu'il n'y a pas d'erreur
    *           -> Créer son propre test pour sa propre partie, du coup
    *               -> Donc, on a au moins : - TestIhmMenu
    *                                        - TestIhmPrincipal
    *                                        - TestControleur
    * ------------------------------- *
    * V. Rendu          - A COMPLETER *
    * ------------------------------- *
    *   IleInterdite  
    *       C'est l'endroit où on va coder le rendu final
    *       -> On le fera une fois qu'on aura fait tous les test sur le controleur ET les ihms
    * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    */ 
}
