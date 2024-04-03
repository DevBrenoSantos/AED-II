package Testes;

public class exResponse {
    public static int numT (int T) {
        int resp;   
        if (T == 0) {
            resp = 1;
        } if (T == 1) {
            resp = 2;
        } else {
            resp = numT(T - 1) * numT(T - 2) - numT(T-1);
        }
        return resp;
    }

    public static void main(String[] args) {
        
    }
}