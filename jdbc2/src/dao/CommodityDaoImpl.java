package dao;

import Util.JdbcUtil;
import pojo.Commodity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommodityDaoImpl implements CommodityDao{


    @Override
    public List<Commodity> selectAllName() throws SQLException {
        Connection conn = JdbcUtil.getConn();
        //事务管理
        conn.setAutoCommit(false);
       List<Commodity>  list =new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("select name from commodity");
            rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString(1);
                Commodity commodity = new Commodity(name);
                list.add(commodity);


            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw new RuntimeException(e);
        }finally {
            JdbcUtil.release(conn,ps,rs);
        }

        return list;

    }

    @Override
    public Commodity selectone(Integer id) throws SQLException {
        Connection conn = JdbcUtil.getConn();
        conn.setAutoCommit(false);
        Commodity commodity = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
             ps = conn.prepareStatement("select id, name,price from commodity where id=?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                int id1 = rs.getInt(1);
                String name = rs.getString(2);
                int price = rs.getInt(3);

                commodity = new Commodity(id1, name, price);


            }
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw new RuntimeException(e);
        }finally {
            JdbcUtil.release(conn,ps,rs);
        }

        return commodity;
    }

    @Override
    //增添
    public int insert(Commodity commodity) {
        String sql = "insert into commodity values(default,?,?) ";
        Object[] params = {commodity.getName() , commodity.getPrice()};
        int update = JdbcUtil.exeUpdate(sql,params);
        return update;
    }

    @Override
    //修改
    public int update(Commodity commodity) {
        String sql = "update commodity set name =? ,price = ? where id = ? ";
        Object[] params =  {commodity.getName() , commodity.getPrice() , commodity.getId()};
        int update = JdbcUtil.exeUpdate(sql , params);
        return update;
    }

    @Override
    public int delete(Integer id) {
        String sql ="delete from commodity where id = ?";
        Object[] params = {id};
        int update = JdbcUtil.exeUpdate(sql, params);
        return update;
    }
}
