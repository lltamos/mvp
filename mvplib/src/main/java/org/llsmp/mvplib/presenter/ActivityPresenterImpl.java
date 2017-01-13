package org.llsmp.mvplib.presenter;


import org.llsmp.mvplib.helper.GenericHelper;
import org.llsmp.mvplib.view.IView;

import android.app.Activity;
import android.os.Bundle;

/**
 * 将Activity作为Presenter的基类 <br />
 * Created by qibin on 2015/11/15.
 */
public class ActivityPresenterImpl<T extends IView> extends Activity implements IPresenter<T> {

    protected T mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        create(savedInstanceState);

        try {
            mView = getViewClass().newInstance();
            mView.bindPresenter(this);
            setContentView(mView.create(getLayoutInflater(), null));
            mView.bindEvent();
            created(savedInstanceState);
        } catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    

    @Override
    public Class<T> getViewClass() {
        return GenericHelper.getViewClass(getClass());
    }

    @Override
    public void create(Bundle savedInstance) {

    }

    @Override
    public void created(Bundle savedInstance) {

    }
}
