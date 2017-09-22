import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 9. 22..
 */
public class Ureka {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t=0;t<T;t++){
            int N = sc.nextInt();
            boolean pass = false;
            for(int i=1;T(i) <= N; i++){
                for(int j=i; T(j) <= N; j++){
                    if(T(i) + T(j) >= N){
                        break;
                    }
                    for(int k=j;T(k) <= N; k++){

                        if(T(i) + T(j) + T(k) == N) {
                            System.out.println("1");
                            pass = true;
                            break;
                        }
                        if(T(i) + T(j) + T(k) > N){
                            break;
                        }

                    }
                    if(pass)
                        break;
                }
                if(pass)
                    break;

            }
            if(!pass)
                System.out.println("0");
        }
    }
    static int T(int num){
        return num*(num+1)/2;
    }
}
