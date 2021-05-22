package ni.com.casapellas.qs36f.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the SOTORD database table.
 * 
 */
@Entity
@Table(name = "SOTORD") 
@XmlRootElement
public class Sotord implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SotordPK sotordPK;

	public Sotord() {}

	public SotordPK getSotordPK() {
		return sotordPK;
	}

	public void setSotordPK(SotordPK sotordPK) {
		this.sotordPK = sotordPK;
	}

}