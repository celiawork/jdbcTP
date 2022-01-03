package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import fr.diginamic.jdbc.connection.ConnectionBdd;
import fr.diginamic.jdbc.dao.CompoDao;
import fr.diginamic.jdbc.entites.Compo;

/**
 * 
 * @author Celia Gretillat
 *
 */
public class CompoDaoImpl implements CompoDao {

	private Connection connection;
	private PreparedStatement prepareSt;

	public CompoDaoImpl() throws SQLException {

		this.connection = ConnectionBdd.getConnection();
		if (this.connection == null)
			throw new SQLException("non-existent connection");
	}

	@Override
	public void insert(Compo compo) throws SQLException {

		String sql = "INSERT INTO compo(ID, ID_ART, ID_BON, QTE) VALUES (?,?,?,?)";

		try {
			connection.setAutoCommit(false);
			prepareSt = connection.prepareStatement(sql);
			final int id_compo = compo.getId_compo();
			final int id_art = compo.getId_item();
			final int id_bon = compo.getId_order();
			final int quantite = compo.getQuantity();

			prepareSt.setInt(1, id_compo);
			prepareSt.setInt(2, id_art);
			prepareSt.setInt(3, id_bon);
			prepareSt.setInt(4, quantite);

			prepareSt.executeUpdate();
			connection.commit();

		} finally {
			if (this.prepareSt != null && !this.prepareSt.isClosed())
				this.prepareSt.close();
		}
	}

}
