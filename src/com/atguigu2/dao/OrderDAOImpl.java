package com.atguigu2.dao;

import com.atguigu2.bean.Order;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class OrderDAOImpl extends BaseDAO implements OrderDAO {

    @Override
    public void insert(Connection conn, Order order) {
//        String sql = "insert into order(order_name, order_date) values(?,?)";
        String sql = "insert into `order`(order_name,order_date)values(?,?)";
        update(conn, sql, order.getOrderName(), order.getOrderDate());
    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from `order` where order_id = ?";
        update(conn, sql, id);
    }

    @Override
    public void update(Connection conn, Order order) {
        String sql = "update `order` set order_name = ?, order_date = ? where order_id = ?";
        update(conn, sql, order.getOrderName(), order.getOrderDate(), order.getOrderId());
    }

    @Override
    public Order getOrderById(Connection conn, int id) {
        String sql = "select order_id orderId, order_name as orderName, order_date as orderDate from `order` where order_id = ?";
        Order ord = getInstance(conn, Order.class, sql, id);
        return ord;
    }

    @Override
    public List<Order> getAll(Connection conn) {
        String sql = "select order_name as orderName, order_date as orderDate from `order`";
        List<Order> res = getForList(conn, Order.class, sql);
        return res;
    }

    @Override
    public Long getCount(Connection conn) {

        String sql = "select count(order_id) from `order`";
        Long count = getValue(conn, sql);
        return count;
    }

    @Override
    public Date getMaxBirth(Connection conn) {
        String sql = "select max(order_date) from `order`";

        return getValue(conn, sql);
    }
}
