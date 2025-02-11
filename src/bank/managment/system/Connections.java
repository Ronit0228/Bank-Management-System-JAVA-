package bank.managment.system;

import javax.swing.undo.StateEdit;
import java.sql.*;

public class Connections {

    Connection connection;
    Statement statement;

    public Connections(){

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","root", "Ronit@123");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
