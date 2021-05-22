package ni.com.casapellas.util;

public class CollectionScheme {

	/* Ambiente de Desarrollo
	 * 
	 */
	public final static String Scheme = "CRPGCPCXC";					// Esquema de Cobranza
	public final static String SchemeJdeCfg = "CRPCTL";					// Esquema de E1 - Archivos de usuo Comun
	public final static String SchemeJdeErp = "CRPDTA";					// Esquema de E1 - Archivos de usuo Comun
	public final static String SchemeFAC400 = "E1QS36F";				// Esquema de Sistema Inventario y Talleres
	public final static String SchemeE1JDE = "E1GCPCXC";				// Esquema de Financiamiento
	
	public final static String SchemeSISEVA = "E1GCPSISEVA2";			// Esquema de SISEVA - Control de Vacaciones
	public final static String SchemeRRHH = "GCPRRHH";					// Esquema de Recursos Humanos
	public final static String SchemeSIADE = "E1GCPSIADE";				// Esquema de SIADE - Se usaba en DICAP
	public final static String SchemeGCPPRDDTA = "ALTDTA";				// Esquema de Jd Edwards A9.2
	public final static String SchemeIF_AUTOS = "E1IF_AUTOS";			// Esquema de Inventarios Autos : Llaves y Inv. Fisico
	
	public final static String SchemeGCPMAG = "E1GCPMAG";				// Esquema de CRM
	public final static String SchemePresupuesto = "E1GCPATP";			// Esquema de Presupuestos de Carroceria
	public final static String SchemeENS = "ENS";						// Esquema de ENS - Entorno de Navegaci�n y Seguridad
	public final static String SchemeCAJA = "E1GCPMCAJA";				// Esquema de CAJA
	public final static String SchemeQUIOSCO = "E1GCPQUIOS"; 			// Esquema del QUIOSCO
	
	public final static String SchemeTaller = "E1QS36F";
	public final static String SchemeInventario = "E1QS36F";
	public final static String SchemeJDE = "CRPDTA";
	public final static String SchemeJDECOM = "CRPCTL";
	public final static String SchemeFinanciamiento = "E1GCPCXC";
	public final static String SchemeMAG = "E1GCPMAG";
	public final static String GCPFMU_SCHEMA = "CRPCPMU";
	
	
	
	/*
	 *   Ambiente de Produccion
	 */
	/*public final static String Scheme = "GCPCXCCOBRO";					// Esquema de Cobranza
	public final static String SchemeJdeCfg = "PRODCTL";				// Esquema de E1 - Archivos de usuo Comun
	public final static String SchemeJdeErp = "PRODDTA";				// Esquema de E1 - Data
	public final static String SchemeFAC400 = "QS36F";					// Esquema de Sistema Inventario y Talleres
	public final static String SchemeE1JDE = "GCPCXC";					// Esquema de Financiamiento
//	
	public final static String SchemeSISEVA = "GCPSISEVA2";				// Esquema de SISEVA - Control de Vacaciones
	public final static String SchemeRRHH = "GCPRRHH";					// Esquema de Recursos Humanos
	public final static String SchemeSIADE = "GCPSIADE";				// Esquema de SIADE - Se usaba en DICAP
	public final static String SchemeGCPPRDDTA = "GCPPRDDTA";			// Esquema de Jd Edwards A9.2
	public final static String SchemeIF_AUTOS = "IF_AUTOS";				// Esquema de Inventarios Autos : Llaves y Inv. Fisico
//	
	public final static String SchemeGCPMAG = "GCPMAG";					// Esquema de CRM
	public final static String SchemePresupuesto = "GCPATP";			// Esquema de Presupuestos de Carroceria
	public final static String SchemeENS = "ENS";						// Esquema de ENS - Entorno de Navegaci�n y Seguridad
	public final static String SchemeCAJA = "GCPMCAJA";					// Esquema de CAJA
	public final static String SchemeQUIOSCO = "GCPQUIOSCO"; 			// Esquema del QUIOSCO
//	
	public final static String SchemeTaller = "QS36F";
	public final static String SchemeInventario = "QS36F";
	public final static String SchemeJDE = "PRODDTA";
	public final static String SchemeJDECOM = "PRODCTL";
	public final static String SchemeFinanciamiento = "GCPCXC";
	public final static String SchemeMAG = "GCPMAG";
	public final static String GCPFMU_SCHEMA = "CPMU";*/


	public static String getScheme() {
		return Scheme;  
	}
	
	public static String SERVER = "http://192.168.1.118/";

    public static String CONTEXT_NAME_WS_Servicios = "GCPeCommerceBACWSREST";
    public static String CONTEXT_NAME_Servicios = "gcpbancorest";
    public final static String INV = "INV";
    
	public final static String LogUrlConnection = "jdbc:as400://192.168.1.3/QS36F;prompt=false";

	
	//Host donde esta la base de datos
	public final static String ipServer = "192.168.1.3";

	
	//Otras variables
	public final static boolean It_is_debug = false;
	public final static String Usuario = "APPCP6";
	public final static String Contrasenia = "APPCP608";
	
	public static String getSchemecaja() {
		return SchemeCAJA;
	}

	public static String getSchemejdecom() {
		return SchemeJDECOM;
	}

	public static String getSchemejde() {
		return SchemeJDE;
	}

	
	public static String getSchemetaller() {
		return SchemeTaller;
	}
	
	public static String getSchemeinventario() {
		return SchemeInventario;
	}

	public static String getSchemepresupuesto() {
		return SchemePresupuesto;
	}
	
}
