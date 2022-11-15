package ProvaT;
import java.util.Scanner;

public class Tables {
    public int nTable;
    public Date[] date = new Date[0];
    public Drink comandaB;
    public Food comandaC;

    public Tables(int nm){
        this.nTable = nm;
        this.comandaB = new Drink();
        this.comandaC = new Food();
    }

    public int getnTable() {
        return nTable;
    }

    public void scDate(){
        Date data = new Date();
        Date[] dat = new Date[date.length + 1];
        int l = 0;
        for (Date date2 : date) {
            dat[l] = date2;
            l++;
        }
        dat[l] = data;
        this.date = dat;
    }

    public void verifyReserve(int dia, int mes, int ano){
        for (int j = 0; j < date.length; j++) {
            if ((this.date[j].dia == dia) && (this.date[j].mes == mes) && (this.date[j].ano == ano)){
                if (this.date[j].reserved){
                    System.out.println("Mesa reservada.");
                } else {
                    System.out.println("Mesa livre.\nReservar? [y/n]");

                    Scanner in = new Scanner(System.in);
                    String ch;
                    ch = in.next();

                    if ((ch == "y") || (ch == "Y")) {
                        System.out.println("Numero de pessoas: ");
                        int nP = in.nextInt();
                        this.date[j].reservation(nP);
                    } else if((ch == "n") || (ch == "N")){
                        System.out.println("Os de vdd eu sei quem são..");
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    in.close();
                }
            } else {
                System.out.println("Data não disponível para reserva.");
            }
        }
    }

    public void showConsume(){
        comandaB.showConsume();
        comandaC.showConsume();
    }

    public double repartBill(int numP){
        return ((comandaB.repartBill(numP)) + (comandaC.repartBill(numP)));
    }

    public double getServiceRate(){
        double rate = comandaB.bill + comandaC.bill;
        return rate/(double)10;
    }
}
