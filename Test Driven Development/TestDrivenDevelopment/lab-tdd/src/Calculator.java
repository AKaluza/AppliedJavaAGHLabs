public class Calculator {
    public int sum(String numbers) {
        if (numbers.length() < 2) {
            if (numbers.isEmpty()) {
                return 0;
            } else {
                return convertToInt(numbers);
            }
        } else {
            String delimiter = ",";
            String[] numList = splitNumbers(numbers, delimiter);
            return add(numList);
        }
    }

    private String[] splitNumbers(String numbers, String divider) {
        return numbers.split(divider);
    }

    private int convertToInt(String num) {
        return Integer.parseInt(num);
    }

    private int add(String[] numbers) {
        int total = 0;

        for (String numberString : numbers) {
            int number = convertToInt(numberString);
            if (number >= 0) {
                total += number;
            }

            if (total > 100) {
                throw new IllegalArgumentException("Sum bigger than 100 is not allowed");
            }
        }
        return total;
    }
}
