package fr.unilim.iut.spaceinvaders.model;

public class Collision {

	public boolean detecterCollision(Sprite sprite1, Sprite sprite2) {
		
		
		//Détecter une collision frontale ( de bas en haut )		
		if (sprite1.ordonneeLaPlusBasse() <= sprite2.ordonneeLaPlusHaute() && sprite1.ordonneeLaPlusBasse() >= sprite2.ordonneeLaPlusBasse()) {
				return true;
			
		}	
		return false;
	}

}
