package JW.ArduComu.repository;

import JW.ArduComu.domain.ArduinoData;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class MemoryArduinoDataRepository implements ArduinoDataRepository{

    private static final Map<Long, ArduinoData> stored = new HashMap<>();
    private static long Num = 0L;
    private static ArduinoData newStored = new ArduinoData();

    private static final List<List<Object>> allHistoryList = new ArrayList<>();
    private  static final Map<String, Double> tempHistoryMap = new HashMap<>();
    private  static final Map<String, Double> humiHistoryMap = new HashMap<>();
    private  static final Map<String, Double> dustHistoryMap = new HashMap<>();
    @Override
    public void save(ArduinoData arduinoData) {

        stored.put(++Num, arduinoData);
        newStored = arduinoData;
//        return arduinoData;
    }
    @Override
    public ArduinoData recentData(){
        return newStored;
    }
    @Override
    public Map<String, Double> getTempHistory() {
        if(Num >= 1L){
        for (long i = 1L; i <= Num; i++){
                tempHistoryMap.put(stored.get(i).getTime(), stored.get(i).getTemp());
            }
        }
        return tempHistoryMap;
    }
    @Override
    public Map<String, Double> getHumiHistory() {
        if (Num >= 1L) {
            for (long i = 1L; i <= Num; i++) {
                humiHistoryMap.put(stored.get(i).getTime(), stored.get(i).getHumi());
            }
        }
        return humiHistoryMap;
    }
    @Override
    public Map<String, Double> getDustHistory() {
        if (Num >= 1L) {
            for (long i = 1L; i <= Num; i++) {
                dustHistoryMap.put(stored.get(i).getTime(), stored.get(i).getDust());
            }
        }
        return dustHistoryMap;
    }
    @Override
    public List<List<Object>> getAllHistory() {
        if (Num >= 1L) {
            for (long i = 1L; i <= Num; i++) {
                List<Object> innerList = new ArrayList<>();
                innerList.add(stored.get(i).getTime());
                innerList.add(stored.get(i).getTemp());
                innerList.add(stored.get(i).getHumi());
                innerList.add(stored.get(i).getDust());
                allHistoryList.add(innerList);
            }
        }
        return allHistoryList;
    }
    public void clearStored() {
        stored.clear();
        Num = 0L;
    }
    //todo: 아래는 이전 파일들.
//    @Override
//    public Optional<Map<String, Double>> getTempHistory() {
//        Map<String, Double> tempHistoryMap = new HashMap<>();
//        if(Num != 1L){
//            for (long i = 1L; i <= Num; i++){
//                tempHistoryMap.put(stored.get(i).getTime(), stored.get(i).getTemp());
//            }
//        }
//        return Optional.of(tempHistoryMap);
//    }
//    @Override
//    public Optional<Map<String, Double>> getHumiHistory() {
//        Map<String, Double> humiHistoryMap = new HashMap<>();
//        if (Num != 1L) {
//            for (long i = 1L; i <= Num; i++) {
//                humiHistoryMap.put(stored.get(i).getTime(), stored.get(i).getHumi());
//            }
//        }
//        return Optional.of(humiHistoryMap);
//    }
//    @Override
//    public Optional<Map<String, Double>> getDustHistory() {
//        Map<String, Double> dustHistoryMap = new HashMap<>();
//        if (Num != 1L) {
//            for (long i = 1L; i <= Num; i++) {
//                dustHistoryMap.put(stored.get(i).getTime(), stored.get(i).getDust());
//            }
//        }
//        return Optional.of(dustHistoryMap);
//    }

}
