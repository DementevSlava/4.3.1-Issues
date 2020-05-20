package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.List;

public class Repo {

    private List<Issue> issueList;

    public Repo(List<Issue> issueList) {
        this.issueList = issueList;
    }

    public List<Issue> getAllIssueList() {
        return issueList;
    }

    public boolean add(Issue issue) {
        return issueList.add(issue);
    }

    public Issue findById(int id){
        for (Issue issue : issueList) {
            if (issue.getId() == id){
                return issue;
            }
        }
        return null;
    }

    public List filterByAuthor(String author) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : issueList) {
            if (author.equals(issue.getAuthor())) {
                result.add(issue);
            }
        }
        return result;
    }

    public List filterByLabel(String label) {
        List<Issue> tmp = new ArrayList<>();
        for (Issue issue : issueList) {
            for (String s : issue.getLabel()) {
                if (s.equals(label)) {
                    tmp.add(issue);
                }
            }
        }
        return tmp;
    }

    public List filterByAssignee(String assignee) {
        List<Issue> tmp = new ArrayList<>();
        for (Issue issue : issueList) {
            for (String s : issue.getAssignee()) {
                if (s.equals(assignee)) {
                    tmp.add(issue);
                }
            }
        }
        return tmp;
    }


}
