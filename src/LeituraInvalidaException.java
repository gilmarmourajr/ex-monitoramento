public class LeituraInvalidaException extends RuntimeException {
    public LeituraInvalidaException(int index, double temperatura) {
        super("Leitura inválida na posição " + index + ": " + temperatura);
    }
}
