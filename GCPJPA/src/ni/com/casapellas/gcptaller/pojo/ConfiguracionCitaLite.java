package ni.com.casapellas.gcptaller.pojo;

import java.io.Serializable;

/**
 *
 * @author manuel
 */
public class ConfiguracionCitaLite implements Serializable {
    private static final long serialVersionUID = 829545465770545508L;
    
    
    private String urlPrepull;
    private String urlImpresion;
    private Integer outputPerformance;
    private String budgetImportPath;
    private String budgetImportedPath;
    private String budgetCopyImported;
    private String budgetDeleteImported;
    private String budgetNotImportedPath;
    private String budgetAskMoveNotImported;
    
    
    private String fotosDanioPath;
    
    public ConfiguracionCitaLite()
    {
    
        budgetCopyImported = "N";
        budgetDeleteImported = "S";
        
    }
    

    public String getUrlPrepull() {
        return urlPrepull;
    }

    public void setUrlPrepull(String urlPrepull) {
        this.urlPrepull = urlPrepull;
    }

    public String getUrlImpresion() {
        return urlImpresion;
    }

    public void setUrlImpresion(String urlImpresion) {
        this.urlImpresion = urlImpresion;
    }

    public Integer getOutputPerformance() {
        return outputPerformance;
    }

    public void setOutputPerformance(Integer outputPerformance) {
        this.outputPerformance = outputPerformance;
    }

    public String getBudgetImportPath() {
        return budgetImportPath;
    }

    public void setBudgetImportPath(String budgetImportPath) {
        this.budgetImportPath = budgetImportPath;
    }

    public String getBudgetImportedPath() {
        return budgetImportedPath;
    }

    public void setBudgetImportedPath(String budgetImportedPath) {
        this.budgetImportedPath = budgetImportedPath;
    }

    public String getBudgetCopyImported() {
        return budgetCopyImported;
    }

    public void setBudgetCopyImported(String budgetCopyImported) {
        this.budgetCopyImported = budgetCopyImported;
    }

    public String getBudgetDeleteImported() {
        return budgetDeleteImported;
    }

    public void setBudgetDeleteImported(String budgetDeleteImported) {
        this.budgetDeleteImported = budgetDeleteImported;
    }


    
    public Boolean getBudgetCopyImportedBool() {
        return budgetCopyImported.equals("S");
    }

    public void setBudgetCopyImportedBool(Boolean budgetCopyImportedBool) {
        this.budgetCopyImported = budgetCopyImportedBool ? "S" : "N";
    }

    public Boolean getBudgetDeleteImportedBool() {
        return !budgetDeleteImported.equals("N");
    }

    public void setBudgetDeleteImportedBool(Boolean budgetDeleteImportedBool) {
        this.budgetDeleteImported = budgetDeleteImportedBool ? "S" : "N";
    }

    public String getBudgetNotImportedPath() {
        return budgetNotImportedPath;
    }

    public void setBudgetNotImportedPath(String budgetNotImportedPath) {
        this.budgetNotImportedPath = budgetNotImportedPath;
    }

    public String getBudgetAskMoveNotImported() {
        return budgetAskMoveNotImported;
    }

    public void setBudgetAskMoveNotImported(String budgetAskMoveNotImported) {
        this.budgetAskMoveNotImported = budgetAskMoveNotImported;
    }

    
    public Boolean getBudgetAskMoveNotImportedBool() {
        return !budgetAskMoveNotImported.equals("N");
    }

    public void setBudgetAskMoveNotImportedBool(Boolean budgetAskMoveNotImportedBool ) {
        this.budgetAskMoveNotImported = budgetAskMoveNotImportedBool ? "S" : "N";
    }

    public String getFotosDanioPath() {
        return fotosDanioPath;
    }

    public void setFotosDanioPath(String fotosDanioPath) {
        this.fotosDanioPath = fotosDanioPath;
    }
    
    
    
    
}

