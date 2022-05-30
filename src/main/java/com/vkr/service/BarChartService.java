package com.vkr.service;

import com.vkr.awt.BarChartAwt;
import com.vkr.data.Choise;
import com.vkr.data.Parameter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultValueDataset;

import java.util.List;
import java.util.Map;

public class BarChartService {

    private static final String pChartName = "Параметры";
    private static final String pChartCategory = "Альтернативы";
    private static final String pChartValue = "Значение параметра";

    private static final String cChartName = "Среднее расстояние до лучшего";
    private static final String cChartCategory = "Альтернативы";
    private static final String cChartValue = "Значение расстояния";

    public void showParametersBarChart(List<Choise> choises) {
        CategoryDataset dataset = getParametersDataset(choises);
        BarChartAwt barChart = new BarChartAwt(pChartName, pChartCategory, pChartValue, dataset, true);
        barChart.pack();
        barChart.setVisible(true);
    }

    public void showChoicesDistanceBarChart(List<Choise> choises) {
        CategoryDataset dataset = getChoicesDataset(choises);
        BarChartAwt barChart = new BarChartAwt(cChartName, cChartCategory, cChartValue, dataset, false);
        barChart.pack();
        barChart.setVisible(true);
    }

    private CategoryDataset getParametersDataset(List<Choise> choises) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        choises.forEach(choise -> {
            Map<Parameter, Double> parameters = choise.getValuesByParameter();
            parameters.forEach((key, value) -> dataset.addValue(value, key.getName(), choise.getName()));
        });
        return dataset;
    }

    private CategoryDataset getChoicesDataset(List<Choise> choises) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        choises.forEach(choise -> dataset.setValue(choise.getDistanceFromBest(), "distance", choise.getName()));
        return dataset;
    }
}
