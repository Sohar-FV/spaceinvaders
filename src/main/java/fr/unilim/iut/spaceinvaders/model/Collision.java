package fr.unilim.iut.spaceinvaders.model;

public class Collision {

	public boolean detecterCollision(Sprite sprite1, Sprite sprite2) {
		
		
		//Condition de collision verticale (obligatoire dans tous les cas)
		if (seSuperposeVerticalement(sprite1, sprite2)) {
			
			//Collision frontale
			if(seSuperposeHorinzontalement(sprite1, sprite2)) { 
				return true;
			}
			
			//Collision latérale gauche 
			if(seSuperposeHorinzontalementPartiellementAGauche(sprite1, sprite2)) { 
				return true;
				}
			
			//Collision latérale droite
			if(seSuperposeHorinzontalementPartiellementADroite(sprite1, sprite2)) { 
				return true;
				}
		}
		return false;
	}

	private boolean seSuperposeHorinzontalementPartiellementADroite(Sprite sprite1, Sprite sprite2) {
		return sprite1.abscisseLaPlusAGauche() >= sprite2.abscisseLaPlusAGauche() && sprite1.abscisseLaPlusADroite()-(sprite1.longueur()-1) <= sprite2.abscisseLaPlusADroite();
	}

	private boolean seSuperposeHorinzontalementPartiellementAGauche(Sprite sprite1, Sprite sprite2) {
		return sprite1.abscisseLaPlusAGauche() >= sprite2.abscisseLaPlusAGauche()-(sprite1.longueur()-1) && sprite1.abscisseLaPlusADroite() <= sprite2.abscisseLaPlusADroite();
	}

	private boolean seSuperposeHorinzontalement(Sprite sprite1, Sprite sprite2) {
		return sprite1.abscisseLaPlusAGauche() >= sprite2.abscisseLaPlusAGauche() && sprite1.abscisseLaPlusADroite() <= sprite2.abscisseLaPlusADroite();
	}

	private boolean seSuperposeVerticalement(Sprite sprite1, Sprite sprite2) {
		return sprite1.ordonneeLaPlusBasse() <= sprite2.ordonneeLaPlusHaute() && sprite1.ordonneeLaPlusHaute() >= sprite2.ordonneeLaPlusBasse();
	}
	
	
	
	
}
