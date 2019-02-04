package co.example.lutfillahmafazi.basicmvp.Mine;

import java.util.List;

import co.example.lutfillahmafazi.basicmvp.Model.User.UserData;

public interface MainContract {

    interface View{
        // TODO 6
        void showProgress();
        void hideProgress();
        // Menampilkan data list user ke view recyclerView
        void showDataListUser(List<UserData> userDataList);
        // Menampilkan pesan gagal
        void showFailureMessege(String msg);
    }
    interface Presenter{
        // Membuat method interface untuk mengambil data dari API
        void getDataListUser();
    }

}
