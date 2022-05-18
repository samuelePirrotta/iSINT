package it.sp.job.inv.beans;

public class Giacenza {
	private String articolo;
	private double giacenza;
	private String deposito;
	public Giacenza() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Giacenza(String articolo, double giacenza, String deposito) {
		super();
		this.articolo = articolo;
		this.giacenza = giacenza;
		this.deposito = deposito;
	}
	public String getArticolo() {
		return articolo;
	}
	public void setArticolo(String articolo) {
		this.articolo = articolo;
	}
	public double getGiacenza() {
		return giacenza;
	}
	public void setGiacenza(double giacenza) {
		this.giacenza = giacenza;
	}
	public String getDeposito() {
		return deposito;
	}
	public void setDeposito(String deposito) {
		this.deposito = deposito;
	}
	@Override
	public String toString() {
		return "Giacenza [articolo=" + articolo + ", giacenza=" + giacenza + ", deposito=" + deposito + "]";
	}
}