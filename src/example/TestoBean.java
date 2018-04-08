package example;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//@Stateless
//@LocalBean
@ManagedBean(name = "TestoBean")
@SessionScoped
public class TestoBean implements Serializable{

    @Resource(name="jdbc/dbs")
    private DataSource ds;

    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    private int support_id, forbrukad_tid;
    private String status;
    private String kommentar_support;
    private String datum;
    private String kompetens;
    private String fornamn;

    public String getMeddelande() {
        return meddelande;
    }

    public void setMeddelande(String meddelande) {
        this.meddelande = meddelande;
    }

    private String meddelande;

    public String getFornamn() {
        return fornamn;
    }

    public void setFornamn(String fornamn) {
        this.fornamn = fornamn;
    }

    public String getEfternamn() {
        return efternamn;
    }

    public void setEfternamn(String efternamn) {
        this.efternamn = efternamn;
    }

    private String efternamn;

    public int getSupport_id() {
        return support_id;
    }

    public void setSupport_id(int support_id) {
        this.support_id = support_id;
    }

    public int getForbrukad_tid() {
        return forbrukad_tid;
    }

    public void setForbrukad_tid(int forbrukad_tid) {
        this.forbrukad_tid = forbrukad_tid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getkommentar_support() {
        return kommentar_support;
    }

    public void setkommentar_support(String kommentar_support) {
        this.kommentar_support = kommentar_support;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getKompetens() {
        return kompetens;
    }

    public void setKompetens(String kompetens) {
        this.kompetens = kompetens;
    }



    public TestoBean() {
        this.support_id = support_id;
        this.forbrukad_tid = forbrukad_tid;
        this.status = status;
        this.kommentar_support = kommentar_support;
        this.datum = datum;
        this.kompetens = kompetens;
    }

    public void addSupportInfo(int getSupport_id, String getKompetens, String getKommentar_support, String getStatus, int getForbrukad_tid, String msg, String clientIdc){
        String sql = "INSERT INTO Support_info Values('" + getSupport_id +"', '"+ getKompetens +"', '"+ getKommentar_support +"', '"+ getStatus +"', '"+ getForbrukad_tid +"')";
        ExecuteQuery(sql,msg,clientIdc);
    }

    public void saveMessage(int getSupport_id, String meddelande, String msg, String clientIdc){
        String sql = "INSERT INTO Support_info Values('" + getSupport_id() +"', '"+ getMeddelande() +"')";
        ExecuteQuery(sql,msg,clientIdc);
    }

    public void updateSupportInfo(SupportInfo support,String msg, String clientIdc){
        String sql = "UPDATE Support_info SET first_name=('" + support.getFirst_name() +"', last_name= '"+ support.getLast_name() +"', Kommentarer= '"+ support.getKommentar_support() +"', Status= '"+ support.getStatus() +"', forbrukad_tid= '"+ support.getForbrukad_tid() + "' WHERE support_id='" + support.getSupport_id() +"')";
        ExecuteQuery(sql,msg,clientIdc);
    }

    public SupportInfo getSupportInfo(String support_id, String msg, String clientIdc){
        SupportInfo supportInfo = new SupportInfo();
        String sql = "SELECT * FROM Support_info WHERE support_id=" + support_id +"'";
        System.out.println(sql);
        ResultSet rs = FetchQuery(sql,msg,clientIdc);
        try {
            if (rs.next()){
                supportInfo.setSupport_id(rs.getInt("Support_id"));
                supportInfo.setKompetens(rs.getString("Kompetenser"));
                supportInfo.setKommentar_support(rs.getString("Kommentar"));
                supportInfo.setStatus(rs.getString("Status"));
                supportInfo.setForbrukad_tid(rs.getInt("forbrukad_tid"));
            }

        }catch (Exception e){
            System.err.println(e.getMessage());
            ERRORSKIT ert = new ERRORSKIT();
            ert.BAJSERROR(msg, clientIdc);
        }
        return supportInfo;
    }


    public void ExecuteQuery(String sql,String msg, String clientIdc){

        try {
           conn = dbs.java_db();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
        }catch (Exception e){
            System.err.println(e.getMessage());
        } finally {

            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                ERRORSKIT ert = new ERRORSKIT();
                ert.BAJSERROR(msg, clientIdc);
            }
        }}

    public ResultSet FetchQuery(String sql,String msg, String clientIdc){
        ResultSet rs = null;
        try {
            conn = dbs.java_db();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            conn.close();
        }catch (Exception e){
            System.err.println(e.getMessage());
            ERRORSKIT ert = new ERRORSKIT();
            ert.BAJSERROR(msg, clientIdc);
        }
        return rs;
    }

    //public void sparadatan(String msg, String clientIdc){

       // try{
        //    conn = dbs.java_db();
            //int val = support_id; //
            //String val2 = kommentar_support; //
            //String val3 = status; //
            //String val5 = first_name; //
            //String val6 = last_name; //
            //int val7 = forbrukad_tid; //
            //String val8 = datum; //

            //String sql = "UPDATE Support_info SET support_id = '" + val + "', first_name = '" + val5 + "', last_name = '" + val6 + "',"
             //       + "status = '" + val3 + "', kommentar_support = '" + val2 + "', forbrukad_tid = '" + val7 + "',"
             //       + "Datum = '" + val8 + "', WHERE support_id = '" + val + "'";

           // pst = conn.prepareStatement(sql);
            //pst.execute();

       // }catch (Exception e)
      //  ERRORSKIT ert = new ERRORSKIT();
       // ert.BAJSERROR(msg, clientIdc);
        {

    }
}
