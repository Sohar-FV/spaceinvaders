package fr.unilim.iut.spaceinvaders;

    import fr.unilim.iut.spaceinvaders.model.Dimension;
import fr.unilim.iut.spaceinvaders.model.Position;
import fr.unilim.iut.spaceinvaders.model.SpaceInvaders;
import fr.unilim.iut.spaceinvaders.utils.DebordementEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.MissileException;

import static org.junit.Assert.assertEquals;
    import static org.junit.Assert.fail;
	import org.junit.Test;
    
    import org.junit.Before;

    public class SpaceInvadersTest {
	
    	private SpaceInvaders spaceinvaders;
    	 
	    @Before
	    public void initialisation() {
	    	spaceinvaders = new SpaceInvaders(15, 10);
	    }
	
	   @Test
	   public void test_AuDebut_JeuSpaceInvaderEstVide() {
		    assertEquals("" + 
		    "...............\n" + 
		    "...............\n" +
		    "...............\n" + 
		    "...............\n" + 
		    "...............\n" + 
		    "...............\n" + 
		    "...............\n" + 
		    "...............\n" + 
		    "...............\n" + 
		    "...............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	        }

	   @Test
	   public void test_unNouveauVaisseauEstCorrectementPositionneDansEspaceJeu() {
		    //Arrange
			//Act
		   spaceinvaders.positionnerUnNouveauSprite(new Dimension(1,1),new Position(7,9), 1, "Vaisseau");
			//Assert
			assertEquals("" + 
			"...............\n" + 
			"...............\n" +
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			".......V.......\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
		}
	   
	   @Test
		public void test_UnNouveauVaisseauPositionneHorsEspaceJeu_DoitLeverUneException() {
			
			try {
				spaceinvaders.positionnerUnNouveauSprite(new Dimension(1,1),new Position(15,9), 1, "Vaisseau");
				fail("Position trop à droite : devrait déclencher une exception HorsEspaceJeuException");
			} catch (final HorsEspaceJeuException e) {
			}
			
			
			try {
				spaceinvaders.positionnerUnNouveauSprite(new Dimension(1,1),new Position(-1,9), 1, "Vaisseau");
				fail("Position trop à gauche : devrait déclencher une exception HorsEspaceJeuException");
			} catch (final HorsEspaceJeuException e) {
			}
			
			
			try {
				spaceinvaders.positionnerUnNouveauSprite(new Dimension(1,1),new Position(14,10), 1, "Vaisseau");
				fail("Position trop en bas : devrait déclencher une exception HorsEspaceJeuException");
			} catch (final HorsEspaceJeuException e) {
			}
			
			
			try {
				spaceinvaders.positionnerUnNouveauSprite(new Dimension(1,1),new Position(14,-1), 1, "Vaisseau");
				fail("Position trop à haut : devrait déclencher une exception HorsEspaceJeuException");
			} catch (final HorsEspaceJeuException e) {
			}
				
		}
	   	 
	   
	    @Test
		public void test_unNouveauVaisseauAvecDimensionEstCorrectementPositionneDansEspaceJeu() {
	    	spaceinvaders.positionnerUnNouveauSprite(new Dimension(3,2),new Position(7,9), 1, "Vaisseau");
			assertEquals("" + 
			"...............\n" + 
			"...............\n" +
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			".......VVV.....\n" + 
			".......VVV.....\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
		}
	   
	    @Test
		public void test_UnNouveauVaisseauPositionneDansEspaceJeuMaisAvecDimensionTropGrande_DoitLeverUneExceptionDeDebordement() {
			
			try {
				spaceinvaders.positionnerUnNouveauSprite(new Dimension(9,2), new Position(7,9), 1, "Vaisseau");
				fail("Dépassement du vaisseau à droite en raison de sa longueur trop importante : devrait déclencher une exception DebordementEspaceJeuException");
			} catch (final DebordementEspaceJeuException e) {
			}
			
			
			try {
				spaceinvaders.positionnerUnNouveauSprite(new Dimension(3,4), new Position(7,1), 1, "Vaisseau");
				fail("Dépassement du vaisseau vers le haut en raison de sa hauteur trop importante : devrait déclencher une exception DebordementEspaceJeuException");
			} catch (final DebordementEspaceJeuException e) {
			}
				
		}
	    
	    
	    
	    //Fonctionnalité 3
	    
	    public void test_VaisseauAvance_DeplacerVaisseauVersLaDroite() {

	        spaceinvaders.positionnerUnNouveauSprite(new Dimension(3,2),new Position(7,9),3, "Vaisseau");
	        spaceinvaders.deplacerVaisseauVersLaDroite();
	        assertEquals("" + 
	        "...............\n" + 
	        "...............\n" +
	        "...............\n" + 
	        "...............\n" + 
	        "...............\n" + 
	        "...............\n" + 
	        "...............\n" + 
	        "...............\n" + 
	        "..........VVV..\n" + 
	        "..........VVV..\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	    }
	    
	    
	    @Test
		public void test_VaisseauImmobile_DeplacerVaisseauVersLaDroite() {
			
	    	spaceinvaders.positionnerUnNouveauSprite(new Dimension(3,2),new Position(12,9), 3, "Vaisseau");
			spaceinvaders.deplacerVaisseauVersLaDroite();
			assertEquals("" + 
			"...............\n" + 
			"...............\n" +
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"............VVV\n" + 
			"............VVV\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
		}


	    @Test
	    public void test_VaisseauAvancePartiellement_DeplacerVaisseauVersLaDroite() {

	       spaceinvaders.positionnerUnNouveauSprite(new Dimension(3,2),new Position(10,9),3, "Vaisseau");
	       spaceinvaders.deplacerVaisseauVersLaDroite();
	       assertEquals("" + 
	       "...............\n" + 
	       "...............\n" +
	       "...............\n" + 
	       "...............\n" + 
	       "...............\n" + 
	       "...............\n" + 
	       "...............\n" + 
	       "...............\n" + 
	       "............VVV\n" + 
	       "............VVV\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	    }
	    
	    @Test
	    public void test_VaisseauAvance_DeplacerVaisseauVersLaGauche() {

	       spaceinvaders.positionnerUnNouveauSprite(new Dimension(3,2),new Position(7,9), 3, "Vaisseau");
	       spaceinvaders.deplacerVaisseauVersLaGauche();

	       assertEquals("" + 
	       "...............\n" + 
	       "...............\n" +
	       "...............\n" + 
	       "...............\n" + 
	       "...............\n" + 
	       "...............\n" + 
	       "...............\n" + 
	       "...............\n" + 
	       "....VVV........\n" + 
	       "....VVV........\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	   }
	    
	    @Test
		public void test_VaisseauImmobile_DeplacerVaisseauVersLaGauche() {
			
	    	spaceinvaders.positionnerUnNouveauSprite(new Dimension(3,2),new Position(0,9), 3, "Vaisseau");
			spaceinvaders.deplacerVaisseauVersLaGauche();
			
			assertEquals("" + 
			"...............\n" + 
			"...............\n" +
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"VVV............\n" + 
			"VVV............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
		}
	    
	    
	    @Test
	    public void test_VaisseauAvancePartiellement_DeplacerVaisseauVersLaGauche() {

	       spaceinvaders.positionnerUnNouveauSprite(new Dimension(3,2),new Position(1,9), 3, "Vaisseau");
	       spaceinvaders.deplacerVaisseauVersLaGauche();

	       assertEquals("" + 
	       "...............\n" + 
	       "...............\n" +
	       "...............\n" + 
	       "...............\n" + 
	       "...............\n" + 
	       "...............\n" + 
	       "...............\n" + 
	       "...............\n" + 
	       "VVV............\n" + 
	       "VVV............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	     }
	    
	    //Fonctionnalité 4
	    
	    @Test
	     public void test_MissileBienTireDepuisVaisseau_VaisseauLongueurImpaireMissileLongueurImpaire() {

		   spaceinvaders.positionnerUnNouveauSprite(new Dimension(7,2),new Position(5,9), 2, "Vaisseau");
		   spaceinvaders.tirerUnMissile(new Dimension(3,2),2);

	       assertEquals("" + 
	       "...............\n" + 
	       "...............\n" +
	       "...............\n" + 
	       "...............\n" + 
	       "...............\n" + 
	       "...............\n" + 
	       ".......MMM.....\n" + 
	       ".......MMM.....\n" + 
	       ".....VVVVVVV...\n" + 
	       ".....VVVVVVV...\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	    }
	    
	    @Test(expected = MissileException.class)
		public void test_PasAssezDePlacePourTirerUnMissile_UneExceptionEstLevee() throws Exception { 
	       spaceinvaders.positionnerUnNouveauSprite(new Dimension(7,2),new Position(5,9), 1, "Vaisseau");
		   spaceinvaders.tirerUnMissile(new Dimension(7,9),1);
		}
	    
	    @Test
	    public void test_MissileAvanceAutomatiquement_ApresTirDepuisLeVaisseau() {

	       spaceinvaders.positionnerUnNouveauSprite(new Dimension(7,2),new Position(5,9), 1, "Vaisseau");
		   spaceinvaders.tirerUnMissile(new Dimension(3,2),2);

		   spaceinvaders.deplacerMissile(); 
		   
	       assertEquals("" + 
	       "...............\n" + 
	       "...............\n" +
	       "...............\n" + 
	       "...............\n" + 
	       ".......MMM.....\n" + 
	       ".......MMM.....\n" + 
	       "...............\n" + 
	       "...............\n" + 
	       ".....VVVVVVV...\n" + 
	       ".....VVVVVVV...\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	   }
	    
	    @Test
	    public void test_MissileDisparait_QuandIlCommenceASortirDeEspaceJeu() {

	 	   spaceinvaders.positionnerUnNouveauSprite(new Dimension(7,2),new Position(5,9), 1, "Vaisseau");
	 	   spaceinvaders.tirerUnMissile(new Dimension(3,2),1);
	 	   for (int i = 1; i <=6 ; i++) {
	 		   spaceinvaders.deplacerMissile();
	 	   }
	 	   
	 	   spaceinvaders.deplacerMissile();
	 	   
	        assertEquals("" +
	        "...............\n" + 
	        "...............\n" +
	        "...............\n" + 
	        "...............\n" +
	        "...............\n" +
	        "...............\n" + 
	        "...............\n" +
	        "...............\n" + 
	        ".....VVVVVVV...\n" + 
	        ".....VVVVVVV...\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	    }
	    
	    @Test
	    public void test_PositionnerUnNouvelEnvahisseur() {
	    	
	    	spaceinvaders.positionnerUnNouveauSprite(new Dimension(3,2),new Position(6,2), 1, "Envahisseur");
	    	
	    	assertEquals("" + 
	    	"...............\n" + 
	    	"......EEE......\n" +
	    	"......EEE......\n" + 
	    	"...............\n" + 
	    	"...............\n" + 
	    	"...............\n" + 
	    	"...............\n" + 
	    	"...............\n" + 
	    	"...............\n" + 
	        "...............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	    }
	    
	    @Test
	    public void test_PositionnerUnNouvelEnvahisseur_et_UnVaisseau() {
	    	spaceinvaders.positionnerUnNouveauSprite(new Dimension(6,2),new Position(5,9), 1, "Vaisseau");
	    	spaceinvaders.positionnerUnNouveauSprite(new Dimension(3,2),new Position(6,2), 1, "Envahisseur");
	    	
	    	assertEquals("" + 
	    	"...............\n" + 
	    	"......EEE......\n" +
	    	"......EEE......\n" + 
	    	"...............\n" + 
	    	"...............\n" + 
	    	"...............\n" + 
	    	"...............\n" + 
	    	"...............\n" + 
	    	".....VVVVVV....\n" + 
	        ".....VVVVVV....\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	    }
	    
	    @Test
	    public void test_DéplacerUnEnvahisseurVersLaGauche() {
	    	
	    	spaceinvaders.positionnerUnNouveauSprite(new Dimension(3,2),new Position(6,2), 1, "Envahisseur");
	    	spaceinvaders.deplacerEnvahisseurVersLaGauche();
	    	
	    	assertEquals("" + 
	    	"...............\n" + 
	    	".....EEE.......\n" +
	    	".....EEE.......\n" + 
	    	"...............\n" + 
	    	"...............\n" + 
	    	"...............\n" + 
	    	"...............\n" + 
	    	"...............\n" + 
	    	"...............\n" + 
	        "...............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
	    }
	   
    }