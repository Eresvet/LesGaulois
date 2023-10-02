package personnages;

public class Romain {
	
	private String nom;
	private int force;
	
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
	
	public static void main(String[] args) {
		Romain minus;
		minus = new Romain("Minus", 6);
		
		minus.parler("Oui ");
		
		minus.recevoirCoup(8);
	}
}
