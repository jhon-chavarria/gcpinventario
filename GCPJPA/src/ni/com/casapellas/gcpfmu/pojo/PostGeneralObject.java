package ni.com.casapellas.gcpfmu.pojo;

import java.util.List;

public class PostGeneralObject {
	
    private String parameter1;
    private String parameter2;
    private String parameter3;
    private String parameter4;
    private String parameter5;
    private String parameter6;
    private String parameter7;


    private List<BillHeader> billPostList;
    private List<CashBillPost> cashBillPosts;
    // Cancel receipt list
    private List<CashBillPost> cancelReceiptList;

    // Positions users / App
    private List<RoutePosition> routePositions;

    // Orders
    private List<Order> orderList;
    private List<Order> orderCancelList;

    public String getParameter1() {
        return parameter1;
    }

    public void setParameter1(String parameter1) {
        this.parameter1 = parameter1;
    }

    public String getParameter2() {
        return parameter2;
    }

    public void setParameter2(String parameter2) {
        this.parameter2 = parameter2;
    }

    public String getParameter3() {
        return parameter3;
    }

    public void setParameter3(String parameter3) {
        this.parameter3 = parameter3;
    }

    public String getParameter4() {
        return parameter4;
    }

    public void setParameter4(String parameter4) {
        this.parameter4 = parameter4;
    }


    public List<BillHeader> getBillPostList() {
        return billPostList;
    }

    public void setBillPostList(List<BillHeader> billPostList) {
        this.billPostList = billPostList;
    }

    public List<CashBillPost> getCashBillPosts() {
        return cashBillPosts;
    }

    public void setCashBillPosts(List<CashBillPost> cashBillPosts) {
        this.cashBillPosts = cashBillPosts;
    }

	public List<CashBillPost> getCancelReceiptList() {
		return cancelReceiptList;
	}

	public void setCancelReceiptList(List<CashBillPost> cancelReceiptList) {
		this.cancelReceiptList = cancelReceiptList;
	}

	public List<RoutePosition> getRoutePositions() {
		return routePositions;
	}

	public void setRoutePositions(List<RoutePosition> routePositions) {
		this.routePositions = routePositions;
	}

	public String getParameter5() {
		return parameter5;
	}

	public void setParameter5(String parameter5) {
		this.parameter5 = parameter5;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public List<Order> getOrderCancelList() {
		return orderCancelList;
	}

	public void setOrderCancelList(List<Order> orderCancelList) {
		this.orderCancelList = orderCancelList;
	}

	public String getParameter6() {
		return parameter6;
	}

	public void setParameter6(String parameter6) {
		this.parameter6 = parameter6;
	}

	public String getParameter7() {
		return parameter7;
	}

	public void setParameter7(String parameter7) {
		this.parameter7 = parameter7;
	}
	
    
}
