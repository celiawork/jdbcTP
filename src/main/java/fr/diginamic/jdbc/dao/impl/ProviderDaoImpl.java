package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.connection.ConnectionBdd;
import fr.diginamic.jdbc.dao.ProviderDao;
import fr.diginamic.jdbc.entites.Provider;

/**
 * 
 * @author Celia Gretillat
 *
 */
public class ProviderDaoImpl implements ProviderDao {

	private Connection connection;
	private Statement smt;
	private PreparedStatement prepareSt;

	public ProviderDaoImpl() throws SQLException {
		this.connection = ConnectionBdd.getConnection();
		if (this.connection == null)
			throw new SQLException("non-existent connection");
	}

	@Override
	public List<Provider> extract() throws SQLException {

		String sql = "SELECT id, nom FROM fournisseur";
		List<Provider> providerList = new ArrayList<>();

		try {
			this.smt = this.connection.createStatement();
			ResultSet result = this.smt.executeQuery(sql);

			while (result.next()) {
				final int id = result.getInt("ID");
				final String name = result.getNString("NOM");
				providerList.add(new Provider(id, name));
			}

			result.close();
			return providerList;

		} finally {
			if (this.smt != null && !this.smt.isClosed())
				this.smt.close();
		}
	}

	@Override
	public void insert(Provider provider) throws SQLException {

		String sql = "INSERT INTO fournisseur(nom) VALUES(?)";

		try {

			connection.setAutoCommit(false);
			prepareSt = connection.prepareStatement(sql);
			String name = provider.getName();
			prepareSt.setString(1, name);
			prepareSt.executeUpdate();
			connection.commit();

		} finally {
			if (this.prepareSt != null && !this.prepareSt.isClosed())
				this.prepareSt.close();
		}

	}

	@Override
	public int update(String former_name, String new_name) throws SQLException {

		String sql = "UPDATE FOURNISSEUR SET nom = ? WHERE nom = ?";

		try {

			prepareSt = connection.prepareStatement(sql);
			String name = new_name;
			String formerName = former_name;
			prepareSt.setString(1, name);
			prepareSt.setString(2, formerName);
			int result = prepareSt.executeUpdate();
			return result;

		} finally {
			if (this.prepareSt != null && !this.prepareSt.isClosed())
				this.prepareSt.close();
		}
	}

	@Override
	public boolean delete(Provider provider) throws SQLException {

		String sql = "DELETE FROM FOURNISSEUR WHERE ID = ?";

		try {
			connection.setAutoCommit(false);
			prepareSt = connection.prepareStatement(sql);
			int id = provider.getId_provider();
			prepareSt.setInt(1, id);
			int result = prepareSt.executeUpdate();
			connection.commit();
			if (result > 0)
				return true;
		} finally {
			if (this.prepareSt != null && !this.prepareSt.isClosed())
				this.prepareSt.close();
		}
		return false;
	}

	@Override
	public Provider extract_one(int id_provider) throws SQLException {
		String sql = "SELECT id, nom FROM fournisseur WHERE id =" + id_provider;
		ResultSet result = null;

		try {
			this.smt = this.connection.createStatement();
			result = smt.executeQuery(sql);
			if (result.next()) {
				return new Provider(result.getInt("ID"), result.getString("NOM"));
			}
			return null;

		} finally {
			if (result != null && !result.isClosed())
				result.close();
			if (this.smt != null && !this.smt.isClosed())
				this.smt.close();
		}

	}

}
