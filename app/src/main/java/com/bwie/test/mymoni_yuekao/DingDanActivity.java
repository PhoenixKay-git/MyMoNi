package com.bwie.test.mymoni_yuekao;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.test.adapter.DingdanAdapter;
import com.bwie.test.bean.DinganBean;
import com.bwie.test.inter.IView;
import com.bwie.test.presenter.CartPresenter;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DingDanActivity extends AppCompatActivity implements IView {
    @BindView(R.id.img_duo)
    ImageView imgDuo;
    @BindView(R.id.textview1)
    TextView textview1;
    @BindView(R.id.textview2)
    TextView textview2;
    @BindView(R.id.textview3)
    TextView textview3;
    @BindView(R.id.rv)
    XRecyclerView mRv;
    private int num = 1;
    private DingdanAdapter dingdanAdapter;
    private CartPresenter presenter;
    private HashMap<String, String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ding_dan);
        ButterKnife.bind(this);
        //隐藏原有标题
        getSupportActionBar().hide();
        getData(1);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRv.setLayoutManager(manager);
        mRv.setPullRefreshEnabled(true);
        mRv.setLoadingMoreEnabled(true);
        mRv.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRv.setLoadingMoreProgressStyle(ProgressStyle.Pacman);

        mRv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        num = 1;
                        getData(num);
                        dingdanAdapter.notifyDataSetChanged();
                        mRv.refreshComplete();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        num++;
                        getData(num);
                        dingdanAdapter.notifyDataSetChanged();
                        mRv.refreshComplete();
                    }
                }, 2000);
            }
        });
    }

    @OnClick({R.id.img_duo, R.id.rv, R.id.textview1, R.id.textview2, R.id.textview3})
    public void onClick(View v){
        switch (v.getId()) {
            default:
                break;
            case R.id.img_duo:
                break;
            case R.id.rv:
                break;
            case R.id.textview1:
                break;
            case R.id.textview2:
                break;
            case R.id.textview3:
                break;
        }
    }

    public void getData(int count) {
        presenter = new CartPresenter();
        map = new HashMap<>();
        //pscid=39&page=1
        map.put("uid", "71");
        map.put("page", count + "");
        presenter.getDingdanData(map);
        presenter.attachView(this);
    }

    @Override
    public void onSuccess(Object o) {
        if (o != null) {
            DinganBean bean = (DinganBean) o;
            Log.i("zzz", "onSuccess: " + bean.getMsg());
            final List<DinganBean.DataBean> data = bean.getData();
            dingdanAdapter = new DingdanAdapter(this, data);
            mRv.setAdapter(dingdanAdapter);
        }
    }

    @Override
    public void onFailed(Exception e) {

    }
}
