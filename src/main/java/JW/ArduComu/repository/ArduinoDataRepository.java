package JW.ArduComu.repository;

import JW.ArduComu.domain.ArduinoData;

import java.util.Map;

public interface ArduinoDataRepository {
    void save(ArduinoData arduinoData);
    ArduinoData recentData();
    Map<Long, ArduinoData> getHistory();
}
