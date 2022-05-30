import java.sql.*;
public class JdbcInsertTest {
    public static void main(String[] args) {
        try
                (
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ebookshop","root",""
            );
            Statement stmt = conn.createStatement();
        )
        {
            String sqlDelete = "delete from books where id>=3000 or id<4000";
            System.out.println("The Sql statement is: "+sqlDelete+"\n");
            int countDelete = stmt.executeUpdate(sqlDelete);
            System.out.println(countDelete+" records delete.\n");

            String sqlInsert  = "insert into books values(3001,'Gone fishing',11.11,11)";
            System.out.println("The sql statement is : "+sqlInsert +"\n");
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted +" records inserted.\n");

            sqlInsert  = "insert into book values"
                    +"(3002,'Gone fishing 2',22.22,22,"
                    +"(3003,'Gone fishing 3',33.33,33";
            System.out.println("The statement is: "+sqlInsert +"\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted +" records inserted.\n");

            sqlInsert = "insert into books(id,title,author) values (3004,'fishing 101','Kumar')";
            System.out.println("The sql statement is: "+sqlInsert+"\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted +" records inserted.\n");

            String strselect = "select * from books";
            System.out.println("The sql statement is: "+strselect +"\n");
            ResultSet rset = stmt.executeQuery(strselect);
            while(rset.next())
            {
                System.out.println(rset.getInt("id") + ", "
                + rset.getString("author") +", "
                + rset.getString("title")  +", "
                +rset.getDouble("price")   +", "
                +rset.getInt("qty")  +", "
                );
            }

        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }

    }
}
