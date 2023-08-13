import java.util.*;

public class MaxPerfectSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string of digits and underscores: ");
        String input = scanner.nextLine();
        scanner.close();

        List<String> permutations = generatePermutations(input);
        long maxPerfectSquare = findMaxPerfectSquare(permutations);

        if (maxPerfectSquare == -1) {
            System.out.println("No perfect square can be formed.");
        } else {
            System.out.println("Maximum perfect square: " + maxPerfectSquare);
        }
    }

    static List<String> generatePermutations(String input) {
        List<String> permutations = new ArrayList<>();
        generatePermutationsHelper(input.toCharArray(), 0, permutations);
        return permutations;
    }

    static void generatePermutationsHelper(char[] arr, int index, List<String> permutations) {
        if (index == arr.length) {
            permutations.add(new String(arr));
            return;
        }

        if (arr[index] == '_') {
            for (char digit = '0'; digit <= '9'; digit++) {
                arr[index] = digit;
                generatePermutationsHelper(arr, index + 1, permutations);
            }
            arr[index] = '_'; // Reset the underscore for backtracking
        } else {
            generatePermutationsHelper(arr, index + 1, permutations);
        }
    }

    static long findMaxPerfectSquare(List<String> permutations) {
        long maxPerfectSquare = -1;
        for (String perm : permutations) {
            long num = Long.parseLong(perm);
            long sqrt = (long) Math.sqrt(num);
            if (sqrt * sqrt == num && num > maxPerfectSquare) {
                maxPerfectSquare = num;
            }
        }
        return maxPerfectSquare;
    }
}
