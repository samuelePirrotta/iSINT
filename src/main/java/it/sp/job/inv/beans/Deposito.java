package it.sp.job.inv.beans;

public class Deposito {
	private int id;
	private String nome;
	public Deposito() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Deposito(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Deposito [id=" + id + ", nome=" + nome + "]";
	}
}