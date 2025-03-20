package br.dev.ferreiras.challenges;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URI;

public class ArrayFindKey {

    public static void main(String[] args) {
        int[][] numbers = new int[][]{
                {1, 2, 3, 14, 5, 6},
                {2, 3, 4, 5, 7, 12},
                {3, 6, 7, 9, 10, 11, 12}
        };

        int[][] position = new int[0][0];
        int key = 14;

        int[] response = findKey(numbers, key);

        Logger.getGlobal().log(Level.INFO, () ->
                String.format("::: Returned Position:--> %d, %d :::", response[0], response[1])
        );

        try {
            showUri();

        } catch(RuntimeException | IOException ex) {
            Logger.getGlobal().log(Level.INFO, () ->
                    String.format("::: Returned Position:--> %s, %s :::", ex.getMessage(), ex.getCause())
            );
        }
    }

    public static int[] findKey(int[][] numbers, int k) {

        int size = numbers.length;
        int[] response = new int[2];
        Logger.getGlobal().log(Level.INFO, () ->
                String.format("::: size: -> %d :::", size));
        int i = 0;
        int j = 0;
        while (i < size) {
            while (j < numbers[i].length) {
                if (numbers[i][j] == k) {
                    response[0] = i;
                    response[1] = j;
                    break;
                }
                j++;
            }

            i++;
            j = 0;
        }

//        for (int[] number : numbers) {
//            System.out.println(Arrays.toString(number));
//        }

        return response;
    }

    public static void showUri() throws IOException {
        var uri = URI.create("https://www.ferreiras.dev.br");
        Desktop.getDesktop().browse(uri);
    }

}

/**
 * Visao Geral
 * Analogia - use uma analogia do mundo real para ilustrar o conceito
 * Explicaçao Progressiva
 * Relaçoes
 * <p>
 * Exemplos Praticos
 * Detalhes Tecnicos
 * Apos fornecido o acima solicite ao usuario:
 * Resumo
 * Perguntas de acompanhamento
 */