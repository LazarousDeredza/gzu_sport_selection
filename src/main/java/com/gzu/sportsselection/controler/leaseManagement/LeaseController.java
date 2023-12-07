
package com.gzu.sportsselection.controler.leaseManagement;

import com.gzu.sportsselection.controler.sportManagement.GroundController2;
import com.gzu.sportsselection.model.leaseManagement.Lease;
import com.gzu.sportsselection.model.leaseManagement.LeaseHistory;
import com.gzu.sportsselection.security.models.User;
import com.gzu.sportsselection.security.repositories.UserRepository;
import com.gzu.sportsselection.service.document_management.StudentDocumentsService;
import com.gzu.sportsselection.service.leaseManagement.LeaseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(
        path = {"api/v1/lease"}
)
public class LeaseController {
    private final LeaseService leaseService;
    private GroundController2 compartmentController;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    ObjectMapper objectmapper = new ObjectMapper();
    private StudentDocumentsService leaseDocumentService;

    @Autowired
    public LeaseController(LeaseService leaseService,  GroundController2 compartmentController) {
        this.leaseService = leaseService;

        this.compartmentController = compartmentController;
    }

    @GetMapping(
            path = {"notice/{time}"}
    )
    public List<Lease> getAboutToExpire(@PathVariable int time) {
        return this.leaseService.getAboutToExpire(time);
    }

    @GetMapping(
            path = {"search/{record}"}
    )
    public List<Lease> getLeaseBySearch(@PathVariable String record) {
        return this.leaseService.getLeaseBySearch(record);
    }

    @GetMapping(
            path = {"getleases"}
    )
    public List<Lease> getLeases() {
        return this.leaseService.getLeases();
    }

    @GetMapping(
            path = {"getleasesHistory"}
    )
    public List<LeaseHistory> getLeaseHistory() {
        return this.leaseService.getLeaseHistory();
    }

    @GetMapping(
            path = {"getform/{ID}"}
    )
    public String getFormName(@PathVariable String ID) {
        return this.leaseService.getFormName(ID);
    }

    @GetMapping(
            path = {"home"}
    )
    public String home() {
        return System.getProperty("user.home");
    }

    public List<Lease> getLeaseByT_ID(@PathVariable String ID) {
        return this.leaseService.getLeaseByT_ID(ID);
    }

    @GetMapping({"/load/{fileName}"})
    public ResponseEntity<Object> LoadFile(@PathVariable String fileName, HttpServletRequest request) {
        Resource resource = this.leaseService.downloadFile(fileName);
        return ResponseEntity.ok().body(new ResponseMessage(resource.toString()));
    }

    @GetMapping({"/download/{fileName}"})
    ResponseEntity<Resource> downLoadSingleFile(@PathVariable String fileName, HttpServletRequest request) {
        Resource resource = this.leaseService.downloadFile(fileName);
        MediaType contentType = MediaType.APPLICATION_PDF;

        String mimeType;
        try {
            mimeType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException var7) {
            mimeType = "application/octet-stream";
        }

        mimeType = mimeType == null ? "application/octet-stream" : mimeType;
        return ((ResponseEntity.BodyBuilder)ResponseEntity.ok().contentType(MediaType.parseMediaType(mimeType)).header("Content-Disposition", new String[]{"attachment;fileName=" + resource.getFilename()})).body(resource);
    }

    @RequestMapping(
            path = {"addlease"},
            method = {RequestMethod.POST},
            consumes = {"multipart/form-data"}
    )
    public ResponseEntity<Object> registerNewLease(@RequestParam(required = true,value = "jsondata") String jsondata, LeaseHistory leaseHistory, @RequestParam(required = true,value = "file") MultipartFile file) throws IOException {
        Lease lease = (Lease)this.objectmapper.readValue(jsondata, Lease.class);
        this.leaseService.addNewLease(lease, leaseHistory);
        String ID = lease.getId().toString();
        String message = "";

        try {
            this.leaseDocumentService.store(file, ID);
            message = "Record Saved with Agreement file successfully : " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception var8) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping(
            path = {"getLease/{leaseId}"}
    )
    public Lease getLease(@PathVariable Long leaseId) {
        Lease lease = this.leaseService.findLeaseById(leaseId);
        lease.setTenant(this.compartmentController.getStudentForSpecificLease(lease.getStudent_id()));
        return lease;
    }

    @GetMapping(
            path = {"getEmail/{name}/"}
    )
    public String getEmail(@PathVariable String name) {
        return this.leaseService.findTenantEmail(name);
    }

    @PutMapping(
            path = {"updatelease/{leaseId}"}
    )
    public void updateLease(@PathVariable Long leaseId, @RequestBody Lease lease, LeaseHistory leaseHistory, String Status) {
        Status = "Updated";
        this.leaseService.updateLease(leaseId, lease);
        this.leaseService.SaveToHistory(leaseId, leaseHistory, Status);
    }

    @PutMapping(
            path = {"terminatelease/{leaseId}"}
    )
    public void terminatelease(@PathVariable Long leaseId, @RequestBody Lease lease, LeaseHistory leaseHistory, String Status) {
        Status = "Terminated";
        this.leaseService.terminatelease(leaseId, lease);
        this.leaseService.SaveToHistory(leaseId, leaseHistory, Status);
    }

    @GetMapping(
            path = {"renewed"}
    )
    public List<LeaseHistory> getExpired(LeaseHistory leaseHistory) {
        return this.leaseService.getRenewed();
    }

    @PutMapping(
            path = {"renewlease/{leaseId}"}
    )
    public void renewlease(@PathVariable Long leaseId, @RequestBody Lease renewal, LeaseHistory leaseHistory, String status) {
        status = "Renewed";
        this.leaseService.renewlease(leaseId, renewal);
        this.leaseService.SaveToHistory(leaseId, leaseHistory, status);
    }

    @GetMapping({"/getUser/{user}"})
    public User getUser(@PathVariable String user) {
        User systemUser = this.userRepository.findByUsername(user);
        return systemUser;
    }

    @PostMapping({"/comparePass/{username}"})
    public void ComparePass(@PathVariable String username, @RequestBody User user) {
        User systemUser = this.userRepository.findByUsername(username);
        if (systemUser == null) {
            throw new IllegalStateException("Username not found");
        } else if (this.passwordEncoder.matches(user.getPassword(), systemUser.getPassword())) {
            System.out.println("Password matches");
            systemUser.setPassword(this.passwordEncoder.encode(user.getNewPass()));
            this.userRepository.save(systemUser);
            System.out.println("Password Changed");
        } else {
            throw new IllegalStateException("Password mismatch");
        }
    }
}
