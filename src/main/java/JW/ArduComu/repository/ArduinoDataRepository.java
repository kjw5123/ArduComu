package JW.ArduComu.repository;

import JW.ArduComu.domain.ArduinoData;

import java.util.List;
import java.util.Map;

public interface ArduinoDataRepository {
    //저장
    void save(ArduinoData arduinoData);
    ArduinoData recentData();

    Map<String, Double> getTempHistory();
    Map<String, Double> getHumiHistory();
    Map<String, Double> getDustHistory();
    List<List<Object>> getAllHistory();

    void clearStored();
}
