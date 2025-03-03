package com.salomovs.librarian.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
  private final String DB_URL="jdbc:mysql://localhost:3306/librarian?user=librarian&password=librarian@123";
  public Connector() { }

  public Connection connect() throws Exception {
    return DriverManager.getConnection(this.DB_URL);
  }

  public void loadTables(Connection conn) throws Exception {
    String CREATE_BOOK_TBL_STMT = ""+
      "CREATE TABLE IF NOT EXISTS books ("+
      "id INT PRIMARY KEY AUTOINCREMENT," +
      "title VARCHAR(255) NOT NULL," +
      "author_id VARCHAR(255) UNIQUE NOT NULL," +
      "isbn VARCHAR(255) NOT NULL," +
      "page_count INT NOT NULL," +
      "created_at DATE NOT NULL DEFAULT NOW," +
      "updated_at DATE DEFAULT NULL," +
      "is_available BOOLEAN DEFAULT false)";

    String CREATE_AUTHOR_TBL_STMT = "" +
      "CREATE TABLE IF NOT EXISTS authors (" +
      "id INT PRIMARY KEY AUTOINCREMENT," +
      "name VARCHAR(255) NOT NULL," +
      "birth_date DATE NOT NULL)";

    String CREATE_BOOK_BORROW_TABLE_STMT = "" +
      "CREATE TABLE IF NOT EXISTS book_borrows (" +
      "id INT PRIMARY KEY AUTOINCREMENT," +
      "username VARCHAR NOT NULL," +
      "book_id INT NOT NULL," +
      "borrowed_at DATE NOT NULL DEFAULT NOW," +
      "returned_at DATE DEFAULT NULL" +
      ")";

    conn.createStatement().execute(CREATE_AUTHOR_TBL_STMT);
    conn.createStatement().execute(CREATE_BOOK_TBL_STMT);
    conn.createStatement().execute(CREATE_BOOK_BORROW_TABLE_STMT);
  }
}
