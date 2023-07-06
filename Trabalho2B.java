import java.util.Scanner;

public class Trabalho2B {

    //Método criado para realizar a tarefa de inserir na lista um cliente, a cidade do cliente, o produto, quantidade de produtos e o valor de cada produto.
    public static void inserirClientes(String [][] matriz, int linhas, int colunas) {
        Scanner scanner = new Scanner(System.in);
        int linha;

        mostrarClientes(matriz, linhas, colunas);
        do {
            System.out.println("Informe onde você deseja inserir o cliente entre a posição 1 e " + linhas + ":");
            linha = scanner.nextInt();
        } while(linha < 1 || linha > linhas);
        System.out.println("Insira o nome do cliente: ");
        matriz[linha-1][0] = scanner.next();
        System.out.println("Insira a cidade do cliente: ");
        matriz[linha-1][1] = scanner.next();
        System.out.println("Insira o nome do produto: ");
        matriz[linha-1][2] = scanner.next();
        System.out.println("Insira a quantidade de itens: ");
        matriz[linha-1][3] = scanner.next();
        System.out.println("Insira o valor unitário do produto: ");
        matriz[linha-1][4] = scanner.next();
        System.out.println("Cliente adicionado com sucesso a lista de vendas.");
    }

    //Método criado para o usuário visualizar toda a lista e onde foram inseridos os dados.
    public static void mostrarClientes(String [][] matriz, int linhas, int colunas) {
        System.out.println("Cliente | Cidade | Produto | Quantidade | Valor em R$");
        for (int i = 0; i < linhas; i++) {
            System.out.print((i + 1) + " - ");
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + " | ");

            }
            System.out.println();
        }
    }

    //Método criado para realizar a remoção de um cliente da lista, quando inserido o nome do cliente, todos os dados desse cliente serão deletados da lista.
    public static void removerClientes(String [][] matriz, int linhas, int colunas) {
        boolean encontrado = false;
        boolean nulo = false;
        Scanner scanner = new Scanner(System.in);
        String nomeCliente;

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (matriz[i][j] != null) {
                    nulo = true;
                    break;
                }
            }
            if (nulo) {
                break;
            }
        }
        if (nulo) {
            mostrarClientes(matriz, linhas, colunas);
            System.out.println("Insira o nome do cliente que deseja remover: ");
            nomeCliente = scanner.next();

            for(int i = 0; i < linhas; i++) {
                if(matriz[i][0] != null && matriz[i][0].equals(nomeCliente)) {
                    encontrado = true;
                    matriz[i][0] = null;
                    matriz[i][1] = null;
                    matriz[i][2] = null;
                    matriz[i][3] = null;
                    matriz[i][4] = null;
                }
            }
            if(encontrado) {
                System.out.println("Cliente removido com sucesso!");
            } else {
                System.out.println("Cliente não encontrado.");
            }
        } else {
            System.out.println("Não há clientes para remover.");
        }
    }

    //Método criado para o usuário remover todos os dados da lista.
    public static void esvaziarLista(String[][] matriz, int linhas, int colunas) {
        boolean nulo = false;
        boolean encontrado = false;
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Essa opção irá apagar todos os dados da sua lista de vendas.");
            System.out.println("Escolha uma das opções abaixo: ");
            System.out.println("1. Desejo esvaziar minha lista");
            System.out.println("2. Retornar ao menu inicial");
            opcao = scanner.nextInt();

            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                    if (matriz[i][j] != null) {
                        nulo = true;
                        break;
                    }
                }
                if (nulo) {
                    break;
                }
            }
            if (opcao == 1) {
                if (nulo) {
                    for (int i = 0; i < linhas; i++) {
                        for (int j = 0; j < colunas; j++) {
                            if (matriz[i][j] != null) {
                                encontrado = true;
                                matriz[i][j] = null;
                            }
                        }
                    }
                    if (encontrado) {
                        System.out.println("Sua lista foi esvaziada.");
                        opcao = 2;
                    }
                } else {
                    System.out.println("Sua lista já está vazia.");
                    opcao = 2;
                }
            } else if (opcao != 2) {
                System.out.println("Opção inválida.");
            }
        } while (opcao != 2);
    }

    //Método criado para não mostrar ao usuário uma matriz que não tenha dados.
    public static void matrizNula(String[][] matriz, int linhas, int colunas) {
        boolean encontrado = false;

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (matriz[i][j] != null) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                break;
            }
        }
        if (encontrado) {
            mostrarClientes(matriz, linhas, colunas);
        } else {
            System.out.println("Sua lista de vendas se encontra vazia.");
        }
    }

    //Método criado para o usuário calcular o valor de venda dos produtos subtraindo o valor do frete.
    public static void calcularValor(String[][] matriz, int linhas, int colunas) {
        float valorFinal = 0.0f;
        boolean encontrado = false;
        float frete = 0.0f;

        for (int i = 0; i < linhas; i++) {
            if (matriz[i][0] != null) {
                switch (matriz[i][1]) {
                    case "Londrina", "Cambe" -> frete = 4.99f;
                    case "Arapongas", "Rolandia", "Apucarana", "Ibipora", "Maringa" -> frete = 23.99f;
                    case "Curitiba", "SaoPaulo" -> frete = 69.99f;
                    case "Brasilia", "RiodeJaneiro" -> frete = 139.99f;
                    default -> System.out.println("Não foi possível calcular o frete da cidade " + matriz[i][1] + ".");
                }
                valorFinal = valorFinal - frete + Float.parseFloat(matriz[i][3]) * Float.parseFloat(matriz[i][4]);
            }
            for (int j = 0; j < colunas; j++) {
                if (matriz[i][j] != null) {
                    encontrado = true;
                    break;
                }
            }
        }
        if (encontrado) {
            System.out.println("Valor final a receber já descontando o valor do frete: R$" + valorFinal + ".");
        } else {
            System.out.println("Não há valores para realizar o cálculo.");
        }
    }

    //Método criado para o usuário visualizar a tabela de cidades e respectivamente seus valores de frete.
    public static void tabelaFrete() {
        System.out.println("Cidade | Valor do Frete");
        System.out.println("Londrina | R$ 4,99");
        System.out.println("Cambe | R$ 4,99");
        System.out.println("Arapongas | R$ 23,99");
        System.out.println("Rolandia | R$ 23,99");
        System.out.println("Ibipora | R$ 23,99");
        System.out.println("Apucarana | R$ 23,99");
        System.out.println("Maringa | R$ 23,99");
        System.out.println("Curitiba | R$ 69,99");
        System.out.println("SaoPaulo | R$ 69,99");
        System.out.println("Brasilia | R$ 139,99");
        System.out.println("RiodeJaneiro | R$ 139,99");
    }

    public static void main(String[] args) {
        String [][] lista;
        int opcao, clientes;
        int colunas = 5;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira a quantidade de clientes que serão inseridos na lista de vendas:");
        clientes = scanner.nextInt();
        lista = new String[clientes][colunas];

        do {
            System.out.println("Escolha uma das opções abaixo: \n 1 - Mostrar lista de vendas. \n 2 - Inserir cliente na lista de vendas. \n 3 - Visualizar cidades disponíveis e valores de frete.  \n 4 - Calcular valor a receber descontando o frete. \n 5 - Remover um cliente da lista de vendas. \n 6 - Esvaziar minha lista. \n 0 - Encerrar o Programa.");
            opcao = scanner.nextInt();
            switch(opcao) {
                case 0:
                    break;
                case 1:
                    matrizNula(lista, clientes, colunas);
                    break;
                case 2:
                    inserirClientes(lista, clientes, colunas);
                    break;
                case 3:
                    tabelaFrete();
                    break;
                case 4:
                    calcularValor(lista, clientes, colunas);
                    break;
                case 5:
                    removerClientes(lista, clientes, colunas);
                    break;
                case 6:
                    esvaziarLista(lista, clientes, colunas);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
        System.out.println("Encerrando...");
    }
}
