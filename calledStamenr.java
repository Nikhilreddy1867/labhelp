import java.util.*;
import java.sql.*;
public class calledStamenr {
    public void CallableStatement(Connection conn) throws SQLException{
        CallableStatement cs=null;
        Scanner sc=new Scanner(System.in);
        int dept_no=sc.nextInt();
        try{
            cs=conn.prepareCall("{call search(?,?,?,?)}");
            cs.setInt(1,dept_no);
            cs.registerOutParameter(2,Types.DOUBLE);
            cs.registerOutParameter(3,Types.DOUBLE);
            cs.registerOutParameter(4,Types.DOUBLE);
            cs.execute();
            System.out.println("max salary:"+cs.getDouble(2));
            System.out.println("min salary:"+cs.getDouble(3));
            System.out.println("avg salary:"+cs.getDouble(4));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(cs!=null) cs.close();
        }
    }
}
