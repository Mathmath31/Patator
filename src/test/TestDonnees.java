package test;

import java.util.Scanner;

import classes.Donnees;

public class TestDonnees {

	public static void main(String[] args) {
		
		String login = null;
		String mdp = null;
		
		Scanner sc = new Scanner(System.in);
		Donnees donnees= new Donnees();
				
		System.out.println("Entrez login: ");
		login=sc.nextLine();
		System.out.println(login);
		System.out.println("Entrez mdp: ");
		mdp=sc.nextLine();
		System.out.println(mdp);
		
		sc.close();
		
		
		donnees.connection(login, mdp);
		
		if (donnees.isConnect�() == true){
			System.out.println("Connect�");
			//System.out.println(donnees.getCinemas().get(0).toString());
		}
		
		
	}

}
