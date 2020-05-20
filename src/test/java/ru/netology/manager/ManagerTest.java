package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.domain.IssueComparator;
import ru.netology.repository.Repo;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManagerTest {
    String bug = "bug";
    String blocked = "blocked";
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
    }

    @Test
    void getOpen() {

        ArrayList<Issue> actual = manager.getOpen(repo.getAllIssueList());
        ArrayList<Issue> expected = new ArrayList<>();
        expected.add(issue1);
        expected.add(issue2);
        expected.add(issue3);

        assertEquals(expected, actual);

    }

    @Test
    void getClose() {
        ArrayList<Issue> actual = manager.getClose(repo.getAllIssueList());
        ArrayList<Issue> expected = new ArrayList<>();
        expected.add(issue5);
        expected.add(issue4);

        assertEquals(expected, actual);
    }

    @Test
    void filterByAuthor() {
    }

    @Test
    void filterByLabel() {
    }

    @Test
    void filterByAssignee() {
    }

    @Test
    void closeById() {
    }

    @Test
    void openById() {
    }
}