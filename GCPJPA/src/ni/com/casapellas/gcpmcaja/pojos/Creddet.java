package ni.com.casapellas.gcpmcaja.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


public class Creddet implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal cant;

	private String coditem;

	private String codsuc;

	private String codunineg;

	private String descitem;

	private BigDecimal factor;

	private String impuesto;

	private BigDecimal nofactura;

	private BigDecimal preciounit;

	private String tipofactura;
	
	private String condicionPago;
	

	public String getCondicionPago() {
		return condicionPago;
	}

	public void setCondicionPago(String condicionPago) {
		this.condicionPago = condicionPago;
	}

	public Creddet() {
	}

	public BigDecimal getCant() {
		return this.cant;
	}

	public void setCant(BigDecimal cant) {
		this.cant = cant;
	}

	public String getCoditem() {
		return this.coditem;
	}

	public void setCoditem(String coditem) {
		this.coditem = coditem;
	}

	public String getCodsuc() {
		return this.codsuc;
	}

	public void setCodsuc(String codsuc) {
		this.codsuc = codsuc;
	}

	public String getCodunineg() {
		return this.codunineg;
	}

	public void setCodunineg(String codunineg) {
		this.codunineg = codunineg;
	}

	public String getDescitem() {
		return this.descitem;
	}

	public void setDescitem(String descitem) {
		this.descitem = descitem;
	}

	public BigDecimal getFactor() {
		return this.factor;
	}

	public void setFactor(BigDecimal factor) {
		this.factor = factor;
	}

	public String getImpuesto() {
		return this.impuesto;
	}

	public void setImpuesto(String impuesto) {
		this.impuesto = impuesto;
	}

	public BigDecimal getNofactura() {
		return this.nofactura;
	}

	public void setNofactura(BigDecimal nofactura) {
		this.nofactura = nofactura;
	}

	public BigDecimal getPreciounit() {
		return this.preciounit;
	}

	public void setPreciounit(BigDecimal preciounit) {
		this.preciounit = preciounit;
	}

	public String getTipofactura() {
		return this.tipofactura;
	}

	public void setTipofactura(String tipofactura) {
		this.tipofactura = tipofactura;
	}

}