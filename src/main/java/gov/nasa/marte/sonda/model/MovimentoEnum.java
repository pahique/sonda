package gov.nasa.marte.sonda.model;

public enum MovimentoEnum {
    GIRAR_ESQUERDA("L"),
    GIRAR_DIREITA("R"),
    MOVER_FRENTE("M");

    private String codigo;

    private MovimentoEnum(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return codigo;
    }

    public static MovimentoEnum fromCodigo(String codigo) {
        MovimentoEnum result = null;
        for(MovimentoEnum value : values()) {
            if(value.getCodigo().equalsIgnoreCase(codigo)) {
                result = value;
            }
        }        
        return result;
    }
    
}