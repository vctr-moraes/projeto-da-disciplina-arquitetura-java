package model.domain;

import java.util.Date;

public class Produto {
    private int codigo;
    private String nome;
    private String descricao;
    private float preco;
    private boolean estoque;
    private Date dataCadastro;
    private int tempoGarantia;

    @Override
    public String toString() {
        return String.format("%d - %s - %.2f - %s", codigo, nome, preco, dataCadastro);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public boolean isEstoque() {
        return estoque;
    }

    public void setEstoque(boolean estoque) {
        this.estoque = estoque;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getTempoGarantia() {
        return tempoGarantia;
    }

    public void setTempoGarantia(int tempoGarantia) {
        this.tempoGarantia = tempoGarantia;
    }
}
