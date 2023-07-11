package resources;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    public Connection connect_to_db(String databaseName, String user, String password) {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + databaseName, user, password);
            if (connection != null) {
                System.out.println("Connection Established.");
            } else {
                System.out.println("Connection Failed.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    public void insertEmployee(Connection connection, String username, String password) {
        Statement statement;
        try {
            String query = String.format("insert into employee(username,password) values('%s','%s');", username, password);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertProduct(Connection connection, String productName, double productPrice, int productQuantity, String productLocation, String productType) {
        Statement statement;
        try {
            String query = String.format("insert into product(product_name, product_price, product_quantity, product_location, product_type) values('%s','%s','%s', '%s', '%s');", productName, productPrice, productQuantity, productLocation, productType);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public String[][] readProduct(Connection connection, String column1, String column2, String column3, String column4, String column5, String column6) {
        Statement statement;
        ResultSet resultSets = null;
        try {
            String query = String.format("SELECT %s, %s, %s, %s, %s, %s FROM product", column1, column2, column3, column4, column5, column6);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSets = statement.executeQuery(query);

            // Determinar o número de linhas no resultado do banco de dados
            int rowCount = 0;
            if (resultSets.last()) {
                rowCount = resultSets.getRow();
                resultSets.beforeFirst(); // Voltar para a posição inicial
            }

            // Criar a matriz products com tamanho adequado
            String[][] data = new String[rowCount][6];

            // Preencher a matriz com os valores do banco de dados
            int rowIndex = 0;
            while (resultSets.next()) {
                String value1 = resultSets.getString(column1);
                String value2 = resultSets.getString(column2);
                String value3 = resultSets.getString(column3);
                String value4 = resultSets.getString(column4);
                String value5 = resultSets.getString(column5);
                String value6 = resultSets.getString(column6);

                data[rowIndex][0] = value1;
                data[rowIndex][1] = value2;
                data[rowIndex][2] = value3;
                data[rowIndex][3] = value4;
                data[rowIndex][4] = value5;
                data[rowIndex][5] = value6;

                rowIndex++;
            }

            return data;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void deleteProduct(Connection connection, int id) {
        Statement statement;
        try {
            String query = String.format("delete from product where product_id = %s", id);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Deleted");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public String[][] searchProductID(Connection connection, String column1, String column2, String column3, String column4, String column5, String column6, int id) {
        Statement statement;
        ResultSet resultSets = null;
        try {
            String query = String.format("SELECT %s, %s, %s, %s, %s, %s FROM product where product_id = %s", column1, column2, column3, column4, column5, column6, id);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSets = statement.executeQuery(query);

            // Determinar o número de linhas no resultado do banco de dados
            int rowCount = 0;
            if (resultSets.last()) {
                rowCount = resultSets.getRow();
                resultSets.beforeFirst(); // Voltar para a posição inicial
            }

            // Criar a matriz products com tamanho adequado
            String[][] data = new String[rowCount][6];

            // Preencher a matriz com os valores do banco de dados
            int rowIndex = 0;
            while (resultSets.next()) {
                String value1 = resultSets.getString(column1);
                String value2 = resultSets.getString(column2);
                String value3 = resultSets.getString(column3);
                String value4 = resultSets.getString(column4);
                String value5 = resultSets.getString(column5);
                String value6 = resultSets.getString(column6);

                data[rowIndex][0] = value1;
                data[rowIndex][1] = value2;
                data[rowIndex][2] = value3;
                data[rowIndex][3] = value4;
                data[rowIndex][4] = value5;
                data[rowIndex][5] = value6;

                rowIndex++;
            }

            return data;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String productUpdate(Connection connection, String field, String parameter, int id){
        Statement statement;
        try {
            String query = String.format("UPDATE product SET %s = '%s' WHERE product_id = %d", field, parameter, id);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Updated");
        } catch (Exception e) {
            System.out.println(e);
        }

        return "funcionou";
    }

    public boolean loginValidation(Connection connection, String username, String password){
        Statement statement;
        ResultSet resultSet;
        boolean isValid = false;
        try {
            String query = String.format("select * from employee where username = '%s' and password = '%s'", username, password);
            System.out.println(username + " " + password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet.next()){
                isValid = true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return isValid;
    }

}