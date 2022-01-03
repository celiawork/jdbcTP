package fr.diginamic.jdbc.service;

import java.util.List;

import fr.diginamic.jdbc.entites.Order;

public interface OrderService {

	/**
	 * Permet de récupérer une liste de bon de commande
	 * @return
	 */
	List<Order> findAllOrder();
	
	/**
	 * Permet d'ajouter un bon de commande 
	 * @param order le bon de commande à insérer
	 */
	void insertOrder(Order order);
	
	/**
	 * Permet de modifier le numero du bon de commande
	 * @param former_number le numero du bon de commande à modifier
	 * @param new_number le nouveau numero de bon de commande
	 */
	void updateOrder(int former_number, int new_number);
	
	/**
	 * Permet de supprimer un bon de commande
	 * @param order_numero numero de commande à supprimer
	 */
	void deleteOrder(int order_numero);
	
	/**
	 * Permet de récupérer un bon de commande
	 * @param order_numero numero du bon de commande à récupérer
	 * @return
	 */
	Order findOneOrder(int order_numero);
}
