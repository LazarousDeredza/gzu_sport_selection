//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.controler;

import com.gzu.sportsselection.controler.sportManagement.AddressController;
import com.gzu.sportsselection.controler.sportManagement.ContactDetailsController;
import com.gzu.sportsselection.controler.sportManagement.GroundController;
import com.gzu.sportsselection.controler.sportManagement.OwnerController;
import com.gzu.sportsselection.model.sportManagement.History;
import com.gzu.sportsselection.model.sportManagement.Sport;
import com.gzu.sportsselection.service.sportManagement.HistoryService;
import com.gzu.sportsselection.service.sportManagement.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(
        path = {"/api/history"}
)
public class historyController {
    private final HistoryService historyService;
    private final AddressController addressController;
    private final OwnerController ownerController;
    private final ContactDetailsController contactDetailsController;
    private final GroundController groundController;

    @Autowired
    public historyController( HistoryService historyService, AddressController addressController, OwnerController ownerController, ContactDetailsController contactDetailsController, GroundController groundController) {
        this.historyService = historyService;

        this.addressController = addressController;
        this.ownerController = ownerController;
        this.contactDetailsController = contactDetailsController;
        this.groundController = groundController;
    }

    @PostMapping({"/save-history"})
    public History saveProperty(@RequestBody History history) {
       this.historyService.saveHistory(history);
        return history;
    }

    @GetMapping({"/get-all-histories"})
    public List<History> getHistories() {
        List<History> histories = this.historyService.getHistories();
        return histories;
    }


    @GetMapping({"/get-all-histories/{sportName}"})
    public List<History> getHistoriesBySport(@PathVariable String sportName) {

        List<History> histories1=new ArrayList<>();

        List<History> histories = this.historyService.getHistories();
        for (History s:histories){
            if (s.getSportName().equals(sportName)){
                histories1.add(s);
            }
        }

        return histories1;
    }


}
