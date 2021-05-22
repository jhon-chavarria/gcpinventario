package ni.com.casapellas.gcptaller.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Modelo Taller")
public class Taller {
	
	@ApiModelProperty(name = "codigoCompania", value = "Codigo de la compania", dataType = "String")
	private String codigoCompania;
	
	@ApiModelProperty(name = "codigoTaller", value = "Codigo del taller", dataType = "String")
	private String codigoTaller;
	
	@ApiModelProperty(name = "descripcion", value = "Descripcion del taller", dataType = "String")
	private String descripcion;
	
	@ApiModelProperty(name = "codigoClasificacion", value = "Codigo de clasificacion del taller", dataType = "String")
	private String codigoClasificacion;
	
	@ApiModelProperty(name = "clasificacion", value = "Clasificacion", dataType = "String")
	private String clasificacion;
	
	@ApiModelProperty(name = "controlNivelUno", value = "Tipo de Control Nivel Uno", dataType = "String")
	private String controlNivelUno;
	
	@ApiModelProperty(name = "controlNivelDos", value = "Tipo de Control Nivel Dos", dataType = "String")
	private String controlNivelDos;
	
	@ApiModelProperty(name = "controlNivelTres", value = "Tipo de Control Nivel Tres", dataType = "String")
	private String controlNivelTres;
	
	@ApiModelProperty(name = "controlNivelCuatro", value = "Tipo de Control Nivel Cuatro", dataType = "String")
	private String controlNivelCuatro;
	/**
	 * @return the codigoCompania
	 */
	public String getCodigoCompania() {
		return codigoCompania;
	}
	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(String codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	/**
	 * @return the codigoTaller
	 */
	public String getCodigoTaller() {
		return codigoTaller;
	}
	/**
	 * @param codigoTaller the codigoTaller to set
	 */
	public void setCodigoTaller(String codigoTaller) {
		this.codigoTaller = codigoTaller;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the codigoClasificacion
	 */
	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}
	/**
	 * @param codigoClasificacion the codigoClasificacion to set
	 */
	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}
	/**
	 * @return the clasificacion
	 */
	public String getClasificacion() {
		return clasificacion;
	}
	/**
	 * @param clasificacion the clasificacion to set
	 */
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	/**
	 * @return the controlNivelUno
	 */
	public String getControlNivelUno() {
		return controlNivelUno;
	}
	/**
	 * @param controlNivelUno the controlNivelUno to set
	 */
	public void setControlNivelUno(String controlNivelUno) {
		this.controlNivelUno = controlNivelUno;
	}
	/**
	 * @return the controlNivelDos
	 */
	public String getControlNivelDos() {
		return controlNivelDos;
	}
	/**
	 * @param controlNivelDos the controlNivelDos to set
	 */
	public void setControlNivelDos(String controlNivelDos) {
		this.controlNivelDos = controlNivelDos;
	}
	/**
	 * @return the controlNivelTres
	 */
	public String getControlNivelTres() {
		return controlNivelTres;
	}
	/**
	 * @param controlNivelTres the controlNivelTres to set
	 */
	public void setControlNivelTres(String controlNivelTres) {
		this.controlNivelTres = controlNivelTres;
	}
	/**
	 * @return the controlNivelCuatro
	 */
	public String getControlNivelCuatro() {
		return controlNivelCuatro;
	}
	/**
	 * @param controlNivelCuatro the controlNivelCuatro to set
	 */
	public void setControlNivelCuatro(String controlNivelCuatro) {
		this.controlNivelCuatro = controlNivelCuatro;
	}
	/**
	 * 
	 */
	public Taller() {
		// TODO Auto-generated constructor stub
	}
}
