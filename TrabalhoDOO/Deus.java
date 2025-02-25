public class Deus extends Personagem implements HabilidadeEspecial {
    public Deus(String nome) {
        super(nome, 100, 15, 10);
    }

    @Override
    // Deus recupera 30 de vida ao usar a habilidade
    public void habilidadeEspecial(Personagem oponente) {
        this.setVida(this.getVida() + 30);
        System.out.println(this.getNome() + " usou sua habilidade especial e recuperou 30 de vida!");
    }
}