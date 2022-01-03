package fr.diginamic.jdbc.service;

import java.util.List;

import fr.diginamic.jdbc.entites.Provider;

public interface ProviderService {

	/**
	 * Permet de récupérer une liste de fournisseur
	 * 
	 * @return
	 */
	List<Provider> findAllProvider();

	/**
	 * Permet d'ajouter un fournisseur
	 * 
	 * @param name nom du fournisseur à ajouter
	 */
	void insertProvider(String name);

	/**
	 * Permet de modifier le nom d'un fournisseur
	 * 
	 * @param former_name nom du fournisseur à modifier
	 * @param new_name    nouveau nom du fournisseur
	 */
	void updateProvider(String former_name, String new_name);

	/**
	 * Permet de supprimer un fournisseur
	 * 
	 * @param provider_name nom du fournisseur à supprimer
	 */
	void deleteProvider(String provider_name);

	/**
	 * Permet de récupérer un fournisseur
	 * 
	 * @param provider_name nom du fournisseur à récuperer
	 * @return
	 */
	Provider findOneProvider(String provider_name);

}
