package co.example.lutfillahmafazi.basicmvp.Mine;

import co.example.lutfillahmafazi.basicmvp.Model.User.UserData;
import co.example.lutfillahmafazi.basicmvp.Model.User.UserResponse;
import co.example.lutfillahmafazi.basicmvp.Network.ApiClient;
import co.example.lutfillahmafazi.basicmvp.Network.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View view;
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void getDataListUser() {
        view.showProgress();
        // merequest data ke api
        Call<UserResponse> call = apiInterface.getDataUsers(9);
        // Menjalankan request ke api
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                view.hideProgress();
                // mencek data response bidy
                if (response.body() != null){
                    UserResponse userResponse = response.body();
                    // Mencek data list User
                    if (userResponse.getUserDataList() != null){
                        // Mengirimkan data list user ke view untuk di tampilkan
                        view.showDataListUser(userResponse.getUserDataList());
                    }
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                view.hideProgress();
                view.showFailureMessege(t.getMessage());
            }
        });
    }
}
