package fr.diginamic.jdbc.entites;

/**
 * Classe Compo
 * @author Celia Gretillat
 *
 */
public class Compo {

	private int id_compo;
	private int id_item;
	private int id_order;
	private int quantity;

	public Compo() {

	}

	public Compo(int id_compo, int id_item, int id_order, int quantity) {
		this.id_compo = id_compo;
		this.id_item = id_item;
		this.id_order = id_order;
		this.quantity = quantity;
	}

	public int getId_compo() {
		return id_compo;
	}

	public void setId_compo(int id_compo) {
		this.id_compo = id_compo;
	}

	public int getId_item() {
		return id_item;
	}

	public void setId_item(int id_item) {
		this.id_item = id_item;
	}

	public int getId_order() {
		return id_order;
	}

	public void setId_order(int id_order) {
		this.id_order = id_order;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Compo [id_compo=" + id_compo + ", id_item=" + id_item + ", id_order=" + id_order + ", quantity="
				+ quantity + "]";
	}
	
	

}



