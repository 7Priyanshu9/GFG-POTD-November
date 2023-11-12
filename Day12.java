public class Day12 {
    public static boolean isRotated(String str1, String str2)
    {
    if (str1.length() != str2.length()) {
        return false;
    }

    // Rotate the string 'a' two places to the right
    String clockwiseRotation = rotateClockwise(str1, 2);

    // Rotate the string 'a' two places to the left
    String anticlockwiseRotation = rotateAnticlockwise(str1, 2);

    // Check if either of the rotations is equal to string 'b'
    return str2.equals(clockwiseRotation) || str2.equals(anticlockwiseRotation);
}

private static String rotateClockwise(String inputString, int n) {
    int len = inputString.length();
    n = n % len;

    return inputString.substring(len - n) + inputString.substring(0, len - n);
}

private static String rotateAnticlockwise(String inputString, int n) {
    int len = inputString.length();
    n = n % len;

    return inputString.substring(n) + inputString.substring(0, n);
}
}
