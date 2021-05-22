package ni.com.casapellas.erp.jde.pojo;

/**
 * 
 * Descripcion de ControlRegistroBatch.java
 * Sistemas: GCPJPA
 * Objetivos: Pojo donde definimos o equilibramos el F0011 
 *
 * Fecha Creacion: Jul 12, 2016
 * @author Luis Fonseca
 * Version: 
 * @since 
 * @see
 *
 */
public class ControlRegistroBatch {
	private Long numeroBatch;
	private String tipoBatch;
	private String estado;
	private String aprobadoContabilizar;
	private Double valorTotal1;
	private String usuario;
	private String fechaBatch;
	private Long numeroDocumento;
	private String documentoCantBalance;
	private String jeBalaceado;
	private String usuarioAutorizado;
	private String registroNoBalanceado;
	private Double valorTotal2;
	private Integer idInternoNatch;
	private String programaCreo;
	private String EntradaDocumento;
	private int fechaBatchJuliano;
	
	public String getFechaBatch() {
		return fechaBatch;
	}
	public void setFechaBatch(String fechaBatch) {
		this.fechaBatch = fechaBatch;
	}
	public int getFechaBatchJuliano() {
		return fechaBatchJuliano;
	}
	public void setFechaBatchJuliano(int fechaBatchJuliano) {
		this.fechaBatchJuliano = fechaBatchJuliano;
	}
	public Long getNumeroBatch() {
		return numeroBatch;
	}
	public void setNumeroBatch(Long numeroBatch) {
		this.numeroBatch = numeroBatch;
	}
	public String getTipoBatch() {
		return tipoBatch;
	}
	public void setTipoBatch(String tipoBatch) {
		this.tipoBatch = tipoBatch;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getAprobadoContabilizar() {
		return aprobadoContabilizar;
	}
	public void setAprobadoContabilizar(String aprobadoContabilizar) {
		this.aprobadoContabilizar = aprobadoContabilizar;
	}
	public Double getValorTotal1() {
		return valorTotal1;
	}
	public void setValorTotal1(Double valorTotal1) {
		this.valorTotal1 = valorTotal1;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Long getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(Long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getDocumentoCantBalance() {
		return documentoCantBalance;
	}
	public void setDocumentoCantBalance(String documentoCantBalance) {
		this.documentoCantBalance = documentoCantBalance;
	}
	public String getJeBalaceado() {
		return jeBalaceado;
	}
	public void setJeBalaceado(String jeBalaceado) {
		this.jeBalaceado = jeBalaceado;
	}
	public String getUsuarioAutorizado() {
		return usuarioAutorizado;
	}
	public void setUsuarioAutorizado(String usuarioAutorizado) {
		this.usuarioAutorizado = usuarioAutorizado;
	}
	public String getRegistroNoBalanceado() {
		return registroNoBalanceado;
	}
	public void setRegistroNoBalanceado(String registroNoBalanceado) {
		this.registroNoBalanceado = registroNoBalanceado;
	}
	public Double getValorTotal2() {
		return valorTotal2;
	}
	public void setValorTotal2(Double valorTotal2) {
		this.valorTotal2 = valorTotal2;
	}
	public Integer getIdInternoNatch() {
		return idInternoNatch;
	}
	public void setIdInternoNatch(Integer idInternoNatch) {
		this.idInternoNatch = idInternoNatch;
	}
	public String getProgramaCreo() {
		return programaCreo;
	}
	public void setProgramaCreo(String programaCreo) {
		this.programaCreo = programaCreo;
	}
	public String getEntradaDocumento() {
		return EntradaDocumento;
	}
	public void setEntradaDocumento(String entradaDocumento) {
		EntradaDocumento = entradaDocumento;
	}

}
