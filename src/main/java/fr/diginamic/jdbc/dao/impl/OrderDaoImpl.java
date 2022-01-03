package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.connection.ConnectionBdd;
import fr.diginamic.jdbc.dao.orderDao;
import fr.diginamic.jdbc.entites.Order;

/**
 * 
 * @author Celia Gretillat
 *
 */
public class OrderDaoImpl implements orderDao {

	private Connection connection;
	private Statement smt;
	private PreparedStatement prepareSt;

	public OrderDaoImpl() throws SQLException {
		this.connection = ConnectionBdd.getConnection();
		if (this.connection == null)
			throw new SQLException("non-existent connection");
	}

	@Override
	public List<Order> extract() throws SQLException {

		String sql = "SELECT * FROM bon;";
		List<Order> orderList = new ArrayList<>();

		try {
			this.smt = this.connection.createStatement();
			ResultSet result = this.smt.executeQuery(sql);

			while (result.next()) {

				final int id_order = result.getInt("ID");
				final int number = result.getInt("NUMERO");
				final LocalDateTime date_order = java.time.LocalDateTime.now();
				final int time_limit = result.getInt("DELAI");
				final int id_provider = result.getInt("ID_FOU");

				Order item = new Order(id_order, number, date_order, time_limit, id_provider);
				orderList.add(item);
			}

			result.close();
			return orderList;

		} finally {
			if (this.smt != null && !this.smt.isClosed())
				this.smt.close();
		}
	}

	@Override
	public void insert(Order order) throws SQLException {

		String sql = "INSERT INTO bon(ID, NUMERO, DATE_CMDE, DELAI, ID_FOU) VALUES(?,?,CURRENT_TIMESTAMP,?,?)";
		try {
			connection.setAutoCommit(false);
			prepareSt = connection.prepareStatement(sql);
			final int id_order = order.getId_order();
			final int number = order.getNumber();
			final int time_limit = order.getTime_limit();
			final int id_provider = order.getId_provider();
			prepareSt.setInt(1, id_order);
			prepareSt.setInt(2, number);
			prepareSt.setDouble(3, time_limit);
			prepareSt.setInt(4, id_provider);
			prepareSt.executeUpdate();
			connection.commit();

		} finally {
			if (this.prepareSt != null && !this.prepareSt.isClosed())
				this.prepareSt.close();
		}
	}

	@Override
	public int update(int former_numero, int new_numero) throws SQLException {

		String sql = "UPDATE bon SET numero = ? WHERE numero = ?";

		try {
			connection.setAutoCommit(false);
			prepareSt = connection.prepareStatement(sql);
			int newId = new_numero;
			int formerId = former_numero;

			prepareSt.setInt(1, newId);
			prepareSt.setInt(2, formerId);
			int result = prepareSt.executeUpdate();
			connection.commit();
			return result;

		} finally {
			if (this.prepareSt != null && !this.prepareSt.isClosed())
				this.prepareSt.close();
		}

	}

	@Override
	public boolean delete(Order order) throws SQLException {

		String sql = "DELETE FROM bon WHERE NUMERO = ?";

		try {
			connection.setAutoCommit(false);
			prepareSt = connection.prepareStatement(sql);
			int numero = order.getNumber();
			prepareSt.setInt(1, numero);
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
	public Order extract_one(int numero_order) throws SQLException {
		String sql = "SELECT id, numero FROM bon WHERE numero =" + numero_order;
		ResultSet result = null;

		try {
			this.smt = this.connection.createStatement();
			result = smt.executeQuery(sql);
			if (result.next()) {
				return new Order();
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
