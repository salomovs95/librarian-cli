package com.salomovs.librarian;

import java.sql.Connection;
import com.salomovs.librarian.db.Connector;

public class Librarian {
  public static void main(String...args) throws Exception {
    Connector db =  new Connector();
    try (Connection con = db.connect()) {
      db.loadTables(con);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
