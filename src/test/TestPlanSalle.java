package test;

import classes.CaseSalle;
import classes.PlanSalle;
import dao.DAO;
import dao.DAOFactory;

public class TestPlanSalle {

	public static void main(String[] args) {
		
		PlanSalle planSalleEnCours= new PlanSalle();
		
		DAO<PlanSalle> PlanSalleDAO = DAOFactory.getPlanSalleDAO();
		DAO<CaseSalle> CaseSalleDAO = DAOFactory.getCaseSalleDAO();
		planSalleEnCours.setIdCinema(1);
		planSalleEnCours.setNomPlanSalle("bob");
		planSalleEnCours=PlanSalleDAO.create(planSalleEnCours);

		System.out.println(planSalleEnCours.toString());
	}

}
