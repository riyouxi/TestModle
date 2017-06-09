package modle.test.com.orderlibrary.interfaces;


import java.util.ArrayList;

import modle.test.com.baselibrary.mvp.BasePresenter;
import modle.test.com.orderlibrary.datas.Order;

/**
 * Created by su on 2016/6/25.
 */
public interface OperationPresenter extends BasePresenter {

    void addOrder();

    void deleteOrder(int index);

    int getOrderCount();

    ArrayList<Order> getOrderList();
}
