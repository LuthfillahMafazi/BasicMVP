package co.example.lutfillahmafazi.basicmvp.Network;

import co.example.lutfillahmafazi.basicmvp.Model.LoginBody;
import co.example.lutfillahmafazi.basicmvp.Model.LoginResponse;
import co.example.lutfillahmafazi.basicmvp.Model.SingleUser.SingleUserResponse;
import co.example.lutfillahmafazi.basicmvp.Model.User.UserResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @POST("api/login")
    Call<LoginResponse> postLogin(@Body LoginBody loginBody);

    @GET("api/users")
    Call<UserResponse> getDataUsers(@Query("per_page") int perPage);

    @GET("/api/users/{id}")
    Call<SingleUserResponse> getDataSingleUser(@Path("id") int id);
}
