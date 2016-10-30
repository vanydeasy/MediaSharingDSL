/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mediasharingdsl

import java.sql.*; 
import groovy.sql.Sql 

/**
 *
 * @author vanyadeasy
 */
class DatabaseConnector {
    // Creating a connection to the database
    def sql = Sql.newInstance('jdbc:mysql://localhost:3306/media_sharing', 'root', '', 'com.mysql.jdbc.Driver')
    
    def getMedia(id){
        return sql.rows("SELECT * FROM media JOIN user WHERE media.id="+id)[0]
    }
    
    def getUser(username) {
        return sql.rows("SELECT * FROM user WHERE username="+username)[0]
    }
    
    def insertUser(info) {
        def command = "INSERT INTO user(username, email, password, first_name, last_name, active) VALUES "+\
                        "('${info.username}', '${info.email}', '${info.password}', '${info.first_name}', '${info.last_name}', 1)"
        try {
            sql.execute(command);
            sql.commit()
            println("Signup succedded") 
        } catch(Exception ex) {
            sql.rollback()
            println("Signup failed")
        }
    }
}

