package fr.diginamic.jdbc;

import java.util.List;
import java.util.Scanner;
import fr.diginamic.jdbc.entites.Item;
import fr.diginamic.jdbc.entites.Order;
import fr.diginamic.jdbc.entites.Provider;
import fr.diginamic.jdbc.service.ProviderService;
import fr.diginamic.jdbc.service.impl.CompoServiceImpl;
import fr.diginamic.jdbc.service.impl.ItemServiceImpl;
import fr.diginamic.jdbc.service.impl.ProviderServiceImpl;
import fr.diginamic.jdbc.service.impl.orderServiceImpl;

/**
 * Menu est la classe permettant de gérer l'interaction de l'utilisateur avec le
 * menu
 * 
 * @author Celia Gretillat
 *
 */
public class Menu {

	private ProviderService providerservice = new ProviderServiceImpl();
	private ItemServiceImpl itemService = new ItemServiceImpl();
	private orderServiceImpl orderService = new orderServiceImpl();
	private CompoServiceImpl compoService = new CompoServiceImpl();
	private Scanner scanner = new Scanner(System.in);

	/**
	 * Permet de demander le nom du fournisseur à inserer dans la BDD
	 */
	public void menuInsertProvider() {
		String res1;

		System.out.println("Nom du fournisseur à créer : ");
		res1 = scanner.next();
		providerservice.insertProvider(res1);
		System.out.println("Fournisseur ajouté !");
	}

	/**
	 * Permet de demander le nouveau nom et le nom du fournisseur à modifier dans la
	 * BDD
	 */
	public void menuUpdateProvider() {

		String res1;
		String res2;

		System.out.println("Nom du fournisseur à modifier :");
		res1 = scanner.nextLine();
		System.out.println("Nouveau nom : ");
		res2 = scanner.nextLine();
		providerservice.updateProvider(res1, res2);
		System.out.println("Fournisseur modifier !");

	}

	/**
	 * Permet de demander le nom du fournisseur à supprimer dans la BDD
	 */
	public void menuDeleteProvider() {

		String res1;

		System.out.println("Nom du fournisseur à supprimer :");
		res1 = scanner.next();
		providerservice.deleteProvider(res1);
		System.out.println("Fournisseur supprimer !");

	}

	/**
	 * Permet d'afficher la liste de tout les fournisseurs de la BDD
	 */
	public void menuFindAllProvider() {

		List<Provider> result;

		System.out.println("Voici la liste des fournisseurs : ");
		System.out.println();
		result = providerservice.findAllProvider();
		for (Provider provider : result) {
			System.out.println("id : " + provider.getId_provider() + " nom : " + provider.getName());
		}

	}

	/**
	 * Permet de demander le nom du fournisseur afin d'afficher les détails de
	 * celui-ci
	 */
	public void menuFindOneProvider() {

		String res1;
		Provider result;

		System.out.println("Nom du fournisseur à afficher :");
		res1 = scanner.nextLine();
		result = providerservice.findOneProvider(res1);
		System.out.println("Voici les informations du fournisseur : id : " + result.getId_provider() + " nom : "
				+ result.getName());

	}

	/*
	 * Permet de demander les informations nécessaire afin d'enregistrer un article
	 * dans la BDD
	 */
	public void menuInsertItem() {

		String res1;
		String res2;
		int res3;
		int res4;
		Item result;

		System.out.println("Nom de l'article à créer : ");
		res1 = scanner.next();
		System.out.println("Le référence : ");
		res2 = scanner.next();
		System.out.println("Le prix: ");
		res3 = scanner.nextInt();
		System.out.println("L'identification du fournisseur : ");
		res4 = scanner.nextInt();
		result = itemService.insertItem(new Item(0, res2, res1, res3, res4));
		if (result == null) {
			System.out.println("L'article n'a pas pu etre ajouté !");
			System.out.println();
			this.menuInsertItem();
		} else {
			System.out.println("L'article est ajouté !");
		}

	}

	/**
	 * Permet de demander le nom et le nouveau nom de l'article à modifier dans la
	 * BDD
	 */
	public void menuUpdateItem() {

		String res1;
		String res2;

		System.out.println("Nom de l'article à modifier : ");
		res1 = scanner.next();
		System.out.println("Le nouveau nom : ");
		res2 = scanner.next();
		itemService.updateItem(res1, res2);
		System.out.println("Article modifié ! ");

	}

	/**
	 * Permet de demander le nom de l'article à supprimer dans la BDD
	 */
	public void menuDeleteItem() {

		String res1;

		System.out.println("Nom de l'article à supprimer :");
		res1 = scanner.next();
		itemService.deleteItem(res1);
		System.out.println("Article supprimer !");
	}

	/**
	 * Permet d'afficher la liste des articles de la BDD
	 */
	public void menuFindAllItem() {

		List<Item> result;

		System.out.println("Voici la liste des articles : ");
		System.out.println();
		result = itemService.findAllItem();
		for (Item item : result) {
			System.out.println(item.toString());
		}

	}

	/**
	 * Permet de demander le nom de l'article à afficher
	 */
	public void menuFindOneItem() {

		String res1;

		System.out.println("Nom des articles à afficher :");
		res1 = scanner.nextLine();
		System.out.println(itemService.findOneItem(res1));
	}

	/**
	 * Permet de demander les informations nescessaires afin d'inserer un bon dans
	 * la BDD
	 */
	public void menuInsertOrder() {

		int res1;
		int res2;
		int res3;

		System.out.println("Numero de la commande à créer : ");
		res1 = scanner.nextInt();
		System.out.println("Le delai : ");
		res2 = scanner.nextInt();
		System.out.println("L'identification du fournisseur : ");
		res3 = scanner.nextInt();

		orderService.insertOrder(new Order(0, res1, null, res2, res3));
		;
		System.out.println("La commande est ajouté !");
	}

	/**
	 * Permet de demander le numero de commande et le nouveau numero de commande
	 * afin de modifier un bon dans la BDD
	 */
	public void menuUpdateOrder() {

		int res1;
		int res2;

		System.out.println("Numero de la commande à modifier : ");
		res1 = scanner.nextInt();
		System.out.println("Le nouveau numero : ");
		res2 = scanner.nextInt();
		orderService.updateOrder(res1, res2);
		System.out.println("La commande est modifié ! ");
	}

	/**
	 * Permet de demander un numero de commande afin de supprimer un bon
	 */
	public void menuDeleteOrder() {

		int res1;

		System.out.println("Numero de commande à supprimer :");
		res1 = scanner.nextInt();
		orderService.deleteOrder(res1);
		System.out.println("Commande supprimer !");
	}

	/**
	 * Permet d'afficher la liste des bons
	 */
	public void menuFindAllOrder() {

		List<Order> result;

		System.out.println("Voici la liste des commandes : ");
		System.out.println();
		result = orderService.findAllOrder();
		for (Order order : result) {
			System.out.println(order.toString());
		}
	}

	/**
	 * Permet de demander le numero de commande afin d'afficher un bon
	 */
	public void menuFindOneOrder() {

		int res1;

		System.out.println("Numero de la commande à afficher :");
		res1 = scanner.nextInt();
		System.out.println(orderService.findOneOrder(res1));
	}

	/**
	 * Permet de demander le nom d'un article, le numero du bon et la quantité afin
	 * de créer une relation entre des articles et des bons
	 */
	public void menuCreateCompo() {

		String res1;
		String res1_2;
		int res2;
		int res3;
		Item findOneItemInList = null;
		List<Item> result1;

		System.out.println("Pour la création de la compo, saisir le nom de l'article : ");
		res1 = scanner.nextLine();

		result1 = itemService.findOneItem(res1);

		if (result1.size() > 1) {
			System.out.println("Il y a plusieurs articles du meme nom, saisir la référence de l'article à ajouter : ");
			res1_2 = scanner.nextLine();
			for (Item item : result1) {
				if (res1_2.equals(item.getRef())) {
					findOneItemInList = item;
				}
			}
		} else {
			findOneItemInList = result1.get(0);
		}

		System.out.println("Le numéro du bon : ");
		res2 = scanner.nextInt();
		System.out.println("La quantité : ");
		res3 = scanner.nextInt();

		compoService.addCompo(findOneItemInList.getName(), findOneItemInList.getId_item(), res2, res3);
		System.out.println("Compo ajouté !");
	}
}
