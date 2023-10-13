package agenciaCrud;

public class PacoteDeViagem {
	private String destino;
	private double preco;
	private boolean promocao = false;
	private int idPacote;
	
	public PacoteDeViagem(String destino, double preco, boolean promocao, int idPacote) {
		super();
		this.destino = destino;
		this.preco = preco;
		this.promocao = promocao;
		this.setIdPacote(idPacote);
	}
	
	public PacoteDeViagem(){};
	
	
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public boolean isPromocao() {
		return promocao;
	}
	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}

	public int getIdPacote() {
		return idPacote;
	}

	public void setIdPacote(int idPacote) {
		this.idPacote = idPacote;
	}

	
	
}
