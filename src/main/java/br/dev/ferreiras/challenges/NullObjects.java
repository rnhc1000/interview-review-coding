package br.dev.ferreiras.challenges;


class A {

    A(Object o) {
        System.out.println("A");
    }
}
public class NullObjects {

    public static void main(String[] args) {
        A obj = new A(null);
    }

}
