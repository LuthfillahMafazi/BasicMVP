package co.example.lutfillahmafazi.basicmvp.Model.User;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.http.GET;

public class UserResponse {
    @SerializedName("data")
    private List<UserData> userDataList;

    public List<UserData> getUserDataList() {
        return userDataList;
    }

    public void setUserDataList(List<UserData> userDataList) {
        this.userDataList = userDataList;
    }
}
