import com.mysql.cj.jdbc.JdbcConnection;

import java.sql.*;

public class JDBC {
    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static String url="jdbc:mysql://localhost:3306/AvtoShop";
    private static String username = "root";
    private static String password="999333";
    private static int rows;
    public static void main(String[] args) {
        try {
            connectionDB();
            addDB("Chui area");
            addDB("Naryn");
            addDB("Issyk-Kul");
            addDB("Batken");
            addDB("Jalal-Abad");
            addDB("Talas");
            addDB("Osh");
            addDB("Bishkek");

            selectDB();

            updateDB("Chui",1);

            deleteFromDB(8);

            selectDB();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    connection.close();
                }
            } catch (SQLException e){
            }
            try {
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    private static void connectionDB (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private static void addDB(String region){
        try {
            statement = connection.prepareStatement("INSERT INTO Region (region) VALUES (?)");
            statement.setString(1, region);
            rows = statement.executeUpdate();
            System.out.printf("%d rows added \n", rows);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void selectDB(){
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Region");
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String region = resultSet.getString(2);
                System.out.printf("%d. %s  \n", id, region);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateDB(String region, int changeID){
        try {
            statement = connection.prepareStatement("UPDATE Region SET region = ? WHERE region_ID = ?");
            statement.setString(1, region);
            statement.setInt(2, changeID);
            rows = statement.executeUpdate();
            System.out.printf("%d rows updated \n", rows);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void deleteFromDB(int id){
        try {
            statement = connection.prepareStatement("DELETE FROM Region WHERE region_ID = ?");
            statement.setInt(1, id);
            rows = statement.executeUpdate();
            System.out.printf("%d rows deleted \n", rows);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}
