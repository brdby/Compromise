package com.vkr.data;

import java.util.Objects;

public class Parameter {

    private final String name;
    private final boolean isMaximizing;
    private final Double weight;

    public Parameter(String name, boolean isMaximizing, Double weight) {
        this.name = name;
        this.isMaximizing = isMaximizing;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public boolean isMaximizing() {
        return isMaximizing;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parameter parameter = (Parameter) o;

        if (isMaximizing != parameter.isMaximizing) return false;
        if (!Objects.equals(name, parameter.name)) return false;
        return Objects.equals(weight, parameter.weight);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (isMaximizing ? 1 : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        return result;
    }
}
