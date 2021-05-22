package ni.com.casapellas.gcpinventario;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import ni.com.casapellas.util.CustomValidationMessage;
import ni.com.casapellas.util.ValidDate;

public class FacturaBatch {
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, max = 2, message = CustomValidationMessage.COMPANIA_REQUERIDA)
	@ApiModelProperty(name = "codigoCompania", value = "Codigo de la Compania", dataType = "String")
	private String codigoCompania;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, max = 2, message = CustomValidationMessage.SUCURSAL_REQUERIDA)
	@ApiModelProperty(name = "codigoSucursal", value = "Codigo de Sucusal", dataType = "String")
	private String codigoSucursal;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 1, max = 2, message = CustomValidationMessage.DEPARTAMENTO_REQUERIDO)
	@ApiModelProperty(name = "codigoDepartamento", value = "Codigo de departamento", dataType = "String")
	private String codigoDepartamento;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ApiModelProperty(name = "tipoDocumento", value = "Tipo Documento", dataType = "String")
	private String tipoDocumento;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Min(value = 1, message = CustomValidationMessage.CAMPO_POSITIVO)
	@ApiModelProperty(name = "numeroBatch", value = "numeroBatch", dataType = "Number")
	private BigDecimal numeroBatch;

	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Min(value = 1, message = CustomValidationMessage.CAMPO_POSITIVO)
	@ApiModelProperty(name = "numeroDocumento", value = "Numero de Factura", dataType = "Number")
	private BigDecimal numeroDocumento;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)	
	@ValidDate(message = "La fecha tiene un formato invalido.")
	@ApiModelProperty(name = "fechaDocumento", required = true, value = "Fecha de ingreso de factura", example = "2020-01-01 08:10:10", dataType = "String", notes = "La fecha  tiene que ser en el formato yyyy-MM-dd hh:mm:ss")
	private String fechaDocumento;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@ValidDate(message = "La fecha tiene un formato invalido.")
	@ApiModelProperty(name = "fechaMovimiento", required = true, value = "Fecha de cambio de estado batch", example = "2020-01-01 08:10:10", dataType = "String", notes = "La fecha  tiene que ser en el formato yyyy-MM-dd hh:mm:ss")
	private String fechaMovimiento;
	
	@NotNull(message = CustomValidationMessage.CAMPO_NONULO)
	@Size(min = 5, max = 10, message = CustomValidationMessage.CODIGO_USUARIO_REQUERIDO)
	@ApiModelProperty(name = "usuario", value = "Codigo de usuario", dataType = "String")
	private String usuario;
	
	public String getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(String fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCodigoCompania() {
		return codigoCompania;
	}

	public String getCodigoSucursal() {
		return codigoSucursal;
	}

	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}

	public BigDecimal getNumeroBatch() {
		return numeroBatch;
	}

	public BigDecimal getNumeroDocumento() {
		return numeroDocumento;
	}

	public String getFechaDocumento() {
		return fechaDocumento;
	}

	public void setCodigoCompania(String codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public void setCodigoSucursal(String codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
	}

	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	public void setNumeroBatch(BigDecimal numeroBatch) {
		this.numeroBatch = numeroBatch;
	}

	public void setNumeroDocumento(BigDecimal numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public void setFechaDocumento(String fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}
}
