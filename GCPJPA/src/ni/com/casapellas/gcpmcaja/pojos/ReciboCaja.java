package ni.com.casapellas.gcpmcaja.pojos;

import java.io.Serializable;

public class ReciboCaja extends Recibo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	 public Integer getNumeroRecibo() {
		  return this.getNumrec();
		 }

		 public void setNumeroRecibo(Integer numrec) {
		  this.setNumrec ( numrec);
		 }
		 public double getMontoAAplicar() {
		  return this.getMontoapl();
		 }

		 public void setMontoAAplicar(double montoapl) {
		  this.setMontoapl ( montoapl);
		 }
		 public double getMontoRecibido() {
		  return this.getMontorec();
		 }

		 public void setMontoRecibido(double montorec) {
		  this.setMontorec ( montorec);
		 }
		 public String getConceptoRecibo() {
		  return this.getConcepto();
		 }

		 public void setConceptoRecibo(String concepto) {
		  this.setConcepto ( concepto);
		 }
		 public String getTipoRecibo() {
		  return this.getTiporec();
		 }

		 public void setTipoRecibo(String tiporec) {
		  this.setTiporec ( tiporec);
		 }
		 public String getFechaRecibo() {
		  return this.getFecha();
		 }

		 public void setFechaRecibo(String fecha) {
		  this.setFecha ( fecha);
		 }
		 public String getNombreCliente() {
		  return this.getCliente();
		 }

		 public void setNombreCliente(String cliente) {
		  this.setCliente ( cliente);
		 }
		 public int getCodigoCliente() {
		  return this.getCodcli();
		 }

		 public void setCodigoCliente(int codcli) {
		  this.setCodcli ( codcli);
		 }
		 public String getNombreCajero() {
		  return this.getCajero();
		 }

		 public void setNombreCajero(String cajero) {
		  this.setCajero ( cajero);
		 }
		 public String getCodigoCompania() {
		  return this.getCodcomp();
		 }

		 public void setCodigoCompania(String codcomp) {
		  this.setCodcomp ( codcomp);
		 }
		 public String getHoraRecibo() {
		  return this.getHora();
		 }

		 public void setHoraRecibo(String hora) {
		  this.setHora ( hora);
		 }
		 public Integer getNumeroReciboManual() {
		  return this.getNumrecm();
		 }

		 public void setNumeroReciboManual(Integer numrecm) {
		  this.setNumrecm ( numrecm);
		 }
		 public double getNumeroReciboFicha() {
		  return this.getRecjde();
		 }

		 public void setNumeroReciboFicha(double recjde) {
		  this.setRecjde ( recjde);
		 }
		 public int getCodigoCaja() {
		  return this.getCaid();
		 }

		 public void setCodigoCaja(int caid) {
		  this.setCaid ( caid);
		 }
		 public String getSucursal() {
		  return this.getCodsuc();
		 }

		 public void setSucursal(String codsuc) {
		  this.setCodsuc ( codsuc);
		 }
		 
		 public String getMotivoAnulacion() {
		  return this.getMotivo();
		 }

		 public void setMotivoAnulacion(String motivo) {
		  this.setMotivo ( motivo);
		 }
		 public String getCodigoUsuarioAnulador() {
		  return this.getCodusera();
		 }

		 public void setCodigoUsuarioAnulador(String codusera) {
		  this.setCodusera ( codusera);
		 }
		 public String getHoraModificacion() {
		  return this.getHoramod();
		 }

		 public void setHoraModificacion(String horamod) {
		  this.setHoramod ( horamod);
		 }
		 public String getCodUsuario() {
		  return this.getCoduser();
		 }

		 public void setCodUsuario(String coduser) {
		  this.setCoduser ( coduser);
		 }
		 public double getNoReciboOriginal() {
		  return this.getNodoco();
		 }

		 public void setNoReciboOriginal(double nodoco) {
		  this.setNodoco ( nodoco);
		 }
		 public String getTipoReciboOriginal() {
		  return this.getTipodoco();
		 }

		 public void setTipoReciboOriginal(String tipodoco) {
		  this.setTipodoco ( tipodoco);
		 }
		 public String getFechaReciboManual() {
		  return this.getFecham();
		 }

		 public void setFechaReciboManual(String fecham) {
		  this.setFecham ( fecham);
		 }
		 public String getUnidadNegocio() {
		  return this.getCodunineg();
		 }

		 public void setUnidadNegocio(String codunineg) {
		  this.setCodunineg ( codunineg);
		 }
		 public String getMotivoCambioTasa() {
		  return this.getMotivoct();
		 }

		 public void setMotivoCambioTasa(String motivoct) {
		  this.setMotivoct ( motivoct);
		 }
		 public String getMonedaAplicada() {
		  return this.getMonedaapl();
		 }

		 public void setMonedaAplicada(String monedaapl) {
		  this.setMonedaapl ( monedaapl);
		 }





}
