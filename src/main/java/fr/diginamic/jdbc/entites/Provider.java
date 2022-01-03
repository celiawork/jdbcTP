package fr.diginamic.jdbc.entites;

/**
 * Classe fournisseur
 * @author Celia Gretillat
 *
 */
public class Provider {

	private int id_provider;
	private String name;

	public Provider() {

	}

	public Provider(int id_provider, String name) {
		super();
		this.id_provider = id_provider;
		this.name = name;
	}

	public int getId_provider() {
		return id_provider;
	}

	public void setId_provider(int id_provider) {
		this.id_provider = id_provider;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "[Id du fournisseur : " + id_provider + ", nom : " + name + "\n]";
	}

}
