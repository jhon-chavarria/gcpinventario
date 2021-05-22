package ni.com.casapellas.gcpmcaja.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Credhdr implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal cimpuesto;

	private BigDecimal codcli;

	private String codcomp;

	private String codsuc;

	private String codunineg;

	private String compenslm;

	private BigDecimal cpendiente;

	private BigDecimal csubtotal;

	private BigDecimal ctotal;

	private BigDecimal dimpuesto;

	private BigDecimal dpendiente;

	private BigDecimal dsubtotal;

	private BigDecimal dtotal;

	private Date fecha;

	private Date fechavenc;

	private BigDecimal impuesto;

	private String moneda;

	private BigDecimal monto;

	private BigDecimal montopend;

	private BigDecimal nofactura;

	private String nomcli;

	private String nomcomp;

	private String nomsuc;

	private String partida;

	private String rpdcto;

	private BigDecimal rpddj;

	private BigDecimal rpdivj;

	private String rppo;

	private BigDecimal subtotal;

	private BigDecimal tasa;

	private String tipofactura;

	private String tipopago;

	private String unineg;
	
	private List<Creddet> Creddet;
	
	private String vendedor;
	
	private String nochasis;
	
	private int batch;
	
	private Date batchDate;
	
	private String codComp;
	private String nomComp;
	
	private String placa;
	
	private String condicionPago;
	
	
	

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCodComp() {
		return codComp;
	}

	public void setCodComp(String codComp) {
		this.codComp = codComp;
	}

	public String getNomComp() {
		return nomComp;
	}

	public void setNomComp(String nomComp) {
		this.nomComp = nomComp;
	}

	public int getBatch() {
		return batch;
	}

	public void setBatch(int batch) {
		this.batch = batch;
	}

	public String getBatchDate() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
			if(batchDate.compareTo(new Date())==0){
				return "";
			}else{
				return sdf.format(batchDate);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return batchDate+"";
	}

	public void setBatchDate(Date batchDate) {
		this.batchDate = batchDate;
	}

	public List<Creddet> getCreddet() {
		return Creddet;
	}

	public void setCreddet(List<Creddet> creddet) {
		Creddet = creddet;
	}

	public Credhdr() {
	}

	public BigDecimal getCimpuesto() {
		return this.cimpuesto;
	}

	public void setCimpuesto(BigDecimal cimpuesto) {
		this.cimpuesto = cimpuesto;
	}

	public BigDecimal getCodcli() {
		return this.codcli;
	}

	public void setCodcli(BigDecimal codcli) {
		this.codcli = codcli;
	}

	public String getCodcomp() {
		return this.codcomp;
	}

	public void setCodcomp(String codcomp) {
		this.codcomp = codcomp;
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

	public String getCompenslm() {
		return this.compenslm;
	}

	public void setCompenslm(String compenslm) {
		this.compenslm = compenslm;
	}

	public BigDecimal getCpendiente() {
		return this.cpendiente;
	}

	public void setCpendiente(BigDecimal cpendiente) {
		this.cpendiente = cpendiente;
	}

	public BigDecimal getCsubtotal() {
		return this.csubtotal;
	}

	public void setCsubtotal(BigDecimal csubtotal) {
		this.csubtotal = csubtotal;
	}

	public BigDecimal getCtotal() {
		return this.ctotal;
	}

	public void setCtotal(BigDecimal ctotal) {
		this.ctotal = ctotal;
	}

	public BigDecimal getDimpuesto() {
		return this.dimpuesto;
	}

	public void setDimpuesto(BigDecimal dimpuesto) {
		this.dimpuesto = dimpuesto;
	}

	public BigDecimal getDpendiente() {
		return this.dpendiente;
	}

	public void setDpendiente(BigDecimal dpendiente) {
		this.dpendiente = dpendiente;
	}

	public BigDecimal getDsubtotal() {
		return this.dsubtotal;
	}

	public void setDsubtotal(BigDecimal dsubtotal) {
		this.dsubtotal = dsubtotal;
	}

	public BigDecimal getDtotal() {
		return this.dtotal;
	}

	public void setDtotal(BigDecimal dtotal) {
		this.dtotal = dtotal;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechavenc() {
		return this.fechavenc;
	}

	public void setFechavenc(Date fechavenc) {
		this.fechavenc = fechavenc;
	}

	public BigDecimal getImpuesto() {
		return this.impuesto;
	}

	public void setImpuesto(BigDecimal impuesto) {
		this.impuesto = impuesto;
	}

	public String getMoneda() {
		return this.moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public BigDecimal getMontopend() {
		return this.montopend;
	}

	public void setMontopend(BigDecimal montopend) {
		this.montopend = montopend;
	}

	public BigDecimal getNofactura() {
		return this.nofactura;
	}

	public void setNofactura(BigDecimal nofactura) {
		this.nofactura = nofactura;
	}

	public String getNomcli() {
		return this.nomcli;
	}

	public void setNomcli(String nomcli) {
		this.nomcli = nomcli;
	}

	public String getNomcomp() {
		return this.nomcomp;
	}

	public void setNomcomp(String nomcomp) {
		this.nomcomp = nomcomp;
	}

	public String getNomsuc() {
		return this.nomsuc;
	}

	public void setNomsuc(String nomsuc) {
		this.nomsuc = nomsuc;
	}

	public String getPartida() {
		return this.partida;
	}

	public void setPartida(String partida) {
		this.partida = partida;
	}

	public String getRpdcto() {
		return this.rpdcto;
	}

	public void setRpdcto(String rpdcto) {
		this.rpdcto = rpdcto;
	}

	public BigDecimal getRpddj() {
		return this.rpddj;
	}

	public void setRpddj(BigDecimal rpddj) {
		this.rpddj = rpddj;
	}

	public BigDecimal getRpdivj() {
		return this.rpdivj;
	}

	public void setRpdivj(BigDecimal rpdivj) {
		this.rpdivj = rpdivj;
	}

	public String getRppo() {
		return this.rppo;
	}

	public void setRppo(String rppo) {
		this.rppo = rppo;
	}

	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getTasa() {
		return this.tasa;
	}

	public void setTasa(BigDecimal tasa) {
		this.tasa = tasa;
	}

	public String getTipofactura() {
		return this.tipofactura;
	}

	public void setTipofactura(String tipofactura) {
		this.tipofactura = tipofactura;
	}

	public String getTipopago() {
		return this.tipopago;
	}

	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}

	public String getUnineg() {
		return this.unineg;
	}

	public void setUnineg(String unineg) {
		this.unineg = unineg;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getNochasis() {
		return nochasis;
	}

	public void setNochasis(String nochasis) {
		this.nochasis = nochasis;
	}

	public String getCondicionPago() {
		return condicionPago;
	}

	public void setCondicionPago(String condicionPago) {
		this.condicionPago = condicionPago;
	}

}