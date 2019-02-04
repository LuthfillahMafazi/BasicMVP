package co.example.lutfillahmafazi.basicmvp.Detail;

import android.os.Bundle;

import co.example.lutfillahmafazi.basicmvp.Model.User.UserData;

public interface DetailContract {
    interface View{
        void showProgress();
        void hideProgress();
        void showDataSIngleUser(UserData userData);
        void showFailureMessage(String msg);

    }
    interface Presenter{
        void getDataSingleUser(Bundle bundle);
    }
}
