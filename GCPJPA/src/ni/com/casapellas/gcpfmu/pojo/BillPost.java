package ni.com.casapellas.gcpfmu.pojo;

import java.util.Date;

public class BillPost {
    /** For creating local */
    private int billItemId;
    private String companyId;
    private String branchId;
    private String lineId;
    private String cellarId;
    private String tipoMV;
    private String tipoMo;
    private int billId;
    private int date;
    private int sequenceId;
    private int returnSequenceId;
    private String productId;
    private float discountPercent;
    private float totalDiscount;
    private float totalDiscountCR;
    private String deviceId;
    private String userId;
    private String softwareId;
    private String sellerId;
    private int sellerNumber;
    private String creditPayCondition;
    private int nfactu;
    private float totalCR;
    private float total;
    private float totalIva;
    private float totalIvaCR;
    private int dateDev;
    private String indct;
    private float exchange;
    private String istat4;
    private int clientId;
    private String clientName;
    private int hora;
    private int returnQuantity;
    private String conditionType;
    private String istat1;
    private String coin;
    private float iva;
    private float priceCR;
    private float price;
    private int billQuantity;
    private String cancelState;
    private int discountCode;
    private String typeCode;
    private String comboId;


    /** For creating remote **/

    private float tCostoCR;
    private float tCosto;
    private float COSTGD;
    private float COSTUD;
    private int EXISTD;
    private String ISTAT2;
    private float COSTGA;
    private float COSTUA;
    private int EXISTA;
    private float VALORG;
    private float VALORU;
    private String statcv;

    private boolean excludeCost;

    // For select
    private String productName;
    private String productDescription;
    private String zoneId;
    private String measureType;
    private String brandId;
    private String receiptNumber;

    // JDE
    private String jdBranchName;
    private String jdCompanyName;
    private String jdLineName;

    private String jdLineId;
    private String jdBranchId;
    private String jdCompanyId;
    
    // Caja
    private float subtotal;
    private float subtotalCR;
    
    private float priceWithDiscount;
    private float discount;
    
    //private int billCreated;
   
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }


    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getCellarId() {
        return cellarId;
    }

    public void setCellarId(String cellarId) {
        this.cellarId = cellarId;
    }


    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }



    public float getExchange() {
        return exchange;
    }

    public void setExchange(float exchange) {
        this.exchange = exchange;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSoftwareId() {
        return softwareId;
    }

    public void setSoftwareId(String softwareId) {
        this.softwareId = softwareId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public int getSellerNumber() {
        return sellerNumber;
    }

    public void setSellerNumber(int sellerNumber) {
        this.sellerNumber = sellerNumber;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }


    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getPriceCR() {
        return priceCR;
    }

    public void setPriceCR(float priceCR) {
        this.priceCR = priceCR;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public float getTotalCR() {
        return totalCR;
    }

    public void setTotalCR(float totalCR) {
        this.totalCR = totalCR;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(float totalIva) {
        this.totalIva = totalIva;
    }

    public float getTotalIvaCR() {
        return totalIvaCR;
    }

    public void setTotalIvaCR(float totalIvaCR) {
        this.totalIvaCR = totalIvaCR;
    }


    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getISTAT2() {
        return ISTAT2;
    }

    public void setISTAT2(String iSTAT2) {
        ISTAT2 = iSTAT2;
    }

    public float getCOSTGA() {
        return COSTGA;
    }

    public void setCOSTGA(float cOSTGA) {
        COSTGA = cOSTGA;
    }

    public float getCOSTUA() {
        return COSTUA;
    }

    public void setCOSTUA(float cOSTUA) {
        COSTUA = cOSTUA;
    }

    public int getEXISTA() {
        return EXISTA;
    }

    public void setEXISTA(int eXISTA) {
        EXISTA = eXISTA;
    }

    public float getVALORG() {
        return VALORG;
    }

    public void setVALORG(float vALORG) {
        VALORG = vALORG;
    }

    public float getVALORU() {
        return VALORU;
    }

    public void setVALORU(float vALORU) {
        VALORU = vALORU;
    }


    public float getCOSTGD() {
        return COSTGD;
    }

    public void setCOSTGD(float cOSTGD) {
        COSTGD = cOSTGD;
    }

    public float getCOSTUD() {
        return COSTUD;
    }

    public void setCOSTUD(float cOSTUD) {
        COSTUD = cOSTUD;
    }

    public int getEXISTD() {
        return EXISTD;
    }

    public void setEXISTD(int eXISTD) {
        EXISTD = eXISTD;
    }


    public int getBillQuantity() {
        return billQuantity;
    }

    public void setBillQuantity(int billQuantity) {
        this.billQuantity = billQuantity;
    }

    public float getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(float totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public float getTotalDiscountCR() {
        return totalDiscountCR;
    }

    public void setTotalDiscountCR(float totalDiscountCR) {
        this.totalDiscountCR = totalDiscountCR;
    }

    public float getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(float discountPercent) {
        this.discountPercent = discountPercent;
    }

    //public float getTCOSTOF() {
    //  return TCOSTOF;
    //}

    //public void setTCOSTOF(float tCOSTOF) {
    //TCOSTOF = tCOSTOF;
    //}


    public int getDateDev() {
        return dateDev;
    }

    public void setDateDev(int dateDev) {
        this.dateDev = dateDev;
    }

    public String getConditionType() {
        return conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    public String getCancelState() {
        return cancelState;
    }

    public void setCancelState(String cancelState) {
        this.cancelState = cancelState;
    }

    public String getIstat1() {
        return istat1;
    }

    public void setIstat1(String istat1) {
        this.istat1 = istat1;
    }

    public String getIstat4() {
        return istat4;
    }

    public void setIstat4(String istat4) {
        this.istat4 = istat4;
    }

    public String getIndct() {
        return indct;
    }

    public void setIndct(String indct) {
        this.indct = indct;
    }

    public int getNfactu() {
        return nfactu;
    }

    public void setNfactu(int nfactu) {
        this.nfactu = nfactu;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getCreditPayCondition() {
        return creditPayCondition;
    }

    public void setCreditPayCondition(String creditPayCondition) {
        this.creditPayCondition = creditPayCondition;
    }

    public float gettCostoCR() {
        return Float.parseFloat(String.format("%.2f", tCostoCR));
    }

    public void settCostoCR(float tCostoCR) {
        this.tCostoCR = tCostoCR;
    }

    public float gettCosto() {
        return tCosto;
    }

    public void settCosto(float tCosto) {
        this.tCosto = tCosto;
    }

    public int getReturnQuantity() {
        return returnQuantity;
    }

    public void setReturnQuantity(int returnQuantity) {
        this.returnQuantity = returnQuantity;
    }

    public String getTipoMV() {
        return tipoMV;
    }

    public void setTipoMV(String tipoMV) {
        this.tipoMV = tipoMV;
    }

    public String getTipoMo() {
        return tipoMo;
    }

    public void setTipoMo(String tipoMo) {
        this.tipoMo = tipoMo;
    }

	public int getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(int discountCode) {
		this.discountCode = discountCode;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public String getMeasureType() {
		return measureType;
	}

	public void setMeasureType(String measureType) {
		this.measureType = measureType;
	}

	public int getBillItemId() {
		return billItemId;
	}

	public void setBillItemId(int billItemId) {
		this.billItemId = billItemId;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getJdBranchName() {
		return jdBranchName;
	}

	public void setJdBranchName(String jdBranchName) {
		this.jdBranchName = jdBranchName;
	}

	public String getJdCompanyName() {
		return jdCompanyName;
	}

	public void setJdCompanyName(String jdCompanyName) {
		this.jdCompanyName = jdCompanyName;
	}

	public String getJdLineName() {
		return jdLineName;
	}

	public void setJdLineName(String jdLineName) {
		this.jdLineName = jdLineName;
	}

	public String getJdLineId() {
		return jdLineId;
	}
	
	public void setJdLineId(String jdLineId) {
		this.jdLineId = jdLineId;
	}

	public String getJdBranchId() {
		return jdBranchId;
	}

	public void setJdBranchId(String jdBranchId) {
		this.jdBranchId = jdBranchId;
	}

	public String getJdCompanyId() {
		return jdCompanyId;
	}

	public void setJdCompanyId(String jdCompanyId) {
		this.jdCompanyId = jdCompanyId;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}



	public float getPriceWithDiscount() {
		return priceWithDiscount;
	}

	public void setPriceWithDiscount(float priceWithDiscount) {
		this.priceWithDiscount = priceWithDiscount;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getSubtotalCR() {
		return subtotalCR;
	}

	public void setSubtotalCR(float subtotalCR) {
		this.subtotalCR = subtotalCR;
	}

	public String getReceiptNumber() {
		return receiptNumber;
	}

	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public int getReturnSequenceId() {
		return returnSequenceId;
	}

	public void setReturnSequenceId(int returnSequenceId) {
		this.returnSequenceId = returnSequenceId;
	}

	public boolean isExcludeCost() {
		return excludeCost;
	}

	public void setExcludeCost(boolean excludeCost) {
		this.excludeCost = excludeCost;
	}

	public String getStatcv() {
		return statcv;
	}

	public void setStatcv(String statcv) {
		this.statcv = statcv;
	}

	public String getComboId() {
		return comboId;
	}

	public void setComboId(String comboId) {
		this.comboId = comboId;
	}


	/*public int getBillCreated() {
		return billCreated;
	}

	public void setBillCreated(int billCreated) {
		this.billCreated = billCreated;
	}*/
}
