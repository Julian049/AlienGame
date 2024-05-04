package co.edu.uptc.presenter;

import co.edu.uptc.pojo.AlienPojo;
import co.edu.uptc.pojo.BulletPojo;
import co.edu.uptc.pojo.CannonPojo;

import java.util.ArrayList;

public interface ContractPlay {
    interface Model {
        void setPresenter(Presenter presenter);
        void countTime();
        CannonPojo getCannonPojo();
        BulletPojo getBulletPojo();
        void moveCannonRight();
        void moveCannonLeft();
        void shoot();
        void loadAliens();
        void checkBulletColision();

        ArrayList<AlienPojo> getAliens();
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
        void shoot();
        BulletPojo getBulletPojo();
        ArrayList<AlienPojo> getAliens();
    }
}
