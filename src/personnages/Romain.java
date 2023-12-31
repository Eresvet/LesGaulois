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
	
//	public void recevoirCoup(int forceCoup) {
//		int forceDebut = forceCoup;
//		assert (force > 0);
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		}else{
//			parler("J'abandonne...");
//		}
//		int forceFin = force;
//		assert (forceDebut > forceFin);
//	}
	
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
	
	//ATTENTION TP3
	
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}
	
	
		private Equipement[] ejecterEquipement() {
			Equipement[] equipementEjecte = new Equipement[nbEquipement];
			System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
			int nbEquipementEjecte = 0;
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null) {
					equipementEjecte[nbEquipementEjecte] = equipements[i];
					nbEquipementEjecte++;
					equipements[i] = null;
				}
			}
			return equipementEjecte;
		}
	
	
	public Equipement[] recevoirCoup(int forceCoup){
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		
		if(force == 0) {
			parler("Aïe");
		}else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
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
