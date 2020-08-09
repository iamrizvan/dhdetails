package com.axiom.designhandler.main.presenter;

import com.axiom.designhandler.main.contract.MainActivityContract;

public class MainPresenter implements MainActivityContract.Presenter {
    MainActivityContract.View view;

    public MainPresenter( MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void toggleSearchById(Boolean visible) {
        if(!visible){
            view.showIDFields();
        }
        else
        {
            view.hideIDFields();
        }
        view.updateVisibilityStatus();
    }
}
