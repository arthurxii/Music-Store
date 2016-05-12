


public class Musicas {
	private String nome;
	public Musicas(String nome){
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String toString(){
		return this.getNome()+ "\n";
	}
}
