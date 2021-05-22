package ni.com.casapellas.gcpmcaja.pojos;

public class BancosCaja {

	private int codigo;
	private String name;
	private int order;
	private String state;
	private int conciliar;
	private int leerecbanco;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public int getLeerecbanco() {
		return leerecbanco;
	}
	public void setLeerecbanco(int leerecbanco) {
		this.leerecbanco = leerecbanco;
	}
	public int getConciliar() {
		return conciliar;
	}
	public void setConciliar(int conciliar) {
		this.conciliar = conciliar;
	}
}
