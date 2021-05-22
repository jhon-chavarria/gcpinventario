package ni.com.casapellas.qs36f.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Invd736PO {
	private String compania;
	private String tipo;
	private int mesanio;
	private double cantidad;
	private double porcentajep;
	private double porcentajes;
	private double valorp;
	private double valors;

	public Invd736PO() {
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

//	public double getMesanio() {
//		return mesanio;
//	}
//
//	public void setMesanio(double mesanio) {
//		this.mesanio = mesanio;
//	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getPorcentajep() {
		return porcentajep;
	}

	public void setPorcentajep(double porcentajep) {
		this.porcentajep = porcentajep;
	}

	public double getPorcentajes() {
		return porcentajes;
	}

	public void setPorcentajes(double porcentajes) {
		this.porcentajes = porcentajes;
	}

	public double getValorp() {
		return valorp;
	}

	public void setValorp(double valorp) {
		this.valorp = valorp;
	}

	public double getValors() {
		return valors;
	}

	public void setValors(double valors) {
		this.valors = valors;
	}

	public int getMesanio() {
		return mesanio;
	}

	public void setMesanio(int mesanio) {
		this.mesanio = mesanio;
	}


}
