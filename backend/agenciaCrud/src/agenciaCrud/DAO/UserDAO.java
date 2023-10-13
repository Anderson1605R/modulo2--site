package agenciaCrud.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import agenciaCrud.Conexao;
import agenciaCrud.User;

public class UserDAO extends User {

	public UserDAO(String name, String cpf, String email, int idUser, String senha) {
		super(name,cpf,email, idUser, senha);
		
	}

	public static void create(User usuario) {
		String sql = "INSERT INTO user(nome, cpf_unico, email, senha)" + "VALUES(?,?,?,?)";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;

			try {
				conn = Conexao.createConnectionToMysql();
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, usuario.getNome());
				pstm.setString(2, usuario.getCpf());
				pstm.setString(3, usuario.getEmail());
				pstm.setString(4, usuario.getSenha());
				
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
		String sql = "DELETE FROM user WHERE id_user = ?";
		
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
	
	
	public static void update(User usuario) {
	String sql = "UPDATE user SET nome = ?, cpf_unico = ?, email = ?, senha = ? WHERE id_user = ? ";
			
			Connection conn = null;
			
			PreparedStatement pstm = null;
	
				try {
					conn = Conexao.createConnectionToMysql();
					pstm = conn.prepareStatement(sql);
					
					pstm.setString(1, usuario.getNome());
					pstm.setString(2, usuario.getCpf());	
					pstm.setString(3, usuario.getEmail());
					pstm.setString(4, usuario.getSenha());
					pstm.setInt(5, usuario.getId());
			
					
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
	
	public static List<User>getUsers(){
		
		String sql = "SELECT * FROM user";
		
		
		List<User> usuarios = new ArrayList<User>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

			try {
				conn = Conexao.createConnectionToMysql();
				pstm = conn.prepareStatement(sql);
				rset = pstm.executeQuery();
				
				while (rset.next()) {
					User usuario = new User();
					
					usuario.setId(rset.getInt("id_user"));
					usuario.setNome(rset.getString("nome"));
					usuario.setCpf(rset.getString("cpf_unico"));
					usuario.setEmail(rset.getString("email"));
					
					usuarios.add(usuario);
					
					
					
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
			
			return usuarios;
	}
	
	
	
	
	
	
	
	
	
	
	
}
