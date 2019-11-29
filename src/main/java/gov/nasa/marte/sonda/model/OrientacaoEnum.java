package gov.nasa.marte.sonda.model;

public enum OrientacaoEnum {
    NORTE("N"),  
    SUL("S"),    
    LESTE("E"),  
    OESTE("W");   

    private String codigo;

    private OrientacaoEnum(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return codigo;
    }

    public static OrientacaoEnum fromCodigo(String codigo) {
        OrientacaoEnum result = null;
        for(OrientacaoEnum value : values()) {
            if(value.getCodigo().equalsIgnoreCase(codigo)) {
                result = value;
            }
        }        
        return result;
    }
}