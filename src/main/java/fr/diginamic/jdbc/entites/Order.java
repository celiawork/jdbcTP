package fr.diginamic.jdbc.entites;
import java.time.LocalDateTime;

/**
 * Classe bon de commande
 * @author Celia Gretillat
 *
 */
public class Order {

	private int id_order;
	private int number;
	private LocalDateTime date_order;
	private int time_limit;
	private int id_provider;

	public Order() {

	}

	public Order(int id_order, int number, LocalDateTime date_order, int time_limit, int id_provider) {
		super();
		this.id_order = id_order;
		this.number = number;
		this.date_order = date_order;
		this.time_limit = time_limit;
		this.id_provider = id_provider;
	}

	public int getId_order() {
		return id_order;
	}

	public void setId_order(int id_order) {
		this.id_order = id_order;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public LocalDateTime getDate_order() {
		return date_order;
	}

	public void setDate_order(LocalDateTime date_order) {
		this.date_order = date_order;
	}

	public int getTime_limit() {
		return time_limit;
	}

	public void setTime_limit(int time_limit) {
		this.time_limit = time_limit;
	}

	public int getId_provider() {
		return id_provider;
	}

	public void setId_provider(int id_provider) {
		this.id_provider = id_provider;
	}

	@Override
	public String toString() {
		return "[Id commande : " + id_order + ", numéro : " + number + ", date de la commande : " + date_order + ", delai : "
				+ time_limit + ", id fornisseur : " + id_provider + "]";
	}
	
	

}



