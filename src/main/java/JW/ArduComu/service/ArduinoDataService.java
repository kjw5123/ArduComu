package JW.ArduComu.service;

import JW.ArduComu.domain.ArduinoData;
import JW.ArduComu.repository.ArduinoDataRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ArduinoDataService {
    private final ArduinoDataRepository arduinoDataRepository;

    public ArduinoDataService(ArduinoDataRepository arduinoDataRepository){
        this.arduinoDataRepository = arduinoDataRepository;
    }

    public void insertData(ArduinoData arduinoData){ //String -> void로 변경함
        arduinoDataRepository.save(arduinoData);
    }

    public ArduinoData getRecentData(){
        return arduinoDataRepository.recentData();
    }
    public Map<Long, ArduinoData> getStoredData(){return arduinoDataRepository.getHistory();}

}