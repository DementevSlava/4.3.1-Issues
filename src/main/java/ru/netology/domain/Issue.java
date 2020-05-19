package ru.netology.domain;

import lombok.Getter;

@Getter
public class Issue {
    private int id;
    private String name;
    private String author;
    private String label;
    private String assignee;
    boolean open = true;

    public Issue(int id, String name, String author, String label, String assignee, boolean open) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.label = label;
        this.assignee = assignee;
        this.open = open;
    }
}
