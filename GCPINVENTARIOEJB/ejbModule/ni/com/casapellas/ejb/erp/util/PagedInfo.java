package ni.com.casapellas.ejb.erp.util;

public class PagedInfo {
	private int pageSize;
	private int pageNumber;
	private String orderBy;
	private String orderDirection;
	private String filterBy;
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
	 * @return the orderBy
	 */
	public String getOrderBy() {
		return orderBy;
	}
	/**
	 * @param orderBy the orderBy to set
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	/**
	 * @return the orderDirection
	 */
	public String getOrderDirection() {
		return orderDirection;
	}
	/**
	 * @param orderDirection the orderDirection to set
	 */
	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}
	/**
	 * @return the filterBy
	 */
	public String getFilterBy() {
		return filterBy;
	}
	/**
	 * @param filterBy the filterBy to set
	 */
	public void setFilterBy(String filterBy) {
		this.filterBy = filterBy;
	}
}
