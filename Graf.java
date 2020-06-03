public class Graf {
    static int y=0;
    static char[][] matrica; //мы объявили нашу матрицу
    static void sdelai_graf(int kol_vo_uzlov){  //этот метод создает матрицу конкретной длины
        matrica = new char[kol_vo_uzlov][kol_vo_uzlov]; //пока что все ячейки нашей матрицы ранвы 0
    }
    static void uzel(String uzli){  //параметром этого метода является сколькими дугами соединен данный узел с другими
        System.out.println("Матрица смежности:");
        for (int i = 0; i < matrica.length ; i++) { //внешний цикл, индекс явяляется индексом строки
            for (int j = 0; j <matrica.length ; j++) { //внутренний цикл, индекс j служит индексом ячеек строки
                if(i!=0&&j==0){y++;}
                matrica[i][j]=uzli.charAt(y); //заполняем матрицу конкретными значениями
                y++;
                System.out.print(matrica[i][j]+"  ");
            }
            System.out.println();
        }
    }
    static void proverka(char massiv[][]){ //этод метод проверяет цикличностть графа
        String q="0";
        char w=q.charAt(0); // объявили перемееную равную символу 0
        for (int i = 0; i <massiv.length ; i++) { //внешний цикл
            for (int j = 0; j <massiv.length ; j++) { //внутренний цикл
               if(massiv[i][j]!=w){ //если данный элемент матрицы нулевой
                   massiv[j][i]=w; //меняем индексы столбца и строки, и тоже его обнуляем
               }
            }
        }
        System.out.println("Новая матрица:");
        for (int i = 0; i <massiv.length ; i++) {
            for (int j = 0; j < massiv.length; j++) {
                System.out.print(massiv[i][j]+"  ");
            }
            System.out.println();
        }
        int schetchik=0;
        for (int i = 0; i <massiv.length ; i++) {
            for (int j = 0; j <massiv.length ; j++) {
                if(massiv[i][j]!=w){ //проверка ненулевых элементов в нововй матрице
                    schetchik++; //счетчик ненулевых элементов
                }
            }
            if(schetchik!=0){ //если счетчик сработал хотя бы 1 раз, то программу можно обрыавать, так как гарф циклический
                System.out.println("Граф циклический!");
                break;
            }
        }
        if(schetchik==0){ System.out.println("Граф нециклический!"); }
    }
    public static void main(String[] args){
        /*sdelai_graf(9);
        uzel("011100000;101000000;100100000;101000000;000000111;000000010;000010000;010011000;000010000");
        proverka(matrica);*/
        sdelai_graf(4);
        uzel("0111,1001,1011,1110");
        proverka(matrica);

    }
}
