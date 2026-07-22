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

        int exigenciaCPU = jogo.getExigenciaCpu();
        int exigenciaGPU = jogo.getExigenciaGpu();

        double fatorCPU = (double) desempenhoCPU / exigenciaCPU;
        double fatorGPU = (double) desempenhoGPU / exigenciaGPU;

        double fatorFinal = (fatorCPU + fatorGPU) / 2;

        int fps = (int) (60 * fatorFinal);

        if (fps < 15)
            fps = 15;

        if (fps > 300)
            fps = 300;

        return fps;
    }

}