package ni.com.casapellas.cxccobro.pojo;//ni.com.casapellas.cxccobro.entity.GcpConfCatalogo

import javax.persistence.Column;


public class GcpConfScriptPojo {
	private int id;
	private String name;
	private String title;
	private String subject;
	private String content;
	private int collectionTypeId;
	private String collectionType;  
	private int scriptTypeId;
	private String scriptType;
	private int status;
 


	public int getStatus() {  
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	private int visible;   

	public GcpConfScriptPojo() {  
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	  

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}  
   
	public String getCollectionType() {
		return collectionType;
	}
  
	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

	public int getVisible() {
		return visible;
	}  

	public void setVisible(int visible) {
		this.visible = visible;
	}

	public int getCollectionTypeId() {
		return collectionTypeId;
	}  
  
	public void setCollectionTypeId(int collectionTypeId) {
		this.collectionTypeId = collectionTypeId;
	}

	public int getScriptTypeId() {
		return scriptTypeId;
	}

	public void setScriptTypeId(int scriptTypeId) {
		this.scriptTypeId = scriptTypeId;
	}

	public String getScriptType() {
		return scriptType;
	}

	public void setScriptType(String scriptType) {
		this.scriptType = scriptType;
	}

	
	
}
