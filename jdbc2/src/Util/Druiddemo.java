package Util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;

import java.util.Properties;

public class Druiddemo {
    public static void main(String[] args) throws Exception{
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        //4.获取连接对象
        Properties prop = new Properties();
        prop.load(new FileInputStream(("src/druid.properties")));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接
        Connection collection = dataSource.getConnection();
        System.out.println(collection);
    }
}


