/**
 * 
 */
package dao;


import classes.CaseSalle;
import classes.Cinema;
import classes.PlanSalle;
import classes.PositionCase;
import classes.TypeCase;
import classes.Ville;
import dao.bddsql.CaseSalleDAO;
import dao.bddsql.CinemaDAO;
import dao.bddsql.PlanSalleDAO;
import dao.bddsql.PositionCaseDAO;

import dao.bddsql.TypeCaseDAO;
import dao.bddsql.VilleDAO;

/**
 * @author thomas
 *
 */
public class DAOFactory {
	
	public static DAO<PositionCase> getPositionCaseDAO(){
		return new PositionCaseDAO();
	}
	
	public static DAO<TypeCase> getTypeCaseDAO(){
		return new TypeCaseDAO();
	}
	
	public static DAO<CaseSalle> getCaseSalleDAO(){
		return new CaseSalleDAO();
	}

	public static DAO<PlanSalle> getPlanSalleDAO(){
		return new PlanSalleDAO();
	}

	
	public static DAO<Ville> getVilleDAO(){
		return new VilleDAO();
	}

	public static DAO<Cinema> getCinemaDAO(){
		return new CinemaDAO();
	}

}
