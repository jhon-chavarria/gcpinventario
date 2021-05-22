package ni.com.casapellas.gcpsisinv.pojo;

public class InventoryLog {
	private String CodCompania;
	private String Sucursal;
	private String Departamento;
	private String Bodega;
	private int NoDocumento;
	private int NoProforma;
	private int NoPresupuesto;
	private int FechaMovimiento; 
	private String CodArticulo;
	private String Descripcion;
	private int CantidadReservada;
	private int CantidadResercadaCPD1;
	private int CantidadReservadaCPD8; 
	private int CodCliente; 
	private String Cliente;
	private String Motivo;
	private String EstadoReservado;
	private String EstadoDesReserva;
	
	
	private String LineaProduccion;
	private int NumeroCita;
	private String DescMarca;
	private String Modelo;
	private String Placa;
	
	public String getLineaProduccion() {
		return LineaProduccion;
	}
	public void setLineaProduccion(String lineaProduccion) {
		LineaProduccion = lineaProduccion;
	}
	public int getNumeroCita() {
		return NumeroCita;
	}
	public void setNumeroCita(int numeroCita) {
		NumeroCita = numeroCita;
	}
	public String getDescMarca() {
		return DescMarca;
	}
	public void setDescMarca(String descMarca) {
		DescMarca = descMarca;
	}
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	public String getPlaca() {
		return Placa;
	}
	public void setPlaca(String placa) {
		Placa = placa;
	}
	public String getCodCompania() {
		return CodCompania;
	}
	public void setCodCompania(String codCompania) {
		CodCompania = codCompania;
	}
	public String getSucursal() {
		return Sucursal;
	}
	public void setSucursal(String sucursal) {
		Sucursal = sucursal;
	}
	public String getDepartamento() {
		return Departamento;
	}
	public void setDepartamento(String departamento) {
		Departamento = departamento;
	}
	public String getBodega() {
		return Bodega;
	}
	public void setBodega(String bodega) {
		Bodega = bodega;
	}
	public int getNoDocumento() {
		return NoDocumento;
	}
	public void setNoDocumento(int noDocumento) {
		NoDocumento = noDocumento;
	}
	public int getNoProforma() {
		return NoProforma;
	}
	public void setNoProforma(int noProforma) {
		NoProforma = noProforma;
	}
	public int getNoPresupuesto() {
		return NoPresupuesto;
	}
	public void setNoPresupuesto(int noPresupuesto) {
		NoPresupuesto = noPresupuesto;
	}
	public int getFechaMovimiento() {
		return FechaMovimiento;
	}
	public void setFechaMovimiento(int fechaMovimiento) {
		FechaMovimiento = fechaMovimiento;
	}
	public String getCodArticulo() {
		return CodArticulo;
	}
	public void setCodArticulo(String codArticulo) {
		CodArticulo = codArticulo;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public int getCantidadReservada() {
		return CantidadReservada;
	}
	public void setCantidadReservada(int cantidadReservada) {
		CantidadReservada = cantidadReservada;
	}
	public int getCantidadResercadaCPD1() {
		return CantidadResercadaCPD1;
	}
	public void setCantidadResercadaCPD1(int cantidadResercadaCPD1) {
		CantidadResercadaCPD1 = cantidadResercadaCPD1;
	}
	public int getCantidadReservadaCPD8() {
		return CantidadReservadaCPD8;
	}
	public void setCantidadReservadaCPD8(int cantidadReservadaCPD8) {
		CantidadReservadaCPD8 = cantidadReservadaCPD8;
	}
	public int getCodCliente() {
		return CodCliente;
	}
	public void setCodCliente(int codCliente) {
		CodCliente = codCliente;
	}
	public String getCliente() {
		return Cliente;
	}
	public void setCliente(String cliente) {
		Cliente = cliente;
	}
	public String getMotivo() {
		return Motivo;
	}
	public void setMotivo(String motivo) {
		Motivo = motivo;
	}
	public String getEstadoReservado() {
		return EstadoReservado;
	}
	public void setEstadoReservado(String estadoReservado) {
		EstadoReservado = estadoReservado;
	}
	public String getEstadoDesReserva() {
		return EstadoDesReserva;
	}
	public void setEstadoDesReserva(String estadoDesReserva) {
		EstadoDesReserva = estadoDesReserva;
	}
}
