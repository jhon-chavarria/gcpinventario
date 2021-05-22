package ni.com.casapellas.ejb.erp.inventario.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.persistence.Query;


public class SqlQuery {
	
	private enum ConditionOption {
		I,
		D,
		MA,
		ME,
		MAI,
		MEI,
		L,
		LI,
		LF,
		F,
		IN,
		NIN
	}
	
	/**
	 * @author lfonseca
	 * 
	 * Ayuda a generar la condicion de una consulta, basado en los parametros de:
	 * @sField: Un array con el nombre de los campos que forman parte de la condicion.
	 * @sConditionType: un array que contiene el tipo de condicion usada por cada campo: 
	 * 					I  = Igual, 
	 * 					D  = Distintos, 
	 * 					MA = Mayor a,
	 * 					ME = Menor a, 
	 * 					L  = Contega a, 
	 * 					LI = Inicie con, 
	 * 					LF = termine con.
	 * 					IN = Array IN
	 * 					NIN= Array NOT IN
	 * @sValues: El valor de la condicion, por cada campo pasado.
	 * @sDataType: el tipo de datos a compra sea
	 * 					Number = Numero.
	 * 					String = Cadena.
	 * 					Date   = Fecha.
	 * 					Field  = Campo de la misma tabla.
	*/
	public String ConditionQuery(String[] sField, String[] sConditionType, Object[] sValues, String[] sDataType) throws Exception
	{
		if(sField.length == 0)
			throw new Exception("No hay ningun parametro para realizar la condicion");
		
		if(sField.length != sConditionType.length || sField.length != sValues.length || sField.length != sDataType.length)
			throw new Exception("La cantidad de parametros no corresponde al tipo de condicion o valores de parametros");
		
		String sWhere = "";
		for (int i = 0; i < sField.length; i++)
		{
			if(sValues[i] != null)
			{
				if(sWhere.equals(""))
				{
					sWhere += "where ";
					sWhere += sField[i];
				}
				else
				{ 
					sWhere += " And ";
					sWhere += sField[i];
				}
				
				
	
				ConditionOption classEnum = ConditionOption.valueOf(sConditionType[i].toString());
				switch (classEnum) {
				case I:
					sWhere += " = ";
					sWhere += ValueToCompare(sDataType[i], sValues[i].toString());
					break;
				case D:
					sWhere += " <> ";
					sWhere += ValueToCompare(sDataType[i], sValues[i].toString());
					break;
				case MA:
					sWhere += " > ";
					sWhere += ValueToCompare(sDataType[i], sValues[i].toString());
					break;
				case ME:
					sWhere += " < ";
					sWhere += ValueToCompare(sDataType[i], sValues[i].toString());
					break;
				case MAI:
					sWhere += " >= ";
					sWhere += ValueToCompare(sDataType[i], sValues[i].toString());
					break;
				case MEI:
					sWhere += " <= ";
					sWhere += ValueToCompare(sDataType[i], sValues[i].toString());
					break;
				case L:
					if(!sDataType[i].equals("String"))
						throw new Exception("Este Tipo de Condicion solo con el tipo de datos String");
					
					sWhere += " LIKE ";
					sWhere += "(";
					sWhere += ValueToCompare(sDataType[i], "%" + sValues[i].toString() + "%");
					sWhere += ")";
					break;
				case LI:
					if(!sDataType[i].equals("String"))
						throw new Exception("Este Tipo de Condicion solo con el tipo de datos String");
					
					sWhere += " LIKE ";
					sWhere += "(";
					sWhere += ValueToCompare(sDataType[i], sValues[i].toString() + "%");
					sWhere += ")";
					break;
				case LF:
					if(!sDataType[i].equals("String"))
						throw new Exception("Este Tipo de Condicion solo con el tipo de datos String");
					
					sWhere += " LIKE ";
					sWhere += "(";
					sWhere += ValueToCompare(sDataType[i],  "%" + sValues[i].toString());
					sWhere += ")";
					break;
				case IN:
					sWhere += " IN ";
					sWhere += "(";
					String[] sValuesI = (String[])sValues[i];
					int n= 0;
					for(int j = 0; j < sValuesI.length; j++)
					{
						if(sValuesI[j] != null)
						{
							if(n != 0)
								sWhere += ",";
							
							sWhere += ValueToCompare(sDataType[i], sValuesI[j].toString());
							n=1;
						}
					}
					sWhere += ")";
					break;
					
				case NIN:
					sWhere += " NOT IN ";
					sWhere += "(";
					String[] sValuesNI = (String[])sValues[i];
					int sn= 0;
					for(int j = 0; j < sValuesNI.length; j++)
					{
						if(sValuesNI[j] != null)
						{
							if(sn != 0)
								sWhere += ",";
							
							sWhere += ValueToCompare(sDataType[i], sValuesNI[j].toString());
							n=1;
						}
					}
					sWhere += ")";
					break;
				default:
					sWhere += " = ";
					sWhere += ValueToCompare(sDataType[i], sValues[i].toString());
					break;
				}
			}

		}
		return sWhere;
	}
	
	private String ValueToCompare(String sDataType, String sValue) throws Exception
	{
		Boolean bIsConstantValue = isConstantValue(sValue, sDataType);
		String sResult= "" ;
		if(sDataType.equals(""))
			throw new Exception("Verifique que ningun tipo de dato sea Blanco, " +
								"\n				Number = Numero, " +
								"\n				String = cadena, " +
								"\n				Date = Fecha" +
								"\n				Numeric(precision, escala) = Numero con precision y escala" +
								"\n				SmallInt  = Entero corto" +
								"\n				Integer = Entero " +
								"\n				BigInt = Entero Largo " +
								"\n				DecFloat = Decimal flotante" +
								"\n				Real = Flotante" +
								"\n				Double = Double" +
								"\n				Time = Tiempo");
		else if(sDataType.equals("Number") || sDataType.startsWith("Numeric") ||
				sDataType.equals("SmallInt") || sDataType.equals("Integer") ||
				sDataType.equals("BigInt") || sDataType.equals("DecFloat") ||
				sDataType.equals("Real") || sDataType.equals("Double") || bIsConstantValue)
		{
			sResult = sValue;
		}
		else if(sDataType.equals("String"))
		{
			sResult = "'" + sValue + "'";
		}
		else if(sDataType.equals("Date"))
		{
			sResult = "'" + sValue + "'";
		}
		else if(sDataType.equals("Time"))
		{
			sResult = "'" + sValue + "'";
		}
		else if(sDataType.equals("Field"))
		{
			sResult = sValue;
		}
		else
			if(sDataType.equals(""))
				throw new Exception("Verifique el tipo de datos sea Number = Numero, String = cadena, Date = Fecha");
		
		return sResult;
	}
	
	public String BodyQuery(String[] sField, Object[] sValues, String[] sDataType) throws Exception
	{
		if(sField.length == 0)
			throw new Exception("No hay ningun parametro para realizar la condicion");
		
		if(sField.length != sValues.length || sField.length != sDataType.length)
			throw new Exception("La cantidad de parametros no corresponde al tipo de condicion o valores de parametros");
		
		String sBody = "";
		for (int i = 0; i < sField.length; i++)
		{
			if(sValues[i] != null)
			{
				if(sBody.equals(""))
				{
					sBody += sField[i];
				}
				else
				{ 
					sBody += " , ";
					sBody += sField[i];
				}
				
				sBody += " = ";
				sBody += ValueToCompare(sDataType[i], sValues[i].toString());

			}

		}
		return sBody;
	}
	
	public String BodyConcatQuery(String[] sField, Object[] sValues, String[] sDataType) throws Exception
	{
		if(sField.length == 0)
			throw new Exception("No hay ningun parametro para realizar la condicion");
		
		if(sField.length != sValues.length || sField.length != sDataType.length)
			throw new Exception("La cantidad de parametros no corresponde al tipo de condicion o valores de parametros");
		
		String sBody = "";
		for (int i = 0; i < sField.length; i++)
		{
			if(sValues[i] != null)
			{
				if(sBody.equals(""))
				{
					sBody += sField[i];
				}
				else
				{ 
					sBody += " , ";
					sBody += sField[i];
				}
				
				sBody += " = " + sField[i] + " Concat ";
				sBody += ValueToCompare(sDataType[i], sValues[i].toString());

			}

		}
		return sBody;
	}
	
	/**
	 * @author Luis Fonseca
	 * @param Values
	 * @return
	 * @throws Exception 
	 */
	public String BodyValuesInsert(Object[] sValues, String[] sValidationRequired, String[] sDataType) throws Exception
	{

		String strErroresDeTipo = GetWrongValuesForTypes(sValues, sValidationRequired, sDataType);
		if(strErroresDeTipo != null && strErroresDeTipo.length() > 0)
			throw new Exception("Errores de validacion de tipo : "  + strErroresDeTipo);
		
		
		String sBody = "Values(";
		int n = 1;
		for(int i = 0 ; i < sValues.length ; i++)
		{
			//aqui checamos si la especificacion del campo requiere o no un parametro
			Boolean bParameterIsRequired = parameterIsRequired(sValues[i], sDataType[i], sValidationRequired[i], null );
			if(bParameterIsRequired )
			{
				if(n==1 && i==0)
					sBody += "?" + n;
				else
					sBody += ", ?" + n;
				
				n+=1;
			}
			else
			{
				sValues[i] = sValues[i].toString().trim().replace("'", "");
				
				if(i==0)
					sBody +=  ValueToCompare(sDataType[i], sValues[i].toString());
				else
					sBody += ", " + ValueToCompare(sDataType[i], sValues[i].toString());

			}
		}
		
		sBody += ")";
		
		return sBody;
	}	
	
	/**
	 * 
	 * @param val
	 * @param dataType
	 * @param validationRequired
	 * @param sConditionType
	 * @return
	 */
	public Boolean parameterIsRequired(Object val, String dataType, String validationRequired, String sConditionType )
	{
		ConditionOption conditional = null;
		
		if( sConditionType != null)
			conditional = ConditionOption.valueOf(sConditionType);
		
		Boolean bIsConstantValue = isConstantValue(val, dataType);
		if(validationRequired.equals("S")  && !bIsConstantValue && dataType.equals("String") && 
			(conditional == null ||	(conditional != ConditionOption.L && conditional != ConditionOption.LI && conditional != ConditionOption.LF && conditional != ConditionOption.IN && conditional != ConditionOption.NIN  )))
		{
			return true;
		}
		
		return false;
			
	}
	
	/**
	 * 
	 * @param val
	 * @param dataType
	 * @return
	 */
	private Boolean isConstantValue(Object val, String dataType)
	{
		if(val == null || dataType == null)
			return false;
		

		if(dataType.equals("Time") && val.toString().toUpperCase().trim().equals("CURRENT TIME"))
		{
				return true;
		}
		

		if(dataType.equals("Date") && val.toString().toUpperCase().trim().equals("CURRENT DATE"))
		{
				return true;
		}
		
		return false;
			
	}
	
	/**
	 * 
	 * @param sValues
	 * @param sValidationRequired
	 * @param sDataType
	 * @return
	 */
	public String GetWrongValuesForTypes(Object[] sValues, String[] sValidationRequired, String[] sDataType)
	{

		
		String sErrors = "";
		for(int i = 0 ; i < sValues.length ; i++)
		{
			if(sValues[i]!=null && sValidationRequired[i] == "S")
			{
				

				if(isConstantValue(sValues[i], sDataType[i]))
				{
						continue;
				}
				
				if(sDataType[i].equals("Number") || sDataType[i].equals("DecFloat"))
				{
					try
					{
						 new BigDecimal(sValues[i].toString()/*.replaceAll(",","")*/);
					}
					catch(Exception ex)
					{
						sErrors += "Valor " + sValues[i].toString() + " en el indice " + Integer.toString(i) + " no es numerico";
						continue;
					}
					continue;
				}

				
				
				if(sDataType[i].startsWith("Numeric"))
				{
					
					BigDecimal decimalValue = new BigDecimal(0); 
					try
					{
						 String strBuffer = sValues[i].toString().replaceAll(",","");
						 decimalValue = new BigDecimal(strBuffer);
					}
					catch(Exception ex)
					{
						sErrors += "Valor " + sValues[i].toString() + " en el indice " + Integer.toString(i) + " no es numerico";
						continue;
					}
					
					
					
					int iPrecision = -1;
					int iEscala = -1;
					
					int[] iBuffer = getPrecisionAndScaleNumericType(sDataType[i]);
				    if(iBuffer != null && iBuffer.length > 1)
				    {
				    	iPrecision = iBuffer[0];
				    	iEscala = iBuffer[1];
				    }
					
					if(  iPrecision > -1 &&  (iPrecision - iEscala) > 0 && decimalValue.compareTo(new BigDecimal(Math.pow(10,(iPrecision - iEscala)))) >= 0  )
					{
						sErrors += "Valor " + sValues[i].toString() + " en el indice " + Integer.toString(i) + " es un numerico demasiado grande";
									
					}
					continue;
					
				}
				
				if(sDataType[i].equals("Integer"))
				{

					try
					{
						 Integer.parseInt(sValues[i].toString());
					}
					catch(Exception ex)
					{
						sErrors += "Valor " + sValues[i].toString() + " en el indice " + Integer.toString(i) + " no es int";
						continue;
					}
					continue;
				}
				

				if(sDataType[i].equals("SmallInt"))
				{

					try
					{
						 Short.parseShort(sValues[i].toString());
					}
					catch(Exception ex)
					{
						sErrors += "Valor " + sValues[i].toString() + " en el indice " + Integer.toString(i) + " no es short";
						continue;
					}
					continue;
				}

				if(sDataType[i].equals("BigInt"))
				{

					try
					{
						 Long.parseLong(sValues[i].toString());
					}
					catch(Exception ex)
					{
						sErrors += "Valor " + sValues[i].toString() + " en el indice " + Integer.toString(i) + " no es long";
						continue;
					}
					continue;
				}
				

				if(sDataType[i].equals("Real"))
				{

					try
					{
						 Float.parseFloat(sValues[i].toString());
					}
					catch(Exception ex)
					{
						sErrors += "Valor " + sValues[i].toString() + " en el indice " + Integer.toString(i) + " no es float";
						continue;
					}
					continue;
				}
				
				

				if(sDataType[i].equals("Double"))
				{

					try
					{
						 Double.parseDouble(sValues[i].toString());
					}
					catch(Exception ex)
					{
						sErrors += "Valor " + sValues[i].toString() + " en el indice " + Integer.toString(i) + " no es float";
						continue;
					}
					continue;
				}
				

				if(sDataType[i].equals("Date"))
				{
					
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

					try
					{
							format.parse(sValues[i].toString());
					}
					catch(Exception ex)
					{
							sErrors += "Valor " + sValues[i].toString() + " en el indice " + Integer.toString(i) + " no es date";
							continue;
					}
					
					continue;
				}

				if(sDataType[i].equals("Time"))
				{


					
					SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

					try
					{
							format.parse(sValues[i].toString());
					}
					catch(Exception ex)
					{
							sErrors += "Valor " + sValues[i].toString() + " en el indice " + Integer.toString(i) + " no es time";
							continue;
					}
					
					continue;
				}
				
			}
		}
		
		return sErrors;
	}
	
	/**
	 * 
	 * @param strType
	 * @return
	 */
	private int[] getPrecisionAndScaleNumericType(String strType)
	{
		int iPrecision = -1;
		int iEscala = -1;
		
		String[] strArrayBuffer = strType.split(Pattern.quote("("));
		if(strArrayBuffer.length > 1)
		{
			strArrayBuffer = strArrayBuffer[1].replaceAll(Pattern.quote(")"), "").split(Pattern.quote(","));

			if(strArrayBuffer.length > 1)
			{
				try
				{
					iPrecision = Integer.parseInt(strArrayBuffer[0].trim());
					iEscala = Integer.parseInt(strArrayBuffer[1].trim());
					
				}
				catch(Exception ex)
				{
				}
			}
			
		}
		
		return new int[]{iPrecision, iEscala};
	}
	
	
	
	/**
	 * 
	 * @param val
	 * @param iTimes
	 * @return
	 */
	public String[] arrayWithRepeatedValue(String val , int iTimes)
	{
		String[] strRetorno = new String[iTimes];
		
		for(int i = 0 ; i < iTimes ; i++)
		{
			strRetorno[i] = val;
		}
		
		
		return strRetorno;
		
	}
	
	/**
	 * @author Manuel llamas
	 * @param first
	 * @param second
	 * @return
	 * @throws Exception
	 */
	public static <T> T[] concat(T[] first, T[] second) {

		  if(first == null && second == null)
			  return null;
		  if(first == null && second != null)
			  return second;
		  if(first != null && second == null)
			  return first;
		
		
		   int firstLen = first.length;
		   int secondLen = second.length;
		   

		   if(firstLen == 0 && secondLen == 0)
				  return first;
		   if(firstLen == 0 && secondLen != 0)
				  return second;
		   if(firstLen != 0 && secondLen == 0)
				  return first;
		   
		
		  T[] result = Arrays.copyOf(first, first.length + second.length);
		  System.arraycopy(second, 0, result, first.length, second.length);
		  return result;
		}
	
	/**
	 * 
	 * @param q
	 * @param bodyParamSpec
	 * @param whereParamSpec
	 * @return
	 * @throws Exception
	 */
	public String QueryParameterValue(Query q, SqlParamSpec bodyParamSpec,
		                                       SqlParamSpec whereParamSpec) throws Exception
	{
		
		//aqui nos aseguramos de que se rellene con null los condicionales de los campos del body, pues no aplica condicional pero debemos llenarlos
		String[] bodyCondition = arrayWithRepeatedValue(null , bodyParamSpec.getsValidationRequired().length);
		
		return QueryParameterValue(q, concat(bodyParamSpec.getsValues(), whereParamSpec.getsValues()), concat(bodyParamSpec.getsValidationRequired(), whereParamSpec.getsValidationRequired()), concat(bodyParamSpec.getsDataType(), whereParamSpec.getsDataType()), concat(bodyCondition, whereParamSpec.getsConditionType()));
	}
	
	
	/**
	 * 
	 * @param q
	 * @param paramSpec
	 * @return
	 * @throws Exception
	 */
	public String QueryParameterValue(Query q, SqlParamSpec paramSpec) throws Exception
	{
		return QueryParameterValue(q, paramSpec.getsValues(), paramSpec.getsValidationRequired(), paramSpec.getsDataType(), paramSpec.getsConditionType());
	}
	

	/**
	 * @author Luis Fonseca
	 * @param q
	 * @param sValues
	 * @param sValidationRequired
	 * @param sDataType
	 * @return
	 * @throws Exception
	 */
	public String QueryParameterValue(Query q, Object[] sValues, String[] sValidationRequired, String[] sDataType) throws Exception
	{
		//aqui nos aseguramos de que se rellene con null los condicionales de los campos, pues se presupone que no aplican
		String[] sConditionType = arrayWithRepeatedValue(null , sValidationRequired.length);
		
		return QueryParameterValue(q, sValues,  sValidationRequired, sDataType,  sConditionType);
	}
	
	

	
	/**
	 * @author Luis Fonseca
	 * @param q
	 * @param sValues
	 * @param sValidationRequired
	 * @param sDataType
	 * @return
	 * @throws Exception
	 */
	public String QueryParameterValue(Query q, Object[] sValues, String[] sValidationRequired, String[] sDataType, String[] sConditionType) throws Exception
	{
		
		
		String sBody = "Values(";
		int n = 1;
		for(int i = 0 ; i < sValues.length ; i++)
		{
			if(sValues[i]!=null)
			{
				
				Boolean bParameterIsRequired = parameterIsRequired(sValues[i], sDataType[i], sValidationRequired[i], sConditionType[i] );
				
				if(bParameterIsRequired)
				{
					if(sDataType[i].equals("String") )
					{
						q.setParameter(n, sValues[i].toString());
					}
					
					n+=1;
				}
			}
		}
		
		sBody += ")";
		
		return sBody;
	}
}
