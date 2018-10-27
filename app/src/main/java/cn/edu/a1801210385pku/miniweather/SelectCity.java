package cn.edu.a1801210385pku.miniweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.pku.wangtao.app.MyApplication;
import cn.edu.pku.wangtao.bean.City;

/**
 * Created by 涛 on 2018/10/17.
 */

public class SelectCity extends Activity implements View.OnClickListener{

    private ImageView mBackBtn;
    private ListView mList;
    private Myadapter myadapter;
    List<City> filterDateList = new ArrayList<City>();  //自己添加的list
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.select_city);
        initViews();

        mBackBtn = (ImageView) findViewById(R.id.title_back);
        mBackBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                Intent i = new Intent();
                i.putExtra("cityCode", "101160101");
                setResult(RESULT_OK, i);
                finish();
                break;
            default:
                break;
        }
    }
    private void initViews(){
        /*
        mList=(ListView) findViewById(R.id.title_list);
        MyApplication myApplication =(MyApplication) getApplication();
        cityList=myApplication.getCityList();
        for (City city : cityList){
            filterDateList.add(city);
        }
        myadapter = new Myadapter(SelectCity.this, R.layout.city_list,cityList);
        mList.setAdapter(myadapter);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int position,long 1){
                City city=filterDateList.get(position);
                Intent i =new Intent();
                i.putExtra("cityCode",city.getNumber());
                setResult(RESULT_OK,i);
                finish();
            }
        });
        */
    }

}


