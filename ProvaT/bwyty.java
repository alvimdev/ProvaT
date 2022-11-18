package ProvaT;
import java.util.Scanner;
import java.io.Console;

/* TRABALHO DE AEDS */
// Restaurante: bwyty (Galês)
// Made by Alvim (2021951426) and Raphael (2020954103)

public class bwyty {
    public static void main(String[] args) {
        Restaurant local = new Restaurant("iPhome", "Rua Alberto Cintra, n 6429, BH");
        Console t = System.console();
        Scanner in = new Scanner(System.in);

        for (int m = 0; m < 15; m++) {
            local.addTable(m);
            for (int n = 0; n < 3; n++) {
                local.tables[m].scDate();
            }
        }

        int choice;
        System.out.println("-------------------------------------------");
        System.out.println("Bem-Vindo ao Restaurante " + local.getName() + "\nEndereço: " + local.getAddress());
        System.out.println("-------------------------------------------");
        System.out.println();
        do {
            System.out.println("<01> MESAS");
            System.out.println("<02> FAZER PEDIDO");
            System.out.println("<03> LISTAR COMANDA");
            System.out.println("<04> DIVIDIR CONTA");
            System.out.println("<05> FINALIZAR SESSÃO");
            System.out.print("Escolha: ");
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
                                System.out.print("Dia: ");
                                dat.dia = in.nextInt();
                                System.out.print("Mes: ");
                                dat.mes = in.nextInt();
                                System.out.println("Ano: 2022");
                                dat.ano = 2022;
                                for (int j = 0; j < local.tables[i].date.length; j++) {
                                    if ((local.tables[i].date[j].dia == dat.dia) && (local.tables[i].date[j].mes == dat.mes)) {
                                        if(local.tables[i].date[j].reserved){
                                            System.out.println("Data já reservada\nEnter para continuar..");
                                            t.readLine();
                                        }
                                        else {
                                            System.out.print("Certo, certo. Quantas pessoas são? ");
                                            int Np = in.nextInt();
                                            in.nextLine();
                                            local.tables[i].date[j].reservation(Np, in);
                                            System.out.println("Reserva concluída.\nEnter para continuar..");
                                            t.readLine();
                                        }                                        
                                        break;  
                                    }
                                    else {
                                        System.out.println("Data não encontrada para reserva.\nEnter para continuar..");
                                        t.readLine();
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        System.out.print("\033\143");
                    } else if (res == 0) {
                        System.out.println("Ok, de toda forma, obrigado!\nEnter para continuar..");
                        t.readLine();
                        System.out.print("\033\143");
                        break;
                    } else {
                        System.out.println("Resposta inválida.");
                    }
                    break;
                case 2:
                    System.out.print("Em qual mesa deseja pedir? Mesa ");
                    int nmch = in.nextInt();
                    for (int i = 0; i < local.tables.length; i++) {
                        if (local.tables[i].nTable == nmch) {
                            System.out.println("O pedido é uma comida ou bebida? 1 para COMIDA e 2 para BEBIDA");
                            
                            int cb = in.nextInt();
                            in.nextLine();
                            String pedido;
                            double valor;
                            
                            if (cb == 1) {
                                System.out.print("Pedido: ");
                                pedido = in.nextLine();
                                System.out.print("Preço: ");
                                valor = in.nextDouble();
                                local.tables[i].comandaC.Ordering(pedido, valor);
                            } else if (cb == 0) {
                                System.out.print("Pedido: ");
                                pedido = in.nextLine();
                                System.out.print("Preço: ");
                                valor = in.nextDouble();
                                local.tables[i].comandaB.Ordering(pedido, valor);
                            } else {
                                System.out.println("Opção inválida");
                            }
                        }
                    }
                    break;
                case 5:
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
        } while (choice != 5);
        in.close();
    }
}