package fr.unilim.iut.spaceinvaders.model;

public class Collision {

	public boolean detecterCollision(Sprite sprite1, Sprite sprite2) {
		
		
		//Détecter une collision frontale ( de bas en haut )		
		if (sprite1.ordonneeLaPlusBasse() <= sprite2.ordonneeLaPlusHaute() && sprite1.ordonneeLaPlusBasse() >= sprite2.ordonneeLaPlusBasse()) {
			return true;
			
		}	
		if (sprite1.abscisseLaPlusAGauche() <= sprite2.abscisseLaPlusADroite() && sprite1.abscisseLaPlusADroite() >= sprite2.abscisseLaPlusAGauche()) {
			return true;
		
		}	
		return false;
	}
	
	//à faire : vérifier l'abscisse en cas de collision frontale (éviter de déclarer une collision en cas de tir à coté)
	//Traiter les colisions latérales 
	//Vérifier qu'il n'y a pas d'autres types de collisions à traiter

}
