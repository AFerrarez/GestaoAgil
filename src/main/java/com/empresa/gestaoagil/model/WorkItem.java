package com.empresa.gestaoagil.model;

import java.math.BigDecimal;
import java.util.Objects;

public final class WorkItem {
    private final String codigo;
    private final int quantidade;
    private final BigDecimal valor;

    /**
     * Construtor que inicializa os atributos e garante a validade dos dados.
     * @param codigo identificador único do work item.
     * @param quantidade valor que não pode ser negativo.
     * @param valor valor monetário que não pode ser nulo ou negativo.
     */
    public WorkItem(String codigo, int quantidade, BigDecimal valor) {
        this.codigo = Objects.requireNonNull(codigo, "Código não pode ser nulo");
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }
        this.quantidade = quantidade;
        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor não pode ser nulo ou negativo");
        }
        this.valor = valor;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    /**
     * Atualiza a quantidade e retorna uma nova instância de WorkItem com o novo valor.
     * @param novaQuantidade nova quantidade (deve ser não negativa).
     * @return nova instância de WorkItem com a quantidade atualizada.
     */
    public WorkItem atualizarQuantidade(int novaQuantidade) {
        if (novaQuantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }
        return new WorkItem(this.codigo, novaQuantidade, this.valor);
    }

    /**
     * Atualiza o valor e retorna uma nova instância de WorkItem com o novo valor.
     * @param novoValor novo valor (não nulo e não negativo).
     * @return nova instância de WorkItem com o valor atualizado.
     */
    public WorkItem atualizarValor(BigDecimal novoValor) {
        if (novoValor == null || novoValor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor não pode ser nulo ou negativo");
        }
        return new WorkItem(this.codigo, this.quantidade, novoValor);
    }

    @Override
    public String toString() {
        return "WorkItem{" +
                "codigo='" + codigo + '\'' +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                '}';
    }
}