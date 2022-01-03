package fr.diginamic.jdbc.service;

import java.util.List;

import fr.diginamic.jdbc.entites.Item;

/**
 * 
 * @author Celia Gretillat
 *
 */
public interface ItemService {

	/**
	 * Permet de récupérer une liste d'article
	 * 
	 * @return
	 */
	List<Item> findAllItem();

	/**
	 * Permet d'inserer un article dans la BDD
	 * 
	 * @param item l'article à insérer
	 * @return
	 */
	Item insertItem(Item item);

	/**
	 * Permet de modifier le nom de l'article
	 * 
	 * @param former_name le nom de l'article à modifier
	 * @param new_name    le nouveau nom de l'article
	 */
	void updateItem(String former_name, String new_name);

	/**
	 * Permet de supprimer un article
	 * 
	 * @param item_name id de l'article à supprimer
	 */
	void deleteItem(String item_name);

	/**
	 * Permet de récupérer un article
	 * 
	 * @param item_name le nom de l'article à récuperer
	 * @return
	 */
	List<Item> findOneItem(String item_name);
}
