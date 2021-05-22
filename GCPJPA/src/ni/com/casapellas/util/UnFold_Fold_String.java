package ni.com.casapellas.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ni.com.casapellas.cxccobro.pojo.GcpConfScriptPojo;

public class UnFold_Fold_String {

 	public UnFold_Fold_String(){
 		
 	}
 	
 	public List<String> foldString(String strCadInp, int blockSize){
 		List<String> content = new ArrayList<String>();
 		try {  
			if(strCadInp.length() <= blockSize){
				content.add(strCadInp);
			}else{
				String strInternalPart = "";
				int index = 0;
				do {
						if((index*(blockSize+1))<strCadInp.length()){  
							strInternalPart = strCadInp.substring((index*(blockSize)), ((blockSize*(index+1))<strCadInp.length()?(blockSize*(index+1)):(strCadInp.length())) );
						}else{
							strInternalPart = strCadInp.substring(((index-1)*(blockSize)), (((index-1)*(blockSize))+(strCadInp.length()-((index-1)*(blockSize)))) );
							break;
						}
					if(strInternalPart.compareToIgnoreCase("")!=0){
						content.add(strInternalPart);
						index ++;
					}				  	
				} while(strInternalPart.compareToIgnoreCase("")!=0);
							
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
 		
 		return content;
 	}
 	
 	
 	public String unFold(List<String>parts){
 		StringBuffer sbuf = new StringBuffer();
 		
 		for (String part : parts) {
			sbuf.append(part);
			
		}
 		 		
 		return sbuf.toString();
 	}
 	public String unFold(List<Object[]>parts,int index){
 		StringBuffer sbuf = new StringBuffer();
 		
 		for (int i=0;i<parts.size();i++) {
			sbuf.append(((Object[])parts.get(i))[index]);
		}
 		 		
 		return sbuf.toString();
 	}
	
 	public String[][] unFold(List<Object[]>parts,int index,String scriptId){
 		String strResp[][] = new String[1][2];
 		for (int i=0;i<parts.size();i++) {
 			Object obj[] = (Object[]) parts.get(i);
 			if(String.valueOf(obj[0]).compareToIgnoreCase(scriptId)==0 ){
 				strResp[0][1]=obj[index]+"";
 				strResp[0][0]=obj[1]+"";
 			}
		}
 		 		
 		return strResp;
 	}
 	
	public String unFoldById(List<Object[]>parts,String scriptId, int index){
 		String strResp = new String();
 		for (int i=0;i<parts.size();i++) {
 			Object[] obj =  (Object[]) parts.get(i);
 			if(String.valueOf(obj[index]).compareToIgnoreCase(scriptId)==0 ){
 				strResp += obj[0]+"";
 			}
		}
 		return strResp;
 	}
	
}
