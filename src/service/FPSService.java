package service;

import model.Build;
import model.Jogo;

public class FPSService {

    public int calcularFPS(Build build, Jogo jogo) {

        if (build == null ||
                build.getProcessador() == null ||
                build.getPlacaVideo() == null ||
                jogo == null) {

            return 0;
        }

        double desempenhoCPU = build.getProcessador().getDesempenho();
        int desempenhoGPU = build.getPlacaVideo().getDesempenho();

        int exigenciaCPU = Math.max(1, jogo.getExigenciaCpu());
        int exigenciaGPU = Math.max(1, jogo.getExigenciaGpu());

        double fatorCPU = desempenhoCPU / exigenciaCPU;
        double fatorGPU = desempenhoGPU / (double) exigenciaGPU;

        double cpuScore = Math.min(1.0, fatorCPU);
        double gpuScore = Math.min(1.0, fatorGPU);

        double fatorFinal = 0.6 * cpuScore + 0.4 * Math.min(cpuScore, gpuScore);

        int fps = (int) Math.round(85 * Math.max(0.2, fatorFinal));

        if (fps < 15) {
            fps = 15;
        }

        if (fps > 300) {
            fps = 300;
        }

        return fps;
    }

}