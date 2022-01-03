package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.dao.impl.ProviderDaoImpl;
import fr.diginamic.jdbc.entites.Provider;
import fr.diginamic.jdbc.service.ProviderService;

public class ProviderServiceImpl implements ProviderService {

	Provider provider = new Provider();

	@Override
	public List<Provider> findAllProvider() {
		try {
			ProviderDaoImpl providerDao = new ProviderDaoImpl();
			return providerDao.extract();
		} catch (SQLException e) {
			System.err.println("Erreur SQL : " + e.getMessage());
		}
		return null;

	}

	@Override
	public void insertProvider(String name) {
		provider.setName(name);
		try {
			ProviderDaoImpl providerDao = new ProviderDaoImpl();
			providerDao.insert(provider);
		} catch (SQLException e) {
			System.err.println("Erreur SQL : " + e.getMessage());
		}
	}

	@Override
	public void updateProvider(String former_name, String new_name) {

		try {
			ProviderDaoImpl providerDao = new ProviderDaoImpl();
			providerDao.update(former_name, new_name);
		} catch (SQLException e) {
			System.err.println("Erreur SQL : " + e.getMessage());
		}

	}

	@Override
	public void deleteProvider(String provider_name) {

		try {
			ProviderDaoImpl providerDao = new ProviderDaoImpl();
			providerDao.delete(this.findOneProvider(provider_name));
		} catch (SQLException e) {
			System.err.println("Erreur SQL : " + e.getMessage());
		}

	}

	@Override
	public Provider findOneProvider(String provider_name) {

		try {
			ProviderDaoImpl providerDao = new ProviderDaoImpl();
			List<Provider> result = providerDao.extract();
			for (Provider provider : result) {
				if (provider_name.equals(provider.getName())) {
					return provider;
				}
			}
		} catch (SQLException e) {
			System.err.println("Erreur SQL : " + e.getMessage());
		}

		return null;
	}
}
