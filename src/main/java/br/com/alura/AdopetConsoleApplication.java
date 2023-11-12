package br.com.alura;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.service.PetService;
import br.com.alura.service.ShelterService;

import java.util.Scanner;

public class AdopetConsoleApplication {

    public static void main(String[] args) {

        ClientHttpConfiguration clientHttpConfiguration = new ClientHttpConfiguration();
        ShelterService shelterService = new ShelterService(clientHttpConfiguration);
        PetService petService = new PetService(clientHttpConfiguration);

        System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####");
        try {
            int opcaoEscolhida = 0;

            while (true) {
                System.out.println(" DIGITE O NÚMERO DA OPERAÇÃO DESEJADA:");
                System.out.println("1 -> Listar abrigos cadastrados");
                System.out.println("2 -> Cadastrar novo abrigo");
                System.out.println("3 -> Listar pets do abrigo");
                System.out.println("4 -> Importar pets do abrigo");
                System.out.println("5 -> Sair");

                String textoDigitado = new Scanner(System.in).nextLine();
                opcaoEscolhida = Integer.parseInt(textoDigitado);

                if (opcaoEscolhida == 1) {
                    shelterService.listShelter();
                } else  if (opcaoEscolhida == 2) {
                    shelterService.createShelter();
                } else if (opcaoEscolhida == 3) {
                    petService.listPetsFromShelter();
                 }else if (opcaoEscolhida == 4) {
                    petService.importPetsFromShelter();
                } else if (opcaoEscolhida == 5) {
                    break;
                } else {
                    System.out.println("NÚMERO INVÁLIDO!");
                }
            }
            System.out.println("Finalizando o programa...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
