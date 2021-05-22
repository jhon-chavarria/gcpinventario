package ni.com.casapellas.cxccobro.pojo;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Luis Fonseca
 *
 */
@XmlRootElement
public class Cxc {
	private String CodSucursal;
	private int CodCliente;
	private String TipoDoc;
	private int NumeroDoc;
	private String Cuota;
	private int FechaFactura;
	private String TipoDocDis;
	private int NumeroDocDis;
	private int FechaPago;
	private int FechaLibroMayor;
	private int Anio;
	private int Mes;
	private String EstadoContab;
	private BigDecimal ImporteBruto;
	private BigDecimal Saldo;
	private String CodMoneda;
	private Double TasaCambio;
	private BigDecimal ImporteBrutoExt;
	private BigDecimal SaldoExt;
	private String ClaseContable;
	private String CodUnidadNegocio;
	private int FechaVencimiento;
	private String NumeroSolicitud;
	private String TipoCartera;
	private String Observaciones;
	private int NumeroBatch;
	
	public String getCodSucursal() {
		return CodSucursal;
	}
	public void setCodSucursal(String codSucursal) {
		CodSucursal = codSucursal;
	}
	public int getCodCliente() {
		return CodCliente;
	}
	public void setCodCliente(int codCliente) {
		CodCliente = codCliente;
	}
	public String getTipoDoc() {
		return TipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		TipoDoc = tipoDoc;
	}
	public int getNumeroDoc() {
		return NumeroDoc;
	}
	public void setNumeroDoc(int numeroDoc) {
		NumeroDoc = numeroDoc;
	}
	public String getCuota() {
		return Cuota;
	}
	public void setCuota(String cuota) {
		Cuota = cuota;
	}
	public int getFechaFactura() {
		return FechaFactura;
	}
	public void setFechaFactura(int fechaFactura) {
		FechaFactura = fechaFactura;
	}
	public String getTipoDocDis() {
		return TipoDocDis;
	}
	public void setTipoDocDis(String tipoDocDis) {
		TipoDocDis = tipoDocDis;
	}
	public int getFechaPago() {
		return FechaPago;
	}
	public void setFechaPago(int fechaPago) {
		FechaPago = fechaPago;
	}
	public int getFechaLibroMayor() {
		return FechaLibroMayor;
	}
	public void setFechaLibroMayor(int fechaLibroMayor) {
		FechaLibroMayor = fechaLibroMayor;
	}
	public int getAnio() {
		return Anio;
	}
	public void setAnio(int anio) {
		Anio = anio;
	}
	public int getMes() {
		return Mes;
	}
	public void setMes(int mes) {
		Mes = mes;
	}
	public BigDecimal getImporteBruto() {
		return ImporteBruto;
	}
	public void setImporteBruto(BigDecimal importeBruto) {
		ImporteBruto = importeBruto;
	}
	public BigDecimal getSaldo() {
		return Saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		Saldo = saldo;
	}
	public String getCodMoneda() {
		return CodMoneda;
	}
	public void setCodMoneda(String codMoneda) {
		CodMoneda = codMoneda;
	}
	public Double getTasaCambio() {
		return TasaCambio;
	}
	public void setTasaCambio(Double tasaCambio) {
		TasaCambio = tasaCambio;
	}
	public BigDecimal getImporteBrutoExt() {
		return ImporteBrutoExt;
	}
	public void setImporteBrutoExt(BigDecimal importeBrutoExt) {
		ImporteBrutoExt = importeBrutoExt;
	}
	public BigDecimal getSaldoExt() {
		return SaldoExt;
	}
	public void setSaldoExt(BigDecimal saldoExt) {
		SaldoExt = saldoExt;
	}
	public String getCodUnidadNegocio() {
		return CodUnidadNegocio;
	}
	public void setCodUnidadNegocio(String codUnidadNegocio) {
		CodUnidadNegocio = codUnidadNegocio;
	}
	public int getFechaVencimiento() {
		return FechaVencimiento;
	}
	public void setFechaVencimiento(int fechaVencimiento) {
		FechaVencimiento = fechaVencimiento;
	}
	public String getNumeroSolicitud() {
		return NumeroSolicitud;
	}
	public void setNumeroSolicitud(String numeroSolicitud) {
		NumeroSolicitud = numeroSolicitud;
	}
	public String getTipoCartera() {
		return TipoCartera;
	}
	public void setTipoCartera(String tipoCartera) {
		TipoCartera = tipoCartera;
	}
	public String getEstadoContab() {
		return EstadoContab;
	}
	public void setEstadoContab(String estadoContab) {
		EstadoContab = estadoContab;
	}
	public String getClaseContable() {
		return ClaseContable;
	}
	public void setClaseContable(String claseContable) {
		ClaseContable = claseContable;
	}
	public int getNumeroDocDis() {
		return NumeroDocDis;
	}
	public void setNumeroDocDis(int numeroDocDis) {
		NumeroDocDis = numeroDocDis;
	}
	public String getObservaciones() {
		return Observaciones;
	}
	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}
	public int getNumeroBatch() {
		return NumeroBatch;
	}
	public void setNumeroBatch(int numeroBatch) {
		NumeroBatch = numeroBatch;
	}
	
}
