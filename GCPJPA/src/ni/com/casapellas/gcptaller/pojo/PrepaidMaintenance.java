package ni.com.casapellas.gcptaller.pojo;

public class PrepaidMaintenance {
	private String CodCompania;
	private String CodTaller;
	private Long NoContrato;
	private Integer CodCliente;
	private String Chasis;
	private String Motor;
	private String TipoDocumento;
	private String Estado;
	private Integer CodEmpleado;
	private Integer NoPropuesta;
	private Integer KilometrajeIni;
	private Integer KilometrajeFin;
	private Double ValorContrato;
	private Double IVA;
	private Double TasaCambio;
	
	private String validarSaldo;
	private Double saldo;
	private int kilometrajeTolerancia;
	private String FechaContrato;
	private String DescEstado;
	
	private String NombreCliente;
	private String NombreVendedor;
	
	public Integer getNoPropuesta() {
		return NoPropuesta;
	}
	public void setNoPropuesta(Integer noPropuesta) {
		NoPropuesta = noPropuesta;
	}
	public Integer getKilometrajeIni() {
		return KilometrajeIni;
	}
	public void setKilometrajeIni(Integer kilometrajeIni) {
		KilometrajeIni = kilometrajeIni;
	}
	public Integer getKilometrajeFin() {
		return KilometrajeFin;
	}
	public void setKilometrajeFin(Integer kilometrajeFin) {
		KilometrajeFin = kilometrajeFin;
	}
	public Double getValorContrato() {
		return ValorContrato;
	}
	public void setValorContrato(Double valorContrato) {
		ValorContrato = valorContrato;
	}
	public Double getIVA() {
		return IVA;
	}
	public void setIVA(Double iVA) {
		IVA = iVA;
	}
	public Double getTasaCambio() {
		return TasaCambio;
	}
	public void setTasaCambio(Double tasaCambio) {
		TasaCambio = tasaCambio;
	}
	public String getCodCompania() {
		return CodCompania;
	}
	public void setCodCompania(String codCompania) {
		CodCompania = codCompania;
	}
	public String getCodTaller() {
		return CodTaller;
	}
	public void setCodTaller(String codTaller) {
		CodTaller = codTaller;
	}
	public Integer getCodCliente() {
		return CodCliente;
	}
	public void setCodCliente(Integer codCliente) {
		CodCliente = codCliente;
	}
	public String getChasis() {
		return Chasis;
	}
	public void setChasis(String chasis) {
		Chasis = chasis;
	}
	public String getMotor() {
		return Motor;
	}
	public void setMotor(String motor) {
		Motor = motor;
	}
	public String getTipoDocumento() {
		return TipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		TipoDocumento = tipoDocumento;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public Integer getCodEmpleado() {
		return CodEmpleado;
	}
	public void setCodEmpleado(Integer codEmpleado) {
		CodEmpleado = codEmpleado;
	}
	public void setNoContrato(Long noContrato) {
		NoContrato = noContrato;
	}
	public Long getNoContrato() {
		return NoContrato;
	}
	public String getValidarSaldo() {
		return validarSaldo;
	}
	public void setValidarSaldo(String validarSaldo) {
		this.validarSaldo = validarSaldo;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public int getKilometrajeTolerancia() {
		return kilometrajeTolerancia;
	}
	public void setKilometrajeTolerancia(int kilometrajeTolerancia) {
		this.kilometrajeTolerancia = kilometrajeTolerancia;
	}
	public String getFechaContrato() {
		return FechaContrato;
	}
	public void setFechaContrato(String fechaContrato) {
		FechaContrato = fechaContrato;
	}
	public String getDescEstado() {
		return DescEstado;
	}
	public void setDescEstado(String descEstado) {
		DescEstado = descEstado;
	}
	public String getNombreCliente() {
		return NombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		NombreCliente = nombreCliente;
	}
	public String getNombreVendedor() {
		return NombreVendedor;
	}
	public void setNombreVendedor(String nombreVendedor) {
		NombreVendedor = nombreVendedor;
	}
}
