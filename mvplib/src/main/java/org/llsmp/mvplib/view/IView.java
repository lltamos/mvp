package org.llsmp.mvplib.view;


import org.llsmp.mvplib.presenter.IPresenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * View层的根接口 <br />
 * Created by qibin on 2015/11/15.
 */
public interface IView {
    /**
     * 根据 {@link getLayoutId()}方法生成生成setContentView需要的根布局
     * @param inflater
     * @param container
     * @return
     */
    View create(LayoutInflater inflater, ViewGroup container);

    /**
     * 当Activity的onCreate完毕后调用
     */
    void created();

    /**
     * 返回当前视图需要的layout的id
     */
    int getLayoutId();

    /**
     * 根据id获取view
     * @param id
     * @param <V>
     * @return
     */
    <V extends View> V findViewById(int id);

    /**
     * 绑定Presenter
     * @param presenter
     */
    void bindPresenter(IPresenter presenter);

    /**
     * {@link created}后调用，可以调用{@link org.llsmp.mvplib.helper.EventHelper}
     * 等方法为控件设置点击事件，一般推荐使用{@link org.llsmp.mvplib.helper.EventHelper(IPresenter presenter, View ...views)}
     * 方法并且让你的Presenter实现相应接口。
     */
    void bindEvent();
}
