package service;

import dao.CommodityDao;
import dao.CommodityDaoImpl;
import dao.OrderDao;
import dao.OrderDaoImpl;
import pojo.Commodity;
import pojo.Order;

import java.util.List;
import java.util.Scanner;

public class Testmain {

    private static CommodityDao commodityDao = new CommodityDaoImpl();
    private static OrderDao orderDao = new OrderDaoImpl();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("欢迎进入商品订单管理系统");
            System.out.println("\t1.查询指定编号商品");
            System.out.println("\t2.添加商品");
            System.out.println("\t3.修改商品信息");
            System.out.println("\t4.删除商品信息");
            System.out.println("\t5.查询指定编号订单");
            System.out.println("\t6.添加订单");
            System.out.println("\t7.修改订单");
            System.out.println("\t8.删除订单");
            System.out.println("\t9.退出");
            System.out.println("-------------------------");
            System.out.println("请选择菜单：");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("请输入查询的id：");
                    int id = scanner.nextInt();
                    Commodity commodity = commodityDao.selectone(id);
                    if (commodity != null) {
                        System.out.println("查询成功");
                        System.out.println(commodity);
                    } else {
                        System.out.println("库里没有此商品");
                    }
                    break;
                case 2:
                    System.out.println("请输入商品名称");
                    String name = scanner.next();
                    System.out.println("请输入商品价格");
                    int price = scanner.nextInt();
                    Commodity com = new Commodity(name, price);
                    int insert = commodityDao.insert(com);
                    if (insert > 0) {
                        System.out.println("添加商品成功");
                    } else {
                        System.out.println("添加失败");
                    }
                    break;
                case 3:
                    System.out.println("请输入要修改的商品的id");
                    int id2 = scanner.nextInt();
                    Commodity com2 = commodityDao.selectone(id2);
                    //判断商品是否存在
                    if (com2 == null) {
                        System.out.println("商品不存在");
                        break;
                    }
                    System.out.println("修改前商品的信息" + com2);
                    System.out.println("执行修改操作");
                    System.out.println("请输入修改后商品名称");
                    String name2 = scanner.next();
                    System.out.println("请输入修改后商品价格");
                    Integer price2 = scanner.nextInt();
                    Commodity com22 = new Commodity(id2, name2, price2);
                    int update = commodityDao.update(com22);
                    if (update > 0) {
                        System.out.println("修改成功");
                    } else {
                        System.out.println("修改失败");
                    }
                    break;
                case 4:
                    System.out.println("请输入要删除的商品的id");
                    int id3 = scanner.nextInt();
                    int delete = commodityDao.delete(id3);
                    if (delete > 0) {
                        System.out.println("删除成功");
                    } else {
                        System.out.println("删除失败");
                    }
                    break;
                case 5:
                    System.out.println("请输入要查询的订单的id");
                    int id4 = scanner.nextInt();
                    Order order = orderDao.selectone(id4);
                    if (order != null) {
                        System.out.println("查询成功");
                        System.out.println(order);
                    } else {
                        System.out.println("查询失败");
                    }
                    break;

                case 6:

                    System.out.println("请输入订单商品名称");
                    String dname = scanner.next();
                    List<Commodity> list = commodityDao.selectAllName();
                    boolean hasName = false;
                    for (int i = 0; i < list.size(); i++) {
                        Commodity commodity2 = list.get(i);
                        String commodityName = commodity2.getName();
                        System.out.println(commodityName);
                        if (dname.equals(commodityName)) {
                            hasName = true;
                            System.out.println("订单合法");
                            break;
                        }
                    }
                    if (!hasName){
                        System.out.println("订单不合法");
                        break;
                    }


                    System.out.println("请输入下单时间(yyyy-MM-dd)");
                    String time = scanner.next();
                    System.out.println("请输入订单商品价格");
                    Integer dprice = scanner.nextInt();
                    Order order2 = new Order(dname, time, dprice);
                    int inserto = orderDao.insert(order2);
                    //判断商品是否存在于仓库中
                    if (inserto > 0) {
                        System.out.println("订单创建成功");
                    } else {
                        System.out.println("订单创建失败");

                    }
                    break;

                case 7:
                    System.out.println("请输入要修改的订单的id");
                    int id5 = scanner.nextInt();
                    Order order3 = orderDao.selectone(id5);
                    if (order3 == null) {
                        System.out.println("订单不存在");
                    }
                    System.out.println("修改前的订单信息" + order3);
                    System.out.println("开始执行修改操作");
                    System.out.println("请输入修改后的商品名称");
                    String dname2 = scanner.next();
                    System.out.println("请输入修改后的下单时间");
                    String time2 = scanner.next();
                    System.out.println("请输入修改后的订单价格");
                    Integer dprice2 = scanner.nextInt();
                    Order order4 = new Order(id5, dname2, time2, dprice2);
                    int update1 = orderDao.update(order4);
                    if (update1 > 0) {
                        System.out.println("修改成功");
                    } else {
                        System.out.println("修改失败");
                    }
                    break;
                case 8:
                    System.out.println("请输入要删除的订单的编号");
                    int id6 = scanner.nextInt();
                    int delete1 = orderDao.delete(id6);
                    if (delete1 > 0) {
                        System.out.println("订单删除成功");
                    } else {
                        System.out.println("订单删除失败");
                    }
                    break;

                case 9:
                    System.out.println("谢谢使用");
                    return;
                default:
                    System.out.println("输入错误");

            }


        }
    }
}
