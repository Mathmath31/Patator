package test;


import classes.Produit;
import dao.DAO;
import dao.DAOFactory;

public class TestProduit {

	public static void main(String[] args) {
		DAO<Produit> ProduitDAO = DAOFactory.getProduitDAO();

		  
		Produit produit=new Produit();
		 
		produit.setNomProduit("Soda Cola 50 cl");
		produit.setDescriptionProduit("Au bon goût de cola, plein de bulles");
		produit.setPrixProduit(3.5);
		
		produit=ProduitDAO.create(produit);
		
		
		produit.setNomProduit("Eau plate 50 cl");
		produit.setDescriptionProduit("En direct des valléees des volcans");
		produit.setPrixProduit(1.5);
		
		produit=ProduitDAO.create(produit);
		
		produit.setNomProduit("Bonbons 200 gr");
		produit.setDescriptionProduit("Hum du sucre !");
		produit.setPrixProduit(4.5);
		
		produit=ProduitDAO.create(produit);
		
		produit.setNomProduit("Popcorn 600 gr");
		produit.setDescriptionProduit("Le classique à ne jamais oublier");
		produit.setPrixProduit((double) 6);
		
		produit=ProduitDAO.create(produit);
		
		
		
	}

}
