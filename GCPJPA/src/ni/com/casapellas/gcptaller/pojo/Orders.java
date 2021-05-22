package ni.com.casapellas.gcptaller.pojo;

import java.util.Date;

public class Orders {
	private String CodCompania;
	private String CodTaller;
	private Integer CodCliente;
	private String NombreApellido;
	private String TipoCliente;
	private Integer NoOrden;
	private Integer NoCita;
	private String Chasis;
	private String Motor;
	private String HoraEntrada;
	
	private String FechaEntrada;
	private String FechaFin;
	private String FecProbEntrega;
	private String HoraProbEntrega;
	private String FechaFac;
	private String TipoOrden;
	private String ModMant;
	private String TipoMant;
	private Integer KmtrOrden;
	private String Marca;
	private String Placa;
	private Integer Anio;
	private Double CostoMat;
	private Double CostoRep;
	private Double CostoServ;
	private Double CostoMOMecan;
	private Double CostoMOPint;
	private Double PrecioMat;
	private Double PrecioRep;
	private Double PrecioServ;
	private Double PrecioMOMecan;
	private Double PrecioMOPint;
	private Double DescMOMecan;
	private Double DescMOPint;
	private Double DescRep;
	private Double DescMat;
	private Double DescServ;
	private String ColorExterno;
	private String CodAsesor;
	private Integer Asesor;
	private String ClienteEsperaVeh;
	private String ClienteRevisaRep;
	private String Estado;
	
	private String CodImagen;
	private String CodColorCono;
	private int NumeroCono;
	private int MedidaCombus;
	
	private String Modelo;
	
	private String LimpiezaExtInt;
	private String RemoverItemCortesia;
	private String ExplicDetalleTrabajo;
	private String ExplicCosto;
	private String ConfirResultCliente;
	private String Corregido;
	private String PlanPSFU;
	private Date FechaEntrega;
	private Date HoraEntrega;
	private String AsesorEntrega;
	
	private String FechaCita;
	private String HoraCita;
	
	private String Observacion;
	
	private String FlagTraeRepuesto;
	private String DTraeRepuesto;
	private String FlagVehiculoSucio;
	
	private String NombreAsesorR;
	private String DescTaller;
	
	private String DescEstado;
	private String descripcionMantenimiento;
	private String codigoSeguridad;
	
	private String EmailAsesor;
	
	public String getMotor() {
		return Motor;
	}
	public void setMotor(String motor) {
		Motor = motor;
	}
	
	
	public String getFlagTraeRepuesto() {
		return FlagTraeRepuesto;
	}
	public void setFlagTraeRepuesto(String flagTraeRepuesto) {
		FlagTraeRepuesto = flagTraeRepuesto;
	}
	public String getDTraeRepuesto() {
		return DTraeRepuesto;
	}
	public void setDTraeRepuesto(String dTraeRepuesto) {
		DTraeRepuesto = dTraeRepuesto;
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
	public String getLimpiezaExtInt() {
		return LimpiezaExtInt;
	}
	public void setLimpiezaExtInt(String limpiezaExtInt) {
		LimpiezaExtInt = limpiezaExtInt;
	}
	public String getRemoverItemCortesia() {
		return RemoverItemCortesia;
	}
	public void setRemoverItemCortesia(String removerItemCortesia) {
		RemoverItemCortesia = removerItemCortesia;
	}
	public String getExplicDetalleTrabajo() {
		return ExplicDetalleTrabajo;
	}
	public void setExplicDetalleTrabajo(String explicDetalleTrabajo) {
		ExplicDetalleTrabajo = explicDetalleTrabajo;
	}
	public String getExplicCosto() {
		return ExplicCosto;
	}
	public void setExplicCosto(String explicCosto) {
		ExplicCosto = explicCosto;
	}
	public String getConfirResultCliente() {
		return ConfirResultCliente;
	}
	public void setConfirResultCliente(String confirResultCliente) {
		ConfirResultCliente = confirResultCliente;
	}
	public String getCorregido() {
		return Corregido;
	}
	public void setCorregido(String corregido) {
		Corregido = corregido;
	}
	public String getPlanPSFU() {
		return PlanPSFU;
	}
	public void setPlanPSFU(String planPSFU) {
		PlanPSFU = planPSFU;
	}
	public Date getFechaEntrega() {
		return FechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		FechaEntrega = fechaEntrega;
	}
	public Date getHoraEntrega() {
		return HoraEntrega;
	}
	public void setHoraEntrega(Date horaEntrega) {
		HoraEntrega = horaEntrega;
	}
	public String getAsesorEntrega() {
		return AsesorEntrega;
	}
	public void setAsesorEntrega(String asesorEntrega) {
		AsesorEntrega = asesorEntrega;
	}
	public String getCodImagen() {
		return CodImagen;
	}
	public void setCodImagen(String codImagen) {
		CodImagen = codImagen;
	}
	public String getCodColorCono() {
		return CodColorCono;
	}
	public void setCodColorCono(String codColorCono) {
		CodColorCono = codColorCono;
	}
	public int getNumeroCono() {
		return NumeroCono;
	}
	public void setNumeroCono(int numeroCono) {
		NumeroCono = numeroCono;
	}
	public int getMedidaCombus() {
		return MedidaCombus;
	}
	public void setMedidaCombus(int medidaCombus) {
		MedidaCombus = medidaCombus;
	}
	public String getClienteEsperaVeh() {
		return ClienteEsperaVeh;
	}
	public void setClienteEsperaVeh(String clienteEsperaVeh) {
		ClienteEsperaVeh = clienteEsperaVeh;
	}
	public String getClienteRevisaRep() {
		return ClienteRevisaRep;
	}
	public void setClienteRevisaRep(String clienteRevisaRep) {
		ClienteRevisaRep = clienteRevisaRep;
	}
	public String getFechaEntrada() {
		return FechaEntrada;
	}
	public void setFechaEntrada(String fechaEntrada) {
		FechaEntrada = fechaEntrada;
	}
	public String getFechaFin() {
		return FechaFin;
	}
	public void setFechaFin(String fechaFin) {
		FechaFin = fechaFin;
	}
	public String getFecProbEntrega() {
		return FecProbEntrega;
	}
	public void setFecProbEntrega(String fecProbEntrega) {
		FecProbEntrega = fecProbEntrega;
	}
	public String getHoraProbEntrega() {
		return HoraProbEntrega;
	}
	public void setHoraProbEntrega(String horaProbEntrega) {
		HoraProbEntrega = horaProbEntrega;
	}
	public String getFechaFac() {
		return FechaFac;
	}
	public void setFechaFac(String fechaFac) {
		FechaFac = fechaFac;
	}
	public String getCodCompania() {
		return CodCompania;
	}
	public void setCodCompania(String codCompania) {
		CodCompania = codCompania;
	}
	public Integer getCodCliente() {
		return CodCliente;
	}
	public void setCodCliente(Integer codCliente) {
		CodCliente = codCliente;
	}
	public String getTipoCliente() {
		return TipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		TipoCliente = tipoCliente;
	}
	public Integer getNoOrden() {
		return NoOrden;
	}
	public void setNoOrden(Integer noOrden) {
		NoOrden = noOrden;
	}
	public String getChasis() {
		return Chasis;
	}
	public void setChasis(String chasis) {
		Chasis = chasis;
	}
	public String getTipoOrden() {
		return TipoOrden;
	}
	public void setTipoOrden(String tipoOrden) {
		TipoOrden = tipoOrden;
	}
	public String getModMant() {
		return ModMant;
	}
	public void setModMant(String modMant) {
		ModMant = modMant;
	}
	public String getTipoMant() {
		return TipoMant;
	}
	public void setTipoMant(String tipoMant) {
		TipoMant = tipoMant;
	}
	public Integer getKmtrOrden() {
		return KmtrOrden;
	}
	public void setKmtrOrden(Integer kmtrOrden) {
		KmtrOrden = kmtrOrden;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getPlaca() {
		return Placa;
	}
	public void setPlaca(String placa) {
		Placa = placa;
	}
	public Integer getAnio() {
		return Anio;
	}
	public void setAnio(Integer anio) {
		Anio = anio;
	}
	public Double getCostoMat() {
		return CostoMat;
	}
	public void setCostoMat(Double costoMat) {
		CostoMat = costoMat;
	}
	public Double getCostoRep() {
		return CostoRep;
	}
	public void setCostoRep(Double costoRep) {
		CostoRep = costoRep;
	}
	public Double getCostoServ() {
		return CostoServ;
	}
	public void setCostoServ(Double costoServ) {
		CostoServ = costoServ;
	}
	public Double getCostoMOMecan() {
		return CostoMOMecan;
	}
	public void setCostoMOMecan(Double costoMOMecan) {
		CostoMOMecan = costoMOMecan;
	}
	public Double getCostoMOPint() {
		return CostoMOPint;
	}
	public void setCostoMOPint(Double costoMOPint) {
		CostoMOPint = costoMOPint;
	}
	public Double getPrecioMat() {
		return PrecioMat;
	}
	public void setPrecioMat(Double precioMat) {
		PrecioMat = precioMat;
	}
	public Double getPrecioRep() {
		return PrecioRep;
	}
	public void setPrecioRep(Double precioRep) {
		PrecioRep = precioRep;
	}
	public Double getPrecioServ() {
		return PrecioServ;
	}
	public void setPrecioServ(Double precioServ) {
		PrecioServ = precioServ;
	}
	public Double getPrecioMOMecan() {
		return PrecioMOMecan;
	}
	public void setPrecioMOMecan(Double precioMOMecan) {
		PrecioMOMecan = precioMOMecan;
	}
	public Double getPrecioMOPint() {
		return PrecioMOPint;
	}
	public void setPrecioMOPint(Double precioMOPint) {
		PrecioMOPint = precioMOPint;
	}
	public Double getDescMOMecan() {
		return DescMOMecan;
	}
	public void setDescMOMecan(Double descMOMecan) {
		DescMOMecan = descMOMecan;
	}
	public Double getDescMOPint() {
		return DescMOPint;
	}
	public void setDescMOPint(Double descMOPint) {
		DescMOPint = descMOPint;
	}
	public Double getDescRep() {
		return DescRep;
	}
	public void setDescRep(Double descRep) {
		DescRep = descRep;
	}
	public Double getDescMat() {
		return DescMat;
	}
	public void setDescMat(Double descMat) {
		DescMat = descMat;
	}
	public Double getDescServ() {
		return DescServ;
	}
	public void setDescServ(Double descServ) {
		DescServ = descServ;
	}
	public String getColorExterno() {
		return ColorExterno;
	}
	public void setColorExterno(String colorExterno) {
		ColorExterno = colorExterno;
	}
	public String getCodAsesor() {
		return CodAsesor;
	}
	public void setCodAsesor(String codAsesor) {
		CodAsesor = codAsesor;
	}
	public void setCodTaller(String codTaller) {
		CodTaller = codTaller;
	}
	public String getCodTaller() {
		return CodTaller;
	}
	public void setNombreApellido(String nombreApellido) {
		NombreApellido = nombreApellido;
	}
	public String getNombreApellido() {
		return NombreApellido;
	}
	public void setAsesor(Integer asesor) {
		Asesor = asesor;
	}
	public Integer getAsesor() {
		return Asesor;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getEstado() {
		return Estado;
	}
	public void setNoCita(Integer noCita) {
		NoCita = noCita;
	}
	public Integer getNoCita() {
		return NoCita;
	}
	public String getHoraEntrada() {
		return HoraEntrada;
	}
	public void setHoraEntrada(String horaEntrada) {
		HoraEntrada = horaEntrada;
	}
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	public String getObservacion() {
		return Observacion;
	}
	public void setObservacion(String observacion) {
		Observacion = observacion;
	}
	public String getFlagVehiculoSucio() {
		return FlagVehiculoSucio;
	}
	public void setFlagVehiculoSucio(String flagVehiculoSucio) {
		FlagVehiculoSucio = flagVehiculoSucio;
	}
	public String getNombreAsesorR() {
		return NombreAsesorR;
	}
	public void setNombreAsesorR(String nombreAsesorR) {
		NombreAsesorR = nombreAsesorR;
	}
	public String getDescTaller() {
		return DescTaller;
	}
	public void setDescTaller(String descTaller) {
		DescTaller = descTaller;
	}
	public String getDescEstado() {
		return DescEstado;
	}
	public void setDescEstado(String descEstado) {
		DescEstado = descEstado;
	}
	public String getDescripcionMantenimiento() {
		return descripcionMantenimiento;
	}
	public void setDescripcionMantenimiento(String descripcionMantenimiento) {
		this.descripcionMantenimiento = descripcionMantenimiento;
	}
	public String getCodigoSeguridad() {
		return codigoSeguridad;
	}
	public void setCodigoSeguridad(String codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}
	public String getEmailAsesor() {
		return EmailAsesor;
	}
	public void setEmailAsesor(String emailAsesor) {
		EmailAsesor = emailAsesor;
	}
}
