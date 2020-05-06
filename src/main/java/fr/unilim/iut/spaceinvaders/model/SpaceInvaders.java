package fr.unilim.iut.spaceinvaders.model;

import fr.unilim.iut.spaceinvaders.Constante;
import fr.unilim.iut.spaceinvaders.moteurjeu.Commande;
import fr.unilim.iut.spaceinvaders.moteurjeu.Jeu;
import fr.unilim.iut.spaceinvaders.utils.*;

public class SpaceInvaders implements Jeu {

	int longueur;
	int hauteur;
	Vaisseau vaisseau; 
	Missile missile;
	Envahisseur envahisseur;

	//Gestion de l'espace de jeu 
	
	public SpaceInvaders(int longueur, int hauteur) {
		this.longueur = longueur;
		this.hauteur = hauteur;
	}

	public String recupererEspaceJeuDansChaineASCII() {
		StringBuilder espaceDeJeu = new StringBuilder();
		for (int y = 0; y < hauteur; y++) {
			for (int x = 0; x < longueur; x++) {
				espaceDeJeu.append(recupererMarqueDeLaPosition(x, y));
			}
			espaceDeJeu.append(Constante.MARQUE_FIN_LIGNE);
		}
		return espaceDeJeu.toString();
	}

	private char recupererMarqueDeLaPosition(int x, int y) {
			char marque;
			if (this.aUnVaisseauQuiOccupeLaPosition(x, y))
				marque = Constante.MARQUE_VAISSEAU;
			else if (this.aUnMissileQuiOccupeLaPosition(x, y))
					marque = Constante.MARQUE_MISSILE;
			else if (this.aUnEnvahisseurQuiOccupeLaPosition(x, y))
				marque = Constante.MARQUE_ENVAHISSEUR;
			else marque = Constante.MARQUE_VIDE;
			return marque;
		}
	
	//Gestion des Sprites
	
	

	public Vaisseau recupererVaisseau() {		
		return this.vaisseau;
	}
	
	public Missile recupererMissile() {
		return this.missile;
	}
	
	public Envahisseur recupererEnvahisseur() {
		return this.envahisseur;
	}

	
	//Gestion des positions

	private boolean aUnMissileQuiOccupeLaPosition(int x, int y) {
		return this.aUnMissile() && missile.occupeLaPosition(x, y);
	}

	public boolean aUnMissile() {
		return missile != null;
	}

	public boolean aUnVaisseauQuiOccupeLaPosition(int x, int y) {
		return this.aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
	}

	public boolean aUnVaisseau() {
		return vaisseau != null;
	}
	
	private boolean aUnEnvahisseurQuiOccupeLaPosition(int x, int y) {
		return this.aUnEnvahisseur() && envahisseur.occupeLaPosition(x, y);
	}

	public boolean aUnEnvahisseur() {
		return envahisseur != null;
	}

	public boolean estDansEspaceJeu(int x, int y) {
		return ((x >= 0) && (x < longueur)) && ((y >= 0) && (y < hauteur));
	}
	
/*			
			int x = position.abscisse();
			int y = position.ordonnee();
			
			if (!estDansEspaceJeu(x, y))
				throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");

			int longueurVaisseau = dimension.longueur();
			int hauteurVaisseau = dimension.hauteur();
			
			if (!estDansEspaceJeu(x + longueurVaisseau - 1, y))
				throw new DebordementEspaceJeuException("Le vaisseau déborde de l'espace jeu vers la droite à cause de sa longueur");
			if (!estDansEspaceJeu(x, y - hauteurVaisseau + 1))
				throw new DebordementEspaceJeuException("Le vaisseau déborde de l'espace jeu vers le bas à cause de sa hauteur");

			vaisseau = new Vaisseau(dimension,position,vitesse);
	}
	 
	public void positionnerUnNouvelEnvahisseur(Dimension dimension, Position position, int vitesse) {
		int x = position.abscisse();
		int y = position.ordonnee();
		
		if (!estDansEspaceJeu(x, y))
			throw new HorsEspaceJeuException("La position de l'envahisseur est en dehors de l'espace jeu");

		int longueurEnvahisseur = dimension.longueur();
		int hauteurEnvahisseur = dimension.hauteur();
		
		if (!estDansEspaceJeu(x + longueurEnvahisseur - 1, y))
			throw new DebordementEspaceJeuException("Le vaisseau déborde de l'espace jeu vers la droite à cause de sa longueur");
		if (!estDansEspaceJeu(x, y - hauteurEnvahisseur + 1))
			throw new DebordementEspaceJeuException("Le vaisseau déborde de l'espace jeu vers le bas à cause de sa hauteur");

		envahisseur = new Envahisseur(dimension,position,vitesse);
			
	}*/
	
	public void positionnerUnNouveauSprite(Dimension dimension, Position position, int vitesse, String type) {
		int x = position.abscisse();
		int y = position.ordonnee();
		
		if (!estDansEspaceJeu(x, y))
			throw new HorsEspaceJeuException("La position du sprite est en dehors de l'espace jeu");

		int longueurSprite = dimension.longueur();
		int hauteurSprite = dimension.hauteur();
		
		if (!estDansEspaceJeu(x + longueurSprite - 1, y))
			throw new DebordementEspaceJeuException("Le sprite déborde de l'espace jeu vers la droite à cause de sa longueur");
		if (!estDansEspaceJeu(x, y - hauteurSprite + 1))
			throw new DebordementEspaceJeuException("Le sprite déborde de l'espace jeu vers le bas à cause de sa hauteur");

		if (type.equals("Envahisseur"))
				envahisseur = new Envahisseur(dimension,position,vitesse);
		if (type.equals("Vaisseau"))
				vaisseau = new Vaisseau(dimension,position,vitesse);
			
	}
	
	

	
	//Gestion des déplacements et actions
	public void deplacerVaisseauVersLaDroite() {
		if (vaisseau.abscisseLaPlusADroite() < (longueur - 1)) {
			vaisseau.deplacerHorizontalementVers(Direction.DROITE);;
			if (!estDansEspaceJeu(vaisseau.abscisseLaPlusADroite(), vaisseau.ordonneeLaPlusHaute())) {
				vaisseau.positionner(longueur - vaisseau.longueur(), vaisseau.ordonneeLaPlusHaute());
			}
		}
	}

	public void deplacerVaisseauVersLaGauche() {
		if (0 < vaisseau.abscisseLaPlusAGauche())
			vaisseau.deplacerHorizontalementVers(Direction.GAUCHE);
		if (!estDansEspaceJeu(vaisseau.abscisseLaPlusAGauche(), vaisseau.ordonneeLaPlusHaute())) {
			vaisseau.positionner(0, vaisseau.ordonneeLaPlusHaute());
		}
	}
	
    public void tirerUnMissile(Dimension dimensionMissile, int vitesseMissile) {
		
		   if ((vaisseau.hauteur()+ dimensionMissile.hauteur()) > this.hauteur )
			   throw new MissileException("Pas assez de hauteur libre entre le vaisseau et le haut de l'espace jeu pour tirer le missile");
							
		   this.missile = this.vaisseau.tirerUnMissile(dimensionMissile,vitesseMissile);
    }

	public void deplacerMissile() {
		missile.deplacerVerticalementVers(Direction.HAUT_ECRAN);
		if (missile.ordonneeLaPlusHaute()<=0) {
			missile = null;
		}
		
	}
	
	public void deplacerEnvahisseurVersLaGauche() {
		if (0 < envahisseur.abscisseLaPlusAGauche())
			envahisseur.deplacerHorizontalementVers(Direction.GAUCHE);
		if (!estDansEspaceJeu(envahisseur.abscisseLaPlusAGauche(), envahisseur.ordonneeLaPlusHaute())) {
			envahisseur.positionner(0, envahisseur.ordonneeLaPlusHaute());
		}
	}
	
	public void deplacerEnvahisseurVersLaDroite() {
		if (envahisseur.abscisseLaPlusADroite() < (longueur - 1)) {
			envahisseur.deplacerHorizontalementVers(Direction.DROITE);
			if (!estDansEspaceJeu(envahisseur.abscisseLaPlusADroite(), envahisseur.ordonneeLaPlusHaute())) {
				envahisseur.positionner(longueur - envahisseur.longueur(), envahisseur.ordonneeLaPlusHaute());
			}
		}
	}
	
	
	
	
	//Gestion du jeu et du moteur graphique
	
	 public void initialiserJeu() {
			Position positionVaisseau = new Position(this.longueur/2,this.hauteur-1);
			Dimension dimensionVaisseau = new Dimension(Constante.VAISSEAU_LONGUEUR, Constante.VAISSEAU_HAUTEUR);
			positionnerUnNouveauSprite(dimensionVaisseau, positionVaisseau, Constante.VAISSEAU_VITESSE, "Vaisseau");
			Position positionEnvahisseur = new Position(this.longueur/2,this.hauteur-80);
			Dimension dimensionEnvahisseur = new Dimension(Constante.ENVAHISSEUR_LONGUEUR, Constante.ENVAHISSEUR_HAUTEUR);
			positionnerUnNouveauSprite(dimensionEnvahisseur, positionEnvahisseur, Constante.ENVAHISSEUR_VITESSE, "Envahisseur");
			
		 }
	
	 @Override
	 public void evoluer(Commande commandeUser) {
		
     if (commandeUser.gauche) {
         deplacerVaisseauVersLaGauche();
     }
		
     if (commandeUser.droite) {
     	deplacerVaisseauVersLaDroite();
     }
     
     if (commandeUser.tir && !this.aUnMissile()) {
         tirerUnMissile(new Dimension(Constante.MISSILE_LONGUEUR, Constante.MISSILE_HAUTEUR), Constante.MISSILE_VITESSE);
	   }
     
     if (this.aUnMissile()) {
         deplacerMissile();
	   }
     
     if (this.aUnEnvahisseur() && envahisseur.getDirectionGauche()) {
    	 
    	 deplacerEnvahisseurVersLaGauche();
    	 if (!(estDansEspaceJeu(envahisseur.abscisseLaPlusAGauche()-1, envahisseur.ordonneeLaPlusHaute()))) {
    		 envahisseur.setDirectionGauche(false);}
     	 }
     
     if (this.aUnEnvahisseur() && !envahisseur.getDirectionGauche()) {
    	 
    	 deplacerEnvahisseurVersLaDroite();
    	 if (!(estDansEspaceJeu(envahisseur.abscisseLaPlusADroite()+1, envahisseur.ordonneeLaPlusHaute()))) {
    		 envahisseur.setDirectionGauche(true);}
     	 }
	 }
     

	 

	 

	@Override
  public boolean etreFini() {
		 return false; 
  }

	
	

}
