public class Main {
    public static void main(String[] args) {
        String test = "aabaaaacaabc";
        int k = 2;
        // 此solution时间复杂度O(n)
        Solution solution = new Solution();
        System.out.println(solution.takeCharacters(test, k));
        test = "abc";
        k = 3;
        System.out.println(solution.takeCharacters(test, k));
    }
}
