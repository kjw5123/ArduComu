package JW.ArduComu.repository;

import JW.ArduComu.domain.ArduinoData;

import java.util.Map;

public interface ArduinoDataRepository {
    //저장
    void save(ArduinoData arduinoData);
    ArduinoData recentData();

    Map<String, Double> getTempHistory();
    Map<String, Double> getHumiHistory();
    Map<String, Double> getDustHistory();
    Map<String, ArduinoData> getAllHistory();

    void clearStored();
}
