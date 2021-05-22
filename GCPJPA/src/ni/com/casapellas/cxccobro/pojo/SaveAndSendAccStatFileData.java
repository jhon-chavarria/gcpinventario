/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.com.casapellas.cxccobro.pojo;

import java.util.List;

import ni.com.casapellas.cxccobro.entity.GcpAccountStatementEmailShipment;

/**
 *
 * @author Francisco Landeros
 */
public class SaveAndSendAccStatFileData {

	private String fileDownLoad;
    private String fileUpLoad;
    
    private String fileDownLoadName;
    private String fileUpLoadName;
    private String fileDownLoadExt;
    private String fileUpLoadExt;
    
    private int codeResponse;
    private String messageResponse;
    
    private GcpAccountStatementEmailShipment gases;
    private List<MailSend> mails;

    public String getFileDownLoad() {
        return fileDownLoad;
    }

    public void setFileDownLoad(String fileDownLoad) {
        this.fileDownLoad = fileDownLoad;
    }

    public String getFileUpLoad() {
        return fileUpLoad;
    }

    public void setFileUpLoad(String fileUpLoad) {
        this.fileUpLoad = fileUpLoad;
    }

    public GcpAccountStatementEmailShipment getGases() {
        return gases;
    }

    public void setGases(GcpAccountStatementEmailShipment gases) {
        this.gases = gases;
    }

    public List<MailSend> getMails() {
        return mails;
    }

    public void setMails(List<MailSend> mails) {
        this.mails = mails;
    }

	public String getFileDownLoadName() {
		return fileDownLoadName;
	}

	public void setFileDownLoadName(String fileDownLoadName) {
		this.fileDownLoadName = fileDownLoadName;
	}

	public String getFileUpLoadName() {
		return fileUpLoadName;
	}

	public void setFileUpLoadName(String fileUpLoadName) {
		this.fileUpLoadName = fileUpLoadName;
	}

	public String getFileDownLoadExt() {
		return fileDownLoadExt;
	}

	public void setFileDownLoadExt(String fileDownLoadExt) {
		this.fileDownLoadExt = fileDownLoadExt;
	}

	public String getFileUpLoadExt() {
		return fileUpLoadExt;
	}

	public void setFileUpLoadExt(String fileUpLoadExt) {
		this.fileUpLoadExt = fileUpLoadExt;
	}

	public int getCodeResponse() {
		return codeResponse;
	}

	public void setCodeResponse(int codeResponse) {
		this.codeResponse = codeResponse;
	}

	public String getMessageResponse() {
		return messageResponse;
	}

	public void setMessageResponse(String messageResponse) {
		this.messageResponse = messageResponse;
	}

}
