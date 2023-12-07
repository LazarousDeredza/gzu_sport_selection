//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.service.sportManagement;

import com.gzu.sportsselection.model.sportManagement.History;
import com.gzu.sportsselection.model.sportManagement.Sport;
import com.gzu.sportsselection.repository.sportManagement.SportRepository;
import com.gzu.sportsselection.repository.studentManagement.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class HistoryService {
    private final HistoryRepository historyRepository;

    @Autowired
    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public void saveHistory(History history) {
        this.historyRepository.save(history);
    }

    public List<History> getHistories() {
        return this.historyRepository.findAll();
    }



   }
