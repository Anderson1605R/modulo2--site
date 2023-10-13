package agenciaCrud.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import agenciaCrud.Conexao;
import agenciaCrud.PacoteDeViagem;


public class PacoteDeViagemDAO extends PacoteDeViagem {

	public PacoteDeViagemDAO(String destino, double preco, boolean promocao, int idPacote) {
		super(destino, preco, promocao, idPacote);
		
	}
	public static void create(PacoteDeViagem pacote) {

		String sql = "INSERT INTO pacote(destino, preco, promocao_boolean)" + "VALUES(?,?,?)";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;

			try {
				conn = Conexao.createConnectionToMysql();
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, pacote.getDestino());
				pstm.setDouble(2, pacote.getPreco());
				pstm.setBoolean(3, pacote.isPromocao());
				
				pstm.execute();
				
				
	
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
		
		
	}
	
	public static void remove(int id) {
		String sql = "DELETE FROM pacote WHERE ID_pacote = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;

			try {
				conn = Conexao.createConnectionToMysql();
				pstm = conn.prepareStatement(sql);
				
				pstm.setInt(1, id);				
		
				
				pstm.execute();
				
			
	
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
	
	public static void update(PacoteDeViagem pacote) {
		String sql = "UPDATE pacote SET destino = ?, preco = ?,  promocao_boolean = ? WHERE ID_pacote = ? ";
				
				Connection conn = null;
				
				PreparedStatement pstm = null;
		
					try {
						conn = Conexao.createConnectionToMysql();
						pstm = conn.prepareStatement(sql);
						
						pstm.setString(1, pacote.getDestino());
						pstm.setDouble(2, pacote.getPreco());	
						pstm.setBoolean(3, pacote.isPromocao());
						pstm.setInt(4, pacote.getIdPacote());	
				
						
						pstm.execute();
						
					
			
						
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if (pstm != null) {
								pstm.close();
							}
							if (conn != null) {
								conn.close();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
			}
	
	public static List<PacoteDeViagem>getPacote(){
		
		String sql = "SELECT * FROM pacote";
		
		
		List<PacoteDeViagem> pacotes = new ArrayList<PacoteDeViagem>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

			try {
				conn = Conexao.createConnectionToMysql();
				pstm = conn.prepareStatement(sql);
				rset = pstm.executeQuery();
				
				while (rset.next()) {
					PacoteDeViagem pacote = new PacoteDeViagem();
					
					pacote.setIdPacote(rset.getInt("ID_pacote"));
					pacote.setDestino(rset.getString("destino"));
					pacote.setPreco(rset.getDouble("preco"));
					pacote.setPromocao(rset.getBoolean("promocao_boolean"));
					
					
					
					pacotes.add(pacote);
					
					
					
				}
				
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
					
					if(rset != null) {
						rset.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return pacotes;
	}
	
}
