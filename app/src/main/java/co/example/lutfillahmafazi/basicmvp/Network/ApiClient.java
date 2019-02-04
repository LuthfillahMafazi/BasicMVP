package co.example.lutfillahmafazi.basicmvp.Network;

import co.example.lutfillahmafazi.basicmvp.Utils.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit retrofit = null;

    // Membuat methpd retrunt untuk mendapatkan retrofit yang sudah diisi baseUrl
    public static Retrofit getClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
