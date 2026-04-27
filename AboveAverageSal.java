import java.util.*;
import java.sql.*;
public class AboveAverageSal {
    public void fetchAboveAverageEmployees(Connection conn)throws SQLException {
        ResultSet rs=null;
        Statement stmt=null;
        String query="select empno,ename,sal from emp where sal>(select avg(sal) from emp)"
        try{
            //Fetch the record and then print them like as follows:
            stmt=conn.createStatemnt();
            rs=stmt.executeQuery(query);
            System.out.println("EMPNO | ENAME | SAL");
            System.out.println("---------------------------------------------------------");
            // print the records from here 
            while(rs.next()){
                System.out.printf(%d,%s,%2.f/d,rs.getInt("empno"),rs.getString("empname"),rs.getDouble("empsal"));
            }
        }
        finally(){
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
        }

    }
}