package ni.com.casapellas.cxccobro.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GcpConfActivityRulePojo {
	
	private int id;
	private int idActivity;
	private String idActivityName;
	private int collectionType;
	private String collectionName;
	private int activityType;
	private String activityName;
	private int processType;
	private int frecuency;
	private String frecuencyName;
	private int dayOfMonth;
	private String script;  
	private int idScript;
	private int status;
	
	private int daysBeforeI;
	private int daysBeforeF;
	private int daysAfterI;
	private int daysAfterF;	
	private int executionType;
	private int range;
	
	public GcpConfActivityRulePojo(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdActivity() {
		return idActivity;
	}
	public void setIdActivity(int idActivity) {
		this.idActivity = idActivity;
	}
	public String getIdActivityName() {
		return idActivityName;
	}
	public void setIdActivityName(String idActivityName) {
		this.idActivityName = idActivityName;
	}
	public int getCollectionType() {
		return collectionType;
	}
	public void setCollectionType(int collectionType) {
		this.collectionType = collectionType;
	}
	public String getCollectionName() {
		return collectionName;
	}
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public int getFrecuency() {
		return frecuency;
	}
	public void setFrecuency(int frecuency) {
		this.frecuency = frecuency;
	}
	public int getDayOfMonth() {
		return dayOfMonth;
	}
	public void setDayOfMonth(int dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public int getActivityType() {
		return activityType;
	}

	public void setActivityType(int activityType) {
		this.activityType = activityType;
	}

	public String getFrecuencyName() {
		return frecuencyName;
	}

	public void setFrecuencyName(String frecuencyName) {
		this.frecuencyName = frecuencyName;
	}

	public int getProcessType() {
		return processType;
	}

	public void setProcessType(int processType) {
		this.processType = processType;
	}
	
	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}


	public int getIdScript() {
		return idScript;
	}

	public void setIdScript(int idScript) {
		this.idScript = idScript;
	}


	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getDaysBeforeI() {
		return daysBeforeI;
	}

	public void setDaysBeforeI(int daysBeforeI) {
		this.daysBeforeI = daysBeforeI;
	}

	public int getDaysBeforeF() {
		return daysBeforeF;
	}

	public void setDaysBeforeF(int daysBeforeF) {
		this.daysBeforeF = daysBeforeF;
	}

	public int getDaysAfterI() {
		return daysAfterI;
	}

	public void setDaysAfterI(int daysAfterI) {
		this.daysAfterI = daysAfterI;
	}

	public int getDaysAfterF() {
		return daysAfterF;
	}

	public void setDaysAfterF(int daysAfterF) {
		this.daysAfterF = daysAfterF;
	}

	public int getExecutionType() {
		return executionType;
	}

	public void setExecutionType(int executionType) {
		this.executionType = executionType;
	}
	
	
}
