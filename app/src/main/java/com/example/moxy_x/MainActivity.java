package com.example.moxy_x;

import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @BindView(R.id.btnCounter1)
    Button buttonOne;

    @BindView(R.id.btnCounter2)
    Button buttonTwo;

    @BindView(R.id.btnCounter3)
    Button buttonThree;

    @InjectPresenter
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnCounter1, R.id.btnCounter2, R.id.btnCounter3})
    public void onButtonClick(Button button) {
        int index = 0;
        switch (button.getId()) {
            case R.id.btnCounter1:
                index = 0;
                break;
            case R.id.btnCounter2:
                index = 1;
                break;
            case R.id.btnCounter3:
                index = 2;
                break;
        }
        presenter.counterClick(index);
    }

    @Override
    public void setText0(int value) {
        buttonOne.setText(String.format(getString(R.string.count_format), value));
    }

    @Override
    public void setText1(int value) {
        buttonTwo.setText(String.format(getString(R.string.count_format), value));
    }

    @Override
    public void setText2(int value) {
        buttonThree.setText(String.format(getString(R.string.count_format), value));
    }
}
