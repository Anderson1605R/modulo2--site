package agenciaCrud;

public class Compra {
	private User user;
	private PacoteDeViagem pacote;
	
	public Compra(User user, PacoteDeViagem pacote, int idCompra) {
		super();
		this.user = user;
		this.pacote = pacote;
		this.idCompra = idCompra;
	}
	
	public Compra() {};
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PacoteDeViagem getPacote() {
		return pacote;
	}

	public void setPacote(PacoteDeViagem pacote) {
		this.pacote = pacote;
	}

	private int idCompra;
	
	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public String getNomeUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
}
