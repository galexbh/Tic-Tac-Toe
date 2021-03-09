package helpers;

public class ControllerHelpers{
    protected static void validatedState(int[][] array, int value, int state){
        switch (value) {
            case 1 -> array[0][0] = state;
            case 2 -> array[0][1] = state;
            case 3 -> array[0][2] = state;
            case 4 -> array[1][0] = state;
            case 5 -> array[1][1] = state;
            case 6 -> array[1][2] = state;
            case 7 -> array[2][0] = state;
            case 8 -> array[2][1] = state;
            case 9 -> array[2][2] = state;
            default -> throw new IllegalStateException("Unexpected value: " + value);
        }
    }

    protected static int validatedStatusH(int[][] array) {
        int statusX = 0;
        int status0 = 0;

        for (int[] ints : array) {
            for (int j = 0; j < array.length; j++) {
                if (ints[j] == 1) {
                    status0++;
                } else if (ints[j] == 0) {
                    statusX++;
                }
                if (statusX == 3) {
                    return 1;
                }
                if (status0 == 3) {
                    return 2;
                }
            }
            statusX = 0;
            status0 = 0;
        }
        return 3;
    }

    protected static int validatedStatusV(int[][] array) {
        int statusX = 0;
        int status0 = 0;

        for (int i = 0; i < array.length; i++){
            for (int[] ints : array) {
                if (ints[i] == 1) {
                    status0++;
                } else if (ints[i] == 0) {
                    statusX++;
                }
                if (statusX == 3) {
                    return 1;
                }
                if (status0 == 3) {
                    return 2;
                }
            }
            statusX = 0;
            status0 = 0;
        }
        return 3;
    }
}
