package gov.nasa.marte.sonda.model;

public enum MovimentoEnum {
    L("Girar à esquerda"),
    R("Girar à direita"),
    M("Mover-se para frente");

    private String descricao;

    private MovimentoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}