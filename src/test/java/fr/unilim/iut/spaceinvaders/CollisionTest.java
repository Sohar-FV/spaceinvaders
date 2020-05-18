package fr.unilim.iut.spaceinvaders;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fr.unilim.iut.spaceinvaders.model.Collision;
import fr.unilim.iut.spaceinvaders.model.Dimension;
import fr.unilim.iut.spaceinvaders.model.Position;
import fr.unilim.iut.spaceinvaders.model.SpaceInvaders;

public class CollisionTest {

	private SpaceInvaders spaceinvaders;
	private Collision collision;
	 
    @Before
    public void initialisation() {
    	spaceinvaders = new SpaceInvaders(15, 10);
    	collision = new Collision();
    }
    
	@Test
	   public void test_Traitement_De_Colision_FrontaleBasHaut() {
		spaceinvaders.positionnerUnNouveauSprite(new Dimension(7,2),new Position(5,9), 1, "Vaisseau");
		spaceinvaders.positionnerUnNouveauSprite(new Dimension(3,2),new Position(7,2), 1, "Envahisseur");
		spaceinvaders.tirerUnMissile(new Dimension(3,2),2);
		
		spaceinvaders.deplacerMissile(); 
		
		/* Représentation de la situation
		 * 
		 *	"...............\n" + 
    	 *	".......EEE.....\n" +
    	 *	".......EEE.....\n" + 
    	 *	"...............\n" + 
	     *	".......MMM.....\n" + 
	     *	".......MMM.....\n" + 
	     *	"...............\n" + 
	     *	"...............\n" + 
	     *	".....VVVVVVV...\n" + 
	     *	".....VVVVVVV...\n"		
	     */
		
		spaceinvaders.deplacerMissile();
		
		assertEquals(true, collision.detecterCollision(spaceinvaders.recupererMissile(), spaceinvaders.recupererEnvahisseur()));
		
	}
	
	@Test
	   public void test_Traitement_De_Tir_Sur_Gros_Envahisseur() {
		spaceinvaders.positionnerUnNouveauSprite(new Dimension(7,2),new Position(4,9), 1, "Vaisseau");
		spaceinvaders.positionnerUnNouveauSprite(new Dimension(5,2),new Position(5,2), 1, "Envahisseur");
		spaceinvaders.tirerUnMissile(new Dimension(3,2),2);

		spaceinvaders.deplacerMissile(); 
		/* Représentation de la situation
		 * 
		 *	"...............\n" + 
		 *	".....EEEEE.....\n" +
		 *	".....EEEEE.....\n" + 
		 *	"...............\n" + 
	     *	"......MMM......\n" + 
	     *	"......MMM......\n" + 
	     *	"...............\n" + 
	     *	"...............\n" + 
	     *	"....VVVVVVV....\n" + 
	     *	"... VVVVVVV....\n"		
	     */

		spaceinvaders.deplacerMissile();
		assertEquals(true, collision.detecterCollision(spaceinvaders.recupererMissile(), spaceinvaders.recupererEnvahisseur()));
		
	}
	
	@Test
	   public void test_Traitement_De_Colision_LatéraleGauche() {
		spaceinvaders.positionnerUnNouveauSprite(new Dimension(3,2),new Position(5,2), 1, "Vaisseau");
		spaceinvaders.positionnerUnNouveauSprite(new Dimension(3,2),new Position(7,2), 1, "Envahisseur");
		
		
		/* Représentation de la situation
		 * 
		 *	"...............\n" + 
		 *	"...VVV....EEE...\n" +
		 *	"...VVV....EEE..\n" + 
		 *	"...............\n" + 
	     *	"...............\n" + 
	     *	"...............\n" + 
	     *	"...............\n" + 
	     *	"...............\n" + 
	     *	"...............\n" + 
	     *	"...............\n"		
	     */
		
		spaceinvaders.deplacerSpriteVersLaDroite(spaceinvaders.recupererVaisseau());
		spaceinvaders.deplacerSpriteVersLaDroite(spaceinvaders.recupererVaisseau());
		
		assertEquals(true, collision.detecterCollision(spaceinvaders.recupererVaisseau(), spaceinvaders.recupererEnvahisseur()));
		
	}
	
	@Test
	   public void test_Traitement_De_Colision_LatéraleDroite() {
		spaceinvaders.positionnerUnNouveauSprite(new Dimension(3,2),new Position(5,2), 1, "Vaisseau");
		spaceinvaders.positionnerUnNouveauSprite(new Dimension(3,2),new Position(7,2), 1, "Envahisseur");
		
		
		/* Représentation de la situation
		 * 
		 *	"...............\n" + 
		 *	"...VVV....EEE...\n" +
		 *	"...VVV....EEE..\n" + 
		 *	"...............\n" + 
	     *	"...............\n" + 
	     *	"...............\n" + 
	     *	"...............\n" + 
	     *	"...............\n" + 
	     *	"...............\n" + 
	     *	"...............\n"		
	     */
		
		spaceinvaders.deplacerSpriteVersLaGauche(spaceinvaders.recupererEnvahisseur());
		spaceinvaders.deplacerSpriteVersLaGauche(spaceinvaders.recupererEnvahisseur());
		
		
		assertEquals(true, collision.detecterCollision(spaceinvaders.recupererEnvahisseur(), spaceinvaders.recupererVaisseau()));
		
	}
	
	@Test
	   public void test_Traitement_De_Colision_LatéraleDroitePartielle() {
		spaceinvaders.positionnerUnNouveauSprite(new Dimension(3,2),new Position(5,1), 1, "Vaisseau");
		spaceinvaders.positionnerUnNouveauSprite(new Dimension(3,2),new Position(7,2), 1, "Envahisseur");
		
		
		/* Représentation de la situation
		 * 
		 *	"...VVV.........\n" + 
		 *	"...VVV....EEE...\n" +
		 *	"..........EEE..\n" + 
		 *	"...............\n" + 
	     *	"...............\n" + 
	     *	"...............\n" + 
	     *	"...............\n" + 
	     *	"...............\n" + 
	     *	"...............\n" + 
	     *	"...............\n"		
	     */
		
		spaceinvaders.deplacerSpriteVersLaGauche(spaceinvaders.recupererEnvahisseur());
		spaceinvaders.deplacerSpriteVersLaGauche(spaceinvaders.recupererEnvahisseur());
		
		
		assertEquals(true, collision.detecterCollision(spaceinvaders.recupererEnvahisseur(), spaceinvaders.recupererVaisseau()));
		
	}
	
	@Test
	   public void test_Traitement_De_TirACoté() {
		spaceinvaders.positionnerUnNouveauSprite(new Dimension(7,2),new Position(2,9), 1, "Vaisseau");
		spaceinvaders.positionnerUnNouveauSprite(new Dimension(3,2),new Position(7,2), 1, "Envahisseur");
		spaceinvaders.tirerUnMissile(new Dimension(3,2),2);

		spaceinvaders.deplacerMissile(); 
		/* Représentation de la situation
		 * 
		 *	"...............\n" + 
		 *	".......EEE.....\n" +
		 *	".......EEE.....\n" + 
		 *	"...............\n" + 
	     *	"....MMM........\n" + 
	     *	"....MMM........\n" + 
	     *	"...............\n" + 
	     *	"...............\n" + 
	     *	"..VVVVVVV......\n" + 
	     *	"..VVVVVVV......\n"		
	     */

		spaceinvaders.deplacerMissile();
		assertEquals(false, collision.detecterCollision(spaceinvaders.recupererMissile(), spaceinvaders.recupererEnvahisseur()));
		
	}
	
	@Test
	   public void test_Traitement_De_Tir_PartielBasGauche() {
		spaceinvaders.positionnerUnNouveauSprite(new Dimension(7,2),new Position(3,9), 1, "Vaisseau");
		spaceinvaders.positionnerUnNouveauSprite(new Dimension(3,2),new Position(7,2), 1, "Envahisseur");
		spaceinvaders.tirerUnMissile(new Dimension(3,2),2);

		spaceinvaders.deplacerMissile(); 
		/* Représentation de la situation
		 * 
		 *	"...............\n" + 
		 *	".......EEE.....\n" +
		 *	".......EEE.....\n" + 
		 *	"...............\n" + 
	     *	".....MMM.......\n" + 
	     *	".....MMM.......\n" + 
	     *	"...............\n" + 
	     *	"...............\n" + 
	     *	"...VVVVVVV.....\n" + 
	     *	"...VVVVVVV.....\n"		
	     */

		spaceinvaders.deplacerMissile();
		assertEquals(true, collision.detecterCollision(spaceinvaders.recupererMissile(), spaceinvaders.recupererEnvahisseur()));
		
	}
	
	@Test
	   public void test_Traitement_De_Tir_PartielBasDroite() {
		spaceinvaders.positionnerUnNouveauSprite(new Dimension(7,2),new Position(7,9), 1, "Vaisseau");
		spaceinvaders.positionnerUnNouveauSprite(new Dimension(3,2),new Position(7,2), 1, "Envahisseur");
		spaceinvaders.tirerUnMissile(new Dimension(3,2),2);

		spaceinvaders.deplacerMissile(); 
		/* Représentation de la situation
		 * 
		 *	"...............\n" + 
		 *	".......EEE.....\n" +
		 *	".......EEE.....\n" + 
		 *	"...............\n" + 
	     *	".........MMM...\n" + 
	     *	".........MMM...\n" + 
	     *	"...............\n" + 
	     *	"...............\n" + 
	     *	".......VVVVVVV.\n" + 
	     *	".......VVVVVVV.\n"		
	     */

		spaceinvaders.deplacerMissile();
		assertEquals(true, collision.detecterCollision(spaceinvaders.recupererMissile(), spaceinvaders.recupererEnvahisseur()));
		
	}
	
	
}
