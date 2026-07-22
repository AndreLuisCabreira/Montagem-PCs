import model.*;
import service.CompatibilidadeService;
import service.ConsumoService;
import service.FPSService;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static UsuarioDAO usuarioDAO = new UsuarioDAO();
    static ProcessadorDAO processadorDAO = new ProcessadorDAO();
    static PlacaMaeDAO placaMaeDAO = new PlacaMaeDAO();
    static PlacaVideoDAO placaVideoDAO = new PlacaVideoDAO();
    static MemoriaDAO memoriaDAO = new MemoriaDAO();
    static SSDDAO ssdDAO = new SSDDAO();
    static FonteDAO fonteDAO = new FonteDAO();
    static BuildDAO buildDAO = new BuildDAO();

    static CompatibilidadeService compatibilidadeService =
            new CompatibilidadeService();

    static ConsumoService consumoService =
            new ConsumoService();

    static FPSService fpsService =
            new FPSService();

    public static int lerInteiro(String mensagem) {

        while (true) {

            System.out.print(mensagem);

            if (sc.hasNextInt()) {

                int numero = sc.nextInt();
                sc.nextLine();
                return numero;

            } else {

                System.out.println("Erro! Digite apenas números inteiros.");
                sc.nextLine();

            }

        }

    }

    public static void main(String[] args) {

        int opcao;

        do {

            System.out.println("\n========== PC BUILDER ==========");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Cadastrar Componentes");
            System.out.println("3 - Criar Build");
            System.out.println("4 - Listar Builds");
            System.out.println("5 - Buscar Build");
            System.out.println("6 - Atualizar Build");
            System.out.println("7 - Excluir Build");
            System.out.println("8 - Compatibilidade");
            System.out.println("9 - Consumo");
            System.out.println("10 - FPS");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){

                case 1:
                    cadastrarUsuario();
                    break;

                case 2:
                    cadastrarComponente();
                    break;

                case 3:
                    criarBuild();
                    break;

                case 4:
                    listarBuilds();
                    break;

                case 5:
                    buscarBuild();
                    break;

                case 6:
                    atualizarBuild();
                    break;

                case 7:
                    excluirBuild();
                    break;

                case 8:
                    testarCompatibilidade();
                    break;

                case 9:
                    calcularConsumo();
                    break;

                case 10:
                    calcularFPS();
                    break;

            }

        }while(opcao != 0);

    }

    public static void cadastrarUsuario() {

        Usuario usuario = new Usuario();

        System.out.println("\n===== CADASTRO DE USUÁRIO =====");

        System.out.print("Nome: ");
        usuario.setNome(sc.nextLine());

        System.out.print("Login: ");
        usuario.setLogin(sc.nextLine());

        System.out.print("Senha: ");
        usuario.setSenha(sc.nextLine());

        usuarioDAO.inserir(usuario);

        System.out.println("\nUsuário cadastrado com sucesso!");
    }

    public static void cadastrarComponente(){

        int op;

        do{

            System.out.println("\n===== COMPONENTES =====");

            System.out.println("1 - Processador");
            System.out.println("2 - Placa Mãe");
            System.out.println("3 - Placa de Vídeo");
            System.out.println("4 - Memória");
            System.out.println("5 - SSD");
            System.out.println("6 - Fonte");
            System.out.println("0 - Voltar");

            op = sc.nextInt();

            sc.nextLine();

            switch(op){

                case 1:

                    cadastrarProcessador();

                    break;

                case 2:

                    cadastrarPlacaMae();

                    break;

                case 3:

                    cadastrarPlacaVideo();

                    break;

                case 4:

                    cadastrarMemoria();

                    break;

                case 5:

                    cadastrarSSD();

                    break;

                case 6:

                    cadastrarFonte();

                    break;

            }

        }while(op != 0);

    }
    public static void cadastrarProcessador(){

        Processador p = new Processador();

        System.out.print("Nome: ");
        p.setNome(sc.nextLine());

        System.out.print("Preço: ");
        p.setPreco(sc.nextDouble());

        sc.nextLine();

        System.out.print("Fabricante: ");
        p.setFabricante(sc.nextLine());

        System.out.print("Socket: ");
        p.setSocket(sc.nextLine());

        System.out.print("Núcleos: ");
        p.setNucleos(sc.nextInt());

        System.out.print("Threads: ");
        p.setThreads(sc.nextInt());

        System.out.print("Consumo: ");
        p.setConsumo(sc.nextInt());

        System.out.print("Desempenho: ");
        p.setDesempenho(sc.nextDouble());

        processadorDAO.inserir(p);

        System.out.println("Processador cadastrado com sucesso!");
    }

    public static void cadastrarPlacaMae() {

        PlacaMae placaMae = new PlacaMae();

        System.out.print("Nome: ");
        placaMae.setNome(sc.nextLine());

        System.out.print("Preço: ");
        placaMae.setPreco(sc.nextDouble());
        sc.nextLine();

        System.out.print("Fabricante: ");
        placaMae.setFabricante(sc.nextLine());

        System.out.print("Socket: ");
        placaMae.setSocket(sc.nextLine());

        System.out.print("Tipo de Memória (DDR4 ou DDR5): ");
        placaMae.setTipoMemoria(sc.nextLine());

        System.out.print("Consumo (W): ");
        placaMae.setConsumo(sc.nextInt());
        sc.nextLine();

        placaMaeDAO.inserir(placaMae);

        System.out.println("\nPlaca-mãe cadastrada com sucesso!");
    }

    public static void cadastrarPlacaVideo() {

        PlacaVideo placaVideo = new PlacaVideo();

        System.out.print("Nome: ");
        placaVideo.setNome(sc.nextLine());

        System.out.print("Preço: ");
        placaVideo.setPreco(sc.nextDouble());
        sc.nextLine();

        System.out.print("Fabricante: ");
        placaVideo.setFabricante(sc.nextLine());

        System.out.print("Memória de Vídeo (GB): ");
        placaVideo.setMemoria(sc.nextInt());

        System.out.print("Consumo (W): ");
        placaVideo.setConsumo(sc.nextInt());

        System.out.print("Desempenho: ");
        placaVideo.setDesempenho(sc.nextInt());
        sc.nextLine();

        placaVideoDAO.inserir(placaVideo);

        System.out.println("\nPlaca de vídeo cadastrada com sucesso!");
    }

    public static void cadastrarMemoria() {

        Memoria memoria = new Memoria();

        System.out.print("Nome: ");
        memoria.setNome(sc.nextLine());

        System.out.print("Preço: ");
        memoria.setPreco(sc.nextDouble());
        sc.nextLine();

        System.out.print("Capacidade (GB): ");
        memoria.setCapacidade(sc.nextInt());

        System.out.print("Frequência (MHz): ");
        memoria.setFrequencia(sc.nextInt());
        sc.nextLine();

        System.out.print("Tipo (DDR4 ou DDR5): ");
        memoria.setTipo(sc.nextLine());

        memoriaDAO.inserir(memoria);

        System.out.println("\nMemória cadastrada com sucesso!");
    }

    public static void cadastrarSSD() {

        SSD ssd = new SSD();

        System.out.print("Nome: ");
        ssd.setNome(sc.nextLine());

        System.out.print("Preço: ");
        ssd.setPreco(sc.nextDouble());
        sc.nextLine();

        System.out.print("Capacidade (GB): ");
        ssd.setCapacidade(sc.nextInt());

        System.out.print("Velocidade de Leitura (MB/s): ");
        ssd.setLeitura(sc.nextInt());

        System.out.print("Velocidade de Escrita (MB/s): ");
        ssd.setEscrita(sc.nextInt());
        sc.nextLine();

        System.out.print("Tipo (SATA ou NVMe): ");
        ssd.setTipo(sc.nextLine());

        ssdDAO.inserir(ssd);

        System.out.println("\nSSD cadastrado com sucesso!");
    }

    public static void cadastrarFonte() {

        Fonte fonte = new Fonte();

        System.out.print("Nome: ");
        fonte.setNome(sc.nextLine());

        System.out.print("Preço: ");
        fonte.setPreco(sc.nextDouble());
        sc.nextLine();

        System.out.print("Potência (W): ");
        fonte.setPotencia(sc.nextInt());
        sc.nextLine();

        System.out.print("Certificação (80 Plus White, Bronze, Gold...): ");
        fonte.setCertificacao(sc.nextLine());

        fonteDAO.inserir(fonte);

        System.out.println("\nFonte cadastrada com sucesso!");
    }

    public static void criarBuild() {

        Build build = new Build();

        System.out.println("\n========== CRIAR BUILD ==========");

        System.out.print("Nome da Build: ");
        build.setNome(sc.nextLine());

        Usuario usuario;

        while (true) {

            int idUsuario = lerInteiro("Digite o ID do Usuário: ");

            usuario = usuarioDAO.buscarPorId(idUsuario);

            if (usuario != null) {

                build.setUsuarioId(idUsuario);
                break;

            }

            System.out.println("Usuário não encontrado! Digite um ID válido.");
        }

        // ==========================
        // PROCESSADOR
        // ==========================

        System.out.println("\nPROCESSADORES DISPONÍVEIS");

        for (Processador p : processadorDAO.listar()) {
            System.out.println(p);
        }

        while (true) {

            int id = lerInteiro("Escolha o ID do Processador: ");

            Processador processador = processadorDAO.buscarPorId(id);

            if (processador != null) {

                build.setProcessador(processador);
                break;

            }

            System.out.println("Processador não encontrado!");
        }

        // ==========================
        // PLACA MÃE
        // ==========================

        System.out.println("\nPLACAS-MÃE COMPATÍVEIS");

        for (PlacaMae pm : placaMaeDAO.listar()) {

            if (pm.getSocket().equalsIgnoreCase(build.getProcessador().getSocket())) {
                System.out.println(pm);
            }

        }

        PlacaMae placaMae;

        while (true) {

            int idPlacaMae = lerInteiro("Escolha o ID da Placa-Mãe: ");

            placaMae = placaMaeDAO.buscarPorId(idPlacaMae);

            if (placaMae == null) {
                System.out.println("Placa-Mãe não encontrada!");
                continue;
            }

            if (!placaMae.getSocket().equalsIgnoreCase(build.getProcessador().getSocket())) {
                System.out.println("Esta placa-mãe não é compatível com o processador escolhido!");
                continue;
            }

            build.setPlacaMae(placaMae);
            break;
        }

        // ==========================
        // PLACA DE VÍDEO
        // ==========================

        System.out.println("\nPLACAS DE VÍDEO DISPONÍVEIS");

        for (PlacaVideo pv : placaVideoDAO.listar()) {
            System.out.println(pv);
        }

        PlacaVideo placaVideo;

        while (true) {

            int idPlacaVideo = lerInteiro("Escolha o ID da Placa de Vídeo: ");

            placaVideo = placaVideoDAO.buscarPorId(idPlacaVideo);

            if (placaVideo != null) {

                build.setPlacaVideo(placaVideo);
                break;

            }

            System.out.println("Placa de Vídeo não encontrada! Digite um ID válido.");
        }

        // ==========================
        // MEMÓRIA
        // ==========================

        System.out.println("\nMEMÓRIAS DISPONÍVEIS");

        for (Memoria m : memoriaDAO.listar()) {
            System.out.println(m);
        }

        Memoria memoria;

        while (true) {

            int idMemoria = lerInteiro("Escolha o ID da Memória: ");

            memoria = memoriaDAO.buscarPorId(idMemoria);

            if (memoria != null) {

                build.setMemoria(memoria);
                break;

            }

            System.out.println("Memória não encontrada! Digite um ID válido.");
        }

        // ==========================
        // SSD
        // ==========================

        System.out.println("\nSSDs DISPONÍVEIS");

        for (SSD s : ssdDAO.listar()) {
            System.out.println(s);
        }

        SSD ssd;

        while (true) {

            int idSSD = lerInteiro("Escolha o ID do SSD: ");

            ssd = ssdDAO.buscarPorId(idSSD);

            if (ssd != null) {

                build.setSsd(ssd);
                break;

            }

            System.out.println("SSD não encontrado! Digite um ID válido.");
        }

        // ==========================
        // FONTE
        // ==========================

        System.out.println("\nFONTES DISPONÍVEIS");

        for (Fonte f : fonteDAO.listar()) {
            System.out.println(f);
        }

        Fonte fonte;

        while (true) {

            int idFonte = lerInteiro("Escolha o ID da Fonte: ");

            fonte = fonteDAO.buscarPorId(idFonte);

            if (fonte != null) {

                build.setFonte(fonte);
                break;

            }

            System.out.println("Fonte não encontrada! Digite um ID válido.");
        }

        // ==========================
        // FAVORITA
        // ==========================

        System.out.print("\nA build é favorita? (true/false): ");
        build.setFavorita(sc.nextBoolean());

        sc.nextLine();

        // ==========================
        // SALVAR
        // ==========================

        buildDAO.inserir(build);

        System.out.println("\nBuild criada com sucesso!");

    }

    public static void listarBuilds() {

        System.out.println("\n========== BUILDS CADASTRADAS ==========\n");

        if (buildDAO.listar().isEmpty()) {
            System.out.println("Nenhuma build cadastrada.");
            return;
        }

        for (Build build : buildDAO.listar()) {

            System.out.println("ID: " + build.getId());
            System.out.println("Nome: " + build.getNome());
            System.out.println("Usuário ID: " + build.getUsuarioId());

            System.out.println("Processador: " +
                    build.getProcessador().getNome());

            System.out.println("Placa-Mãe: " +
                    build.getPlacaMae().getNome());

            System.out.println("Placa de Vídeo: " +
                    build.getPlacaVideo().getNome());

            System.out.println("Memória: " +
                    build.getMemoria().getNome());

            System.out.println("SSD: " +
                    build.getSsd().getNome());

            System.out.println("Fonte: " +
                    build.getFonte().getNome());

            System.out.println("Favorita: " +
                    (build.isFavorita() ? "Sim" : "Não"));

            System.out.println("----------------------------------------");
        }
    }

    public static void buscarBuild() {

        System.out.println("\n========== BUSCAR BUILD ==========");

        System.out.print("Digite o ID da Build: ");
        int id = sc.nextInt();
        sc.nextLine();

        Build build = buildDAO.buscarPorId(id);

        if (build == null) {
            System.out.println("\nBuild não encontrada!");
            return;
        }

        System.out.println("\n========== BUILD ENCONTRADA ==========");
        System.out.println("ID: " + build.getId());
        System.out.println("Nome: " + build.getNome());
        System.out.println("Usuário ID: " + build.getUsuarioId());

        System.out.println("Processador: " +
                build.getProcessador().getNome());

        System.out.println("Placa-Mãe: " +
                build.getPlacaMae().getNome());

        System.out.println("Placa de Vídeo: " +
                build.getPlacaVideo().getNome());

        System.out.println("Memória: " +
                build.getMemoria().getNome());

        System.out.println("SSD: " +
                build.getSsd().getNome());

        System.out.println("Fonte: " +
                build.getFonte().getNome());

        System.out.println("Favorita: " +
                (build.isFavorita() ? "Sim" : "Não"));
    }

    public static void atualizarBuild() {

        System.out.println("\n========== ATUALIZAR BUILD ==========");

        System.out.print("Digite o ID da Build: ");
        int id = sc.nextInt();
        sc.nextLine();

        Build build = buildDAO.buscarPorId(id);

        if (build == null) {
            System.out.println("Build não encontrada!");
            return;
        }

        System.out.print("Novo nome da Build: ");
        build.setNome(sc.nextLine());

        System.out.println("\nUSUÁRIOS DISPONÍVEIS");

        for (Usuario u : usuarioDAO.listar()) {
            System.out.println(u);
        }

        System.out.print("ID do Usuário: ");
        build.setUsuarioId(sc.nextInt());

        // ==========================
        // PROCESSADOR
        // ==========================

        System.out.println("\nPROCESSADORES DISPONÍVEIS");

        for (Processador p : processadorDAO.listar()) {
            System.out.println(p);
        }

        System.out.print("ID do Processador: ");
        build.setProcessador(processadorDAO.buscarPorId(sc.nextInt()));

        // ==========================
        // PLACA MÃE
        // ==========================

        System.out.println("\nPLACAS-MÃE DISPONÍVEIS");

        for (PlacaMae pm : placaMaeDAO.listar()) {
            System.out.println(pm);
        }

        System.out.print("ID da Placa-Mãe: ");
        build.setPlacaMae(placaMaeDAO.buscarPorId(sc.nextInt()));

        // ==========================
        // PLACA DE VÍDEO
        // ==========================

        System.out.println("\nPLACAS DE VÍDEO DISPONÍVEIS");

        for (PlacaVideo pv : placaVideoDAO.listar()) {
            System.out.println(pv);
        }

        System.out.print("ID da Placa de Vídeo: ");
        build.setPlacaVideo(placaVideoDAO.buscarPorId(sc.nextInt()));

        // ==========================
        // MEMÓRIA
        // ==========================

        System.out.println("\nMEMÓRIAS DISPONÍVEIS");

        for (Memoria m : memoriaDAO.listar()) {
            System.out.println(m);
        }

        System.out.print("ID da Memória: ");
        build.setMemoria(memoriaDAO.buscarPorId(sc.nextInt()));

        // ==========================
        // SSD
        // ==========================

        System.out.println("\nSSDs DISPONÍVEIS");

        for (SSD s : ssdDAO.listar()) {
            System.out.println(s);
        }

        System.out.print("ID do SSD: ");
        build.setSsd(ssdDAO.buscarPorId(sc.nextInt()));

        // ==========================
        // FONTE
        // ==========================

        System.out.println("\nFONTES DISPONÍVEIS");

        for (Fonte f : fonteDAO.listar()) {
            System.out.println(f);
        }

        System.out.print("ID da Fonte: ");
        build.setFonte(fonteDAO.buscarPorId(sc.nextInt()));

        // ==========================
        // FAVORITA
        // ==========================

        System.out.print("Favorita (true/false): ");
        build.setFavorita(sc.nextBoolean());
        sc.nextLine();

        buildDAO.atualizar(build);

        System.out.println("\nBuild atualizada com sucesso!");
    }

    public static void excluirBuild() {

        System.out.println("\n========== EXCLUIR BUILD ==========");

        System.out.print("Digite o ID da Build: ");
        int id = sc.nextInt();
        sc.nextLine();

        Build build = buildDAO.buscarPorId(id);

        if (build == null) {
            System.out.println("\nBuild não encontrada!");
            return;
        }

        System.out.println("\nBuild encontrada:");
        System.out.println("ID: " + build.getId());
        System.out.println("Nome: " + build.getNome());

        System.out.print("\nDeseja realmente excluir esta build? (S/N): ");
        String resposta = sc.nextLine();

        if (resposta.equalsIgnoreCase("S")) {

            buildDAO.excluir(id);

            System.out.println("\nBuild excluída com sucesso!");

        } else {

            System.out.println("\nOperação cancelada.");

        }

    }

    public static void testarCompatibilidade() {

        System.out.println("\n========== TESTAR COMPATIBILIDADE ==========");

        System.out.print("Digite o ID da Build: ");
        int id = sc.nextInt();
        sc.nextLine();

        Build build = buildDAO.buscarPorId(id);

        if (build == null) {
            System.out.println("\nBuild não encontrada!");
            return;
        }

        boolean compativel = compatibilidadeService.verificarBuild(build);

        System.out.println("\nResultado da análise:");

        if (compativel) {

            System.out.println("A build é compatível!");

        } else {

            System.out.println("A build possui incompatibilidades!");

        }
    }

    public static void calcularConsumo() {

        System.out.println("\n========== CALCULAR CONSUMO ==========");

        int id = lerInteiro("Escolha o ID da build: ");

        Build build = buildDAO.buscarPorId(id);

        if (build == null) {
            System.out.println("\nBuild não encontrada!");
            return;
        }

        int consumo = consumoService.calcularConsumo(build);

        int recomendado = consumoService.consumoRecomendado(build);

        boolean suporta = consumoService.fonteSuporta(build);


        System.out.println("\n========== RESULTADO ==========");

        System.out.println("Build: " + build.getNome());

        System.out.println("Consumo estimado: "
                + consumo + "W");

        System.out.println("Fonte recomendada: "
                + recomendado + "W");


        if (suporta) {

            System.out.println("A fonte suporta essa configuração!");

        } else {

            System.out.println("A fonte não suporta essa configuração!");

        }

    }

    public static void calcularFPS() {

        System.out.println("\n========== CALCULAR FPS ==========");

        int id = lerInteiro("Escolha o ID da build: ");

        Build build = buildDAO.buscarPorId(id);

        if (build == null) {
            System.out.println("\nBuild não encontrada!");
            return;
        }


        Jogo jogo = new Jogo();

        System.out.print("Nome do jogo: ");
        jogo.setNome(sc.nextLine());

        System.out.print("Exigência do processador (CPU): ");
        jogo.setExigenciaCpu(sc.nextInt());

        System.out.print("Exigência da placa de vídeo (GPU): ");
        jogo.setExigenciaGpu(sc.nextInt());
        sc.nextLine();


        int fps = fpsService.calcularFPS(build, jogo);


        System.out.println("\n========== RESULTADO ==========");

        System.out.println("Build: " + build.getNome());

        System.out.println("Jogo: " + jogo.getNome());

        System.out.println("FPS estimado: " + fps);


        if (fps >= 60) {

            System.out.println("✅ Desempenho recomendado!");

        } else {

            System.out.println("⚠️ Desempenho abaixo do ideal.");

        }

    }
}