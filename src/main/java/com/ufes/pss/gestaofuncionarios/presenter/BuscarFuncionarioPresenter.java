package com.ufes.pss.gestaofuncionarios.presenter;

import com.ufes.pss.gestaofuncionarios.collection.FuncionarioCollection;
import com.ufes.pss.gestaofuncionarios.factory.SistemaDeLogs;
import com.ufes.pss.gestaofuncionarios.view.BuscarFuncionarioView;
import javax.swing.table.DefaultTableModel;

public class BuscarFuncionarioPresenter {
    
    private BuscarFuncionarioView view;
    private final DefaultTableModel tmFuncionarios;
    private final FuncionarioCollection funcionarios;
    private SistemaDeLogs logs;
    
    public BuscarFuncionarioPresenter(PrincipalPresenter principal, FuncionarioCollection funcionarios, SistemaDeLogs logs){
        this.funcionarios = funcionarios;
        this.logs = logs;
        funcionarios.ordenar();
        view = new BuscarFuncionarioView();
        principal.getView().getDesktop().add(view);
        
        tmFuncionarios = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Nome", "Idade", "Função", "Salário base (R$)"});
    }
    
}
