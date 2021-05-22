package ni.com.casapellas.gcpmcaja.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Recibofac implements Serializable {
	private static final long serialVersionUID = 1L;
	private int caid;
	private int codcli;
	private String codcomp;
	private String codsuc;
	private String codunineg;
	private String estado;
	private Date fecha;
	private int hora;
	private double monto;
	private Integer numfac;
	private Integer numrec;
	private String partida;
	private String tipofactura;
	private String tiporec;
	private String nameUnineg;
	
	

	public String getNameUnineg() {
		return nameUnineg;
	}

	public void setNameUnineg(String nameUnineg) {
		this.nameUnineg = nameUnineg;
	}

	public Recibofac() {
	}

	public int getCaid() {
		return caid;
	}

	public void setCaid(int caid) {
		this.caid = caid;
	}

	public int getCodcli() {
		return codcli;
	}

	public void setCodcli(int codcli) {
		this.codcli = codcli;
	}

	public String getCodcomp() {
		return codcomp;
	}

	public void setCodcomp(String codcomp) {
		this.codcomp = codcomp;
	}

	public String getCodsuc() {
		return codsuc;
	}

	public void setCodsuc(String codsuc) {
		this.codsuc = codsuc;
	}

	public String getCodunineg() {
		return codunineg;
	}

	public void setCodunineg(String codunineg) {
		this.codunineg = codunineg;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

 
	public String getFecha() {
		try {
			if(fecha != null)
			{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				return sdf.format(fecha);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fecha+"";
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getNumfac() {
		if(numfac == null)
			return 0;
		
		return numfac;
	}


	public double getNumrec() {
		if(numrec == null)
			return 0;
		
		return numrec;
	}


	public String getPartida() {
		return partida;
	}

	public void setPartida(String partida) {
		this.partida = partida;
	}

	public String getTipofactura() {
		return tipofactura;
	}

	public void setTipofactura(String tipofactura) {
		this.tipofactura = tipofactura;
	}

	public String getTiporec() {
		return tiporec;
	}

	public void setTiporec(String tiporec) {
		this.tiporec = tiporec;
	}

	public void setNumfac(Integer numfac) {
		this.numfac = numfac;
	}

	public void setNumrec(Integer numrec) {
		this.numrec = numrec;
	}

	
	// propiedades añadidas para congruencia
	 public Date getFechaFactura() {
		    return this.fecha;
	}
	 
	 public Integer getNumeroRecibo() {
		    return numrec;
	}
	 
	 public void setNumeroRecibo(Integer NumeroRecibo) {
		    numrec = NumeroRecibo;
	}
	 
	public Integer getNumeroFactura() {
		    return numfac;
	}

	public void setNumeroFactura(Integer NumeroFactura) {
		    numfac = NumeroFactura;
	}
	

}