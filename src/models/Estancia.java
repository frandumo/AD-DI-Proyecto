package models;
// Generated 09-feb-2017 13:27:33 by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * Estancia generated by hbm2java
 */
public class Estancia implements java.io.Serializable {

	private Integer idEstancia;
	private Barco barco;
	private Muelle muelle;
	private Date fechaEntrada;
	private Date fechaSalida;

	public Estancia() {
	}

	public Estancia(Barco barco, Muelle muelle) {
		this.barco = barco;
		this.muelle = muelle;
	}

	public Estancia(Barco barco, Muelle muelle, Date fechaEntrada, Date fechaSalida) {
		this.barco = barco;
		this.muelle = muelle;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
	}

	public Integer getIdEstancia() {
		return this.idEstancia;
	}

	public void setIdEstancia(Integer idEstancia) {
		this.idEstancia = idEstancia;
	}

	public Barco getBarco() {
		return this.barco;
	}

	public void setBarco(Barco barco) {
		this.barco = barco;
	}

	public Muelle getMuelle() {
		return this.muelle;
	}

	public void setMuelle(Muelle muelle) {
		this.muelle = muelle;
	}

	public Date getFechaEntrada() {
		return this.fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

}
