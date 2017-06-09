package modle.test.com.orderlibrary;


import java.util.ArrayList;

import modle.test.com.orderlibrary.datas.Order;
import modle.test.com.orderlibrary.datas.OrderDatas;
import modle.test.com.orderlibrary.interfaces.OperationPresenter;
import modle.test.com.orderlibrary.interfaces.OrderOperationView;

/**
 * Created by su on 2016/6/27.
 */
public class OrderPresenter implements OperationPresenter {

    private OrderDatas orderDatas = new OrderDatas();
    private OrderOperationView orderOperationView;

    public OrderPresenter(OrderOperationView orderOperationView) {
        this.orderOperationView = orderOperationView;
    }

    @Override
    public void addOrder() {
        Order order = new Order();
        order.setName("order");
        order.setPrice(1515);
        orderDatas.addOrder(order);
        orderOperationView.showCountChanged();
        if (orderDatas.getOrderCount() > 0) {
            orderOperationView.hasData();
        }
    }

    @Override
    public void deleteOrder(int index) {
        orderDatas.deleteOrder(index);
        orderOperationView.showCountChanged();
        if (orderDatas.getOrderCount() <= 0) {
            orderOperationView.showNoData();
        }
    }

    @Override
    public int getOrderCount() {
        return orderDatas.getOrderCount();
    }

    @Override
    public ArrayList<Order> getOrderList() {
        return orderDatas.getOrderList();
    }

    @Override
    public void start() {

    }
}
