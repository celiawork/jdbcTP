package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;
import java.util.List;
import fr.diginamic.jdbc.dao.impl.OrderDaoImpl;
import fr.diginamic.jdbc.entites.Order;
import fr.diginamic.jdbc.service.OrderService;

public class orderServiceImpl implements OrderService {


	@Override
	public List<Order> findAllOrder() {
		try {
			OrderDaoImpl orderDao = new OrderDaoImpl();
			return orderDao.extract();
		} catch (SQLException e) {
			System.err.println("Erreur SQL : " + e.getMessage());
		}
		return null;

	}

	@Override
	public void insertOrder(Order order) {

		try {
			OrderDaoImpl orderDao = new OrderDaoImpl();
			orderDao.insert(order);
			;
		} catch (SQLException e) {
			System.err.println("Erreur SQL : " + e.getMessage());
		}

	}

	@Override
	public void updateOrder(int former_number, int new_number) {
		try {
			OrderDaoImpl orderDao = new OrderDaoImpl();
			orderDao.update(former_number, new_number);
		} catch (SQLException e) {
			System.err.println("Erreur SQL : " + e.getMessage());
		}

	}

	@Override
	public void deleteOrder(int order_numero) {
		try {

			OrderDaoImpl orderDao = new OrderDaoImpl();
			List<Order> result = orderDao.extract();

			for (Order order : result) {
				if (order_numero == order.getNumber()) {
					orderDao.delete(order);
				}
			}
		} catch (SQLException e) {
			System.err.println("Erreur SQL : " + e.getMessage());
		}
	}

	@Override
	public Order findOneOrder(int order_numero) {
		try {
			OrderDaoImpl orderDao = new OrderDaoImpl();
			List<Order> result = orderDao.extract();
			for (Order order : result) {
				if (order_numero == order.getNumber()) {
					return order;
				}
			}
		} catch (SQLException e) {
			System.err.println("Erreur SQL : " + e.getMessage());
		}

		return null;
	}
}
