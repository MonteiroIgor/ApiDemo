package com.igor.apiDemo.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
public class RealizarServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nsu;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Funcionario funcionario;

    @ManyToOne
    private Servico servico;
    private String forma_Pagamento;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nsu == null) ? 0 : nsu.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RealizarServico other = (RealizarServico) obj;
        if (nsu == null) {
            if (other.nsu != null)
                return false;
        } else if (!nsu.equals(other.nsu))
            return false;
        return true;
    }


    public String getNsu() {
        return nsu;
    }

    public void setNsu(String nsu) {
        this.nsu = nsu;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public String getForma_Pagamento() {
        return forma_Pagamento;
    }

    public void setForma_Pagamento(String forma_Pagamento) {
        this.forma_Pagamento = forma_Pagamento;
    }
}
