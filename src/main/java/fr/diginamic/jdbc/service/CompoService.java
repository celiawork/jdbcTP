package fr.diginamic.jdbc.service;

public interface CompoService {

	/**
	 * Permet d'ajouter une compo 
	 * @param item_name nom de l'article
	 * @param id_item id de l'article
	 * @param order_number numero du bon de commande
	 * @param qty quantité d'article
	 * @return
	 */
	public boolean addCompo(String item_name, int id_item, int order_number, int qty);
}
