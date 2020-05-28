package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class IssueManager {
    private IssueRepository issueRepository;

    public IssueManager(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public List getAllOpen() {
        ArrayList<Issue> tmp = new ArrayList<>();
        List<Issue> issueList = issueRepository.getAllIssueList();
        for (Issue issue : issueList) {
            if (issue.isOpen()) {
                tmp.add(issue);
            }
        }
        return tmp;
    }

    public List getALLClose() {
        List<Issue> tmp = new ArrayList<>();
        List<Issue> issueList = issueRepository.getAllIssueList();
        for (Issue issue : issueList) {
            if (!issue.isOpen()) {
                tmp.add(issue);
            }
        }
        return tmp;
    }

    public List filterByAuthor(String author) {
        List<Issue> result = new ArrayList<>();
        List<Issue> issueList = issueRepository.getAllIssueList();
        Predicate<String> byAuthor = s -> s.equals(author);
        for (Issue issue : issueList) {
            if (byAuthor.test(issue.getAuthor())) {
                result.add(issue);
            }
        }
        return result;
    }

    public List filterByLabel(String label) {
        List<Issue> result = new ArrayList<>();
        List<Issue> issueList = issueRepository.getAllIssueList();
        for (Issue issue : issueList) {
            for (String s : issue.getLabel()) {
                if (s.equals(label)) {
                    result.add(issue);
                }
            }
        }
        return result;
    }

    public List filterByAssignee(String assignee) {
        List<Issue> result = new ArrayList<>();
        List<Issue> issueList = issueRepository.getAllIssueList();
        for (Issue issue : issueList) {
            for (String s : issue.getAssignee()) {
                if (s.equals(assignee)) {
                    result.add(issue);
                }
            }
        }
        return result;
    }

    void addLabel(Issue issue, String label) {
        issue.getLabel().add(label);
    }

    void addAssignee(Issue issue, String assignee) {
        issue.getAssignee().add(assignee);
    }
}
