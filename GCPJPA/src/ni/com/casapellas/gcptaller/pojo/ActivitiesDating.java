package ni.com.casapellas.gcptaller.pojo;

public class ActivitiesDating {
	private String CodCompania;
	private String CodTaller;
	private int NumCita;
	private String CodActividad;
	private Double TiempoActividad;
	private String Actividad;
	
	private String Mpp;
	private int Mppkmtr;
	private int NoContrato;
	private Double ValActCliente;
	
	private Double ValActMecanico;
	
	private String LineaProduccion;
	private String CodBahia;
	private String FechaEjecucion; 
	private String HoraIniEjecucion;
	private String HoraFinEjecucion;
	private int NoOrdenRT;
	private String FlagCampania;
	
	private String CodChip;
	private int DuracionChip;
	
	private int Secuencia;
	
	private String FechaFin;
	private String SucursalMPP;
	
	private Double precioTotalMpp;
	
	//--------------------------------------------
	//Agregar campos correspondiente a cabecera
	//de citas
	
	public String getCodChip() {
		return CodChip;
	}
	public void setCodChip(String codChip) {
		CodChip = codChip;
	}
	public int getDuracionChip() {
		return DuracionChip;
	}
	public void setDuracionChip(int duracionChip) {
		DuracionChip = duracionChip;
	}
	public int getNoOrdenRT() {
		return NoOrdenRT;
	}
	public void setNoOrdenRT(int noOrdenRT) {
		NoOrdenRT = noOrdenRT;
	}
	public String getFlagCampania() {
		return FlagCampania;
	}
	public void setFlagCampania(String flagCampania) {
		FlagCampania = flagCampania;
	}
	public String getHoraIniEjecucion() {
		return HoraIniEjecucion;
	}
	public void setHoraIniEjecucion(String horaIniEjecucion) {
		HoraIniEjecucion = horaIniEjecucion;
	}
	public String getHoraFinEjecucion() {
		return HoraFinEjecucion;
	}
	public void setHoraFinEjecucion(String horaFinEjecucion) {
		HoraFinEjecucion = horaFinEjecucion;
	}
	private String Chasis;
	private int CodCliente;
	private String NombreCliente;
	private String Placa;
	private String FechaCita;
	private String HoraCita;
	private String Modelo;
	private String Estado;
	private String FechaEntrega;
	private String HoraEntrega;
	private String DescMarca;
	
	private String ClienteEsperaR;
	
	//--------------------------------------------
	
	public String getChasis() {
		return Chasis;
	}
	public void setChasis(String chasis) {
		Chasis = chasis;
	}
	public int getCodCliente() {
		return CodCliente;
	}
	public void setCodCliente(int codCliente) {
		CodCliente = codCliente;
	}
	public String getNombreCliente() {
		return NombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		NombreCliente = nombreCliente;
	}
	public String getPlaca() {
		return Placa;
	}
	public void setPlaca(String placa) {
		Placa = placa;
	}
	public String getFechaCita() {
		return FechaCita;
	}
	public void setFechaCita(String fechaCita) {
		FechaCita = fechaCita;
	}
	public String getHoraCita() {
		return HoraCita;
	}
	public void setHoraCita(String horaCita) {
		HoraCita = horaCita;
	}
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getFechaEntrega() {
		return FechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) {
		FechaEntrega = fechaEntrega;
	}
	public String getHoraEntrega() {
		return HoraEntrega;
	}
	public void setHoraEntrega(String horaEntrega) {
		HoraEntrega = horaEntrega;
	}
	public String getDescMarca() {
		return DescMarca;
	}
	public void setDescMarca(String descMarca) {
		DescMarca = descMarca;
	}
	public String getLineaProduccion() {
		return LineaProduccion;
	}
	public void setLineaProduccion(String lineaProduccion) {
		LineaProduccion = lineaProduccion;
	}
	public String getCodBahia() {
		return CodBahia;
	}
	public void setCodBahia(String codBahia) {
		CodBahia = codBahia;
	}
	public String getFechaEjecucion() {
		return FechaEjecucion;
	}
	public void setFechaEjecucion(String fechaEjecucion) {
		FechaEjecucion = fechaEjecucion;
	}
	public int getNoContrato() {
		return NoContrato;
	}
	public void setNoContrato(int noContrato) {
		NoContrato = noContrato;
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
	
	public String getCodActividad() {
		return CodActividad;
	}
	public void setCodActividad(String codActividad) {
		CodActividad = codActividad;
	}
	public Double getTiempoActividad() {
		return TiempoActividad;
	}
	public void setTiempoActividad(Double tiempoActividad) {
		TiempoActividad = tiempoActividad;
	}
	public String getActividad() {
		return Actividad;
	}
	public void setActividad(String actividad) {
		Actividad = actividad;
	}
	public int getNumCita() {
		return NumCita;
	}
	public void setNumCita(int numCita) {
		NumCita = numCita;
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
	public String getClienteEsperaR() {
		return ClienteEsperaR;
	}
	public void setClienteEsperaR(String clienteEsperaR) {
		ClienteEsperaR = clienteEsperaR;
	}
	public int getSecuencia() {
		return Secuencia;
	}
	public void setSecuencia(int secuencia) {
		Secuencia = secuencia;
	}
	public String getFechaFin() {
		return FechaFin;
	}
	public void setFechaFin(String fechaFin) {
		FechaFin = fechaFin;
	}
	public int getMppkmtr() {
		return Mppkmtr;
	}
	public void setMppkmtr(int mppkmtr) {
		Mppkmtr = mppkmtr;
	}
	public String getMpp() {
		return Mpp;
	}
	public void setMpp(String mpp) {
		Mpp = mpp;
	}
	public String getSucursalMPP() {
		return SucursalMPP;
	}
	public void setSucursalMPP(String sucursalMPP) {
		SucursalMPP = sucursalMPP;
	}
	public Double getPrecioTotalMpp() {
		return precioTotalMpp;
	}
	public void setPrecioTotalMpp(Double precioTotalMpp) {
		this.precioTotalMpp = precioTotalMpp;
	}
	
}
