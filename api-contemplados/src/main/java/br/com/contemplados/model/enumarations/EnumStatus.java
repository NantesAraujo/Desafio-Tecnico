package br.com.contemplados.model.enumarations;

public enum EnumStatus {

    CADASTRO_VALIDO(0, "Cadastro válido"),
    JA_POSSUI_CASA(1, "Já possui uma casa"),
    SELECIONADA_OUTRO_PROCESSO(2, "Selecionada em outro processo de seleção"),
    CADASTRO_INCOMPLETO(3, "Cadastro incompleto");

    private Integer id;
    private String valor;

    EnumStatus(int id, String valor) {
        this.id = id;
        this.valor = valor;
    }

}
