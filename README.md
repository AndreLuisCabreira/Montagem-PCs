# 🖥️ PC Builder - Montagem de PCs

Um sistema completo em Java para construir, gerenciar e analisar configurações de computadores. O aplicativo permite que usuários criem builds personalizadas, verifiquem compatibilidade entre componentes e estimem desempenho em jogos.

## 📋 Sobre o Projeto

**PC Builder** é uma aplicação console em Java que funciona como um assistente inteligente para montagem de PCs. Ele oferece um conjunto robusto de funcionalidades para:

- ✅ Cadastro e gerenciamento de usuários
- ✅ Cadastro de componentes de hardware (processador, placa-mãe, placa de vídeo, memória, SSD, fonte)
- ✅ Criação de builds personalizadas
- ✅ Verificação automática de compatibilidade entre componentes
- ✅ Cálculo de consumo de energia
- ✅ Estimativa de FPS em jogos

## 🛠️ Tecnologias

- **Linguagem:** Java
- **IDE:** IntelliJ IDEA
- **Arquitetura:** MVC (Model-View-Controller)
- **Padrão de Design:** DAO (Data Access Object)
- **Estrutura:** Console Application

## 📁 Estrutura do Projeto

```
src/
├── Main.java                           Interface de linha de comando
├── model/                              Entidades do domínio
│   ├── Usuario.java                    Usuário do sistema
│   ├── Processador.java                Componente CPU
│   ├── PlacaMae.java                   Componente placa-mãe
│   ├── PlacaVideo.java                 Componente GPU
│   ├── Memoria.java                    Componente RAM
│   ├── SSD.java                        Componente armazenamento
│   ├── Fonte.java                      Componente fonte de energia
│   ├── Build.java                      Configuração completa de PC
│   └── Jogo.java                       Requisitos de jogo
├── dao/                                Persistência de dados
│   ├── UsuarioDAO.java
│   ├── ProcessadorDAO.java
│   ├── PlacaMaeDAO.java
│   ├── PlacaVideoDAO.java
│   ├── MemoriaDAO.java
│   ├── SSDDAO.java
│   ├── FonteDAO.java
│   └── BuildDAO.java
└── service/                            Lógica de negócio
    ├── CompatibilidadeService.java     Verifica compatibilidade
    ├── ConsumoService.java             Calcula consumo de energia
    └── FPSService.java                 Estima desempenho em jogos
```

## ⚙️ Como Funciona

### Fluxo de Operação

1. **Menu Principal** - Apresenta 10 opções de funcionalidades
2. **Cadastro** - Usuários e componentes são cadastrados no sistema
3. **Criar Build** - O sistema constrói uma configuração validando:
   - Compatibilidade de socket (CPU ↔ Placa-mãe)
   - Compatibilidade de memória (RAM ↔ Placa-mãe)
4. **Análise** - Fornece informações sobre:
   - Consumo total de energia
   - Potência recomendada da fonte (com margem de 20%)
   - Estimativa de FPS em jogos

### Algoritmo de Compatibilidade
- Verifica se o **socket do processador** é compatível com a placa-mãe
- Valida se o **tipo de memória** (DDR4/DDR5) é suportado pela placa-mãe

### Cálculo de Consumo
```
Consumo Total = CPU + Placa-Mãe + GPU + Memória(5W) + SSD(5W)
Consumo Recomendado = Consumo Total × 1.20 (margem de segurança)
```

### Estimativa de FPS
```
Fator CPU = Desempenho CPU / Exigência CPU
Fator GPU = Desempenho GPU / Exigência GPU
Fator Final = (Fator CPU + Fator GPU) / 2
FPS = 60 × Fator Final (limitado entre 15 e 300)
```

## 🚀 Como Executar

### Pré-requisitos
- Java 8+ instalado
- IDE IntelliJ IDEA ou compilador `javac`

### Passos

1. **Clone o repositório**
   ```bash
   git clone https://github.com/AndreLuisCabreira/Montagem-PCs.git
   cd Montagem-PCs
   ```

2. **Compile o projeto**
   ```bash
   javac src/**/*.java -d out
   ```

3. **Execute a aplicação**
   ```bash
   java -cp out Main
   ```

4. **Navegue pelo menu**
   - Digite `1` para cadastrar usuário
   - Digite `2` para cadastrar componentes
   - Digite `3` para criar uma build
   - Digite `8` para verificar compatibilidade
   - Digite `0` para sair

## 📊 Funcionalidades Principais

### 1️⃣ Cadastrar Usuário
Cria um novo usuário no sistema com nome, login e senha.

### 2️⃣ Cadastrar Componentes
Menu para cadastrar 6 tipos de componentes:
- **Processador** (socket, núcleos, threads, consumo, desempenho)
- **Placa-Mãe** (socket, tipo de memória, consumo)
- **Placa de Vídeo** (memória VRAM, consumo, desempenho)
- **Memória RAM** (capacidade, frequência, tipo DDR)
- **SSD** (capacidade, velocidade leitura/escrita)
- **Fonte** (potência, certificação)

### 3️⃣ Criar Build
Cria uma configuração completa de PC:
- Seleciona usuário responsável
- Escolhe 1 processador
- Filtra placas-mãe compatíveis por socket
- Valida compatibilidade de socket e memória
- Seleciona GPU, RAM, SSD, Fonte
- Marca como favorita opcionalmente

### 4️⃣ Gerenciar Builds
- **Listar** - Exibe todas as builds cadastradas
- **Buscar** - Localiza build por ID
- **Atualizar** - Modifica configuração existente
- **Excluir** - Remove build com confirmação

### 5️⃣ Testar Compatibilidade
Verifica se uma build possui:
- ✅ Socket compatível (CPU ↔ Placa-Mãe)
- ✅ Memória compatível (DDR Type)

### 6️⃣ Calcular Consumo
Estima:
- Consumo total em watts
- Potência mínima recomendada para a fonte
- Se a fonte atual suporta a configuração

### 7️⃣ Calcular FPS
Prevê o desempenho em jogos:
- Solicita exigências de CPU e GPU do jogo
- Retorna FPS estimado
- Indica se atinge ≥60 FPS (desempenho recomendado)

## 📝 Exemplos de Uso

### Criar uma Build Gamer
```
1. Cadastrar usuário "João" (ID: 1)
2. Cadastrar componentes gamer:
   - AMD Ryzen 7 5700X (8-cores, socket AM4)
   - ASUS TUF B550 (socket AM4, DDR4)
   - RTX 3070 Ti (8GB VRAM, 350W)
   - Corsair 32GB DDR4 3600MHz
   - Samsung 970 EVO Plus 1TB NVMe
   - Corsair RM850x 850W Gold
3. Criar build com esses componentes
4. Testar compatibilidade → ✅ Compatível!
5. Calcular consumo → 450W consumo, 540W recomendado
6. Calcular FPS em Cyberpunk 2077
```

## 🔍 Validações e Regras

| Regra | Descrição |
|-------|-----------|
| **Socket** | CPU e Placa-Mãe devem ter mesmo socket |
| **Memória** | Tipo de RAM deve ser suportado pela Placa-Mãe |
| **Consumo** | Fonte deve suportar consumo + margem de 20% |
| **FPS** | Limitado entre 15 FPS (mínimo) e 300 FPS (máximo) |

## 🐛 Possíveis Melhorias Futuras

- [ ] Integração com banco de dados (MySQL/PostgreSQL)
- [ ] Interface gráfica (Swing/JavaFX)
- [ ] Cálculo de custo total da build
- [ ] Validação de preços e compatibilidade com mercado real
- [ ] Recomendações automáticas de builds por categoria
- [ ] Sistema de avaliação e comentários de builds
- [ ] Exportação de builds em PDF
- [ ] API REST para integração web

## 👨‍💻 Desenvolvedor

**André Luis Cabreira**  
📧 [GitHub](https://github.com/AndreLuisCabreira)

## 📄 Licença

Este projeto é de uso livre para fins educacionais.

---

**Versão:** 1.0.0  
**Data:** Julho 2026  
**Status:** ✅ Funcional
