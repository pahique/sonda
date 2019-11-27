package gov.nasa.marte.model;

public enum OrientacaoEnum {
    NORTE("N"),  
    SUL("S"),    
    LESTE("E"),  
    OESTE("W");   

    private String code;

    private OrientacaoEnum(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}