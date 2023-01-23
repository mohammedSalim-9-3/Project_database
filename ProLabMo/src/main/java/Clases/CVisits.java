package Clases;

public class CVisits {
   public int id;
   public String docName;
   public String patName;
   public String medReport;

    public CVisits(int id, String docName, String patName, String medReport) {
        this.id = id;
        this.docName = docName;
        this.patName = patName;
        this.medReport = medReport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName;
    }

    public String getMedReport() {
        return medReport;
    }

    public void setMedReport(String medReport) {
        this.medReport = medReport;
    }
}
