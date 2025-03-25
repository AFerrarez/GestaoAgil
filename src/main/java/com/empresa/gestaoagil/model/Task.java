package com.empresa.gestaoagil.model;

import java.util.Objects;

public final class Task {

    private final String title;
    private final String description;
    private final TaskStatus status;
    private final User responsavel;

    public Task(String title, String description, TaskStatus status, User responsavel) {
        this.title = Objects.requireNonNull(title, "O título não pode ser nulo");
        this.description = Objects.requireNonNull(description, "A descrição não pode ser nula");
        this.status = Objects.requireNonNull(status, "O status não pode ser nulo");
        this.responsavel = responsavel;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public User getResponsavel() {
        return responsavel;
    }

    /**
     * Método que altera o status da tarefa.
     * Em vez de modificar o objeto atual, ele retorna uma nova instância de Task com o novo status.
     */
    public Task alterarStatus(TaskStatus novoStatus) {
        return new Task(this.title, this.description, novoStatus, this.responsavel);
    }

    /**
     * Método que atribui um novo responsável à tarefa.
     * Também retorna uma nova instância de Task com o novo responsável.
     */
    public Task atribuirResponsavel(User novoResponsavel) {
        return new Task(this.title, this.description, this.status, novoResponsavel);
    }

    /**
     * Exibe os detalhes da tarefa no console.
     */
    public void exibirDetalhes() {
        System.out.println("Título: " + title);
        System.out.println("Descrição: " + description);
        System.out.println("Status: " + status);
        System.out.println("Responsável: " + (responsavel != null ? responsavel.getNome() : "Nenhum"));
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", responsavel=" + (responsavel != null ? responsavel.getNome() : "Nenhum") +
                '}';
    }
}
