package co.edu.uptc.presenter;

public interface ContractPlay {
    interface Model {
        void setPresenter(Presenter presenter);
        void countTime();
    }

    interface View {
        void setPresenter(Presenter presenter);
        void run();
        void updateTime(String time);
    }

    interface Presenter {
        void setView(View view);

        void setModel(Model model);
        void run();
        void updateTime(String time);
    }
}
