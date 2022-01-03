package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;
import fr.diginamic.jdbc.entites.Item;

/**
 * 
 * @author Celia Gretillat
 *
 */
public interface itemDao {

	/**
	 * Permet de récupérer tout les articles de la BDD
	 * 
	 * @return retourne une liste d'article
	 * @throws SQLException
	 */
	List<Item> extract() throws SQLException;

	/**
	 * Permet d'inserer un article dans la BDD
	 * 
	 * @param item article à insérer
	 * @throws SQLException
	 */
	void insert(Item item) throws SQLException;

	/**
	 * Permet de modifier un article dans la BDD
	 * 
	 * @param former_name Le nom de l'article à modifier
	 * @param new_name    Le nouveau nom pour l'article
	 * @return retourne le nombre d'enregistrement
	 * @throws SQLException
	 */
	int update(String former_name, String new_name) throws SQLException;

	/**
	 * Permet de supprimer un article dans la BDD
	 * 
	 * @param item article à supprimer
	 * @return retourne un booleen si la suppression a bien été faite
	 * @throws SQLException
	 */
	boolean delete(Item item) throws SQLException;

	/**
	 * Permet de récupérer un article dans la BDD
	 * 
	 * @param id_item id de l'article à récupérer
	 * @return retourne l'article
	 * @throws SQLException
	 */
	Item extract_one(int id_item) throws SQLException;

}
