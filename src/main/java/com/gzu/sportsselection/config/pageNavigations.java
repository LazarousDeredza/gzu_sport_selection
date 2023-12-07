package com.gzu.sportsselection.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class pageNavigations
{

    @GetMapping({ "/addStudentDocuments" })
    public String addtenantDocuments() {
        return "add_studentdocuments";
    }

    @GetMapping({ "/leasedocuments" })
    public String leaseDocuments() {
        return "lease_documents";
    }

    @GetMapping({ "/noticedocuments" })
    public String noticeDocuments() {
        return "notice_documents";
    }


    @GetMapping({ "/studentDocuments" })
    public String tenantDocuments() {
        return "student_documents";
    }

    @GetMapping({ "/viewTenantDocuments" })
    public String viewTenantDocuments() {
        return "view_tenantDocuments";
    }

    @GetMapping({ "/viewFile" })
    public String viewFile() {
        return "viewFile";
    }

    @GetMapping({ "/otherForm" })
    public String OtherFile() {
        return "OtherForm";
    }





    @GetMapping({ "/addSport" })
    public String addProperty() {
        return "add_sport";
    }

    @GetMapping({ "/editSport" })
    public String editSport() {
        return "edit_sport";
    }

    @GetMapping({ "/sportList" })
    public String sportList() {
        return "sport-list";
    }

    @GetMapping({ "/viewSport" })
    public String viewSport() {
        return "view-sport";
    }


    @GetMapping({ "/view-sport-with-players" })
    public String viewSportWithPlayers() {
        return "view-sport-with-players";
    }


    @GetMapping({ "/viewGround" })
    public String viewGround() {
        return "view-ground";
    }

    @GetMapping({ "/addGround" })
    public String addGround() {
        return "add_ground";
    }




    @GetMapping({ "/studentList" })
    public String studentList() {
        return "student_list";
    }

    @GetMapping({ "/studentDetail" })
    public String studentDetails() {
        return "student_detail";
    }

    @GetMapping({ "/addStudent" })
    public String addStudent() {
        return "add_student";
    }

    @GetMapping({ "/assignSport" })
    public String AssignProperty() {
        return "assign_sport";
    }






    @GetMapping({ "/lecturesList" })
    public String lecturersList() {
        return "lecturer_list";
    }

    @GetMapping({ "/lecturerDetail" })
    public String lecturerDetails() {
        return "lecturer_detail";
    }

    @GetMapping({ "/addlecturer" })
    public String addLecturer() {
        return "add_lecturer";
    }

    @GetMapping({ "/assignSportToLecture" })
    public String AssignsportToLectur() {
        return "assign_sport_to_lecturer";
    }






    @GetMapping({ "/teamPlayers" })
    public String teamPlayers() {
        return "team_players";
    }




    @GetMapping({ "/addHistory" })
    public String addhistory() {
        return "add_history";
    }

    @GetMapping({ "/viewHistory" })
    public String viewhistory() {
        return "history";
    }


    @GetMapping({ "/historyDetail" })
    public String historyDetails() {
        return "historyDetail";
    }




    @GetMapping({ "/addTimeTable" })
    public String addTimeTable() {
        return "addTimeTable";
    }

    @GetMapping({ "/viewTimeTable" })
    public String viewTimeTable() {
        return "viewTimetable";
    }


    @GetMapping({ "/timeTableDetail" })
    public String timeTableDetail() {
        return "timeTableDetail";
    }




}