package models;
// Generated 09-feb-2017 13:27:33 by Hibernate Tools 4.3.1.Final

/**
 * Inventario generated by hbm2java
 */
public class Inventario implements java.io.Serializable {

	private Integer idInventario;
	private Barco barco;
	private Mercancia mercancia;
	private int cantidad;
	private double peso;

	public Inventario() {
	}

	public Inventario(Barco barco, Mercancia mercancia, int cantidad, double peso) {
		this.barco = barco;
		this.mercancia = mercancia;
		this.cantidad = cantidad;
		this.peso = peso;
	}

	public Integer getIdInventario() {
		return this.idInventario;
	}

	public void setIdInventario(Integer idInventario) {
		this.idInventario = idInventario;
	}

	public Barco getBarco() {
		return this.barco;
	}

	public void setBarco(Barco barco) {
		this.barco = barco;
	}

	public Mercancia getMercancia() {
		return this.mercancia;
	}

	public void setMercancia(Mercancia mercancia) {
		this.mercancia = mercancia;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

}