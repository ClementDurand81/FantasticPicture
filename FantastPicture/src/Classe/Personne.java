package Classe;

public class Personne {
    private String nom;
    private String motDePasse;

    public Personne(String nom, String motDePasse) {
        this.setNom(nom);
        this.setMotDePasse(motDePasse);
    }

    public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

    public boolean verifierIdentifiants(String nom, String motDePasse) {
        return this.nom.equals(nom) && this.motDePasse.equals(motDePasse);
    }
}
