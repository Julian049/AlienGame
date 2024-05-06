package co.edu.uptc.presenter;

import co.edu.uptc.pojo.AlienPojo;
import co.edu.uptc.pojo.BulletPojo;
import co.edu.uptc.pojo.CannonPojo;

import java.util.concurrent.CopyOnWriteArrayList;


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
        CopyOnWriteArrayList<AlienPojo> getAliens();
        void updateCountALiens();
        void spawnNwAlien();
    }

    interface View {
        void setPresenter(Presenter presenter);
        void run();
        void updateTime(String time);
        void updateAliveALiens(int aliensAlive);
        void updateKilledALiens(int aliensKilled);
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
        CopyOnWriteArrayList<AlienPojo> getAliens();
        void updateAliveALiens(int aliensAlive);
        void updateKilledALiens(int aliensKilled);
    }
}
