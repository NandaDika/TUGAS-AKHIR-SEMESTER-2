import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SQLCon {
    private static final String JDB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/terbanginaja_db";
    private static final String USER  = "root";
    private static final String PASS = "";
    protected static SQLException ex_stat;

    private static Connection connect;

    private static Master master = new Master();

    protected static void connection(){
        try {
            Class.forName(JDB_DRIVER);

            connect = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Koneksi Berhasil");

        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Tidak Dapat Terhubung ke Database", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected static int loginUser(String user, String pass){
        try {
            ResultSet dataLogin1 = connect.createStatement().executeQuery("select * from user where id_user = 'admin' and password = '"+pass+"'");
            if (dataLogin1.next()){
                return 9;
            }else{
                ResultSet dataLogin = connect.createStatement().executeQuery("select * from user where id_user = '"+user+"' and password = '"+pass+"'");
                if (dataLogin.next()){
                    Boolean status = dataLogin.getBoolean("status");
                    if(status==true){
                        return 1;
                    } else {
                        return 2;
                    }
                    
                } else{
                   return 0;
                }
            }

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tidak Dapat Terhubung ke Database", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return 0;
    }

    protected static void setData(String x){
        try {
        String nama;
        TempUser.ID = master.setID();
        nama = x;
        TempUser.PASS = master.setPass();
           
           String sql2 = "INSERT INTO transaksi(id_user, nama, nik, id_maskapai, tanggal, tujuan, status) VALUES (?,?,?,?,?,?,?)";
           PreparedStatement statement2 = connect.prepareStatement(sql2);
           statement2.setString(1, TempUser.ID);
           statement2.setString(2, TempUser.nama_user);
           statement2.setInt(3, Integer.parseInt(TempUser.nik_user));
           statement2.setString(4, TempUser.maskapai);
           statement2.setString(5, TempUser.tanggal);
           statement2.setString(6, TempUser.kota);
           statement2.setString(7, "TERDAFTAR");
           int numRowsAffected2 = statement2.executeUpdate();

            if(numRowsAffected2>0){
                String sql1 = "INSERT INTO user(id_user, password, nama, status) VALUES (?, ?, ?, ?)";
           PreparedStatement statement1 = connect.prepareStatement(sql1);
           statement1.setString(1, TempUser.ID);
           statement1.setString(2, TempUser.PASS);
           statement1.setString(3, TempUser.nama_user);
           statement1.setInt(4, 1);
           int numRowsAffected = statement1.executeUpdate();
            }
            
            
        } catch(SQLException ex){
            if(ex.getSQLState().equals("45000")) {
                
                ex_stat = ex;
               }
        }catch (Exception e) {
            System.out.println(e);
        } 
    }

    protected static void getData(){
        try {
            ResultSet dataSet = connect.createStatement().executeQuery("select * from transaksi where id_user='"+master.getID()+"'");
            if(dataSet.next()){
            Master.dataTemp[0] = dataSet.getString("id_user");
            Master.dataTemp[1] = dataSet.getString("nama");
            Master.dataTemp[2] = dataSet.getString("id_maskapai");
            Master.dataTemp[3] = dataSet.getString("tanggal");
            Master.dataTemp[4] = dataSet.getString("tujuan");
            

            System.out.println(dataSet.getString("id_user"));
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    protected static void setCekin(){
        try {
            connect.createStatement().executeUpdate("update user set status = 0 where id_user='"+master.getID()+"'");
            connect.createStatement().executeUpdate("UPDATE transaksi SET STATUS = 'DIBATALKAN' WHERE id_user = '"+master.getID()+"'");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected static void setCekin2(){
        try {
            connect.createStatement().executeUpdate("update user set status = 0 where id_user='"+master.getID()+"'");
            connect.createStatement().executeUpdate("UPDATE transaksi SET STATUS = 'SELESAI' WHERE id_user = '"+master.getID()+"'");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected static void setTable(DefaultTableModel x){
        try {
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM transaksi");

            // Add rows to the table model
            while (rs.next()) {
                x.addRow(new Object[]{rs.getString("id_user"), rs.getString("nama"), rs.getInt("nik"), rs.getString("tujuan"), rs.getString("id_maskapai"), rs.getString("status")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected static void updateAdmin(String x){
        try {
            connect.createStatement().executeUpdate("update user set password = '"+x+"' where id_user='admin'");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
