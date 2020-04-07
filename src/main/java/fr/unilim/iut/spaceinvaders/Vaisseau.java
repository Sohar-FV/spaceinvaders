package fr.unilim.iut.spaceinvaders;

public class Vaisseau {

	int x;
	int y;
	int hauteur;
	int longueur;
	
	public Vaisseau(int longueur, int hauteur) {
		this(longueur, hauteur, 0, 0);
	}

	public Vaisseau(int longueur, int hauteur, int x, int y) {
		this.x = x;
		this.y = y;
		this.hauteur=hauteur;
		this.longueur=longueur;
	}
	
    public boolean occupeLaPosition(int x, int y) {
	     if (estAbscisseCouverte(x) && estOrdonneCouverte(y))
			return true;
		
	     return false;
    }

	private boolean estOrdonneCouverte(int y) {
		return (ordonneLaPlusHaute()<=y) && (y<=ordonneLaPlusBasse());
	}

	private int ordonneLaPlusBasse() {
		return this.y;
	}

	private int ordonneLaPlusHaute() {
		return ordonneLaPlusBasse()-this.hauteur+1;
	}

	private boolean estAbscisseCouverte(int x) {
		return (abscisseLaPlusAGauche()<=x) && (x<=abscisseLaPlusADroite());
	}

	public int abscisseLaPlusADroite() {
		return this.x+this.longueur-1;
	}

	
	public int abscisseLaPlusAGauche() {
		return this.x;
	}
	
	public void seDeplacerVersLaDroite() {
	    this.x = this.x + 1 ;
	}
	public void seDeplacerVersLaGauche() {
		this.x = this.x - 1 ;
		
	}

	public void positionner(int x, int y) {
	    this.x = x;
	 	this.y = y;
	}

}
