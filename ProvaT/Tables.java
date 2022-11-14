package ProvaT;
import java.util.Scanner;

public class Tables {
    private int nTable;
    private Date[] date = new Date[0];

    public Tables(int nm){
        this.nTable = nm;
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

    public void verifyReserve(Date data){
        for (int j = 0; j < date.length; j++) {
            if (this.date[j].equals(data)) {
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
                return;
            }
        }
    }
}
