package com.vuongtc.uet.uber_shipper.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.vuongtc.uet.uber_shipper.R;
import com.vuongtc.uet.uber_shipper.databases.MyApplication;
import com.vuongtc.uet.uber_shipper.users.AccountInfo;

//import com.facebook.CallbackManager;
//import com.facebook.login.widget.LoginButton;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private static final int GG_SIGN_IN = 001;

    private GoogleApiClient mGoogleApiClient;
    private ProgressDialog mProgressDialog;

    private SignInButton btn_login_google;

    private EditText edt_email,edt_pass;
    private Button btn_login;
    private TextView tv_register;
    private ImageView iv_register;
//    private LoginButton btn_login_facebook;

//    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {

        btn_login_google = (SignInButton)findViewById(R.id.login_google);
        btn_login_google.setOnClickListener(this);

        edt_email = (EditText)findViewById(R.id.email);
        edt_pass = (EditText)findViewById(R.id.password);
        btn_login = (Button)findViewById(R.id.btn_login);
        tv_register = (TextView)findViewById(R.id.tv_register);
        iv_register = (ImageView)findViewById(R.id.iv_register);

        btn_login.setOnClickListener(this);
        iv_register.setOnClickListener(this);
        tv_register.setOnClickListener(this);

//        btn_login_facebook = (LoginButton)findViewById(R.id.login_facebook);

        //google login
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestProfile()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        //facebook login
//        FacebookSdk.sdkInitialize(getApplicationContext());
//        callbackManager = CallbackManager.Factory.create();

//        btn_login_facebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                Toast.makeText(LoginActivity.this,"Successful", Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onCancel() {
//                Toast.makeText(LoginActivity.this,"Login attempt canceled.", Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onError(FacebookException error) {
//                Toast.makeText(LoginActivity.this,"Login attempt failed.", Toast.LENGTH_LONG).show();
//            }
//        });

    }

    private void googleLogin() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, GG_SIGN_IN);
    }

    public void googleLogout() {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        updateUI(false);
                    }
                });
    }

    private void handleSignInResult(GoogleSignInResult result) {
//        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();


            String personName = acct.getDisplayName();
            String personPhotoUrl = String.valueOf(acct.getPhotoUrl());
            String personEmail = acct.getEmail();

            Log.e(TAG, "display name: " + personPhotoUrl);

            AccountInfo accountInfo = new AccountInfo(personName, personEmail,personPhotoUrl);
            MyApplication application = (MyApplication)getApplication();
            application.setAccountInfo(accountInfo);
            updateUI(true);
            toMainActivity();
        } else {
            // Signed out, show unauthenticated UI.
            updateUI(false);
        }
    }

    private void toMainActivity(){
        Intent mainActivityIntent = new Intent();
        mainActivityIntent.setClass(this,MainActivity.class);
        startActivity(mainActivityIntent);
    }

    private void updateUI(boolean isSignedIn) {
        if (isSignedIn) {
            btn_login_google.setVisibility(View.GONE);
        } else {
            btn_login_google.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.login_google:
                googleLogin();
                break;
            case R.id.btn_login:
                break;
            case R.id.tv_register:
                toRegisterActivity();
                break;
            case R.id.iv_register:
                toRegisterActivity();
                break;
            default:
                break;
        }

    }

    private void toRegisterActivity(){
        Intent registerIntent = new Intent(this,RegisterActivity.class);
        startActivity(registerIntent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == GG_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }/*else{
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }*/
    }


    @Override
    protected void onStart() {
        super.onStart();
        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);
        if (opr.isDone()) {
            // If the user's cached credentials are valid, the OptionalPendingResult will be "done"
            // and the GoogleSignInResult will be available instantly.
            Log.d(TAG, "Got cached sign-in");
            GoogleSignInResult result = opr.get();
            handleSignInResult(result);
        } else {
            // If the user has not previously signed in on this device or the sign-in has expired,
            // this asynchronous branch will attempt to sign in the user silently.  Cross-device
            // single sign-on will occur in this branch.
            showProgressDialog();
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(GoogleSignInResult googleSignInResult) {
                    hideProgressDialog();
                    handleSignInResult(googleSignInResult);
                }
            });
        }
    }

    private void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    private void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.hide();
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }
}
