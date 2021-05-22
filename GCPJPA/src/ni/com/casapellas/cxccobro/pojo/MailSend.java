/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.com.casapellas.cxccobro.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Francisco Landeros
 */
public class MailSend {

    private String from;
    private List<String> to;
    private List<String> cc;
    private List<String> cco;

    public MailSend() {

    }
    
    public void addTo(String data) {
        if(to == null){
            to = new ArrayList<String>();
        }
        to.add(data);
    }
    
    public void addCc(String data) {
        if(cc == null){
            cc = new ArrayList<String>();
        }
        cc.add(data);
    }
    
    public void addCco(String data) {
        if(cco == null){
            cco = new ArrayList<String>();
        }
        cco.add(data);
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public List<String> getCco() {
        return cco;
    }

    public void setCco(List<String> cco) {
        this.cco = cco;
    }

}
