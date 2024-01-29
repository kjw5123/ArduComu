package JW.ArduComu.repository;

import JW.ArduComu.domain.ArduinoData;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class MemoryArduinoDataRepository implements ArduinoDataRepository {
    private static final Map<Long, ArduinoData> stored = new HashMap<>();
    private static long Num = 0L;
    private static ArduinoData newStored = new ArduinoData();

    @Override
    public void save(ArduinoData arduinoData) {
        stored.put(++Num, arduinoData);
        newStored = arduinoData;
    }

    @Override
    public ArduinoData recentData() {
        return newStored;
    }

    @Override
    public Map<Long, ArduinoData> getHistory(){
        return stored;
    }

}