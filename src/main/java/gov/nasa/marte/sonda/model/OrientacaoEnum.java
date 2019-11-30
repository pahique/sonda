package gov.nasa.marte.sonda.model;

public enum OrientacaoEnum {
    N("Norte"),  
    S("Sul"),    
    E("Leste"),  
    W("Oeste");   

    private String descricao;

    private OrientacaoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}