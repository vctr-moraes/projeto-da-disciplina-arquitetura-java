package model.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Eletrodomesticos")
public class Eletrodomestico extends Produto {
	@Size(min = 2, max = 50, message = "O campo deve ter entre {min} e {max} caracteres.")
    private String tensao;
    
	@Size(min = 2, max = 50, message = "O campo deve ter entre {min} e {max} caracteres.")
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