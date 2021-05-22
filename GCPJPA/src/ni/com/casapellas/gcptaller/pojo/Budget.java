package ni.com.casapellas.gcptaller.pojo;

import java.math.BigDecimal;

public class Budget {
	private String CodCompania;
	private String CodTaller;
	private int NoPresupuesto;
	private int CodCliente;
	private String Chasis;
	private String Placa;
	private String Observacion;
	private String ModMantenimiento;
	
	private String FechaPresupuesto;
	private Double ManoObra;
	private Double Materiales;
	private Double Repuesto;
	private Double MaterialPintura;
	private Double Total;
	private int NoOrden;
	private String Estado;
	private String TipoPresupuesto;
	private String Observaciones;
	private String Estado2;
	private int NoCita;
	
	private String CodItem; 
	private String DescripcionItem;
	private String TipoItem;
	private String DecTipoPresupuesto;
	private String NombreCliente; 
	private String DescTaller;
	private Double ValorItem;
	
	private int Cantidad;
	private String Moneda;
	private BigDecimal TasaCambio;
	private String LineaProduccion;
	
	private String ClasifActiv;
	private Double Duracion;
	private String DescEstado;
	
	
	private int NoProforma;
	private double PrecioProf;
	
	private String Modelo;
	private String Marca;
	
	//Nuevo campos de 
	private String Aseguradora;
	private String DireccionCliente;
	private int TelefonoCliente;
	private int Anio;
	private String SubModelo;
	private String Color;
	private int Puertas;
	
	private String Programa;
	//--------------------------
	
	private String EsReal;
	
	
	public int getNoProforma() {
		return NoProforma;
	}
	public String getAseguradora() {
		return Aseguradora;
	}
	public void setAseguradora(String aseguradora) {
		Aseguradora = aseguradora;
	}
	public String getDireccionCliente() {
		return DireccionCliente;
	}
	public void setDireccionCliente(String direccionCliente) {
		DireccionCliente = direccionCliente;
	}
	public String getSubModelo() {
		return SubModelo;
	}
	public void setSubModelo(String subModelo) {
		SubModelo = subModelo;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public int getPuertas() {
		return Puertas;
	}
	public void setPuertas(int puertas) {
		Puertas = puertas;
	}
	public void setNoProforma(int noProforma) {
		NoProforma = noProforma;
	}
	public double getPrecioProf() {
		return PrecioProf;
	}
	public void setPrecioProf(double precioProf) {
		PrecioProf = precioProf;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public String getMoneda() {
		return Moneda;
	}
	public void setMoneda(String moneda) {
		Moneda = moneda;
	}
	public String getLineaProduccion() {
		return LineaProduccion;
	}
	public void setLineaProduccion(String lineaProduccion) {
		LineaProduccion = lineaProduccion;
	}
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getCodItem() {
		return CodItem;
	}
	public void setCodItem(String codItem) {
		CodItem = codItem;
	}
	public String getDescripcionItem() {
		return DescripcionItem;
	}
	public void setDescripcionItem(String descripcionItem) {
		DescripcionItem = descripcionItem;
	}
	public String getTipoItem() {
		return TipoItem;
	}
	public void setTipoItem(String tipoItem) {
		TipoItem = tipoItem;
	}
	public String getNombreCliente() {
		return NombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		NombreCliente = nombreCliente;
	}
	public String getDescTaller() {
		return DescTaller;
	}
	public void setDescTaller(String descTaller) {
		DescTaller = descTaller;
	}
	public String getFechaPresupuesto() {
		return FechaPresupuesto;
	}
	public void setFechaPresupuesto(String fechaPresupuesto) {
		FechaPresupuesto = fechaPresupuesto;
	}
	public Double getManoObra() {
		return ManoObra;
	}
	public void setManoObra(Double manoObra) {
		ManoObra = manoObra;
	}
	public Double getMateriales() {
		return Materiales;
	}
	public void setMateriales(Double materiales) {
		Materiales = materiales;
	}
	public Double getRepuesto() {
		return Repuesto;
	}
	public void setRepuesto(Double repuesto) {
		Repuesto = repuesto;
	}
	public Double getMaterialPintura() {
		return MaterialPintura;
	}
	public void setMaterialPintura(Double materialPintura) {
		MaterialPintura = materialPintura;
	}
	public Double getTotal() {
		return Total;
	}
	public void setTotal(Double total) {
		Total = total;
	}
	public int getNoOrden() {
		return NoOrden;
	}
	public void setNoOrden(int noOrden) {
		NoOrden = noOrden;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getTipoPresupuesto() {
		return TipoPresupuesto;
	}
	public void setTipoPresupuesto(String tipoPresupuesto) {
		TipoPresupuesto = tipoPresupuesto;
	}
	public String getObservaciones() {
		return Observaciones;
	}
	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}
	public String getEstado2() {
		return Estado2;
	}
	public void setEstado2(String estado2) {
		Estado2 = estado2;
	}
	public int getNoCita() {
		return NoCita;
	}
	public void setNoCita(int noCita) {
		NoCita = noCita;
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
	public int getNoPresupuesto() {
		return NoPresupuesto;
	}
	public void setNoPresupuesto(int noPresupuesto) {
		NoPresupuesto = noPresupuesto;
	}
	public int getCodCliente() {
		return CodCliente;
	}
	public void setCodCliente(int codCliente) {
		CodCliente = codCliente;
	}
	public String getChasis() {
		return Chasis;
	}
	public void setChasis(String chasis) {
		Chasis = chasis;
	}
	public String getPlaca() {
		return Placa;
	}
	public void setPlaca(String placa) {
		Placa = placa;
	}
	public String getObservacion() {
		return Observacion;
	}
	public void setObservacion(String observacion) {
		Observacion = observacion;
	}
	public String getModMantenimiento() {
		return ModMantenimiento;
	}
	public void setModMantenimiento(String modMantenimiento) {
		ModMantenimiento = modMantenimiento;
	}
	public String getDecTipoPresupuesto() {
		return DecTipoPresupuesto;
	}
	public void setDecTipoPresupuesto(String decTipoPresupuesto) {
		DecTipoPresupuesto = decTipoPresupuesto;
	}
	public Double getValorItem() {
		return ValorItem;
	}
	public void setValorItem(Double valorItem) {
		ValorItem = valorItem;
	}
	public BigDecimal getTasaCambio() {
		return TasaCambio;
	}
	public void setTasaCambio(BigDecimal tasaCambio) {
		TasaCambio = tasaCambio;
	}
	public Double getDuracion() {
		return Duracion;
	}
	public void setDuracion(Double duracion) {
		Duracion = duracion;
	}
	public String getClasifActiv() {
		return ClasifActiv;
	}
	public void setClasifActiv(String clasifActiv) {
		ClasifActiv = clasifActiv;
	}
	public String getDescEstado() {
		return DescEstado;
	}
	public void setDescEstado(String descEstado) {
		DescEstado = descEstado;
	}
	public int getTelefonoCliente() {
		return TelefonoCliente;
	}
	public void setTelefonoCliente(int telefonoCliente) {
		TelefonoCliente = telefonoCliente;
	}
	public int getAnio() {
		return Anio;
	}
	public void setAnio(int anio) {
		Anio = anio;
	}
	public String getPrograma() {
		return Programa;
	}
	public void setPrograma(String programa) {
		Programa = programa;
	}
	public String getEsReal() {
		return EsReal;
	}
	public void setEsReal(String esReal) {
		EsReal = esReal;
	}
}
