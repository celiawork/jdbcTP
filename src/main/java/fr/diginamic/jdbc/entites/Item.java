package fr.diginamic.jdbc.entites;

/**
 * Classe article
 * @author Celia Gretillat
 *
 */
public class Item {

	private int id_item;
	private String ref;
	private String name;
	private double price;
	private int id_provider;

	public Item() {

	}

	public Item(int id_item, String ref, String name, double price, int id_provider) {
		super();
		this.id_item = id_item;
		this.ref = ref;
		this.name = name;
		this.price = price;
		this.id_provider = id_provider;
	}

	public int getId_item() {
		return id_item;
	}

	public void setId_item(int id_item) {
		this.id_item = id_item;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId_provider() {
		return id_provider;
	}

	public void setId_provider(int id_provider) {
		this.id_provider = id_provider;
	}

	@Override
	public String toString() {
		return "[Id de la commande : " + id_item + ", réference : " + ref + ", designation  : " + name + ", prix  : " + price + ", id fournisseur : "
				+ id_provider + "]";
	}

}
