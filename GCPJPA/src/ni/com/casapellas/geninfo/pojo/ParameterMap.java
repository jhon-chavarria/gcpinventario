package ni.com.casapellas.geninfo.pojo;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="Parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParameterMap {
	private Map<String, Parameter> parameterMap = new HashMap<String, Parameter>();

    /**
     * @return the parameterMap
     */
    public Map<String, Parameter> getParameterMap() {
        return parameterMap;
    }

    /**
     * @param parameterMap the parameterMap to set
     */
    public void setParameterMap(Map<String, Parameter> parameterMap) {
        this.parameterMap = parameterMap;
    }
}
