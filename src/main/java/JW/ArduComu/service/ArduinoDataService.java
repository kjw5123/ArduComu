package JW.ArduComu.service;

import JW.ArduComu.domain.ArduinoData;
import JW.ArduComu.repository.ArduinoDataRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ArduinoDataService {
    private final ArduinoDataRepository arduinoDataRepository;
    private final ArduinoDataRepository currentRepository;

    public ArduinoDataService(ArduinoDataRepository arduinoDataRepository){
        this.arduinoDataRepository = arduinoDataRepository;
        this.currentRepository = arduinoDataRepository; //잘못된 부분이니 꼭 다시 공부하기. 내가 이 코드를 안넣어버림
    }
    public void InsertData(ArduinoData arduinoData){ //String -> void로 변경함
        arduinoDataRepository.save(arduinoData);
            currentRepository.clearStored();
            currentRepository.save(arduinoData);
    }
    public ArduinoData outData(){
        return currentRepository.recentData();
    }
    public Map<String, ArduinoData> allArduinoDataHistories(){
        return arduinoDataRepository.getAllHistory();
    }

    public Map<String, Double> getTempHistory(){
        return arduinoDataRepository.getTempHistory();
    }
    public Map<String, Double> getHumiHistory(){
        return arduinoDataRepository.getHumiHistory();
    }
    public Map<String, Double> getDustHistory(){
        return arduinoDataRepository.getDustHistory();
    }
}