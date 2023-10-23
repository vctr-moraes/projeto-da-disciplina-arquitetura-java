package model.domain;

public class Eletrodomestico extends Produto {
    private String tensao;
    private String cor;

    @Override
    public String toString() {
        return String.format("%s - %s - %s", super.toString(), tensao, cor);
    }

    public String getTensao() {
        return tensao;
    }

    public void setTensao(String tensao) {
        this.tensao = tensao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
