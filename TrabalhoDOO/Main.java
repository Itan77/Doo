import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Personagem jogador1;
        Personagem jogador2;

        try {
            System.out.println("Bem vido ao Fighting Game ! ");

            System.out.println("Escolha seu personagem :");
            System.out.println("1- Kratos");
            System.out.println("2- Merlin");
            System.out.println("3- Kuririn");
            System.out.println("4- Goku");
            System.out.println("5- Vegeta");

            jogador1 = escolherPersonagem(teclado.nextInt());
            System.out.println("Jogador 1 escolheu: " + jogador1.nome);

            System.out.println("Escolha o personagem do Jogador 2:");
            jogador2 = escolherPersonagem(teclado.nextInt());
            System.out.println("Jogador 2 escolheu: " + jogador2.nome);

            while (jogador1.estaVivo() && jogador2.estaVivo()) {
                turno(jogador1, jogador2, teclado);
                if (!jogador2.estaVivo())
                    break;
                turno(jogador2, jogador1, teclado);
            }

            if (jogador1.estaVivo()) {
                System.out.println("Game Over!  The Winner is : " + jogador1.nome);
            } else {
                System.out.println("Game Over!  The Winner is : " + jogador2.nome);
            }
        } catch (Exception e) {
            System.out.println("Erro na entrada de dados. Certifique-se de inserir um número válido.");
        }
    }

    /*
     * A exceção Exception não pode ser lançada diretamente de um método sem ser
     * declarada na assinatura do método.
     */
    public static Personagem escolherPersonagem(int escolha) throws Exception {
        switch (escolha) {
            case 1:
                return new Deus("Kratos");
            case 2:
                return new Mago("Merlin");
            case 3:
                return new Guerreiro("Kuririn");
            case 4:
                return new Sayajin("Goku");
            case 5:
                return new Sayajin("Vegeta",100,18,10);               
            default:
                throw new Exception("Escolha inválida!");
        }
    }

    /*
     * O Scanner é usado como um parâmetro para permitir que a
     * função turno acesse o objeto de entrada do usuário,
     * sem ter que criar um novo Scanner
     */

    public static void turno(Personagem jogador, Personagem oponente, Scanner teclado) {
        System.out.println("\nTurno de " + jogador.nome + "! Escolha sua ação:");
        System.out.println("[1]- Atacar  [2]- Curar  [3]- Habilidade Especial");
        try {
            int escolha = teclado.nextInt();
            switch (escolha) {
                case 1:
                    jogador.atacar(oponente);
                    break;
                case 2:
                    jogador.curar();
                    break;
                case 3:
                    jogador.habilidadeEspecial(oponente);
                    break;
                default:
                    System.out.println("Escolha inválida!");
                    break;
            }
            System.out.println("Vida de " + jogador.nome + ": " + jogador.vida);
            System.out.println("Vida de " + oponente.nome + ": " + oponente.vida);
        } catch (Exception e) {
            System.out.println("Erro:opção inválida .Escolha um número entre 1 e 3.");
            teclado.next();
        }
    }
}
