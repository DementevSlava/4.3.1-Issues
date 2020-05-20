package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.domain.IssueComparator;
import ru.netology.repository.Repo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ManagerTest {
    String bug = "bug";
    String blocked = "blocked";
    String invalid = "invalid";
    String assignee1 = "Петров";
    String assignee2 = "Козлов";
    String assignee3 = "Сутормин";
    Repo repo = new Repo();
    Manager manager = new Manager(repo);
    IssueComparator comparator = new IssueComparator();

    Issue issue1 = new Issue(1, "Test 1", "Иванов", new HashSet<>(), new HashSet<>(), true);
    Issue issue2 = new Issue(2, "Test 2", "Петров", new HashSet<>(), new HashSet<>(), true);
    Issue issue3 = new Issue(3, "Test 3", "Сидоров", new HashSet<>(), new HashSet<>(), true);
    Issue issue4 = new Issue(4, "Test 4", "Иванов", new HashSet<>(), new HashSet<>(), false);
    Issue issue5 = new Issue(5, "Test 5", "Сидоров", new HashSet<>(), new HashSet<>(), false);

    @BeforeEach
    void setUp() {
        repo.add(issue3);
        repo.add(issue2);
        repo.add(issue1);
        repo.add(issue4);
        repo.add(issue5);
        repo.getAllIssueList(comparator);
    }

    @Test
    void getOpen() {

        List<Issue> actual = manager.getOpen(repo.getAllIssueList(comparator));
        List<Issue> expected = Arrays.asList(issue3, issue2, issue1);

        assertEquals(expected, actual);

    }

    @Test
    void getClose() {
        List<Issue> actual = manager.getClose(repo.getAllIssueList(comparator));
        List<Issue> expected = Arrays.asList(issue5, issue4);

        assertEquals(expected, actual);
    }

    @Test
    void filterByAuthor() {
        List<Issue> actual = manager.filterByAuthor("Иванов");
        List<Issue> expected = Arrays.asList(issue4, issue1);

        assertEquals(expected, actual);
    }

    @Test
    void addLabel() {
        manager.addLabel(issue1, bug);
        manager.addLabel(issue1, blocked);
        //System.out.println(issue1);
        assertTrue(issue1.getLabel().contains(bug));
    }

    @Test
    void filterByLabel() {

        manager.addLabel(issue1, bug);
        manager.addLabel(issue1, invalid);
        manager.addLabel(issue5, invalid);

        List<Issue> actual = manager.filterByLabel(invalid);
        List<Issue> expected = Arrays.asList(issue5, issue1);

        assertEquals(expected, actual);
    }

    @Test
    void filterByAssignee() {

        manager.addAssignee(issue2, assignee1);
        manager.addAssignee(issue2, assignee2);
        manager.addAssignee(issue3, assignee2);
        manager.addAssignee(issue3, assignee3);

        List<Issue> actual = manager.filterByAssignee(assignee2);
        List<Issue> expected = Arrays.asList(issue3, issue2);

        assertEquals(expected, actual);
    }

    @Test
    void closeById() {
        manager.closeById(1);

        List<Issue> actual = manager.getClose(repo.getAllIssueList(comparator));
        List<Issue> expected = Arrays.asList(issue5, issue4, issue1);

        assertEquals(expected, actual);
    }

    @Test
    void openById() {
        manager.openById(5);

        List<Issue> actual = manager.getOpen(repo.getAllIssueList(comparator));
        List<Issue> expected = Arrays.asList(issue5, issue3, issue2, issue1);

        assertEquals(expected, actual);
    }
}