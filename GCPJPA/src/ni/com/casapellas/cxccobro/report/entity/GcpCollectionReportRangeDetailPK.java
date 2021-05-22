package ni.com.casapellas.cxccobro.report.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the GCP_COLLECTION_REPORT_RANGE_DETAIL database table.
 * 
 */
@Embeddable
public class GcpCollectionReportRangeDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_ROW")
	private int idRow;

	@Column(name="ID_RANGE")
	private int idRange;

	@Column(name="ID_REPORT_MASTER")
	private int idReportMaster;

	public GcpCollectionReportRangeDetailPK() {
	}
	 
	public int getIdRange() {
		return this.idRange;
	}
	public void setIdRange(int idRange) {
		this.idRange = idRange;
	}
	public int getIdReportMaster() {
		return this.idReportMaster;
	}
	public void setIdReportMaster(int idReportMaster) {
		this.idReportMaster = idReportMaster;
	}

	public int getIdRow() {
		return idRow;
	}

	public void setIdRow(int idRow) {
		this.idRow = idRow;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRange;
		result = prime * result + idReportMaster;
		result = prime * result + idRow;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GcpCollectionReportRangeDetailPK other = (GcpCollectionReportRangeDetailPK) obj;
		if (idRange != other.idRange)
			return false;
		if (idReportMaster != other.idReportMaster)
			return false;
		if (idRow != other.idRow)
			return false;
		return true;
	}
	
	

	 
}