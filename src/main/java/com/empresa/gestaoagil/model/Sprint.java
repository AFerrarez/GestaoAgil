package com.empresa.gestaoagil.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Sprint {
    private final String nome;
    private final LocalDate dataInicio;
    private final LocalDate dataFim;
    private final List<Task> tasks;

    /**
     * Construtor que inicializa todos os atributos da Sprint, inclusive a lista de tarefas.
     *
     * @param nome      Nome da Sprint, não nulo.
     * @param dataInicio Data de início, não nula.
     * @param dataFim   Data de fim, não nula.
     * @param tasks     Lista de tarefas, não nula.
     */
    public Sprint(String nome, LocalDate dataInicio, LocalDate dataFim, List<Task> tasks) {
        this.nome = Objects.requireNonNull(nome, "Nome não pode ser nulo");
        this.dataInicio = Objects.requireNonNull(dataInicio, "Data de início não pode ser nula");
        this.dataFim = Objects.requireNonNull(dataFim, "Data de fim não pode ser nula");
        // Cria uma cópia imutável da lista de tarefas
        this.tasks = Collections.unmodifiableList(new ArrayList<>(Objects.requireNonNull(tasks, "Lista de tarefas não pode ser nula")));
    }

    /**
     * Construtor auxiliar que inicializa a Sprint com uma lista de tarefas vazia.
     *
     * @param nome       Nome da Sprint.
     * @param dataInicio Data de início.
     * @param dataFim    Data de fim.
     */
    public Sprint(String nome, LocalDate dataInicio, LocalDate dataFim) {
        this(nome, dataInicio, dataFim, new ArrayList<>());
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Retorna uma nova instância de Sprint com a tarefa adicionada.
     *
     * @param task Tarefa a ser adicionada.
     * @return nova instância de Sprint com a tarefa incluída.
     */
    public Sprint addTask(Task task) {
        List<Task> updatedTasks = new ArrayList<>(this.tasks);
        updatedTasks.add(task);
        return new Sprint(this.nome, this.dataInicio, this.dataFim, updatedTasks);
    }

    /**
     * Retorna uma nova instância de Sprint com a tarefa removida.
     *
     * @param task Tarefa a ser removida.
     * @return nova instância de Sprint sem a tarefa especificada.
     */
    public Sprint removeTask(Task task) {
        List<Task> updatedTasks = new ArrayList<>(this.tasks);
        updatedTasks.remove(task);
        return new Sprint(this.nome, this.dataInicio, this.dataFim, updatedTasks);
    }

    /**
     * Lista as tarefas da Sprint no console.
     */
    public void listTasks() {
        tasks.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Sprint{" +
                "nome='" + nome + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", tasks=" + tasks +
                '}';
    }
}