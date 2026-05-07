package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double score = 0.0;
        int subjectCount = 0;

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            subjectCount += pupil.subjects().size();
        }

        return subjectCount == 0 ? 0.0 : score / subjectCount;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();

        for (Pupil pupil : pupils) {
            double score = 0.0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            list.add(new Label(pupil.name(), score / pupil.subjects().size()));
        }

        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> result = new ArrayList<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), subject.score() + map.getOrDefault(subject.name(), 0));
            }
        }

        for (String key : map.keySet()) {
            result.add(new Label(key, (double) map.get(key) / pupils.size()));
        }

        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> students = new ArrayList<>();

        for (Pupil pupil : pupils) {
            double score = 0.0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            students.add(new Label(pupil.name(), score));
        }

        students.sort(Comparator.naturalOrder());
        return students.get(students.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new HashMap<>();
        List<Label> list = new ArrayList<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), subject.score() + map.getOrDefault(subject.name(), 0));
            }
        }

        for (String key : map.keySet()) {
            list.add(new Label(key, map.get(key)));
        }

        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }
}