package dao;

import pojo.Commodity;
import pojo.Order;

import java.sql.SQLException;

public interface OrderDao {
    /**
     * 查询单个订单
     * @param id
     * @return order
     * @throws SQLException
     */
    Order selectone(Integer id) throws SQLException;
    /**
     * 增添订单
     * @param order
     * @return int
     */
    int insert(Order order);

    /**
     *
     */

    int update(Order order);

    int delete(Integer id);

}
