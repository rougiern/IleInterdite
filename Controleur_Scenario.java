/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterditeproj;

import LesJoueurs.Messager;
import LesJoueurs.Plongeur;
import LesJoueurs.Pilote;
import LesJoueurs.Navigateur;
import LesJoueurs.Explorateur;
import LesJoueurs.Ingenieur;
import LesJoueurs.Aventurier;
import LesJoueurs.Aventurier;
import LesJoueurs.Explorateur;
import LesJoueurs.Ingenieur;
import LesJoueurs.Messager;
import LesJoueurs.Navigateur;
import LesJoueurs.Pilote;
import LesJoueurs.Plongeur;
import Vues.VueAcceuil;
import Vues.VueAventurier;
import Vues.VueCarteSpeciale;
import Vues.VueDefausse;
import Vues.VueDonCarte;
import Vues.VueInscription;
import Vues.VueNiveau;
import Vues.VuePlateau;
import ileinterditeproj.EtatTuile;
import ileinterditeproj.Grille;
import ileinterditeproj.Message;
import ileinterditeproj.Tuile;
import ileinterditeproj.Utils.Commandes;
import java.awt.Desktop;
import static java.lang.Math.random;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author duttod
 */
public class Controleur implements Observer {

    private Grille grille;
    private ArrayList<Aventurier> joueurs;
    private ArrayList<Tuile> tuilesdepart;
    private ArrayList<CarteInondation> piocheInondation;
    private ArrayList<CarteInondation> defausseInondation;
    private ArrayList<CarteTirage> piocheTirage;
    private ArrayList<CarteTirage> defausseTirage;
    private VueInscription vueinsc;
    private VueAcceuil vueaccueil;
    private VuePlateau vplateau;
    private VueDonCarte vdon;
    private int compteurtour = 0;
    private ArrayList<Tuile> tuilesatteignables;
    private Aventurier joueurcourant, joueurutilisateurcarte;
    private ArrayList<Tuile> tuilesassechables;
    private ArrayList<Utils.Tresor> tresorsrecupérés;
    private VueDefausse vdefausse;
    private VueCarteSpeciale vueutilisercartes;
    private boolean noyadeEnCours = false;

    Controleur() {

        joueurcourant = null;
        tuilesatteignables = null;
        tuilesassechables = null;

        //Création de la Grille
        grille = new Grille();
        ArrayList<Tuile> lestuiles = new ArrayList(24);

        //Création des tuiles
        Tuile t1 = new Tuile("LePontDesAbimes");
        Tuile t2 = new Tuile("LaPorteDeBronze");  // Pion.ROUGE
        Tuile t3 = new Tuile("LaCarverneDesOmbres", Utils.Tresor.CRISTAL);
        Tuile t4 = new Tuile("LaPorteDeFer");    //Pion.VIOLET
        Tuile t5 = new Tuile("LaPortedOr");   //Pion.JAUNE
        Tuile t6 = new Tuile("LesFalaisesDeLOubli");
        Tuile t7 = new Tuile("LePalaisDeCorail", Utils.Tresor.CALICE);
        Tuile t8 = new Tuile("LaPortedArgent");  //Pion.ORANGE
        Tuile t9 = new Tuile("LesDunesDeLIllusion");
        Tuile t10 = new Tuile("Heliport");      //Pion.BLEU 
        Tuile t11 = new Tuile("LaPorteDeCuivre");  // Pion.VERT
        Tuile t12 = new Tuile("LeJardinDesHurlements", Utils.Tresor.ZEPHYR);
        Tuile t13 = new Tuile("LaForetPourpre");
        Tuile t14 = new Tuile("LeLagonPerdu");
        Tuile t15 = new Tuile("LeMaraisBrumeux");
        Tuile t16 = new Tuile("Observatoire");
        Tuile t17 = new Tuile("LeRocherFantome");
        Tuile t18 = new Tuile("LaCarverneDuBrasier", Utils.Tresor.CRISTAL);
        Tuile t19 = new Tuile("LeTempleDuSoleil", Utils.Tresor.PIERRE);
        Tuile t20 = new Tuile("LeTempleDeLaLune", Utils.Tresor.PIERRE);
        Tuile t21 = new Tuile("LePalaisDesMarees", Utils.Tresor.CALICE);
        Tuile t22 = new Tuile("LeValDuCrepuscule");
        Tuile t23 = new Tuile("LaTourDuGuet");
        Tuile t24 = new Tuile("LeJardinDesMurmures", Utils.Tresor.ZEPHYR);

        //Affectation des tuiles de départ
        tuilesdepart = new ArrayList(6);

        tuilesdepart.add(t2);
        tuilesdepart.add(t4);
        tuilesdepart.add(t5);
        tuilesdepart.add(t8);
        tuilesdepart.add(t10);
        tuilesdepart.add(t11);

        //Ajout des tuiles dans la liste des tuiles
        lestuiles.add(t1);
        lestuiles.add(t2);
        lestuiles.add(t3);
        lestuiles.add(t4);
        lestuiles.add(t5);
        lestuiles.add(t6);
        lestuiles.add(t7);
        lestuiles.add(t8);
        lestuiles.add(t9);
        lestuiles.add(t10);
        lestuiles.add(t11);
        lestuiles.add(t12);
        lestuiles.add(t13);
        lestuiles.add(t14);
        lestuiles.add(t15);
        lestuiles.add(t16);
        lestuiles.add(t17);
        lestuiles.add(t18);
        lestuiles.add(t19);
        lestuiles.add(t20);
        lestuiles.add(t21);
        lestuiles.add(t22);
        lestuiles.add(t23);
        lestuiles.add(t24);

        // Création des collections pioche/défausse Inondation
        piocheInondation = new ArrayList(24);
        defausseInondation = new ArrayList(24);
        piocheTirage = new ArrayList();
        defausseTirage = new ArrayList();
        tresorsrecupérés = new ArrayList(4);

        //Initialisation de la grille
        //Collections.shuffle(lestuiles);
        grille.setTableau(lestuiles);

        //Lancement du jeu      
        joueurs = new ArrayList();

        vueaccueil = new VueAcceuil();
        vueaccueil.addObserver(this);
        vueaccueil.afficher();

        //Création du plateau
        this.vplateau = new VuePlateau(this.grille, joueurs, tresorsrecupérés);
        vplateau.addObserver(this);

        //Création de la liste des cartes inondations, en fonction des tuiles inondées
        setpiocheInondation(lestuiles);

        //Création de la liste des cartes tirages
        setPiocheTirage();

    }

    @Override
    public void update(Observable arg0, Object arg1) {

        if (arg1 instanceof MessageIni) {
            MessageIni message = (MessageIni) arg1;
            if (message.getAction() == Action.COMMENCER_PARTIE) {

               // vueinsc = new VueInscription();
               // vueinsc.addObserver(this);
               // vueinsc.afficher();
                vueaccueil.close();
                
                Ingenieur ing = new Ingenieur("ing", tuilesdepart.get(0));
                tuilesdepart.get(0).addAventurierTuile(ing);
                joueurs.add(ing);
                
                Navigateur n = new Navigateur("nav", tuilesdepart.get(2));
                tuilesdepart.get(2).addAventurierTuile(n);
                joueurs.add(n);
                
                Messager m = new Messager("mess", tuilesdepart.get(3));
                tuilesdepart.get(3).addAventurierTuile(m);
                joueurs.add(m);
                
                Pilote pilote = new Pilote("pil", tuilesdepart.get(4));
                tuilesdepart.get(4).addAventurierTuile(pilote);
                joueurs.add(pilote);

                //SCENARIO OBTENTION TRESORS
                
                for (CarteTirage t : piocheTirage) {
                    if (t instanceof CarteTresor) {
                        System.out.println(((CarteTresor) t).getTypeTresor().name());
                    }
                }
                
     
                
                joueurs.get(0).getMains().add(piocheTirage.get(1));
                joueurs.get(0).getMains().add(piocheTirage.get(2));
                
                joueurs.get(1).getMains().add(piocheTirage.get(5));
                joueurs.get(1).getMains().add(piocheTirage.get(6));
                
                joueurs.get(2).getMains().add(piocheTirage.get(10));
                joueurs.get(2).getMains().add(piocheTirage.get(11));
                
                joueurs.get(3).getMains().add(piocheTirage.get(15));
                joueurs.get(3).getMains().add(piocheTirage.get(16));
                
                
                piocheTirage.remove(0);
                piocheTirage.remove(0);
                piocheTirage.remove(2);

                piocheTirage.remove(3);
                piocheTirage.remove(3);
                piocheTirage.remove(5);
                
                piocheTirage.remove(5);
                piocheTirage.remove(5);
                piocheTirage.remove(4);
                
                piocheTirage.remove(9);
                piocheTirage.remove(9);
                piocheTirage.remove(11);
                
                joueurcourant = joueurs.get(0);
                
                vplateau.raffraichir(grille, joueurs, tresorsrecupérés);
                vplateau.afficher();

                vplateau.getVueniveau().setNiveau(10);   // pour que tirercarteInondation tire 1 carta a chaque fois
                for (int i = 0; i < 6; i++) {
                    tirerCarteInondation();
                }
                setDifficulte("novice");  //Initialise la difficulte donc la vue niveau 

                vplateau.raffraichir(grille, joueurs, tresorsrecupérés);
                this.grisebouton(joueurcourant.getPtsaction());
                afficherJoueurs();


            } else if (message.getAction() == Action.OUVRIR_PAGEWEB) {
                openWebpage(message.getLien());
            } else if (message.getAction() == Action.NB_JOUEURS) {
                vueinsc.formulaire(message.getNbj());
            } else if (message.getAction() == Action.INSCRIRE_JOUEURS) {
                AttribuerRole(message.getNoms());
                vueinsc.close();

                //Distribution des cartes
                //DistributionDébut();
              
            }
        } else if (arg1 instanceof Message) {

            if (noyadeEnCours) {
                Message message = (Message) arg1;
                // On doit recevoir le déplacement d'un joueur en cours de noyade
                // => le déplacer puis vérifier s'il reste des joueurs en cours de
                // noyade
                // Déplacer le joueurCourant qui était en de se noyer
                joueurcourant = gererNoyade();
                griseAllbouton();
                if ((arg0 instanceof VuePlateau) && message.getAction() == Commandes.DEPLACEMENT_NOYADE) {
                    int x = 0;
                    while (x < tuilesatteignables.size() && !(tuilesatteignables.get(x).getNom().equals(message.getTuile().getNom()))) {
                        x++;
                    }

                    if (x != tuilesatteignables.size()) {
                        System.out.println(tuilesatteignables.get(x).getNom());
                        joueurcourant.getTuileCourante().retirerAventurierTuile(joueurcourant);
                        tuilesatteignables.get(x).addAventurierTuile(joueurcourant);
                        joueurcourant.setTuileCourante(tuilesatteignables.get(x));
                        System.out.println("Action effectuée : Nouvelle tuile :" + joueurcourant.getTuileCourante().getNom());

                    } else {
                        System.out.println("la case n'est pas valide");
                    }
                }
                gererNoyade();
                joueurcourant = gererNoyadeMessage();
                vplateau.raffraichir(this.grille, joueurs, tresorsrecupérés);
                griseAllbouton();

                if (gererNoyade() == null) {
                    noyadeEnCours = false;
                    joueurcourant = joueurs.get(compteurtour);
                    vplateau.griserAction(joueurs);
                    grisebouton(joueurcourant.getPtsaction());
                    defausse(joueurcourant);
                }
            }
            if (!noyadeEnCours) {

                vplateau.griserAction(joueurs);   //On rafraichit le plateau pour dégriser les boutons aprés une éventuelle noyade
                this.grisebouton(joueurcourant.getPtsaction());
                Message message = (Message) arg1;
                //Gestion de la demande de bouger quand un joueur clique sur le bouton BOUGER
                if ((arg0 instanceof VuePlateau) && message.getAction() == Commandes.DEMANDE_BOUGER) {
                    gererDemandeBouger();

                    // GESTION DE LA RECUPERATION D UN DEPLACEMENT APRES CLICK SUR UNE TUILE
                } else if ((arg0 instanceof VuePlateau) && (message.getAction() == Commandes.BOUGER || message.getAction() == Commandes.BOUGER_AVEC_HELICO || message.getAction() == Commandes.DEPLACER)) {

                    int x = 0;

                    while (x < tuilesatteignables.size() && !(tuilesatteignables.get(x).getNom().equals(message.getTuile().getNom()))) {
                        x++;
                    }

                    if (x != tuilesatteignables.size()) {

                        joueurcourant.getTuileCourante().retirerAventurierTuile(joueurcourant);
                        tuilesatteignables.get(x).addAventurierTuile(joueurcourant);
                        joueurcourant.setTuileCourante(tuilesatteignables.get(x));
                        joueurcourant.enleveUneAction();

                        if (message.getAction() == Commandes.BOUGER_AVEC_HELICO || message.getAction() == Commandes.DEPLACER) {
                            joueurcourant.setPtsaction(joueurcourant.getPtsaction() + 1);
                            joueurcourant = this.getJoueurs().get(compteurtour);
                            if (message.getAction() == Commandes.DEPLACER) {
                                joueurcourant.enleveUneAction();
                            }
                            if (message.getAction() == Commandes.BOUGER_AVEC_HELICO) {
                                gererUtilisationCarteActionMainPleine();
                            }

                        }
                    } else {
                        Utils.afficherInformation("La case n'est pas accessible");
                        if (message.getAction() == Commandes.BOUGER_AVEC_HELICO || message.getAction() == Commandes.DEPLACER) {
                            joueurcourant.setPtsaction(joueurcourant.getPtsaction() + 1);

                            joueurcourant = this.getJoueurs().get(compteurtour);
                        }
                    }
                    vplateau.setDerniereaction(null);
                    vplateau.raffraichir(this.grille, joueurs, tresorsrecupérés);
                    grisebouton(joueurcourant.getPtsaction());

                    // GESTION DE LA RECUPERATION D UN TRESOR
                } else if ((arg0 instanceof VuePlateau) && message.getAction() == Commandes.RECUPERER_TRESOR) {

                    // On regarde si il a 4 cartes tirage du même trésor que le trésor de la tuile sur la quelle il est
                    int nbok = nbMemeCarteTresor();

                    // Si c'est le cas, on retire ces cartes de sa main
                    if (nbok >= 4) {
                        retirerLes4Cartes();

                        // On ajoute à la liste des trésors récupérés le trésor concerné, et on enlève de la tuile le trésor
                        tresorsrecupérés.add(joueurcourant.getTuileCourante().getTresor());
                        joueurcourant.enleveUneAction();
                        vplateau.raffraichir(grille, joueurs, tresorsrecupérés);
                        grisebouton(joueurcourant.getPtsaction());
                        // On enléve le trésor de la deuxiéme tuile ou il est instancié
                        retirerLe2iemTresor();

                        Utils.afficherInformation("Trésor récupéré:" + joueurcourant.getTuileCourante().getTresor().name());
                        joueurcourant.getTuileCourante().setTresor(null);
                        vplateau.raffraichir(this.grille, joueurs, tresorsrecupérés);
                        grisebouton(joueurcourant.getPtsaction());

                    } else {
                        Utils.afficherInformation("nb carte trésor inferieur a 4"); //trace

                    }
                    vplateau.setDerniereaction(null);
                    //GESTION DE LA DEMANDE D ASSECHEMENT QUAND ON CLIQUE SUR ASSECHER
                } else if ((arg0 instanceof VuePlateau) && message.getAction() == Commandes.DEMANDE_ASSECHER) {

                    gererDemandeAssechement();
//                    

                } else if (message.getAction() == Commandes.ASSECHER || message.getAction() == Commandes.ASSECHER_SAC_SABLE) {

                    int i = 0;
                    while (i < tuilesassechables.size() && !(tuilesassechables.get(i).getNom().equals(message.getTuile().getNom()))) {
                        i++;
                    }

                    if (i < tuilesassechables.size()) {

                        vplateau.setDerniereaction(Commandes.ASSECHER);
                        if (message.getAction() == Commandes.ASSECHER_SAC_SABLE) {
                            joueurcourant.setPtsaction(joueurcourant.getPtsaction() + 1);
                            joueurcourant.assechertuile(tuilesassechables.get(i));
                            int nbcartesenlevees = 0;
                            for (int numindice = joueurcourant.getMains().size() - 1; numindice >= 0; numindice--) {
                                if ((joueurcourant.getMains().get(numindice) instanceof CarteSacDeSable) && nbcartesenlevees == 0) {
                                    defausseTirage.add(joueurcourant.getMains().get(numindice));
                                    joueurcourant.retirerCarte(numindice);
                                    vplateau.raffraichir(this.grille, joueurs, tresorsrecupérés);
                                    nbcartesenlevees++;
                                    joueurcourant = joueurs.get(compteurtour);
                                    gererUtilisationCarteActionMainPleine();

                                }
                            }
                        } else {
                            joueurcourant.assechertuile(tuilesassechables.get(i));
                        }

                        vplateau.raffraichir(this.grille, joueurs, tresorsrecupérés);
                        grisebouton(joueurcourant.getPtsaction());
                        vplateau.setDerniereaction(null);
                        if (joueurcourant instanceof Ingenieur && ((Ingenieur) joueurcourant).getNbAsseche() == 1 && !(message.getAction() == Commandes.ASSECHER_SAC_SABLE)) {
                            deuxiemeAssechementInge();

                        }
                    } else {
                        Utils.afficherInformation("La case n'est pas accessible");
                    }
                    //DEMANDE DE DEPLACER UN JOUEUR PAR LE NAVIGATEUR
                } else if ((arg0 instanceof VuePlateau) && (message.getAction() == Commandes.DEMANDE_DEPLACER)) {

                    int nbActions = joueurcourant.getPtsaction();
                    Grille g = this.getGrille();

                    if (joueurcourant instanceof Navigateur && nbActions > 0) {

                        vueutilisercartes = new VueCarteSpeciale(joueurcourant);
                        vueutilisercartes.actualiserPourDeplacerNav(joueurs, joueurcourant);
                        vueutilisercartes.addObserver(this);

                    }
                    //RECHERCHE DU JOUEUR CHOISIS A DEPLACER SUR LA VUE CARTE SPECIAL(ICI VUE CHOIX JOUEUR A DEPLACER)
                } else if ((arg0 instanceof VueCarteSpeciale) && message.getAction() == Commandes.DEMANDE_DEPLACER) {
                    Aventurier av = chercherAventurier(message.getNomJ());
                    vueutilisercartes.close();
                    if (av != null) {
                        tuilesatteignables = av.deplacementParNavigateur(grille);
                        vplateau.setDerniereaction(Commandes.DEPLACER);
                        joueurcourant = av;

                    }
                } else if (message.getAction() == Commandes.DEFAUSSE) {

                    System.out.println("suppr carte");
                    defausseTirage.add(joueurcourant.getMains().get(message.getNbcarte()));
                    joueurcourant.retirerCarte(message.getNbcarte());
                    vplateau.raffraichir(this.grille, joueurs, tresorsrecupérés);
                    grisebouton(joueurcourant.getPtsaction());

                    if (joueurcourant.getMains().size() > 5) {
                        vdefausse.close();
                        defausse(joueurcourant);
                        System.out.println("rafraichissement");
                        vplateau.raffraichir(this.grille, joueurs, tresorsrecupérés);
                        grisebouton(joueurcourant.getPtsaction());

                    } else {
                        vdefausse.close();
                        System.out.println("cacher");
                        joueurcourant = joueurs.get(compteurtour);
                        vplateau.raffraichir(this.grille, joueurs, tresorsrecupérés);
                        grisebouton(joueurcourant.getPtsaction());
                    }

                } else if (message.getAction() == Utils.Commandes.CHOISIR_CARTE) {

                    joueurcourant = chercherAventurier(message.getNomJ());
                    joueurutilisateurcarte = chercherAventurier(message.getNomJ());
                    vueutilisercartes = new VueCarteSpeciale(joueurcourant);
                    vueutilisercartes.addObserver(this);
                    vueutilisercartes.afficher();

                } else if (message.getAction() == Utils.Commandes.UTILISER_CARTE_HELICO) {

                    vueutilisercartes.actualiserPourDeplacer(joueurs);
                    griseAllbouton();

                } else if (message.getAction() == Utils.Commandes.BOUGER_AVEC_HELICO) {

                    vueutilisercartes.close();

                    tuilesatteignables = grille.getTuilesNonCoulees();
                    for (Aventurier a : joueurs) {
                        if (a.getNom().equals(message.getNomJ())) {
                            joueurcourant = a;
                        }
                    }

                    vplateau.setDerniereaction(Commandes.BOUGER_AVEC_HELICO);

                    int nbcartesenlevees = 0;
                    for (int numindice = joueurutilisateurcarte.getMains().size() - 1; numindice >= 0; numindice--) {
                        if ((joueurutilisateurcarte.getMains().get(numindice) instanceof CarteHelicoptere) && nbcartesenlevees == 0) {
                            defausseTirage.add(joueurutilisateurcarte.getMains().get(numindice));
                            joueurutilisateurcarte.retirerCarte(numindice);
                            vplateau.raffraichir(this.grille, joueurs, tresorsrecupérés);
                            nbcartesenlevees++;
                        }
                    }
                    //UTILISATION D UNE CARTE SAC DE SABLE
                } else if (message.getAction() == Utils.Commandes.UTILISER_CARTE_SACSABLE) {

                    tuilesassechables = grille.getTuilesInondees();
                    vplateau.setDerniereaction(Commandes.ASSECHER_SAC_SABLE);
                    griseAllbouton();

                    vueutilisercartes.close();
                    // DON D UNE CARTE TRESOR 
                } else if ((arg0 instanceof VuePlateau) && (message.getAction() == Commandes.DONNER)) {

                    if (pasSeulSurCase(joueurcourant) || (joueurcourant instanceof Messager)) {
                        if ((joueurcourant.pasDeTresor())) {
                            vdon = new VueDonCarte(joueurcourant.getMains(), joueurs, joueurcourant);
                            vdon.afficher();
                            vdon.addObserver(this);
                        } else {
                            Utils.afficherInformation("Le Joueur n'a pas de carte Trésor à donner ");
                        }
                    } else {
                        Utils.afficherInformation("Le Joueur est seul sur sa case il ne peut rien donner ");
                    }

                } else if ((arg0 instanceof VueDonCarte) && (message.getAction() == Commandes.DONNER) && joueurcourant instanceof Messager) {

                    int i = 0;
                    while ((i < joueurs.size()) && (!(joueurs.get(i).getNom().equals(message.getNomJ())))) {
                        i++;
                    }
                    Utils.afficherInformation("La carte :" + joueurcourant.getMains().get(message.getNbcarte()).toString() + " donner a " + message.getNomJ());
                    Aventurier receveur = joueurs.get(i);

                    if (receveur.getMains().size() <= 5) {
                        gererReceptionMessager(receveur, message);

                        grisebouton(joueurcourant.getPtsaction());
                        vdon.close();
                    } else {
                        gererReceptionMessager(receveur, message);

                        griseAllbouton();
                        vdon.close();
                        defausse(receveur);
                    }

                } else if ((arg0 instanceof VueDonCarte) && (message.getAction() == Commandes.DONNER)) {
                    int i = 0;
                    while ((i < joueurs.size()) && (!(joueurs.get(i).getNom().equals(message.getNomJ())))) {
                        i++;
                    }

                    if (joueurcourant.getTuileCourante().getNom().equals(joueurs.get(i).getTuileCourante().getNom())) {
                        Utils.afficherInformation("La carte :" + joueurcourant.getMains().get(message.getNbcarte()).toString() + " donner a " + message.getNomJ());
                        Aventurier receveur = joueurs.get(i);
                        if (receveur.getMains().size() <= 5) {
                            receveur.getMains().add(joueurcourant.getMains().get(message.getNbcarte())); // A FACTORISER
                            joueurcourant.enleveUneAction();
                            joueurcourant.getMains().remove(message.getNbcarte());
                            vplateau.raffraichir(this.grille, joueurs, tresorsrecupérés);
                            grisebouton(joueurcourant.getPtsaction());
                            vdon.close();
                        } else {
                            receveur.getMains().add(joueurcourant.getMains().get(message.getNbcarte()));// A FACTORISER
                            joueurcourant.enleveUneAction();
                            joueurcourant.getMains().remove(message.getNbcarte());
                            vplateau.raffraichir(this.grille, joueurs, tresorsrecupérés);
                            griseAllbouton();
                            vdon.close();
                            defausse(receveur);
                        }
                    }
                } else if ((arg0 instanceof VueDonCarte) && (message.getAction() == Commandes.FERMER_DONCARTE)) {
                    vdon.close();
                    //GESTION DE FIN DE TOUR
                } else if (message.getAction() == Commandes.TERMINER) {
                    victoire();
                    defaite();

                    tirerCarteInondation();
                    gererNoyade();
                    tirerCartetirage(joueurcourant);
                    compteurtour++;
                    if (compteurtour < joueurs.size()) {
                        joueurcourant = this.getJoueurs().get(compteurtour);
                        //                    défausse carte
                        vplateau.raffraichir(this.grille, joueurs, tresorsrecupérés);
                        if (!noyadeEnCours) {
                            defausse(joueurcourant);
                            grisebouton(joueurcourant.getPtsaction());
                        } else {
                            griseAllbouton();
                        }

                    } else {
                        System.out.println("Le tour est terminé");
                        compteurtour = 0;
                        for (Aventurier j : joueurs) {
                            j.setPtsaction(3);
                            if (j instanceof Pilote) {
                                ((Pilote) j).setNbvol(1);
                            }
                        }
                        joueurcourant = this.getJoueurs().get(compteurtour);
                        //défausse carte
                        vplateau.raffraichir(this.grille, joueurs, tresorsrecupérés);
                        if (!noyadeEnCours) {
                            defausse(joueurcourant);
                            grisebouton(joueurcourant.getPtsaction());
                        } else {
                            griseAllbouton();
                        }
                    }
                    vplateau.setDerniereaction(null);
                    if (noyadeEnCours) {
                        joueurcourant = gererNoyade();
                    }
                }
            }
        }

    }

    public void setDifficulte(String dif) {
        //"novice", "normal", "élite","légendaire"
        if (dif.equals("novice")) {
            vplateau.getVueniveau().setNiveau(1);
        } else if (dif.equals("normal")) {
            vplateau.getVueniveau().setNiveau(2);
        } else if (dif.equals("élite")) {
            vplateau.getVueniveau().setNiveau(3);
        } else if (dif.equals("légendaire")) {
            vplateau.getVueniveau().setNiveau(4);
        } else {
            System.out.println("Erreur difficulté");
        }

    }

    private boolean pasSeulSurCase(Aventurier a) {

        return a.getTuileCourante().getAventuriers().size() > 1;

    }

    public boolean tousTresorsObtenus() {

        return tresorsrecupérés.size() == 4;
    }

    public boolean tousSurHeliport() {
        boolean bool = true;
        for (Aventurier a : joueurs) {
            if (!(a.getTuileCourante().getNom().equals("Heliport"))) {
                bool = false;
            }
        }
        return bool;
    }

    public boolean unJoueurPossedeHelico() {
        boolean bool = false;
        for (Aventurier a : joueurs) {
            if (a.possedeHelico()) {
                bool = true;
            }
        }
        return bool;
    }

    public void victoire() {

        if (tousTresorsObtenus() && tousSurHeliport() && unJoueurPossedeHelico()) {
            Utils.afficherInformation("VOUS AVEZ GAGNEZ !!!");
            vplateau.close();

        }

    }

    public boolean TresorsCoulee() {
        ArrayList<String> nomstresors = new ArrayList<>();
        boolean condition = false;
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                if (grille.getTableau()[x][y].getTresor() != null) {
                    if (grille.getTableau()[x][y].getEtat() == Utils.EtatTuile.COULEE) {
                        if (nomstresors.contains(grille.getTableau()[x][y].getTresor().name())) {
                            condition = true;
                            System.out.println("Tresor coulee");
                        } else {
                            nomstresors.add(grille.getTableau()[x][y].getTresor().name());
                        }
                    }
                }
            }
        }

        return condition;
    }

    public boolean heliportCoulee() {
        boolean cond = false;
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                if (grille.getTableau()[x][y].getNom().equals("Heliport") && grille.getTableau()[x][y].getEtat() == Utils.EtatTuile.COULEE) {
                    cond = true;
                    System.out.println("Heliport coulee");
                }
            }
        }
        return cond;

    }

    public boolean hommeAlaMer() {
        boolean cond = false;
        for (Aventurier a : joueurs) {
            if (a.getTuileCourante().getEtat() == Utils.EtatTuile.COULEE) {
                ArrayList<Tuile> tuilesA = new ArrayList();
                if (a instanceof Pilote) {
                    tuilesA = ((Pilote) a).seDeplacerVol(grille);
                } else {
                    tuilesA = a.seDeplacer(grille);
                }
                if (tuilesA.isEmpty()) {
                    cond = true;
                    System.out.println("HommeAlaMer ");
                    System.out.println(a.getClass().getSimpleName());
                }
            }
        }
        return cond;

    }

    public Aventurier gererNoyade() {
        for (Aventurier a : joueurs) {
            if (a.getTuileCourante().getEtat() == Utils.EtatTuile.COULEE) {
                ArrayList<Tuile> tuilesA = new ArrayList();
                if (a instanceof Pilote) {
                    ((Pilote) a).setNbvol(1);
                    tuilesA = ((Pilote) a).seDeplacerVol(grille);
                    ((Pilote) a).setNbvol(0);
                } else {
                    tuilesA = a.seDeplacer(grille);
                }
                if (!(tuilesA.isEmpty())) {
                    if (!(noyadeEnCours)) {
                        Utils.afficherInformation(a.getNom() + " doit se déplacer pour ne pas se noyer !");
                    }
                    tuilesatteignables = tuilesA;
                    vplateau.setDerniereaction(Commandes.DEPLACEMENT_NOYADE);
                    noyadeEnCours = true;
                    return a;

                }
            }
        }
        return null;
    }

    public Aventurier gererNoyadeMessage() {
        for (Aventurier a : joueurs) {
            if (a.getTuileCourante().getEtat() == Utils.EtatTuile.COULEE) {
                ArrayList<Tuile> tuilesA = new ArrayList();
                if (a instanceof Pilote) {
                    ((Pilote) a).setNbvol(1);
                    tuilesA = ((Pilote) a).seDeplacerVol(grille);
                    ((Pilote) a).setNbvol(0);
                } else {
                    tuilesA = a.seDeplacer(grille);
                }
                if (!(tuilesA.isEmpty())) {
                    if (noyadeEnCours) {
                        Utils.afficherInformation(a.getNom() + " doit se déplacer pour ne pas se noyer !");
                    }
                    tuilesatteignables = tuilesA;
                    vplateau.setDerniereaction(Commandes.DEPLACEMENT_NOYADE);
                    noyadeEnCours = true;
                    return a;
                }
            }
        }
        return null;
    }

    public boolean nivEau10() {
        if (vplateau.getVueniveau().getNiveau() >= 10) {
            Utils.afficherInformation(" NIVEAU D EAU >= 10 ");
        }
        return vplateau.getVueniveau().getNiveau() >= 10;
    }

    public void defaite() {

        if (TresorsCoulee() || hommeAlaMer() || heliportCoulee() || nivEau10()) {
            Utils.afficherInformation("VOUS AVEZ PERDU !!!");
            vplateau.close();
        }
    }

    public void deuxiemeAssechementInge() {
        int sauvegardepts = joueurcourant.getPtsaction();
        joueurcourant.setPtsaction(1);
        tuilesassechables = joueurcourant.assecher(grille);
        joueurcourant.setPtsaction(sauvegardepts);
        if (joueurcourant.getTuileCourante().getEtat() == Utils.EtatTuile.INONDEE) {
            tuilesassechables.add(joueurcourant.getTuileCourante());
        }
        if (!(tuilesassechables.isEmpty())) {
            if (Utils.poserQuestion("Voulez-vous assécher une autre case ?")) {

                affichernomtuiles(tuilesassechables);
                System.out.println("2iem affi inge");

                vplateau.delimiterTuilesAtteignables(tuilesassechables, joueurcourant);
                System.out.println("Quelle case assécher ING ?");
                joueurcourant.setPtsaction(joueurcourant.getPtsaction() + 1);
                ((Ingenieur) joueurcourant).setNbAsseche(0);
                System.out.println("PA" + joueurcourant.getPtsaction());
                vplateau.setDerniereaction(Commandes.ASSECHER);

            }
        }

    }

    public void addAventurier(Aventurier aventurier) {

        if (this.getJoueurs().size() < 4) {
            this.getJoueurs().add(aventurier);
        }
    }

    public Grille getGrille() {
        return grille;
    }

    public ArrayList<Aventurier> getJoueurs() {
        return joueurs;
    }

    public void afficherJoueurs() {

        for (Aventurier j : joueurs) {
            System.out.println("Nom :" + j.getNom() + " Role:" + j.getClass().getSimpleName());
        }

    }

    public Tuile chercherTuile(String nomtuile, ArrayList<Tuile> tuilesatteignable) {
        int i = 0;
        Tuile tvoulu = null;

        while (i < tuilesatteignable.size() && tuilesatteignable.get(i).getNom().equals(nomtuile) == false) {
            i++;
        }
        if (i < tuilesatteignable.size() && tuilesatteignable.get(i).getNom().equals(nomtuile)) {
            tvoulu = tuilesatteignable.get(i);
        }

        return tvoulu;

    }

    public Aventurier chercherAventurier(String nomjoueurcherche) {
        int i = 0;
        Aventurier jvoulu = null;

        while (i < joueurs.size() && joueurs.get(i).getNom().equals(nomjoueurcherche) == false) {
            i++;

        }
        if (i < joueurs.size() && joueurs.get(i).getNom().equals(nomjoueurcherche)) {
            jvoulu = joueurs.get(i);

        }
        return jvoulu;

    }

    private void affichernomtuiles(ArrayList<Tuile> listetuiles) {
        for (Tuile t : listetuiles) {
            System.out.println(t.getNom());
        }
    }

    public VueAventurier getVueAv() {
        int i = 0;
        while (i < joueurs.size() && joueurs.get(i).getNom().equals(joueurcourant.getNom()) == false) {
            i++;
        }
        if (i == 0) {
            return vplateau.getVuej1();
        } else if (i == 1) {
            return vplateau.getVuej2();
        } else if (i == 2) {
            return vplateau.getVuej3();
        } else {
            return vplateau.getVuej4();
        }

    }

    public void grisebouton(int nbaction) {

        getVueAv().degriserActions();

        if (nbaction == 0) {

            getVueAv().getBtnAssecher().setEnabled(false);

            getVueAv().getBtnBouger().setEnabled(false);

            getVueAv().getBtnAutreAction().setEnabled(false);

            getVueAv().getBtnRecupererTresor().setEnabled(false);

            if (getVueAv().getBtnDeplacerJoueur() != null) {
                getVueAv().getBtnDeplacerJoueur().setEnabled(false);
            }

        }

    }

    public void griseAllbouton() {

        vplateau.getVuej1().griserActions();
        vplateau.getVuej2().griserActions();
        if (vplateau.getVuej3() != null) {
            vplateau.getVuej3().griserActions();
        }
        if (vplateau.getVuej4() != null) {
            vplateau.getVuej4().griserActions();
        }
    }

    public void setpiocheInondation(ArrayList<Tuile> listeT) {
        CarteInondation carte;
        for (Tuile t : listeT) {
            carte = new CarteInondation(t);
            getPiocheInondation().add(carte);
        }
        //Collections.shuffle(piocheInondation);
    }

    public void setPiocheTirage() {

        //Création des cartes trésor
        for (int i = 1; i <= 20; i++) {
            if (i <= 5) {
                this.getPiocheTirage().add(new CarteTresor(Utils.Tresor.CALICE));

            } else if (i > 5 && i <= 10) {
                this.getPiocheTirage().add(new CarteTresor(Utils.Tresor.CRISTAL));

            } else if (i > 10 && i <= 15) {
                this.getPiocheTirage().add(new CarteTresor(Utils.Tresor.PIERRE));

            } else {
                this.getPiocheTirage().add(new CarteTresor(Utils.Tresor.ZEPHYR));
            }
        }
        //Création des cartes hélicos
        for (int j = 1; j <= 3; j++) {
            this.getPiocheTirage().add(new CarteHelicoptere());

        }

        for (int k = 1; k <= 2; k++) {
            this.getPiocheTirage().add(new CarteSacDeSable());

        }

        for (int l = 1; l <= 2; l++) {
            this.getPiocheTirage().add(new CarteMonteedesEaux());
        }

        //Collections.shuffle(piocheTirage); ENLEVE POUR SCENARIO
    }

    public ArrayList<CarteInondation> getPiocheInondation() {
        return piocheInondation;

    }

    public ArrayList<CarteInondation> getDefausseInondation() {
        return defausseInondation;

    }

    public ArrayList<CarteTirage> getPiocheTirage() {
        return piocheTirage;

    }

    public ArrayList<CarteTirage> getDefausseTirage() {
        return defausseTirage;

    }

    private void AttribuerRole(String[] noms) {
        ArrayList<String> roles;
        roles = new ArrayList();
        roles.add("plongeur");
        roles.add("explorateur");
        roles.add("navigateur");
        roles.add("messager");
        roles.add("ingenieur");
        roles.add("pilote");

        for (int i = 0; i < noms.length; i++) {
            Random r = new Random();

            int valeur = r.nextInt(roles.size());

            if (roles.get(valeur).equals("plongeur")) {
                Plongeur p = new Plongeur(noms[i], tuilesdepart.get(1)); //Noir
                tuilesdepart.get(1).addAventurierTuile(p);
                roles = retirerRole(roles, "plongeur");
                joueurs.add(p);

            } else if (roles.get(valeur).equals("explorateur")) {
                Explorateur exp = new Explorateur(noms[i], tuilesdepart.get(5));
                tuilesdepart.get(5).addAventurierTuile(exp);
                roles = retirerRole(roles, "explorateur");//Blanc
                joueurs.add(exp);

            } else if (roles.get(valeur).equals("navigateur")) {
                Navigateur n = new Navigateur(noms[i], tuilesdepart.get(2));
                tuilesdepart.get(2).addAventurierTuile(n);
                roles = retirerRole(roles, "navigateur");
                joueurs.add(n);

            } else if (roles.get(valeur).equals("messager")) {
                Messager m = new Messager(noms[i], tuilesdepart.get(3));
                tuilesdepart.get(3).addAventurierTuile(m);
                roles = retirerRole(roles, "messager");
                joueurs.add(m);

            } else if (roles.get(valeur).equals("ingenieur")) {
                Ingenieur ing = new Ingenieur(noms[i], tuilesdepart.get(0));
                tuilesdepart.get(0).addAventurierTuile(ing);
                roles = retirerRole(roles, "ingenieur");
                joueurs.add(ing);

            } else if (roles.get(valeur).equals("pilote")) {
                Pilote pilote = new Pilote(noms[i], tuilesdepart.get(4));
                tuilesdepart.get(4).addAventurierTuile(pilote);
                roles = retirerRole(roles, "pilote");// Bleu
                joueurs.add(pilote);

            }

        }
    }

    private ArrayList<String> retirerRole(ArrayList<String> roles, String r) {
        int i = 0;
        while (i < roles.size() && !(roles.get(i).equals(r))) {
            i++;
        }
        if (i != roles.size()) {
            roles.remove(i);

        }
        return roles;

    }

    public void defausserCarteInondation(int i) {
        defausseInondation.add(piocheInondation.get(i));
        piocheInondation.remove(i);

    }

    public void defausserCarteMonteedesEaux(int i) {

        defausseTirage.add(piocheTirage.get(i));
        piocheTirage.remove(i);

    }

    private void tirerCartetirage(Aventurier j) {

        CarteTirage carte1 = null, carte2 = null;

        for (int t = 0; t < 2; t++) {

            if (piocheTirage.isEmpty()) {
                retourneDefausseCarteTirage();
            }
            if (j.getMains().size() < 9) {
                if (t == 0) {
                    carte1 = piocheTirage.get(0);
                } else {
                    carte2 = piocheTirage.get(0);
                }

                if (piocheTirage.get(0) instanceof CarteMonteedesEaux) {
                    this.tireCarteMonteeDesEaux(0);

                } else {
                    j.getMains().add(piocheTirage.get(0));
                    piocheTirage.remove(piocheTirage.get(0));
                }
            }
        }

       /* if (carte1 instanceof CarteMonteedesEaux || carte2 instanceof CarteMonteedesEaux) {
            this.melangeDefausseCarteInondation();

        }*/

    }

    public void tirerCarteInondation() {
        String[] listeInnon = new String[vplateau.getVueniveau().nbCarteAPiocher()];
        CarteInondation cInon;
        Tuile ttire;
        for (int x = 0; x < vplateau.getVueniveau().nbCarteAPiocher(); x++) {

            if (piocheInondation.isEmpty()) {
                melangeDefausseCarteInondation();

            }
            cInon = piocheInondation.get(0);
            listeInnon[x] = cInon.getTuile().getNom();
            ttire = cInon.getTuile();

            grille.inonderTuile(ttire);

            if (ttire.getEtat() == Utils.EtatTuile.INONDEE) {
                defausserCarteInondation(0);
            } else if (ttire.getEtat() == Utils.EtatTuile.COULEE) {
                System.out.println(piocheInondation.get(0));
                piocheInondation.remove(0);

            }
        }
        String s = "";

        for (int x = 0; x < vplateau.getVueniveau().nbCarteAPiocher(); x++) {
            s = s + listeInnon[x] + ",";

        }
        s = s + " S'innonde maintenant !!!";
        Utils.afficherInformation(s);

    }

    public void tireCarteMonteeDesEaux(int i) {
        // On augmente le niveau de l'eau
        this.vplateau.getVueniveau().setNiveau(vplateau.getVueniveau().getNiveau() + 1);
        // On défausse la carte Montée des eaux qui vient d'être tirée
        this.defausserCarteMonteedesEaux(i);

    }

    private void retourneDefausseCarteTirage() {
        Collections.shuffle(this.getDefausseTirage());
        piocheTirage.addAll(this.getDefausseTirage());
        defausseTirage.clear();
    }

    public void melangeDefausseCarteInondation() {
        Collections.shuffle(this.getDefausseInondation());
        ArrayList<CarteInondation> copie = new ArrayList();
        copie.addAll(this.getDefausseInondation());
        copie.addAll(piocheInondation);
        piocheInondation.clear();
        defausseInondation.clear();
        piocheInondation = copie;
    }

    public void DistributionDébut() {
        for (Aventurier a : this.getJoueurs()) {
            int r = 0, nb = 0;
            while (r != 2) {
                if (!(this.getPiocheTirage().get(nb) instanceof CarteMonteedesEaux)) {
                    a.getMains().add(this.getPiocheTirage().get(nb));

                    this.getPiocheTirage().remove(nb);
                    r++;
                }
                nb++;

            }
        }
        Collections.shuffle(piocheTirage);

    }

    public void defausse(Aventurier a) {

        if (a.getMains().size() > 5) {
            vdefausse = new VueDefausse(a.getMains(), a.getNom());
            System.out.println(noyadeEnCours);
            vdefausse.addObserver(this);
            vdefausse.afficher();
            joueurcourant = a;
            if (joueurcourant.possedeHelico() || joueurcourant.possedeSacSable()) {
                getVueAv().degriserUtiliserCarte();
            }

        }
    }

    public static void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int nbMemeCarteTresor() {
        int nbcarte = 0;
        if (joueurcourant.getTuileCourante().getTresor() != null) {   // A FACTORISER
            for (CarteTirage c : joueurcourant.getMains()) {
                if (c instanceof CarteTresor) {
                    if (((CarteTresor) c).getTypeTresor() == joueurcourant.getTuileCourante().getTresor()) {
                        nbcarte++;
                    }
                }
            }
        }
        return nbcarte;
    }

    private void retirerLes4Cartes() {
        ArrayList<CarteTirage> copie = new ArrayList();
        int nbretires = 0;
        for (int u = 0; u < joueurcourant.getMains().size(); u++) {
            if (joueurcourant.getMains().get(u) instanceof CarteTresor) {
                if ((((CarteTresor) joueurcourant.getMains().get(u)).getTypeTresor() == joueurcourant.getTuileCourante().getTresor()) && nbretires < 4) {
                    nbretires++;
                } else {
                    copie.add(joueurcourant.getMains().get(u));
                }
            }
        }
        joueurcourant.getMains().clear();
        joueurcourant.getMains().addAll(copie);
    }

    private void retirerLe2iemTresor() {
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                if (grille.getTableau()[x][y].getTresor() != null) {
                    if ((grille.getTableau()[x][y].getTresor().equals(joueurcourant.getTuileCourante().getTresor())) && grille.getTableau()[x][y] != joueurcourant.getTuileCourante()) {
                        grille.getTableau()[x][y].setTresor(null);
                    }
                }
            }
        }
    }

    private void gererDemandeAssechement() {
        vplateau.setDerniereaction(Commandes.ASSECHER);
        if (joueurcourant instanceof Ingenieur) {
            ((Ingenieur) joueurcourant).setNbAsseche(1);
        }

        tuilesassechables = joueurcourant.assecher(grille);
        if (joueurcourant.getTuileCourante().getEtat() == Utils.EtatTuile.INONDEE) {
            tuilesassechables.add(joueurcourant.getTuileCourante());
        }
        if (!(tuilesassechables.isEmpty())) {
            affichernomtuiles(tuilesassechables);
            vplateau.raffraichir(grille, joueurs, tresorsrecupérés);
            grisebouton(joueurcourant.getPtsaction());
            vplateau.delimiterTuilesAtteignables(tuilesassechables, joueurcourant);
            System.out.println("cliquez sur une case à assecher");

        } else {
            Utils.afficherInformation("Assechement impossible:Aucune case a assecher a proximité");
        }
    }

    private void gererDemandeBouger() {
        vplateau.setDerniereaction(Commandes.BOUGER);

        if (!(joueurcourant instanceof Pilote)) {
            tuilesatteignables = joueurcourant.seDeplacer(grille);

        } else {
            if (((Pilote) joueurcourant).getNbvol() == 1) {
                if (Utils.poserQuestion("Voulez-vous utiliser votre vol ?")) {
                    tuilesatteignables = ((Pilote) joueurcourant).seDeplacerVol(grille);
                } else {
                    tuilesatteignables = joueurcourant.seDeplacer(grille);
                }
            } else {
                tuilesatteignables = joueurcourant.seDeplacer(grille);
            }
        }

        if (tuilesatteignables.isEmpty() == false) {
            vplateau.raffraichir(grille, joueurs, tresorsrecupérés);
            grisebouton(joueurcourant.getPtsaction());
            vplateau.delimiterTuilesAtteignables(tuilesatteignables, joueurcourant);
            System.out.println("Ou se déplacer ?");

        } else {
            System.out.println("Action impossible");
        }
    }

    private void gererReceptionMessager(Aventurier receveur, Message message) {
        receveur.getMains().add(joueurcourant.getMains().get(message.getNbcarte()));
        joueurcourant.enleveUneAction();
        joueurcourant.getMains().remove(message.getNbcarte());
        vplateau.raffraichir(this.grille, joueurs, tresorsrecupérés);
    }

    private void gererUtilisationCarteActionMainPleine() {
        if (joueurutilisateurcarte != null && vdefausse != null) {
            if (joueurutilisateurcarte.getMains().size() <= 5 && vdefausse.estOuverte()) {
                joueurutilisateurcarte = null;
                vdefausse.close();
            } else if (joueurutilisateurcarte.getMains().size() > 5 && vdefausse.estOuverte()) {
                vdefausse.close();
                defausse(joueurutilisateurcarte);
                vdefausse.rafraichir(joueurutilisateurcarte.getMains());
            }
        }
    }

}
