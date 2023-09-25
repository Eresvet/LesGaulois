package histoire;

import personnages.*;

public class Scenario {

	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		
		Gaulois obelix = new Gaulois("Obelix", 25);
		
		Romain minus = new Romain("Minus", 6);
		
		Druide pano = new Druide("Panoramix", 5, 10);
		
		pano.preparerPotion();
		pano.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		pano.booster(asterix);
		asterix.parler("Bonjour");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
		
		
	}

}
