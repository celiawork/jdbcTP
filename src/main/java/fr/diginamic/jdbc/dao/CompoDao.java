package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import fr.diginamic.jdbc.entites.Compo;

/**
 * 
 * @author Celia Gretillat
 *
 */
public interface CompoDao {

	/**
	 * Permet d'insérer dans la BDD une relation entre le bon et l'article avec une
	 * quantité
	 * 
	 * @param compo contient id de l'article, l'id du bon et la quantité
	 * @throws SQLException
	 */
	void insert(Compo compo) throws SQLException;
}
