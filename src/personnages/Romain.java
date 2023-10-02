package personnages;

public class Romain {
	
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		assert (force > 0);
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	public String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		int forceDebut = forceCoup;
		assert (force > 0);
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		}else{
			parler("J'abandonne...");
		}
		int forceFin = force;
		assert (forceDebut > forceFin);
	}
	
	public void sEquiper(Equipement equip) {
		switch(nbEquipement) {
			case 1:
				if (equipements[nbEquipement-1] == equip) {
					System.out.println("Le soldat " + getNom() + " possede deja un " + equip + ".");

					
					
				}else{
					equipements[nbEquipement] = equip;
					nbEquipement++;
					System.out.println("Le soldat " + getNom() + " s'equipe avec un " + equip + ".");

				}
				break;
			case 0:
				equipements[nbEquipement] = equip;
				nbEquipement++;
				System.out.println("Le soldat " + getNom() + " s'equipe avec un " + equip + ".");

				break;
				
			default:
				System.out.println("Le soldat " + getNom() + " est deja bien protege !");


		}
	}
	
	public static void main(String[] args) {
		Romain minus;
		minus = new Romain("Minus", 6);
//		
//		minus.parler("Oui ");
//		
//		minus.recevoirCoup(8);
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
