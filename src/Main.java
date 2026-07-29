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
            String entrada = sc.nextLine().trim();

            if (entrada.isEmpty()) {
                System.out.println("Erro! O campo não pode ficar vazio.");
                continue;
            }

            if (entrada.matches("\\d+")) {

                int numero = Integer.parseInt(entrada);

                if (numero < 0) {
                    System.out.println("Erro! O número não pode ser negativo.");
                    continue;
                }

                return numero;

            } else {

                System.out.println("Erro! Digite apenas números inteiros.");

            }

        }

    }

    public static double lerDouble(String mensagem) {

        while (true) {

            System.out.print(mensagem);
            String entrada = sc.nextLine().trim();

            if (entrada.isEmpty()) {
                System.out.println("Erro! O campo não pode ficar vazio.");
                continue;
            }

            try {
                double numero = Double.parseDouble(entrada);

                if (numero < 0) {
                    System.out.println("Erro! O número não pode ser negativo.");
                    continue;
                }

                return numero;
            } catch (NumberFormatException e) {
                System.out.println("Erro! Digite apenas números válidos.");
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

            opcao = lerInteiro("Escolha: ");

            if (opcao < 0 || opcao > 10) {
                System.out.println("Opção inválida! Digite um número entre 0 e 10.");
                continue;
            }

            switch (opcao) {

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

        } while (opcao != 0);

    }

    public static void cadastrarUsuario() {

        Usuario usuario = new Usuario();

        System.out.println("\n===== CADASTRO DE USUÁRIO =====");

        String nome;
        do {
            System.out.print("Nome: ");
            nome = sc.nextLine().trim();
            if (nome.isEmpty()) {
                System.out.println("Erro! O nome não pode ficar vazio.");
            }
        } while (nome.isEmpty());
        usuario.setNome(nome);

        String login;
        do {
            System.out.print("Login: ");
            login = sc.nextLine().trim();
            if (login.isEmpty()) {
                System.out.println("Erro! O login não pode ficar vazio.");
            }
        } while (login.isEmpty());
        usuario.setLogin(login);

        String senha;
        do {
            System.out.print("Senha: ");
            senha = sc.nextLine().trim();
            if (senha.isEmpty()) {
                System.out.println("Erro! A senha não pode ficar vazia.");
            }
        } while (senha.isEmpty());
        usuario.setSenha(senha);

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

        String nome;
        do {
            System.out.print("Nome: ");
            nome = sc.nextLine().trim();
            if (nome.isEmpty()) {
                System.out.println("Erro! O nome não pode ficar vazio.");
            }
        } while (nome.isEmpty());
        p.setNome(nome);

        p.setPreco(lerDouble("Preço: "));

        String fabricante;
        do {
            System.out.print("Fabricante: ");
            fabricante = sc.nextLine().trim();
            if (fabricante.isEmpty()) {
                System.out.println("Erro! O fabricante não pode ficar vazio.");
            }
        } while (fabricante.isEmpty());
        p.setFabricante(fabricante);

        String socket;
        do {
            System.out.print("Socket: ");
            socket = sc.nextLine().trim();
            if (socket.isEmpty()) {
                System.out.println("Erro! O socket não pode ficar vazio.");
            }
        } while (socket.isEmpty());
        p.setSocket(socket);

        p.setNucleos(lerInteiro("Núcleos: "));

        p.setThreads(lerInteiro("Threads: "));

        p.setConsumo(lerInteiro("Consumo: "));

        p.setDesempenho(lerDouble("Desempenho: "));

        processadorDAO.inserir(p);

        System.out.println("Processador cadastrado com sucesso!");
    }

    public static void cadastrarPlacaMae() {

        PlacaMae placaMae = new PlacaMae();

        String nome;
        do {
            System.out.print("Nome: ");
            nome = sc.nextLine().trim();
            if (nome.isEmpty()) {
                System.out.println("Erro! O nome não pode ficar vazio.");
            }
        } while (nome.isEmpty());
        placaMae.setNome(nome);

        placaMae.setPreco(lerDouble("Preço: "));

        String fabricante;
        do {
            System.out.print("Fabricante: ");
            fabricante = sc.nextLine().trim();
            if (fabricante.isEmpty()) {
                System.out.println("Erro! O fabricante não pode ficar vazio.");
            }
        } while (fabricante.isEmpty());
        placaMae.setFabricante(fabricante);

        String socket;
        do {
            System.out.print("Socket: ");
            socket = sc.nextLine().trim();
            if (socket.isEmpty()) {
                System.out.println("Erro! O socket não pode ficar vazio.");
            }
        } while (socket.isEmpty());
        placaMae.setSocket(socket);

        String tipoMemoria;
        do {
            System.out.print("Tipo de Memória (DDR4 ou DDR5): ");
            tipoMemoria = sc.nextLine().trim();
            if (tipoMemoria.isEmpty()) {
                System.out.println("Erro! O tipo de memória não pode ficar vazio.");
            }
        } while (tipoMemoria.isEmpty());
        placaMae.setTipoMemoria(tipoMemoria);

        placaMae.setConsumo(lerInteiro("Consumo (W): "));

        placaMaeDAO.inserir(placaMae);

        System.out.println("\nPlaca-mãe cadastrada com sucesso!");
    }

    public static void cadastrarPlacaVideo() {

        PlacaVideo placaVideo = new PlacaVideo();

        String nome;
        do {
            System.out.print("Nome: ");
            nome = sc.nextLine().trim();
            if (nome.isEmpty()) {
                System.out.println("Erro! O nome não pode ficar vazio.");
            }
        } while (nome.isEmpty());
        placaVideo.setNome(nome);

        placaVideo.setPreco(lerDouble("Preço: "));

        String fabricante;
        do {
            System.out.print("Fabricante: ");
            fabricante = sc.nextLine().trim();
            if (fabricante.isEmpty()) {
                System.out.println("Erro! O fabricante não pode ficar vazio.");
            }
        } while (fabricante.isEmpty());
        placaVideo.setFabricante(fabricante);

        placaVideo.setMemoria(lerInteiro("Memória de Vídeo (GB): "));

        placaVideo.setConsumo(lerInteiro("Consumo (W): "));

        placaVideo.setDesempenho(lerInteiro("Desempenho: "));

        placaVideoDAO.inserir(placaVideo);

        System.out.println("\nPlaca de vídeo cadastrada com sucesso!");
    }

    public static void cadastrarMemoria() {

        Memoria memoria = new Memoria();

        String nome;
        do {
            System.out.print("Nome: ");
            nome = sc.nextLine().trim();
            if (nome.isEmpty()) {
                System.out.println("Erro! O nome não pode ficar vazio.");
            }
        } while (nome.isEmpty());
        memoria.setNome(nome);

        memoria.setPreco(lerDouble("Preço: "));

        memoria.setCapacidade(lerInteiro("Capacidade (GB): "));

        memoria.setFrequencia(lerInteiro("Frequência (MHz): "));

        String tipo;
        do {
            System.out.print("Tipo (DDR4 ou DDR5): ");
            tipo = sc.nextLine().trim();
            if (tipo.isEmpty()) {
                System.out.println("Erro! O tipo não pode ficar vazio.");
            }
        } while (tipo.isEmpty());
        memoria.setTipo(tipo);

        memoriaDAO.inserir(memoria);

        System.out.println("\nMemória cadastrada com sucesso!");
    }

    public static void cadastrarSSD() {

        SSD ssd = new SSD();

        String nome;
        do {
            System.out.print("Nome: ");
            nome = sc.nextLine().trim();
            if (nome.isEmpty()) {
                System.out.println("Erro! O nome não pode ficar vazio.");
            }
        } while (nome.isEmpty());
        ssd.setNome(nome);

        ssd.setPreco(lerDouble("Preço: "));

        ssd.setCapacidade(lerInteiro("Capacidade (GB): "));

        ssd.setLeitura(lerInteiro("Velocidade de Leitura (MB/s): "));

        ssd.setEscrita(lerInteiro("Velocidade de Escrita (MB/s): "));

        String tipo;
        do {
            System.out.print("Tipo (SATA ou NVMe): ");
            tipo = sc.nextLine().trim();
            if (tipo.isEmpty()) {
                System.out.println("Erro! O tipo não pode ficar vazio.");
            }
        } while (tipo.isEmpty());
        ssd.setTipo(tipo);

        ssdDAO.inserir(ssd);

        System.out.println("\nSSD cadastrada com sucesso!");
    }

    public static void cadastrarFonte() {

        Fonte fonte = new Fonte();

        String nome;
        do {
            System.out.print("Nome: ");
            nome = sc.nextLine().trim();
            if (nome.isEmpty()) {
                System.out.println("Erro! O nome não pode ficar vazio.");
            }
        } while (nome.isEmpty());
        fonte.setNome(nome);

        fonte.setPreco(lerDouble("Preço: "));

        fonte.setPotencia(lerInteiro("Potência (W): "));

        String certificacao;
        do {
            System.out.print("Certificação (80 Plus White, Bronze, Gold...): ");
            certificacao = sc.nextLine().trim();
            if (certificacao.isEmpty()) {
                System.out.println("Erro! A certificação não pode ficar vazia.");
            }
        } while (certificacao.isEmpty());
        fonte.setCertificacao(certificacao);

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

        int id = lerInteiro("Digite o ID da Build: ");

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

        int id = lerInteiro("Digite o ID da Build: ");

        Build build = buildDAO.buscarPorId(id);

        if (build == null) {
            System.out.println("Build não encontrada!");
            return;
        }

        String nome;
        do {
            System.out.print("Novo nome da Build: ");
            nome = sc.nextLine().trim();
            if (nome.isEmpty()) {
                System.out.println("Erro! O nome da build não pode ficar vazio.");
            }
        } while (nome.isEmpty());
        build.setNome(nome);

        while (true) {
            System.out.println("\nUSUÁRIOS DISPONÍVEIS");

            for (Usuario u : usuarioDAO.listar()) {
                System.out.println(u);
            }

            int idUsuario = lerInteiro("ID do Usuário: ");
            if (usuarioDAO.buscarPorId(idUsuario) != null) {
                build.setUsuarioId(idUsuario);
                break;
            }

            System.out.println("Erro! Esse usuário não existe. Escolha um ID da lista.");
        }

        // ==========================
        // PROCESSADOR
        // ==========================

        while (true) {
            System.out.println("\nPROCESSADORES DISPONÍVEIS");

            for (Processador p : processadorDAO.listar()) {
                System.out.println(p);
            }

            int idProcessador = lerInteiro("ID do Processador: ");
            Processador processadorSelecionado = processadorDAO.buscarPorId(idProcessador);
            if (processadorSelecionado != null) {
                build.setProcessador(processadorSelecionado);
                break;
            }

            System.out.println("Erro! Esse processador não existe. Escolha um ID da lista.");
        }

        // ==========================
        // PLACA MÃE
        // ==========================

        while (true) {
            System.out.println("\nPLACAS-MÃE DISPONÍVEIS");

            for (PlacaMae pm : placaMaeDAO.listar()) {
                System.out.println(pm);
            }

            int idPlacaMae = lerInteiro("ID da Placa-Mãe: ");
            PlacaMae placaMaeSelecionada = placaMaeDAO.buscarPorId(idPlacaMae);
            if (placaMaeSelecionada == null) {
                System.out.println("Erro! Essa placa-mãe não existe. Escolha um ID da lista.");
                continue;
            }

            if (!placaMaeSelecionada.getSocket().equalsIgnoreCase(build.getProcessador().getSocket())) {
                System.out.println("Erro! Essa placa-mãe não é compatível com o processador selecionado.");
                continue;
            }

            build.setPlacaMae(placaMaeSelecionada);
            break;
        }

        // ==========================
        // PLACA DE VÍDEO
        // ==========================

        while (true) {
            System.out.println("\nPLACAS DE VÍDEO DISPONÍVEIS");

            for (PlacaVideo pv : placaVideoDAO.listar()) {
                System.out.println(pv);
            }

            int idPlacaVideo = lerInteiro("ID da Placa de Vídeo: ");
            PlacaVideo placaVideoSelecionada = placaVideoDAO.buscarPorId(idPlacaVideo);
            if (placaVideoSelecionada != null) {
                build.setPlacaVideo(placaVideoSelecionada);
                break;
            }

            System.out.println("Erro! Essa placa de vídeo não existe. Escolha um ID da lista.");
        }

        // ==========================
        // MEMÓRIA
        // ==========================

        while (true) {
            System.out.println("\nMEMÓRIAS DISPONÍVEIS");

            for (Memoria m : memoriaDAO.listar()) {
                System.out.println(m);
            }

            int idMemoria = lerInteiro("ID da Memória: ");
            Memoria memoriaSelecionada = memoriaDAO.buscarPorId(idMemoria);
            if (memoriaSelecionada != null) {
                build.setMemoria(memoriaSelecionada);
                break;
            }

            System.out.println("Erro! Essa memória não existe. Escolha um ID da lista.");
        }

        // ==========================
        // SSD
        // ==========================

        while (true) {
            System.out.println("\nSSDs DISPONÍVEIS");

            for (SSD s : ssdDAO.listar()) {
                System.out.println(s);
            }

            int idSsd = lerInteiro("ID do SSD: ");
            SSD ssdSelecionado = ssdDAO.buscarPorId(idSsd);
            if (ssdSelecionado != null) {
                build.setSsd(ssdSelecionado);
                break;
            }

            System.out.println("Erro! Esse SSD não existe. Escolha um ID da lista.");
        }

        // ==========================
        // FONTE
        // ==========================

        while (true) {
            System.out.println("\nFONTES DISPONÍVEIS");

            for (Fonte f : fonteDAO.listar()) {
                System.out.println(f);
            }

            int idFonte = lerInteiro("ID da Fonte: ");
            Fonte fonteSelecionada = fonteDAO.buscarPorId(idFonte);
            if (fonteSelecionada != null) {
                build.setFonte(fonteSelecionada);
                break;
            }

            System.out.println("Erro! Essa fonte não existe. Escolha um ID da lista.");
        }

        // ==========================
        // FAVORITA
        // ==========================

        String favorita;
        do {
            System.out.print("Favorita (true/false): ");
            favorita = sc.nextLine().trim();
            if (!favorita.equalsIgnoreCase("true") && !favorita.equalsIgnoreCase("false")) {
                System.out.println("Erro! Digite apenas true ou false.");
            }
        } while (!favorita.equalsIgnoreCase("true") && !favorita.equalsIgnoreCase("false"));
        build.setFavorita(Boolean.parseBoolean(favorita));

        buildDAO.atualizar(build);

        System.out.println("\nBuild atualizada com sucesso!");
    }

    public static void excluirBuild() {

        System.out.println("\n========== EXCLUIR BUILD ==========");

        int id = lerInteiro("Digite o ID da Build: ");

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

        int id = lerInteiro("Digite o ID da Build: ");

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