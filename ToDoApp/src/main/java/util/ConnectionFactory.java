/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author bruno
 */
public class ConnectionFactory {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/todoApp";
    public static final String USER = "root";
    public static final String PASS = "";

    public static Connection getConnection() {
        try { //tray e catch serve para pegar poss�veis erros que podem acontecer e trata-los.
            //Dentro do tray n�s colocamos o c�digo que pode dar erro e no bloco do catch executa uma acao pra
            //reparar o erro
            Class.forName(DRIVER); //serve para carregar o driver pra dentro da aplicacao
            return DriverManager.getConnection(URL, USER, PASS);//DriverManager � uma classe do conjunto de depend�ncias que baixamos e que nessa classe tem o m�todo getConnection que preciso informar tr�s par�metros. Ele tamb�m � um m�todo est�tico, pois n�o precisar criar um objeto da classe DriverManager pra poder utilizar o getConnection dela.
        } catch (Exception ex) {
            throw new RuntimeException("Erro na conex�o com o BD", ex);
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar o BD", ex);
        }
    }

    //podemos ter v�rios m�todos com o mesmo estado, nome, retorno por�m com par�metros diferentes
    //nesse caso, al�m de fechar a conexao eu tamb�m fecho o statement
    public static void closeConnection(Connection connection, java.sql.PreparedStatement statement) {
        try {
            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar o BD", ex);
        }
    }
    
    public static void closeConnection(Connection connection, java.sql.PreparedStatement statemente, java.sql.ResultSet resultSet){
        try {
            if (connection != null){
                connection.close();
            }
            if (statemente != null){
                statemente.close();
            }
            if (resultSet != null){
                resultSet.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao buscar informa��es" + ex.getMessage(), ex);
        }
    }

}
