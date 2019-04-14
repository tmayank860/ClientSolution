package db;

import java.sql.*;
import javax.swing.JOptionPane;

public class DbConnect {
    static public Connection c;
    static public Statement st;
    static public PreparedStatement insertUser;
    static public PreparedStatement getUsers;
    static public PreparedStatement updateUser;
    static{
        try{
        //Class.forName("oracle.jdbc.driver.OracleDriver");
        Class.forName("com.mysql.jdbc.Driver");
        //c=DriverManager.getConnection(
    // "jdbc:oracle:thin:@localhost:1521:xe",
    //  "clientsol100","clientsol100");
        c=DriverManager.getConnection(
  "jdbc:mysql://localhost:3306/clientsol100","root", "incapp");
        st=c.createStatement();
        insertUser=c.prepareStatement(
          "insert into client_info (name,gender,dob,country,address,"
                  + "language) values(?,?,?,?,?,?)");
        getUsers=c.prepareStatement(
                "select * from client_info where name like ?");
        updateUser=c.prepareStatement(
          "update client_info set name=?,gender=?,dob=?,country=?,address=?,"
                  + "language=? where cid=?");
        }catch(Exception ex){
          JOptionPane.showMessageDialog(null, ex);
        }
    }
}
