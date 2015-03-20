package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:XE", "quiz_master", "password");
        PreparedStatement statement = connection.prepareStatement("Select * from QUESTIONS");
        ResultSet result = statement.executeQuery();
        while (result.next()){
            System.out.println("id = "+result.getInt("ID"));
            System.out.println("question = "+result.getString("QUESTION"));
        }
        Frames f = new Frames();
        f.setProperty();
        f.showQuestionOnFrame();
        Frames.createDBConnection();
    }
}
