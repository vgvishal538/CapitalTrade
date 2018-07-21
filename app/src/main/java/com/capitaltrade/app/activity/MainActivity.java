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

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.addCaseBtn)
    Button addCaseBtn;
    @BindView(R.id.viewSubmittedCaseBtn)
    Button viewSubmittedCaseBtn;
    @BindView(R.id.viewCaseStatusBtn)
    Button viewCaseStatusBtn;
    @BindView(R.id.contactBtn)
    Button contactBtn;
    @BindView(R.id.logoutBtn)
    Button logoutBtn;
    @BindView(R.id.personName)
    TextView personName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        personName.setText("Welcome ,"+SharedPrefUtils.getPersonName(MainActivity.this));
    }

    @OnClick(R.id.addCaseBtn)
    public void AddCaseBtnClick(){
        startActivity(new Intent(getApplicationContext(),AddCaseActivity.class));
    }
    @OnClick(R.id.viewSubmittedCaseBtn)
    public void ViewSubmittedCaseBtnClick(){
        startActivity(new Intent(getApplicationContext(),ViewSubmittedCaseActivity.class));
    }
    @OnClick(R.id.viewCaseStatusBtn)
    public void ViewCaseStatusBtnClick(){
        startActivity(new Intent(getApplicationContext(),ViewCaseStatusActivity.class));

    }
    @OnClick(R.id.contactBtn)
    public void ContactBtnClick(){
        startActivity(new Intent(getApplicationContext(),ContactActivity.class));
    }
    @OnClick(R.id.logoutBtn)
    public void Logout(){
        SharedPrefUtils.clearUserData(MainActivity.this);
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        finish();
    }


}
