package JW.ArduComu.service;

import JW.ArduComu.domain.ArduinoData;
import JW.ArduComu.repository.ArduinoDataRepository;

import java.util.List;
import java.util.Optional;

public class ArduinoDataService {
    private final ArduinoDataRepository arduinoDataRepository;
    public ArduinoDataService(ArduinoDataRepository arduinoDataRepository){
        this.arduinoDataRepository = arduinoDataRepository;
    }
    public String saveData(ArduinoData arduinoData){
        arduinoDataRepository.save(arduinoData);
        return arduinoData.getTime();
    } // 추후 수정 필요할 듯

    public List<ArduinoData> allArduinoDataHistories(){
        return arduinoDataRepository.findAll();
    }

    public Optional<ArduinoData> tempHistory(){
//        return arduinoDataRepository.tempHistory(Double temp);
    }
    public Optional<ArduinoData> humiHistory(){

    }
    public Optional<ArduinoData> dustHistory(){

    }
}