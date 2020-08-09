package com.axiom.designhandler.main.contract;

import android.view.View;

public class MainActivityContract {

    public interface Presenter
    {
        void toggleSearchById(Boolean visible);
    }

    public interface View {
        void showIDFields();
        void hideIDFields();
        void updateVisibilityStatus();
    }
}
