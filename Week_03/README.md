分治、回溯采用递归
求解组合、全排列用递归的模板如下
```
private List<List<Integer>> list = new LinkedList<>();
    private int[] nums;
    private int length;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.length = nums.length;
        permute(new LinkedList<>());
        return list;
    }

    private void permute(LinkedList<Integer> curr) {
        // 如果求组合，把length改一下，然后return就好
        if (curr.size() == length) {
            // 满足条件了
            list.add(new ArrayList<>(curr));
        }
        for (int i = 0; i < length; i++) {
            // 给回溯套路增加一个条件
            if (!curr.contains(nums[i])) {
                // 把当前节点加进去
                curr.add(nums[i]);
                // drill in
                permute(curr);
                // reverse
                curr.removeLast();
            }
        }
    }
```

如果再增加一个初始元素可以包含重复元素的话，用一个hashMap记录每个char出现的次数，然后把输入数组去重，模板如下
```
private List<List<Integer>> mList = new LinkedList<>();
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int[] nums;
    private int targetLength;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.targetLength = nums.length;
        // 记录每个元素出现的次数
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 去重之后的数组
        this.nums = deleteRepeat(nums);
        // 回溯
        permute(new LinkedList<>());
        return mList;
    }

    private int[] deleteRepeat(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        int[] newNums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            newNums[i] = list.get(i);
        }
        return newNums;
    }

    private void permute(LinkedList<Integer> curr) {
        if (curr.size() == targetLength) {
            mList.add(new ArrayList<>(curr));
            // 如果求组合，把length改一下，然后return就好
        }
        for (int num : nums) {
            // 给回溯套路增加一个条件
            if (containCount(curr, num) < map.get(num)) {
                curr.add(num);
                permute(curr);
                curr.removeLast();
            }
        }
    }

    private int containCount(LinkedList<Integer> curr, int num) {
        int count = 0;
        for (Integer integer : curr) {
            if (integer == num) {
                count++;
            }
        }
        return count;
    }
```