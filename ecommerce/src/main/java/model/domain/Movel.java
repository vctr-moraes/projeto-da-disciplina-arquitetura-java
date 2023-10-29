package model.domain;

import javax.persistence.*;

@Entity
@Table(name = "Moveis")
public class Movel extends Produto {
    private String material;
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
