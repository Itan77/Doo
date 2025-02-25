abstract class Personagem {

    protected String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    protected int vida;
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }

    protected int danoBase;
    public int getDanoBase() {
        return danoBase;
    }
    public void setDanoBase(int danoBase) {
        this.danoBase = danoBase;
    }

    protected int curaBase;
    public int getCuraBase() {
        return curaBase;
    }
    public void setCuraBase(int curaBase) {
        this.curaBase = curaBase;
    }

    protected boolean imune = false;
    public boolean isImune() {
        return imune;
    }
    public void setImune(boolean imune) {
        this.imune = imune;
    }

    public Personagem(String nome, int vida, int danoBase, int curaBase) {
        this.nome = nome;
        this.vida = vida;
        this.danoBase = danoBase;
        this.curaBase = curaBase;

    }

    public void atacar(Personagem oponente) {
        if (!oponente.imune) {
            oponente.vida -= this.danoBase;
            System.out.println(this.nome + " atacou " + oponente.nome + " causando " + this.danoBase + " de dano!");
        } else {
            System.out.println(oponente.nome + " estava imune e não sofreu dano!");
            oponente.imune = false;
        }
    }

    public void curar() {
        this.vida += this.curaBase;
        System.out.println(this.nome + " se curou e recuperou " + this.curaBase + " de vida!");
    }

    public abstract void habilidadeEspecial(Personagem oponente);

    public boolean estaVivo() {
        return this.vida > 0;
    }
}