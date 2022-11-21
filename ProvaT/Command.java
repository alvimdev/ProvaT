package ProvaT;

public class Command {
    public String[] consume = new String[0];
    public float[] value = new float[0];
    private float bill = 0;

    public float getBill() {
        return bill;
    }

    public void showConsume() {
        for (int i = 0; i < consume.length; i++) {
            System.out.println("[R$" + value[i] + "] " + consume[i]);
        }
    }

    public void Ordering(String order, float val){
        String[] consumo = new String[consume.length + 1];
        float[] valor = new float[value.length + 1];
        consumo[consumo.length - 1] = order;
        valor[value.length] = val;
        this.consume = consumo;
        this.value = valor;
        this.bill += val;
    }

    public float repartBill(int numP){
        return (bill/(float)numP);
    }
}
