package Controle;
// Nom des differentes actions possibles

public enum TypesActions {
    // ihm menu
    commencerPartie, // traité  - a tester - OK
    // ihm aventurier
    //      pion
    demandeDeplacement, // traité
    deplacement, // traité
    demandeAssechement, // traité
    assechement, // traité
    terminerTour, // traité
    recupererTresor, // PAS traité

    //      cartes
    demandeUtilisationCarte,// PAS traité    
    utiliserCarte, // PAS traité
    demandeDonCarte, // PAS traité
    donCarte, // PAS traité
    demandeDefausseCarte,
    defausserCarte, // PAS traité

    // automatique
    piocherTresor, // PAS traité
    piocherInondation, // PAS traité

    // toujours
    reglesJeu, // PAS traité
    fermerReglesJeu,
    
    //
    gagnerPartie,
    perdrePartie,
    
    //autre
    recommencer,
    revenirMenu,
    quitter
}
