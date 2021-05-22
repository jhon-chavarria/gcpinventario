package ni.com.casapellas.ejb.erp.inventario.util;

import java.util.Collection;

import javax.persistence.Query;

public class ToolsStringEjb {
	public static String retornoMesSiguiente(String mes, int anio) {
		String anioMes = "";
		if (mes.compareToIgnoreCase("12") == 0) {
			anioMes = (anio + 1) + "00";
		} else {
			if (Integer.parseInt(mes) < 9) {
				anioMes = anio + "0" + (Integer.parseInt(mes) + 1);
			} else {
				anioMes = (anio) + String.valueOf(Integer.parseInt(mes) + 1);
			}
		}
		return anioMes;
	}

	public static String formatoAnioMesInvd49(String aniomes) {
		String strAnioMes = "";
		try {
//			System.out.println("cadena -- " + aniomes + "mes: "
//					+ aniomes.substring(4, 6) + " anio: "
//					+ aniomes.substring(0, 3));
			strAnioMes = aniomes.substring(4, 6) + aniomes.substring(0, 4);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println("VALOR DEVUELTO: " + strAnioMes);
		return strAnioMes;
	}
	

	public static String constructQueryParam(String field, int paramNumber, Object[] values) {
        StringBuilder sqlWhere = new StringBuilder(" AND ");
        if (values != null) {
            if (values.length == 1) {
                sqlWhere.append(" ").append(field).append(" ").append("= ").append("?").append(paramNumber);
            } else {
                sqlWhere.append(" ").append(field).append(" ").append("IN ( ").append("?").append(paramNumber).append(" ) ");
            }
        }
        return sqlWhere.toString();
    }

	public static void constructQueryParamValues(int paramNumber, Object[] values, Query query) {
        if (values != null) {
            if (values.length == 1) {
                query.setParameter(paramNumber, values[0]);
            } else {
                query.setParameter(paramNumber, values);
            }
        }
    }
    
    public static void constructQueryParamCollection(int paramNumber, final Collection<String> values, Query query) {
        if (values != null) {
            if (values.size() == 1) {
                query.setParameter(paramNumber, values.iterator().next());
            } else {
                query.setParameter(paramNumber, values);
            }
        }
    }

    public static String constructQuery(String field, boolean typeOfString, Object[] values) {
        StringBuilder sqlWhere = new StringBuilder(" AND ");
        if (values != null) {
            if (values.length == 1) {
                sqlWhere.append(" ").append(field).append(" ").append("= ");
                if (typeOfString) {
                	sqlWhere.append("'");
                }
                sqlWhere.append(values[0]);
                if (typeOfString) {
                	sqlWhere.append("'");
                }
            } else {
                sqlWhere.append(" ").append(field).append(" ").append("IN ( ");
                for (int i = 0; i < values.length; i++) {
                    if (typeOfString) {
                        sqlWhere.append("'");
                    }
                    sqlWhere.append(values[i]);
                    if (typeOfString) {
                        sqlWhere.append("'");
                    }
                    if (i < (values.length - 1)) {
                        sqlWhere.append(",");
                    }
                }
                sqlWhere.append(" ) ");
            }
        }
        return sqlWhere.toString();
    }
    
    public static String constructQuery(boolean isFirst, String field, boolean typeOfString, Object[] values) {
    	StringBuilder sqlWhere = new StringBuilder();
    	if(isFirst){
    		sqlWhere.append(" WHERE ");
    	} else {
    		sqlWhere.append(" AND ");
    	}
        if (values != null) {
            if (values.length == 1) {
                sqlWhere.append(" ").append(field).append(" ").append("= ");
                if (typeOfString) {
                	sqlWhere.append("'");
                }
                sqlWhere.append(values[0]);
                if (typeOfString) {
                	sqlWhere.append("'");
                }
            } else {
                sqlWhere.append(" ").append(field).append(" ").append("IN ( ");
                for (int i = 0; i < values.length; i++) {
                    if (typeOfString) {
                        sqlWhere.append("'");
                    }
                    sqlWhere.append(values[i]);
                    if (typeOfString) {
                        sqlWhere.append("'");
                    }
                    if (i < (values.length - 1)) {
                        sqlWhere.append(",");
                    }
                }
                sqlWhere.append(" ) ");
            }
        }
        return sqlWhere.toString();
    }
    
    public static String constructOrLikeQuery(boolean isFirst, String field, boolean typeOfString, Object[] values) {
        StringBuilder sqlWhere = new StringBuilder();
        if(isFirst){
//         sqlWhere.append(" WHERE ");
        } else {
         sqlWhere.append(" OR ");
        }
        Object[] valsTmp = String.valueOf(values[0]).trim().split(" ");
        for (int i = 0; i < valsTmp.length; i++) {
         if(i != 0)
          sqlWhere.append(" OR ");
         sqlWhere.append(field).append(" ").append(" LIKE UPPER ");
               if (typeOfString) {
                sqlWhere.append("('%");
               }
               sqlWhere.append(valsTmp[i]);
               if (typeOfString) {
                sqlWhere.append("%')");
               }
           }
           return sqlWhere.toString();
       }
    
    public static String constructLikeQuery(boolean isFirst, String field, boolean typeOfString, Object[] values) {
    	StringBuilder sqlWhere = new StringBuilder();
    	if(isFirst){
    		sqlWhere.append(" WHERE ");
    	} else {
    		sqlWhere.append(" AND ");
    	}        
        sqlWhere.append(" ").append(field).append(" ").append(" LIKE UPPER ");
        if (typeOfString) {
        	sqlWhere.append("('%");
        }
        sqlWhere.append(values[0]);
        if (typeOfString) {
        	sqlWhere.append("%')");
        }
        return sqlWhere.toString();
    }
    
    public static String constructQueryFirst(String field, boolean typeOfString, Object[] values) {
        StringBuilder sqlWhere = new StringBuilder();
        if (values != null) {
            if (values.length == 1) {
                sqlWhere.append(" ").append(field).append(" ").append("= ");
                if (typeOfString) {
                	sqlWhere.append("'");
                }
                sqlWhere.append(values[0]);
                if (typeOfString) {
                	sqlWhere.append("'");
                }
            } else {
                sqlWhere.append(" ").append(field).append(" ").append("IN ( ");
                for (int i = 0; i < values.length; i++) {
                    if (typeOfString) {
                        sqlWhere.append("'");
                    }
                    sqlWhere.append(values[i]);
                    if (typeOfString) {
                        sqlWhere.append("'");
                    }
                    if (i < (values.length - 1)) {
                        sqlWhere.append(",");
                    }
                }
                sqlWhere.append(" ) ");
            }
        }
        return sqlWhere.toString();
    }
	
    public static String constructOrLikeForQuery(boolean isFirst, String field, boolean typeOfString, Object[] values) {
        StringBuilder sqlWhere = new StringBuilder();
        if(!isFirst){
         sqlWhere.append(" AND ");
        }
        
        for (int i = 0; i < values.length; i++) {
         if(i != 0)
          sqlWhere.append(" AND ");
         sqlWhere.append(field).append(" ").append(" LIKE UPPER ");
               if (typeOfString) {
                sqlWhere.append("('%");
               }
               sqlWhere.append(values[i]);
               if (typeOfString) {
                sqlWhere.append("%')");
               }
           }
           return sqlWhere.toString();
       }
    

}
