import java.util.*;
import java.sql.*;
public class newyork {
    public void search(Connection conn) throws SQLException{
        Statement stmt=null;
        ResultSet rs=null;
        String query"select Employee.ename,Employee.eno from Employee join Department on Employee.deptid=Department.deptid where Departmnet.deptloaction="new York";
        try{
            stmt=conn.createStatement();
            rs=stmt.executeQuery(query);
            System.out.println("EMP NAME || EMP NO");
            System.out.println("--------------------");
            while(rs.next()){
                System.out.printf("%d | %s/n",rs.getString("empname"),rs.getInt("empname"));
            }
        }
        finally{
            if(rs!=null) rs.close();
            if(stmt!=null) rs.close();
        }
    }
}
