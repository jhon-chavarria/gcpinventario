package ni.com.casapellas.gcpsiade.pojos;

public class VExistenciasLotes {

	private String lote;
	private int existencia;
	private int reservados;
	private int existencia_disponible;
	private String fecha;

	public String getLote() {
		return lote;
	}

	public int getExistencia() {
		return existencia;
	}

	public int getReservados() {
		return reservados;
	}

	public int getExistencia_disponible() {
		return existencia_disponible;
	}

	public String getFecha() {
		return fecha;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}

	public void setReservados(int reservados) {
		this.reservados = reservados;
	}

	public void setExistencia_disponible(int existencia_disponible) {
		this.existencia_disponible = existencia_disponible;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
