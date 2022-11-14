package ProvaT;

public class Command {
    public String[] consume = new String[0];
    public double bill = 0;

    public double getBill() {
        return bill;
    }

    public void showConsume() {
        for (int i = 0; i < consume.length; i++) {
            System.out.println(consume[i]);
        }
    }

    public void Ordering(String order, double value){
        String[] consumo = new String[consume.length + 1];
        consumo[consumo.length - 1] = order;
        this.consume = consumo;
        this.bill += value;
    }

    public double repartBill(int numP){
        return (bill/(float)numP);
    }

    public double getServiceRate(){
        return ((double)(10/100) * bill);
    }
}
