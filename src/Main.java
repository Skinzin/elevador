import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] andaresAtrio = {1, 4};
        int[] andaresEntrada = {-1, 2, 3, 5};
        int[] andaresBiblioteca = {2, 3};

        Elevador atrio = new Elevador(-1, 5,24, andaresAtrio);
        Elevador entrada = new Elevador(0, 2,15, andaresEntrada);
        Elevador biblioteca = new Elevador(-1, 5,15, andaresBiblioteca);


        int i = 0;
        int identifyingElevator = 0;

        do {
            if(identifyingElevator == 0) {
                identifyingElevator = setElevador(0);
            }

            Scanner selectMenu = new Scanner(System.in);
            System.out.println("\n-- M E N U --");
            System.out.println("""
                    1 - Navegar andares.
                    2 - Entrada de pessoas.
                    3 - Saída de pessoas.
                    4 - Info do elevador.
                    5 - Trocar elevador.
                    6 - Sair.
                    """);
            System.out.print("Escolha uma opção: ");
            i = selectMenu.nextInt();

            if(i == 5) {
                identifyingElevator = 0;
            }

            switch (identifyingElevator) {
                case 1:
                    executarElevador(atrio, i, identifyingElevator);
                    break;
                case 2:
                    executarElevador(entrada, i, identifyingElevator);
                    break;
                case 3:
                    executarElevador(biblioteca, i, identifyingElevator);
                    break;
                default:
                    System.out.println("Opção de elevador invalida.");
                    break;
            }
        } while(i != 6);
    }

    public static int setElevador(int novoElevador) {
        int identifyingElevator = novoElevador;

        do {
            Scanner selectElevator = new Scanner(System.in);
            System.out.println("""
                        \nQual elevador você irá utilizar?
                        1. Elevador do Atrio;
                        2. Elevador da Entrada;
                        3. Elevador da Biblioteca;
                        """);
            System.out.print("Escolha uma opção: ");
            identifyingElevator = selectElevator.nextInt();

            if(identifyingElevator < 1 || identifyingElevator > 3) {
                System.out.println("Opção de elevador invalida.");
                identifyingElevator = 0;
            }

        } while(identifyingElevator == 0);

        return identifyingElevator;
    }

    public static void executarElevador(Elevador elevador, int i, int identifyingElevator) {
        switch (i) {
            case 1:
                elevador.irPara();
                break;
            case 2:
                elevador.entrar();
                break;
            case 3:
                elevador.sair();
                break;
            case 4:
                elevador.info();
                break;
            case 5:
                setElevador(0);
                break;
            case 6:
                System.out.println("Você está descendo no andar " + identifyingElevator +  "!");
                break;
            default:
                System.out.println("Opção invalida");
                break;
        }
    }
}