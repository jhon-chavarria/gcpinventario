package ni.com.casapellas.cxccobro.pojo;

import java.io.Serializable;

public class GcpCollectionListPojo implements Serializable {

    private static final long serialVersionUID = 1L;

    private int activityId;
    private String activityTitle;
    private int customerCode;
    private String customerName;
    private String customerType;
    private int collectionCodeId;
    private String collectionTitle;
    private double amountCor;
    private double amountUsd;
    private int collectionStatus;
    private int recipeId;
    private int status;
	private int idActivity;
	private String nameActivity;
	private String companyCode;
	private String branchCode;
	private String businessLine;
	private int empCode;
	private int activityIdBasic;
	private String activityNameBasic;
	private String dateKey;
	private int sequenceKey;
	private int display;
	
	private int genAct;
	
	private String activityCode;
	private String activityBasicCode;
	private int collectionType;
	private int customersegment7;
	private int customersegment8;
	
	private String requestnumber;
	private int interaction;
	private int employeeCode;
	private String employeeName;
	
	private int rowId;
	private int requestedOrder;
	
	private int range;
	private int reallocate;
	
	private int criticality;

    public GcpCollectionListPojo() {
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCollectionCodeId() {
        return collectionCodeId;
    }

    public void setCollectionCodeId(int collectionCodeId) {
        this.collectionCodeId = collectionCodeId;
    }

    public String getCollectionTitle() {
        return collectionTitle;
    }

    public void setCollectionTitle(String collectionTitle) {
        this.collectionTitle = collectionTitle;
    }

    public double getAmountCor() {
        return amountCor;
    }

    public void setAmountCor(double amountCor) {
        this.amountCor = amountCor;
    }

    public double getAmountUsd() {
        return amountUsd;
    }

    public void setAmountUsd(double amountUsd) {
        this.amountUsd = amountUsd;
    }

    public int getCollectionStatus() {
        return collectionStatus;
    }

    public void setCollectionStatus(int collectionStatus) {
        this.collectionStatus = collectionStatus;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

	public int getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(int idActivity) {
		this.idActivity = idActivity;
	}

	public String getNameActivity() {
		return nameActivity;
	}

	public void setNameActivity(String nameActivity) {
		this.nameActivity = nameActivity;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public int getEmpCode() {
		return empCode;
	}

	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}

	public String getBusinessLine() {
		return businessLine;
	}

	public void setBusinessLine(String businessLine) {
		this.businessLine = businessLine;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public int getActivityIdBasic() {
		return activityIdBasic;
	}

	public void setActivityIdBasic(int activityIdBasic) {
		this.activityIdBasic = activityIdBasic;
	}

	public String getActivityNameBasic() {
		return activityNameBasic;
	}

	public void setActivityNameBasic(String activityNameBasic) {
		this.activityNameBasic = activityNameBasic;
	}

	public String getDateKey() {
		return dateKey;
	}

	public void setDateKey(String dateKey) {
		this.dateKey = dateKey;
	}

	public int getSequenceKey() {
		return sequenceKey;
	}

	public void setSequenceKey(int sequenceKey) {
		this.sequenceKey = sequenceKey;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getActivityBasicCode() {
		return activityBasicCode;
	}

	public void setActivityBasicCode(String activityBasicCode) {
		this.activityBasicCode = activityBasicCode;
	}

	public int getCollectionType() {
		return collectionType;
	}

	public void setCollectionType(int collectionType) {
		this.collectionType = collectionType;
	}

	public int getDisplay() {
		return display;
	}

	public void setDisplay(int display) {
		this.display = display;
	}

	public int getCustomersegment7() {
		return customersegment7;
	}

	public void setCustomersegment7(int customersegment7) {
		this.customersegment7 = customersegment7;
	}

	public int getCustomersegment8() {
		return customersegment8;
	}

	public void setCustomersegment8(int customersegment8) {
		this.customersegment8 = customersegment8;
	}

	public String getRequestnumber() {
		return requestnumber;
	}

	public void setRequestnumber(String requestnumber) {
		this.requestnumber = requestnumber;
	}

	public int getInteraction() {
		return interaction;
	}

	public void setInteraction(int interaction) {
		this.interaction = interaction;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(int employeeCode) {
		this.employeeCode = employeeCode;
	}

	public int getRowId() {
		return rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	public int getRequestedOrder() {
		return requestedOrder;
	}

	public void setRequestedOrder(int requestedOrder) {
		this.requestedOrder = requestedOrder;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getGenAct() {
		return genAct;
	}

	public void setGenAct(int genAct) {
		this.genAct = genAct;
	}

	public int getReallocate() {
		return reallocate;
	}

	public void setReallocate(int reallocate) {
		this.reallocate = reallocate;
	}

	public int getCriticality() {
		return criticality;
	}

	public void setCriticality(int criticality) {
		this.criticality = criticality;
	}


}
