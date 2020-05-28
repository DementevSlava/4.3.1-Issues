package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.domain.IssueComparator;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IssueManagerTest {
    private String bug = "bug";
    private String blocked = "blocked";
    private String invalid = "invalid";
    private String assignee1 = "Петров";
    private String assignee2 = "Козлов";
    private String assignee3 = "Сутормин";
    private IssueRepository issueRepository = new IssueRepository();
    private IssueManager issueManager = new IssueManager(issueRepository);
    private IssueComparator comparator = new IssueComparator();

    private Issue issue1 = new Issue(1, "Test 1", "Иванов", new HashSet<>(), new HashSet<>(), true);
    private Issue issue2 = new Issue(2, "Test 2", "Петров", new HashSet<>(), new HashSet<>(), true);
    private Issue issue3 = new Issue(3, "Test 3", "Сидоров", new HashSet<>(), new HashSet<>(), true);
    private Issue issue4 = new Issue(4, "Test 4", "Иванов", new HashSet<>(), new HashSet<>(), false);
    private Issue issue5 = new Issue(5, "Test 5", "Сидоров", new HashSet<>(), new HashSet<>(), false);

    @BeforeEach
    void setUp() {
        issueRepository.add(issue3);
        issueRepository.add(issue2);
        issueRepository.add(issue1);
        issueRepository.add(issue4);
        issueRepository.add(issue5);
    }

    @Test
    void getOpen() {
        List<Issue> actual = issueManager.getAllOpen();
        List<Issue> expected = Arrays.asList(issue3, issue2, issue1);

        assertEquals(expected, actual);
    }

    @Test
    void getClose() {
        List<Issue> actual = issueManager.getALLClose();
        List<Issue> expected = Arrays.asList(issue5, issue4);

        assertEquals(expected, actual);
    }

    @Test
    void filterByNonAuthor() {
        List<Issue> actual = issueManager.filterByAuthor("Тест");
        List<Issue> expected = new ArrayList<>();

        assertEquals(expected, actual);
    }

    @Test
    void filterByAuthor() {
        List<Issue> actual = issueManager.filterByAuthor("Иванов");
        List<Issue> expected = Arrays.asList(issue4, issue1);

        assertEquals(expected, actual);
    }

    @Test
    void filterByLabel() {
        issueManager.addLabel(issue1, bug);
        issueManager.addLabel(issue1, invalid);
        issueManager.addLabel(issue5, invalid);

        List<Issue> actual = issueManager.filterByLabel(invalid);
        List<Issue> expected = Arrays.asList(issue5, issue1);

        assertEquals(expected, actual);
    }

    @Test
    void filterByAssignee() {
        issueManager.addAssignee(issue2, assignee1);
        issueManager.addAssignee(issue2, assignee2);
        issueManager.addAssignee(issue3, assignee2);
        issueManager.addAssignee(issue3, assignee3);

        List<Issue> actual = issueManager.filterByAssignee(assignee2);
        List<Issue> expected = Arrays.asList(issue3, issue2);

        assertEquals(expected, actual);
    }
}
