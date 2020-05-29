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

    public List<Issue> getAllOpen() {
        ArrayList<Issue> tmp = new ArrayList<>();
        List<Issue> issueList = issueRepository.getAllIssueList();
        for (Issue issue : issueList) {
            if (issue.isOpen()) {
                tmp.add(issue);
            }
        }
        return tmp;
    }

    public List<Issue> getALLClose() {
        List<Issue> tmp = new ArrayList<>();
        List<Issue> issueList = issueRepository.getAllIssueList();
        for (Issue issue : issueList) {
            if (!issue.isOpen()) {
                tmp.add(issue);
            }
        }
        return tmp;
    }

    public List<Issue> filterByAuthor(String author) {
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

    public List<Issue> filterByLabel(String label) {
        List<Issue> result = new ArrayList<>();
        List<Issue> issueList = issueRepository.getAllIssueList();
        Predicate<String> byLabel = s -> s.equals(label);
        for (Issue issue : issueList) {
            for (String value : issue.getLabel()) {
                if (byLabel.test(value)) {
                    result.add(issue);
                }
            }
        }
        return result;
    }

    public List<Issue> filterByAssignee(String assignee) {
        List<Issue> result = new ArrayList<>();
        List<Issue> issueList = issueRepository.getAllIssueList();
        Predicate<String> byAssignee = s -> s.equals(assignee);
        for (Issue issue : issueList) {
            for (String value : issue.getAssignee()) {
                if (byAssignee.test(value)) {
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
