package dao;

import pojo.Commodity;

import java.sql.SQLException;
import java.util.List;

public interface CommodityDao {





    List<Commodity> selectAllName() throws SQLException;


    /**
     * 查询单个商品
     * @param id
     * @return commodity
     * @throws SQLException
     */
    Commodity selectone(Integer id) throws SQLException;


    /**
     * 增添商品
     * @param commodity
     * @return int
     */
    int insert(Commodity commodity);


    /**
     * 修改商品
     * @param commodity
     * @return int
     */
    int update(Commodity commodity);



    int delete(Integer id);





}
