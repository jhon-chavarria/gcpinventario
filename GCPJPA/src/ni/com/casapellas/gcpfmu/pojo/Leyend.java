package ni.com.casapellas.gcpfmu.pojo;

public class Leyend implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String leyend;
	
	public Leyend() {}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLeyend() {
		return leyend;
	}

	public void setLeyend(String leyend) {
		this.leyend = leyend;
	}	
	
}
