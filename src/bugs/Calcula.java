/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugs;

/**
 *
 * @author 05220139
 */
public class Calcula {

    int num_1, num_2;

    public Calcula(int num_1, int num_2, char operacao) {
        this.num_1 = num_1;
        this.num_2 = num_2;
        this.operacao = operacao;
    }

    public Calcula() {

    }

    public int getNum_1() {
        return num_1;
    }

    public void setNum_1(int num_1) {
        this.num_1 = num_1;
    }

    public int getNum_2() {
        return num_2;
    }

    public void setNum_2(int num_2) {
        this.num_2 = num_2;
    }
    char operacao;

    public char getOperacao() {
        return operacao;
    }

    public void setOperacao(char operacao) {
        this.operacao = operacao;
    }

    public int Soma(int num_1, int num_2) {
        return num_1 + num_2;
    }

    public int Subs(int num_1, int num_2) {
        if (num_2 > num_1) {
            System.out.println("Nem vem querer número negativo fera, mas te dou o resultado: ");
            return num_2 - num_1;
        }
        return num_1 - num_2;
    }

    public int Multiplica(int num_1, int num_2) {
        return num_1 * num_2;
    }

    public int Divisiao(int num_1, int num_2) {
        if (num_2 == 0) {
            System.out.println("Divisão por zero magrão tá doido");
            return 0;
        } else {

            return num_1 / num_2;
        }

    }

}
