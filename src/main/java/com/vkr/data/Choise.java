package com.vkr.data;

import java.util.Map;
import java.util.Objects;

public class Choise {

    private final String name;
    private final Map<Parameter, Double> valuesByParameter;
    private Double distanceFromBest = Double.MAX_VALUE;

    public Choise(String name, Map<Parameter, Double> valuesByParameter) {
        this.name = name;
        this.valuesByParameter = valuesByParameter;
    }

    public String getName() {
        return name;
    }

    public Map<Parameter, Double> getValuesByParameter() {
        return valuesByParameter;
    }

    public Double getDistanceFromBest() {
        return distanceFromBest;
    }

    public void setDistanceFromBest(Double distanceFromBest) {
        this.distanceFromBest = distanceFromBest;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Choise choise = (Choise) o;

        if (!Objects.equals(name, choise.name)) return false;
        if (!Objects.equals(valuesByParameter, choise.valuesByParameter))
            return false;
        return Objects.equals(distanceFromBest, choise.distanceFromBest);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (valuesByParameter != null ? valuesByParameter.hashCode() : 0);
        result = 31 * result + (distanceFromBest != null ? distanceFromBest.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Choise{" +
                "name='" + name + '\'' +
                ", valuesByParameter=" + valuesByParameter +
                ", distanceFromBest=" + distanceFromBest +
                '}';
    }
}
