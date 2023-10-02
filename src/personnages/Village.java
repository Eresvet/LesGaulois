package personnages;

public class Village {
	
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois[] villageois;

	
	
	public Village(String nom, int nbVillageoisMax) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMax];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int i){
		return villageois[i];
		
	}
	
	public void afficherVillageois() {
		System.out.println("Dans village du chef Abraracourcix vivent les légendaires gaulois :");
		for(int i = 0; i < nbVillageois; i++ ) {
			System.out.println("- " + villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		
		Village village = new Village("Village des Irréductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(29);
//		message de levée d'exception car 30 est une case qui n'est pas dans le tableau
		Chef abra = new Chef("Abraracourcix", 6, village);
		village.setChef(abra);
		
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);
		
		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterHabitant(obelix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		il n'y a personne dans la case 1 du tableau, asterix est dans la case 0
		
		village.afficherVillageois();
	}
}
