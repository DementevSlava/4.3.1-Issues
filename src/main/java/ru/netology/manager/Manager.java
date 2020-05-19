package ru.netology.manager;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private List<Issue> issueList = new ArrayList<>();

    public List<Issue> getAllIssueList() {
        return issueList;
    }

    public List getOpen(List<Issue> issueList) {
        List<Issue> tmp = new ArrayList<>();
        for (Issue issue : issueList) {
            if (issue.isOpen()) {
                tmp.add(issue);
            }
        }
        return tmp;
    }

    public List getClose(List<Issue> issueList) {
        List<Issue> tmp = new ArrayList<>();
        for (Issue issue : issueList) {
            if (!issue.isOpen()) {
                tmp.add(issue);
            }
        }
        return tmp;
    }
}
