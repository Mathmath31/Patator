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
 * @author Thomas
 *
 */
public class SeanceDAO extends DAO<Seance> {
	
	@Override 
	/**
	 * Search the Data in the Database 
	 * @author Thomas
	 * @params id = idSeance
	 * @return class Seance
	 */
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
				
		return seance;
	}

	
	@Override
	public Seance create(Seance obj) {
		
		Connection.update("INSERT INTO Seance (idFilm) VALUES("+obj.getIdFilm()+")");
		
		ResultSet result = 	Connection.selectFrom("SELECT idSeance FROM Seance;");

		int i = 0;
		try
		{
			result.last();
			i = result.getInt("idPositionCase");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		obj.setId(i);
		return obj;
	}


	@Override
	public Seance update(Seance obj) {
		
		Connection.update("UPDATE Seance SET idFilm ="+obj.getIdFilm()
						  +" WHERE idSeance="+obj.getId()+";");							
		return obj;
	}

	
	@Override
	public void delete(Seance obj) {
		
		Connection.update("DELETE  FROM Seance WHERE idSeance="+obj.getId()+";");	
	}

	

}
