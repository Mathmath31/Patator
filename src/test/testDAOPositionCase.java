package test;

import java.util.ArrayList;

import classes.PositionCase;
import dao.DAO;
import dao.DAOFactory;

public class testDAOPositionCase {
	
	public static void main(String[] args) {
		
		DAO<PositionCase> PositionCaseDAO = DAOFactory.getPositionCaseDAO();
		ArrayList<PositionCase> posCase=new ArrayList<PositionCase>();
		System.out.println("\n Avant création d'un objet positionCase :");
		
		
//		for(int i = 1; i <20; i++)
//		{
//			if(PositionCaseDAO.find(i).getPosX() != 0 && PositionCaseDAO.find(i).getPosY() != 0){
//				System.out.println(PositionCaseDAO.find(i).toString());
//				posCase.add(PositionCaseDAO.find(i));
//			}
//				
//		}
		
		
		/*PositionCase posCasse = new PositionCase();
		for (int j=0; j<50; j++){
			for (int k=0; k<50; k++){
				posCasse.setPosX(j);
				posCasse.setPosY(k);
				PositionCaseDAO.create(posCasse);
			}
		}*/
//		PositionCase ad = new PositionCase();
	
//		ad.setPosX(35);
//		ad.setPosY(28);
//		
//		ad = PositionCaseDAO.create(ad);
//		
//		posCase.add(ad);
		
		
		System.out.println("\n Après création d'un nouveau langage :");
		for(PositionCase o : posCase){
			System.out.println(PositionCaseDAO.find(o.getId()).toString());
		}
		

//		
//		
//		
//		System.out.println("\n Après mise à jour de l'objet langage :");
//		for(int i = 1; i < 5; i++)
//		System.out.println(PositionCaseDAO.find(i).toString());
//		
//		PositionCaseDAO.delete(ad);
//		System.out.println("\n Après suppression l'objet langage :");
//		for(int i = 1; i < 5; i++)
//		System.out.println(PositionCaseDAO.find(i).toString());
//		
//		
//		System.out.println("Nonononono nonnononononon");
//		for(PositionCase b:addss)
//		{
//			System.out.println(b.toString());
//		}
	}

}
