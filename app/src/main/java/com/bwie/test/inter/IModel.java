package com.bwie.test.inter;

import java.util.Map;

public interface IModel {
    void getProductData(Map<String, String> map);
    void getShowsData(Map<String, String> map);
    void getAddData(Map<String, String> map);
    void getCartsData(Map<String, String> map);
    void getDeleteData(Map<String, String> map);
    void getDingdanData(Map<String, String> map);
}