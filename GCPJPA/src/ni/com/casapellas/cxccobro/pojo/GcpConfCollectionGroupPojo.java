package ni.com.casapellas.cxccobro.pojo;//ni.com.casapellas.cxccobro.entity.GcpConfCatalogo

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GcpConfCollectionGroupPojo {
	private int id;
	private String code;
	private String name;
	private String description;
	private int processType;
	private int from;
	private int to;
	private int status;
	private String range;
	
	public GcpConfCollectionGroupPojo() {
	}
	
	public int getStatus() {  
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProcessType() {
		return processType;
	}

	public void setProcessType(int processType) {
		this.processType = processType;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

}
