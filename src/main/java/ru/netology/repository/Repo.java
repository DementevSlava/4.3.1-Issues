package ru.netology.repository;

import ru.netology.domain.Issue;
import ru.netology.domain.IssueComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Repo {

    private List<Issue> issueList = new ArrayList<>();

    public List<Issue> getAllIssueList(IssueComparator comparator) {
        Collections.sort(issueList, comparator);
        return issueList;
    }

    public boolean add(Issue issue) {
        return issueList.add(issue);
    }

    public Issue findById(int id) {
        for (Issue issue : issueList) {
            if (issue.getId() == id) {
                return issue;
            }
        }
        return null;
    }

    public ArrayList filterByAuthor(String author) {
        ArrayList<Issue> result = new ArrayList<>();
        for (Issue issue : issueList) {
            if (author.equals(issue.getAuthor())) {
                result.add(issue);
            }
        }
        return result;
    }

    public ArrayList filterByLabel(String label) {
        ArrayList<Issue> tmp = new ArrayList<>();
        for (Issue issue : issueList) {
            for (String s : issue.getLabel()) {
                if (s.equals(label)) {
                    tmp.add(issue);
                }
            }
        }
        return tmp;
    }

    public ArrayList filterByAssignee(String assignee) {
        ArrayList<Issue> tmp = new ArrayList<>();
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
