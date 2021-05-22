package ni.com.casapellas.gcpcxccobro.pojos;

import java.util.List;

public class ActivityManagenment {
	private int recordsTotal;
	private int recordsFiltered;
	private List<ActivityManagementData> data;

	public ActivityManagenment() {
	}


	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<ActivityManagementData> getData() {
		return data;
	}

	public void setData(List<ActivityManagementData> data) {
		this.data = data;
	}

}
