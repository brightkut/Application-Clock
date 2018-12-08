package Model;

public class Clock {

    private int setH;
    private int setM;

    private String hourShow;
    private String minuteShow;

    public Clock() {

    }

    public int changeStringToHour(String h){
        int hourInt =0;
        try {
            hourInt = Integer.parseInt(h);

        }catch (NumberFormatException e){
            System.out.println(e);
        }
        return hourInt;
    }

    public int changeStringToMinute(String m){
        int minuteInt = 0;
        try {
            minuteInt = Integer.parseInt(m);

        }catch (NumberFormatException e){
            System.out.println(e);
        }
        return minuteInt;

    }

    public void setSetH(int setH) {
        if (setH<0||setH>23){
            throw new IllegalArgumentException("Hour is out of bound");
        }
        this.setH = setH;
        setHourShow(setH);

    }

    public void setSetM(int setM) {
        if (setM<0|| setM>59){
            throw new IllegalArgumentException("Minute is out of bound");
        }
        this.setM = setM;
        setMinuteShow(setM);
    }

    public void setHourShow(int setH) {
        if (setH<10){
            this.hourShow = "0"+Integer.toString(setH);
        }else {
            this.hourShow = Integer.toString(setH);
        }
    }

    public void setMinuteShow(int setM) {
        if (setM<10){
            this.minuteShow = "0"+Integer.toString(setM);
        }else {
            this.minuteShow = Integer.toString(setM);
        }
    }

    public String getHourShow() {
        return hourShow;
    }

    public String getMinuteShow() {
        return minuteShow;
    }

    public int getSetH() {
        return setH;
    }

    public int getSetM() {
        return setM;
    }
}
