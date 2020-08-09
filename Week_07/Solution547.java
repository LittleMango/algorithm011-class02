public class Solution547 {

    public static void main(String[] args) {
        /*
        [[1,1,0],
 [1,1,0],
 [0,0,1]]
         */
        System.out.println(new Solution547().findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    public int findCircleNum(int[][] M) {
        if (M.length == 0) {
            return 0;
        }
        int n = M.length; //行数
        int m = M[0].length; //列数
        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }

    public static class UF {
        private int count;
        private int[] parent;

        public UF(int n) {
            parent = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }

            // 最初的联通分量有n个
            count = n;
        }

        // 将p和q联通
        public void union(int p, int q) {
            // 找到它们的祖先
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                // 祖先相同
                return;
            } else {
                // 祖先不同
                parent[rootP] = rootQ;
                // 并集减少1
                count--;
            }
        }

        // 返回有多少个联通分量
        public int getCount() {
            return count;
        }

        // 寻找祖先
        private int find(int p) {
            int temp = p;
            while (parent[p] != p) {
                p = parent[p];
            }
            // 路径压缩
            while (parent[temp] != p) {
                temp = parent[temp];
                parent[temp] = p;
            }
            return p;
        }
    }
}
