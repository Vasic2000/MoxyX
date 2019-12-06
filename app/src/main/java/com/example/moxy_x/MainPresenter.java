package com.example.moxy_x;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private Model model = new Model();

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public int calcValue(int index){
        model.setAt(index, model.getAt(index) + 1);
        return model.getAt(index);
    }

    public void counterClick(int id){
        switch (id) {
            case 0:
                getViewState().setText0(calcValue(0));
                break;
            case 1:
                getViewState().setText1(calcValue(1));
                break;
            case 2:
                getViewState().setText2(calcValue(2));
                break;
        }
    }
}
