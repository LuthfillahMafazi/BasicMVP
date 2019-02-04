package co.example.lutfillahmafazi.basicmvp.Login;

import co.example.lutfillahmafazi.basicmvp.Model.LoginBody;
import co.example.lutfillahmafazi.basicmvp.Model.LoginResponse;
import co.example.lutfillahmafazi.basicmvp.Network.ApiClient;
import co.example.lutfillahmafazi.basicmvp.Network.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter {

    // TODO 4
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    // Membuat object LoginContract View
    private final LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void doLogin(String email, String password) {
        // Mencek email dan Password apakah ada passwordnya
        if (email == null || email.isEmpty()){
            view.loginFailure("Email Kosong");
            return;
        }
        if (password == null || password.isEmpty()){
            view.loginFailure("Password kosong");
            return;
        }

        // Menampilkan Progress Dialog
        view.showProgress();

        // Memasukan data ke dalam login body
        final LoginBody loginBody = new LoginBody();
        loginBody.setEmail(email);
        loginBody.setPassword(password);

        // Mengeksekusi data ke server
        // Membuat Object Call untuk mengirim login body
        Call<LoginResponse> call = apiInterface.postLogin(loginBody);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                // menutup Progress
                view.hideProgress();

                // Mencek response apakah ada isinya?
                if (response.body() != null){
                    //Mengambil data Response body dan memasukan ke dalam class model LoginResponse
                    LoginResponse loginResponse = response.body();
                    // Mencek isi token apakah ada isinya? agar tidak forceClose apabila null
                    if (loginResponse.getToken() != null){
                        view.loginSuccess(loginResponse.getToken());
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                view.hideProgress();
                view.loginFailure(t.getMessage());
            }
        });
    }
}
