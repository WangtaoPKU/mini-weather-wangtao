package cn.edu.a1801210385pku.miniweather;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import cn.edu.pku.wangtao.bean.City;

/**
 * Created by 涛 on 2018/10/24.
 */

public class Myadapter extends ArrayAdapter<City>{
    private int resourceId;
    public Myadapter(Context content, int textViewResourceId, List<City>Objects)
    {
        super(content, textViewResourceId, Objects);
        resourceId = textViewResourceId;
    }

}
