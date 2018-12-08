package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exercise {
    private int value1 ;
    private String operator;
    private int value2;
    private int answer;

    public Exercise() {
       random_value_1_and_2();
       random_value_arraylist_java();
    }

    public void random_value_arraylist_java() {
        List<String> randomList = new ArrayList<String>();
        randomList.add("+");
        randomList.add("-");
        randomList.add("*");
        randomList.add("/");
        Random random = new Random();
        this.operator = randomList.get(random.nextInt(randomList.size()));

    }

    public void random_value_1_and_2(){
        Random r = new Random();
        int randomInt = r.nextInt(100) + 1;
        this.value1 = randomInt;
        int randomInt2 = r.nextInt(100) + 1;
        this.value2 = randomInt2;
    }

    public int getValue1() {
        return value1;
    }

    public String getOperator() {
        return operator;
    }

    public int getValue2() {
        return value2;
    }

    public boolean calculate(double d){
        if (operator.equals("+")){
            answer = value1+value2;

        }
        if (operator.equals("-")){
            answer = value1-value2;

        }
        if (operator.equals("*")){
            answer = value1*value2;

        }
        if (operator.equals("/")){
            answer = value1/value2;

        }
        if (d==answer){
            return true;
        }
        return false;
    }

}
