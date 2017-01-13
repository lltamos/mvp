package org.llsmp.mcp;


import org.llsmp.mvplib.presenter.ActivityPresenterImpl;

import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

public class MainActivity extends ActivityPresenterImpl<DataListView>
        implements AdapterView.OnItemClickListener, View.OnClickListener {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mView.toast(position);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.newdata) newData();
        else getData();
    }

    private void newData() {
        new MainBiz().data(new MainBiz.Callback<ArrayList<String>>() {
            @Override
            public void callback(ArrayList<String> data) {
                mView.setData(data);
            }
        });
    }

    private void getData() {
        new MainBiz().data(new MainBiz.Callback<ArrayList<String>>() {
            @Override
            public void callback(ArrayList<String> data) {
                mView.addData(data);
            }
        });
    }
}


