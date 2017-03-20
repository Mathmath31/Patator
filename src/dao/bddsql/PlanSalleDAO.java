package dao.bddsql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import classes.CaseSalle;
import classes.PlanSalle;
import connection.Connection;
import dao.DAO;
import dao.DAOFactory;

/**
 * @author Thomas
 *
 */

public class PlanSalleDAO extends DAO<PlanSalle> {

	@Override
	public PlanSalle find(int id) {

		PlanSalle Salle=new PlanSalle();
		
		DAO <CaseSalle> CaseSalleDAO = DAOFactory.getCaseSalleDAO();
		ArrayList<CaseSalle> cases=new ArrayList<CaseSalle>();

		String nomPlanSalle=null;
		String numPlanSalle=null;
		
		int idCinema=0;
		int[] idcases = new int[200];
		int i=0;
		int j=0;

		ResultSet rs = Connection.selectFrom("SELECT nomPlanSalle,numPlanSalle,idCinema "
											 + "FROM PlanSalle "
											 + "WHERE idPlanSalle = " + id +";");
		try {
			while(rs.next())
			{
				nomPlanSalle = rs.getString("nomPlanSalle");
				numPlanSalle=rs.getString("numPlanSalle");
				idCinema=rs.getInt("idCinema");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//Recherche du nombre de cases
		ResultSet result2 = Connection.selectFrom("SELECT idCaseSalle "
												  + "FROM CaseSalle "
												  + "WHERE "
												  + "idPlanSalle="
												  +id
												  +";");

		//Recuperation des id des cases
		try {
			while(result2.next())
			{
				idcases[i]=result2.getInt("idCaseSalle");
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		

		for(j=0;j<i;j++)
		{
			cases.add(CaseSalleDAO.find(idcases[j]));
		}

	
		
		
		//if(nome != null && numt != null && mel != null)
		//{
		Salle = new PlanSalle(id,nomPlanSalle,numPlanSalle,idCinema,cases); 
		//}

		return Salle;
	}

	@Override
	public PlanSalle create(PlanSalle obj) {

		Connection.update("INSERT INTO PlanSalle (nomPlanSalle,numPlanSalle,idCinema) VALUES( '"
					   	  +obj.getNomPlanSalle() + "','"
						  +obj.getNumPlanSalle()+"',"	
						  +obj.getIdCinema()+")");

		ResultSet result = Connection.selectFrom("SELECT idPlanSalle "
											   	 + "FROM PlanSalle "
												 +";");
		int i = 0;
		try
		{
			result.last();
			i = result.getInt("idPlanSalle");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		obj.setId(i);

		return obj;
	}

	@Override
	public PlanSalle update(PlanSalle obj) {

	
		Connection.update("UPDATE PlanSalle SET "
				          + "nomPlanSalle ='" + obj.getNomPlanSalle()
						  +"',numPlanSalle='" + obj.getNumPlanSalle()
						  +"',idCinema="  + obj.getIdCinema()
						  +" WHERE idPlanSalle=" + obj.getId() + ";");        
		return obj;
	}

	@Override
	public void delete(PlanSalle obj) {

		Connection.update("DELETE  FROM PlanSalle WHERE idPlanSalle ="
						  +obj.getId()
						  +";");
	}
	
	
}