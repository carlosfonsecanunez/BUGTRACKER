/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete.com.Bugtracker;

import java.util.Date;

/**
 *
 * @author kai
 */
public class Bug {
    
    private int bCode;
    private String bName;
    private String bType;
    private String bDescription;
    private String bStatus;    
    private String bUser;
    private Date binitial_Date;
    private Date bfinal_Date;
    
    //Constructor 1

    /**
     *
     * @param bCode
     * @param bName
     * @param bType
     * @param bDescription
     * @param bStatus
     * @param bUser
     * @param binitial_Date
     * @param bfinal_Date
     */
    
    public Bug(int bCode,String bName,String bType,String bDescription,String bStatus,String bUser,Date binitial_Date,Date bfinal_Date){
        this.bCode = bCode;
        this.bName = bName;
        this.bType = bType;
        this.bDescription = bDescription;
        this.bStatus = bStatus;
        this.bUser = bUser;
        this.binitial_Date = binitial_Date;
        this.bfinal_Date = bfinal_Date;
    }
    
    /** Contructor 2 sin el campo Codigo
     *
     * @param bName
     * @param bType
     * @param bDescription
     * @param bStatus
     * @param bUser
     * @param binitial_Date
     * @param bfinal_Date
     */
    public Bug(String bName,String bType,String bDescription,String bStatus,String bUser,Date binitial_Date,Date bfinal_Date){
        this.bName = bName;
        this.bType = bType;
        this.bDescription = bDescription;
        this.bStatus = bStatus;
        this.bUser = bUser;
        this.binitial_Date = binitial_Date;
        this.bfinal_Date = bfinal_Date;
    }
    
    public Bug(String bName,String bType,String bDescription,String bStatus,String bUser,Date binitial_Date){
        this.bName = bName;
        this.bType = bType;
        this.bDescription = bDescription;
        this.bStatus = bStatus;
        this.bUser = bUser;
        this.binitial_Date = binitial_Date;
    }
    public Bug(int bCode,String bName,String bType,String bDescription,String bStatus,String bUser){
        this.bCode = bCode;
        this.bName = bName;
        this.bType = bType;
        this.bDescription = bDescription;
        this.bStatus = bStatus;
        this.bUser = bUser;
        
    }
    /**
     * @return the bCode
     */
    public int getbCode() {
        return bCode;
    }

    /**
     * @param bCode the bCode to set
     */
    public void setbCode(int bCode) {
        this.bCode = bCode;
    }

    /**
     * @return the bName
     */
    public String getbName() {
        return bName;
    }

    /**
     * @param bName the bName to set
     */
    public void setbName(String bName) {
        this.bName = bName;
    }

    /**
     * @return the bType
     */
    public String getbType() {
        return bType;
    }

    /**
     * @param bType the bType to set
     */
    public void setbType(String bType) {
        this.bType = bType;
    }

    /**
     * @return the bDescription
     */
    public String getbDescription() {
        return bDescription;
    }

    /**
     * @param bDescription the bDescription to set
     */
    public void setbDescription(String bDescription) {
        this.bDescription = bDescription;
    }

    /**
     * @return the bStatus
     */
    public String getbStatus() {
        return bStatus;
    }

    /**
     * @param bStatus the bStatus to set
     */
    public void setbStatus(String bStatus) {
        this.bStatus = bStatus;
    }

    /**
     * @return the bUser
     */
    public String getbUser() {
        return bUser;
    }

    /**
     * @param bUser the bUser to set
     */
    public void setbUser(String bUser) {
        this.bUser = bUser;
    }

    /**
     * @return the binitial_Date
     */
    public Date getBinitial_Date() {
        return binitial_Date;
    }

    /**
     * @param binitial_Date the binitial_Date to set
     */
    public void setBinitial_Date(Date binitial_Date) {
        this.binitial_Date = binitial_Date;
    }

    /**
     * @return the bfinal_Date
     */
    public Date getBfinal_Date() {
        return bfinal_Date;
    }

    /**
     * @param bfinal_Date the bfinal_Date to set
     */
    public void setBfinal_Date(Date bfinal_Date) {
        this.bfinal_Date = bfinal_Date;
    }
    
    
}
