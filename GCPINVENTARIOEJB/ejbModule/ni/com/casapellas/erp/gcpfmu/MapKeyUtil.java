package ni.com.casapellas.erp.gcpfmu;


public class MapKeyUtil {
	
	private Object key1;
	private Object key2;

	@Override
	public boolean equals(Object object) {
		if (((MapKeyUtil) object).key1 == null && ((MapKeyUtil) object).key2 == null) {
			return true;
		}
		if (((MapKeyUtil) object).key1 == null
				&& ((MapKeyUtil) object).key2.equals(this.key2)) {
			return true;
		}
		if (((MapKeyUtil) object).key1.equals(this.key1)
				&& ((MapKeyUtil) object).key2 == null) {
			return true;
		}
		if (((MapKeyUtil) object).key1.equals(this.key1)
				&& ((MapKeyUtil) object).key2.equals(this.key2)) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hashCode = this.key1 == null ? 0 : this.key1.hashCode();
		hashCode = hashCode + (this.key2 == null ? 0 : this.key2.hashCode());
		return hashCode;
	}

	public Object getKey1() {
		return key1;
	}

	public void setKey1(Object key1) {
		this.key1 = key1;
	}

	public Object getKey2() {
		return key2;
	}

	public void setKey2(Object key2) {
		this.key2 = key2;
	}

	// TODO Auto-generated constructor stub
}