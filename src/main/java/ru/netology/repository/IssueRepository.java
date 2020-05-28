package ru.netology.repository;

import ru.netology.domain.Issue;
import ru.netology.domain.IssueComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IssueRepository {
    private IssueComparator comparator = new IssueComparator();
    private List<Issue> issueList = new ArrayList<>();


    public List<Issue> getAllIssueList() {
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

    void closeById(int id) {
        Issue tmp = findById(id);
        for (Issue issue : issueList) {
            if (id == issue.getId()) {
                tmp.setOpen(false);
            }
        }
    }

    void openById(int id) {
        Issue tmp = findById(id);
        for (Issue issue : issueList) {
            if (id == issue.getId()) {
                tmp.setOpen(true);
            }
        }
    }
}
