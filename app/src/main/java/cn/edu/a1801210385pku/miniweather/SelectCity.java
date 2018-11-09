package cn.edu.a1801210385pku.miniweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.pku.wangtao.app.MyApplication;
import cn.edu.pku.wangtao.bean.City;

/**
 * Created by 涛 on 2018/10/17.
 */

public class SelectCity extends Activity implements View.OnClickListener{

    private ImageView mBackBtn;
    private ListView listView=null;
    private TextView cityselected=null;
    private List<City> listcity = MyApplication.getInstance().getCityList();
    private int listSize = listcity.size();
    private String[] city = new String[listSize];

    private ArrayList<String> mSearchResult = new ArrayList<>();
    private Map<String,String> nameToCode = new HashMap<>();
    private Map<String,String> nameToPinyin = new HashMap<>();

    private EditText mSearch;

    String returnCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_city);
        mBackBtn = (ImageView) findViewById(R.id.title_back);
        cityselected = (TextView) findViewById(R.id.title_name);
        mBackBtn.setOnClickListener(this);
        Log.i("City", listcity.get(1).getCity());
        for (int i = 0; i < listSize; i++) {
            city[i] = listcity.get(i).getCity();
            Log.d("City", city[i]);
        }

        String strName;
        String strNamePinyin;
        String strCode;
        for (City city1 : listcity) {
            strCode = city1.getNumber();
            strName = city1.getCity();
            strNamePinyin = city1.getFirstPy();
            nameToCode.put(strName, strCode);
            nameToPinyin.put(strName, strNamePinyin);
            mSearchResult.add(strName);
        }
        final ArrayAdapter<String> arrayAdapter = new
                ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice,
                mSearchResult);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String returnCityName = mSearchResult.get(i);
                Toast.makeText(SelectCity.this, "你已选择：" +
                        returnCityName, Toast.LENGTH_SHORT).show();
                cityselected.setText("当前城市：" + city[i]);
                returnCode = nameToCode.get(returnCityName);
                Log.d("returnCode",returnCode);
                cityselected.setText("当前城市：" + returnCityName);
            }
        });
        mSearch = (EditText) findViewById(R.id.search_edit);
        mSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                arrayAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    private List<String> getData() {
        List<String> data = new ArrayList<String>();
        data.add("测试数据1");
        data.add("测试数据2");
        data.add("测试数据3");
        return data;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.title_back) {
            Log.d("myWeather", "我点击了返回界面");
            int position = listView.getCheckedItemPosition();
            String select_cityCode = listcity.get(position).getNumber();
            Intent i = new Intent();
            i.putExtra("cityCode", returnCode);
            setResult(RESULT_OK, i);
            finish();
        }
        if (v.getId() == R.id.title_name) {
            Log.d("myWeather", "我是北京");
        }
    }



}


