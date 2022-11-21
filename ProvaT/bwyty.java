package ProvaT;
import java.util.Scanner;
import java.io.Console;

/* TRABALHO DE AEDS */
// Restaurante: bwyty (Galês)
// Made by Alvim (2021951426) and Raphael (2020954103)

/* Comentários adicionais */
// O comando: 't.readLine();' serve para coletar o \n do input fazendo com que o programa prossiga apenas quando o usuário teclar o Enter
// O comando: 'System.out.print("\033\143");' serve para limpar o terminal e melhorar a apresentação ao usuário

public class bwyty {
    public static void main(String[] args) {
        Restaurant local = new Restaurant("iPhome", "Rua Alberto Cintra, n 6429, BH");
        Console t = System.console();
        Scanner in = new Scanner(System.in);
        int Nm, choice, cp, np, res; //variáveis de escolha

        for (int m = 0; m < 15; m++) {
            local.addTable(m);
            for (int n = 0; n < 3; n++) {
                local.tables[m].scDate();
            }
        }

        System.out.println("-------------------------------------------");
        System.out.println("Bem-Vindo ao Restaurante " + local.getName() + "\nEndereço: " + local.getAddress());
        System.out.println("-------------------------------------------");
        System.out.println();
        do {
            System.out.println("<01> MESAS");
            System.out.println("<02> FAZER PEDIDO");
            System.out.println("<03> LISTAR COMANDA");
            System.out.println("<04> DIVIDIR CONTA");
            System.out.println("<05> PAGAR");
            System.out.println("<06> FINALIZAR SESSÃO");
            System.out.print("Escolha: ");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("-------------------------------------------");
                    System.out.println("\t\t MESAS                                ");
                    System.out.println("-------------------------------------------");
                    local.showTables();
                    System.out.println("\nDeseja reservar uma mesa? 1 para SIM e 0 para NÃO");
                    res = in.nextInt();
                    if (res == 1) {
                        System.out.println("Perfeito! Qual mesa deseja reservar?");
                        Nm = in.nextInt();
                        for (int i = 0; i < local.tables.length; i++) {
                            if (Nm == local.tables[i].getnTable()){
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
                                        if(local.tables[i].date[j].getReserve()){
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
                                }
                                break;
                            }
                        }
                        System.out.print("\033\143");
                    } else if (res == 0) {
                        System.out.println("Ok, estamos ao seu dispor.\nEnter para continuar..");
                        t.readLine();
                        System.out.print("\033\143");
                        break;
                    } else {
                        System.out.println("Resposta inválida.");
                    }
                    break;
                case 2:
                    System.out.print("Em qual mesa deseja pedir? Mesa ");
                    Nm = in.nextInt();
                    for (int i = 0; i < local.tables.length; i++) {
                        if (local.tables[i].getnTable() == Nm) {
                            System.out.println("O pedido é uma comida ou bebida? 1 para COMIDA e 2 para BEBIDA");
                            cp = in.nextInt();
                            in.nextLine();
                            
                            String pedido;
                            float valor;
                            if (cp == 1) {
                                System.out.print("Pedido: ");
                                pedido = in.nextLine();
                                System.out.print("Preço: ");
                                valor = Float.parseFloat(in.nextLine());
                                local.tables[i].comandaC.Ordering(pedido, valor);
                                System.out.println("Pedido efetuado.");
                            } else if (cp == 2) {
                                System.out.print("Pedido: ");
                                pedido = in.nextLine();
                                System.out.print("Preço: ");
                                valor = Float.parseFloat(in.nextLine());
                                local.tables[i].comandaB.Ordering(pedido, valor);
                                System.out.println("Pedido efetuado.");
                            } else {
                                System.out.println("Opção inválida");
                            }
                            System.out.println("Enter para continuar..");
                            t.readLine();
                            System.out.print("\033\143");
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Qual mesa quer exibir a comanda? Mesa ");
                    Nm = in.nextInt();
                    for (int i = 0; i < local.tables.length; i++) {
                        if (local.tables[i].getnTable() == Nm) {
                            System.out.println("-------------------------------------------");
                            System.out.println("\t\t   COMANDA                             ");
                            System.out.println("-------------------------------------------");
                            System.out.println("Mesa: " + local.tables[i].getnTable());
                            System.out.println("-------------------------------------------");
                            local.tables[i].showConsume();
                            break;
                        }
                    }
                    System.out.println("Enter para continuar..");
                    t.readLine();
                    System.out.print("\033\143");
                    break;
                case 4:
                    System.out.print("Em qual mesa quer dividir a conta? ");
                    Nm = in.nextInt();
                    for (int i = 0; i < local.tables.length; i++) {
                        if (local.tables[i].getnTable() == Nm) {
                            System.out.print("Para quantas pessoas a conta será repartida? ");
                            np = in.nextInt();
                            local.tables[i].repartBill(np);
                            System.out.println("Conta dividida.\nCada membro pagará R$" + local.tables[i].getDividedBill());
                        }
                    }
                    System.out.println("Enter para continuar..");
                    t.readLine();
                    System.out.print("\033\143");
                    break;
                case 5:
                    System.out.println("Digite a mesa que deseja efetuar o pagamento: ");
                    Nm = in.nextInt();
                    for (int i = 0; i < local.tables.length; i++) {
                        if (local.tables[i].getnTable() == Nm) {
                            System.out.print("\033\143");
                            System.out.println("-------------------------------------------");
                            System.out.println("\t\t    CONTA                              ");
                            System.out.println("-------------------------------------------");
                            System.out.println("Mesa: " + local.tables[i].getnTable());
                            System.out.println("-------------------------------------------");
                            local.tables[i].showConsume();
                            System.out.println("-------------------------------------------");
                            System.out.println("Taxa de serviço (10%): R$" + local.tables[i].getServiceRate());
                            if (local.tables[i].getDividedBill() > 0)
                                System.out.println("Valor dividido: R$" + local.tables[i].getDividedBill() + " cada");
                                float conta = local.tables[i].comandaB.getBill() + local.tables[i].comandaC.getBill();
                            System.out.println("Valor total: R$" + (local.tables[i].getServiceRate() + conta));
                            System.out.println("-------------------------------------------");
                            System.out.println("Pagamento \"efetuado\".\nEnter para continuar..");
                        }
                    }
                    t.readLine();
                    System.out.print("\033\143");
                    break;
                case 6:
                    System.out.println("Obrigadx por vir ao Restaurante " + local.getName());
                    System.out.println("Volte sempre! :3");
                    for (int c = 0; c < local.tables.length; c++) {
                        local.tables[c].comandaB = new Drink();
                        local.tables[c].comandaC = new Food();
                        for (int cc = 0; cc < args.length; cc++) {
                            local.tables[c].date[cc].setReserve(false);
                        }
                    }
                    return;
            
                default:
                    System.out.println("Opção inexistente. Por favor, repita a ação.");
                    break;
            }
        } while (choice != 6);
        in.close();
    }
}
