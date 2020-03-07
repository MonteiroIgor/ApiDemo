package com.igor.apiDemo.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Agendamento;

    @ManyToOne
    private Cliente cliente;
    private Date dt_serviço;

    @ManyToOne
    private Funcionario funcionario;


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_Agendamento == null) ? 0 : id_Agendamento.hashCode());
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
        Agenda other = (Agenda) obj;
        if (id_Agendamento == null) {
            if (other.id_Agendamento != null)
                return false;
        } else if (!id_Agendamento.equals(other.id_Agendamento))
            return false;
        return true;
    }

    public Long getId_Agendamento() {
        return id_Agendamento;
    }

    public void setId_Agendamento(Long id_Agendamento) {
        this.id_Agendamento = id_Agendamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDt_serviço() {
        return dt_serviço;
    }

    public void setDt_serviço(Date dt_serviço) {
        this.dt_serviço = dt_serviço;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
