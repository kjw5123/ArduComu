package JW.ArduComu.repository;

import JW.ArduComu.domain.ArduinoData;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class MemoryArduinoDataRepository implements ArduinoDataRepository{

    private static final Map<String, ArduinoData> stored = new HashMap<>();
    @Override
    public ArduinoData save(ArduinoData arduinoData) {
//        LocalDateTime currentTime = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("Asia/Seoul"));
//        String time = String.valueOf(currentTime.getHour())+":"+ String.valueOf(currentTime.getMinute())+":"+ String.valueOf(currentTime.getSecond());
//        // 12:00:00 형태의 String으로 출력됨
//        arduinoData.setTime(time);
        stored.put(arduinoData.getTime(), arduinoData);
        return arduinoData;
    }

    @Override
    public Optional<ArduinoData> tempHistory(Double temp) {
        return Optional.ofNullable(stored.get(temp));
    }
    @Override
    public Optional<ArduinoData> humiHistory(Double humi) {
        return Optional.ofNullable(stored.get(humi));
    }
    @Override
    public Optional<ArduinoData> dustHistory(Double dust) {
        return Optional.ofNullable(stored.get(dust));
    }
    @Override
    public Optional<ArduinoData> timeHistory(String time) {
        return Optional.ofNullable(stored.get(time));
    }
    @Override
    public List<ArduinoData> allHistory() {
        return new ArrayList<>(stored.values());
    }
    public void clearStored() {
        stored.clear();
    }
}
