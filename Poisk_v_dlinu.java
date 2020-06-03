

import java.util.*;


public class Poisk_v_dlinu {
    private int yzel;
    private LinkedList<Integer> list[];
    public static void main(String[] args) {
        Poisk_v_dlinu g = new Poisk_v_dlinu(9);
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

        g.poisk_v_dlinu(1);
    }



    Poisk_v_dlinu(int v) {   //метод для нумерации и инициализации списка Link
        yzel = v;
        list = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            list[i] = new LinkedList();
    }


    void addReb(int v, int w) {
        list[v].add(w);
    }


    void poisk_v_dlinu1(int v, boolean visited[]) { //метод поиска в глубину
        visited[v] = true; // помечаем, что вершина проейдена
        System.out.println(++v + " Вершина посещена ");  //выводим пройденную вершину
        v--;

        Iterator<Integer> i = list[v].listIterator();
        while (i.hasNext()) {  //пока есть непосещенные вершина
            int n = i.next();
            if (!visited[n]) //проверяем была ли она посещена
                poisk_v_dlinu1(n, visited); //вызываем метод для пометки посеещения
        }
    }

    void poisk_v_dlinu(int v) {

        boolean visited[] = new boolean[yzel];

        poisk_v_dlinu1(v, visited);
    }
}