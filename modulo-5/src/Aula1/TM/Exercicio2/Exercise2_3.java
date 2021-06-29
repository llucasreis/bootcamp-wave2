package Aula1.TM.Exercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise2_3 {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while (products.size() < 3) {
            System.out.print("Nome do produto: ");
            String name = sc.next();

            System.out.print("Valor do produto: ");
            double value = Double.parseDouble(sc.next());

            System.out.print("Quantidade: ");
            int quantity = sc.nextInt();

            products.add(new Product(name, value, quantity));
        }

        double total = 0.0;
        for (int i = 0; i < products.size(); i++) {
            System.out.println("Produto " + (i + 1));
            System.out.println(products.get(i).getName());
            System.out.println("R$" + products.get(i).getValue());
            System.out.println("Quantidade: " + products.get(i).getQuantity());
            System.out.println("");
            total += (products.get(i).getQuantity() * products.get(i).getValue());
        }
        System.out.println("Valor Total: R$" + total);
    }
}

class Product {
    String name;
    double value;
    int quantity;

    public Product(String name, double value, int quantity) {
        this.name = name;
        this.value = value;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
