package ProvaT;
import java.util.Scanner;

/* TRABALHO DE AEDS */
// Restaurante: bwyty (Galês)
// Made by Alvim (2021951426) and Raphael (2020954103)

public class bwyty {
    public static void main(String[] args) {
        Restaurant local = new Restaurant("iPhome", "Rua Alberto Cintra, n 6429, BH");
        Scanner in = new Scanner(System.in);

        for (int m = 0; m < 15; m++) {
            local.addTable(m);
            for (int n = 0; n < 3; n++) {
                local.tables[m].scDate();
            }
        }

        int choice = 0;
        System.out.println("-------------------------------------------");
        System.out.println("Bem-Vindo ao Restaurante " + local.getName() + "\nEndereço: " + local.getAddress());
        System.out.println("-------------------------------------------");
        System.out.println();
        do {
            System.out.println("<01> MESAS");
            System.out.println("<03> FAZER PEDIDO");
            System.out.println("<04> LISTAR COMANDA");
            System.out.println("<05> DIVIDIR CONTA");
            System.out.println("<06> CADASTRAR UM CLIENTE");
            System.out.println("<07> FINALIZAR SESSÃO");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Lista de mesas: ");
                    local.showTables();
                    System.out.println("\nDeseja reservar uma mesa? 1 para SIM e 0 para NÃO");
                    int res = in.nextInt();
                    if (res == 1) {
                        System.out.println("Perfeito! Qual mesa deseja reservar?");
                        int Nm = in.nextInt();
                        for (int i = 0; i < local.tables.length; i++) {
                            if (Nm == local.tables[i].nTable){
                                Date dat = new Date();
                                System.out.println("Ótimo, mesa escolhida! Para qual data desja reservar esta mesa?");
                                System.out.println("Dia: ");
                                dat.dia = in.nextInt();
                                System.out.println("Mes: ");
                                dat.mes = in.nextInt();
                                System.out.println("Ano: \n2022");
                                dat.ano = 2022;
                                for (int j = 0; j < local.tables[i].date.length; j++) {
                                    if ((local.tables[i].date[j].dia == dat.dia) && (local.tables[i].date[j].mes == dat.mes)) {
                                        System.out.println("Certo, certo. Quantas pessoas são?");
                                        int Np = in.nextInt();
                                        in.nextLine();
                                        local.tables[i].date[j].reservation(Np, in);
                                        break;  
                                    }
                                }
                                break;
                            }
                        }
                    } else if (res == 0) {
                        System.out.println("Ok, de toda forma, obrigado!");
                        System.out.print("\033\143");
                        break;
                    } else {
                        System.out.println("Resposta inválida.");
                    }
                    break;
                case 7:
                    System.out.println("Obrigado por vir ao Restaurante " + local.getName());
                    System.out.println("Volte sempre! :3");
                    for (int c = 0; c < local.tables.length; c++) {
                        local.tables[c].comandaB = new Drink();
                        local.tables[c].comandaC = new Food();
                        for (int cc = 0; cc < args.length; cc++) {
                            local.tables[c].date[cc].reserved = false;
                        }
                    }
                    break;
            
                default:
                    System.out.println("Opção inexistente. Por favor, repita a ação.");
                    break;
            }
        } while (choice != 7);
        in.close();
    }
}