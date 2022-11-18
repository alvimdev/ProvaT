package ProvaT;

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

    public Date getDate(int pos) {
        return date[pos];
    }

    public void verifyReserve(Date data, int j){
        if (this.date[j].equals(data)){
            this.date[j].printData();
            System.out.print(" -- ");
            if (this.date[j].reserved){
                System.out.println("Mesa reservada.");
            } else {
                System.out.println("Mesa livre.");
            }
        } else {
            System.out.println("Data não disponível.");
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
