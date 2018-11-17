import java.util.Stack;

class Solution {
    private int[][] picture;
    class Node {
        public int m, n;
        public int preM, preN;

        public Node(int m, int n) {
            this.m = m;
            this.n = n;
        }

        public void setPreNode(int m, int n) {
            this.preM = m;
            this.preN = n;
        }

        public int[] getPreNode() {
            return new int[]{preM, preN};
        }
    }

    // solution
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int mamSizeOfOneArea = 0;
        int sizeOfOneArea = 0;
        this.picture = picture;
        Stack<Node> nodes = new Stack<Node>();

        int[] sp;



        while((sp = searchStartingNode()) != null) {
            System.out.println("sp: " + sp[0] + ", " + sp[1]);

            int next[];
            Node node = new Node(sp[0], sp[1]);
            next = searchNextNode(node);

            while (true) {
                Node nextNode;

                if(nodes.empty()) { // loop end condition
                    break;
                }
            }



            numberOfArea++;
            if(mamSizeOfOneArea > sizeOfOneArea) {
                mamSizeOfOneArea = sizeOfOneArea;
            }
            break; // tmp code
        }

        System.out.println("end");

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = mamSizeOfOneArea;
        return answer;
    }

    private int[] searchNextNode(Node p) {
        int m = p.m;
        int n = p.n;

        if(picture[m-1][n] != 0) { // up
            try{
                return new int[]{m-1, n};
            } catch (ArrayIndexOutOfBoundsException e) { }
        } else if(picture[m+1][n] != 0) { // down
            try{
                return new int[]{m+1, n};
            } catch (ArrayIndexOutOfBoundsException e) { }
        } else if(picture[m][n-1] != 0) { // left
            try {
                return new int[]{m, n-1};
            } catch (ArrayIndexOutOfBoundsException e) { }
        } else { // right
            try {
                return new int[]{m, n+1};
            } catch (ArrayIndexOutOfBoundsException e) { }
        }
        return null;
    }

    private int[] searchStartingNode() {
        for(int i=0; i<picture.length; i++) {
            for(int j=0; j<picture[i].length; j++) {
                if(picture[i][j] != 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}