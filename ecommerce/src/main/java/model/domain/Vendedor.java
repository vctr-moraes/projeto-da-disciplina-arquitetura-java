package model.domain;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Vendedores", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "documento" }),
        @UniqueConstraint(columnNames = { "email" })
})

public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@PositiveOrZero
    private int codigo;

    @Size(min = 2, max = 50)
    private String nome;

    @Column(unique = true)
    private String documento;

    @Column(unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "EnderecoId")
    private Endereco endereco;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "VendedorId")
    private List<Produto> produtos;

    @Override
    public String toString() {
        return String.format("id (%d) - nome (%s) - documento (%s) - email (%s) - endereco (%s) - produtos (%d)",
                id,
                nome,
                documento,
                email,
                endereco,
                produtos != null ? produtos.size() : 0);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}