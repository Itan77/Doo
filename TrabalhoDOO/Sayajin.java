class Sayajin extends Personagem implements HabilidadeEspecial {
    public Sayajin(String nome) {
        super(nome, 100, 14, 6);
    }

    public Sayajin(String nome, int vida, int danoBase, int curaBase) {
        super(nome, vida, danoBase, curaBase);
    }

    public Sayajin(String nome, int danoBase) {
        super(nome, 100, danoBase, 6);
    }

    @Override
    //Sayajin causa mais dano quanto menor sua vida
    public void habilidadeEspecial(Personagem oponente) {
        int danoExtra = (100 - this.getVida()) / 2;
        int danoTotal = this.getDanoBase() + danoExtra;
        oponente.setVida(oponente.getVida() - danoTotal);
        System.out.println(this.getNome() + " usou sua habilidade especial e causou " + danoTotal + " de dano!");
    }
}