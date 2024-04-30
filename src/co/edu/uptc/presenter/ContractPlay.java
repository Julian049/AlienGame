package co.edu.uptc.presenter;

import co.edu.uptc.pojo.CannonPojo;

public interface ContractPlay {
    interface Model {
        void setPresenter(Presenter presenter);
        void countTime();
        CannonPojo getCannonPojo();
        void moveCannonRight();
        void moveCannonLeft();

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
        void moveCannonLeft();
        void moveCannonRight();
        CannonPojo getCannonPojo();
    }
}
