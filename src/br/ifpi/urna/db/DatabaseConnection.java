package br.ifpi.urna.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DatabaseConnection {
  private static final String DB_URL = "jdbc:sqlite:urna.db";
  private static Connection connection = null;

  public static Connection getConnection() {
    if ( connection == null ) {
      try {
        connection = DriverManager.getConnection(DB_URL);
        System.out.printf("Conectado com sucesso em: %s\n", DB_URL);
        criarTabelas();
      } catch (SQLException error) {
        System.err.println("Erro ao conectar ao banco de dados: " + error.getMessage());
      }
    }
    return connection;
  }

  public static void closeConnection() {
    if (connection != null) {
      try {
        connection.close();
        System.out.println("Conexão com o banco de dados fechada.");
      } catch (SQLException error) {
        System.out.printf("Erro ao desconectar do banco de dados: " + error.getMessage());
      } finally {
        connection = null;
      }
    }
  }

  private static void criarTabelas() {
    String sql = """
          CREATE TABLE IF NOT EXISTIS eletior (
            id INTERGER PRIMARY KEY,
            nome TEXT NOT NULL,
            idade 
          ),
        """;
  }

}
