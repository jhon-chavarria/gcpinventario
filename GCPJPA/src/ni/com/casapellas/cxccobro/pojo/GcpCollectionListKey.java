package ni.com.casapellas.cxccobro.pojo;

import java.util.Date;

public class GcpCollectionListKey {
	private Date processDate;
	private int sequence;
	private int tableKey;

	public GcpCollectionListKey() {
	}

	public Date getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public int getTableKey() {
		return tableKey;
	}

	public void setTableKey(int tableKey) {
		this.tableKey = tableKey;
	}

}
