package it.sp.job.inv.beans;

public class Record {
	private String ean;
	private String articolo;
	private String descrizione;
	private double giacenza;
	private int nuovo;
	private String unita;
	private String deposito;
	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Record(String ean, String articolo, String descrizione, int nuovo, String unita) {
		super();
		this.ean = ean;
		this.articolo = articolo;
		this.descrizione = descrizione;
		this.nuovo = nuovo;
		this.unita = unita;
	}
	public String getDeposito() {
		return deposito;
	}
	public void setDeposito(String deposito) {
		this.deposito = deposito;
	}
	public String getEan() {
		return ean;
	}
	public void setEan(String ean) {
		this.ean = ean;
	}
	public String getArticolo() {
		return articolo;
	}
	public void setArticolo(String articolo) {
		this.articolo = articolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public double getGiacenza() {
		return giacenza;
	}
	public void setGiacenza(double giacenza) {
		this.giacenza = giacenza;
	}
	public int getNuovo() {
		return nuovo;
	}
	public void setNuovo(int nuovo) {
		this.nuovo = nuovo;
	}
	public String getUnita() {
		return unita;
	}
	public void setUnita(String unita) {
		this.unita = unita;
	}
	@Override
	public String toString() {
		return "Record [ean=" + ean + ", articolo=" + articolo + ", descrizione=" + descrizione + ", giacenza="
				+ giacenza + ", nuovo=" + nuovo + ", unita=" + unita + ", deposito=" + deposito + "]";
	}
}