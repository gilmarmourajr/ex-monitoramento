package Sensores;

public class ErroSensor {
    public ErroSensor(String idSensor, String mensagemErro) {
        this.idSensor = idSensor;
        this.mensagemErro = mensagemErro;
    }

    private String idSensor;
    private String mensagemErro;

    public String getId() {
        return idSensor;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }
}
