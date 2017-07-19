import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 7. 19..
 * https://www.codeground.org/practice/practiceProblemView
 * 문제 : 화학자의 문장
 */
public class chemistryWriting {
    static boolean Answer;
    static String[] C = {"H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al",
         "Si", "P", "S", "Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe",
         "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr",
         "Y","Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb",
         "Te", "I", "Xe", "Cs", "Ba", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au",
         "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra", "Rf", "Db", "Sg",
         "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Fl", "Lv", "La", "Ce", "Pr", "Nd",
         "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Ac",
         "Th", "Pa", "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md",
         "No", "Lr"};
    public static void main(String args[]) throws Exception	{

        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));
        HashMap<String, Integer> map = new HashMap<>();
        int index = 0;
        for(String s : C){
            s = s.toLowerCase();
            map.put(s, index);
            index++;
        }
        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
            String input = sc.next();
            Answer = true;
            int start=0;
            int rear=0;
            String temp;
            while(start < input.length()){
                temp = "";
                for(int i = start; i<=rear;i++){
                    temp += input.charAt(i);
                }
                if(map.get(temp) == null){
                    if((rear-start) == 1){
                        Answer = false;
                        break;
                    }
                    else{
                        if((rear+1) == input.length()){
                            Answer = false;
                            break;
                        }
                        rear++;
                    }
                }
                else{
                    start = rear+1;
                    rear++;
                }
            }

            System.out.println("Case #"+(test_case+1));
            if(!Answer)
                System.out.println("NO");
            else
                System.out.println("YES");

        }
    }
}
