package ni.com.casapellas.cxccobro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import ni.com.casapellas.util.CollectionScheme;

@XmlRootElement
@Entity
@Table(name = "GCP_CONF_ACTIVITY_RULE", catalog = "SISTEMIP", schema = CollectionScheme.Scheme)
public class GcpConfActivityRule {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "ID_ACTIVITY")
	private int idActivity;
	@Column(name = "PROCESS_TYPE")
	private int processType;
	
	@Column(name = "DAYS_BEFOREI")
	private int daysBeforeI;
	@Column(name = "DAYS_BEFOREF")
	private int daysBeforeF;	
	@Column(name = "DAYS_AFTERI")
	private int daysAfterI;
	@Column(name = "DAYS_AFTERF")
	private int daysAfterF;	
	@Column(name = "RANGE")
	private int range;
	
	@Column(name = "FRECUENCY")
	private int frecuency;
	@Column(name = "DAY_OF_MONTH")
	private int dayOfMonth;
	@Column(name = "COLLECTION_TYPE")
	private int collectionType;
	@Column(name = "ACTIVITY_TYPE")
	private int activityType;
	@Column(name = "ID_SCRIPT")
	private int idScript;
	@Column(name = "EXECUTION_TYPE")
	private int executionType;
	@Column(name = "STATUS")
	private int status;

	public GcpConfActivityRule() {
	}

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

	public int getProcessType() {
		return processType;
	}

	public void setProcessType(int processType) {
		this.processType = processType;
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

	public int getCollectionType() {
		return collectionType;
	}

	public void setCollectionType(int collectionType) {
		this.collectionType = collectionType;
	}

	public int getActivityType() {
		return activityType;
	}

	public void setActivityType(int activityType) {
		this.activityType = activityType;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public void setRange(int range) {
		this.range = range;
	}

	public int getExecutionType() {
		return executionType;
	}

	public void setExecutionType(int executionType) {
		this.executionType = executionType;
	}

}
