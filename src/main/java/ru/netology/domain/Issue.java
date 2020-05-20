package ru.netology.domain;

import lombok.Data;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Data
public class Issue {
    private int id;
    private String name;
    private String author;
    private HashSet<String> label;
    private HashSet<String> assignee;
    boolean open;

    public Issue(int id, String name, String author, HashSet<String> label, HashSet<String> assignee, boolean open) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.label = label;
        this.assignee = assignee;
        this.open = open;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", label='" + label + '\'' +
                ", assignee='" + assignee + '\'' +
                ", open=" + open;
    }

}
