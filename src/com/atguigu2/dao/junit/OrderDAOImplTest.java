package com.atguigu2.dao.junit;

import com.atguigu1.util.JDBCUtils;
import com.atguigu2.bean.Customer;
import com.atguigu2.bean.Order;
import com.atguigu2.dao.OrderDAOImpl;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class OrderDAOImplTest {

    private OrderDAOImpl odi = new OrderDAOImpl();

    @Test
    public void testInsert() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Order order = new Order(3, "CC", new Date(453465656L));
            odi.insert(conn, order);
            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.closeResource(conn, null);

        }

    }

    @Test
    public void testDeleteById() {
        Connection conn = null;
        try{
            conn = JDBCUtils.getConnection();
            int id = 1;
            odi.deleteById(conn, id);
            System.out.println("删除成功");
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    @Test
    public void testUpdateConnectionOrder() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Order order = new Order(2, "EE", new Date(1234567L));
            odi.update(conn, order);
            System.out.println("更新成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);

        }

    }

    @Test
    public void testGetOrderById() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Order order = odi.getOrderById(conn, 4);
            System.out.println(order);

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.closeResource(conn, null);

        }
    }

    @Test
    public void testGetAll() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            List<Order> list = odi.getAll(conn);
            for (Order o : list){
                System.out.println(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);

        }
    }

    @Test
    public void testGetCount() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();

            Long count = odi.getCount(conn);

            System.out.println("表中的记录数为：" + count);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.closeResource(conn, null);

        }
    }

    @Test
    public void testGetMaxBirth() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            Date date = odi.getMaxBirth(conn);
            System.out.println(date);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }
}
