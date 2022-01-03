package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entites.Provider;

/**
 * 
 * @author Celia Gretillat
 *
 */
public interface ProviderDao {

	/**
	 * Permet de récupérer tout les fournisseurs de la BDD
	 * 
	 * @return
	 * @throws SQLException
	 */
	List<Provider> extract() throws SQLException;

	/**
	 * Permet d'inserer un bon de commande dans la BDD
	 * 
	 * @param provider
	 * @throws SQLException
	 */
	void insert(Provider provider) throws SQLException;

	/**
	 * Permet de modifier un fournisseur de la BDD
	 * 
	 * @param former_name le nom du fournisseur à modifier
	 * @param new_name    le nouveau nom du fournisseur
	 * @return retourne le nombre d'enregistrement
	 * @throws SQLException
	 */
	int update(String former_name, String new_name) throws SQLException;

	/**
	 * 
	 * @param provider fournisseur à supprimer
	 * @return retourne un booleen si la suppression a bien été faite
	 * @throws SQLException
	 */
	boolean delete(Provider provider) throws SQLException;

	/**
	 * Permet de récupérer un fournisseur dans la BDD
	 * 
	 * @param id_provider id du fournisseur à récupérer
	 * @return retourne le fournisseur
	 * @throws SQLException
	 */
	Provider extract_one(int id_provider) throws SQLException;

}
