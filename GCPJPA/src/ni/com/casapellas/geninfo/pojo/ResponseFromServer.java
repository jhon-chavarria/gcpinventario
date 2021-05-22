package ni.com.casapellas.geninfo.pojo;

public class ResponseFromServer {
	private int codeMessage;
	private String textmessage;

	public ResponseFromServer() {
	}

	public ResponseFromServer(int codeMessage, String textmessage) {
		super();
		this.codeMessage = codeMessage;
		this.textmessage = textmessage;
	}

	public int getCodeMessage() {
		return codeMessage;
	}

	public void setCodeMessage(int codeMessage) {
		this.codeMessage = codeMessage;
	}

	public String getTextmessage() {
		return textmessage;
	}

	public void setTextmessage(String textmessage) {
		this.textmessage = textmessage;
	}

}
