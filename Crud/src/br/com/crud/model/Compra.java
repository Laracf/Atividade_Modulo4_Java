package br.com.crud.model;

import java.util.Date;

public class Compra {
	
	private int Id;
	private Date DataIda;
	private Date DataVolta;
	private double ValorCompra;
	private int Id_contato;
	private Contato contato;
	private int Id_destino;
	private Destino destino;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Date getDataIda() {
		return DataIda;
	}
	public void setDataIda(Date dataIda) {
		DataIda = dataIda;
	}
	public Date getDataVolta() {
		return DataVolta;
	}
	public void setDataVolta(Date dataVolta) {
		DataVolta = dataVolta;
	}
	public double getValorCompra() {
		return ValorCompra;
	}
	public void setValorCompra(double valorCompra) {
		ValorCompra = valorCompra;
	}
	public int getId_contato() {
		return Id_contato;
	}
	public void setId_contato(int id_contato) {
		Id_contato = id_contato;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	public int getId_destino() {
		return Id_destino;
	}
	public void setId_destino(int id_destino) {
		Id_destino = id_destino;
	}
	public Destino getDestino() {
		return destino;
	}
	public void setDestino(Destino destino) {
		this.destino = destino;
	}
}
