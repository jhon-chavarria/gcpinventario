package ni.com.casapellas.cxccobro.cxc;

import java.math.BigDecimal;
import java.util.Date;

public class ResumenF {
	private int nosol;
	private int nofactura;
	private String producto;
	private String codsuc;
	private Date fechaini;
	private BigDecimal montorig;
	private Date fechapago;
	private int nocuota;
	private BigDecimal montocuota;
	private BigDecimal principal;
	private BigDecimal interesc;
	private BigDecimal mora;
	private BigDecimal otros;
	private BigDecimal saldopri;
	public int getNosol() {
		return nosol;
	}
	public void setNosol(int nosol) {
		this.nosol = nosol;
	}
	public int getNofactura() {
		return nofactura;
	}
	public void setNofactura(int nofactura) {
		this.nofactura = nofactura;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getCodsuc() {
		return codsuc;
	}
	public void setCodsuc(String codsuc) {
		this.codsuc = codsuc;
	}
	public Date getFechaini() {
		return fechaini;
	}
	public void setFechaini(Date fechaini) {
		this.fechaini = fechaini;
	}
	public BigDecimal getMontorig() {
		return montorig;
	}
	public void setMontorig(BigDecimal montorig) {
		this.montorig = montorig;
	}
	public Date getFechapago() {
		return fechapago;
	}
	public void setFechapago(Date fechapago) {
		this.fechapago = fechapago;
	}
	public int getNocuota() {
		return nocuota;
	}
	public void setNocuota(int nocuota) {
		this.nocuota = nocuota;
	}
	public BigDecimal getMontocuota() {
		return montocuota;
	}
	public void setMontocuota(BigDecimal montocuota) {
		this.montocuota = montocuota;
	}
	public BigDecimal getPrincipal() {
		return principal;
	}
	public void setPrincipal(BigDecimal principal) {
		this.principal = principal;
	}
	public BigDecimal getInteresc() {
		return interesc;
	}
	public void setInteresc(BigDecimal interesc) {
		this.interesc = interesc;
	}
	public BigDecimal getMora() {
		return mora;
	}
	public void setMora(BigDecimal mora) {
		this.mora = mora;
	}
	public BigDecimal getOtros() {
		return otros;
	}
	public void setOtros(BigDecimal otros) {
		this.otros = otros;
	}
	public BigDecimal getSaldopri() {
		return saldopri;
	}
	public void setSaldopri(BigDecimal saldopri) {
		this.saldopri = saldopri;
	}
}
