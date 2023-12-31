package personnages;

public class Gaulois {
	private String nom;
//	private int force;
	private int effetPotion = 1;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}


	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

//	public String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
//		+ romain.getNom());
//		romain.recevoirCoup((force / 3)*effetPotion);
//	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
	}
	
	
	//ATTENTION TP3
	
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
	
	private String prendreParole() {
		return ("Le gaulois " + nom + " : ");
		}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesRecevoirCoup = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesRecevoirCoup != null && i < tropheesRecevoirCoup.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheesRecevoirCoup[i];
		}
	}
	
	
	public static void main(String[] args) {
		Gaulois asterix;
		asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
		
		asterix.parler("Hey ");
		
		Gaulois obelix = new Gaulois("Obélix", 25);
		
		Romain minus;
		minus = new Romain("Minus", 6);		//création d'un romain Jules pour test
		
		asterix.boirePotion(5);
		
		asterix.frapper(minus);
		
		
	}
}

