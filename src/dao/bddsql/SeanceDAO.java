/**
 * 
 */
package dao.bddsql;

import java.sql.ResultSet;
import java.sql.SQLException;
import classes.CreerSeance;
import classes.Film;
import classes.Seance;
import connection.Connection;
import dao.DAO;
import dao.DAOFactory;

/**
 * Data Access Object SQL for the class Seance, able to find, create, update, delete the class
 * @author Thomas
 */ 
public class SeanceDAO extends DAO<Seance> {
	
	/**
	 * Retrieve the Data in the Database of the class Seance
	 * @author Thomas
	 * @param id : idSeance
	 * @return seance : class Seance
	 * @exception  SQLException : When the query doesn't work
	 */
	@Override 
	public Seance find(int id) {
		
		Seance seance=new Seance();
		int idFilm = 0;
		
		DAO<Film> FilmDAO = DAOFactory.getFilmDAO();
		Film filmT=new Film();
		
		DAO<CreerSeance> CreerSeanceDAO = DAOFactory.getCreerSeanceDAO();
		CreerSeance creerSeanceT=new CreerSeance();
		
		ResultSet result = Connection.selectFrom("SELECT idFilm "
												+ "FROM Seance "
												+ "WHERE idSeance="
												+id
												+";");
		try {
			while(result.next())
			{
				idFilm=result.getInt("idFilm");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		filmT=FilmDAO.find(idFilm);
		creerSeanceT=CreerSeanceDAO.find(id); 

		seance = new Seance(id,idFilm,filmT,creerSeanceT); 
		Connection.close();		
		return seance;
	}

	/**
	 * Create the Data in the Database of the class Seance
	 * @author Thomas
	 * @param obj : class Seance
	 * @return obj : class Seance
	 * @exception  SQLException : When the query doesn't work
	 */
	@Override
	public Seance create(Seance obj) {
		
		Connection.update("INSERT INTO Seance (idFilm) VALUES("+obj.getIdFilm()+")");
		
		ResultSet result = 	Connection.selectFrom("SELECT idSeance FROM Seance;");

		int i = 0;
		try
		{
			result.last();
			i = result.getInt("idSeance");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		obj.setId(i);
		Connection.close();
		return obj;
	}

	/**
	 * Update the Data in the Database of the class Seance
	 * @author Thomas
	 * @param obj : class Seance
	 * @return obj : class Seance
	 */
	@Override
	public Seance update(Seance obj) {
		
		Connection.update("UPDATE Seance SET idFilm ="+obj.getIdFilm()
						  +" WHERE idSeance="+obj.getId()+";");	
		Connection.close();
		return obj;
	}

	/**
	 * Delete the Data in the Database of the class Seance
	 * @author Thomas
	 * @param obj : class Seance
	 */
	@Override
	public void delete(Seance obj) {
		
		Connection.update("DELETE  FROM Seance WHERE idSeance="+obj.getId()+";");	
		Connection.close();
	}

	

}
