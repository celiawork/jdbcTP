package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;
import fr.diginamic.jdbc.entites.Order;

/**
 * 
 * @author Celia Gretillat
 *
 */
public interface orderDao {

	/**
	 * Permet de récupérer tout les bons de commande de la BDD
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<Order> extract() throws SQLException;

	/**
	 * Permet d'inserer un bon de commande dans la BDD
	 * 
	 * @param order le bon à insérer
	 * @throws SQLException
	 */
	void insert(Order order) throws SQLException;

	/**
	 * Permet de modifier un bon de commande dans la BDD
	 * 
	 * @param former_numero numero du bon à modifier
	 * @param new_numero    nouveau numero de bon
	 * @return retourne le nombre d'enregistrement
	 * @throws SQLException
	 */
	int update(int former_numero, int new_numero) throws SQLException;

	/**
	 * Permet de supprimer un bon de commande dans la BDD
	 * 
	 * @param order bon de commande à suppimer
	 * @return retourne un booleen si la suppression a bien été faite
	 * @throws SQLException
	 */
	boolean delete(Order order) throws SQLException;

	/**
	 * Permet de récupérer un bon de commande dans la BDD
	 * 
	 * @param id_order id du bon à récupérer
	 * @return retourne le bon
	 * @throws SQLException
	 */
	Order extract_one(int id_order) throws SQLException;
}
