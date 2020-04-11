package br.com.familia.util;

import java.time.LocalDate;

public abstract class IdadeUtil {

    public static final int calularIdade(LocalDate dataDeNascimento){
        return LocalDate.now().getYear() - dataDeNascimento.getYear();
    }
}
