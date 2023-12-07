//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.service.leaseManagement;

import com.gzu.sportsselection.controler.sportManagement.GroundController2;
import com.gzu.sportsselection.model.leaseManagement.Lease;
import com.gzu.sportsselection.model.leaseManagement.LeaseHistory;
import com.gzu.sportsselection.model.sportManagement.Ground;
import com.gzu.sportsselection.repository.leaseManagement.LeaseHistoryRepository;
import com.gzu.sportsselection.repository.leaseManagement.LeaseRepository;
import com.gzu.sportsselection.repository.sportManagement.GroundRepository;
import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LeaseService {
    LeaseRepository leaseRepository;
    LeaseHistoryRepository leaseHistoryRepository;
    GroundController2 compartmentController;
    GroundRepository groundRepository;

    @Autowired
    public LeaseService(LeaseRepository leaseRepository, LeaseHistoryRepository leaseHistoryRepository, GroundController2 compartmentController, GroundRepository groundRepository) {
        this.leaseRepository = leaseRepository;
        this.leaseHistoryRepository = leaseHistoryRepository;
        this.compartmentController = compartmentController;
        this.groundRepository = groundRepository;
    }

    public List<Lease> getLeases() {
        List<Lease> list = this.leaseRepository.findAll();

        for(int i = 0; i < this.leaseRepository.findAll().size(); ++i) {
            Long leaseID = ((Lease)list.get(i)).getId();
            Lease lease = (Lease)this.leaseRepository.findById(leaseID).orElseThrow(() -> {
                return new IllegalStateException("Record With ID " + leaseID + " Does Not Exist");
            });
            lease.setTenant(this.compartmentController.getStudentForSpecificLease(lease.getStudent_id()));
            if (lease.getEndDate().isBefore(LocalDate.now()) && !Objects.equals(lease.getStatus(), "Terminated")) {
                lease.setStatus("Expired");
                lease.setTimeLeft(0);
            } else if (lease.getEndDate().isAfter(LocalDate.now()) && !Objects.equals(lease.getStatus(), "Terminated")) {
                lease.setStatus("Active");
                int Months = Period.between(LocalDate.now(), lease.getEndDate()).getMonths();
                if (Months < 0) {
                    Months *= -1;
                }

                int Days = Period.between(LocalDate.now(), lease.getEndDate()).getDays();
                if (Days < 0) {
                    Days *= -1;
                }

                int Years = Period.between(LocalDate.now(), lease.getEndDate()).getYears();
                if (Years < 0) {
                    Years *= -1;
                }

                int tleft = Math.addExact(Days, Math.addExact(Months * 30, Years * 12 * 30));
                lease.setTimeLeft(tleft);
            }
        }

        return this.leaseRepository.findAll();
    }

    public List<LeaseHistory> getLeaseHistory() {
        return this.leaseHistoryRepository.findAll();
    }

    public void addNewLease(Lease lease, LeaseHistory lease_history) {
        Optional<Lease> ID = this.leaseRepository.findTenantid(lease.getStudent_id());
        if (ID.isPresent()) {
            throw new IllegalStateException("That Tenant Already Exists");
        } else {
            if (lease.getTerms().isEmpty()) {
                lease.setTerms("Unspecified");
            }

            lease.setEndDate(lease.getStartDate().plusMonths((long)lease.getDuration()));
            if (lease.getStartDate().plusMonths((long)lease.getDuration()).isAfter(LocalDate.now())) {
                lease.setStatus("Active");
                int Months = Period.between(LocalDate.now(), lease.getEndDate()).getMonths();
                if (Months < 0) {
                    Months *= -1;
                }

                int Days = Period.between(LocalDate.now(), lease.getEndDate()).getDays();
                if (Days < 0) {
                    Days *= -1;
                }

                int Years = Period.between(LocalDate.now(), lease.getEndDate()).getYears();
                if (Years < 0) {
                    Years *= -1;
                }

                int tleft = Math.addExact(Days, Math.addExact(Months * 30, Years * 12 * 30));
                lease.setTimeLeft(tleft);
            } else {
                lease.setTimeLeft(0);
                lease.setStatus("Expired");
            }

            this.leaseRepository.save(lease);
            Integer id = lease.getId().intValue();
            lease_history.setLease_id(id);
            lease_history.setTenant_id(lease.getStudent_id());
            lease_history.setDuration(lease.getDuration());
            lease_history.setEndDate(lease.getEndDate());
            lease_history.setStartDate(lease.getStartDate());
            lease_history.setTerms(lease.getTerms());
            lease_history.setActionDate(LocalDateTime.now());
            lease_history.setAction("Added");
            this.leaseHistoryRepository.save(lease_history);
        }
    }

    @Transactional
    public void terminatelease(Long leaseId, Lease update) {
        Lease lease = (Lease)this.leaseRepository.findById(leaseId).orElseThrow(() -> {
            return new IllegalStateException("Record With ID " + leaseId + " Does Not Exist");
        });
        System.out.println(lease.getStatus());
        if (lease.getStatus().toString().equals("Terminated")) {
            throw new IllegalStateException("That Record Is already Terminated");
        } else if (update.getStatus().trim().isEmpty()) {
            throw new IllegalStateException("Action Is Required");
        } else {
            if (!Objects.equals(update.getStatus().toString().trim(), (Object)null) && update.getStatus().trim().length() > 0) {
                lease.setStatus("Terminated");
                lease.setTimeLeft(0);
                Long id = Long.parseLong(String.valueOf(lease.getStudent_id()));
                List<Ground> ground = this.groundRepository.findByTenant(id);

                for(int i = 0; i < ground.size(); ++i) {
                    ((Ground) ground.get(i)).setTenant((Long)null);
                    ((Ground) ground.get(i)).setStatus("0");
                }
            }

        }
    }

    @Transactional
    public void updateLease(Long leaseId, Lease update) {
        Lease lease = (Lease)this.leaseRepository.findById(leaseId).orElseThrow(() -> {
            return new IllegalStateException("Record With ID " + leaseId + " Does Not Exist");
        });
        if (Objects.equals(lease.getStatus().toString(), "Terminated")) {
            throw new IllegalStateException("Sorry You cant Edit a Terminated Lease");
        } else {
            if (update.getTerms() != null && update.getTerms().length() > 0 && !Objects.equals(lease.getTerms(), update.getTerms())) {
                lease.setTerms(update.getTerms());
            }

            int Months = Period.between(LocalDate.now(), lease.getEndDate()).getMonths();
            if (Months < 0) {
                Months *= -1;
            }

            int Days = Period.between(LocalDate.now(), lease.getEndDate()).getDays();
            if (Days < 0) {
                Days *= -1;
            }

            int Years = Period.between(LocalDate.now(), lease.getEndDate()).getYears();
            if (Years < 0) {
                Years *= -1;
            }

            int tleft = Math.addExact(Days, Math.addExact(Months * 30, Years * 12 * 30));
            lease.setTimeLeft(tleft);
        }
    }

    public void SaveToHistory(Long leaseId, LeaseHistory lease_history, String status) {
        Lease lease = (Lease)this.leaseRepository.findById(leaseId).orElseThrow(() -> {
            return new IllegalStateException("Record With ID " + leaseId + " Does Not Exist");
        });
        Integer id = leaseId.intValue();
        lease_history.setTenant_id(lease.getStudent_id());
        lease_history.setLease_id(id);
        lease_history.setDuration(lease.getDuration());
        lease_history.setEndDate(lease.getEndDate());
        lease_history.setStartDate(lease.getStartDate());
        lease_history.setTerms(lease.getTerms());
        lease_history.setActionDate(LocalDateTime.now());
        lease_history.setAction(status);
        this.leaseHistoryRepository.save(lease_history);
    }

    @Transactional
    public List<Lease> getAboutToExpire(int time) {
        List<Lease> list = this.leaseRepository.findAll();

        for(int i = 0; i < this.leaseRepository.findAll().size(); ++i) {
            Long leaseID = ((Lease)list.get(i)).getId();
            Lease lease = (Lease)this.leaseRepository.findById(leaseID).orElseThrow(() -> {
                return new IllegalStateException("Record With ID " + leaseID + " Does Not Exist");
            });
            lease.setTenant(this.compartmentController.getStudentForSpecificLease(lease.getStudent_id()));
            lease.setEndDate(lease.getStartDate().plusMonths((long)lease.getDuration()));
            int Months;
            int Days;
            int Years;
            int tleft;
            if (lease.getEndDate().isBefore(LocalDate.now()) && !Objects.equals(lease.getStatus(), "Terminated")) {
                lease.setStatus("Expired");
                lease.setTimeLeft(0);
            } else if (lease.getEndDate().isAfter(LocalDate.now()) && !Objects.equals(lease.getStatus(), "Terminated")) {
                lease.setStatus("Active");
                Months = Period.between(LocalDate.now(), lease.getEndDate()).getMonths();
                if (Months < 0) {
                    Months *= -1;
                }

                Days = Period.between(LocalDate.now(), lease.getEndDate()).getDays();
                if (Days < 0) {
                    Days *= -1;
                }

                Years = Period.between(LocalDate.now(), lease.getEndDate()).getYears();
                if (Years < 0) {
                    Years *= -1;
                }

                tleft = Math.addExact(Days, Math.addExact(Months * 30, Years * 12 * 30));
                lease.setTimeLeft(tleft);
            }

            if (Objects.equals(lease.getStatus(), "Expired")) {
                lease.setTimeLeft(0);
            }

            if (Objects.equals(lease.getStatus(), "Active")) {
                Months = Period.between(LocalDate.now(), lease.getEndDate()).getMonths();
                if (Months < 0) {
                    Months *= -1;
                }

                Days = Period.between(LocalDate.now(), lease.getEndDate()).getDays();
                if (Days < 0) {
                    Days *= -1;
                }

                Years = Period.between(LocalDate.now(), lease.getEndDate()).getYears();
                if (Years < 0) {
                    Years *= -1;
                }

                tleft = Math.addExact(Days, Math.addExact(Months * 30, Years * 12 * 30));
                lease.setTimeLeft(tleft);
            }
        }

        return this.leaseRepository.findbyExpirery(time);
    }

    @Transactional
    public List<LeaseHistory> getRenewed() {
        List<LeaseHistory> renewedLeases = this.leaseHistoryRepository.getRenewed();

        for(int i = 0; i < renewedLeases.size(); ++i) {
            ((LeaseHistory)renewedLeases.get(i)).setTenant(this.compartmentController.getStudentForSpecificLease(((LeaseHistory)renewedLeases.get(i)).getStudent_id()));
        }

        return renewedLeases;
    }

    @Transactional
    public List<Lease> getExpiredLeases(String status) {
        List<Lease> list = this.leaseRepository.findAll();

        for(int i = 0; i < this.leaseRepository.findAll().size(); ++i) {
            Long leaseID = ((Lease)list.get(i)).getId();
            Lease lease = (Lease)this.leaseRepository.findById(leaseID).orElseThrow(() -> {
                return new IllegalStateException("Record With ID " + leaseID + " Does Not Exist");
            });
            lease.setEndDate(lease.getStartDate().plusMonths((long)lease.getDuration()));
            if (lease.getEndDate().isBefore(LocalDate.now()) && !Objects.equals(lease.getStatus(), "Expired") && !Objects.equals(lease.getStatus(), "Terminated")) {
                lease.setStatus("Expired");
                lease.setTimeLeft(0);
            } else if (lease.getEndDate().isAfter(LocalDate.now()) && !Objects.equals(lease.getStatus(), "Active") && !Objects.equals(lease.getStatus(), "Terminated")) {
                lease.setStatus("Active");
                int Months = Period.between(LocalDate.now(), lease.getEndDate()).getMonths();
                if (Months < 0) {
                    Months *= -1;
                }

                int Days = Period.between(LocalDate.now(), lease.getEndDate()).getDays();
                if (Days < 0) {
                    Days *= -1;
                }

                int Years = Period.between(LocalDate.now(), lease.getEndDate()).getYears();
                if (Years < 0) {
                    Years *= -1;
                }

                int tleft = Math.addExact(Days, Math.addExact(Months * 30, Years * 12 * 30));
                lease.setTimeLeft(tleft);
            }
        }

        return this.leaseRepository.findLeaseByStatus(status);
    }

    @Transactional
    public void renewlease(Long leaseId, Lease renewal) {
        Lease lease = (Lease)this.leaseRepository.findById(leaseId).orElseThrow(() -> {
            return new IllegalStateException("Record With ID " + leaseId + " Does Not Exist");
        });
        String s = String.valueOf(renewal.getDuration());
        if (s.isEmpty()) {
            throw new IllegalStateException("New duration is Required");
        } else if (renewal.getDuration() <= 0) {
            throw new IllegalStateException("Please Enter new Valid duration");
        } else if (renewal.getStartDate() != null && renewal.getStartDate().isBefore(LocalDate.now())) {
            throw new IllegalStateException("Entered Start Date is already Due,  please enter a new valid one");
        } else {
            int Months;
            int Days;
            int Years;
            int tleft;
            if (renewal.getStartDate() == null && !s.isEmpty()) {
                lease.setStartDate(LocalDate.now());
                lease.setDuration(renewal.getDuration());
                lease.setEndDate(LocalDate.now().plusMonths((long)renewal.getDuration()));
                Months = Period.between(LocalDate.now(), lease.getEndDate()).getMonths();
                if (Months < 0) {
                    Months *= -1;
                }

                Days = Period.between(LocalDate.now(), lease.getEndDate()).getDays();
                if (Days < 0) {
                    Days *= -1;
                }

                Years = Period.between(LocalDate.now(), lease.getEndDate()).getYears();
                if (Years < 0) {
                    Years *= -1;
                }

                tleft = Math.addExact(Days, Math.addExact(Months * 30, Years * 12 * 30));
                lease.setTimeLeft(tleft);
                lease.setStatus("Renewed");
            }

            if (renewal.getStartDate() != null && !s.isEmpty()) {
                lease.setStartDate(renewal.getStartDate());
                lease.setDuration(renewal.getDuration());
                lease.setEndDate(renewal.getStartDate().plusMonths((long)renewal.getDuration()));
                Months = Period.between(LocalDate.now(), lease.getEndDate()).getMonths();
                if (Months < 0) {
                    Months *= -1;
                }

                Days = Period.between(LocalDate.now(), lease.getEndDate()).getDays();
                if (Days < 0) {
                    Days *= -1;
                }

                Years = Period.between(LocalDate.now(), lease.getEndDate()).getYears();
                if (Years < 0) {
                    Years *= -1;
                }

                tleft = Math.addExact(Days, Math.addExact(Months * 30, Years * 12 * 30));
                lease.setTimeLeft(tleft);
                lease.setStatus("Renewed");
            }

        }
    }

    public Lease findLeaseById(Long leaseId) {
        return (Lease)this.leaseRepository.findById(leaseId).orElseThrow(() -> {
            return new IllegalStateException("Record With ID " + leaseId + " Does Not Exist");
        });
    }

    public String findTenantEmail(String name) {
        return this.leaseRepository.findByEmail(name);
    }

    public String getFormName(String ID) {
        return this.leaseRepository.findTenantForm(ID);
    }

    public Resource downloadFile(String fileName) {
        String DocumentPath = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "Leases";
        Path path = Paths.get(DocumentPath).toAbsolutePath().resolve(fileName);

        UrlResource resource;
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException var6) {
            throw new RuntimeException("Issue in reading the file", var6);
        }

        if (resource.exists() && resource.isReadable()) {
            return resource;
        } else {
            throw new RuntimeException("the file doesn't exist or not readable");
        }
    }

    public List<Lease> getLeaseBySearch(String record) {
        List<Lease> list = this.leaseRepository.findAll();

        for(int i = 0; i < this.leaseRepository.findAll().size(); ++i) {
            Long leaseID = ((Lease)list.get(i)).getId();
            Lease lease = (Lease)this.leaseRepository.findById(leaseID).orElseThrow(() -> {
                return new IllegalStateException("Record With ID " + leaseID + " Does Not Exist");
            });
            lease.setEndDate(lease.getStartDate().plusMonths((long)lease.getDuration()));
            if (lease.getEndDate().isBefore(LocalDate.now()) && !Objects.equals(lease.getStatus(), "Expired") && !Objects.equals(lease.getStatus(), "Terminated")) {
                lease.setStatus("Expired");
                lease.setTimeLeft(0);
            } else if (lease.getEndDate().isAfter(LocalDate.now()) && !Objects.equals(lease.getStatus(), "Active") && !Objects.equals(lease.getStatus(), "Terminated")) {
                lease.setStatus("Active");
                int Months = Period.between(LocalDate.now(), lease.getEndDate()).getMonths();
                if (Months < 0) {
                    Months *= -1;
                }

                int Days = Period.between(LocalDate.now(), lease.getEndDate()).getDays();
                if (Days < 0) {
                    Days *= -1;
                }

                int Years = Period.between(LocalDate.now(), lease.getEndDate()).getYears();
                if (Years < 0) {
                    Years *= -1;
                }

                int tleft = Math.addExact(Days, Math.addExact(Months * 30, Years * 12 * 30));
                lease.setTimeLeft(tleft);
            }
        }

        return this.leaseRepository.findLeaseBySearch(record);
    }

    public List<Lease> getLeaseByT_ID(String id) {
        return this.leaseRepository.findTenant(id);
    }
}
