package spring.springdata.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "baggage_tag")
public class BaggageTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "baggage_tag_name", nullable = false, length = 100)
    private String baggageTagName;

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

    public String getBaggageTagName() {
        return baggageTagName;
    }

    public void setBaggageTagName(String baggageTagName) {
        this.baggageTagName = baggageTagName;
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