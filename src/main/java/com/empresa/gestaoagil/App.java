package com.empresa.gestaoagil;

import com.empresa.gestaoagil.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class App {
    public static void main( String[] args ) {
        // Criação de usuários
    User user1 = new User("Alice", "alice@example.com", "Developer");
    User user2 = new User("Bob", "bob@example.com", "Tester");

    // Criação de tarefas
    Task task1 = new Task("Implementar login", "Criar a funcionalidade de login", TaskStatus.TODO, user1);
    Task task2 = new Task("Testar login", "Realizar testes unitários na funcionalidade de login", TaskStatus.TODO, user2);

    // Atualiza o status da task1 para IN_PROGRESS utilizando método imutável
    task1 = task1.alterarStatus(TaskStatus.IN_PROGRESS);

    // Criação de uma sprint e adição de tarefas (Sprint também deve seguir o padrão imutável)
    Sprint sprint1 = new Sprint("Sprint 1", LocalDate.now(), LocalDate.now().plusDays(14));
    sprint1 = sprint1.addTask(task1);
    sprint1 = sprint1.addTask(task2);

    // Criação do projeto e adição da sprint
    Project project = new Project("Sistema Ágil", "Projeto para gestão ágil");
    project = project.addSprint(sprint1);

    // Criação de um work item e de um registro para demonstração
    WorkItem workItem = new WorkItem("WI001", 5, new BigDecimal("150.00"));
    Registro registro = new Registro("REG001", new BigDecimal("1000.00"), 3, LocalDateTime.now());

    // Exibição dos detalhes na saída do console
        System.out.println("=== Projeto ===");
        System.out.println(project);

        System.out.println("\n=== Sprint ===");
        System.out.println(sprint1);

        System.out.println("\n=== Task 1 ===");
        task1.exibirDetalhes();

        System.out.println("\n=== WorkItem ===");
        System.out.println(workItem);

        System.out.println("\n=== Registro ===");
        System.out.println(registro);
}
}