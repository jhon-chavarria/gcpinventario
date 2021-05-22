package ni.com.casapellas.cxccobro.report.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import ni.com.casapellas.util.CollectionScheme;

import java.math.BigDecimal;


/**
 * The persistent class for the GCP_CONF_COLLECTION_RANGE_DETAIL database table.
 * 
 */
@Entity
@Table(name="GCP_CONF_COLLECTION_RANGE_DETAIL", catalog = "SISTEMIP", schema = CollectionScheme.Scheme)
public class GcpConfCollectionRangeDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="\"FROM\"")
	private BigDecimal from;

	@Column(name="ID_CONF_COLLECTION_RANGE")
	private int idConfCollectionRange;

	private int sumarize;

	@Column(name="\"TO\"")
	private BigDecimal to;

	public GcpConfCollectionRangeDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getFrom() {
		return this.from;
	}

	public void setFrom(BigDecimal from) {
		this.from = from;
	}

	public int getIdConfCollectionRange() {
		return this.idConfCollectionRange;
	}

	public void setIdConfCollectionRange(int idConfCollectionRange) {
		this.idConfCollectionRange = idConfCollectionRange;
	}

	public int getSumarize() {
		return this.sumarize;
	}

	public void setSumarize(int sumarize) {
		this.sumarize = sumarize;
	}

	public BigDecimal getTo() {
		return this.to;
	}

	public void setTo(BigDecimal to) {
		this.to = to;
	}

}