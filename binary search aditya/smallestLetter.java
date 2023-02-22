public class smallestLetter {
    public static char nextGreatestLetter(char[] letters, char target) {
        int s = 0;
        char ans = '#';
        int e = letters.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (letters[mid] == target)
                s = mid + 1;

            else if (target > letters[mid]) {
                s = mid + 1;
            } else {
                ans = letters[mid];
                e = mid - 1;
            }
        }
        if (ans == '#')
            return letters[0];
        return ans;
    }

    public static void main(String[] args) {
        char[] letters = { 'c', 'f', 'j' };
        System.out.println(nextGreatestLetter(letters, 'a'));
    }
}
