/**
 * 
 */
package dao.bddsql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.PlanSalle;
import classes.Ville;
import classes.Cinema;
import connection.Connection;
import dao.DAO;
import dao.DAOFactory;

/**
 * @author thomas
 *
 */
public class CinemaDAO extends DAO<Cinema> {

	@Override
	public Cinema find(int id) {

		Cinema Cine=new Cinema();
		
		DAO <PlanSalle> PlanSalleDAO = DAOFactory.getPlanSalleDAO();
		ArrayList<PlanSalle> salles=new ArrayList<PlanSalle>();
		
		DAO <Ville> VilleDAO = DAOFactory.getVilleDAO();
		Ville villeCine = new Ville();

		String nomCine=null;
		String nVoieCine=null;
		int idVille=0;
		

		int[] idSalles = new int[200];
		int i=0;
		int j=0;
		
	

		ResultSet rs = Connection.selectFrom("SELECT nomCine,nVoieCine,idVille "
											 + "FROM Cinema "
											 + "WHERE idCinema = " + id +";");

		try {
			while(rs.next())
			{
				nomCine = rs.getString("nomCine");
				nVoieCine=rs.getString("nVoieCine");
				idVille=rs.getInt("idVille");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		villeCine=VilleDAO.find(idVille); 

		//Recherche du nombre de cases
		ResultSet result2 = Connection.selectFrom("SELECT idPlanSalle "
												  + "FROM PlanSalle "
												  + "WHERE "
												  + "idCinema="
												  +id
												  +";");

		//Recuperation des id des salles
		try {
			while(result2.next())
			{
				idSalles[i]=result2.getInt("idPlanSalle");
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		

		for(j=0;j<i;j++)
		{
			salles.add(PlanSalleDAO.find(idSalles[j]));
		}

	
		
		
		//if(nome != null && numt != null && mel != null)
		//{
		Cine = new Cinema(id,nomCine,nVoieCine,idVille,villeCine,salles); 
		//}

		return Cine;
	}

	@Override
	public Cinema create(Cinema obj) {

		Connection.update("INSERT INTO Cinema (nomCine,nVoieCine,idVille) VALUES('', '"
					   	  +obj.getNomCine() + "','"
						  +obj.getnVoieCine()+"',"	
						  +obj.getIdVille()+")");

		ResultSet result = Connection.selectFrom("SELECT idCinema "
											   	 + "FROM Cinema "
												 +";");
		int i = 0;
		try
		{
			result.last();
			i = result.getInt("idCinema");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		obj.setId(i);

		return obj;
	}

	@Override
	public Cinema update(Cinema obj) {

	
		Connection.update("UPDATE Cinema SET "
				          + "nomCine ='" + obj.getNomCine()
						  +"',nVoieCine='" + obj.getnVoieCine()
						  +"',idVille="  + obj.getIdVille()
						  +" WHERE idCinema=" + obj.getId() + ";");        
		return obj;
	}

	@Override
	public void delete(Cinema obj) {
	
		Connection.update("DELETE * FROM Cinema WHERE idCinema ="
						  +obj.getId()
						  +";");
	}
	
	
	
}