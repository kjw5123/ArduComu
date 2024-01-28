package JW.ArduComu.domain;

public class ArduinoData {

    private Double temp;
    private Double humi;
    private Double dust;
    private String time;

    public ArduinoData(){

    }
    public ArduinoData(String time, Double temp, Double humi, Double dust) {
        this.time = time;
        this.temp = temp;
        this.humi = humi;
        this.dust = dust;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public Double getTemp() {
        return temp;
    }
    public void setTemp(Double temp) {
        this.temp = temp;
    }
    public Double getHumi() {
        return humi;
    }

    public void setHumi(Double humi) {
        this.humi = humi;
    }

    public Double getDust() {
        return dust;
    }

    public void setDust(Double dust) {
        this.dust = dust;
    }

//    @Override
//    public String toString() {
//        return "ArduinoData{" +
//                "time=\"" + time + '\"' +
//                ", temp=" + temp +
//                ", humi=" + humi +
//                ", dust=" + dust +
//                '}';
//    }
}
