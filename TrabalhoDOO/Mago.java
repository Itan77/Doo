public class Mago extends Personagem implements HabilidadeEspecial {
    public Mago(String nome) {
        super(nome, 100, 12, 25);
    }

    @Override
    // Mago fica  imune a dano por um turno
    public void habilidadeEspecial(Personagem oponente) {
        this.setImune(true);
        System.out.println(this.getNome() + " usou sua habilidade especial e ficará imune por um turno!");
    }
}
