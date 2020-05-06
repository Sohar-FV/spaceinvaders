package fr.unilim.iut.spaceinvaders.model;

public class Envahisseur extends Sprite {
	
	private boolean directionGauche;

	public Envahisseur(Dimension dimension, Position positionOrigine, int vitesse) {
		super(dimension, positionOrigine, vitesse);
		this.directionGauche = true;
	}
	
	public void setDirectionGauche(boolean directionGauche) {
		this.directionGauche = directionGauche;
	}

	public boolean getDirectionGauche() {
		return directionGauche;
	}
}
