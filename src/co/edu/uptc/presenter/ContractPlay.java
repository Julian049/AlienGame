package co.edu.uptc.presenter;

public interface ContractPlay {
    interface Model {
        void setPresenter(Presenter presenter);
    }

    interface View {
        void setPresenter(Presenter presenter);
        void run();
    }

    interface Presenter {
        void setView(View view);

        void setModel(Model model);
        void run();
    }
}
