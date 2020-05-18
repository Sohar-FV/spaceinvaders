package fr.unilim.iut.spaceinvaders.model;

public class Collision {

	public boolean detecterCollision(Sprite sprite1, Sprite sprite2) {
		
		
		 	
		boolean bool = false;
		
		
		//Condition de collision verticale (obligatoire dans tous les cas)
		if (sprite1.ordonneeLaPlusBasse() <= sprite2.ordonneeLaPlusHaute() && sprite1.ordonneeLaPlusHaute() >= sprite2.ordonneeLaPlusBasse()) {
			
			//Collision frontale
			if(sprite1.abscisseLaPlusAGauche() >= sprite2.abscisseLaPlusAGauche() && sprite1.abscisseLaPlusADroite() <= sprite2.abscisseLaPlusADroite()) { 
				return true;
			}
			
			//Collision latérale gauche 
			if(sprite1.abscisseLaPlusAGauche() >= sprite2.abscisseLaPlusAGauche()-(sprite1.longueur()-1) && sprite1.abscisseLaPlusADroite() <= sprite2.abscisseLaPlusADroite()) { 
				return true;
				}
			
			//Collision latérale droite
			if(sprite1.abscisseLaPlusAGauche() >= sprite2.abscisseLaPlusAGauche() && sprite1.abscisseLaPlusADroite()-(sprite1.longueur()-1) <= sprite2.abscisseLaPlusADroite()) { 
				return true;
				}
		}
		return bool;
	}
	
	
	
	
}
