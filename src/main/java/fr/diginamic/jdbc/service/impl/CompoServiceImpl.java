package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;
import java.util.List;
import fr.diginamic.jdbc.dao.impl.CompoDaoImpl;
import fr.diginamic.jdbc.entites.Compo;
import fr.diginamic.jdbc.entites.Item;
import fr.diginamic.jdbc.entites.Order;
import fr.diginamic.jdbc.service.CompoService;

public class CompoServiceImpl implements CompoService {

	private ItemServiceImpl itemService = new ItemServiceImpl();
	private orderServiceImpl orderService = new orderServiceImpl();

	@Override
	public boolean addCompo(String item_name, int id_item, int order_number, int qty) {

		List<Item> itemList = itemService.findOneItem(item_name);
		Order order = orderService.findOneOrder(order_number);
		Item item = null;

		try {
			CompoDaoImpl CompoDao = new CompoDaoImpl();

			if (itemList.size() > 1) {

				for (Item item2 : itemList) {
					
					if (item2.getId_item() == id_item) {
						item = item2;
					}
				}

			} else {
				item = itemList.get(0);
			}

			CompoDao.insert(new Compo(0, item.getId_item(), order.getId_order(), qty));

		} catch (SQLException e) {
			System.err.println("Erreur SQL : " + e.getMessage());
		}
		return true;
	}
}
