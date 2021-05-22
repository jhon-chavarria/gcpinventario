package ni.com.casapellas.gcpfmu.pojo;

import java.util.Set;

public class CashBillReceiptRelation {
	private int receiptNumber;
    private int billId;
    private String jdCompanyId;
    private float amount;
    private float crBalance;

    private String billType;
    private String jdBranchId;
    private int cajaId;
    private String jdLineId;
    private String coin;
    private float crAmount;
    private int codCli;
    private String fee;
    

    // Account
    private String accountPart1;
    private String accountPart2;
    private String accountPart3;
    private String account;
    
    private String companyId2;
    private String account2;
    
    private float cancelAmount;
    private float cancelCrAmount;
    
    
    private float billExchange;
    
    private float calculatedExchange;

    
    // for credit bills
    private boolean cancelCompleteBill;
    private String clientType;

    private int sequenceNumber;
    private float billExchangeAmountGainLoss;

    private float newCorAmount;


    public CashBillReceiptRelation() {
    }

    public int getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(int receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }


    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getJdBranchId() {
        return jdBranchId;
    }

    public void setJdBranchId(String jdBranchId) {
        this.jdBranchId = jdBranchId;
    }

    public int getCajaId() {
        return cajaId;
    }

    public void setCajaId(int cajaId) {
        this.cajaId = cajaId;
    }

    public String getJdLineId() {
        return jdLineId;
    }

    public void setJdLineId(String jdLineId) {
        this.jdLineId = jdLineId;
    }

 

    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

  
	public String getJdCompanyId() {
		return jdCompanyId;
	}

	public void setJdCompanyId(String jdCompanyId) {
		this.jdCompanyId = jdCompanyId;
	}

	public float getCrAmount() {
		return crAmount;
	}

	public void setCrAmount(float crAmount) {
		this.crAmount = crAmount;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getAccountPart1() {
		return accountPart1;
	}

	public void setAccountPart1(String accountPart1) {
		this.accountPart1 = accountPart1;
	}

	public String getAccountPart2() {
		return accountPart2;
	}

	public void setAccountPart2(String accountPart2) {
		this.accountPart2 = accountPart2;
	}

	public String getAccountPart3() {
		return accountPart3;
	}

	public void setAccountPart3(String accountPart3) {
		this.accountPart3 = accountPart3;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}


	public String getAccount2() {
		return account2;
	}

	public void setAccount2(String account2) {
		this.account2 = account2;
	}

	public String getCompanyId2() {
		return companyId2;
	}

	public void setCompanyId2(String companyId2) {
		this.companyId2 = companyId2;
	}

	public boolean isCancelCompleteBill() {
		return cancelCompleteBill;
	}

	public void setCancelCompleteBill(boolean cancelCompleteBill) {
		this.cancelCompleteBill = cancelCompleteBill;
	}

	public float getCancelAmount() {
		return cancelAmount;
	}

	public void setCancelAmount(float cancelAmount) {
		this.cancelAmount = cancelAmount;
	}

	public float getCancelCrAmount() {
		return cancelCrAmount;
	}

	public void setCancelCrAmount(float cancelCrAmount) {
		this.cancelCrAmount = cancelCrAmount;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public float getCalculatedExchange() {
		return calculatedExchange;
	}

	public void setCalculatedExchange(float calculatedExchange) {
		this.calculatedExchange = calculatedExchange;
	}

	public float getBillExchange() {
		return billExchange;
	}

	public void setBillExchange(float billExchange) {
		this.billExchange = billExchange;
	}

	public float getCrBalance() {
		return crBalance;
	}

	public void setCrBalance(float crBalance) {
		this.crBalance = crBalance;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public float getBillExchangeAmountGainLoss() {
		return billExchangeAmountGainLoss;
	}

	public void setBillExchangeAmountGainLoss(float billExchangeAmountGainLoss) {
		this.billExchangeAmountGainLoss = billExchangeAmountGainLoss;
	}

	public float getNewCorAmount() {
		return newCorAmount;
	}

	public void setNewCorAmount(float newCorAmount) {
		this.newCorAmount = newCorAmount;
	}
}
