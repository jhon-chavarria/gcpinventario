package ni.com.casapellas.gcpmcaja.pojos;

import java.io.Serializable;

public class RecibodetCaja  extends Recibodet implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private int numeroReferencia;
	private int pagoAplicadoBajoPreconciliacion;
	private String codigoMarcaTarjeta;
	private String marcaTarjeta;
	private int liquidarPorMarca;
	private String descripcionMP;

	
	 	public Integer getNumeroRecibo() {
		  return this.getNumrec();
		 }

		 public void setNumeroRecibo(Integer numrec) {
		  this.setNumrec ( numrec);
		 }
		 public double getMontoPago() {
		  return this.getMonto();
		 }

		 public void setMontoPago(double monto) {
		  this.setMonto ( monto);
		 }
		 public String getMonedaPago() {
		  return this.getMoneda();
		 }

		 public void setMonedaPago(String moneda) {
		  this.setMoneda ( moneda);
		 }
		 public String getCodigoMetodoPago() {
		  return this.getMpago();
		 }

		 public void setCodigoMetodoPago(String mpago) {
		  this.setMpago ( mpago);
		 }
		 public double getTasaMetodoPago() {
		  return this.getTasa();
		 }

		 public void setTasaMetodoPago(double tasa) {
		  this.setTasa ( tasa);
		 }
		 public double getEquivalenteMonedaDomestica() {
		  return this.getEquiv();
		 }

		 public void setEquivalenteMonedaDomestica(double equiv) {
		  this.setEquiv ( equiv);
		 }
		 public String getReferencia1() {
		  return this.getRefer1();
		 }

		 public void setReferencia1(String refer1) {
		  this.setRefer1 ( refer1);
		 }
		 public String getReferencia2() {
		  return this.getRefer2();
		 }

		 public void setReferencia2(String refer2) {
		  this.setRefer2 ( refer2);
		 }
		 public String getReferencia3() {
		  return this.getRefer3();
		 }

		 public void setReferencia3(String refer3) {
		  this.setRefer3 ( refer3);
		 }
		 public String getReferencia4() {
		  return this.getRefer4();
		 }

		 public void setReferencia4(String refer4) {
		  this.setRefer4 ( refer4);
		 }
		 public String getCodigoCompania() {
		  return this.getCodcomp();
		 }

		 public void setCodigoCompania(String codcomp) {
		  this.setCodcomp ( codcomp);
		 }
		 public Integer getNumeroReciboManual() {
		  return this.getNumrecm();
		 }

		 public void setNumeroReciboManual(Integer numrecm) {
		  this.setNumrecm ( numrecm);
		 }
		 public int getNoCaja() {
		  return this.getCaid();
		 }

		 public void setNoCaja(int caid) {
		  this.setCaid ( caid);
		 }
		 public String getSucursal() {
		  return this.getCodsuc();
		 }

		 public void setSucursal(String codsuc) {
		  this.setCodsuc ( codsuc);
		 }
		 public String getTipoRecibo() {
		  return this.getTiporec();
		 }

		 public void setTipoRecibo(String tiporec) {
		  this.setTiporec ( tiporec);
		 }
		 public String getReferencia5() {
		  return this.getRefer5();
		 }

		 public void setReferencia5(String refer5) {
		  this.setRefer5 ( refer5);
		 }
		 public String getReferencia6() {
		  return this.getRefer6();
		 }

		 public void setReferencia6(String refer6) {
		  this.setRefer6 ( refer6);
		 }
		 public String getReferencia7() {
		  return this.getRefer7();
		 }

		 public void setReferencia7(String refer7) {
		  this.setRefer7 ( refer7);
		 }
		 public String getPagoConVoucherManual() {
		  return this.getVmanual();
		 }

		 public void setPagoConVoucherManual(String vmanual) {
		  this.setVmanual ( vmanual);
		 }
		 public double getCodigoCajaOrigenPos() {
		  return this.getCaidpos();
		 }

		 public void setCodigoCajaOrigenPos(double caidpos) {
		  this.setCaidpos ( caidpos);
		 }
		 public String getNombretarjeta() {
		  return this.getNombre();
		 }

		 public void setNombretarjeta(String nombre) {
		  this.setNombre ( nombre);
		 }

		public int getNumeroReferencia() {
			return numeroReferencia;
		}

		public void setNumeroReferencia(
				int _numeroReferencia) {
			numeroReferencia = _numeroReferencia;
		}

		public int getPagoAplicadoBajoPreconciliacion() {
			return pagoAplicadoBajoPreconciliacion;
		}

		public void setPagoAplicadoBajoPreconciliacion(
				int _pagoAplicadoBajoPreconciliacion) {
			pagoAplicadoBajoPreconciliacion = _pagoAplicadoBajoPreconciliacion;
		}

		public String getCodigoMarcaTarjeta() {
			return codigoMarcaTarjeta;
		}

		public void setCodigoMarcaTarjeta(String _codigoMarcaTarjeta) {
			codigoMarcaTarjeta = _codigoMarcaTarjeta;
		}

		public String getMarcaTarjeta() {
			return marcaTarjeta;
		}

		public void setMarcaTarjeta(String _marcaTarjeta) {
			marcaTarjeta = _marcaTarjeta;
		}

		public int getLiquidarPorMarca() {
			return liquidarPorMarca;
		}

		public void setLiquidarPorMarca(int _liquidarPorMarca) {
			liquidarPorMarca = _liquidarPorMarca;
		}

		public String getDescripcionMP() {
			return descripcionMP;
		}

		public void setDescripcionMP(String descripcionMP) {
			this.descripcionMP = descripcionMP;
		}



}
