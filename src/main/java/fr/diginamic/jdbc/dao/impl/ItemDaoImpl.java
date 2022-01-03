package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.connection.ConnectionBdd;
import fr.diginamic.jdbc.dao.itemDao;
import fr.diginamic.jdbc.entites.Item;

/**
 * 
 * @author Celia Gretillat
 *
 */
public class ItemDaoImpl implements itemDao {

	private Connection connection;
	private Statement smt;
	private PreparedStatement prepareSt;

	public ItemDaoImpl() throws SQLException {

		this.connection = ConnectionBdd.getConnection();
		if (this.connection == null)
			throw new SQLException("non-existent connection");

	}

	@Override
	public List<Item> extract() throws SQLException {

		String sql = "select * from article a inner join fournisseur f on f.ID = a.ID_FOU";
		List<Item> itemList = new ArrayList<>();
		try {
			this.smt = this.connection.createStatement();
			ResultSet result = this.smt.executeQuery(sql);

			while (result.next()) {

				final int id_item = result.getInt("ID");
				final String ref = result.getNString("REF");
				final String name = result.getNString("DESIGNATION");
				final double price = result.getDouble("PRIX");
				final int id_provider = result.getInt("ID_FOU");

				Item item = new Item(id_item, ref, name, price, id_provider);
				itemList.add(item);
			}

			result.close();
			return itemList;

		} finally {
			if (this.smt != null && !this.smt.isClosed())
				this.smt.close();
		}
	}

	@Override
	public void insert(Item item) throws SQLException {

		String sql = "INSERT INTO article(ID, REF, DESIGNATION, PRIX, ID_FOU) VALUES(?,?,?,?,?)";
		try {

			connection.setAutoCommit(false);
			prepareSt = connection.prepareStatement(sql);
			final int id_item = item.getId_item();
			final String ref = item.getRef();
			final String name = item.getName();
			final double price = item.getPrice();
			final int id_provider = item.getId_provider();

			prepareSt.setInt(1, id_item);
			prepareSt.setString(2, ref);
			prepareSt.setString(3, name);
			prepareSt.setDouble(4, price);
			prepareSt.setInt(5, id_provider);
			prepareSt.executeUpdate();
			connection.commit();

		} finally {
			if (this.prepareSt != null && !this.prepareSt.isClosed())
				this.prepareSt.close();
		}

	}

	@Override
	public int update(String former_name, String new_name) throws SQLException {

		String sql = "UPDATE Article SET DESIGNATION = ? WHERE DESIGNATION = ?";

		try {
			connection.setAutoCommit(false);
			prepareSt = connection.prepareStatement(sql);
			String name = new_name;
			String formerName = former_name;

			prepareSt.setString(1, name);
			prepareSt.setString(2, formerName);
			int result = prepareSt.executeUpdate();
			connection.commit();
			return result;
		} finally {
			if (this.prepareSt != null && !this.prepareSt.isClosed())
				this.prepareSt.close();
		}
	}

	@Override
	public boolean delete(Item item) throws SQLException {
		String sql = "DELETE FROM Article WHERE ID = ?";
		try {
			connection.setAutoCommit(false);
			prepareSt = connection.prepareStatement(sql);
			int id = item.getId_item();
			prepareSt.setLong(1, id);
			prepareSt.executeUpdate();
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
	public Item extract_one(int id_item) throws SQLException {

		String sql = "SELECT * FROM article WHERE id =" + id_item;
		ResultSet result = null;

		try {
			this.smt = this.connection.createStatement();
			result = smt.executeQuery(sql);
			if (result.next()) {
				return new Item(result.getInt("ID"), result.getString("REF"), result.getString("DESIGNATION"),
						result.getDouble("PRIX"), result.getInt("ID_FOU"));
			}

		} finally {
			if (result != null && !result.isClosed())
				result.close();
			if (this.smt != null && !this.smt.isClosed())
				this.smt.close();
		}
		return null;

	}

}
