package spring.springdata.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "baggage_tag_custody_cert_shelf")
public class BaggageTagCustodyCertShelf {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "custody_cert_id", nullable = false)
    private CustodyCert custodyCert;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "baggage_tag_id", nullable = false)
    private BaggageTag baggageTag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shelf_id")
    private Shelf shelf;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "leave_date", nullable = false)
    private Instant leaveDate;

    @Column(name = "return_date")
    private Instant returnDate;

    @Column(name = "staff_name", nullable = false, length = 100)
    private String staffName;

    @Column(name = "update_date", nullable = false)
    private Instant updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustodyCert getCustodyCert() {
        return custodyCert;
    }

    public void setCustodyCert(CustodyCert custodyCert) {
        this.custodyCert = custodyCert;
    }

    public BaggageTag getBaggageTag() {
        return baggageTag;
    }

    public void setBaggageTag(BaggageTag baggageTag) {
        this.baggageTag = baggageTag;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Instant getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Instant leaveDate) {
        this.leaveDate = leaveDate;
    }

    public Instant getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Instant returnDate) {
        this.returnDate = returnDate;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Instant getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
    }

}