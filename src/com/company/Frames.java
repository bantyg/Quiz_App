package com.company;

import org.omg.CORBA.FREE_MEM;

import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import java.sql.*;




public class Frames {
    JFrame frame = new JFrame("quiz");
    void setProperty(){
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());

    }

    public static Connection createDBConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:XE", "quiz_master", "password");
    }

    public ResultSet getDataFromDB(String query) throws SQLException {
        Connection connection = createDBConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    void showQuestionOnFrame() throws SQLException {
        ResultSet resultSet = getDataFromDB("select * from QUESTIONS");
        resultSet.next();
        JTextArea ta = new JTextArea(2,15);
        JButton ans = new JButton("Answer");
        frame.add(new Label(resultSet.getString("QUESTION")));
        frame.add(ta);
        frame.add(ans);

    }

}
