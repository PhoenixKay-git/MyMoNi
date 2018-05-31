package com.bwie.test.model;

import com.bwie.test.bean.AddBean;
import com.bwie.test.bean.CartsBean;
import com.bwie.test.bean.DeleteBean;
import com.bwie.test.bean.DinganBean;
import com.bwie.test.bean.ProductsBean;
import com.bwie.test.bean.ShowsBean;
import com.bwie.test.inter.IModel;
import com.bwie.test.presenter.CartPresenter;
import com.bwie.test.utils.RetrofitUtils;

import java.util.Map;

import io.reactivex.Flowable;

public class CartModel implements IModel {
    private CartPresenter presenter;

    public CartModel(CartPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getProductData(Map<String, String> map) {
        Flowable<ProductsBean> flowable = RetrofitUtils.getInstance("https://www.zhaoapi.cn/").getApiService().getProduct(map);
        presenter.getProductNews(flowable);
    }

    @Override
    public void getShowsData(Map<String, String> map) {
        Flowable<ShowsBean> flowable = RetrofitUtils.getInstance("https://www.zhaoapi.cn/").getApiService().getShows(map);
        presenter.getShowsNews(flowable);
    }

    @Override
    public void getAddData(Map<String, String> map) {
        Flowable<AddBean> flowable = RetrofitUtils.getInstance("http://120.27.23.105/").getApiService().getAdd(map);
        presenter.getAddNews(flowable);
    }

    @Override
    public void getCartsData(Map<String, String> map) {
        Flowable<CartsBean> flowable = RetrofitUtils.getInstance("http://120.27.23.105/").getApiService().getCarts(map);
        presenter.getCartsNews(flowable);
    }

    @Override
    public void getDeleteData(Map<String, String> map) {
        Flowable<DeleteBean> flowable = RetrofitUtils.getInstance("http://120.27.23.105/").getApiService().getDelete(map);
        presenter.getDeleteNews(flowable);
    }

    @Override
    public void getDingdanData(Map<String, String> map) {
        Flowable<DinganBean> flowable = RetrofitUtils.getInstance("http://120.27.23.105/").getApiService().getDingdan(map);
        presenter.getDingdanNews(flowable);
    }
}
