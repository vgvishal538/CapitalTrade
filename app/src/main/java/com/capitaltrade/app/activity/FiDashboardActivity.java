package com.capitaltrade.app.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.capitaltrade.app.R;
import com.capitaltrade.app.Utils.SharedPrefUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FiDashboardActivity extends AppCompatActivity {
    @BindView(R.id.fiLogout)
    Button fiLogout;
    @BindView(R.id.finame)
    TextView finame;
    @BindView(R.id.finewCase)
    Button finewCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fi_dashboard);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        finame.setText("Welcome , "+SharedPrefUtils.getPersonName(FiDashboardActivity.this));
    }

    @OnClick(R.id.finewCase)
    public void FiAddNewCase(){
        startActivity(new Intent(getApplicationContext(),FIAddCaseActivity.class));
    }

    @OnClick(R.id.viewSubmittedCaseFi)
    public void ViewSubmittedCaseFi(){
        startActivity(new Intent(getApplicationContext(),ViewCaseSubmittedFiActivity.class));
    }

    @OnClick(R.id.fiLogout)
    public void Logout(){
        SharedPrefUtils.clearUserData(FiDashboardActivity.this);
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        finish();
    }
    @OnClick(R.id.Ficontact)
    public void FiContact(){
        startActivity(new Intent(getApplicationContext(),ContactActivity.class));
    }
}
