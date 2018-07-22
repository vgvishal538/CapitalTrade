package com.capitaltrade.app.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.capitaltrade.app.R;
import com.capitaltrade.app.Utils.SharedPrefUtils;
import com.capitaltrade.app.network.responseModel.loginResponse.dealerResponse.DealerResponse;
import com.capitaltrade.app.network.responseModel.loginResponse.fiResponse.FiResponse;
import com.capitaltrade.app.network.retrofit.ApiInterface;
import com.capitaltrade.app.network.retrofit.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.loginType_spinner)
    Spinner loginType_spinner;
    @BindView(R.id.userNameBox)
    TextInputEditText userNameBox;
    @BindView(R.id.passwordBox)
    TextInputEditText passwordBox;
    private String selectedType;
    ApiInterface apiService;
    private ProgressDialog progress;
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        ButterKnife.bind(this);

       // userNameBox.setText("9565817700");
       // passwordBox.setText("CTDL589395");

        progress=new ProgressDialog(this);
        progress.setMessage("Loading...");
        progress.setCancelable(false);

        // retrofit api init.
         apiService = RetrofitUtil.getClient().create(ApiInterface.class);

        // Spinner click listener
        loginType_spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Select Login Type");
        categories.add("FI");
        categories.add("DEALER");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        loginType_spinner.setAdapter(dataAdapter);
    }
    @OnClick(R.id.loginBtn)
    public void LoginButtonClick(){
        if (selectedType.equalsIgnoreCase("Select Login Type")){
            Toast.makeText(getApplicationContext(),"Select Login Type",Toast.LENGTH_LONG).show();
        }else if (selectedType.equalsIgnoreCase("FI")&& !userNameBox.getText().toString().isEmpty() && !passwordBox.getText().toString().isEmpty()){
            getFiLogin(userNameBox.getText().toString(),passwordBox.getText().toString(),selectedType);
        }else if (selectedType.equalsIgnoreCase("DEALER")&& !userNameBox.getText().toString().isEmpty() && !passwordBox.getText().toString().isEmpty()){
            getDealerLogin(userNameBox.getText().toString(),passwordBox.getText().toString(),selectedType);
        }

    }

    private void getFiLogin(String username, String password, String selectedType) {
        progress.show();
        Call<FiResponse> call = apiService.getFiResponse(username,password,"0");
        call.enqueue(new Callback<FiResponse>() {
            @Override
            public void onResponse(@NonNull Call<FiResponse>call, @NonNull Response<FiResponse> response) {
                progress.dismiss();
                if (response.body().getSuccess().equals(1)){
                    String id = response.body().getFIData().get(0).getId();
                    String reg_no = response.body().getFIData().get(0).getRegNo();
                    String joining_date = response.body().getFIData().get(0).getJoiningDate();
                    String f_name = response.body().getFIData().get(0).getFName();
                    String l_name = response.body().getFIData().get(0).getLName();
                    String mobile = response.body().getFIData().get(0).getMobile();
                    String loginType = "0";
                    SharedPrefUtils.saveFiLoginDate(getApplicationContext(),id,reg_no,
                            joining_date,f_name,l_name,mobile,loginType);
                    startActivity(new Intent(getApplicationContext(),FiDashboardActivity.class));
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(),"Enter Valid Username & Password",Toast.LENGTH_LONG).show();
                }
                Log.e(TAG,""+response.body().getMessage());

            }

            @Override
            public void onFailure(@NonNull Call<FiResponse>call, @NonNull Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                progress.dismiss();
            }
        });
    }

    private void getDealerLogin(String username, String password, final String selectedType) {
        progress.show();

        Call<DealerResponse> call = apiService.getDealerResponse(username,password,"1");
        call.enqueue(new Callback<DealerResponse>() {
            @Override
            public void onResponse( Call<DealerResponse> call,  Response<DealerResponse> response) {
                progress.dismiss();
                if (response.body().getSuccess().equals(1)){
                    String dealer_id = response.body().getDealerData().get(0).getId();
                    String reg_no = response.body().getDealerData().get(0).getRegNo();
                    String joining_date = response.body().getDealerData().get(0).getJoiningDate();
                    String f_name = response.body().getDealerData().get(0).getFName();
                    String l_name = response.body().getDealerData().get(0).getLName();
                    String mobile = response.body().getDealerData().get(0).getMobile();
                    String email = response.body().getDealerData().get(0).getEmail();
                    String dealer_name = response.body().getDealerData().get(0).getDealerName();
                    String loginType = "1";
                    SharedPrefUtils.saveDealerLoginData(getApplicationContext(),dealer_id,reg_no,
                            joining_date,f_name,l_name,mobile,email,dealer_name,loginType);

                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(),"Enter  Username & Password",Toast.LENGTH_LONG).show();
                }
                Log.e(TAG,""+response.body().getMessage());

            }

            @Override
            public void onFailure(@NonNull Call<DealerResponse>call, @NonNull Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                progress.dismiss();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        selectedType = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
      //  Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
