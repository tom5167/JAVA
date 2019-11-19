/*
 * Copyright (C) 2019 PatientCare - Hospital Management System
 *
 * Licensed under PatientCare CLIENT LICENSE AGREEMENT (the "License");
 * you may not use this file except in compliance with the License.
 *
 * User acknowledges and agrees that this class constitute and incorporate PatientCare's confidential information. 
 * User shall take all reasonable precautions necessary to safeguard the confidentiality of all confidential information.  
 * 
 * User shall not:
 * (a) allow the removal or defacement of any confidentiality or proprietary notice placed on any confidential information
 * (a) permit any other person or third party to use or access the class; 
 * (b) sublicense, redistribute, sell, lease, or otherwise make the class available to any other person or third party;
 * (c) redistribute through personal email accounts, USB drives, internal or third party FTP sites, or internal share drives;  
 * (c) reproduce, copy, translate, modify, adapt, decompile, disassemble or reverse engineer any portion of the class or 
 *     otherwise attempt to secure the source code of all or any part of the Software; 
 */
package patientCareDAO;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

import patientCareLogger.PatientCareLogger;

public class JdbcDBConn {
	static Logger logger = PatientCareLogger.getLogger();
    Connection conn = null;
    
    public static Connection jdbcConnection(){
    	String serverName = "DESKTOP-R652O6A\\SQLEXPRESS";
    	//String portNo = "1433";
    	String portNo = "65377";
    	String databaseName = "PatientCareDB";
    	String userName = "sa";
    	String password = "admin";
    	String connectionUrl ="jdbc:sqlserver://"+serverName+":"+portNo+";"
                        + "database="+databaseName+";"
                        + "user="+userName+";"
                        + "password="+password+";"
                        //+ "integratedSecurity=true"
                        ;
    	//System.out.println("connectionUrl -> "+connectionUrl);
        try{
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
            Connection conn = DriverManager.getConnection(connectionUrl);
            return conn;
        }catch(Exception e){
        	e.printStackTrace();
            return null;
        }
    }
}
