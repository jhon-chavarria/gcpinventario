package ni.com.casapellas.gcpsiade.pojos;

public class ExistencesP {

	private String invitm;
	private String store;
	private String storeskind;
	private int existences;
	private int reserved;
	private int available_existence;
	private String store_descri;
	private String location;

	public String getInvitm() {
		return invitm;
	}

	public int getExistences() {
		return existences;
	}

	public void setInvitm(String invitm) {
		this.invitm = invitm;
	}

	public void setExistences(int existences) {
		this.existences = existences;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getStoreskind() {
		return storeskind;
	}

	public int getReserved() {
		return reserved;
	}

	public int getAvailable_existence() {
		return available_existence;
	}

	public void setStoreskind(String storeskind) {
		this.storeskind = storeskind;
	}

	public void setReserved(int reserved) {
		this.reserved = reserved;
	}

	public void setAvailable_existence(int available_existence) {
		this.available_existence = available_existence;
	}

	public String getStore_descri() {
		return store_descri;
	}

	public void setStore_descri(String store_descri) {
		this.store_descri = store_descri;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
