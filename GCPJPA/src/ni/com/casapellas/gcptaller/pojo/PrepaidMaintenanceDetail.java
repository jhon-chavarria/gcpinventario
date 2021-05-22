package ni.com.casapellas.gcptaller.pojo;

import java.util.Date;

public class PrepaidMaintenanceDetail {
	private int NoContrato;
	private int Kilometraje;
	private String CodActividad;
	private String Actividad;
	private int NoCita;
	private int NoOrden;
	private int NoFactura;
	private String Estado;
	private Date Fecha;
	private Double DescuentoMOMec;
	private Double DuracionActividad;
	private Double ValActCliente;
	private Double ValActMecanico;
	
	private String sTipoItem;
	private String TipoMantenimiento;
	
	private String ClasifActiv;
	private String EsReal;
	
	private Double precioTotal;
	private String CodTaller;
	
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	
	public int getNoContrato() {
		return NoContrato;
	}
	public void setNoContrato(int noContrato) {
		NoContrato = noContrato;
	}
	public int getKilometraje() {
		return Kilometraje;
	}
	public void setKilometraje(int kilometraje) {
		Kilometraje = kilometraje;
	}
	public String getCodActividad() {
		return CodActividad;
	}
	public void setCodActividad(String codActividad) {
		CodActividad = codActividad;
	}
	public String getActividad() {
		return Actividad;
	}
	public void setActividad(String actividad) {
		Actividad = actividad;
	}
	public int getNoCita() {
		return NoCita;
	}
	public void setNoCita(int noCita) {
		NoCita = noCita;
	}
	public int getNoOrden() {
		return NoOrden;
	}
	public void setNoOrden(int noOrden) {
		NoOrden = noOrden;
	}
	public int getNoFactura() {
		return NoFactura;
	}
	public void setNoFactura(int noFactura) {
		NoFactura = noFactura;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public Double getDescuentoMOMec() {
		return DescuentoMOMec;
	}
	public void setDescuentoMOMec(Double descuentoMOMec) {
		DescuentoMOMec = descuentoMOMec;
	}
	public Double getDuracionActividad() {
		return DuracionActividad;
	}
	public void setDuracionActividad(Double duracionActividad) {
		DuracionActividad = duracionActividad;
	}
	public Double getValActCliente() {
		return ValActCliente;
	}
	public void setValActCliente(Double valActCliente) {
		ValActCliente = valActCliente;
	}
	public Double getValActMecanico() {
		return ValActMecanico;
	}
	public void setValActMecanico(Double valActMecanico) {
		ValActMecanico = valActMecanico;
	}
	public String getClasifActiv() {
		return ClasifActiv;
	}
	public void setClasifActiv(String clasifActiv) {
		ClasifActiv = clasifActiv;
	}
	public String getsTipoItem() {
		return sTipoItem;
	}
	public void setsTipoItem(String sTipoItem) {
		this.sTipoItem = sTipoItem;
	}
	public String getTipoMantenimiento() {
		return TipoMantenimiento;
	}
	public void setTipoMantenimiento(String tipoMantenimiento) {
		TipoMantenimiento = tipoMantenimiento;
	}
	public String getEsReal() {
		return EsReal;
	}
	public void setEsReal(String esReal) {
		EsReal = esReal;
	}
	public Double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public String getCodTaller() {
		return CodTaller;
	}
	public void setCodTaller(String codTaller) {
		CodTaller = codTaller;
	}
}
