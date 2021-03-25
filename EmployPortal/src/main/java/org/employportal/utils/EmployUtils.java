package org.employportal.utils;

import org.employportal.dto.Employ;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployUtils {
    public void sortByName(List<Employ> employList) {
        employList.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
    }

    public void applyBonusToAll(List<Employ> employList, double percentage) {
        employList.forEach(e ->
                e.setBonus(e.getSalary() * percentage / 100)
        );
    }

    public List<Employ> getEmploysBySalary(List<Employ> employs, double salary) {
        return employs.stream().filter(e -> (e.getSalary() > salary))
                .collect(Collectors.toList());
    }

    public Employ getEmployById(List<Employ> employs, String id) {
        return employs.stream().filter(e -> e.getId().equals(id))
                .findAny()
                .orElse(null);
    }


    public List<String> getAllEmployNames(List<Employ> employs) {
        return employs.stream()
                .map(Employ::getName)
                .collect(Collectors.toList());
    }

    public List<String> getAllEmployNamesBySalary(List<Employ> employList, double salary) {
        return employList.stream()
                .filter(e -> e.getSalary() == salary)
                .map(Employ::getName)
                .collect(Collectors.toList());
    }
}
