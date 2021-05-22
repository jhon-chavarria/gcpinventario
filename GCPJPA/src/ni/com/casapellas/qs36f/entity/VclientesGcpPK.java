package ni.com.casapellas.qs36f.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VclientesGcpPK implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private String apellidos;

	@Column(name="CODIGO_IDENTIF_JURIDICO")
	private String codIdentifJuridico;

	@Column(name="CODIGO_IDENTIF_NATURAL")
	private String codIdentifNatural;

	private String codigo;

	@Column(name="CODIGO_PLAZO")
	private String codigoPlazo;

	private String compania;

	private String departamento;

	@Column(name="DESC_CODIGO_PLAZO")
	private String descCodigoPlazo;

	@Column(name="DESC_DIA_VISITA_R_P")
	private String descDiaVisitaRP;

	@Column(name="DESC_DIA_VISITA_R_S")
	private String descDiaVisitaRS;

	@Column(name="DESC_ESTADO_R_S")
	private String descEstadoRS;

	@Column(name="DESC_ESTADO_RUTA_P")
	private String descEstadoRutaP;

	@Column(name="DESC_SECUENCIA_VISITA_R_P")
	private String descSecuenciaVisitaRP;

	@Column(name="DESC_SECUENCIA_VISITA_R_S")
	private String descSecuenciaVisitaRS;

	@Column(name="DESC_TIPO_DIRECCION")
	private String descTipoDireccion;

	@Column(name="DIA_VISITA_RUTA_PRIM")
	private String diaVisitaRutaPrim;

	@Column(name="DIA_VISITA_RUTA_SECUNDARIA")
	private String diaVisitaRutaSecundaria;

	@Column(name="DIAS_PLAZO")
	private String diasPlazo;

	private String direccion;

	@Column(name="ESTADO_REGISTRO")
	private String estadoRegistro;

	@Column(name="ESTADO_RUTA_PRIMARIA")
	private String estadoRutaPrimaria;

	@Column(name="ESTADO_RUTA_S")
	private String estadoRutaS;

	@Column(name="GRUPO_PRECIO")
	private String grupoPrecio;

	@Column(name="LIMITE_CREDITO")
	private String limiteCredito;

	private String municipo;

	private String nombre;

	@Column(name="NOMBRE_EMAIL")
	private String nombreEmail;

	@Column(name="NOMBRE_PAIS")
	private String nombrePais;

	private String orden;

	private String pais;

	@Column(name="PRIMER_NOMBRE")
	private String primerNombre;

	private String prioridad;

	@Column(name="RAZON_SOCIAL")
	private String razonSocial;

	@Column(name="RUTA_PRIMARIA")
	private String rutaPrimaria;

	@Column(name="RUTA_SECUNDARIA")
	private String rutaSecundaria;

	@Column(name="SECUENCIA_VISITA_RUTA_P")
	private String secuenciaVisitaRutaP;

	@Column(name="SECUENCIA_VISITA_RUTA_S")
	private String secuenciaVisitaRutaS;

	@Column(name="SEGUNDO_NOMBRE")
	private String segundoNombre;

	private String sucursal;

	@Column(name="TIPO_DIRECCION")
	private String tipoDireccion;

	@Column(name="UNIDAD_MEDIDA_N")
	private String unidadMedidaN;

	@Column(name="UNIDAD_MEDIDA_N_DESC")
	private String unidadMedidaNDesc;

	@Column(name="UNIDAD_NEGOCIO")
	private String unidadNegocio;

    public VclientesGcpPK() {
    }

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCodIdentifJuridico() {
		return this.codIdentifJuridico;
	}

	public void setCodIdentifJuridico(String codIdentifJuridico) {
		this.codIdentifJuridico = codIdentifJuridico;
	}

	public String getCodIdentifNatural() {
		return this.codIdentifNatural;
	}

	public void setCodIdentifNatural(String codIdentifNatural) {
		this.codIdentifNatural = codIdentifNatural;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigoPlazo() {
		return this.codigoPlazo;
	}

	public void setCodigoPlazo(String codigoPlazo) {
		this.codigoPlazo = codigoPlazo;
	}

	public String getCompania() {
		return this.compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDescCodigoPlazo() {
		return this.descCodigoPlazo;
	}

	public void setDescCodigoPlazo(String descCodigoPlazo) {
		this.descCodigoPlazo = descCodigoPlazo;
	}

	public String getDescDiaVisitaRP() {
		return this.descDiaVisitaRP;
	}

	public void setDescDiaVisitaRP(String descDiaVisitaRP) {
		this.descDiaVisitaRP = descDiaVisitaRP;
	}

	public String getDescDiaVisitaRS() {
		return this.descDiaVisitaRS;
	}

	public void setDescDiaVisitaRS(String descDiaVisitaRS) {
		this.descDiaVisitaRS = descDiaVisitaRS;
	}

	public String getDescEstadoRS() {
		return this.descEstadoRS;
	}

	public void setDescEstadoRS(String descEstadoRS) {
		this.descEstadoRS = descEstadoRS;
	}

	public String getDescEstadoRutaP() {
		return this.descEstadoRutaP;
	}

	public void setDescEstadoRutaP(String descEstadoRutaP) {
		this.descEstadoRutaP = descEstadoRutaP;
	}

	public String getDescSecuenciaVisitaRP() {
		return this.descSecuenciaVisitaRP;
	}

	public void setDescSecuenciaVisitaRP(String descSecuenciaVisitaRP) {
		this.descSecuenciaVisitaRP = descSecuenciaVisitaRP;
	}

	public String getDescSecuenciaVisitaRS() {
		return this.descSecuenciaVisitaRS;
	}

	public void setDescSecuenciaVisitaRS(String descSecuenciaVisitaRS) {
		this.descSecuenciaVisitaRS = descSecuenciaVisitaRS;
	}

	public String getDescTipoDireccion() {
		return this.descTipoDireccion;
	}

	public void setDescTipoDireccion(String descTipoDireccion) {
		this.descTipoDireccion = descTipoDireccion;
	}

	public String getDiaVisitaRutaPrim() {
		return this.diaVisitaRutaPrim;
	}

	public void setDiaVisitaRutaPrim(String diaVisitaRutaPrim) {
		this.diaVisitaRutaPrim = diaVisitaRutaPrim;
	}

	public String getDiaVisitaRutaSecundaria() {
		return this.diaVisitaRutaSecundaria;
	}

	public void setDiaVisitaRutaSecundaria(String diaVisitaRutaSecundaria) {
		this.diaVisitaRutaSecundaria = diaVisitaRutaSecundaria;
	}

	public String getDiasPlazo() {
		return this.diasPlazo;
	}

	public void setDiasPlazo(String diasPlazo) {
		this.diasPlazo = diasPlazo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstadoRegistro() {
		return this.estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getEstadoRutaPrimaria() {
		return this.estadoRutaPrimaria;
	}

	public void setEstadoRutaPrimaria(String estadoRutaPrimaria) {
		this.estadoRutaPrimaria = estadoRutaPrimaria;
	}

	public String getEstadoRutaS() {
		return this.estadoRutaS;
	}

	public void setEstadoRutaS(String estadoRutaS) {
		this.estadoRutaS = estadoRutaS;
	}

	public String getGrupoPrecio() {
		return this.grupoPrecio;
	}

	public void setGrupoPrecio(String grupoPrecio) {
		this.grupoPrecio = grupoPrecio;
	}

	public String getLimiteCredito() {
		return this.limiteCredito;
	}

	public void setLimiteCredito(String limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public String getMunicipo() {
		return this.municipo;
	}

	public void setMunicipo(String municipo) {
		this.municipo = municipo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreEmail() {
		return this.nombreEmail;
	}

	public void setNombreEmail(String nombreEmail) {
		this.nombreEmail = nombreEmail;
	}

	public String getNombrePais() {
		return this.nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public String getOrden() {
		return this.orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getPrioridad() {
		return this.prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRutaPrimaria() {
		return this.rutaPrimaria;
	}

	public void setRutaPrimaria(String rutaPrimaria) {
		this.rutaPrimaria = rutaPrimaria;
	}

	public String getRutaSecundaria() {
		return this.rutaSecundaria;
	}

	public void setRutaSecundaria(String rutaSecundaria) {
		this.rutaSecundaria = rutaSecundaria;
	}

	public String getSecuenciaVisitaRutaP() {
		return this.secuenciaVisitaRutaP;
	}

	public void setSecuenciaVisitaRutaP(String secuenciaVisitaRutaP) {
		this.secuenciaVisitaRutaP = secuenciaVisitaRutaP;
	}

	public String getSecuenciaVisitaRutaS() {
		return this.secuenciaVisitaRutaS;
	}

	public void setSecuenciaVisitaRutaS(String secuenciaVisitaRutaS) {
		this.secuenciaVisitaRutaS = secuenciaVisitaRutaS;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getTipoDireccion() {
		return this.tipoDireccion;
	}

	public void setTipoDireccion(String tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	public String getUnidadMedidaN() {
		return this.unidadMedidaN;
	}

	public void setUnidadMedidaN(String unidadMedidaN) {
		this.unidadMedidaN = unidadMedidaN;
	}

	public String getUnidadMedidaNDesc() {
		return this.unidadMedidaNDesc;
	}

	public void setUnidadMedidaNDesc(String unidadMedidaNDesc) {
		this.unidadMedidaNDesc = unidadMedidaNDesc;
	}

	public String getUnidadNegocio() {
		return this.unidadNegocio;
	}

	public void setUnidadNegocio(String unidadNegocio) {
		this.unidadNegocio = unidadNegocio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime
				* result
				+ ((codIdentifJuridico == null) ? 0 : codIdentifJuridico
						.hashCode());
		result = prime
				* result
				+ ((codIdentifNatural == null) ? 0 : codIdentifNatural
						.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((codigoPlazo == null) ? 0 : codigoPlazo.hashCode());
		result = prime * result
				+ ((compania == null) ? 0 : compania.hashCode());
		result = prime * result
				+ ((departamento == null) ? 0 : departamento.hashCode());
		result = prime * result
				+ ((descCodigoPlazo == null) ? 0 : descCodigoPlazo.hashCode());
		result = prime * result
				+ ((descDiaVisitaRP == null) ? 0 : descDiaVisitaRP.hashCode());
		result = prime * result
				+ ((descDiaVisitaRS == null) ? 0 : descDiaVisitaRS.hashCode());
		result = prime * result
				+ ((descEstadoRS == null) ? 0 : descEstadoRS.hashCode());
		result = prime * result
				+ ((descEstadoRutaP == null) ? 0 : descEstadoRutaP.hashCode());
		result = prime
				* result
				+ ((descSecuenciaVisitaRP == null) ? 0 : descSecuenciaVisitaRP
						.hashCode());
		result = prime
				* result
				+ ((descSecuenciaVisitaRS == null) ? 0 : descSecuenciaVisitaRS
						.hashCode());
		result = prime
				* result
				+ ((descTipoDireccion == null) ? 0 : descTipoDireccion
						.hashCode());
		result = prime
				* result
				+ ((diaVisitaRutaPrim == null) ? 0 : diaVisitaRutaPrim
						.hashCode());
		result = prime
				* result
				+ ((diaVisitaRutaSecundaria == null) ? 0
						: diaVisitaRutaSecundaria.hashCode());
		result = prime * result
				+ ((diasPlazo == null) ? 0 : diasPlazo.hashCode());
		result = prime * result
				+ ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result
				+ ((estadoRegistro == null) ? 0 : estadoRegistro.hashCode());
		result = prime
				* result
				+ ((estadoRutaPrimaria == null) ? 0 : estadoRutaPrimaria
						.hashCode());
		result = prime * result
				+ ((estadoRutaS == null) ? 0 : estadoRutaS.hashCode());
		result = prime * result
				+ ((grupoPrecio == null) ? 0 : grupoPrecio.hashCode());
		result = prime * result
				+ ((limiteCredito == null) ? 0 : limiteCredito.hashCode());
		result = prime * result
				+ ((municipo == null) ? 0 : municipo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result
				+ ((nombreEmail == null) ? 0 : nombreEmail.hashCode());
		result = prime * result
				+ ((nombrePais == null) ? 0 : nombrePais.hashCode());
		result = prime * result + ((orden == null) ? 0 : orden.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result
				+ ((primerNombre == null) ? 0 : primerNombre.hashCode());
		result = prime * result
				+ ((prioridad == null) ? 0 : prioridad.hashCode());
		result = prime * result
				+ ((razonSocial == null) ? 0 : razonSocial.hashCode());
		result = prime * result
				+ ((rutaPrimaria == null) ? 0 : rutaPrimaria.hashCode());
		result = prime * result
				+ ((rutaSecundaria == null) ? 0 : rutaSecundaria.hashCode());
		result = prime
				* result
				+ ((secuenciaVisitaRutaP == null) ? 0 : secuenciaVisitaRutaP
						.hashCode());
		result = prime
				* result
				+ ((secuenciaVisitaRutaS == null) ? 0 : secuenciaVisitaRutaS
						.hashCode());
		result = prime * result
				+ ((segundoNombre == null) ? 0 : segundoNombre.hashCode());
		result = prime * result
				+ ((sucursal == null) ? 0 : sucursal.hashCode());
		result = prime * result
				+ ((tipoDireccion == null) ? 0 : tipoDireccion.hashCode());
		result = prime * result
				+ ((unidadMedidaN == null) ? 0 : unidadMedidaN.hashCode());
		result = prime
				* result
				+ ((unidadMedidaNDesc == null) ? 0 : unidadMedidaNDesc
						.hashCode());
		result = prime * result
				+ ((unidadNegocio == null) ? 0 : unidadNegocio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VclientesGcpPK other = (VclientesGcpPK) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (codIdentifJuridico == null) {
			if (other.codIdentifJuridico != null)
				return false;
		} else if (!codIdentifJuridico.equals(other.codIdentifJuridico))
			return false;
		if (codIdentifNatural == null) {
			if (other.codIdentifNatural != null)
				return false;
		} else if (!codIdentifNatural.equals(other.codIdentifNatural))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (codigoPlazo == null) {
			if (other.codigoPlazo != null)
				return false;
		} else if (!codigoPlazo.equals(other.codigoPlazo))
			return false;
		if (compania == null) {
			if (other.compania != null)
				return false;
		} else if (!compania.equals(other.compania))
			return false;
		if (departamento == null) {
			if (other.departamento != null)
				return false;
		} else if (!departamento.equals(other.departamento))
			return false;
		if (descCodigoPlazo == null) {
			if (other.descCodigoPlazo != null)
				return false;
		} else if (!descCodigoPlazo.equals(other.descCodigoPlazo))
			return false;
		if (descDiaVisitaRP == null) {
			if (other.descDiaVisitaRP != null)
				return false;
		} else if (!descDiaVisitaRP.equals(other.descDiaVisitaRP))
			return false;
		if (descDiaVisitaRS == null) {
			if (other.descDiaVisitaRS != null)
				return false;
		} else if (!descDiaVisitaRS.equals(other.descDiaVisitaRS))
			return false;
		if (descEstadoRS == null) {
			if (other.descEstadoRS != null)
				return false;
		} else if (!descEstadoRS.equals(other.descEstadoRS))
			return false;
		if (descEstadoRutaP == null) {
			if (other.descEstadoRutaP != null)
				return false;
		} else if (!descEstadoRutaP.equals(other.descEstadoRutaP))
			return false;
		if (descSecuenciaVisitaRP == null) {
			if (other.descSecuenciaVisitaRP != null)
				return false;
		} else if (!descSecuenciaVisitaRP.equals(other.descSecuenciaVisitaRP))
			return false;
		if (descSecuenciaVisitaRS == null) {
			if (other.descSecuenciaVisitaRS != null)
				return false;
		} else if (!descSecuenciaVisitaRS.equals(other.descSecuenciaVisitaRS))
			return false;
		if (descTipoDireccion == null) {
			if (other.descTipoDireccion != null)
				return false;
		} else if (!descTipoDireccion.equals(other.descTipoDireccion))
			return false;
		if (diaVisitaRutaPrim == null) {
			if (other.diaVisitaRutaPrim != null)
				return false;
		} else if (!diaVisitaRutaPrim.equals(other.diaVisitaRutaPrim))
			return false;
		if (diaVisitaRutaSecundaria == null) {
			if (other.diaVisitaRutaSecundaria != null)
				return false;
		} else if (!diaVisitaRutaSecundaria
				.equals(other.diaVisitaRutaSecundaria))
			return false;
		if (diasPlazo == null) {
			if (other.diasPlazo != null)
				return false;
		} else if (!diasPlazo.equals(other.diasPlazo))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (estadoRegistro == null) {
			if (other.estadoRegistro != null)
				return false;
		} else if (!estadoRegistro.equals(other.estadoRegistro))
			return false;
		if (estadoRutaPrimaria == null) {
			if (other.estadoRutaPrimaria != null)
				return false;
		} else if (!estadoRutaPrimaria.equals(other.estadoRutaPrimaria))
			return false;
		if (estadoRutaS == null) {
			if (other.estadoRutaS != null)
				return false;
		} else if (!estadoRutaS.equals(other.estadoRutaS))
			return false;
		if (grupoPrecio == null) {
			if (other.grupoPrecio != null)
				return false;
		} else if (!grupoPrecio.equals(other.grupoPrecio))
			return false;
		if (limiteCredito == null) {
			if (other.limiteCredito != null)
				return false;
		} else if (!limiteCredito.equals(other.limiteCredito))
			return false;
		if (municipo == null) {
			if (other.municipo != null)
				return false;
		} else if (!municipo.equals(other.municipo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (nombreEmail == null) {
			if (other.nombreEmail != null)
				return false;
		} else if (!nombreEmail.equals(other.nombreEmail))
			return false;
		if (nombrePais == null) {
			if (other.nombrePais != null)
				return false;
		} else if (!nombrePais.equals(other.nombrePais))
			return false;
		if (orden == null) {
			if (other.orden != null)
				return false;
		} else if (!orden.equals(other.orden))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (primerNombre == null) {
			if (other.primerNombre != null)
				return false;
		} else if (!primerNombre.equals(other.primerNombre))
			return false;
		if (prioridad == null) {
			if (other.prioridad != null)
				return false;
		} else if (!prioridad.equals(other.prioridad))
			return false;
		if (razonSocial == null) {
			if (other.razonSocial != null)
				return false;
		} else if (!razonSocial.equals(other.razonSocial))
			return false;
		if (rutaPrimaria == null) {
			if (other.rutaPrimaria != null)
				return false;
		} else if (!rutaPrimaria.equals(other.rutaPrimaria))
			return false;
		if (rutaSecundaria == null) {
			if (other.rutaSecundaria != null)
				return false;
		} else if (!rutaSecundaria.equals(other.rutaSecundaria))
			return false;
		if (secuenciaVisitaRutaP == null) {
			if (other.secuenciaVisitaRutaP != null)
				return false;
		} else if (!secuenciaVisitaRutaP.equals(other.secuenciaVisitaRutaP))
			return false;
		if (secuenciaVisitaRutaS == null) {
			if (other.secuenciaVisitaRutaS != null)
				return false;
		} else if (!secuenciaVisitaRutaS.equals(other.secuenciaVisitaRutaS))
			return false;
		if (segundoNombre == null) {
			if (other.segundoNombre != null)
				return false;
		} else if (!segundoNombre.equals(other.segundoNombre))
			return false;
		if (sucursal == null) {
			if (other.sucursal != null)
				return false;
		} else if (!sucursal.equals(other.sucursal))
			return false;
		if (tipoDireccion == null) {
			if (other.tipoDireccion != null)
				return false;
		} else if (!tipoDireccion.equals(other.tipoDireccion))
			return false;
		if (unidadMedidaN == null) {
			if (other.unidadMedidaN != null)
				return false;
		} else if (!unidadMedidaN.equals(other.unidadMedidaN))
			return false;
		if (unidadMedidaNDesc == null) {
			if (other.unidadMedidaNDesc != null)
				return false;
		} else if (!unidadMedidaNDesc.equals(other.unidadMedidaNDesc))
			return false;
		if (unidadNegocio == null) {
			if (other.unidadNegocio != null)
				return false;
		} else if (!unidadNegocio.equals(other.unidadNegocio))
			return false;
		return true;
	}
	
	
}
