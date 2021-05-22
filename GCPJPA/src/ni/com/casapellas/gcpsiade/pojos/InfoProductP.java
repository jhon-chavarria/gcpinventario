package ni.com.casapellas.gcpsiade.pojos;

public class InfoProductP {

	private String invitm;
	private String invbac_descri;
	private int existencia;
	private int reservados;
	private int existencia_disponible;
	private String invppk;
	private double precio_base_cor;
	private int unidades_x_cajas;
	private double precio_x_caja;
	private int ipedid;
	private int liq_pendientes;

	public String getInvitm() {
		return invitm;
	}

	public String getInvbac_descri() {
		return invbac_descri;
	}

	public String getInvppk() {
		return invppk;
	}

	public void setInvitm(String invitm) {
		this.invitm = invitm;
	}

	public void setInvbac_descri(String invbac_descri) {
		this.invbac_descri = invbac_descri;
	}

	public void setInvppk(String invppk) {
		this.invppk = invppk;
	}

	public double getPrecio_base_cor() {
		return precio_base_cor;
	}

	public void setPrecio_base_cor(double precio_base_cor) {
		this.precio_base_cor = precio_base_cor;
	}

	public int getExistencia() {
		return existencia;
	}

	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}

	public int getReservados() {
		return reservados;
	}

	public int getExistencia_disponible() {
		return existencia_disponible;
	}

	public int getUnidades_x_cajas() {
		return unidades_x_cajas;
	}

	public double getPrecio_x_caja() {
		return precio_x_caja;
	}

	public void setReservados(int reservados) {
		this.reservados = reservados;
	}

	public void setExistencia_disponible(int existencia_disponible) {
		this.existencia_disponible = existencia_disponible;
	}

	public void setUnidades_x_cajas(int unidades_x_cajas) {
		this.unidades_x_cajas = unidades_x_cajas;
	}

	public void setPrecio_x_caja(double precio_x_caja) {
		this.precio_x_caja = precio_x_caja;
	}

	public int getIpedid() {
		return ipedid;
	}

	public void setIpedid(int ipedid) {
		this.ipedid = ipedid;
	}

	public int getLiq_pendientes() {
		return liq_pendientes;
	}

	public void setLiq_pendientes(int liq_pendientes) {
		this.liq_pendientes = liq_pendientes;
	}

}
