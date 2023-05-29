import java.util.Arrays;
import java.util.Scanner;

public class Elevador {
    private int andarAtual;
    private int totalAndares;
    private int andarMin;
    private int capacidadeMaxima;
    private int pessoasAtuais;
    private int[] andaresNotAtendidos;



    public Elevador(int andarMin, int totalAndares, int capacidadePessoas, int[] andaresNotAtendidos) {
        this.andarAtual = 0; // 0 = Terreo, -1 = SubSolo
        this.pessoasAtuais = 0;
        this.andarMin = andarMin;
        this.totalAndares = totalAndares;
        this.capacidadeMaxima = capacidadePessoas;
        this.andaresNotAtendidos = andaresNotAtendidos;
    }

    private boolean floorFilter(int andar) {
        for (int i = 0; i < this.andaresNotAtendidos.length; i++) {
            if(this.andaresNotAtendidos[i] == andar) {
                System.out.println("Andar no filtro.");
                return true;
            }
        }
        return false;
    }

    public void irPara() {
        System.out.print("Para qual andar você deseja ir? ");
        Scanner andarEscolhido = new Scanner(System.in);
        int andar = andarEscolhido.nextInt();

        if(this.pessoasAtuais == 0) {
            this.pessoasAtuais += 1;
        }

        if(floorFilter(andar)) {
            System.out.println("Este elevador não para no andar " + andar);
        } else if(andar < this.andarAtual) {
            this.desce(andar);
        } else {
            this.sobe(andar);
        }
    }

    public void entrar() {
        System.out.print("Quantas pessoas irão entrar no elevador? ");
        Scanner entrada = new Scanner(System.in);
        int entradaPessoas = entrada.nextInt();
        if(entradaPessoas == this.capacidadeMaxima) {
            System.out.println("O elevador está em sua capacidade maxima");
        } else if((entradaPessoas + this.pessoasAtuais) > this.capacidadeMaxima) {
            System.out.println("O elevador excedeu a capacidade maxima, algumas pessoas terão que sair.");
        } else {
            this.pessoasAtuais += entradaPessoas;
            System.out.println("Há " + this.pessoasAtuais + " pessoa(s) no elevador.");
        }
    }

    public void sair() {
        System.out.print("Quantas pessoas irão sair do elevador? ");
        Scanner saida = new Scanner(System.in);
        int saidaPessoas = saida.nextInt();
        if(saidaPessoas <= 0) {
            System.out.println("Não há ninguém no elevador.");
        } else if ((this.pessoasAtuais - saidaPessoas) < 0) {
            System.out.println("Ops! Não há toda essa gente para sair do elevador!");
        } else {
            this.pessoasAtuais -= saidaPessoas;
            System.out.println("Há " + this.pessoasAtuais + " pessoa(s) no elevador.");
        }
    }

    private void sobe(int andar) {
        if(andar > this.totalAndares) {
            System.out.println("Você já está no ultimo andar.");
        } else if (andar == this.andarAtual) {
            System.out.println("Você já está no andar " + this.andarAtual);
        } else {
            System.out.println("Subindo para o andar: " + andar);
            this.andarAtual = andar;
        }
    }

    private void desce(int andar) {
        if(andar < this.andarMin) {
            System.out.println("Você não pode descer mais do que o andar " + this.andarMin);
        } else if (andar == this.andarAtual) {
            System.out.println("Você já está no andar " + this.andarAtual);
        } else {
            System.out.println("Descendo para o andar: " + andar);
            this.andarAtual = andar;
        }
    }

    public void info() {
        System.out.println("--- I N F O R M A Ç Õ E S ---");
        System.out.println("Você está no andar: " + this.andarAtual);
        System.out.println("Há um total de: " + this.pessoasAtuais + " pessoa(s)");
        System.out.println("A capacidade máxima deste elevador é de " + this.capacidadeMaxima + " pessoas.");
        System.out.println("Este elevador não atende os andares: " + Arrays.toString(this.andaresNotAtendidos));
        System.out.println("--- F I M ---");

    }
}
