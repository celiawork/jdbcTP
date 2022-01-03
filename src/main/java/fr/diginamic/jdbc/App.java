package fr.diginamic.jdbc;

import java.util.Scanner;

/**
 * La classe App permet d'executer le programme
 * 
 * @version 1.0
 *
 * @author Celia Gretillat.
 */
public class App {

	public static void main(String[] args) {

		Menu menu = new Menu();
		int choice1 = 0;
		int choice2 = 0;
		Scanner scanner = new Scanner(System.in);

		while (choice1 > 5 || choice1 != 5 || choice2 == 6) {

			do {

				// Affichage du menu
				System.out.println();
				System.out.println("||||||||||||||  GESTIONNNAIRE  |||||||||||||| ");

				System.out.println();
				System.out.println("1 - Gérer Fournisseur");
				System.out.println("2 - Gérer Article");
				System.out.println("3 - Gérer Bon");
				System.out.println("4 - Gérer des Compo");
				System.out.println("5 - EXIT");
				System.out.println();
				choice1 = scanner.nextInt();

			} while (choice1 > 5);

			System.out.println();
			System.out.println("|||||||||||||||||||||||||||||||||||||||||||||");
			System.out.println();

			if (choice1 != 4 && choice1 != 5) {

				// Affichage des sous-menu
				System.out.println("Faite votre choix :");
				System.out.println();
				System.out.println("1 - Créer");
				System.out.println("2 - Modifier");
				System.out.println("3 - Supprimer");
				System.out.println("4 - Liste complète");
				System.out.println("5 - Visualisation d'un élément");
				System.out.println("6 - RETOUR");
				System.out.println();
				choice2 = scanner.nextInt();
				System.out.println();
				System.out.println("|||||||||||||||||||||||||||||||||||||||||||||");
			}

			System.out.println();

			// Appel des methodes selon les choix du menu et du sous-menus
			if (choice1 == 1 && choice2 == 1) {
				menu.menuInsertProvider();
			} else if (choice1 == 1 && choice2 == 2) {
				menu.menuUpdateProvider();
			} else if (choice1 == 1 && choice2 == 3) {
				menu.menuDeleteProvider();
			} else if (choice1 == 1 && choice2 == 4) {
				menu.menuFindAllProvider();
			} else if (choice1 == 1 && choice2 == 5) {
				menu.menuFindOneProvider();
			} else if (choice1 == 2 && choice2 == 1) {
				menu.menuInsertItem();
			} else if (choice1 == 2 && choice2 == 2) {
				menu.menuUpdateItem();
			} else if (choice1 == 2 && choice2 == 3) {
				menu.menuDeleteItem();
			} else if (choice1 == 2 && choice2 == 4) {
				menu.menuFindAllItem();
			} else if (choice1 == 2 && choice2 == 5) {
				menu.menuFindOneItem();
			} else if (choice1 == 3 && choice2 == 1) {
				menu.menuInsertOrder();
			} else if (choice1 == 3 && choice2 == 2) {
				menu.menuUpdateOrder();
			} else if (choice1 == 3 && choice2 == 3) {
				menu.menuDeleteOrder();
			} else if (choice1 == 3 && choice2 == 4) {
				menu.menuFindAllOrder();
			} else if (choice1 == 3 && choice2 == 5) {
				menu.menuFindOneOrder();
			} else if (choice1 == 4) {
				menu.menuCreateCompo();
			} else if (choice1 == 5) {
				System.out.println(Graphic.createAscii("A BIENTOT"));
				System.exit(0);
			} else {
				System.out.println("indisponible");
			}
		}

		scanner.close();

	}

}
