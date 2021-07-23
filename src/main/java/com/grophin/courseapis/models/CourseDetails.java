package com.grophin.courseapis.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Course_Details")
@Data
public class CourseDetails {

    @Id
    @Column(name="CourseID")
    private String courseId;

    @Column(name="Type")
    String type;

    @Column(name="Description")
    String description;

    @Column(name="Title")
    String title;

    @Column(name = "CreateUser")
    String createUser;

    @Column(name = "Cost")
    int cost;

    @Column(name = "contents")
    String contents;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "CreateDate")
    Date createDate;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumns({
//            @JoinColumn(name = "TicketID", referencedColumnName = "IDTicket", insertable = false, updatable = false)
//    })
//    private TicketStatus ticketStatus;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumns({
//            @JoinColumn(name = "CreateUser", referencedColumnName = "UserName", insertable = false, updatable = false)
//    })
//    private UserDetails userDetails;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumns({
//            @JoinColumn(name = "TicketID", referencedColumnName = "TicketID", insertable = false, updatable = false)
//    })
//    private AssignedAgent assignedAgent;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumns({
//            @JoinColumn(name = "TicketID", referencedColumnName = "TicketId", insertable = false, updatable = false)
//    })
//    private TicketResponse ticketResponse;




}
