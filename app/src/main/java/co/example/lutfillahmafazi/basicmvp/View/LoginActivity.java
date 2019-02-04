package co.example.lutfillahmafazi.basicmvp.View;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.example.lutfillahmafazi.basicmvp.Login.LoginContract;
import co.example.lutfillahmafazi.basicmvp.Login.LoginPresenter;
import co.example.lutfillahmafazi.basicmvp.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    @BindView(R.id.edtEmail)
    EditText edtEmail;
    @BindView(R.id.edtPassword)
    EditText edtPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;

    private ProgressDialog progressDialog;
    // Membuat variable untuk dapat mengakses LoginPresenter
    private final LoginPresenter loginPresenter = new LoginPresenter(this);
    // TODO 3
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();

    }

    @Override
    public void loginFailure(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess(String token) {
        Toast.makeText(this, token, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @OnClick(R.id.btnLogin)
    public void onViewClicked() {
        loginPresenter.doLogin(edtEmail.getText().toString(),edtPassword.getText().toString());
    }
}
