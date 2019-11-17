/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baymax2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author USCHAS
 */
public class datrabase {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/patientinfo", "root", "1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public int save_patient_info(String Firstname, String Lastname, String Mobile, String Sex, String age, String height, String weight, String username, String password) {
        int cnt = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://@localhost:3306/patientinfo", "root", "1234");
            Statement st = conn.createStatement();


            String str;
            str = "Insert into patient values(" + "'" + Firstname + "'," + "'" + Lastname + "'," + "'" + Mobile + "'," + "'" + Sex + "'," + age + "," + height + "," + weight + ",'" + username + "','" + password + "')";
            st.executeUpdate(str);
            st.executeUpdate("commit");

        } catch (Exception sqle) {
            cnt = 1;
            System.out.println("SQL Exception 1: " + sqle);
        }
        return cnt;
    }

    public int check_info(String username, String password) {
        int cnt = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://@localhost:3306/patientinfo", "root", "1234");
            Statement st = conn.createStatement();


            String str, pass;
            //st.executeUpdate(str);
            str = "select * from patient where userid='" + username + "'";
            ResultSet rs = st.executeQuery(str);
            while (rs.next()) {
                pass = rs.getString(9);
                if (pass.equals(password)) cnt = 1;

            }

        } catch (Exception sqle) {

            System.out.println("SQL Exception 1: " + sqle);
        }
        return cnt;
    }

    public ArrayList<String> doc_load() {
        ArrayList<String> doc = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://@localhost:3306/patientinfo", "root", "1234");
            Statement st = conn.createStatement();


            String str, s;

            str = "select * from doctor";
            System.out.println("hudi");
            ResultSet rs = st.executeQuery(str);
            while (rs.next()) {
                s = rs.getString(1);
                doc.add(s);
                System.out.println(s);
                System.out.println("XD na");


            }

        } catch (Exception sqle) {

            System.out.println("SQL Exception 1: " + sqle);
        }
        return doc;
    }

    public String get_patient_name(String userid) {
        String ret;
        ret = "null";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://@localhost:3306/patientinfo", "root", "1234");
            Statement st = conn.createStatement();


            String s1, s2, str;
            //st.executeUpdate(str);
            str = "select * from patient where userid='" + userid + "'";
            ResultSet rs = st.executeQuery(str);
            while (rs.next()) {
                s1 = rs.getString(1);
                s2 = rs.getString(2);
                ret = s1 + s2;

            }

        } catch (Exception sqle) {

            System.out.println("SQL Exception 1: " + sqle);
        }
        return ret;
    }

    public int save_patient_doc(String patient, String doc, String dt) {
        int cnt = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://@localhost:3306/patientinfo", "root", "1234");
            Statement st = conn.createStatement();


            String str;
            str = "Insert into meet_patient_doctor values" + "('" + patient + "','" + doc + "','" + dt + "')";
            st.executeUpdate(str);
            st.executeUpdate("commit");
        } catch (Exception sqle) {
            cnt = 1;
            System.out.println("SQL Exception 1: " + sqle);
        }
        return cnt;
    }


    public ArrayList<String> meet_patient() {
        ArrayList<String> patient = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://@localhost:3306/patientinfo", "root", "1234");
            Statement st = conn.createStatement();


            String str, s;

            str = "select * from meet_patient_doctor";
            System.out.println("hudi");
            ResultSet rs = st.executeQuery(str);
            while (rs.next()) {
                s = rs.getString(1);
                patient.add(s);
                System.out.println(s);
                System.out.println("XD na");


            }

        } catch (Exception sqle) {

            System.out.println("SQL Exception 1: " + sqle);
        }
        return patient;
    }

    public ArrayList<String> meet_doc() {
        ArrayList<String> doc = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://@localhost:3306/patientinfo", "root", "1234");
            Statement st = conn.createStatement();


            String str, s;

            str = "select * from meet_patient_doctor";
            System.out.println("hudi");
            ResultSet rs = st.executeQuery(str);
            while (rs.next()) {
                s = rs.getString(2);
                doc.add(s);
                System.out.println(s);
                System.out.println("XD na");


            }

        } catch (Exception sqle) {

            System.out.println("SQL Exception 1: " + sqle);
        }
        return doc;
    }

    public ArrayList<String> meet_date() {
        ArrayList<String> dt = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://@localhost:3306/patientinfo", "root", "1234");
            Statement st = conn.createStatement();


            String str, s;

            str = "select * from meet_patient_doctor";
            System.out.println("hudi");
            ResultSet rs = st.executeQuery(str);
            while (rs.next()) {
                s = rs.getString(3);
                dt.add(s);
                System.out.println(s);
                System.out.println("XD na");


            }

        } catch (Exception sqle) {

            System.out.println("SQL Exception 1: " + sqle);
        }
        return dt;
    }


}
