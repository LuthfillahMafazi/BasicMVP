package co.example.lutfillahmafazi.basicmvp.Login;

public interface LoginContract {
    // Membuat interface untuk method yang dinbutuhkan pada View / Interaksi dengan user
    interface View{
        // Menampilkan progress Loading
        void showProgress();
        void hideProgress();

        // Menampilkan dan melakukan sesuatu pada saat server merespon
        void loginFailure(String msg);
        void loginSuccess(String token);

    }
    // Membuat interface untuk method yang dibutuhkan pada presenter / Mediator dengan model(Bisnis Logic)
    interface Presenter{
        // TODO 2 di Logic
        // Membuat method untuk berkomunikasi dengan model
        void doLogin(String email, String password);
    }
}
