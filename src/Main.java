import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] measure = in.nextLine().split(" ");
        String[][] mtx_lab = new String[Integer.parseInt(measure[0])][Integer.parseInt(measure[0])];
        int count_dots = 0;
        int start_x = 0;
        int start_y = 0;

        for (int i = 0; i < Integer.parseInt(measure[0]); i++){
            String str_full = in.nextLine();
            if (str_full.indexOf("S") > 0){
                start_x = str_full.indexOf("S");
                start_y = i;
            }
            String[] str_lab = str_full.split("");
            count_dots += Arrays.stream(str_lab).filter(c -> c.equals(".")).count();
            mtx_lab[i] = str_lab;
        }

        SearchWay(start_y, start_x,mtx_lab,count_dots);

        Arrays.stream(mtx_lab).forEach(c->{
            Arrays.stream(c).forEach(System.out::print);
            System.out.println();});

    }
    public static String[][] SearchWay(int y, int x, String[][] mtx_lab, int count_dots){
        //OUT
        if (count_dots == 0){return mtx_lab;}
        //UP
        else if (mtx_lab[y-1][x].equals(".")){
            count_dots--;
            mtx_lab[y-1][x] = "U";
            SearchWay(y-1, x, mtx_lab, count_dots);
        }
        //LEFT
        else if (mtx_lab[y][x-1].equals(".")){
            count_dots--;
            mtx_lab[y][x-1] = "L";
            SearchWay(y, x-1, mtx_lab, count_dots);
        }
        //DOWN
        else if (mtx_lab[y+1][x].equals(".")){
            count_dots--;
            mtx_lab[y+1][x] = "D";
            SearchWay(y+1, x, mtx_lab, count_dots);
        }
        //RIGHT
        else if (mtx_lab[y][x+1].equals(".")){
            count_dots--;
            mtx_lab[y][x+1] = "R";
            SearchWay(y, x+1, mtx_lab, count_dots);
        }

        else if (mtx_lab[y][x].equals("U")){SearchWay(y+1, x, mtx_lab, count_dots);}
        else if (mtx_lab[y][x].equals("L")){SearchWay(y, x+1, mtx_lab, count_dots);}
        else if (mtx_lab[y][x].equals("D")){SearchWay(y-1, x, mtx_lab, count_dots);}
        else if (mtx_lab[y][x].equals("R")){SearchWay(y, x-1, mtx_lab, count_dots);}
        return null;
    }
}