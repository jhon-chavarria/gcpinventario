package ni.com.casapellas.gcpinventario;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ni.com.casapellas.util.CustomValidationMessage;
@ApiModel(value = "Factura (Detalle)")
public class FacturaDetalle {
	@JsonProperty("CODIGO_ARTICULO")
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, message = CustomValidationMessage.ARTICULO_REQUERIDO)
	@ApiModelProperty(name = "CODIGO_ARTICULO", required = true, example = "01PRUEBA", value = "Codigo articulo", dataType = "String")
	private String CODIGO_ARTICULO; 
	
	@JsonProperty("CODIGO_CATEGORIA")
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)	
	@ApiModelProperty(required = true, example = "01", value = "Codigo categoria", dataType = "String")
	private String CODIGO_CATEGORIA; 
	
	@JsonProperty("CODIGO_BODEGA")
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)	
	@ApiModelProperty(required = true, example = "01", value = "Codigo bodega", dataType = "String")
	private String CODIGO_BODEGA; 
	
	@JsonProperty("CANTIDAD")
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)	
	@ApiModelProperty(required = true, example = "1", value = "Codigo bodega", dataType = "float")
	private float CANTIDAD; 
	
	@JsonProperty("PRECIO")
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)	
	@ApiModelProperty(required = true, example = "25.25", value = "Precio articulo", dataType = "float")
	private float PRECIO; 
	
	@JsonProperty("CODIGO_MODENA")
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)	
	@ApiModelProperty(required = true, example = "COR", value = "Codigo moneda COR/USD", dataType = "string")
	private String CODIGO_MODENA;
	
	@JsonProperty("SECUENCIA")
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)	
	@ApiModelProperty(required = true, example = "1", value = "Secuencia articulo", dataType = "int")
	private int SECUENCIA;
	
	@JsonProperty("PRECIOUSD")
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)	
	@ApiModelProperty(required = true, example = "0", value = "Precio dollar", dataType = "float")
	private float PRECIOUSD;
	
	@JsonProperty("DESCUENTO")
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ApiModelProperty(required = true, example = "1", value = "Descuento", dataType = "float")
	private float DESCUENTO; 
	
	@JsonProperty("IMPUESTO_VENTA")
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ApiModelProperty(required = true, example = "1", value = "Impuesto venta IVA", dataType = "float")
	private float IMPUESTO_VENTA; 
	
	@JsonProperty("IMPUESTO_ISC")
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ApiModelProperty(required = true, example = "1", value = "Impuesto venta ISC", dataType = "float")
	private float IMPUESTO_ISC;
	
	public int getSECUENCIA() {
		return SECUENCIA;
	}
	public void setSECUENCIA(int sECUENCIA) {
		SECUENCIA = sECUENCIA;
	}
	public String getCODIGO_MODENA() {
		return CODIGO_MODENA;
	}
	public void setCODIGO_MODENA(String cODIGO_MODENA) {
		CODIGO_MODENA = cODIGO_MODENA;
	}
	public float getPRECIOUSD() {
		return PRECIOUSD;
	}
	public void setPRECIOUSD(float pRECIOUSD) {
		PRECIOUSD = pRECIOUSD;
	}
	
	public String getCODIGO_ARTICULO() {
		return CODIGO_ARTICULO;
	}
	public String getCODIGO_CATEGORIA() {
		return CODIGO_CATEGORIA;
	}
	public String getCODIGO_BODEGA() {
		return CODIGO_BODEGA;
	}
	public float getCANTIDAD() {
		return CANTIDAD;
	}
	public float getPRECIO() {
		return PRECIO;
	}
	public float getDESCUENTO() {
		return DESCUENTO;
	}
	public float getIMPUESTO_VENTA() {
		return IMPUESTO_VENTA;
	}
	public float getIMPUESTO_ISC() {
		return IMPUESTO_ISC;
	}
	public void setCODIGO_ARTICULO(String cODIGO_ARTICULO) {
		CODIGO_ARTICULO = cODIGO_ARTICULO;
	}
	public void setCODIGO_CATEGORIA(String cODIGO_CATEGORIA) {
		CODIGO_CATEGORIA = cODIGO_CATEGORIA;
	}
	public void setCODIGO_BODEGA(String cODIGO_BODEGA) {
		CODIGO_BODEGA = cODIGO_BODEGA;
	}
	public void setCANTIDAD(float cANTIDAD) {
		CANTIDAD = cANTIDAD;
	}
	public void setPRECIO(float pRECIO) {
		PRECIO = pRECIO;
	}
	public void setDESCUENTO(float dESCUENTO) {
		DESCUENTO = dESCUENTO;
	}
	public void setIMPUESTO_VENTA(float iMPUESTO_VENTA) {
		IMPUESTO_VENTA = iMPUESTO_VENTA;
	}
	public void setIMPUESTO_ISC(float iMPUESTO_ISC) {
		IMPUESTO_ISC = iMPUESTO_ISC;
	} 
}
