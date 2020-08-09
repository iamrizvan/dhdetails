package com.axiom.designhandler.main.view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.axiom.designhandler.R;
import com.axiom.designhandler.main.contract.MainActivityContract;
import com.axiom.designhandler.main.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    @BindView(R.id.design_txt)
    TextView designTxt;
    @BindView(R.id.handler_text)
    TextView handlerTxt;
    @BindView(R.id.qr_icon)
    ImageView rqIcon;
    @BindView(R.id.search_by_id_tv)
    TextView searchByIdTv;
    @BindView(R.id.product_id_edt)
    EditText productIdEdt;
    @BindView(R.id.search_btn)
    Button searchBtn;

    MainPresenter presenter;
    Boolean visibilityStatus = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind the view using butter knife library
        ButterKnife.bind(this);

        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/quicksand.otf");
        designTxt.setTypeface(tf);
        handlerTxt.setTypeface(tf);
        searchByIdTv.setTypeface(tf);
        productIdEdt.setTypeface(tf);
        searchBtn.setTypeface(tf);

        presenter = new MainPresenter(this);

        searchByIdTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.toggleSearchById(visibilityStatus);
            }
        });

    }

    @Override
    public void showIDFields() {
        productIdEdt.setVisibility(View.VISIBLE);
        searchBtn.setVisibility(View.VISIBLE);
        searchByIdTv.setText("Search By ID");
    }

    @Override
    public void hideIDFields() {
        productIdEdt.setVisibility(View.GONE);
        searchBtn.setVisibility(View.GONE);
        searchByIdTv.setText("Search By ID >");
    }

    @Override
    public void updateVisibilityStatus() {
        visibilityStatus = !visibilityStatus;
    }

}