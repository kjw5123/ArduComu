package JW.ArduComu.repository;

import JW.ArduComu.domain.ArduinoData;

import java.util.List;
import java.util.Optional;

public interface ArduinoDataRepository {
    ArduinoData save(ArduinoData arduinoData);
    Optional<ArduinoData> timeHistory(String time);
    Optional<ArduinoData> tempHistory(Double temp);
    Optional<ArduinoData> humiHistory(Double humi);
    Optional<ArduinoData> dustHistory(Double dust);
    List<ArduinoData> allHistory();
}
