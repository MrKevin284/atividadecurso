import java.util.Scanner;

interface FormaGeometrica {
    double calcularPerimetro();
    double calcularArea();
}

abstract class Quadrilatero implements FormaGeometrica {
    double lado1, lado2, lado3, lado4;

    Quadrilatero(double lado1, double lado2, double lado3, double lado4) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.lado4 = lado4;
    }

    public double calcularPerimetro() {
        return lado1 + lado2 + lado3 + lado4;
    }
}

class Retangulo extends Quadrilatero {
    Retangulo(double base, double altura) {
        super(base, altura, base, altura);
    }

    public double calcularArea() {
        return lado1 * lado2;
    }
}

class Quadrado extends Quadrilatero {
    Quadrado(double lado) {
        super(lado, lado, lado, lado);
    }

    public double calcularArea() {
        return lado1 * lado1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantas formas você deseja criar?");
        int n = scanner.nextInt();
        FormaGeometrica[] formas = new FormaGeometrica[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Você deseja criar um quadrado ou um retângulo? (q/r)");
            char tipo = scanner.next().charAt(0);
            if (tipo == 'q') {
                System.out.println("Insira o tamanho do lado:");
                double lado = scanner.nextDouble();
                formas[i] = new Quadrado(lado);
            } else if (tipo == 'r') {
                System.out.println("Insira o tamanho da base:");
                double base = scanner.nextDouble();
                System.out.println("Insira o tamanho da altura:");
                double altura = scanner.nextDouble();
                formas[i] = new Retangulo(base, altura);
            }
        }

        for (FormaGeometrica forma : formas) {
            if (forma instanceof Quadrado) {
                Quadrado quadrado = (Quadrado) forma;
                System.out.println("Quadrado com lado " + quadrado.lado1);
            } else if (forma instanceof Retangulo) {
                Retangulo retangulo = (Retangulo) forma;
                System.out.println("Retângulo com base " + retangulo.lado1 + " e altura " + retangulo.lado2);
            }
            System.out.println("Perímetro: " + forma.calcularPerimetro());
            System.out.println("Área: " + forma.calcularArea());
        }
    }
}
