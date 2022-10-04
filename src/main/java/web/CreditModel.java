package web;

public class CreditModel {
	private Double montant;
	private Double taux;
	private int duree;
	private Double mensualite;

	
	public CreditModel(Double montant, Double taux, int duree, Double mensualite) {
		super();
		this.montant = montant;
		this.taux = taux;
		this.duree = duree;
		this.mensualite = mensualite;
	}
	
	
	public CreditModel() {
		super();
	}


	public Double getMontant() {
		return montant;
	}
	
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	
	public Double getTaux() {
		return taux;
	}
	
	public void setTaux(Double taux) {
		this.taux = taux;
	}
	
	public int getDuree() {
		return duree;
	}
	
	public void setDuree(int duree) {
		this.duree = duree;
	}
	
	public Double getMensualite() {
		return mensualite;
	}
	
	public void setMensualite(Double mensualite) {
		this.mensualite = mensualite;
	}
		
}
