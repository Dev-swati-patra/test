package com.example.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;

	public Student() {
		super();
	}

	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

}

//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//private Integer    tenderId;
//private String     tenderName;
//private String     tenderRefNo;
//private String     issuedBy;
//private String     contactPersonName1;
//private Long       contactPersonPhoneNo1;
//private String     contactPersonEmail1;
//private String     contactPersonName2;
//private Long       contactPersonPhoneNo2;
//private String     contactPersonEmail2;
//@Temporal(TemporalType.DATE)
//private Date       tenderIssueDate;
//@Temporal(TemporalType.TIMESTAMP)
//private Date       lastQueriesSubmissionDateTimeOrig;
//@Temporal(TemporalType.TIMESTAMP)
//private Date       lastQueriesSubmissionDateTimeRev;
//@Temporal(TemporalType.TIMESTAMP)
//private Date       preBidMeetingOrig;
//@Temporal(TemporalType.TIMESTAMP)
//private Date       preBidMeetingRev;
//@Temporal(TemporalType.TIMESTAMP)
//private Date       tenderSubmissionDateTimeOrig;
//@Temporal(TemporalType.TIMESTAMP)
//private Date       tenderSubmissionDateTimeRev;
//@Temporal(TemporalType.TIMESTAMP)
//private Date       techProposalOpeningDateTimeOrig;
//@Temporal(TemporalType.TIMESTAMP)
//private Date       techProposalOpeningDateTimeRev;
//@Temporal(TemporalType.TIMESTAMP)
//private Date       techPresentationDateAndTimeOrig;
//@Temporal(TemporalType.TIMESTAMP)
//private Date       techPresentationDateAndTimeRev;
//@Temporal(TemporalType.TIMESTAMP)
//private Date       financialProposalOpeningDateTimeOrig;
//@Temporal(TemporalType.TIMESTAMP)
//private Date       financialProposalOpeningDateTimeRev;
//private BigDecimal tenderFees;
//private BigDecimal tenderEarnestMoneyDeposit;
//private String     applicableEmpanelment;
//private Integer    tenderStatus;
//private String     createdBy;
//private String     updatedBy;
//private Timestamp  createdAt;
//private Timestamp  updatedAt;