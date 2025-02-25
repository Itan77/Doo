
public class Guerreiro extends Personagem implements HabilidadeEspecial {
    public Guerreiro(String nome) {
        super(nome, 80, 18, 7); 
    }

    @Override
     // Guerreiro causa dano  extra ao usar a habilidade especial
    public void habilidadeEspecial(Personagem oponente) {
        int danoExtra = 10; 
        int danoTotal = this.getDanoBase() + danoExtra;

        
        oponente.setVida(oponente.getVida() - danoTotal);

        System.out.println(this.getNome() + " usou sua habilidade especial e causou " + danoTotal + " de dano!");
    }
}