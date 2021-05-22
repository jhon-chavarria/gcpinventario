package ni.com.casapellas.cxccobro.report.entity;

import java.io.Serializable;
import javax.persistence.*;

import ni.com.casapellas.util.CollectionScheme;

import java.math.BigDecimal;


/**
 * The persistent class for the GCP_COLLECTION_REPORT_RANGE_DETAIL database table.
 * 
 */
@Entity
@Table(name="GCP_COLLECTION_REPORT_RANGE_DETAIL", catalog = "SISTEMIP", schema = CollectionScheme.Scheme)
public class GcpCollectionReportRangeDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GcpCollectionReportRangeDetailPK id;

	@Column(name="TOTAL_AMOUNT")
	private BigDecimal totalAmount;

	public GcpCollectionReportRangeDetail() {
	}

	public GcpCollectionReportRangeDetailPK getId() {
		return this.id;
	}

	public void setId(GcpCollectionReportRangeDetailPK id) {
		this.id = id;
	}

	public BigDecimal getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

}