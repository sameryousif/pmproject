import java.sql.*;
import javax.swing.JOptionPane;

public class connnection {
  Connection con;
  Statement stm;
  int u = 0;

  public connnection() {
    try {
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/pm",
          "root",
          "112002");
      stm = con.createStatement();
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(
          null,
          e.getMessage(),
          "error",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  public ResultSet execute(String sql) {
    try {
      return stm.executeQuery(sql);
    } catch (SQLException e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          null,
          e.getMessage(),
          "error in the querying procedure",
          JOptionPane.ERROR_MESSAGE);
      return null;
    }
  }

  public void update(String sql) throws SQLException {
    try {
      stm.executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(
          null,
          e.getMessage(),
          "error in the update procedure",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  public boolean checkUser(String name, String password) {
    String sql = "select * from users where name = '" +
        name +
        "' and password = " +
        password +
        ";";
    System.out.println(sql);
    connnection co = new connnection();
    ResultSet rs = co.execute(sql);
    try {
      if (rs.next()) {
        return true;
      }
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(
          null,
          e.getMessage(),
          "error",
          JOptionPane.ERROR_MESSAGE);
    }
    return false;
  }

  public boolean checkUser(String name) {
    String sql = "select * from users where name = '" + name + "' ;";
    System.out.println(sql);
    connnection co = new connnection();
    ResultSet rs = co.execute(sql);
    try {
      if (rs.next()) {
        return true;
      }
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(
          null,
          e.getMessage(),
          "error",
          JOptionPane.ERROR_MESSAGE);
    }
    return false;
  }

  public void addUser(
      String name,
      String password,
      String phone,
      String email,
      Object day,
      Object month,
      Object year) {
    if (!checkUser(name, password)) {
      String dt = day.toString() + "/" + month.toString() + "/" + year.toString();
      System.out.println(dt);
      String sql = "insert into users(name,password,phone,email,age) values('" +
          name +
          "','" +
          password +
          "','" +
          phone +
          "','" +
          email +
          "','" +
          dt +
          "');";

      try {
        update(sql);
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            null,
            e.getMessage(),
            "error",
            JOptionPane.ERROR_MESSAGE);
      }
    } else {
    }
  }

  public void delete(String name) {
    String sql = "delete from users where name='" + name + "';";
    try {
      update(sql);
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(
          null,
          e.getMessage(),
          "error",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  // all about drugs from now on (:

  public boolean checkdrug(String searchKey) {
    String sql = " select * from drugs where name like '%" + searchKey + "%';";
    System.out.println(sql);
    connnection co = new connnection();
    ResultSet rs = co.execute(sql);
    try {
      if (rs.next()) {
        return true;
      }
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(
          null,
          e.getMessage(),
          "error",
          JOptionPane.ERROR_MESSAGE);
    }
    return false;
  }

  public ResultSet retriveDrug(String searchKey) {
    if (checkdrug(searchKey)) {
      String sql = " select * from drugs where name like '%" + searchKey + "%';";
      return execute(sql);
    }
    return null;
  }

  public void addDrug(String medname, String disease, String price, String expdate, String quantity) {
    String sql = "insert into drugs (name, disease, price, date, QTY) values ('" + medname + "', '" + disease
        + "', '" + price + "' , '" + expdate + "'," + quantity + ");";
    System.out.println(sql);

    try {
      update(sql);
      JOptionPane.showConfirmDialog(null, "successfully inserted", "Done", JOptionPane.PLAIN_MESSAGE);
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
    }
  }

  public void deleteDrug(String name) {
    if (checkdrug(name)) {
      String sql = "delete from drugs where name like '%" + name + "%';";
      try {
        update(sql);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public void changeDrug(String name, String medName, String disease, String expdate, String quantity, String price) {
    if (checkdrug(name)) {

      if (u < 1) {

        String sql = "update drugs set name ='" + medName + "' , date = '" + expdate + "',disease='" + disease
            + "',QTY='"
            + quantity + "',price='" + price + "' where name like '%" + name + "%';";
        System.out.println(sql);
        try {
          update(sql);
          u++;
          JOptionPane.showConfirmDialog(null, "successfully changed", "Done", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    }
  }

  public void decreas(String na, int quantity) {
    int dq = quantity;
    String sql = "update drugs set QTY=QTY-" + dq + " where name like '%" + na + "%';";
    System.out.println(sql);
    try {
      update(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void increase(String name, int quantity) {
    String sql = "update drugs set QTY=QTY+" + quantity + " where name like '%" + name + "%';";
    System.out.println(sql);
    try {
      update(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public ResultSet returnDrugsTable() {
    String sql = "select * from drugs;";
    ResultSet rs = execute(sql);
    return rs;
  }

  public void log(String na, String date, int price, String qu) {
    String sql = "insert into logs (name, date,QTY,price) values ('" + na + "', '" + date + "', '" + qu + "', '" + price
        + "');";
    System.out.println(sql);
    try {
      update(sql);
    } catch (SQLException e) {

    }
  }

  public int getlength(String table) {
    String sql = "select count(*) from " + table + ";";
    ResultSet rs = execute(sql);
    int result = 0;
    try {
      while (rs.next()) {
        result = rs.getInt(1);
      }

      rs.next();
    } catch (SQLException e) {

      JOptionPane.showMessageDialog(null, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);

    }
    return result;
  }

  public ResultSet returnLogs() {
    String sql = "select * from logs;";
    ResultSet rs = execute(sql);
    return rs;
  }
}
/*
 * my beautifull to do list :
 * 1- decrease the the quantity when selling
 * 2- the return page
 * 3- the inventory page
 */