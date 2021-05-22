package ni.com.casapellas.gcpfmu.pojo;

import java.util.List;

public class CashBillPost {

	private CashReceipt cashReceipt;
	private List<CashReceiptPaymentItem> cashReceiptPaymentItems;
	private List<CashBillReceiptRelation> cashBillReceiptRelations;
	private List<CashChangeDetail> cashChangeDetails;

	private CashReceipt cashSheetReceipt;
	private CashReceiptPaymentItem cashSheetReceiptPaymentItem;
	
	//private List<SurplusExchange> surplusExchangeDiff;

	private SurplusExchange surplusExchange;

	public CashReceipt getCashReceipt() {
		return cashReceipt;
	}

	public void setCashReceipt(CashReceipt cashReceipt) {
		this.cashReceipt = cashReceipt;
	}

	public List<CashReceiptPaymentItem> getCashReceiptPaymentItems() {
		return cashReceiptPaymentItems;
	}

	public void setCashReceiptPaymentItems(List<CashReceiptPaymentItem> cashReceiptPaymentItems) {
		this.cashReceiptPaymentItems = cashReceiptPaymentItems;
	}

	public List<CashBillReceiptRelation> getCashBillReceiptRelations() {
		return cashBillReceiptRelations;
	}

	public void setCashBillReceiptRelations(List<CashBillReceiptRelation> cashBillReceiptRelations) {
		this.cashBillReceiptRelations = cashBillReceiptRelations;
	}

	public List<CashChangeDetail> getCashChangeDetails() {
		return cashChangeDetails;
	}

	public void setCashChangeDetails(List<CashChangeDetail> cashChangeDetails) {
		this.cashChangeDetails = cashChangeDetails;
	}

	public CashReceipt getCashSheetReceipt() {
		return cashSheetReceipt;
	}

	public void setCashSheetReceipt(CashReceipt cashSheetReceipt) {
		this.cashSheetReceipt = cashSheetReceipt;
	}

	public CashReceiptPaymentItem getCashSheetReceiptPaymentItem() {
		return cashSheetReceiptPaymentItem;
	}

	public void setCashSheetReceiptPaymentItem(CashReceiptPaymentItem cashSheetReceiptPaymentItem) {
		this.cashSheetReceiptPaymentItem = cashSheetReceiptPaymentItem;
	}

	/*public List<SurplusExchange> getSurplusExchangeDiff() {
		return surplusExchangeDiff;
	}

	public void setSurplusExchangeDiff(List<SurplusExchange> surplusExchangeDiff) {
		this.surplusExchangeDiff = surplusExchangeDiff;
	}*/

	public SurplusExchange getSurplusExchange() {
		return surplusExchange;
	}

	public void setSurplusExchange(SurplusExchange surplusExchange) {
		this.surplusExchange = surplusExchange;
	}

}
