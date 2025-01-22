package Util;

import java.sql.*;

//工具类
public class JdbcUtil {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql:///ordermanagement?useSSL=false&useServerPrepStmts=true";
    private static Connection conn = null;
    private static String username = null;
    private static String password = null;
    private static PreparedStatement pstat = null;

    private static ResultSet rs = null;

    //专门用来获取连接
    public static Connection getConn(){
        try {
            //注册驱动
            Class.forName(driver);
            conn = DriverManager.getConnection(url,"root","123456");
            return conn;
        } catch (Exception e) {
           e.printStackTrace();
        }
        return conn;

    }

    //增添修改删除
    public static int exeUpdate(String sql ,Object[] params){
        try {
            conn = getConn();
            pstat =conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstat.setObject(i + 1,params[i]);
            }
          return pstat.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //释放资源
    public static void release(Connection conn, PreparedStatement ps, ResultSet rs) {
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }




}
