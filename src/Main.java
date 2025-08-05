import Sensores.Sensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Sensor> listaSensor = new ArrayList<>();
        List<List<Double>> dados = new ArrayList<>();

        //gera os sensores e os dados
        for(int i=1; i<=3; i++) {
            listaSensor.add(new Sensor(String.valueOf(i)));
            dados.add(gerar(i));
        }

        SistemaMonitoramento sistema = new SistemaMonitoramento();
        sistema.processarSensores(listaSensor, dados);
        sistema.exibirRelatorio();
    }

    private static List<Double> gerar(int i) {
        List<Double> lista = new ArrayList<>();
        Random rd = new Random();
        // definir valores padrão, para a geração de números seguindo o padrão da aplicação
        int limite = 60;
        int total = 100;

        if(i == 2) {
            total = total / 2;
            // ajustar geração para menos números do que o total, retornando erro
        } else if(i == 3) {
            limite = 100;
            //ajustar o limite de cada número, retornando erro
        }

        for(int j=0; j<total; j++) {
            lista.add(rd.nextDouble(-limite, limite));
        }

        return lista;
    }


}
