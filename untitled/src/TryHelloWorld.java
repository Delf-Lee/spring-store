public class TryHelloWorld {
    public int tiling(int n) {
        if (n <= 1) {
            return n;
        } else {
            int result = tiling(n-1) + tiling(n-2);
            return result > 100000 ? result%100000 : result;
        }
        // return answer;
    }

    private int[] memo = new int[1000];
    public int tiling2(int n) {
        if (n <= 2) {
            return n;
        } else if (memo[n] != 0) {
            return memo[n];
        } else {
            return memo[n] = tiling2(n-1) + tiling2(n-2);
        }
    }


    public static void main(String args[]) {
        System.out.println("start");
        TryHelloWorld tryHelloWorld = new TryHelloWorld();
        // 아래는 테스트로 출력해 보기 위한 코드입니다.
        for(int i=0; i<50; i++) {
            System.out.println("i = " + i + "/ " + tryHelloWorld.tiling2(i));
        }
    }
}