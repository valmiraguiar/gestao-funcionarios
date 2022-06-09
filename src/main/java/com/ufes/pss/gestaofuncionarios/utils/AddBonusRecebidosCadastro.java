package com.ufes.pss.gestaofuncionarios.utils;

import com.ufes.pss.gestaofuncionarios.model.Funcionario;
import com.ufes.pss.gestaofuncionarios.model.Bonus;
import java.time.LocalDate;

public class AddBonusRecebidosCadastro {
    
    public static void addBonusRecebidoCadastro(Funcionario funcionario, String bonusInicial) {
        bonusNormalGeneroso(funcionario, bonusInicial);
        bonusFuncionarioDoMes(funcionario);
        bonusAnosDeServico(funcionario);
        bonusFaltas(funcionario);

    }

    private static void bonusFuncionarioDoMes(Funcionario funcionario) {
        if (funcionario.isFuncionarioDoMes()) {
            funcionario.addBonus(new Bonus("Funcionario do Mes", 0.10));
        }

    }

    private static void bonusNormalGeneroso(Funcionario funcionario, String bonusInicial) {

        if (bonusInicial.toLowerCase().equals("normal")) {
            funcionario.addBonus(new Bonus("Normal", 0.05));
        }

        if (bonusInicial.toLowerCase().equals("generoso")) {
            funcionario.addBonus(new Bonus("Generoso", 0.15));
        }

    }

    private static void bonusAnosDeServico(Funcionario funcionario) {
        if ((LocalDate.now().getYear() - funcionario.getAdmissao().getYear()) >= 1
                && (LocalDate.now().getYear() - funcionario.getAdmissao().getYear()) <= 5) {
            funcionario.addBonus(new Bonus("1-5 Anos de Serviço", 0.02));
        } else if ((LocalDate.now().getYear() - funcionario.getAdmissao().getYear()) <= 10) {
            funcionario.addBonus(new Bonus("6-10 Anos de Serviço", 0.03));
        } else if ((LocalDate.now().getYear() - funcionario.getAdmissao().getYear()) <= 15) {
            funcionario.addBonus(new Bonus("11-15 Anos de Serviço", 0.08));
        } else if ((LocalDate.now().getYear() - funcionario.getAdmissao().getYear()) <= 20) {
            funcionario.addBonus(new Bonus("16-20 Anos de Serviço", 0.10));
        } else {
            funcionario.addBonus(new Bonus("20+ Anos de Serviço", 0.15));
        }

    }

    private static void bonusFaltas(Funcionario funcionario) {
        if (funcionario.getNumFaltas() == 0) {
            funcionario.addBonus(new Bonus("0 Faltas", 0.1));
        } else if (funcionario.getNumFaltas() <= 3) {
            funcionario.addBonus(new Bonus("1-3 Faltas", 0.05));
        } else {
            funcionario.addBonus(new Bonus("4+ Faltas", 0.01));
        }

    }

}
