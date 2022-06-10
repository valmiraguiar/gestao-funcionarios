package com.ufes.pss.gestaofuncionarios.presenter;

import com.ufes.pss.gestaofuncionarios.view.PrincipalView;
import com.ufes.pss.gestaofuncionarios.collection.FuncionarioCollection;
import com.ufes.pss.gestaofuncionarios.factory.SistemaDeLogs;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class PrincipalPresenter {
    
    private PrincipalView view;
    private final FuncionarioCollection funcionarios;
    private final SistemaDeLogs logs;
    
    public PrincipalPresenter() throws IOException{
        
        funcionarios = new FuncionarioCollection();
        logs = new SistemaDeLogs("TXT");
        
        inicializa();
        
    }
    
    public void inicializa(){
        
        view = new PrincipalView();
        informacoesDoSistema();
        view.setVisible(true);
        
        view.getBtnAddFuncionario().addActionListener(((ActionEvent ae) -> {
            addFuncionario();
        }));
        
        view.getBtnBuscarFuncionario().addActionListener((ActionEvent ae) -> {
            buscarFuncionario();
        });
        
        view.getBtnCalcularSalario().addActionListener((ActionEvent ae) -> {
            calcularSalario();
        });
        
        view.getBtnAlterarLogs().addActionListener((ActionEvent ae) -> {
            alterarLogs();
        });
    }

    private void informacoesDoSistema() {
        updateNumFuncionarios();
        updateTipoLog();
        view.getLblNumVersao().setText("1.0-SNAPSHOT");
        view.getLblTipoPersistencia().setText("none");
    }

    private void addFuncionario() {
        ManterFuncionarioPresenter manterFuncionarioPresenter = new ManterFuncionarioPresenter(this, funcionarios, logs);
    }

    private void buscarFuncionario() {
        BuscarFuncionarioPresenter buscarFuncionarioPresenter = new BuscarFuncionarioPresenter(this, funcionarios, logs);
    }

    private void calcularSalario() {
        CalcularSalarioPresenter calcularSalarioPresenter = new CalcularSalarioPresenter(this, funcionarios, logs);CalcularSalarioPresenter calcularSalarioPresenter = new CalcularSalarioPresenter(this, funcionarios, logs);
    }

    private void alterarLogs() {
        SistemaDeLogsPresenter sistemaDeLogsPresenter = new SistemaDeLogsPresenter(this, logs);
    }

    private void updateNumFuncionarios() {
        view.getLblNumFuncionarios().setText(Integer.toString(funcionarios.getFuncionarios().size()));
    }

    private void updateTipoLog() {
        view.getLblTipoLogs().setText(logs.getTipo().toUpperCase());
    }
    
    public PrincipalView getView(){
        return view;
    }
    
}
