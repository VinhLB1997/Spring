package spring.springdata.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "custody_cert")
public class CustodyCert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "guest_name", nullable = false, length = 100)
    private String guestName;

    @Column(name = "guest_tel_no", length = 12)
    private String guestTelNo;

    @Column(name = "delivery_slip_no", length = 100)
    private String deliverySlipNo;

    @Column(name = "guest_baggage_number", nullable = false)
    private Integer guestBaggageNumber;

    @Lob
    @Column(name = "note")
    private String note;

    @Column(name = "type", nullable = false)
    private Integer type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    @Column(name = "room_number", length = 40)
    private String roomNumber;

    @Column(name = "check_in_date")
    private LocalDate checkInDate;

    @Column(name = "reservation_no", length = 100)
    private String reservationNo;

    @Column(name = "qrcode_id", nullable = false, length = 100)
    private String qrcodeId;

    @Column(name = "create_user_id")
    private Integer createUserId;

    @Column(name = "create_date", nullable = false)
    private Instant createDate;

    @Column(name = "update_user_id")
    private Integer updateUserId;

    @Column(name = "update_date", nullable = false)
    private Instant updateDate;

    @Column(name = "delete_flag", nullable = false)
    private Boolean deleteFlag = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestTelNo() {
        return guestTelNo;
    }

    public void setGuestTelNo(String guestTelNo) {
        this.guestTelNo = guestTelNo;
    }

    public String getDeliverySlipNo() {
        return deliverySlipNo;
    }

    public void setDeliverySlipNo(String deliverySlipNo) {
        this.deliverySlipNo = deliverySlipNo;
    }

    public Integer getGuestBaggageNumber() {
        return guestBaggageNumber;
    }

    public void setGuestBaggageNumber(Integer guestBaggageNumber) {
        this.guestBaggageNumber = guestBaggageNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getReservationNo() {
        return reservationNo;
    }

    public void setReservationNo(String reservationNo) {
        this.reservationNo = reservationNo;
    }

    public String getQrcodeId() {
        return qrcodeId;
    }

    public void setQrcodeId(String qrcodeId) {
        this.qrcodeId = qrcodeId;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Instant getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}