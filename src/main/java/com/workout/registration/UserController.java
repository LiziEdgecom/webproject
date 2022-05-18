package com.workout.registration;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static java.lang.Integer.valueOf;

public class UserController {
    private static PreparedStatement ps;
    private static String sqlQuery;
    private static String sqlPrikazt;
    private static Connection con;

    public int insertUser(User user){
        String sql = "INSERT INTO user ( name, password, email, weight, height) VALUES (?,?,?,?,?)";

        try (
                Connection con = DatabaseConnector.getCon();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, user.getName());
            ps.setString(2, encrypt(user.getPassword()));
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getWeight());
            ps.setString(5, user.getHeight());

            return ps.executeUpdate();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException  e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static String encrypt(String data) {
        Base64.Encoder encoder = Base64.getEncoder();
        String originalString = data;
        String encodedString = encoder.encodeToString(originalString.getBytes());
        return encodedString;
    }



    public static boolean isUserInDatabase(String email) throws SQLException, NamingException {
        boolean isInDatabase = false;
        Connection conn = null;
        try {
            conn = DatabaseConnector.getCon();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        sqlQuery = "SELECT * from user";

        try {
            ps = conn.prepareStatement(sqlQuery);
            ResultSet rs = ps.executeQuery(sqlQuery);

            while(rs.next()){
                String nameP = rs.getString("email");
                if(rs.getString("email").equals(email)){

                    return true;
                }else {
                    isInDatabase = false;
                }
            }

            //return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return isInDatabase;
    }



    private static ResultSet getResultSet() {
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sqlQuery);
            rs = ps.executeQuery(sqlQuery);
            Statement statement = (Statement) con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /*public int deleteUser(String nickname) throws NamingException {

        sqlQuery = "DELETE FROM users WHERE NicknameDB = "+"'" + nickname + "'";

        try (
                //Connection con = DatabaseConnector.getCon();
                //PreparedStatement ps = con.prepareStatement(sqlQuery);
        ){
            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }*/

    public int deleteUserIndex(String nickname) throws NamingException {

        sqlQuery = "DELETE FROM usersindex WHERE NicknameUI = " + "'" + nickname + "'";

        try (
                Connection con = DatabaseConnector.getCon();
                PreparedStatement ps = con.prepareStatement(sqlQuery);
        ){
            return ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int UploadUser(String nickname,String email,String weight,String height) throws NamingException {

        sqlQuery = "UPDATE user SET name = " + "'" + nickname + "', weight = " + "'" + weight + "',height = " + "'" + height + "' WHERE email = " + "'" + email + "' ";

        try (
                Connection con = DatabaseConnector.getCon();
                PreparedStatement ps = con.prepareStatement(sqlQuery);
        ){
            return ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static ArrayList getUser(String emailAtt) throws SQLException, NamingException, ClassNotFoundException {
        ArrayList dataList = new ArrayList();
        Connection conn = DatabaseConnector.getCon();
        sqlQuery = "SELECT * from user WHERE email = "+"'" + emailAtt + "'";
        System.out.println("selectujem" );
        try {
            Statement s = conn.createStatement();
            s.executeQuery(sqlQuery);

            ResultSet rs = s.getResultSet();
            if(rs.next()) {
                dataList.add(rs.getString("name"));
                dataList.add(rs.getString("weight"));
                dataList.add(rs.getString("height"));

                return dataList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
