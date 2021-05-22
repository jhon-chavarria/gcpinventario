package ni.com.casapellas.ejb.erp.util;

import java.util.List;

public class PagedResult<T> {
	private int totalRows;
	private int pageNumber;
	private int pageSize;
	private List<T> entity;
	/**
	 * @return the totalRows
	 */
	public int getTotalRows() {
		return totalRows;
	}
	/**
	 * @param totalRows the totalRows to set
	 */
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	/**
	 * @return the pageNumber
	 */
	public int getPageNumber() {
		return pageNumber;
	}
	/**
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @return the entity
	 */
	public List<T> getEntity() {
		return entity;
	}
	/**
	 * @param entity the entity to set
	 */
	public void setEntity(List<T> entity) {
		this.entity = entity;
	}
	/**
	 * @param totalRows
	 * @param pageNumber
	 * @param pageSize
	 * @param entity
	 */
	public PagedResult(int totalRows, int pageNumber, int pageSize, List<T> entity) {
		super();
		this.totalRows = totalRows;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.entity = entity;
	}
}
