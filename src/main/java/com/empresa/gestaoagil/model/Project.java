package com.empresa.gestaoagil.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Project {

    private final String name;
    private final String description;
    private final List<Sprint> sprints;

    public Project(String name, String description, List<Sprint> sprints) {
        this.name = Objects.requireNonNull(name, "O nome não pode ser nulo");
        this.description = Objects.requireNonNull(description, "A descrição não pode ser nula");
        // Cria uma cópia imutável da lista de sprints
        this.sprints = Collections.unmodifiableList(new ArrayList<>(Objects.requireNonNull(sprints, "A lista de sprints não pode ser nula")));
    }

    public Project(String name, String description) {
        this(name, description, new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public Project addSprint(Sprint sprint) {
        List<Sprint> updatedSprints = new ArrayList<>(this.sprints);
        updatedSprints.add(sprint);
        return new Project(this.name, this.description, updatedSprints);
    }

    public Project removeSprint(Sprint sprint) {
        List<Sprint> updatedSprints = new ArrayList<>(this.sprints);
        updatedSprints.remove(sprint);
        return new Project(this.name, this.description, updatedSprints);
    }

    public void listSprints() {
        sprints.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", sprints=" + sprints +
                '}';
    }




}
