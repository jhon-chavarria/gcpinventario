package ni.com.casapellas.gcpmcaja.pojos;

import java.io.Serializable;


/**
 * Descripcion de RecibojdeCaja.java
 * Sistemas: Quiosco
 * Objetivos: Pojo que se utilizara para retener informacion relacionada a
 *            la tabla RecibojdeCaja.
 * Fecha Creacion: jul 19, 2016
 * @author MLlamas
 * Version:
 * @since
 * @see
 *
 *
 */
public class RecibojdeCaja extends Recibojde implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Integer getNumeroRecibo() {
        return this.getNumrec();
       }

       public void setNumeroRecibo(Integer NumeroRecibo) {
        this.setNumrec( NumeroRecibo);
       }
      public String getCodigoCompania() {
        return this.getCodcomp();
       }

       public void setCodigoCompania(String CodigoCompania) {
        this.setCodcomp( CodigoCompania);
       }
      public Integer getNumeroReciboJde() {
        return this.getRecjde();
       }

       public void setNumeroReciboJde(Integer NumeroReciboJde) {
        this.setRecjde( NumeroReciboJde);
       }
      public Integer getNumeroBatch() {
        return this.getNobatch();
       }

       public void setNumeroBatch(Integer NumeroBatch) {
        this.setNobatch( NumeroBatch);
       }
      public int getNoCaja() {
        return this.getCaid();
       }

       public void setNoCaja(int NoCaja) {
        this.setCaid( NoCaja);
       }
      public String getCodigoSucursal() {
        return this.getCodsuc();
       }

       public void setCodigoSucursal(String CodigoSucursal) {
        this.setCodsuc( CodigoSucursal);
       }
      public String getTipoDocumento() {
        return this.getTipodoc();
       }

       public void setTipoDocumento(String TipoDocumento) {
        this.setTipodoc( TipoDocumento);
       }
      public String getTipoRecibo() {
        return this.getTiporec();
       }

       public void setTipoRecibo(String TipoRecibo) {
        this.setTiporec( TipoRecibo);
       }

	
	
}

