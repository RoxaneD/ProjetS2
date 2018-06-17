package $_Organisation;

public class Planning {
   /**
    * // NE RIEN SUPPRIMER SUR CE DOCUMENT - RAJOUTEZ JUSTE DES INFORMATIONS (par exemple qui s'est occupé de quoi)
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
    * 
    * 
    * 
    *                             Travail à faire :
    * 
    * 
    * I. Modèle        - A COMPLETER
    *   Aventuriers     - A COMPLETER
    *       Navigateur
    *           1) Construire la méthode qui permet de déplacer un autre joueur d'une ou deux cases adjacentes pour une action
    *   Cartes          - Normalement rien à faire
    *   ElementsJeu     - A COMPLETER
    *       Grille 
    *           1) Construire la méthode qui permet d'instancier aléatoirement une grille
    *   Enumerations    - Normalement rien à faire
    *   Tas             - A COMPLETER
    *       POUR TOUS LES TAS 
    *           1) Construire la méthode qui permet d'instancier aléatoirement les tas
    *           2) Construire les méthodes pour mélanger ces tas (peut aider pour la méthode du dessus)
    *              (Utile pour mélanger les défausses principalement)      
    * 
    * 
    * II. Controleur    - A COMPLETER    
    *   Controle        - A COMPLETER
    *       Faire les traiterAction() pour :
    *       1) Utilisation d'une carte Tresor
    *       2) Utilisation d'une carte Inondation
    *       3) Piocher une carte Tresor
    *       4) Piocher une carte Inondation
    *       5) Donner une carte Tresor
    *       6) Se défausser d'une carte 
    *       7) Recuperer un Tresor
    * 
    * 
    * III. Ihm           - A COMPLETER
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
    *           -> Un espace par joueur
    *               -> Nom + Couleur + Carte Aventurier 
    *                  + Tas de Cartes du joueur (entre 0 et 5 cartes possibles)
    *                   -> utiliser les images dans Image pour les cartes retournées
    * 
    * 
    * IV. Tests         - A COMPLETER
    *   Jeu_Tests       - A COMPLETER
    *       Chacun doit faire des tests pour sa propre partie
    *           -> On doit bien TOUT vérifier morceaux par morceaux, pour être sûr qu'il n'y a pas d'erreur
    *           -> Créer son propre test pour sa propre partie, du coup
    * 
    * 
    * 
    */ 
}
