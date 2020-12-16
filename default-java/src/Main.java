public class Main {

    public static String pluramWords(int countWords) {
        String newString = correctString(countWords, "гривня","гривні", "гривень");
        return newString;
    }

    public static String correctString(int countWords, String one, String few, String many) {
        var newWord = countWords + " ";
        int lastDegit = countWords % 10;
        int lastTwoDegits = countWords % 100;

        if (lastTwoDegits > 10 & lastTwoDegits < 20) {
            newWord += many;
        } else {
            if (lastDegit == 1) newWord += one;
            else if(lastDegit > 1 & lastDegit <= 4) newWord += few;
            else if(lastDegit > 4 & lastDegit <= 9 | lastDegit == 0) newWord += many;
        }

        return newWord;
    }

    public static int summ(int min, int max) {
        var result = 0;
        for(int i = min; i <= max; i++) {
            result += i;
        }
        return result;
    }

    public static int factorial(int range) {
        var result = 1;
        for (int i = 1; i <= range; i++) {
            result = result * i;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(pluramWords(233011));
        System.out.println("Result summ: " + summ(20, 22));
	    System.out.println("Result factorial: " + factorial(4));
    }

}
