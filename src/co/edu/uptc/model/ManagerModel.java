package co.edu.uptc.model;

import co.edu.uptc.presenter.ContractPlay;

public class ManagerModel implements ContractPlay.Model {
    private ContractPlay.Presenter presenter;
    @Override
    public void setPresenter(ContractPlay.Presenter presenter) {
        this.presenter = presenter;
    }
}
