package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fr.diginamic.jdbc.dao.impl.ItemDaoImpl;
import fr.diginamic.jdbc.entites.Item;
import fr.diginamic.jdbc.service.ItemService;

public class ItemServiceImpl implements ItemService {


	@Override
	public List<Item> findAllItem() {
		try {
			ItemDaoImpl itemDao = new ItemDaoImpl();
			return itemDao.extract();
		} catch (Exception e) {
			System.err.println("Erreur SQL : " + e.getMessage());
		}
		return null;
	}

	@Override
	public Item insertItem(Item item) {
		try {
			ItemDaoImpl itemDao = new ItemDaoImpl();
			itemDao.insert(item);
		} catch (SQLException e) {
			System.err.println("Erreur SQL : " + e.getMessage());
		}

		return null;
	}

	@Override
	public void updateItem(String former_name, String new_name) {

		try {
			ItemDaoImpl itemDao = new ItemDaoImpl();
			itemDao.update(former_name, new_name);
		} catch (SQLException e) {
			System.err.println("Erreur SQL : " + e.getMessage());
		}
	}

	@Override
	public void deleteItem(String item_name) {
		try {
			ItemDaoImpl itemDao = new ItemDaoImpl();

			List<Item> result = itemDao.extract();

			for (Item item : result) {
				if (item_name.equals(item.getName())) {
					itemDao.delete(item);
				}
			}
		} catch (SQLException e) {
			System.err.println("Erreur SQL : " + e.getMessage());
		}

	}

	@Override
	public List<Item> findOneItem(String item_name) {

		List<Item> itemsFound = new ArrayList<>();
		try {
			ItemDaoImpl itemDao = new ItemDaoImpl();

			List<Item> result = itemDao.extract();

			for (Item item : result) {

				if (item_name.equals(item.getName())) {
					itemsFound.add(item);
				}
			}

		} catch (SQLException e) {
			System.err.println("Erreur SQL : " + e.getMessage());
		}

		return itemsFound;
	}
}
