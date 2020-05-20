package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.Repo;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private Repo repo;

    public Manager(Repo repo) {
        this.repo = repo;
    }

    public ArrayList getOpen(List<Issue> issueList) {
        ArrayList<Issue> tmp = new ArrayList<>();
        for (Issue issue : issueList) {
            if (issue.isOpen()) {
                tmp.add(issue);
            }
        }
        return tmp;
    }

    public ArrayList getClose(List<Issue> issueList) {
        ArrayList<Issue> tmp = new ArrayList<>();
        for (Issue issue : issueList) {
            if (!issue.isOpen()) {
                tmp.add(issue);
            }
        }
        return tmp;
    }

    public List filterByAuthor(String author) {
        return repo.filterByAuthor(author);
    }

    public List filterByLabel(String label) {
        return repo.filterByLabel(label);
    }

    public List filterByAssignee(String assignee) {
        return repo.filterByAssignee(assignee);
    }

    void closeById(int id) {
        Issue tmp = repo.findById(id);
        if (tmp.isOpen()) {
            tmp.setOpen(false);
        }
    }

    void openById(int id) {
        Issue tmp = repo.findById(id);
        if (!tmp.isOpen()) {
            tmp.setOpen(true);
        }
    }

    void addLabel(Issue issue, String label) {
        issue.getLabel().add(label);
    }

    void addAssignee(Issue issue, String assignee) {
        issue.getAssignee().add(assignee);
    }
}
