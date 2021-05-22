package ni.com.casapellas.ens.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;

/**
 * The persistent class for the LOG database table.
 * 
 */
@Entity
@Table(name = "LOG", catalog = "SYSTEMIP", schema = "ENS")
public class Log implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LogPK id;

	private String accion;

	private String codapp;

	private String codsec;

	private String coduser;

	private short exito;

	private Timestamp fregistro;

	private String mensaje;

	public Log() {
	}

	public LogPK getId() {
		return this.id;
	}

	public void setId(LogPK id) {
		this.id = id;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getCodapp() {
		return this.codapp;
	}

	public void setCodapp(String codapp) {
		this.codapp = codapp;
	}

	public String getCodsec() {
		return this.codsec;
	}

	public void setCodsec(String codsec) {
		this.codsec = codsec;
	}

	public String getCoduser() {
		return this.coduser;
	}

	public void setCoduser(String coduser) {
		this.coduser = coduser;
	}

	public short getExito() {
		return this.exito;
	}

	public void setExito(short exito) {
		this.exito = exito;
	}

	public Timestamp getFregistro() {
		return this.fregistro;
	}

	public void setFregistro(Timestamp fregistro) {
		this.fregistro = fregistro;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}