import Exceptions.LeituraInvalidaException;
import Sensores.ErroSensor;
import Sensores.Sensor;

import java.util.ArrayList;
import java.util.List;

public class SistemaMonitoramento {
    private List<Sensor> sensoresValidos;
    private List<ErroSensor> sensoresComErro;

    public SistemaMonitoramento() {
        sensoresValidos = new ArrayList<>();
        sensoresComErro = new ArrayList<>();
    }

    public void exibirRelatorio() {
        String aux = "";

        aux += "===== SENSORES VÁLIDOS =====\n";
        for(Sensor sensor : sensoresValidos) {
            aux += "Sensor: " + sensor.getId() + "\n";
        }

        aux += "===== SENSORES COM ERRO =====\n";
        for(ErroSensor sensor : sensoresComErro) {
            aux += "Sensor: " + sensor.getId() + "\n" +
                    sensor.getMensagemErro();
        }

        System.out.println(aux);
    }

    public void processarSensores(List<Sensor> sensores, List<List<Double>> dados) {
        for(int i=0; i<sensores.size(); i++) {
            Sensor sensor = sensores.get(i);
            List<Double> leitura = dados.get(i);
            try {
                sensor.registrarLeituras(leitura);
                sensoresValidos.add(sensor);
            }
            catch (LeituraInvalidaException | IllegalArgumentException e) {
                sensoresComErro.add(new ErroSensor(sensor.getId(), e.toString()));
            }
        }
    }
}
