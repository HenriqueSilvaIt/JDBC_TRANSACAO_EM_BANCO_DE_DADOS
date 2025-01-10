package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class ProgramJDBC {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"DELETE FROM departament "
					+ "WHERE "
					+ "Id = ?");
			
			st.setInt(1, 2);
					
			
			int rows = st.executeUpdate(); // aqui ele executa o comando retorna
			// quantas linhas foram afetadas, é como se fosse o commit do banco
			
			System.out.println("Done, rows affected: " + rows);
	
						
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
