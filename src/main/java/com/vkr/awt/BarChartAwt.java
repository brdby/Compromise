package com.vkr.awt;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.CategoryDataset;

public class BarChartAwt extends ApplicationFrame {

    public BarChartAwt(String title, String categoryName, String valueName, CategoryDataset dataset, boolean legend) {
        super(title);
        JFreeChart barChart = ChartFactory.createBarChart(
                title,
                categoryName,
                valueName,
                dataset,
                PlotOrientation.VERTICAL,
                legend, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
        setContentPane(chartPanel);
    }


}
