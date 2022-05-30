package com.vkr.service;

import com.vkr.data.Choise;
import com.vkr.data.Parameter;

import java.util.*;

public class ChoisesCreatorService {

    private final Scanner in;

    public ChoisesCreatorService(Scanner in) {
        this.in = in;
    }

    public List<Choise> parseChoises(){
        List<Choise> choises = new ArrayList<>();
        List<Parameter> parameters = parseParameters();
        System.out.println("Введите количество вариантов:");
        int choisesNum = in.nextInt();
        for (int i = 1; i <= choisesNum; i++) {
            System.out.println("Ввод варианта номер " + i);
            System.out.println("Введите имя варианта:");
            String name = in.next();
            System.out.println("Ввод значений параметров данного варианта:");
            Map<Parameter, Double> parameterValues = new HashMap<>();
            for (Parameter p : parameters) {
                System.out.println("Ввод значения для параметра " + p.getName());
                double value = in.nextDouble();
                parameterValues.put(p, value);
            }
            choises.add(new Choise(name, parameterValues));
        }
        return choises;
    }

    private List<Parameter> parseParameters() {
        System.out.println("Введите количество критериев:");
        int parametersNum = in.nextInt();
        List<Parameter> parameters = new ArrayList<>();
        for (int i = 1; i <= parametersNum; i++) {
            System.out.println("Ввод критерия номер " + i);
            System.out.println("Введите имя критерия:");
            String name = in.next();
            System.out.println("Введите вес критерия:");
            Double weight = in.nextDouble();
            System.out.println("Введите 1 - если критерий максимизирующий иначе - любое другое число");
            boolean isMaximizing = in.nextInt() == 1;
            parameters.add(new Parameter(name, isMaximizing, weight));
        }
        return parameters;
    }

}
