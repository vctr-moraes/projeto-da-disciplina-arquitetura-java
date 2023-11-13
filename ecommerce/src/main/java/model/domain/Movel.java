package model.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Moveis")
public class Movel extends Produto {
	@Size(min = 2, max = 50, message = "O campo deve ter entre {min} e {max} caracteres.")
    private String material;

	@Size(min = 2, max = 50, message = "O campo deve ter entre {min} e {max} caracteres.")
    private String cor;

    @Override
    public String toString() {
        return String.format("%s - %s - %s", super.toString(), material, cor);
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}