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
 * Data Access Object SQL for the class Film, able to find, create, update, delete the class
 * @author Thomas
 */ 
public class FilmDAO extends DAO<Film>{
	
	/**
	 * Create the Data in the Database of the class Film
	 * @author Thomas
	 * @param obj : class Film
	 * @return obj : class Film
	 * @exception  SQLException : When the query doesn't work
	 */
	public Film create(Film obj) {
		
		Connection.update("INSERT INTO film (codeFilm,nomFilm) VALUES('"
						  +obj.getCodeFilm() +"','"
						  +obj.getNomFilm() +"')");
		
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
		Connection.close();
		return obj;
	}
	
	/**
	 * Retrieve the Data in the Database of the class Film
	 * @author Thomas
	 * @param id : idFilm
	 * @return film : class Film
	 * @exception  SQLException : When the query doesn't work
	 */
	public Film find(int id) {
		
		String codeFilm = null;
		String nomFilm = null;
		Film film = new Film();
		
		try {
			ResultSet result = Connection.selectFrom("SELECT codeFilm, nomFilm "
													+ "FROM film "
													+ "WHERE idFilm="
													+id
													+";");
			
			while(result.next())
			{
				codeFilm = result.getString("codeFilm");
				nomFilm = result.getString("nomFilm");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		film = new Film(id,codeFilm,nomFilm);
		Connection.close();
		return film;
	}

	/**
	 * Update the Data in the Database of the class Film
	 * @author Thomas
	 * @param obj : class Film
	 * @return obj : class Film
	 */
	public Film update(Film obj) {
		
		Connection.update("UPDATE film SET codeFilm ='"+obj.getCodeFilm()+"','"
													   +obj.getNomFilm()
														+"' WHERE idFilm="
														+obj.getId()
														+";");
		Connection.close();
		return obj;
	}

	/**
	 * Delete the Data in the Database of the class Film
	 * @author Thomas
	 * @param obj : class Film
	 */
	public void delete(Film obj) {
		
		Connection.update("DELETE  FROM film WHERE idFilm="
						  +obj.getId()
						  +";");
		Connection.close();
	}
}
