/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete.com.Bugtracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author kai
 */
public class ModeloBug {

    
    private static DataSource origenDatos;
    
    public ModeloBug(DataSource origen){
        this.origenDatos = origen;
    }
    
    public List<Bug> getBugs()throws Exception{
        List<Bug> bug = new ArrayList<>();
        //Class.forName("com.mysql.jdbc.Driver");                  
        Connection miConnection = null;
        Statement miStatement = null;
        ResultSet miResultset = null;
        try{
        miConnection = origenDatos.getConnection();

        String sentenciaSql="SELECT * FROM BUG";
        miStatement = miConnection.createStatement();

        miResultset = miStatement.executeQuery(sentenciaSql);
            
            while(miResultset.next()){
                int id = miResultset.getInt(1);
                String name = miResultset.getString(2);
                String type = miResultset.getString(3);
                String descripcion = miResultset.getString(4);
                String status = miResultset.getString(5);
                String user = miResultset.getString(6);
                Date fecha_inicial = miResultset.getDate(7);
                Date fecha_final = miResultset.getDate(8);
                
                Bug temBug = new Bug(id,name,type,descripcion,status,user,fecha_inicial,fecha_final);
                bug.add(temBug);
            }
        }finally{
          miStatement.close();
          miConnection.close();  
        }   
            
       
        return bug;
    }
/////cambie private por static en este metodo y en el origenDatos
   void addNewBug(Bug newBug) {
       Connection miConnection = null;
       PreparedStatement miStatement = null;
       
        try {
            miConnection = origenDatos.getConnection();
            String instruccionSQL="INSERT INTO BUG (NAME,TYPE,DESCRIPTION,STATUS,USER,INITIALDATE)"+
                    "VALUES(?,?,?,?,?,?)";
            miStatement = miConnection.prepareCall(instruccionSQL);
            
            miStatement.setString(1, newBug.getbName());
            miStatement.setString(2, newBug.getbType());
            miStatement.setString(3, newBug.getbDescription());
            miStatement.setString(4, newBug.getbStatus());
            miStatement.setString(5, newBug.getbUser());
            
            //convirtiendo de fecha Util.Date a sql.Date
            java.util.Date utilDate = newBug.getBinitial_Date();
            long fechaEnlong = utilDate.getTime();
            java.sql.Date fechaConvertida;
            fechaConvertida = new java.sql.Date(fechaEnlong);            
            miStatement.setDate(6, fechaConvertida);
            
            miStatement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloBug.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    Bug getBug(int codigo) throws ParseException {
        Bug bug=null;
        Connection miConnection = null;
        PreparedStatement ps = null;
        ResultSet miRs = null;
        SimpleDateFormat formatdate=new SimpleDateFormat("yyyy-MM-dd");
        String str=null;
        try {
            miConnection = origenDatos.getConnection();
            
            String insSql = "select * from BUG WHERE ID=?";
            ps = miConnection.prepareStatement(insSql);
            ps.setInt(1, codigo);
            miRs= ps.executeQuery();
            
            if (miRs.next()){
                int codi = miRs.getInt(1);
                String name = miRs.getString(2);
                String type = miRs.getString(3);
                String description = miRs.getString(4);
                String status = miRs.getString(5);
                String user = miRs.getString(6);
                Date inicialf = miRs.getDate(7);
                Date finalf = miRs.getDate(8);
                if (finalf==null){
                    finalf=new Date();
                    str = formatdate.format(finalf);
                    bug =new Bug(codi,name,type,description,status,user,inicialf,str);
                }else{
                    str = formatdate.format(finalf);
                    bug =new Bug(codi,name,type,description,status,user,inicialf,str);}
            }
               
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloBug.class.getName()).log(Level.SEVERE, null, ex);
        }
       return bug;
    }

    void actualizar(Bug bug) {
        Connection miConnection = null;
        PreparedStatement miStatement = null;
       
        try {
            miConnection = origenDatos.getConnection();
            String instruccionSQL="UPDATE  BUG SET NAME=?,TYPE=?,DESCRIPTION=?,STATUS=?,USER=?,INITIALDATE=?,FINALDATE=?"+
                    "WHERE ID=?";
            miStatement = miConnection.prepareCall(instruccionSQL);
            
            miStatement.setString(1, bug.getbName());
            miStatement.setString(2, bug.getbType());
            miStatement.setString(3, bug.getbDescription());
            miStatement.setString(4, bug.getbStatus());
            miStatement.setString(5, bug.getbUser());
            java.util.Date utildate = bug.getBinitial_Date() ;
            
            long time = utildate.getTime();
            java.sql.Date sqlDate = new java.sql.Date(time);
            miStatement.setDate(6, sqlDate);
            
            java.util.Date utildate2 = bug.getBfinal_Date() ;
            
            long time2 = utildate2.getTime();
            java.sql.Date sqlDate2 = new java.sql.Date(time2);
            miStatement.setDate(7, sqlDate2);
            
            miStatement.setInt(8, bug.getbCode());
            miStatement.execute();
        }catch(SQLException e){
            
        }
    }

    void addNewBug2(Bug newBug) {
        Connection miConnection = null;
        PreparedStatement miStatement = null;
       
        try {
            miConnection = origenDatos.getConnection();
            String instruccionSQL="INSERT INTO BUG (NAME,TYPE,DESCRIPTION,STATUS,USER)"+
                    "VALUES(?,?,?,?,?)";
            miStatement = miConnection.prepareCall(instruccionSQL);
            
            miStatement.setString(1, newBug.getbName());
            miStatement.setString(2, newBug.getbType());
            miStatement.setString(3, newBug.getbDescription());
            miStatement.setString(4, newBug.getbStatus());
            miStatement.setString(5, newBug.getbUser());
            
            //convirtiendo de fecha Util.Date a sql.Date
            /*java.util.Date utilDate = newBug.getBinitial_Date();
            long fechaEnlong = utilDate.getTime();
            java.sql.Date fechaConvertida;
            fechaConvertida = new java.sql.Date(fechaEnlong);            
            miStatement.setDate(6, fechaConvertida);*/
            
            miStatement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloBug.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
