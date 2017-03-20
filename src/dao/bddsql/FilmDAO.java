/**
 * 
 */
package dao.bddsql;
import java.sql.ResultSet;
import java.sql.SQLException;
import classes.Film;
import connection.Connection;
import dao.DAO;
/**
 * @author Thomas
 *
 */
public class FilmDAO extends DAO<Film>{

public Film create(Film obj) {
		
		Connection.update("INSERT INTO film (codeFilm) VALUES('"
						  +obj.getCodeFilm()+"')");
		
		ResultSet result = 	Connection.selectFrom("SELECT idFilm "
				+ "FROM film "
				+";");

		int i = 0;
		try
		{
			result.last();
			i = result.getInt("idFilm");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		obj.setId(i);
		
		return obj;
	}
	
	
	public Film find(int id) {
		
		String codeFilm = null;
		Film film = new Film();
		
		try {
			ResultSet result = Connection.selectFrom("SELECT codeFilm "
													+ "FROM film "
													+ "WHERE idFilm="
													+id
													+";");
			
			while(result.next())
			{
				codeFilm = result.getString("codeFilm");				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		film = new Film(id,codeFilm);
		
		return film;
	}

	
	public Film update(Film obj) {
		
		Connection.update("UPDATE film SET posXPositionCase ='"+obj.getCodeFilm()							
														+"' WHERE idFilm="
														+obj.getId()
														+";");	
		return obj;
	}

	
	public void delete(Film obj) {
		
		Connection.update("DELETE  FROM film WHERE idFilm="
						  +obj.getId()
						  +";");
	}
}