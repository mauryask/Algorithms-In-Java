// This is same as printing all the combinations and printing all the subsets
public class GenerateAllTheSubSequencsOfAString {
    static int count = 0;

    static void solve(String input, String output, int start, int end) {

        if (start > end) {
            System.out.println(output);
            count++;
            return;
        }

        solve(input, output + input.charAt(start), start + 1, end);
        solve(input, output, start + 1, end);
    }

    public static void main(String[] args) {
        String str = "ABCD";
        solve(str, "", 0, str.length() - 1);
        System.err.println("Count is: "+ count);
    }
}
