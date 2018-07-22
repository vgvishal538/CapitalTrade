package com.capitaltrade.app.activity;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.capitaltrade.app.R;
import com.capitaltrade.app.network.responseModel.loginResponse.dealerResponse.DealerResponse;
import com.capitaltrade.app.network.responseModel.loginResponse.preFormUploadResponse.AddCaseResponse;
import com.capitaltrade.app.network.retrofit.ApiInterface;
import com.capitaltrade.app.network.retrofit.RetrofitUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.security.acl.Permission;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCaseActivity extends AppCompatActivity {
    @BindView(R.id.applicantNameBox)
    TextInputEditText applicantNameBox;
    @BindView(R.id.fatherNameBox)
    TextInputEditText fatherNameBox;
    @BindView(R.id.aplicantAddressBox)
    TextInputEditText aplicantAddressBox;
    @BindView(R.id.aplicantContactNoBox)
    TextInputEditText aplicantContactNoBox;
    @BindView(R.id.aplicantContactBox)
    TextInputEditText aplicantContactBox;
    @BindView(R.id.aplicantdobBox)
    TextInputEditText aplicantdobBox;
    @BindView(R.id.agegroupBox)
    TextInputEditText agegroupBox;
    @BindView(R.id.literacyBox)
    TextInputEditText literacyBox;
    @BindView(R.id.wherestayBox)
    TextInputEditText wherestayBox;
    @BindView(R.id.billcanoBox)
    TextInputEditText billcanoBox;
    @BindView(R.id.aadharnoBox)
    TextInputEditText aadharnoBox;
    @BindView(R.id.pannoBox)
    TextInputEditText pannoBox;
    @BindView(R.id.kycBox)
    TextInputEditText kycBox;
    @BindView(R.id.relationwithBox)
    TextInputEditText relationwithBox;
    @BindView(R.id.coapplicantnameBox)
    TextInputEditText coapplicantnameBox;
    @BindView(R.id.coapplicantfnameBox)
    TextInputEditText coapplicantfnameBox;
    @BindView(R.id.coapplicantaddressBox)
    TextInputEditText coapplicantaddressBox;
    @BindView(R.id.coapplicantnumberBox)
    TextInputEditText coapplicantnumberBox;
    @BindView(R.id.coapplicantaccountBox)
    TextInputEditText coapplicantaccountBox;
    @BindView(R.id.coapplicantebillBox)
    TextInputEditText coapplicantebillBox;
    @BindView(R.id.coapplicantaadharox)
    TextInputEditText coapplicantaadharox;
    @BindView(R.id.coapplicantpanbox)
    TextInputEditText coapplicantpanbox;
    @BindView(R.id.coapplicantkycbox)
    TextInputEditText coapplicantkycbox;
    @BindView(R.id.guarantornamebox)
    TextInputEditText guarantornamebox;
    @BindView(R.id.guarantorfnamebox)
    TextInputEditText guarantorfnamebox;
    @BindView(R.id.guarantoraddressbox)
    TextInputEditText guarantoraddressbox;
    @BindView(R.id.guarantornumberbox)
    TextInputEditText guarantornumberbox;
    @BindView(R.id.guarantorebillbox)
    TextInputEditText guarantorebillbox;
    @BindView(R.id.dealernamebox)
    TextInputEditText dealernamebox;
    @BindView(R.id.dealermanbox)
    TextInputEditText dealermanbox;
    @BindView(R.id.submitAddCaseBtn)
    Button submitAddCaseBtn;
    @BindView(R.id.signUploadBtn)
    Button signUploadBtn;
    @BindView(R.id.uploadImage)
    ImageView uploadImage;
    @BindView(R.id.currentDate)
    TextView currentDate;

    public static final int PICK_IMAGE = 100;
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 100;
    private final static int REQUEST_LOCATION = 199;
    //storage permission code
    private static final int STORAGE_PERMISSION_CODE = 123;
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    private static final int MEDIA_TYPE_IMAGE = 1;
    public RequestBody reqFile,appl_name,joining_date,appl_father_name,contact_no,alter_contact_no,
            elligible_age_group,appl_litracy_status,appl_house,bill_no,adhaar_no,pan_no,kyc_no,
            appl_relation,co_appl_name,co_appl_father_name,co_appl_address,co_appl_con_no,co_appl_acc_detail,
            co_appl_bill_no,co_appl_adhaar_no,co_appl_pan_no,co_appl_kyc_no,garantor_name,garantor_con_no,
            garantor_father_name,garantor_address,garantor_bill_no,dealer_id,e_riq_manuf,area;
    public MultipartBody.Part body;
    public RequestBody nameRequest, fatherNameRequest, mobNoRequest, genderRequest,
            pincodeRequest, districtRequest, stateRequest, placeRequest, postCropDetailsRequest, postlandareaRequest;
    StrictMode.VmPolicy.Builder builder;
    String filepathtoupload;
    private Uri filePath;
    private Bitmap bitmap;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    private String userChoosenTask, stateData,date;
    ApiInterface apiService;
    private ProgressDialog progress;


    private static File getOtputMediaFile(int type) {

        File mediastorageDir = new File(Environment.getExternalStorageDirectory(), "CapitalTrade");

        if (!mediastorageDir.exists()) {
            if (!mediastorageDir.mkdirs()) {

                return null;
            }
        }

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        File mediafile;

        if (type == MEDIA_TYPE_IMAGE) {
            mediafile = new File(mediastorageDir.getPath() + File.separator + "Img" + timestamp + ".jpg");
        } else {
            return null;
        }
        return mediafile;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_case);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        builder = new StrictMode.VmPolicy.Builder();
        progress=new ProgressDialog(this);
        progress.setMessage("Loading...");
        progress.setCancelable(false);

        // retrofit api init.
        apiService = RetrofitUtil.getClient().create(ApiInterface.class);
        StrictMode.setVmPolicy(builder.build());
        date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        currentDate.setText("Date : "+date);
    }

    @OnClick(R.id.submitAddCaseBtn)
    public void SubmitCaseDataClick(){
        if (applicantNameBox.getText().toString().isEmpty()){
            applicantNameBox.setError("This Can't Be Empty ");
        }else if (fatherNameBox.getText().toString().isEmpty()){
            fatherNameBox.setError("This Can't Be Empty");
        }else if(aplicantAddressBox.getText().toString().isEmpty()){
            aplicantAddressBox.setError("This Can't Be Empty");
        }else if (aplicantContactNoBox.getText().toString().isEmpty()){
            aplicantContactNoBox.setError("This Can't Be Empty");
        }else if (aplicantdobBox.getText().toString().isEmpty()){
            aplicantdobBox.setError("This Can't Be Empty");
        }else {
            submitForm();
        }
    }

    @OnClick(R.id.signUploadBtn)
    public void SignUploadBtnClick(){
        Log.e("click","yes");
        selectImage();
    }

    private void submitForm() {
        appl_name = RequestBody.create(MediaType.parse("text/plain"), applicantNameBox.getText().toString());
        joining_date = RequestBody.create(MediaType.parse("text/plain"), date);
        appl_father_name=RequestBody.create(MediaType.parse("text/plain"), fatherNameBox.getText().toString());
        contact_no = RequestBody.create(MediaType.parse("text/plain"), aplicantContactNoBox.getText().toString());
        alter_contact_no= RequestBody.create(MediaType.parse("text/plain"), aplicantContactBox.getText().toString());
        elligible_age_group = RequestBody.create(MediaType.parse("text/plain"), aplicantContactBox.getText().toString());
        appl_litracy_status = RequestBody.create(MediaType.parse("text/plain"), agegroupBox.getText().toString());
        appl_house = RequestBody.create(MediaType.parse("text/plain"), aplicantAddressBox.getText().toString());
        bill_no = RequestBody.create(MediaType.parse("text/plain"), billcanoBox.getText().toString());
        adhaar_no = RequestBody.create(MediaType.parse("text/plain"), aadharnoBox.getText().toString());
        pan_no = RequestBody.create(MediaType.parse("text/plain"), pannoBox.getText().toString());
        kyc_no = RequestBody.create(MediaType.parse("text/plain"), kycBox.getText().toString());
        appl_relation = RequestBody.create(MediaType.parse("text/plain"), relationwithBox.getText().toString());
        co_appl_name = RequestBody.create(MediaType.parse("text/plain"), coapplicantnameBox.getText().toString());
        co_appl_father_name = RequestBody.create(MediaType.parse("text/plain"), coapplicantfnameBox.getText().toString());
        co_appl_address = RequestBody.create(MediaType.parse("text/plain"), coapplicantaddressBox.getText().toString());
        co_appl_con_no= RequestBody.create(MediaType.parse("text/plain"), coapplicantnumberBox.getText().toString());
        co_appl_acc_detail=RequestBody.create(MediaType.parse("text/plain"), coapplicantaccountBox.getText().toString());
        co_appl_bill_no = RequestBody.create(MediaType.parse("text/plain"), coapplicantebillBox.getText().toString());
        co_appl_adhaar_no = RequestBody.create(MediaType.parse("text/plain"), coapplicantaadharox.getText().toString());
        co_appl_pan_no = RequestBody.create(MediaType.parse("text/plain"), coapplicantpanbox.getText().toString());
        co_appl_kyc_no =  RequestBody.create(MediaType.parse("text/plain"), coapplicantkycbox.getText().toString());
        garantor_name = RequestBody.create(MediaType.parse("text/plain"), guarantornamebox.getText().toString());
        garantor_con_no = RequestBody.create(MediaType.parse("text/plain"), guarantornumberbox.getText().toString());
        garantor_father_name = RequestBody.create(MediaType.parse("text/plain"), guarantorfnamebox.getText().toString());;
        garantor_address = RequestBody.create(MediaType.parse("text/plain"), guarantoraddressbox.getText().toString());;
        garantor_bill_no =  RequestBody.create(MediaType.parse("text/plain"), guarantorebillbox.getText().toString());;
        dealer_id =  RequestBody.create(MediaType.parse("text/plain"), dealernamebox.getText().toString());;
        e_riq_manuf = RequestBody.create(MediaType.parse("text/plain"), dealermanbox.getText().toString());;

        progress.show();

        Call<AddCaseResponse> call = apiService.uploadFormData(body,appl_name,joining_date,appl_father_name,contact_no,alter_contact_no,
                elligible_age_group,appl_litracy_status,appl_house,bill_no,adhaar_no,pan_no,kyc_no,
                appl_relation,co_appl_name,co_appl_father_name,co_appl_address,co_appl_con_no,co_appl_acc_detail,
                co_appl_bill_no,co_appl_adhaar_no,co_appl_pan_no,co_appl_kyc_no,garantor_name,garantor_con_no,
                garantor_father_name,garantor_address,garantor_bill_no,dealer_id,e_riq_manuf);
        call.enqueue(new Callback<AddCaseResponse>() {
            @Override
            public void onResponse( Call<AddCaseResponse> call,  Response<AddCaseResponse> response) {
                progress.dismiss();
                if (response.body().getSuccess() == 1){
                    Toast.makeText(getApplicationContext(),response.body().getMessage(),Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(),response.body().getMessage(),Toast.LENGTH_LONG).show();
                }
                Log.e("AddCaseRes",response.body().getMessage());

            }

            @Override
            public void onFailure(@NonNull Call<AddCaseResponse>call, @NonNull Throwable t) {
                // Log error here since request failed
                Log.e("AddCaseReserror", t.toString());
                progress.dismiss();
            }
        });



    }
    private void selectImage() {
        final CharSequence[] items = {"Camera", "Choose from Gallery"};

        AlertDialog.Builder builder = new AlertDialog.Builder(AddCaseActivity.this);
        builder.setTitle("Please Select");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result = com.capitaltrade.app.Utils.Permission.checkPermission(AddCaseActivity.this);

                if (items[item].equals("Camera")) {
                    userChoosenTask = "Camera";
                    if (result) {
                        cameraIntent();
                    }

                } else if (items[item].equals("Choose from Gallery")) {
                    userChoosenTask = "Choose from Gallery";
                    if (result) {
                        galleryIntent();
                    }

                }
            }
        });
        builder.show();
    }
    private void galleryIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_FILE);
    }

    private void cameraIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        filePath = getOtputMediaFileUri(MEDIA_TYPE_IMAGE);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, filePath);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            builder.detectFileUriExposure();
        }
        startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);


    }

    public Uri getOtputMediaFileUri(int type) {
        return Uri.fromFile(getOtputMediaFile(type));
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_CAPTURE_IMAGE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                filepathtoupload = filePath.getPath();
                Log.e("path", filepathtoupload);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 8;
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                    // CALL THIS METHOD TO GET THE URI FROM THE BITMAP
                    Uri tempUri = getImageUri(getApplicationContext(), bitmap);
                    uploadImage.setImageBitmap(bitmap);

                    // CALL THIS METHOD TO GET THE ACTUAL PATH
                    File finalFile = new File(getRealPathFromURI(tempUri));
                    filepathtoupload = String.valueOf(finalFile);
                    decodeFile(String.valueOf(finalFile));
                    reqFile = RequestBody.create(MediaType.parse("image/*"), finalFile);
                    body = MultipartBody.Part.createFormData("picture", finalFile.getName(), reqFile);

                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                    Toast.makeText(getApplication(), "An unexpected error occurred, Please Try Again",
                            Toast.LENGTH_LONG).show();
                }


            }
        } else if (requestCode == SELECT_FILE && resultCode == RESULT_OK && data != null
                && data.getData() != null) {

            filePath = data.getData();

            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 8;
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                uploadImage.setImageBitmap(bitmap);

                // CALL THIS METHOD TO GET THE URI FROM THE BITMAP
                Uri tempUri = getImageUri(getApplicationContext(), bitmap);

                // CALL THIS METHOD TO GET THE ACTUAL PATH
                File finalFile = new File(getRealPathFromURI(tempUri));
                filepathtoupload = String.valueOf(finalFile);
                decodeFile(String.valueOf(finalFile));
                reqFile = RequestBody.create(MediaType.parse("image/*"), finalFile);
                body = MultipartBody.Part.createFormData("picture", finalFile.getName(), reqFile);

            } catch (Throwable throwable) {
                throwable.printStackTrace();
                Toast.makeText(getApplication(), "An unexpected error occurred, Please Try Again",
                        Toast.LENGTH_LONG).show();
            }
        }

    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media
                .insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        assert cursor != null;
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }

    //method to get the file path from uri
    public String getPath(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        assert cursor != null;
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();

        cursor = getContentResolver().query(
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
        assert cursor != null;
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();

        return path;
    }


    public void decodeFile(String filePath) {
        // Decode image size
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, o);

        // The new size we want to scale to
        final int REQUIRED_SIZE = 100;

        // Find the correct scale value. It should be the power of 2.
        int width_tmp = o.outWidth, height_tmp = o.outHeight;
        int scale = 1;
        while (true) {
            if (width_tmp < REQUIRED_SIZE && height_tmp < REQUIRED_SIZE) {
                break;
            }
            width_tmp /= 8;
            height_tmp /= 8;
            scale *= 8;
        }

        // Decode with inSampleSize
        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        bitmap = BitmapFactory.decodeFile(filePath, o2);
//        profile_image.setImageBitmap(bitmap);


    }

    //Requesting permission
    private void requestCameraPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_CAMERA);
            }
        }


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
