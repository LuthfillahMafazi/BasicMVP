package co.example.lutfillahmafazi.basicmvp.View;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.example.lutfillahmafazi.basicmvp.Detail.DetailContract;
import co.example.lutfillahmafazi.basicmvp.Detail.DetailPresenter;
import co.example.lutfillahmafazi.basicmvp.Model.User.UserData;
import co.example.lutfillahmafazi.basicmvp.R;

public class DetailActivity extends AppCompatActivity implements DetailContract.View {

    @BindView(R.id.imgAvatar)
    ImageView imgAvatar;
    @BindView(R.id.txtFirstName)
    TextView txtFirstName;
    @BindView(R.id.txtLastName)
    TextView txtLastName;

    // Membuat variable yang dibutuhkan
    private ProgressDialog progressDialog;
    private final DetailPresenter detailPresenter = new DetailPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        // Mengirimkan bundle ke presenter untuk di cek dan merequest single user denagn ID
        Bundle bundle = getIntent().getExtras();
        detailPresenter.getDataSingleUser(bundle);
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
    public void showDataSIngleUser(UserData userData) {
        // Menampilkan data yang di kirim oleh presenter untuk ke layar
        txtFirstName.setText(userData.getFirst_name());
        txtLastName.setText(userData.getLast_name());

        RequestOptions requestOptions = new RequestOptions().error(R.drawable.ic_broken_image).placeholder(R.drawable.ic_broken_image);
        Glide.with(this).load(userData.getAvatar()).apply(requestOptions).into(imgAvatar);
    }

    @Override
    public void showFailureMessage(String msg) {

    }
}
