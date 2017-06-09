package modle.test.com.orderlibrary.interfaces;


import modle.test.com.baselibrary.mvp.BaseView;

/**
 * Created by su on 2016/6/25.
 */
public interface OrderOperationView extends BaseView<OperationPresenter> {

    void showNoData();

    void showCountChanged();

    void hasData();

}
