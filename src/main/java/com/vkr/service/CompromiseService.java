package com.vkr.service;

import com.vkr.data.Choise;
import com.vkr.data.Parameter;
import com.vkr.util.CompromiseException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompromiseService {

    public Choise getBestChoice(List<Choise> choises) throws CompromiseException {
        if (choises.isEmpty()) throw new CompromiseException("Список альтернатив пуст");
        computeDistances(choises);
        return choises.stream().min(Comparator.comparingDouble(Choise::getDistanceFromBest)).get();
    }

    public void computeDistances(List<Choise> choises) {
        Map<Parameter, Double> bestValues = getBestValuesForParameter(choises);
        choises.forEach(choise ->  {
            Map<Parameter, Double> parameters = choise.getValuesByParameter();
            double sumDistance = 0;
            for (Map.Entry<Parameter, Double> entry : parameters.entrySet()) {
                Parameter parameter = entry.getKey();
                Double value = entry.getValue();
                Double bestValue = bestValues.get(parameter);
                if (parameter.isMaximizing()) sumDistance += (bestValue - value) * parameter.getWeight();
                else sumDistance += (value - bestValue) * parameter.getWeight();
            }
            choise.setDistanceFromBest(sumDistance);
        });
    }

    private Map<Parameter, Double> getBestValuesForParameter(List<Choise> choises) {
        Map<Parameter, Double> result = new HashMap<>();
        choises.forEach(choise -> {
            Map<Parameter, Double> parameters = choise.getValuesByParameter();
            parameters.forEach((parameter, value) -> {
                Double curValue = result.get(parameter);
                if (curValue == null || ((parameter.isMaximizing() && value > curValue) || (!parameter.isMaximizing() && value < curValue))) {
                    result.put(parameter, value);
                }
            });
        });
        return result;
    }

}
