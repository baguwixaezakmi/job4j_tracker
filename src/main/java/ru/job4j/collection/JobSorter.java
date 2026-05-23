package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
            new Job("Fix bugs", 4),
            new Job("Impl task", 2),
            new Job("Reboot server", 1)
        );
        System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);

        jobs.sort(new SortByNameJob());
        System.out.println(jobs);

        jobs.sort(new SortDescByNameJob());
        System.out.println(jobs);

        jobs.sort(new JobDescByName().thenComparing(new JobDescByPriority()));

        Comparator<Job> combine = new JobDescByNameLength().thenComparing(new JobDescByName()).thenComparing(new JobDescByPriority());
        jobs.sort(combine);

        Comparator<Job> compareName = Comparator.comparing(Job::getName);
        Comparator<Job> comparePriority = Comparator.comparingInt(Job::getPriority);
        Comparator<Job> anotherCombine = compareName.thenComparing(comparePriority);

        jobs.sort(anotherCombine);
    }
}