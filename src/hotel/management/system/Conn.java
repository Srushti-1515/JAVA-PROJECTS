
package hotel.management.system;

import java.sql.*;

public class Conn {
    Connection con;
    Statement s;
    Conn(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver"); //step1: Loading Driver
        String url="jdbc:mysql://localhost:3306/hotelmanagementsystem";
        con=DriverManager.getConnection(url, "root", "Dreams@15"); //step2: creting a connection stream
        s=con.createStatement(); //step3: Creating statement with the help of create statement we can execute the query
        
        }catch(Exception e){
        e.printStackTrace();
        }
    }
}
    