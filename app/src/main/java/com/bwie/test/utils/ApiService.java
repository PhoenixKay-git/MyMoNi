package com.bwie.test.utils;

import com.bwie.test.bean.AddBean;
import com.bwie.test.bean.CartsBean;
import com.bwie.test.bean.DeleteBean;
import com.bwie.test.bean.DinganBean;
import com.bwie.test.bean.ProductsBean;
import com.bwie.test.bean.ShowsBean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiService {
    //https://www.zhaoapi.cn/product/getProducts?pscid=39&page=1
    @GET("product/getProducts")
    Flowable<ProductsBean> getProduct(@QueryMap Map<String, String> map);

    //https://www.zhaoapi.cn/product/getProductDetail?pid=45&source=android
    @GET("product/getProductDetail")
    Flowable<ShowsBean> getShows(@QueryMap Map<String, String> map);

    //http://120.27.23.105/product/addCart?uid=101&pid=45&source=android
    @GET("product/addCart")
    Flowable<AddBean> getAdd(@QueryMap Map<String, String> map);

    // http://120.27.23.105/product/getCarts?uid=75&source=android
    @GET("product/getCarts")
    Flowable<CartsBean> getCarts(@QueryMap Map<String, String> map);

    //http://120.27.23.105/product/deleteCart?uid=101&pid=45&source=android
    @GET("product/deleteCart")
    Flowable<DeleteBean> getDelete(@QueryMap Map<String, String> map);

    //http://120.27.23.105/product/getOrders?uid=71
    @GET("product/getOrders")
    Flowable<DinganBean> getDingdan(@QueryMap Map<String, String> map);
}
