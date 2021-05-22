package ni.com.casapellas.gcptaller.pojo;

public class Vehicles {
	private Integer CodCliente;
	private String Chasis;
	private String Motor;
	private String Marca;
	private String Modelo;
	private String TipoVehiculo;
	private String Combustible;
	private Integer Anio;
	private String Placa;
	private String ColorExterno;
	private String ColorInterno;
	private Integer Kilometraje;
	private String TipoCliente;
	private String DescModelo;
	private String SegCliente;
	private Integer KmtsComparados;
	private String MntSugerido;
	private String NombreApellido;
	private String PersonaAsignada;
	private String TipoCalculo;
	private String CategoriaMec;
	private String Cilindraje;
	private String FechaVenta;
	private String DescColoExterno; 
	private String DescMarca;
	private String DescTipoVehiculo; 
	private String DescCombustible;
	private String ModeloFabrica;
	private String KitMantenimiento;
	private String Estado;
	private String DescEstado;
	private String FechaUltVisita;
	private String TieneCita;
	private Integer NumeroCita;
	private String TallerPreferencia;
	private Integer KilometrajeHoy;
	private String Flota;
	private String CodigoFlota;
	private Integer CodigoAsignado;
	private Integer CodigoEncargado;
	private String NombreAsignado;
	private String NombreEncargado;
	private Integer NumeroActivo;
	private String FechaProximoMantenimiento;
	
	private String DescripcionMantenimiento;
	private Integer codigoVendedor;
	private String NombreVendedor;
	private Long numeroFactura;
	
	private String SucursalActivo;
	private String UnidadNegocioActivo;
	
	private String CodigoAuto;
	
	private String FechaCita;
	private String HoraCita;
	private String TallerCita;
	
 
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
	public String getTallerCita() {
		return TallerCita;
	}
	public void setTallerCita(String tallerCita) {
		TallerCita = tallerCita;
	}
	public String getSucursalActivo() {
		return SucursalActivo;
	}
	public void setSucursalActivo(String sucursalActivo) {
		SucursalActivo = sucursalActivo;
	}
	public String getUnidadNegocioActivo() {
		return UnidadNegocioActivo;
	}
	public void setUnidadNegocioActivo(String unidadNegocioActivo) {
		UnidadNegocioActivo = unidadNegocioActivo;
	}
	public Integer getCodigoVendedor() {
		return codigoVendedor;
	}
	public void setCodigoVendedor(Integer codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}
	public Integer getNumeroCita() {
		return NumeroCita;
	}
	public Integer getKilometrajeHoy() {
		return KilometrajeHoy;
	}
	public String getNombreVendedor() {
		return NombreVendedor;
	}
	public void setNombreVendedor(String nombreVendedor) {
		NombreVendedor = nombreVendedor;
	}
	public Long getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(Long numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public void setNumeroCita(Integer numeroCita) {
		NumeroCita = numeroCita;
	}
	public void setKilometrajeHoy(Integer kilometrajeHoy) {
		KilometrajeHoy = kilometrajeHoy;
	}
	public String getNombreAsignado() {
		return NombreAsignado;
	}
	public void setNombreAsignado(String nombreAsignado) {
		NombreAsignado = nombreAsignado;
	}
	public String getNombreEncargado() {
		return NombreEncargado;
	}
	public void setNombreEncargado(String nombreEncargado) {
		NombreEncargado = nombreEncargado;
	}
	public Integer getNumeroActivo() {
		return NumeroActivo;
	}
	public void setNumeroActivo(Integer numeroActivo) {
		NumeroActivo = numeroActivo;
	}
	public String getCodigoFlota() {
		return CodigoFlota;
	}
	public void setCodigoFlota(String codigoFlota) {
		CodigoFlota = codigoFlota;
	}
	public Integer getCodigoAsignado() {
		return CodigoAsignado;
	}
	public void setCodigoAsignado(Integer codigoAsignado) {
		CodigoAsignado = codigoAsignado;
	}
	public Integer getCodigoEncargado() {
		return CodigoEncargado;
	}
	public void setCodigoEncargado(Integer codigoEncargado) {
		CodigoEncargado = codigoEncargado;
	}
	
	public String getTieneCita() {
		return TieneCita;
	}
	public void setTieneCita(String tieneCita) {
		TieneCita = tieneCita;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getDescEstado() {
		return DescEstado;
	}
	public void setDescEstado(String descEstado) {
		DescEstado = descEstado;
	}
	public String getDescCategoriaMec() {
		return DescCategoriaMec;
	}
	public void setDescCategoriaMec(String descCategoriaMec) {
		DescCategoriaMec = descCategoriaMec;
	}
	public String getDescFlota() {
		return DescFlota;
	}
	public void setDescFlota(String descFlota) {
		DescFlota = descFlota;
	}
	public String getDescCilindraje() {
		return DescCilindraje;
	}
	public void setDescCilindraje(String descCilindraje) {
		DescCilindraje = descCilindraje;
	}
	public String getDescTipoCalculo() {
		return DescTipoCalculo;
	}
	public void setDescTipoCalculo(String descTipoCalculo) {
		DescTipoCalculo = descTipoCalculo;
	}
		private String DescCategoriaMec;
        
        private String DescFlota;
        private String DescCilindraje;
        private String DescTipoCalculo;
        
	public String getModeloFabrica() {
		return ModeloFabrica;
	}
	public void setModeloFabrica(String modeloFabrica) {
		ModeloFabrica = modeloFabrica;
	}
	public String getKitMantenimiento() {
		return KitMantenimiento;
	}
	public void setKitMantenimiento(String kitMantenimiento) {
		KitMantenimiento = kitMantenimiento;
	}
	public String getDescColoExterno() {
		return DescColoExterno;
	}
	public void setDescColoExterno(String descColoExterno) {
		DescColoExterno = descColoExterno;
	}
	public String getDescMarca() {
		return DescMarca;
	}
	public void setDescMarca(String descMarca) {
		DescMarca = descMarca;
	}
	public String getDescTipoVehiculo() {
		return DescTipoVehiculo;
	}
	public void setDescTipoVehiculo(String descTipoVehiculo) {
		DescTipoVehiculo = descTipoVehiculo;
	}
	public String getDescCombustible() {
		return DescCombustible;
	}
	public void setDescCombustible(String descCombustible) {
		DescCombustible = descCombustible;
	}
	public String getCategoriaMec() {
		return CategoriaMec;
	}
	public void setCategoriaMec(String categoriaMec) {
		CategoriaMec = categoriaMec;
	}
	public String getCilindraje() {
		return Cilindraje;
	}
	public void setCilindraje(String cilindraje) {
		Cilindraje = cilindraje;
	}
	public Integer getKilometraje() {
		return Kilometraje;
	}
	public void setKilometraje(Integer kilometraje) {
		Kilometraje = kilometraje;
	}
	public String getTipoCliente() {
		return TipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		TipoCliente = tipoCliente;
	}
	public Integer getKmtsComparados() {
		return KmtsComparados;
	}
	public void setKmtsComparados(Integer kmtsComparados) {
		KmtsComparados = kmtsComparados;
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
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	public String getTipoVehiculo() {
		return TipoVehiculo;
	}
	public void setTipoVehiculo(String tipoVehiculo) {
		TipoVehiculo = tipoVehiculo;
	}
	public String getCombustible() {
		return Combustible;
	}
	public void setCombustible(String combustible) {
		Combustible = combustible;
	}
	public Integer getAnio() {
		return Anio;
	}
	public void setAnio(Integer anio) {
		Anio = anio;
	}
	public String getPlaca() {
		return Placa;
	}
	public void setPlaca(String placa) {
		Placa = placa;
	}
	public String getColorExterno() {
		return ColorExterno;
	}
	public void setColorExterno(String colorExterno) {
		ColorExterno = colorExterno;
	}
	public String getColorInterno() {
		return ColorInterno;
	}
	public void setColorInterno(String colorInterno) {
		ColorInterno = colorInterno;
	}


	public String getDescModelo() {
		return DescModelo;
	}
	public void setDescModelo(String descModelo) {
		DescModelo = descModelo;
	}
	public String getSegCliente() {
		return SegCliente;
	}
	public void setSegCliente(String segCliente) {
		SegCliente = segCliente;
	}

	public String getMntSugerido() {
		return MntSugerido;
	}
	public void setMntSugerido(String mntSugerido) {
		MntSugerido = mntSugerido;
	}
	public void setNombreApellido(String nombreApellido) {
		NombreApellido = nombreApellido;
	}
	public String getNombreApellido() {
		return NombreApellido;
	}
	public void setPersonaAsignada(String personaAsignada) {
		PersonaAsignada = personaAsignada;
	}
	public String getPersonaAsignada() {
		return PersonaAsignada;
	}
	public void setTipoCalculo(String tipoCalculo) {
		TipoCalculo = tipoCalculo;
	}
	public String getTipoCalculo() {
		return TipoCalculo;
	}
	public void setFlota(String flota) {
		Flota = flota;
	}
	public String getFlota() {
		return Flota;
	}
	public String getFechaVenta() {
		return FechaVenta;
	}
	public void setFechaVenta(String fechaVenta) {
		FechaVenta = fechaVenta;
	}
	public String getFechaUltVisita() {
		return FechaUltVisita;
	}
	public void setFechaUltVisita(String fechaUltVisita) {
		FechaUltVisita = fechaUltVisita;
	}
	public String getTallerPreferencia() {
		return TallerPreferencia;
	}
	public void setTallerPreferencia(String tallerPreferencia) {
		TallerPreferencia = tallerPreferencia;
	}

	public String getFechaProximoMantenimiento() {
		return FechaProximoMantenimiento;
	}
	public void setFechaProximoMantenimiento(String fechaProximoMantenimiento) {
		FechaProximoMantenimiento = fechaProximoMantenimiento;
	}
	public String getDescripcionMantenimiento() {
		return DescripcionMantenimiento;
	}
	public void setDescripcionMantenimiento(String descripcionMantenimiento) {
		DescripcionMantenimiento = descripcionMantenimiento;
	}
	public String getCodigoAuto() {
		return CodigoAuto;
	}
	public void setCodigoAuto(String codigoAuto) {
		CodigoAuto = codigoAuto;
	}
	
}
