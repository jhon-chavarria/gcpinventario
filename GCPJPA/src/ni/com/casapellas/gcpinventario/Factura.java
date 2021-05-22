package ni.com.casapellas.gcpinventario;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.codehaus.jackson.annotate.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ni.com.casapellas.util.CustomValidationMessage;

@ApiModel(value = "Factura(Cabecera)")
public class Factura {
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, message = CustomValidationMessage.COMPANIA_REQUERIDA)
	@ApiModelProperty(name = "CODIGO_COMPANNIA", required = true, value = "Codigo de la Compania", example = "01", dataType = "String")
	@JsonProperty("CODIGO_COMPANNIA")
	private String CODIGO_COMPANNIA;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, message = CustomValidationMessage.SUCURSAL_REQUERIDA)
	@ApiModelProperty(name = "CODIGO_SUCURSAL", required = true, value = "Codigo sucursal", example = "00", dataType = "String")
	@JsonProperty("CODIGO_SUCURSAL")
	private String CODIGO_SUCURSAL;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, message = CustomValidationMessage.DEPARTAMENTO_REQUERIDO)
	@ApiModelProperty(name = "CODIGO_DEPARTAMENTO", required = true, value = "Codigo de departamento", example = "00", dataType = "String")
	@JsonProperty("CODIGO_DEPARTAMENTO")
	private String CODIGO_DEPARTAMENTO;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ApiModelProperty(name = "TIPO_MOVIMIENTO", required = true, value = "Tipo movimiento", example = "21", dataType = "String")
	@JsonProperty("TIPO_MOVIMIENTO")
	private String TIPO_MOVIMIENTO;
	
	@ApiModelProperty(name = "TIPO_MOVIMIENTO_JDE", required = true, value = "Tipo movimiento jde", example = "Y1", dataType = "String")
	@JsonProperty("TIPO_MOVIMIENTO_JDE")
	private String TIPO_MOVIMIENTO_JDE;
	
	@ApiModelProperty(name = "NUMERO_DOCUMENTO", required = true, value = "Numero de factura", example = "88888890", dataType = "String")
	@JsonProperty("NUMERO_DOCUMENTO")
	private String NUMERO_DOCUMENTO;
	
	@ApiModelProperty(name = "NUMERO_DOCUMENTO_ORIGINAL", value = "Numero de factura original", example = "88888890", dataType = "String")
	@JsonProperty("NUMERO_DOCUMENTO_ORIGINAL")
	private String NUMERO_DOCUMENTO_ORIGINAL;
	
	@ApiModelProperty(name = "NUMERO_BATCH", value = "Numero de batch", example = "25631", dataType = "String")
	@JsonProperty("NUMERO_BATCH")
	private String NUMERO_BATCH;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 5,max = 35, message = "La longitud del nombre del cliente es invalida")
	@ApiModelProperty(name = "NOMBRE_CLIENTE", required = true, value = "Nombre Cliente", example = "Jose Adan Blandon", dataType = "String")
	@JsonProperty("NOMBRE_CLIENTE")
	private String NOMBRE_CLIENTE;
	
	@JsonProperty("CODIGO_CANAL_VENTA")
	@ApiModelProperty(name = "CODIGO_CANAL_VENTA", required = true, value = "Codigo del canal de venta", example = "M", dataType = "String")
	private String CODIGO_CANAL_VENTA;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ApiModelProperty(name = "TIPO_CONDICION_PAGO", required = true, value = "Condicion de Pago. Contado, Credito, Anulacion, Devolucion", example = "Contado", dataType = "String")
	@JsonProperty("TIPO_CONDICION_PAGO")
	private String TIPO_CONDICION_PAGO;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ApiModelProperty(name = "CODIGO_MONEDA", required = true, value = "Codigo de la moneda", notes = "Este campo puede tener los siguientes valores: COR, DOL", example = "COR", dataType = "String")
	@JsonProperty("CODIGO_MONEDA")
	private String CODIGO_MONEDA;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Min(value = 0, message =CustomValidationMessage.CAMPO_POSITIVO)
	@ApiModelProperty(name = "TOTAL_ML", required = true, value = "Total de la factura en moneda local", example = "12.52", dataType = "Number")
	@JsonProperty("TOTAL_ML")
	private BigDecimal TOTAL_ML;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Min(value = 0, message =CustomValidationMessage.CAMPO_POSITIVO)
	@ApiModelProperty(name = "TOTAL_DESCUENTO_ML", required = true, value = "Total del descuento en moneda local", example = "12.52", dataType = "Number")
	@JsonProperty("TOTAL_DESCUENTO_ML")
	private BigDecimal TOTAL_DESCUENTO_ML;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Min(value = 0, message =CustomValidationMessage.CAMPO_POSITIVO)
	@ApiModelProperty(name = "TOTAL_IMPIVA_ML", required = true, value = "Total del impuesto de venta en moneda local", example = "12.52", dataType = "Number")
	@JsonProperty("TOTAL_IMPIVA_ML")
	private BigDecimal TOTAL_IMPIVA_ML;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Min(value = 0, message =CustomValidationMessage.CAMPO_POSITIVO)
	@ApiModelProperty(name = "TOTAL_IMPISC_ML", required = true, value = "Total del impuesto al consumo en moneda local", example = "12.52", dataType = "Number")
	@JsonProperty("TOTAL_IMPISC_ML")
	private BigDecimal TOTAL_IMPISC_ML;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Min(value = 0, message =CustomValidationMessage.CAMPO_POSITIVO)
	@ApiModelProperty(name = "TOTAL_ME", required = true, value = "Total de la factura en moneda extranjera", example = "12.52", dataType = "Number")
	@JsonProperty("TOTAL_ME")
	private BigDecimal TOTAL_ME;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Min(value = 0, message =CustomValidationMessage.CAMPO_POSITIVO)
	@ApiModelProperty(name = "TOTAL_DESCUENTO_ME", required = true, value = "Total del descuento en moneda extranjera", example = "12.52", dataType = "Number")
	@JsonProperty("TOTAL_DESCUENTO_ME")
	private BigDecimal TOTAL_DESCUENTO_ME;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Min(value = 0, message =CustomValidationMessage.CAMPO_POSITIVO)
	@ApiModelProperty(name = "TOTAL_IMPIVA_ME", required = true, value = "Total del impuesto de venta en moneda extranjera", example = "12.52", dataType = "Number")
	@JsonProperty("TOTAL_IMPIVA_ME")
	private BigDecimal TOTAL_IMPIVA_ME;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Min(value = 0, message =CustomValidationMessage.CAMPO_POSITIVO)
	@ApiModelProperty(name = "TOTAL_IMPISC_ME", required = true, value = "Total del impuesto al consumo en moneda extranjera", example = "12.52", dataType = "Number")
	@JsonProperty("TOTAL_IMPISC_ME")
	private BigDecimal TOTAL_IMPISC_ME;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 5, max = 20, message = CustomValidationMessage.CODIGO_USUARIO_REQUERIDO)
	@ApiModelProperty(name = "USUARIO", required = true, value = "Usuario que genera el movimiento", example = "PRUEBAS", dataType = "String")
	@JsonProperty("USUARIO")
	private String USUARIO;
	
	@ApiModelProperty(name = "MOTIVO_ANULACION", value = "Motivo de la anulacion. Solo es requerido cuando se esta anulando o devolviendo.", example = "A", dataType = "String")
	@JsonProperty("MOTIVO_ANULACION")
	private String MOTIVO_ANULACION;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ApiModelProperty(name = "FECHA_MOVIMIENTO", required = true, value = "Fecha factura con formato ddMMyyyyy", example = "20200101", dataType = "String")
	@JsonProperty("FECHA_MOVIMIENTO")
	private String FECHA_MOVIMIENTO;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ApiModelProperty(name = "HORA_MOVIMIENTO", required = true, value = "Hora factura formato HHmmss", example = "130000", dataType = "String")
	@JsonProperty("HORA_MOVIMIENTO")
	private String HORA_MOVIMIENTO;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ApiModelProperty(name = "TIPO_CAMBIO", required = true, value = "Factor de Cambio a usar en el movimiento", example = "35.25", dataType = "String")
	@JsonProperty("TIPO_CAMBIO")
	private String TIPO_CAMBIO;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ApiModelProperty(name = "FECHA_REGISTRO", required = true, value = "Fecha de regsitro del movimiento con formato yyyyMMdd", example = "20200101", dataType = "String")
	@JsonProperty("FECHA_REGISTRO")
	private String FECHA_REGISTRO;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, max = 3, message = CustomValidationMessage.CODIGO_VENDEDOR_CORTO_REQUERIDO)
	@ApiModelProperty(name = "CODIGO_VENDEDOR_C", required = true, value = "Codigo corto del vendedor", example = "AL", dataType = "String")
	@JsonProperty("CODIGO_VENDEDOR_C")
	private String CODIGO_VENDEDOR_C;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, message = CustomValidationMessage.CODIGO_VENDEDOR_LARGO_REQUERIDO)
	@ApiModelProperty(name = "CODIGO_VENDEDOR_L", required = true, value = "Codigo largo del vendedor", example = "45612", dataType = "String")
	@JsonProperty("CODIGO_VENDEDOR_L")
	private String CODIGO_VENDEDOR_L;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, message = CustomValidationMessage.CODIGO_CLIENTE_REQUERIDO)
	@ApiModelProperty(name = "CODIGO_CLIENTE", required = true, value = "Codigo del cliente", example = "0", dataType = "String")
	@JsonProperty("CODIGO_CLIENTE")
	private String CODIGO_CLIENTE;
	
	@NotNull(message = CustomValidationMessage.LISTA_NONULO)
	@ApiModelProperty(name = "productos", required = true, value = "Detalle de la factura")
	@JsonProperty("productos")
	private List<FacturaDetalle> productos;
	
	@ApiModelProperty(name = "FACTURA_DENEGADA", value = "Propiedad que indica si la factura es denegada o no", example="S", notes = "Notas del campo", dataType = "String")
	@JsonProperty("FACTURA_DENEGADA")
	private String FACTURA_DENEGADA;
	
	@ApiModelProperty(name = "CODIGO_PROMOCIONAL", value = "Propiedad para los valores de promociones", example="SSS", notes = "Codgos de promocion", dataType = "String")
	@JsonProperty("CODIGO_PROMOCIONAL")
	private String CODIGO_PROMOCIONAL;

	public String getCODIGO_PROMOCIONAL() {
		return CODIGO_PROMOCIONAL;
	}

	public void setCODIGO_PROMOCIONAL(String cODIGO_PROMOCIONAL) {
		CODIGO_PROMOCIONAL = cODIGO_PROMOCIONAL;
	}

	public String getFACTURA_DENEGADA() {
		return FACTURA_DENEGADA;
	}

	public void setFACTURA_DENEGADA(String fACTURA_DENEGADA) {
		FACTURA_DENEGADA = fACTURA_DENEGADA;
	}

	public String getNUMERO_BATCH() {
		return NUMERO_BATCH;
	}

	public void setNUMERO_BATCH(String nUMERO_BATCH) {
		NUMERO_BATCH = nUMERO_BATCH;
	}

	public String getNUMERO_DOCUMENTO_ORIGINAL() {
		return NUMERO_DOCUMENTO_ORIGINAL;
	}

	public void setNUMERO_DOCUMENTO_ORIGINAL(String nUMERO_DOCUMENTO_ORIGINAL) {
		NUMERO_DOCUMENTO_ORIGINAL = nUMERO_DOCUMENTO_ORIGINAL;
	}

	public String getHORA_MOVIMIENTO() {
		return HORA_MOVIMIENTO;
	}

	public void setHORA_MOVIMIENTO(String hORA_MOVIMIENTO) {
		HORA_MOVIMIENTO = hORA_MOVIMIENTO;
	}

	public List<FacturaDetalle> getProductos() {
		return productos;
	}

	public void setProductos(List<FacturaDetalle> productos) {
		this.productos = productos;
	}

	public String getCODIGO_COMPANNIA() {
		return CODIGO_COMPANNIA;
	}

	public String getCODIGO_SUCURSAL() {
		return CODIGO_SUCURSAL;
	}

	public String getTIPO_MOVIMIENTO() {
		return TIPO_MOVIMIENTO;
	}

	public String getTIPO_MOVIMIENTO_JDE() {
		return TIPO_MOVIMIENTO_JDE;
	}

	public String getNUMERO_DOCUMENTO() {
		return NUMERO_DOCUMENTO;
	}

	public String getFECHA_MOVIMIENTO() {
		return FECHA_MOVIMIENTO;
	}

	public String getTIPO_CAMBIO() {
		return TIPO_CAMBIO;
	}

	public String getFECHA_REGISTRO() {
		return FECHA_REGISTRO;
	}

	public String getCODIGO_VENDEDOR_C() {
		return CODIGO_VENDEDOR_C;
	}

	public String getCODIGO_VENDEDOR_L() {
		return CODIGO_VENDEDOR_L;
	}

	public String getCODIGO_CLIENTE() {
		return CODIGO_CLIENTE;
	}

	public String getNOMBRE_CLIENTE() {
		return NOMBRE_CLIENTE;
	}

	public String getCODIGO_CANAL_VENTA() {
		return CODIGO_CANAL_VENTA;
	}

	public String getTIPO_CONDICION_PAGO() {
		return TIPO_CONDICION_PAGO;
	}

	public String getCODIGO_MONEDA() {
		return CODIGO_MONEDA;
	}

	public BigDecimal getTOTAL_ML() {
		return TOTAL_ML;
	}

	public BigDecimal getTOTAL_DESCUENTO_ML() {
		return TOTAL_DESCUENTO_ML;
	}

	public BigDecimal getTOTAL_IMPIVA_ML() {
		return TOTAL_IMPIVA_ML;
	}

	public BigDecimal getTOTAL_IMPISC_ML() {
		return TOTAL_IMPISC_ML;
	}

	public BigDecimal getTOTAL_ME() {
		return TOTAL_ME;
	}

	public BigDecimal getTOTAL_DESCUENTO_ME() {
		return TOTAL_DESCUENTO_ME;
	}

	public BigDecimal getTOTAL_IMPIVA_ME() {
		return TOTAL_IMPIVA_ME;
	}

	public BigDecimal getTOTAL_IMPISC_ME() {
		return TOTAL_IMPISC_ME;
	}

	public String getUSUARIO() {
		return USUARIO;
	}

	public void setCODIGO_COMPANNIA(String cODIGO_COMPANNIA) {
		CODIGO_COMPANNIA = cODIGO_COMPANNIA;
	}

	public void setCODIGO_SUCURSAL(String cODIGO_SUCURSAL) {
		CODIGO_SUCURSAL = cODIGO_SUCURSAL;
	}

	public void setTIPO_MOVIMIENTO(String tIPO_MOVIMIENTO) {
		TIPO_MOVIMIENTO = tIPO_MOVIMIENTO;
	}

	public void setTIPO_MOVIMIENTO_JDE(String tIPO_MOVIMIENTO_JDE) {
		TIPO_MOVIMIENTO_JDE = tIPO_MOVIMIENTO_JDE;
	}

	public void setNUMERO_DOCUMENTO(String nUMERO_DOCUMENTO) {
		NUMERO_DOCUMENTO = nUMERO_DOCUMENTO;
	}

	public void setFECHA_MOVIMIENTO(String fECHA_MOVIMIENTO) {
		FECHA_MOVIMIENTO = fECHA_MOVIMIENTO;
	}

	public void setTIPO_CAMBIO(String tIPO_CAMBIO) {
		TIPO_CAMBIO = tIPO_CAMBIO;
	}

	public void setFECHA_REGISTRO(String fECHA_REGISTRO) {
		FECHA_REGISTRO = fECHA_REGISTRO;
	}

	public void setCODIGO_VENDEDOR_C(String cODIGO_VENDEDOR_C) {
		CODIGO_VENDEDOR_C = cODIGO_VENDEDOR_C;
	}

	public void setCODIGO_VENDEDOR_L(String cODIGO_VENDEDOR_L) {
		CODIGO_VENDEDOR_L = cODIGO_VENDEDOR_L;
	}

	public void setCODIGO_CLIENTE(String cODIGO_CLIENTE) {
		CODIGO_CLIENTE = cODIGO_CLIENTE;
	}

	public void setNOMBRE_CLIENTE(String nOMBRE_CLIENTE) {
		NOMBRE_CLIENTE = nOMBRE_CLIENTE;
	}

	public void setCODIGO_CANAL_VENTA(String cODIGO_CANAL_VENTA) {
		CODIGO_CANAL_VENTA = cODIGO_CANAL_VENTA;
	}

	public void setTIPO_CONDICION_PAGO(String tIPO_CONDICION_PAGO) {
		TIPO_CONDICION_PAGO = tIPO_CONDICION_PAGO;
	}

	public void setCODIGO_MONEDA(String cODIGO_MONEDA) {
		CODIGO_MONEDA = cODIGO_MONEDA;
	}

	public void setTOTAL_ML(BigDecimal tOTAL_ML) {
		TOTAL_ML = tOTAL_ML;
	}

	public void setTOTAL_DESCUENTO_ML(BigDecimal tOTAL_DESCUENTO_ML) {
		TOTAL_DESCUENTO_ML = tOTAL_DESCUENTO_ML;
	}

	public void setTOTAL_IMPIVA_ML(BigDecimal tOTAL_IMPIVA_ML) {
		TOTAL_IMPIVA_ML = tOTAL_IMPIVA_ML;
	}

	public void setTOTAL_IMPISC_ML(BigDecimal tOTAL_IMPISC_ML) {
		TOTAL_IMPISC_ML = tOTAL_IMPISC_ML;
	}

	public void setTOTAL_ME(BigDecimal tOTAL_ME) {
		TOTAL_ME = tOTAL_ME;
	}

	public void setTOTAL_DESCUENTO_ME(BigDecimal tOTAL_DESCUENTO_ME) {
		TOTAL_DESCUENTO_ME = tOTAL_DESCUENTO_ME;
	}

	public void setTOTAL_IMPIVA_ME(BigDecimal tOTAL_IMPIVA_ME) {
		TOTAL_IMPIVA_ME = tOTAL_IMPIVA_ME;
	}

	public void setTOTAL_IMPISC_ME(BigDecimal tOTAL_IMPISC_ME) {
		TOTAL_IMPISC_ME = tOTAL_IMPISC_ME;
	}

	public void setUSUARIO(String uSUARIO) {
		USUARIO = uSUARIO;
	}

	public String getMOTIVO_ANULACION() {
		return MOTIVO_ANULACION;
	}

	public void setMOTIVO_ANULACION(String mOTIVO_ANULACION) {
		MOTIVO_ANULACION = mOTIVO_ANULACION;
	}

	/**
	 * @return the cODIGO_DEPARTAMENTO
	 */
	public String getCODIGO_DEPARTAMENTO() {
		return CODIGO_DEPARTAMENTO;
	}

	/**
	 * @param cODIGO_DEPARTAMENTO the cODIGO_DEPARTAMENTO to set
	 */
	public void setCODIGO_DEPARTAMENTO(String cODIGO_DEPARTAMENTO) {
		CODIGO_DEPARTAMENTO = cODIGO_DEPARTAMENTO;
	}
}
