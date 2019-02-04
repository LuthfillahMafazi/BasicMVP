package co.example.lutfillahmafazi.basicmvp.Detail;

import android.os.Bundle;

import co.example.lutfillahmafazi.basicmvp.Model.SingleUser.SingleUserResponse;
import co.example.lutfillahmafazi.basicmvp.Network.ApiClient;
import co.example.lutfillahmafazi.basicmvp.Network.ApiInterface;
import co.example.lutfillahmafazi.basicmvp.Utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter implements DetailContract.Presenter {

    private final DetailContract.View view;
    ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
    private int id;

    public DetailPresenter(DetailContract.View view) {
        this.view = view;
    }

    @Override
    public void getDataSingleUser(Bundle bundle) {
        // Mcek bundle apakah ada isinya
        if (bundle != null){
            id = bundle.getInt(Constants.KEY_ID);

            view.showProgress();
            Call<SingleUserResponse> call = apiInterface.getDataSingleUser(id);
            call.enqueue(new Callback<SingleUserResponse>() {
                @Override
                public void onResponse(Call<SingleUserResponse> call, Response<SingleUserResponse> response) {
                    view.hideProgress();
                    // Mencek response body
                    if (response.body() != null){
                        SingleUserResponse singleUserResponse = response.body();
                        // Mencek apakah singleUserResponse ada isinya
                        if (singleUserResponse.getData() != null){
                            // Mengirim data single user ke view untuk ditampilakn
                            view.showDataSIngleUser(singleUserResponse.getData());
                        }
                    }
                }

                @Override
                public void onFailure(Call<SingleUserResponse> call, Throwable t) {
                    view.hideProgress();
                    view.showFailureMessage(t.getMessage());
                }
            });

        }
    }
}
