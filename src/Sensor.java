import Exceptions.LeituraInvalidaException;

import java.util.ArrayList;
import java.util.List;

public class Sensor {
    private String id;
    private List<Double> leituras;

    public Sensor(String id) {
        this.id = id;
        this.leituras = new ArrayList<>();
    }

    public List<Double> getLeituras() {
        return leituras;
    }

    public void registrarLeituras(List<Double> leituras) throws LeituraInvalidaException {
        if (leituras.size() != 100) {
            throw new IllegalArgumentException("O total de leituras deve ser 100");
        }

        for (int i = 0; i < this.leituras.size(); i++) {
            double temp = this.leituras.get(i);
            if(temp < -60 || temp > 60) {
                throw new LeituraInvalidaException(i, temp);
            }
        }

        this.leituras = leituras;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Sensor " + id;
    }
}
