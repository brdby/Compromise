package com.vkr;

import com.vkr.data.Choise;
import com.vkr.service.BarChartService;
import com.vkr.service.ChoisesCreatorService;
import com.vkr.service.CompromiseService;
import com.vkr.util.CompromiseException;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws CompromiseException {
        ChoisesCreatorService choisesCreatorService = new ChoisesCreatorService(new Scanner(System.in));
        CompromiseService compromiseService = new CompromiseService();
        BarChartService barChartService = new BarChartService();

        List<Choise> choises = choisesCreatorService.parseChoises();
        System.out.println(compromiseService.getBestChoice(choises));
        barChartService.showParametersBarChart(choises);
        barChartService.showChoicesDistanceBarChart(choises);
    }
}
