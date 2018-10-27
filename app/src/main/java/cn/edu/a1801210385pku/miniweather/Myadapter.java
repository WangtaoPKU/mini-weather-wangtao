package cn.edu.a1801210385pku.miniweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import cn.edu.pku.wangtao.bean.City;

/**
 * Created by 涛 on 2018/10/24.
 */

public class Myadapter extends ArrayAdapter<City>{
    private int resourceId;
    public Myadapter(Context content, int textViewResourceId,List<City>Objects)
    {
        super(content, textViewResourceId,Objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        City city = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView cityname = (TextView) view.findViewById(R.id.citylist);
        cityname.setText(city.getCity() + city.getNumber());
        return view;
    }
}
