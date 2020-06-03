import java.util.*;

public class Poisk_v_shirinu {
    private int yzel;
    private LinkedList<Integer> list[];
    public static void main(String[] args) {
        Poisk_v_shirinu g = new Poisk_v_shirinu(9);
        g.addReb(2, 0);
        g.addReb(0, 2);
        g.addReb(0, 3);
        g.addReb(3, 0);
        g.addReb(0, 1);
        g.addReb(1, 0);
        g.addReb(1, 7);
        g.addReb(7, 1);
        g.addReb(7, 5);
        g.addReb(5, 7);
        g.addReb(7, 4);
        g.addReb(4, 7);
        g.addReb(4, 8);
        g.addReb(8, 4);
        g.addReb(4, 6);
        g.addReb(6, 4);

        g.poisk_v_shirinu1(1);
    }






    Poisk_v_shirinu(int v) { //метод для нумерации узлов
        yzel = v;
        list = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            list[i] = new LinkedList();
    }


    void addReb(int v, int w) {
        list[v].add(w);
    }


    void poisk_v_shirinu1(int v) { //метод для поиска в ширину

        boolean visited[] = new boolean[yzel];   //массив посещений

        LinkedList<Integer> qer = new LinkedList<Integer>();  //список, в котором будем отображать очередь


        visited[v] = true;  //вершина посещена
        qer.add(v);    //доюаваляем в список очеереди
        while (qer.size() != 0) {   //условие: пока очередь есть

            v = qer.poll();
            System.out.println(++v + " Вершина посещена ");  //выводим посещенный узел
            v--;

            Iterator<Integer> i = list[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    qer.add(n);
                }
            }
        }
    }
}