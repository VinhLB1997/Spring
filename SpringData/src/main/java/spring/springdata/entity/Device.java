package spring.springdata.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "device")
public class Device {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "device_token", nullable = false, length = 256)
    private String deviceToken;

    @Column(name = "device_type", nullable = false)
    private Integer deviceType;

    @Column(name = "user_agent", length = 512)
    private String userAgent;

    @Column(name = "device_name", length = 100)
    private String deviceName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "last_time_access", nullable = false)
    private Instant lastTimeAccess;

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

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
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

    public Instant getLastTimeAccess() {
        return lastTimeAccess;
    }

    public void setLastTimeAccess(Instant lastTimeAccess) {
        this.lastTimeAccess = lastTimeAccess;
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