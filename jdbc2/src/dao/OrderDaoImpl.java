package dao;

import Util.JdbcUtil;
import pojo.Commodity;
import pojo.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao{


    @Override
    public Order selectone(Integer id) throws SQLException {
        Connection conn = JdbcUtil.getConn();
        conn.setAutoCommit(false);
        Order order = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("select id,name,time,price from orderform where id = ?");
        ps.setInt(1,id);
        rs = ps.executeQuery();
        while(rs.next()){
            int id1 = rs.getInt(1);
            String name = rs.getString(2);
            String time = rs.getString(3);
            int price = rs.getInt(4);
            order = new Order(id1,name,time,price);
            }
            conn.commit();
        }catch (SQLException e) {
            conn.rollback();
            throw new RuntimeException(e);
        }finally {
            JdbcUtil.release(conn,ps,rs);
        }

        return order;

    }

    @Override
    public int insert(Order order) {
        String sql  ="insert into orderform values(default,?,?,?)";
        Object[] params = {order.getName() ,order.getTime(), order.getPrice()};
        int update = JdbcUtil.exeUpdate(sql,params);
        return update;
    }

    @Override
    public int update(Order order) {
        String sql  ="update orderform set name =? ,time = ? ,price = ? where id = ?";
        Object[] params = {order.getName() ,order.getTime(), order.getPrice(),order.getId()};
        int update = JdbcUtil.exeUpdate(sql,params);
        return update;
    }

    @Override
    public int delete(Integer id) {
        String sql ="delete from orderform where id = ?";
        Object[] params = {id};
        int update = JdbcUtil.exeUpdate(sql, params);
        return update;
    }
}
