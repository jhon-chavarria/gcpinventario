package ni.com.casapellas.gcptaller.pojo;

import java.util.Date;

public class Dating {
	private String Compania;
	private String CodTaller;
	private Integer NoCita;
	private Date FechaHoraCita;
	private Integer CodCliente;
	private String NombreCliente;
	private String Chasis;
	private String Motor;
	private String CodMarca;
	private String Marca;
	private String Placa;
	private String Modelo;
	private Integer Anio;
	private String CodAsesor;
	private Integer CodEmpAsesor;
	private String NombreAsesor;
	private Integer CodEmpTecnico;
	private String CodTipoOrden;
	private String TipoOrden;
	private String CodModalidadMant;
	private String ModalidadMant;
	private String CodTipoMant;
	private String TipoMant;
	private String ModKitRep;
	private Integer NoPresupuesto;
	private Integer NoOrden;
	private Integer KilometrajeMRS;
	private String UltimoManten;
	private Integer RecomendTecnica;
	private Integer Campanias;
	private Integer MantPrepagado;
	private Integer MantPeriodico;
	private Integer ActualizarCliente;	
	private String FechaCita;
	private String HoraCita;
	private String Combustible;
	private String Estado;
	private String FechaEntrega;
	private String HoraEntrega;
	private String DescMarca;
	private String DescTaller;
	private String FechaEjecucion;
	private String HoraEjecucion;
	private String ModalidadOperacion;
	private String LineaProduccion;
	private String Turno;
	private String CodBahia;
	private String CategoriaMec;
	private String FechaVenta;
	private String CodColor;
	private String MntSugerido;
	private String Direccion;
	private int Telefono;
	private String Conductor;
	private String Motivo;
	private String MotivoAnulacion;
	private String MotivoConfirmacion;
	private String ClienteEsperaR;
	private String TipoVehiculo;
	private String HoraFinCita;
	
	private String UsuarioReprogramo;
	private String FechaReprogramo;
	private String HoraReprogramo;
	
	private String UsuarioCreo;
	private int FechaCreo;
	private int HoraCreo;
	
	private String PersonaCreo;
	private String PersonaReprogramo;
	private String DescEstado;
	
	private String SubEstado;
	private String Fuente;
	private String ClienteTraeR;
	private double TiempoAsesorTecnico;
	private String ParaConfirmar;
	
	private String CodMotivoAnulacion;
	private String CodMotivoReprogramacion;
	
	private String UsuarioModifico;
	private String FechaModifico;
	private String HoraModifico;
	
	private int TiempoAsesorServicio;
	
	private String descripcionMantenimiento;
	private String descripcionLineaProduccion;
	private String descripcionTurno;
	private String descripcionModalidadOperacion;
	
	public String getDescripcionTurno() {
		return descripcionTurno;
	}
	public void setDescripcionTurno(String descripcionTurno) {
		this.descripcionTurno = descripcionTurno;
	}
	public String getDescripcionModalidadOperacion() {
		return descripcionModalidadOperacion;
	}
	public void setDescripcionModalidadOperacion(
			String descripcionModalidadOperacion) {
		this.descripcionModalidadOperacion = descripcionModalidadOperacion;
	}
	public String getDescripcionMantenimiento() {
		return descripcionMantenimiento;
	}
	public void setDescripcionMantenimiento(String descripcionMantenimiento) {
		this.descripcionMantenimiento = descripcionMantenimiento;
	}
	public String getDescripcionLineaProduccion() {
		return descripcionLineaProduccion;
	}
	public void setDescripcionLineaProduccion(String descripcionLineaProduccion) {
		this.descripcionLineaProduccion = descripcionLineaProduccion;
	}
	public String getUsuarioModifico() {
		return UsuarioModifico;
	}
	public void setUsuarioModifico(String usuarioModifico) {
		UsuarioModifico = usuarioModifico;
	}
	public String getFechaModifico() {
		return FechaModifico;
	}
	public void setFechaModifico(String fechaModifico) {
		FechaModifico = fechaModifico;
	}
	public String getHoraModifico() {
		return HoraModifico;
	}
	public void setHoraModifico(String horaModifico) {
		HoraModifico = horaModifico;
	}
	public String getCodMotivoAnulacion() {
		return CodMotivoAnulacion;
	}
	public void setCodMotivoAnulacion(String codMotivoAnulacion) {
		CodMotivoAnulacion = codMotivoAnulacion;
	}
	public String getCodMotivoReprogramacion() {
		return CodMotivoReprogramacion;
	}
	public void setCodMotivoReprogramacion(String codMotivoReprogramacion) {
		CodMotivoReprogramacion = codMotivoReprogramacion;
	}
	public int getFechaCreo() {
		return FechaCreo;
	}
	public void setFechaCreo(int fechaCreo) {
		FechaCreo = fechaCreo;
	}
	public int getHoraCreo() {
		return HoraCreo;
	}
	public void setHoraCreo(int horaCreo) {
		HoraCreo = horaCreo;
	}
	public String getUsuarioReprogramo() {
		return UsuarioReprogramo;
	}
	public void setUsuarioReprogramo(String usuarioReprogramo) {
		UsuarioReprogramo = usuarioReprogramo;
	}
	public String getFechaReprogramo() {
		return FechaReprogramo;
	}
	public void setFechaReprogramo(String fechaReprogramo) {
		FechaReprogramo = fechaReprogramo;
	}
	public String getHoraReprogramo() {
		return HoraReprogramo;
	}
	public void setHoraReprogramo(String horaReprogramo) {
		HoraReprogramo = horaReprogramo;
	}
	public String getUsuarioCreo() {
		return UsuarioCreo;
	}
	public void setUsuarioCreo(String usuarioCreo) {
		UsuarioCreo = usuarioCreo;
	}
	
	public String getPersonaCreo() {
		return PersonaCreo;
	}
	public void setPersonaCreo(String personaCreo) {
		PersonaCreo = personaCreo;
	}
	public String getPersonaReprogramo() {
		return PersonaReprogramo;
	}
	public void setPersonaReprogramo(String personaReprogramo) {
		PersonaReprogramo = personaReprogramo;
	}
	public String getMotivo() {
		return Motivo;
	}
	public void setMotivo(String motivo) {
		Motivo = motivo;
	}
	public String getMotivoAnulacion() {
		return MotivoAnulacion;
	}
	public void setMotivoAnulacion(String motivoAnulacion) {
		MotivoAnulacion = motivoAnulacion;
	}
	public String getMotivoConfirmacion() {
		return MotivoConfirmacion;
	}
	public void setMotivoConfirmacion(String motivoConfirmacion) {
		MotivoConfirmacion = motivoConfirmacion;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getConductor() {
		return Conductor;
	}
	public void setConductor(String conductor) {
		Conductor = conductor;
	}
	public Integer getCodEmpAsesor() {
		return CodEmpAsesor;
	}
	public void setCodEmpAsesor(Integer codEmpAsesor) {
		CodEmpAsesor = codEmpAsesor;
	}
	public Integer getCodEmpTecnico() {
		return CodEmpTecnico;
	}
	public void setCodEmpTecnico(Integer codEmpTecnico) {
		CodEmpTecnico = codEmpTecnico;
	}
	public String getFechaVenta() {
		return FechaVenta;
	}
	public void setFechaVenta(String fechaVenta) {
		FechaVenta = fechaVenta;
	}
	public String getCodColor() {
		return CodColor;
	}
	public void setCodColor(String codColor) {
		CodColor = codColor;
	}
	public String getModalidadOperacion() {
		return ModalidadOperacion;
	}
	public void setModalidadOperacion(String modalidadOperacion) {
		ModalidadOperacion = modalidadOperacion;
	}
	public String getLineaProduccion() {
		return LineaProduccion;
	}
	public void setLineaProduccion(String lineaProduccion) {
		LineaProduccion = lineaProduccion;
	}
	public String getTurno() {
		return Turno;
	}
	public void setTurno(String turno) {
		Turno = turno;
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
	public String getHoraEjecucion() {
		return HoraEjecucion;
	}
	public void setHoraEjecucion(String horaEjecucion) {
		HoraEjecucion = horaEjecucion;
	}
	public String getDescMarca() {
		return DescMarca;
	}
	public void setDescMarca(String descMarca) {
		DescMarca = descMarca;
	}
	public String getDescTaller() {
		return DescTaller;
	}
	public void setDescTaller(String descTaller) {
		DescTaller = descTaller;
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
	public Integer getKilometrajeMRS() {
		return KilometrajeMRS;
	}
	public void setKilometrajeMRS(Integer kilometrajeMRS) {
		KilometrajeMRS = kilometrajeMRS;
	}
	public String getCombustible() {
		return Combustible;
	}
	public void setCombustible(String combustible) {
		Combustible = combustible;
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
	public Integer getRecomendTecnica() {
		return RecomendTecnica;
	}
	public void setRecomendTecnica(Integer recomendTecnica) {
		RecomendTecnica = recomendTecnica;
	}
	public Integer getCampanias() {
		return Campanias;
	}
	public void setCampanias(Integer campanias) {
		Campanias = campanias;
	}
	public Integer getMantPrepagado() {
		return MantPrepagado;
	}
	public void setMantPrepagado(Integer mantPrepagado) {
		MantPrepagado = mantPrepagado;
	}
	public Integer getMantPeriodico() {
		return MantPeriodico;
	}
	public void setMantPeriodico(Integer mantPeriodico) {
		MantPeriodico = mantPeriodico;
	}
	public String getCompania() {
		return Compania;
	}
	public void setCompania(String compania) {
		Compania = compania;
	}
	public Integer getNoCita() {
		return NoCita;
	}
	public void setNoCita(Integer noCita) {
		NoCita = noCita;
	}
	public Date getFechaHoraCita() {
		return FechaHoraCita;
	}
	public void setFechaHoraCita(Date fechaHoraCita) {
		FechaHoraCita = fechaHoraCita;
	}
	public Integer getCodCliente() {
		return CodCliente;
	}
	public void setCodCliente(Integer codCliente) {
		CodCliente = codCliente;
	}
	public String getNombreCliente() {
		return NombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		NombreCliente = nombreCliente;
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
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	public Integer getAnio() {
		return Anio;
	}
	public void setAnio(Integer anio) {
		Anio = anio;
	}
	public String getCodAsesor() {
		return CodAsesor;
	}
	public void setCodAsesor(String codAsesor) {
		CodAsesor = codAsesor;
	}
	public String getNombreAsesor() {
		return NombreAsesor;
	}
	public void setNombreAsesor(String nombreAsesor) {
		NombreAsesor = nombreAsesor;
	}
	public String getTipoOrden() {
		return TipoOrden;
	}
	public void setTipoOrden(String tipoOrden) {
		TipoOrden = tipoOrden;
	}
	public String getModalidadMant() {
		return ModalidadMant;
	}
	public void setModalidadMant(String modalidadMant) {
		ModalidadMant = modalidadMant;
	}
	public String getTipoMant() {
		return TipoMant;
	}
	public void setTipoMant(String tipoMant) {
		TipoMant = tipoMant;
	}
	public String getModKitRep() {
		return ModKitRep;
	}
	public void setModKitRep(String modKitRep) {
		ModKitRep = modKitRep;
	}
	public Integer getNoPresupuesto() {
		return NoPresupuesto;
	}
	public void setNoPresupuesto(Integer noPresupuesto) {
		NoPresupuesto = noPresupuesto;
	}
	public Integer getNoOrden() {
		return NoOrden;
	}
	public void setNoOrden(Integer noOrden) {
		NoOrden = noOrden;
	}
	public void setCodMarca(String codMarca) {
		CodMarca = codMarca;
	}
	public String getCodMarca() {
		return CodMarca;
	}
	public void setCodModalidadMant(String codModalidadMant) {
		CodModalidadMant = codModalidadMant;
	}
	public String getCodModalidadMant() {
		return CodModalidadMant;
	}
	public void setCodTipoOrden(String codTipoOrden) {
		CodTipoOrden = codTipoOrden;
	}
	public String getCodTipoOrden() {
		return CodTipoOrden;
	}
	public void setCodTipoMant(String codTipoMant) {
		CodTipoMant = codTipoMant;
	}
	public String getCodTipoMant() {
		return CodTipoMant;
	}
	public void setUltimoManten(String ultimoManten) {
		UltimoManten = ultimoManten;
	}
	public String getUltimoManten() {
		return UltimoManten;
	}
	public void setActualizarCliente(Integer actualizarCliente) {
		ActualizarCliente = actualizarCliente;
	}
	public Integer getActualizarCliente() {
		return ActualizarCliente;
	}
	public void setCodTaller(String codTaller) {
		CodTaller = codTaller;
	}
	public String getCodTaller() {
		return CodTaller;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getCategoriaMec() {
		return CategoriaMec;
	}
	public void setCategoriaMec(String categoriaMec) {
		CategoriaMec = categoriaMec;
	}
	public String getMntSugerido() {
		return MntSugerido;
	}
	public void setMntSugerido(String mntSugerido) {
		MntSugerido = mntSugerido;
	}
	public int getTelefono() {
		return Telefono;
	}
	public void setTelefono(int telefono) {
		Telefono = telefono;
	}
	public String getClienteEsperaR() {
		return ClienteEsperaR;
	}
	public void setClienteEsperaR(String clienteEsperaR) {
		ClienteEsperaR = clienteEsperaR;
	}
	public String getTipoVehiculo() {
		return TipoVehiculo;
	}
	public void setTipoVehiculo(String tipoVehiculo) {
		TipoVehiculo = tipoVehiculo;
	}
	public String getHoraFinCita() {
		return HoraFinCita;
	}
	public void setHoraFinCita(String horaFinCita) {
		HoraFinCita = horaFinCita;
	}
	public String getDescEstado() {
		return DescEstado;
	}
	public void setDescEstado(String descEstado) {
		DescEstado = descEstado;
	}
	public String getSubEstado() {
		return SubEstado;
	}
	public void setSubEstado(String subEstado) {
		SubEstado = subEstado;
	}
	public String getFuente() {
		return Fuente;
	}
	public void setFuente(String fuente) {
		Fuente = fuente;
	}
	public String getClienteTraeR() {
		return ClienteTraeR;
	}
	public void setClienteTraeR(String clienteTraeR) {
		ClienteTraeR = clienteTraeR;
	}
	public double getTiempoAsesorTecnico() {
		return TiempoAsesorTecnico;
	}
	public void setTiempoAsesorTecnico(double tiempoAsesorTecnico) {
		TiempoAsesorTecnico = tiempoAsesorTecnico;
	}
	public String getParaConfirmar() {
		return ParaConfirmar;
	}
	public void setParaConfirmar(String paraConfirmar) {
		ParaConfirmar = paraConfirmar;
	}
	public int getTiempoAsesorServicio() {
		return TiempoAsesorServicio;
	}
	public void setTiempoAsesorServicio(int tiempoAsesorServicio) {
		TiempoAsesorServicio = tiempoAsesorServicio;
	}
	
	
}
