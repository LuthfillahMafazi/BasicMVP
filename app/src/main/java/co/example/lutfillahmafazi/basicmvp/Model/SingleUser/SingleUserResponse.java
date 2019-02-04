package co.example.lutfillahmafazi.basicmvp.Model.SingleUser;

import com.google.gson.annotations.SerializedName;

import co.example.lutfillahmafazi.basicmvp.Model.User.UserData;

public class SingleUserResponse {

    /**
     * Mengapa Single user Response tidak menggunakan list adalah karena dia tidak berupa array
     * karena jika array maka datanya dimaskuakn ke dalam array dan jika tidak maka seperti contoh dibawah
     */

    @SerializedName("data")
    private UserData data;

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }
}
